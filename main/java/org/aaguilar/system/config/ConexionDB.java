package org.aaguilar.system.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static ConexionDB instanciaConexionDB;
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ConexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + Enviroment.LOCATION_SERVICE + "/" + Enviroment.DATABASE,
                    String.valueOf(Enviroment.USER),
                    String.valueOf(Enviroment.PASSWORD)
            );
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static ConexionDB getInstanciaConexionDB() {
        if (instanciaConexionDB == null) {
            instanciaConexionDB = new ConexionDB();
        }
        return instanciaConexionDB;
    }
}
