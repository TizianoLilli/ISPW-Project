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
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;
import org.example.ispwprogect.utils.enumeration.components.FretboardType;

public class BuyDreamGuitarControllerF extends GraphicController {

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;

    private int id;


    @Override
    public void init(int id, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean) {

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
        istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean, null);

    }

    @FXML private RadioButton mapleRadio;

    @FXML private RadioButton rosewoodRadio;

    @FXML private RadioButton ebonyRadio;

    @FXML private Label total;

    @FXML
    private void handleNextClick(ActionEvent event) {

        try {

            //BuyDreamGuitarApplicationController controller = new BuyDreamGuitarApplicationController();

            FretboardType alternative = null;

            if (mapleRadio.isSelected()) {

                alternative = FretboardType.MAPLE;

            } else if (rosewoodRadio.isSelected()) {

                alternative = FretboardType.ROSEWOOD;

            } else if (ebonyRadio.isSelected()) {

                alternative = FretboardType.EBONY;

            }

            controller.addComponent(dreamGuitarBean, "fretboard", alternative);

            ChangePage istanza = ChangePage.getChangePage();
            istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean, null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
