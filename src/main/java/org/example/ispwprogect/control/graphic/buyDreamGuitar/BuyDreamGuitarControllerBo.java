package org.example.ispwprogect.control.graphic.buyDreamGuitar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.enumeration.components.BodyType;

public class BuyDreamGuitarControllerBo extends GraphicController {

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

    @FXML private RadioButton mapleRadio;
    @FXML private RadioButton mahoganyRadio;
    @FXML private RadioButton ashRadio;
    @FXML private Label total;

    @FXML
    private void handleNextClick(ActionEvent event) {

        try {

            BodyType alternative = null;

            if (mapleRadio.isSelected()) {
                alternative = BodyType.MAPLE;
            } else if (mahoganyRadio.isSelected()) {
                alternative = BodyType.MAHOGANY;
            } else if (ashRadio.isSelected()) {
                alternative = BodyType.ASH;
            }

            controller.addComponent(dreamGuitarBean, "body", alternative);

            ChangePage istanza = ChangePage.getChangePage();
            istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
