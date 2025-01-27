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
import org.example.ispwprogect.utils.bean.PickupBean;
import org.example.ispwprogect.utils.enumeration.PickupType;

import java.util.HashMap;
import java.util.Map;

public class BuyDreamGuitarControllerStart extends GraphicController{

    @FXML private Button bodyButton;

    @FXML private Button bridgeButton;

    @FXML private Button pickupsButton;

    @FXML private Button fretboardButton;

    @FXML private Button stringsButton;

    @FXML private Button nesButton;

    @FXML private Button backButtonStart;

    @FXML private Button backButton;

    @FXML private Button nextButton;

    private Map<Button, String> page = new HashMap<>();

    private BuyDreamGuitarApplicationController controller;

    private DreamGuitarBean dreamGuitarBean;

    @FXML
    public void initialize() { //ATTENZIONE!! OGNI VOLTA CHE CAMBIO FXML RICHIAMO QUESTO METODO

        page.put(bodyButton, "view/buyDreamGuitarBo.fxml");
        page.put(bridgeButton, "view/buyDreamGuitarBr.fxml");
        page.put(pickupsButton, "view/buyDreamGuitarP.fxml");
        page.put(fretboardButton, "view/buyDreamGuitarF.fxml");
        page.put(stringsButton, "view/buyDreamGuitarS.fxml");
        page.put(nesButton, "view/buyDreamGuitarNH.fxml");

        page.put(backButtonStart, "view/homePage.fxml");
        page.put(backButton, "view/buyDreamGuitarStart.fxml");

        page.put(nextButton, "view/buyDreamGuitarStart.fxml");

//        controller = new BuyDreamGuitarApplicationController();
//        dreamGuitarBean = controller.newDreamGuitar(); //Problema: ogni volta creo una nuova istanza!!!

        if (total != null && dreamGuitarBean != null) {
            total.setText("TOT = " + dreamGuitarBean.getPrice() + "$"); //DA RIVEDERE! il prezzo viene aggiornato in body ma non viene trascritto in Start
        }

    }

    @Override
    public void init(DreamGuitarBean dreamGuitarBean, BuyDreamGuitarApplicationController controller) {

        this.dreamGuitarBean = dreamGuitarBean;
        this.controller = controller;
//        controller = new BuyDreamGuitarApplicationController();
//        dreamGuitarBean = controller.newDreamGuitar();
//        if (dreamGuitarBean != null) {System.out.println("SI");}
//        if (controller != null) {System.out.println("SI");}

    }

    @FXML
    private void handleClick(ActionEvent event) {

        Button clickedButton = (Button) event.getSource();
        String fxmlFile = page.get(clickedButton);

        if (fxmlFile != null) {
            changePage(fxmlFile, event);
        }

    }

    private FXMLLoader loader;

    private Scene newScene;

    private void changePage(String fxmlFile, ActionEvent event) {

        try {
            if (loader == null) {
                loader = new FXMLLoader(getClass().getResource(fxmlFile));
                newScene = new Scene(loader.load());
            }else{
                newScene = new Scene(loader.getRoot());
            }
            Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML private RadioButton SingleCoilRadio;

    @FXML private RadioButton HumbuckerRadio;

    @FXML private RadioButton P90Radio;

    @FXML private Label totPriceLabel;

    @FXML private Label total;

    @FXML
    private void handleNextClick(ActionEvent event) { // MEGLIO GESTIRLO CON LE BEAN!

        try{
            init(dreamGuitarBean, controller);
            if (dreamGuitarBean == null) {System.out.println("NO");}
            if (controller == null) {System.out.println("NO");}

            if (SingleCoilRadio.isSelected() && dreamGuitarBean != null) {
                if (dreamGuitarBean.getPickupBean() != null) {dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getPickupBean().getPrice()); }
                PickupBean pickupBean = new PickupBean(PickupType.SINGLECOIL);
                dreamGuitarBean.setPickupBean(pickupBean);
                // aggiorna il prezzo (o devo farlo in dream guitar bean?)
                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getPickupBean().getPrice());
                System.out.println(dreamGuitarBean.getPickupBean().getPrice());
                // prezzo associato all'alternativa SINGLECOIL
            } else if (HumbuckerRadio.isSelected() && dreamGuitarBean != null) {
                if (dreamGuitarBean.getPickupBean() != null) {dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getPickupBean().getPrice()); }
                PickupBean pickupBean = new PickupBean(PickupType.HUMBUCKER);
                dreamGuitarBean.setPickupBean(pickupBean);
                // aggiorna il prezzo (o devo farlo in dream guitar bean?)
                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getPickupBean().getPrice());
                // prezzo associato all'alternativa HUMBUCKER
            } else if (P90Radio.isSelected() && dreamGuitarBean != null) {
                // prezzo associato all'alternativa ASH
            }

//            System.out.println(dreamGuitarBean.getPrice());

            handleClick(event);

            init(dreamGuitarBean, controller);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
