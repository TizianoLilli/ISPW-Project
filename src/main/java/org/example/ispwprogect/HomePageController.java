package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

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
        // Questo metodo sarà automaticamente chiamato dopo che la vista è stata caricata
        leftStatusLabel.setText("Applicazione pronta.");
        rightStatusLabel.setText("Benvenuto!");
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


}