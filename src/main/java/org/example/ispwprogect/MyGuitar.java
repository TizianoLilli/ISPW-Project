package org.example.ispwprogect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import java.io.IOException;

public class MyGuitar extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MyGuitar.class.getResource("homePage.fxml"));
        Parent root = fxmlLoader.load();

        primaryStage.getIcons().add(new Image("logoApp.png")); //da rivedere (non scala correttamente l'immagine)

        primaryStage.setTitle("MyGuitar");
        primaryStage.setResizable(false); // Opzionale: finestra non ridimensionabile
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}