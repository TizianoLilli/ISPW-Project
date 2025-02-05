package org.example.ispwprogect.control.graphic;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;

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
    private RecommendedGuitarBean recommendedGuitarBean;

    @FXML
    private void handleHomeClick(MouseEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/homePage.fxml", id, null, null);

    }

    @FXML
    public void handleLoginClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/login.fxml"));
            VBox loginRoot = loader.load();

            Stage stage = (Stage) ((Label)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loginRoot, 400, 300)); // Dimensioni della schermata di login
            stage.setTitle("MyGuitar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleNewRecommendedGuitarClick(MouseEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/getRecommendedGuitar/getRecommendedGuitar.fxml", id, null, null);

    }

    @FXML
    public void handleNewDreamGuitarClick(MouseEvent event) {
        controller = new BuyDreamGuitarApplicationController();
        dreamGuitarBean = controller.newDreamGuitar();

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }

    @FXML
    public void handleBuyAccessoriesClick(MouseEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyAccessories/buyAccessories.fxml", id, null, null);

    }

}
