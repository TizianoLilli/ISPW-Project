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
import org.example.ispwprogect.control.application.LoginApplicationController;
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

    @Override
    public void init(IdSessionBean idSessionBean, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean) {
    }

    public void registerUser(String id, String name, String surname, String email, String address) {
        UserBean user = new UserBean(id, name, surname, email, address);
        LoginApplicationController controller = new LoginApplicationController();
    }

    public void registerAccount(String id, String password, Role role) {
        AccountBean account = new AccountBean(id, password, role);
        LoginApplicationController controller = new LoginApplicationController();
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

