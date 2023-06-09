package com.example.pruebamvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vista/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inicio");
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(String fxml,String titulo) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.setTitle(titulo);
        stage.getScene().setRoot(pane);
    }
    public static void main(String[] args) {
        launch();
    }
}