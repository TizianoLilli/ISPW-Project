package org.example.ispwprogect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GetRecommendedGuitarController {

    public void handleBackClick(ActionEvent event) {
        try {
            // Carica il file FXML della HomePage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent homePageRoot = loader.load();

            // Crea una nuova scena
            Scene homePageScene = new Scene(homePageRoot);

            // Ottieni lo Stage corrente e imposta la nuova scena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(homePageScene);
            stage.setTitle("Home Page");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Errore nel caricamento della HomePage.");
        }
    }

    @FXML
    private void handleNextClick() {
        // Logica per passare alla prossima schermata
        System.out.println("Next button clicked!");
    }

    @FXML
    private void handleHomeClick() {
        loadScene("homePage.fxml");
    }

    @FXML
    private void handleSettingsClick() {
        System.out.println("Settings clicked!");
    }

    @FXML
    private void handleLogoutClick() {
        loadScene("login.fxml");
    }

    private void loadScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            AnchorPane root = loader.load();

            Stage stage = (Stage) ((AnchorPane) root.getScene().getRoot()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
