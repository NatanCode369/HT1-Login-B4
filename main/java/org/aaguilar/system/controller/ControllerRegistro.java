package org.aaguilar.system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.aaguilar.system.utils.AlertInformation;
import org.aaguilar.system.utils.FactoryView;
import org.aaguilar.system.utils.Validations;

public class ControllerRegistro {
    @FXML private TextField textFieldNombre;
    @FXML private TextField textFieldLastName;
    @FXML private TextField textFieldUsername;
    @FXML private TextField textFieldCorreo;
    @FXML private TextField textFieldTelefono;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField passwordFieldConfirmar;
    protected Validations validaciones = new Validations();
    private final AlertInformation message = new AlertInformation();

    @FXML
    private void validacionesCampos() {

        if ((textFieldNombre.getText().isEmpty() || textFieldLastName.getText().isEmpty()) &&
                (textFieldUsername.getText().isEmpty() || textFieldUsername.getText().isBlank()) &&
                (textFieldCorreo.getText().isEmpty() || textFieldCorreo.getText().isBlank()) &&
                (textFieldTelefono.getText().isEmpty() || textFieldTelefono.getText().isBlank()) &&
                (passwordField.getText().isEmpty() || passwordField.getText().isBlank()) &&
                (passwordField.getText().isEmpty() || passwordField.getText().isBlank()))
            message.alertaErrorFormulario(
                    "Campos Obligatorios",
                    "Debe llenar los campos con letras o valores númericos."
            );

        if (validaciones.validarCorreo(textFieldCorreo.getText()))
            message.alertaAdvertenciaFormulario(
                    "Email no válido",
                    """
                            Asegúrese de ingresar correctamente el email,\s
                            debe llevar 1 sola @, el dominio no puede tener\s
                            más de 3 especificaciones (.ejemplo).
                           \s"""
            );

        if (validaciones.validarTelefono(textFieldTelefono.getText()))
            message.alertaAdvertenciaFormulario(
                    "Teléfono no válido",
                    "No puede ingresar letras en el número de teléfono, únicamente números."
            );

        if (validaciones.validarPassword(passwordField, passwordFieldConfirmar))
            message.alertaAdvertenciaFormulario(
                    "Las contraseñas no coinciden",
                    "Asegúrese de haber ingresado correctamente su contraseña en ambos campos."
            );
    }

    @FXML
    private void cambiarFormulario() {
        FactoryView.getInstancia().registroView();
    }
}