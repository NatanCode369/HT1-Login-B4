package org.aaguilar.system.utils;

import javafx.scene.control.Alert;

public class AlertInformation {
    private final Alert alerta = new Alert(Alert.AlertType.NONE);

    public AlertInformation() {}

    public void alertaErrorFormulario(String causaError,String description) {
        getAlerta().setAlertType(Alert.AlertType.ERROR);
        getAlerta().setTitle("Error");
        getAlerta().setHeaderText(causaError);
        getAlerta().setContentText(description);
        getAlerta().showAndWait();
    }

    public void alertaConfirmacionFormulario(String causaConfirmacion, String description) {
        getAlerta().setAlertType(Alert.AlertType.CONFIRMATION);
        getAlerta().setTitle("Confirmación");
        getAlerta().setHeaderText(causaConfirmacion);
        getAlerta().setContentText(description);
        getAlerta().showAndWait();
    }

    public void alertaAdvertenciaFormulario(String causaAdvertencia, String description) {
        getAlerta().setAlertType(Alert.AlertType.WARNING);
        getAlerta().setTitle("Advertencia");
        getAlerta().setHeaderText(causaAdvertencia);
        getAlerta().setContentText(description);
        getAlerta().showAndWait();
    }

    public Alert getAlerta() {
        return alerta;
    }
}
