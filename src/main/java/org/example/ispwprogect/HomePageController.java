package org.example.ispwprogect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

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
    private Label viewLabel;

    @FXML
    private Label detailsLabel;

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