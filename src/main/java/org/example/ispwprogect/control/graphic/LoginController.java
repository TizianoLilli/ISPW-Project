package org.example.ispwprogect.control.graphic;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.ispwprogect.model.login.Account;
import org.example.ispwprogect.utils.bean.*;
import org.example.ispwprogect.utils.enumeration.Role;

import java.io.IOException;

public class LoginController extends GraphicController{

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private AccountBean account1;
    private AccountBean account2;

    private UserBean user1;
    private UserBean user2;

    @Override
    public void init(IdSessionBean idSessionBean, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean) {
        // creo degli utenti fittizzi
        account1 = new AccountBean("ciccio123", "2025a", Role.BASE);
        account2 = new AccountBean("clau456", "1000b", Role.PREMIUM);

        user1 = new UserBean("ciccio123", "francesco", "renga", "fra@gmail.com", "via del campo 22");
        user2 = new UserBean("clau456", "claudia", "quaranta", "cla@gmail.com", "via del campo 11");
    }

    // Metodo chiamato quando l'utente clicca "Log In"
    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // USA UNA USER DAO PER RECUPERARE LA LISTA DI UTENTI


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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/homePage.fxml"));
            AnchorPane homeRoot = loader.load();

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(homeRoot));
            stage.setTitle("MyGuitar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

