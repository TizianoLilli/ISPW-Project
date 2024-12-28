package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class SidebarController {

    @FXML
    private Label rightStatusLabel;

    @FXML
    public void initialize() {
        if (rightStatusLabel != null) {
            rightStatusLabel.setText("Benvenuto!");
        } else {
            System.out.println("rightStatusLabel è null!");
        }
    }

    @FXML
    private void handleHomeClick(MouseEvent event) {
        loadScene("view/homePage.fxml", "", event);
    }

    @FXML
    public void handleLoginClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/login.fxml"));
            VBox loginRoot = loader.load();

            Stage stage = (Stage) ((Label)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loginRoot, 400, 300)); // Dimensioni della schermata di login
            stage.setTitle("Login - MyGuitar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleNewRecommendedGuitarClick(MouseEvent event) {
        loadScene("view/getRecommendedGuitar.fxml", "New Recommended Guitar - ", event);
    }

    private void loadScene(String fxml, String title, MouseEvent event) {
        try {
            // Carica la nuova schermata ".fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            AnchorPane sidebarRoot = loader.load();

            // Ottieni la finestra corrente e imposta la nuova scena
            Stage stage = (Stage) ((Label)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(sidebarRoot));
            stage.setTitle(title + "MyGuitar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
