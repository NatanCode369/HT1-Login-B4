package org.aaguilar.system.controller;

import javafx.fxml.FXML;
import org.aaguilar.system.utils.AlertInformation;
import org.aaguilar.system.utils.FactoryView;

public class ControllerMainMenu {
    private final AlertInformation alerta = new AlertInformation();

    @FXML
    private void cerrarSesion() {
        alerta.alertaConfirmacionFormulario(
                "Cierre Exitoso",
                "Se logró cerrar sesión de forma segura y correcta."
        );
        FactoryView.getInstancia().loginView();
    }
}
