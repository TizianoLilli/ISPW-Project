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
import org.example.ispwprogect.utils.bean.StringsBean;
import org.example.ispwprogect.utils.enumeration.StringsType;

public class BuyDreamGuitarControllerS extends GraphicController {

    private DreamGuitarBean dreamGuitarBean;

    private IdSessionBean id;

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

    private BuyDreamGuitarApplicationController controller;

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

            if (dreamGuitarBean.getStringsBean() != null) {
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getStringsBean().getPrice());
            }

            if (nineGaugeRadio.isSelected()) {

                StringsBean stringsBean = new StringsBean(StringsType.NINEGAUGE);
                dreamGuitarBean.setStringsBean(stringsBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getStringsBean().getPrice());
                // prezzo associato all'alternativa NINEGAUGE

            } else if (tenGaugeRadio.isSelected()) {

                StringsBean stringsBean = new StringsBean(StringsType.TENGAUGE);
                dreamGuitarBean.setStringsBean(stringsBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getStringsBean().getPrice());
                // prezzo associato all'alternativa TENGAUGE

            } else if (elevenGaugeRadio.isSelected()) {

                StringsBean stringsBean = new StringsBean(StringsType.ELEVENGAUGE);
                dreamGuitarBean.setStringsBean(stringsBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getStringsBean().getPrice());
                // prezzo associato all'alternativa ELEVENGAUGE

            }else{
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getStringsBean().getPrice());
            }

            ChangePage istanza = ChangePage.getChangePage();
            istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
