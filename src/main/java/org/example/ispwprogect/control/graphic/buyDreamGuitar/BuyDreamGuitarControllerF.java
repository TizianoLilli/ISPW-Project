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
import org.example.ispwprogect.utils.bean.IdSessionBean;
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;
import org.example.ispwprogect.utils.enumeration.components.FretboardType;

public class BuyDreamGuitarControllerF extends GraphicController {

    private DreamGuitarBean dreamGuitarBean;
    private RecommendedGuitarBean recommendedGuitarBean;

    private IdSessionBean id;


    @Override
    public void init(IdSessionBean id, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean) {

        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;
        SessionManager manager = SessionManager.getSessionManager();
        Session session = manager.getSessionFromId(id);

        if (total != null && dreamGuitarBean != null) {
            total.setText("TOT = " + dreamGuitarBean.getPrice() + "$");
        }

    }

    private BuyDreamGuitarApplicationController controller;

    @FXML
    private void handleBackClick(ActionEvent event) {

        ChangePage istanza = ChangePage.getChangePage();
        istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean, recommendedGuitarBean);

    }

    @FXML private RadioButton mapleRadio;

    @FXML private RadioButton rosewoodRadio;

    @FXML private RadioButton ebonyRadio;

    @FXML private Label total;

    @FXML
    private void handleNextClick(ActionEvent event) {

        try {

            BuyDreamGuitarApplicationController controller = new BuyDreamGuitarApplicationController();

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
            istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean, recommendedGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
