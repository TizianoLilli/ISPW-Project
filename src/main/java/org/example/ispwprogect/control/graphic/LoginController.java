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

public class LoginController extends GraphicController{

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private int sessionId = 0;

    @Override
    public void init(int sessionId, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean) {}

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
        sessionId = controller.login(username, password);
        if (sessionId != -1) {
            // fai qualcosa
            System.out.println("Login successful");

            Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            ChangePage istanza = ChangePage.getChangePage();
            istanza.setStage(currentStage);
            istanza.change("view/homepage.fxml", sessionId, null, null);

        } else {errorLabel.setText("Invalid username or password.");}

    }

    @FXML
    public void handleBackToHome(ActionEvent event) {
        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", sessionId, null, null);
    }

}

