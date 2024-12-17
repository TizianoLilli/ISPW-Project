package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    // Metodo chiamato quando l'utente clicca "Log In"
    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Logica di autenticazione (puoi personalizzarla)
        if ("admin".equals(username) && "password123".equals(password)) {
            errorLabel.setText("");
            loadHomePage(); // Se l'accesso è corretto, torna alla home page
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    // Metodo per tornare alla schermata iniziale
    @FXML
    public void handleBackToHome() {
        loadHomePage();
    }

    private void loadHomePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));
            AnchorPane homeRoot = loader.load();

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(homeRoot, 900, 600));
            stage.setTitle("MyGuitar - Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

