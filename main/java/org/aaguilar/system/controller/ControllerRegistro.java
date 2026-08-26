package org.aaguilar.system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.aaguilar.system.utils.Validations;

public class ControllerRegistro {
    @FXML private TextField textFieldNombre;
    @FXML private TextField textFieldLastName;
    @FXML private TextField textFieldCorreo;
    @FXML private TextField textFieldTelefono;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField passwordFieldConfirmar;
    @FXML private Hyperlink linkCambioFormulario;
    @FXML private Button btnRegistro;
    protected Validations validaciones = new Validations();
    private Alert alert = new Alert(Alert.AlertType.ERROR);

    private void validacionesCampos() {

        if ((textFieldNombre.getText().isEmpty() || textFieldNombre.getText().isBlank()) &&
                (textFieldLastName.getText().isBlank() || textFieldLastName.getText().isBlank()) &&
                (textFieldCorreo.getText().isEmpty() || textFieldCorreo.getText().isBlank()) &&
                (textFieldTelefono.getText().isEmpty() || textFieldTelefono.getText().isBlank()) &&
                (passwordField.getText().isEmpty() || passwordField.getText().isBlank()) &&
                (passwordField.getText().isEmpty() || passwordField.getText().isBlank()))
            alert.showAndWait();

        if (validaciones.validarCorreo(textFieldCorreo.getText()) && validaciones.validarTelefono(textFieldTelefono.getText()))
            alert.showAndWait();
    }
}