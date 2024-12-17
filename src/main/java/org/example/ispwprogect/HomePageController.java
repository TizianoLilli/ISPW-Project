package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    
    @FXML
    private Label leftStatusLabel;

    @FXML
    private Label rightStatusLabel;

    @FXML
    private Label saveText;
    
    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem saveMenuItem;

    @FXML
    private MenuItem saveAsMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Label masterLabel;

    @FXML
    private Label viewLabel;

    @FXML
    private Label detailsLabel;

    @FXML
    public void initialize() {
        if (leftStatusLabel != null) {
            // Questo metodo sarà automaticamente chiamato dopo che la vista è stata caricata
            leftStatusLabel.setText("Applicazione pronta.");
        } else {
            System.out.println("leftStatusLabel non e' stato inizializzato!");
        }

        if (rightStatusLabel != null) {
            rightStatusLabel.setText("Benvenuto!");
        } else {
            System.out.println("rightStatusLabel è null!");
        }
    }

    @FXML
    private void handleNewMenuAction() {
        System.out.println("Nuovo file creato!");
    }

    @FXML
    private void handleOpenMenuAction() {
        // Puoi inserire qui la logica per aprire un file
        System.out.println("Apertura file...");
    }

    @FXML
    private void handleCloseMenuAction() {
        System.out.println("Chiusura file.");
    }

    @FXML
    private void handleSaveMenuAction() {
        saveText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void handleAboutMenuAction() {
        System.out.println("Informazioni sull'app.");
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



}