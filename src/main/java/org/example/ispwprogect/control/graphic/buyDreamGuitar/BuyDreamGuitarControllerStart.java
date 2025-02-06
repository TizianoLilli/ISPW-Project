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
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;

public class BuyDreamGuitarControllerStart extends GraphicController {

    @FXML private Button pickupsButton;
    @FXML private Button bodyButton;
    @FXML private Button bridgeButton;
    @FXML private Button stringsButton;
    @FXML private Button fretboardButton;
    @FXML private Button nesButton;

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;
    private RecommendedGuitarBean recommendedGuitarBean;
    private IdSessionBean id;

    @FXML private Label total;


    @Override
    public void init(IdSessionBean id, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean) {

        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;
        SessionManager manager = SessionManager.getSessionManager();
        Session session = manager.getSessionFromId(id);

        if (total != null && dreamGuitarBean != null) {
            total.setText("TOT = " + dreamGuitarBean.getPrice() + "$");

            if (dreamGuitarBean.getPickup() != null) {
                pickupsButton.setText("Pickups\n(" + dreamGuitarBean.getPickup().name() + ")");
            }
            if (dreamGuitarBean.getBody() != null) {
                bodyButton.setText("Body\n(" + dreamGuitarBean.getBody().name() + ")");
            }
            if (dreamGuitarBean.getBridge() != null) {
                bridgeButton.setText("Bridge\n(" + dreamGuitarBean.getBridge().name() + ")");
            }
            if (dreamGuitarBean.getStrings() != null) {
                stringsButton.setText("Strings\n(" + dreamGuitarBean.getStrings().name() + ")");
            }
            if (dreamGuitarBean.getFretboard() != null) {
                fretboardButton.setText("Fretboard\n(" + dreamGuitarBean.getFretboard().name() + ")");
            }
            if (dreamGuitarBean.getNes() != null) {
                nesButton.setText("Nes\n(" + dreamGuitarBean.getNes().name() + ")");
            }
        }
    }

    @FXML
    private void handleBackClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/homePage.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }

    @FXML
    private void handlePickupsClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarP.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }

    @FXML
    private void handleBodyClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarBo.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }

    @FXML
    private void handleBridgeClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarBr.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }

    @FXML
    private void handleStringsClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarS.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }

    @FXML
    private void handleFretboardClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarF.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }

    @FXML
    private void handleNesClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarNH.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }
}
