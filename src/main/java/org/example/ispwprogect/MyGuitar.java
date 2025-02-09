package org.example.ispwprogect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import org.example.ispwprogect.utils.enumeration.PersistenceProvider;

import java.io.IOException;
import java.util.Scanner;

public class MyGuitar extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MyGuitar.class.getResource("view/homePage.fxml"));
        Parent root = fxmlLoader.load();

        primaryStage.getIcons().add(new Image("logoApp.png"));

        primaryStage.setTitle("MyGuitar");
        primaryStage.setResizable(false); // Opzionale: finestra non ridimensionabile
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {

        Config conf = new Config();

        int choice = -1;
        Scanner s = new Scanner(System.in);

        conf.setPersistenceProvider(choice, s);

        launch();
    }
}