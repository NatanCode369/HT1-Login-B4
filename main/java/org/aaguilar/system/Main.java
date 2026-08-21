package org.aaguilar.system;

import javafx.application.Application;
import javafx.stage.Stage;
import org.aaguilar.system.utils.FactoryView;
import org.aaguilar.system.utils.SceneManager;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SceneManager.getInstanciaSceneManager().setPrimaryStage(primaryStage);
        FactoryView factoryView = new FactoryView();
        factoryView.loginView();
    }
}
