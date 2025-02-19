package org.example.ispwprogect.control.graphic.buyDreamGuitar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.enumeration.components.BridgeType;

public class BuyDreamGuitarControllerBr extends GraphicController {

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;

    private int id;

    @Override
    public void init(int id, DreamGuitarBean dreamGuitarBean) {

        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;

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

            BridgeType alternative = null;

            if (hardtailRadio.isSelected()) {
                alternative = BridgeType.HARDTAIL;
            } else if (tremoloRadio.isSelected()) {
                alternative = BridgeType.TREMOLO;
            } else if (tuneomaticRadio.isSelected()) {
                alternative = BridgeType.TUNEOMATIC;
            }

            controller.addComponent(dreamGuitarBean, "bridge", alternative);

            ChangePage istanza = ChangePage.getChangePage();
            istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
