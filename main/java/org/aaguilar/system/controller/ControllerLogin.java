package org.aaguilar.system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.aaguilar.system.utils.AlertInformation;
import org.aaguilar.system.utils.FactoryView;

public class ControllerLogin {
    @FXML private TextField textFieldUsername;
    @FXML private PasswordField passwordField;
    private final AlertInformation message = new AlertInformation();

    @FXML
    private void validacionesCampos() {
        if ((textFieldUsername.getText().isEmpty() || textFieldUsername.getText().isBlank()) &&
                (passwordField.getText().isEmpty() || passwordField.getText().isBlank()))
            message.alertaAdvertenciaFormulario(
                    "Campos Obligatorios",
                    "Debe llenar todos los campos ni llenar con espacios."
            );

    }
    @FXML
    private void cambiarFormulario() {
        FactoryView.getInstancia().loginView();
    }
}