module HT.Login.B {
    // Modulos de Java
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires mysql.connector.j;
    requires java.sql;

    exports org.aaguilar.system;
    opens org.aaguilar.system to javafx.fxml;
    opens org.aaguilar.system.controller to  javafx.fxml;
    opens org.aaguilar.system.view to javafx.fxml;
    opens org.aaguilar.system.utils to javafx.fxml;
}