package org.example.ispwprogect;

//attualmente contiene tutte le pagine FXML di buyDreamGuitar

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;
import org.example.ispwprogect.utils.bean.PickupBean;
import org.example.ispwprogect.utils.enumeration.PickupType;

import java.util.HashMap;
import java.util.Map;

public class BuyDreamGuitarControllerStart extends GraphicController{

//    @FXML private Button bodyButton;

    @FXML private Button backButton;

    @FXML private Button nextButton;

    private Map<Button, String> page = new HashMap<>();

    private BuyDreamGuitarApplicationController controller;

    private DreamGuitarBean dreamGuitarBean;

    private IdSessionBean id;

    @FXML
    public void initialize() { //ATTENZIONE!! OGNI VOLTA CHE CAMBIO FXML RICHIAMO QUESTO METODO

//        page.put(bodyButton, "view/buyDreamGuitarBo.fxml");
//        page.put(bridgeButton, "view/buyDreamGuitarBr.fxml");
//        page.put(pickupsButton, "view/buyDreamGuitarP.fxml");
//        page.put(fretboardButton, "view/buyDreamGuitarF.fxml");
//        page.put(stringsButton, "view/buyDreamGuitarS.fxml");
//        page.put(nesButton, "view/buyDreamGuitarNH.fxml");
//
//        page.put(backButtonStart, "view/homePage.fxml");
//        page.put(backButton, "view/buyDreamGuitarStart.fxml");
//
//        page.put(nextButton, "view/buyDreamGuitarStart.fxml");

    }

    @Override
    public void init(IdSessionBean id, DreamGuitarBean dreamGuitarBean) {

        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;
        SessionManager manager = SessionManager.getSessionManager();
        Session session = manager.getSessionFromId(id);

        if (total != null && dreamGuitarBean != null) {
            total.setText("TOT = " + dreamGuitarBean.getPrice() + "$");
        }

    }

    @FXML
    private void handleBackClick(ActionEvent event) {}

    @FXML
    private void handleClick(ActionEvent event) {

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitarP.fxml", id, dreamGuitarBean);

    }

    @FXML private Label total;

}
