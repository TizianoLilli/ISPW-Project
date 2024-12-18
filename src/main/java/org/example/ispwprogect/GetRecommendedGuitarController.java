package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GetRecommendedGuitarController {

    @FXML
    private void handleBackClick() {
        // Torna alla home page
        loadScene("homePage.fxml");
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
