package org.example.ispwprogect.control.graphic.buyDreamGuitar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.AddComponentBean;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.enumeration.components.StringsType;
import org.example.ispwprogect.utils.exception.SystemException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;

public class BuyDreamGuitarControllerS extends GraphicController {

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;

    private int id;

    @Override
    public void init(int id, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException {

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

    @FXML private RadioButton nineGaugeRadio;

    @FXML private RadioButton tenGaugeRadio;

    @FXML private RadioButton elevenGaugeRadio;

    @FXML private Label total;

    @FXML
    private void handleNextClick(ActionEvent event) {

        try {

            StringsType alternative = null;

            if (nineGaugeRadio.isSelected()) {
                alternative = StringsType.NINEGAUGE;
            } else if (tenGaugeRadio.isSelected()) {
                alternative = StringsType.TENGAUGE;
            } else if (elevenGaugeRadio.isSelected()) {
                alternative = StringsType.ELEVENGAUGE;
            }

            AddComponentBean addComponentBean = new AddComponentBean("strings",alternative);
            controller.addComponent(dreamGuitarBean, addComponentBean);

            ChangePage istanza = ChangePage.getChangePage();
            istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
