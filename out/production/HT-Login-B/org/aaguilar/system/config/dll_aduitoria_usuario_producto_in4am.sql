DROP DATABASE IF EXISTS auditoria_usuario_producto_in4am;
CREATE DATABASE auditoria_usuario_producto_in4am;
USE auditoria_usuario_producto_in4am;

CREATE TABLE User
(
    name      VARCHAR(50) NOT NULL CHECK ( LENGTH(name) <= 50 ),
    last_name VARCHAR(50) NOT NULL CHECK ( LENGTH(last_name) <= 50 ),
    email     VARCHAR(50) NOT NULL CHECK ( LENGTH(email) <= 50 ),
    user_name VARCHAR(25) NOT NULL CHECK ( LENGTH(user_name) <= 25 ),
    password  VARCHAR(50) NOT NULL CHECK ( LENGTH(password) <= 50),
    id_user   VARCHAR(40) NOT NULL,
    CONSTRAINT pk_users primary key (id_user)
);

-- Se aplica el uso de CONSTRAINT para que valide toda la información.

DELIMITER $$
CREATE PROCEDURE sp_create_users(IN name_p VARCHAR(50),
                                 IN last_name_p VARCHAR(50),
                                 IN email_p VARCHAR(50),
                                 IN user_name_p VARCHAR(25),
                                 IN password_p VARCHAR(50))
BEGIN
    INSERT INTO User(name, last_name, email, user_name, password, id_user)
        VALUE (name_p, last_name_p, email_p, user_name_p, password_p, uuid());
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_login_user(IN name_p VARCHAR(25), IN password_p(50))
BEGIN
    SELECT * FROM User WHERE name = name_p AND password = password_p;
END $$
DELIMITER ;

# Llamada de pruebadel procedimiento almacenado
CALL sp_create_users("Natanael", "Aguilar", "na@gmail.com", "na", "A1B2C3");