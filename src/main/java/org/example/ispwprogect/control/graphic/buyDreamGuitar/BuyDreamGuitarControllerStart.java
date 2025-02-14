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
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.enumeration.components.*;

public class BuyDreamGuitarControllerStart extends GraphicController {

    @FXML private Button pickupsButton;
    @FXML private Button bodyButton;
    @FXML private Button bridgeButton;
    @FXML private Button stringsButton;
    @FXML private Button fretboardButton;
    @FXML private Button nesButton;

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;
    private int id;

    @FXML private Label total;


    @Override
    public void init(int id, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean) {

        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;

        if (total != null && dreamGuitarBean != null) {
            total.setText("TOT = " + dreamGuitarBean.getPrice() + "$");

            GenericType alternative;

            alternative = dreamGuitarBean.getComponent("pickup");
            if (alternative != null) {
                pickupsButton.setText("Pickups\n(" + ((PickupType)alternative).name() + ")");
            }
            alternative = dreamGuitarBean.getComponent("body");
            if (alternative != null) {
                bodyButton.setText("Body\n(" + ((BodyType)alternative).name() + ")");
            }
            alternative = dreamGuitarBean.getComponent("bridge");
            if (alternative != null) {
                bridgeButton.setText("Bridge\n(" + ((BridgeType)alternative).name() + ")");
            }
            alternative = dreamGuitarBean.getComponent("strings");
            if (alternative != null) {
                stringsButton.setText("Strings\n(" + ((StringsType)alternative).name() + ")");
            }
            alternative = dreamGuitarBean.getComponent("fretboard");
            if (alternative != null) {
                fretboardButton.setText("Fretboard\n(" + ((FretboardType)alternative).name() + ")");
            }
            alternative = dreamGuitarBean.getComponent("neck&headstock");
            if (alternative != null) {
                nesButton.setText("Nes\n(" + ((NesType)alternative).name() + ")");
            }
        }
    }

    @FXML
    private void handleBackClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/homePage.fxml", id, dreamGuitarBean, null);

    }

    @FXML
    private void handlePickupsClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarP.fxml", id, dreamGuitarBean, null);

    }

    @FXML
    private void handleBodyClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarBo.fxml", id, dreamGuitarBean, null);

    }

    @FXML
    private void handleBridgeClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarBr.fxml", id, dreamGuitarBean, null);

    }

    @FXML
    private void handleStringsClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarS.fxml", id, dreamGuitarBean, null);

    }

    @FXML
    private void handleFretboardClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarF.fxml", id, dreamGuitarBean, null);

    }

    @FXML
    private void handleNesClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarNH.fxml", id, dreamGuitarBean, null);

    }

    @FXML
    public void handleSaveClick(ActionEvent event) {

        SessionManager manager = SessionManager.getSessionManager();
        Session session = manager.getSessionFromId(id);
        UserBean userBean = session.getUserBean();

        controller.saveDreamGuitar(dreamGuitarBean, userBean);

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/toLuthier.fxml", id, dreamGuitarBean, null);
    }
}
