module HT1.Login.B4 {
    // Modulos de Java
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires mysql.connector.j;
    requires java.sql;

    exports org.aaguilar.system;
    opens org.aaguilar.system to javafx.fxml;
}