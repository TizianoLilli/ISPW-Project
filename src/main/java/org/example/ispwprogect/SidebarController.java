package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;

import java.io.IOException;

public class SidebarController{

    @FXML
    private Label rightStatusLabel;

    @FXML
    public void initialize() {
        if (rightStatusLabel != null) {
            rightStatusLabel.setText("Benvenuto!");
        } else {
            System.out.println("rightStatusLabel è null!");
        }
    }

    private BuyDreamGuitarApplicationController controller;
    private IdSessionBean id;
    private DreamGuitarBean dreamGuitarBean;

    @FXML
    private void handleHomeClick(MouseEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/homePage.fxml", id, null);

    }

    @FXML
    public void handleLoginClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/login.fxml"));
            VBox loginRoot = loader.load();

            Stage stage = (Stage) ((Label)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loginRoot, 400, 300)); // Dimensioni della schermata di login
            stage.setTitle("Login - MyGuitar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleNewRecommendedGuitarClick(MouseEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/getRecommendedGuitar.fxml", id, null);

    }

    @FXML
    public void handleNewDreamGuitarClick(MouseEvent event) {
        controller = new BuyDreamGuitarApplicationController();
        dreamGuitarBean = controller.newDreamGuitar();

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

    }

}
