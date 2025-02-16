package org.example.ispwprogect.control.graphic;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.control.graphic.buyDreamGuitar.BuyDreamGuitarControllerStart;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;

public class SidebarController{

    @FXML
    private Label rightStatusLabel;

    @FXML
    private Label userLabel;

    // voglio mantenere solo la sessione
    private int id = -1;
    private Session session;

    public void initialize(){
        SessionManager manager = SessionManager.getSessionManager();
        this.id = manager.getCurrentId();
        if (id != -1){
            session = manager.getSessionFromId(id);
            userLabel.setText("Hi, " + session.getUserId());
        } else {
            userLabel.setText("Guest");
        }
    }

    @FXML
    private void handleHomeClick(MouseEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/homePage.fxml", id, null, null);

    }

    @FXML
    public void handleLoginClick(MouseEvent event) {
        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/login.fxml", id, null, null);

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
        BuyDreamGuitarApplicationController controller = new BuyDreamGuitarApplicationController();
        DreamGuitarBean dreamGuitarBean = controller.newDreamGuitar();

        boolean value = controller.checkGuitar(session.getUserId());
        BuyDreamGuitarControllerStart.setToRecover(value);

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean, null);

    }

    @FXML
    public void handleBuyAccessoriesClick(MouseEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyAccessories/buyAccessories.fxml", id, null, null);

    }

}
