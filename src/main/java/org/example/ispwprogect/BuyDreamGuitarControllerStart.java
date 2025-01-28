package org.example.ispwprogect;

//attualmente contiene tutte le pagine FXML di buyDreamGuitar

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;
import org.example.ispwprogect.utils.bean.PickupBean;
import org.example.ispwprogect.utils.enumeration.PickupType;

public class BuyDreamGuitarControllerStart extends GraphicController{

    @FXML private Button pickupsButton;
    @FXML private Button bodyButton;
    @FXML private Button bridgeButton;
    @FXML private Button stringsButton;
    @FXML private Button fretboardButton;
    @FXML private Button nesButton;
    @FXML private Button backButton;
    @FXML private Button nextButton;

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;
    private IdSessionBean id;

    @FXML private Label total;

    @Override
    public void init(IdSessionBean id, DreamGuitarBean dreamGuitarBean) {

        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;
        SessionManager manager = SessionManager.getSessionManager();
        Session session = manager.getSessionFromId(id);

        if (total != null && dreamGuitarBean != null) {
            total.setText("TOT = " + dreamGuitarBean.getPrice() + "$");

            if (dreamGuitarBean.getPickupBean() != null) {
                pickupsButton.setText("Pickups&#10;(" + dreamGuitarBean.getPickupBean().getType() + ")");
            } else if (dreamGuitarBean.getBodyBean() != null) {
                bodyButton.setText("Body&#10;(" + dreamGuitarBean.getBodyBean().getType() + ")");
            } else if (dreamGuitarBean.getBridgeBean() != null) {
                bridgeButton.setText("Bridge&#10;(" + dreamGuitarBean.getBridgeBean().getType() + ")");
            } else if (dreamGuitarBean.getStringsBean() != null) {
                stringsButton.setText("Strings&#10;(" + dreamGuitarBean.getStringsBean().getType() + ")");
            } else if (dreamGuitarBean.getFretboardBean() != null) {
                fretboardButton.setText("Fretboard&#10;(" + dreamGuitarBean.getStringsBean().getType() + ")");
            } else if (dreamGuitarBean.getNesBean() != null) {
                nesButton.setText("Nes&#10;(" + dreamGuitarBean.getStringsBean().getType() + ")");
            }
        }
    }

    @FXML
    private void handleBackClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/homePage.fxml", id, null);

    }

    @FXML
    private void handlePickupsClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitarP.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleBodyClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitarBo.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleBridgeClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitarBr.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleStringsClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitarS.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleFretboardClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitarF.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleNesClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitarNH.fxml", id, dreamGuitarBean);

    }
}
