package org.aaguilar.system.utils;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static SceneManager instanciaSceneManager;
    private Stage primaryStage;

    private SceneManager() {
    }

    public static SceneManager getInstanciaSceneManager() {
        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }
        return instanciaSceneManager;
    }

    /**
     * Este método, como su nombre dice, recibe un objeto de tipo escena
     * y esa escena es la que se mostrará en el primariStage.
     *
     * @param scene es la Escena que se mostrará.
     */
    public void cambiarScene(Scene scene) {
        try {
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
