package org.example.ispwprogect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;
import org.example.ispwprogect.utils.bean.PickupBean;
import org.example.ispwprogect.utils.enumeration.PickupType;

public class BuyDreamGuitarControllerP extends GraphicController{

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
        istanza.change("view/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

    }

    @FXML private RadioButton SingleCoilRadio;

    @FXML private RadioButton HumbuckerRadio;

    @FXML private RadioButton P90Radio;

    @FXML private Label total;

    @FXML
    private void handleNextClick(ActionEvent event) {

        try {

            if (dreamGuitarBean.getPickupBean() != null) {
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getPickupBean().getPrice());
            }

            if (SingleCoilRadio.isSelected()) {

                PickupBean pickupBean = new PickupBean(PickupType.SINGLECOIL);
                dreamGuitarBean.setPickupBean(pickupBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getPickupBean().getPrice());
                // prezzo associato all'alternativa SINGLECOIL

            } else if (HumbuckerRadio.isSelected()) {

                PickupBean pickupBean = new PickupBean(PickupType.HUMBUCKER);
                dreamGuitarBean.setPickupBean(pickupBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getPickupBean().getPrice());
                // prezzo associato all'alternativa HUMBUCKER

            } else if (P90Radio.isSelected()) {

                PickupBean pickupBean = new PickupBean(PickupType.P90);
                dreamGuitarBean.setPickupBean(pickupBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getPickupBean().getPrice());
                // prezzo associato all'alternativa P90
            }else{
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getPickupBean().getPrice());
            }

            ChangePage istanza = ChangePage.getChangePage();
            istanza.change("view/buyDreamGuitarStart.fxml", id, dreamGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
