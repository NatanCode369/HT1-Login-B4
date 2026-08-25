package org.aaguilar.system.repository;

import com.mysql.cj.jdbc.CallableStatement;
import org.aaguilar.system.config.ConexionDB;
import org.aaguilar.system.model.User;

public class UserRepository implements UserInterface {

    //objeto de tipo ConexionDB para hacer la conexión a la DB
    private final ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    /**
     * Se sobreescribe el método de UserInterface
     * de esta forma se puede aplicar el patrón de diseño Comando
     *
     */
    @Override
    public void create(User usuario) {
        try {
            // objeto de tipo CallableStatement para llamar al procedimiento almacenado de la DB
            CallableStatement callableStatement = (CallableStatement) conexionDB
                    .getConnection()
                    .prepareCall("{ CALL sp_create_users(?, ?, ?, ?, ?)}");

            callableStatement.setString(1, usuario.getName());
            callableStatement.setString(2, usuario.getLastName());
            callableStatement.setString(3, usuario.getEmail());
            callableStatement.setString(4, usuario.getUserName());
            callableStatement.setString(5, usuario.getPassword());
            callableStatement.execute();
            callableStatement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
