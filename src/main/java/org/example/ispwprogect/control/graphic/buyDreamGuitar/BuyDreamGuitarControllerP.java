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
import org.example.ispwprogect.utils.bean.PickupBean;
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;
import org.example.ispwprogect.utils.enumeration.PickupType;

public class BuyDreamGuitarControllerP extends GraphicController {

    private DreamGuitarBean dreamGuitarBean;

    private IdSessionBean id;

    public void initRecommendedGuitar(IdSessionBean idSessionBean, RecommendedGuitarBean bean) {
        throw new UnsupportedOperationException("Questo controller non usa RecommendedGuitarBean");
    }

    @Override
    public void initDreamGuitar(IdSessionBean id, DreamGuitarBean dreamGuitarBean) {

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
        istanza.changeDreamGuitar("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

    }

    @FXML private RadioButton SingleCoilRadio;

    @FXML private RadioButton HumbuckerRadio;

    @FXML private RadioButton P90Radio;

    @FXML private Label total;

    @FXML
    private void handleNextClick(ActionEvent event) {

        try {

            BuyDreamGuitarApplicationController controller = new BuyDreamGuitarApplicationController();

            PickupType alternative = null;

            if (SingleCoilRadio.isSelected()) {

                alternative = PickupType.SINGLECOIL;

            } else if (HumbuckerRadio.isSelected()) {

                alternative = PickupType.HUMBUCKER;

            } else if (P90Radio.isSelected()) {

                alternative = PickupType.P90;

            }

            controller.addPickup(dreamGuitarBean, alternative);

            ChangePage istanza = ChangePage.getChangePage();
            istanza.changeDreamGuitar("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
