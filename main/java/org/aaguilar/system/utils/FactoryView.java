package org.aaguilar.system.utils;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import org.aaguilar.system.Main;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Objects;


public class FactoryView {
    private static FactoryView instanciFactoryView;

    public static FactoryView getInstancia() {
        if (instanciFactoryView == null)
            instanciFactoryView = new FactoryView();
        return instanciFactoryView;
    }

    public Scene cargarArchivoFXML(String fxmlName, double width, double height) {
        String PATH_VIEWS = "/org/aaguilar/system/view/";
        String rutaArchivoFXML = PATH_VIEWS + fxmlName;

        try {
            //Instancia de FXMLLoader
            FXMLLoader fxmlLoader = new FXMLLoader();

            /*
              Acá se le proporcionará la ruta del archivo FXML al loader
              y se llamará al archivo main
             */

            URL url = Main.class.getResource(rutaArchivoFXML);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            fxmlLoader.setLocation(url);

            return new Scene(fxmlLoader.load(), width, height);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    public void loadScene(String fxmlname) {
        Scene scene = null;
        try {
            switch (fxmlname){
                case "login" -> {
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().setTitle("Login Plataforma");
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().setResizable(false);
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().initStyle(StageStyle.TRANSPARENT);
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().getIcons().add(
                            new Image(Objects.requireNonNull(Main.class.getResourceAsStream("descarga1.jpg")))
                    );

                    scene = cargarArchivoFXML("LoginView.fxml", 400, 550);
                }
                case "registro" -> {
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().setTitle("Registro Plataforma");
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().setResizable(false);
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().initStyle(StageStyle.TRANSPARENT);
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().getIcons().add(
                            new Image(Objects.requireNonNull(Main.class.getResourceAsStream("kaoruko-smiling.gif")))
                    );

                    scene = cargarArchivoFXML("RegistroView.fxml", 400, 550);
                }
                case "menu" -> {
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().setTitle("Menu Plataforma");
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().setResizable(false);
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().initStyle(StageStyle.TRANSPARENT);
                    SceneManager.getInstanciaSceneManager().getPrimaryStage().getIcons().add(
                            new Image(Objects.requireNonNull(Main.class.getResourceAsStream("logo.png")))
                    );

                    scene = cargarArchivoFXML("MainMenuView.fxml", 900, 700);
                }
                default -> scene = cargarArchivoFXML("LoginView.fxml", 400, 550);
            }
            SceneManager.getInstanciaSceneManager().cambiarScene(scene);
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void loginView() {
        loadScene("login");
    }

    public void registroView() {
        loadScene("registro");
    }
}
