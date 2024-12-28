package org.example.ispwprogect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GetRecommendedGuitarController {

    public void handleBackClick(ActionEvent event) {
        try {
            // Carica il file FXML della HomePage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/homePage.fxml"));
            Parent homePageRoot = loader.load();

            // Crea una nuova scena
            Scene homePageScene = new Scene(homePageRoot);

            // Ottieni lo Stage corrente e imposta la nuova scena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(homePageScene);
            stage.setTitle("MyGuitar");
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
    private void handleSettingsClick() {
        System.out.println("Settings clicked!");
    }

}
