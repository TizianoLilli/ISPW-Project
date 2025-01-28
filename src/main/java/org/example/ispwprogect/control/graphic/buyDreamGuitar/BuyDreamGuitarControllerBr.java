package org.example.ispwprogect.control.graphic.buyDreamGuitar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.BridgeBean;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;
import org.example.ispwprogect.utils.enumeration.BridgeType;

public class BuyDreamGuitarControllerBr extends GraphicController {

    private DreamGuitarBean dreamGuitarBean;
    private IdSessionBean id;
    private BuyDreamGuitarApplicationController controller;

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
    private void handleBackClick(ActionEvent event) {

        ChangePage istanza = ChangePage.getChangePage();
        istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

    }

    @FXML private RadioButton hardtailRadio;
    @FXML private RadioButton tremoloRadio;
    @FXML private RadioButton tuneomaticRadio;
    @FXML private Label total;

    @FXML
    private void handleNextClick(ActionEvent event) {

        try {

            if (dreamGuitarBean.getBridgeBean() != null) {
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getBridgeBean().getPrice());
            }

            if (hardtailRadio.isSelected()) {

                BridgeBean bridgeBean = new BridgeBean(BridgeType.HARDTAIL);
                dreamGuitarBean.setBridgeBean(bridgeBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getBridgeBean().getPrice());
                // prezzo associato all'alternativa HARDTAIL

            } else if (tremoloRadio.isSelected()) {

                BridgeBean bridgeBean = new BridgeBean(BridgeType.TREMOLO);
                dreamGuitarBean.setBridgeBean(bridgeBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getBridgeBean().getPrice());
                // prezzo associato all'alternativa TREMOLO

            } else if (tuneomaticRadio.isSelected()) {

                BridgeBean bridgeBean = new BridgeBean(BridgeType.TUNEOMATIC);
                dreamGuitarBean.setBridgeBean(bridgeBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getBridgeBean().getPrice());
                // prezzo associato all'alternativa TUNEOMATIC

            } else {
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getBridgeBean().getPrice());
            }

            ChangePage istanza = ChangePage.getChangePage();
            istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
