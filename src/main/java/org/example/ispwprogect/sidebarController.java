package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class sidebarController {

    @FXML
    private Label rightStatusLabel;

    @FXML
    private Label masterLabel;

    @FXML
    public void initialize() {
        if (rightStatusLabel != null) {
            rightStatusLabel.setText("Benvenuto!");
        } else {
            System.out.println("rightStatusLabel è null!");
        }
    }

    @FXML
    public void handleLoginClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            VBox loginRoot = loader.load();

            Stage stage = (Stage) masterLabel.getScene().getWindow();
            stage.setScene(new Scene(loginRoot, 400, 300)); // Dimensioni della schermata di login
            stage.setTitle("Login - MyGuitar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleNewRecommendedGuitarClick() {
        try {
            // Carica la nuova schermata "getRecommendedGuitar.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("getRecommendedGuitar.fxml"));
            AnchorPane recommendedRoot = loader.load();

            // Ottieni la finestra corrente e imposta la nuova scena
            Stage stage = (Stage) masterLabel.getScene().getWindow();
            stage.setScene(new Scene(recommendedRoot, 900, 600));
            stage.setTitle("New Recommended Guitar - MyGuitar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
