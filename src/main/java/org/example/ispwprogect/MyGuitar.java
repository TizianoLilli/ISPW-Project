package org.example.ispwprogect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import org.example.ispwprogect.control.graphic.LoginController;
import org.example.ispwprogect.utils.enumeration.PersistenceProvider;
import org.example.ispwprogect.utils.enumeration.Role;

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

        LoginController registration = new LoginController();
        registration.registerUser("ciccio123", "francesco", "renga", "fra@gmail.com", "via del campo 22");
        registration.registerUser("clau456", "claudia", "quaranta", "cla@gmail.com", "via del campo 11");
        registration.registerAccount("ciccio123", "2025a", Role.BASE);
        registration.registerAccount("clau456", "1000b", Role.PREMIUM);
    }
}