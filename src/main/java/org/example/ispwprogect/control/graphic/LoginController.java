package org.example.ispwprogect.control.graphic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.control.application.LoginApplicationController;
import org.example.ispwprogect.utils.bean.*;
import org.example.ispwprogect.utils.enumeration.Role;
import org.example.ispwprogect.utils.exception.SystemException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController extends GraphicController{

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private int sessionId = -1;

    @Override
    public void init(int sessionId, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException {
        this.sessionId = sessionId;
    }

    public void registerUser(String id,  String password, Role role, String email, String address) {
        UserBean user = new UserBean(id, password, role, email, address);
        LoginApplicationController controller = new LoginApplicationController();
        controller.register(user);
    }

    // Metodo chiamato quando l'utente clicca "Log In"
    @FXML
    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        LoginApplicationController controller = new LoginApplicationController();
        CredentialBean credential = new CredentialBean(username, password);
        sessionId = controller.login(credential);
        if (sessionId != -1) {
            // fai qualcosa

            Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            ChangePage istanza = ChangePage.getChangePage();
            istanza.setStage(currentStage);
            istanza.change("view/homePage.fxml", sessionId, null);

        } else {errorLabel.setText("Invalid username or password.");}

    }

    @FXML
    public void handleBackToHome(ActionEvent event) {
        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/homePage.fxml", sessionId, null);
    }

}

