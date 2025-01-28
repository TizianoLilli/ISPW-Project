package org.example.ispwprogect.control.graphic.buyDreamGuitar;

//attualmente contiene tutte le pagine FXML di buyDreamGuitar

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;

public class BuyDreamGuitarControllerStart extends GraphicController {

    @FXML private Button pickupsButton;
    @FXML private Button bodyButton;
    @FXML private Button bridgeButton;
    @FXML private Button stringsButton;
    @FXML private Button fretboardButton;
    @FXML private Button nesButton;

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
                pickupsButton.setText("Pickups\n(" + dreamGuitarBean.getPickupBean().getType() + ")");
            }
            if (dreamGuitarBean.getBodyBean() != null) {
                bodyButton.setText("Body\n(" + dreamGuitarBean.getBodyBean().getType() + ")");
            }
            if (dreamGuitarBean.getBridgeBean() != null) {
                bridgeButton.setText("Bridge\n(" + dreamGuitarBean.getBridgeBean().getType() + ")");
            }
            if (dreamGuitarBean.getStringsBean() != null) {
                stringsButton.setText("Strings\n(" + dreamGuitarBean.getStringsBean().getType() + ")");
            }
            if (dreamGuitarBean.getFretboardBean() != null) {
                fretboardButton.setText("Fretboard\n(" + dreamGuitarBean.getFretboardBean().getType() + ")");
            }
            if (dreamGuitarBean.getNesBean() != null) {
                nesButton.setText("Nes\n(" + dreamGuitarBean.getNesBean().getType() + ")");
            }
        }
    }

    @FXML
    private void handleBackClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/homePage.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handlePickupsClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarP.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleBodyClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarBo.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleBridgeClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarBr.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleStringsClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarS.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleFretboardClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarF.fxml", id, dreamGuitarBean);

    }

    @FXML
    private void handleNesClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarNH.fxml", id, dreamGuitarBean);

    }
}
