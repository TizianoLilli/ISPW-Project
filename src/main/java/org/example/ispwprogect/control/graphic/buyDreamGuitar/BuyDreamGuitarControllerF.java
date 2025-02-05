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
import org.example.ispwprogect.utils.bean.FretboardBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;
import org.example.ispwprogect.utils.enumeration.FretboardType;

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

            if (dreamGuitarBean.getFretboardBean() != null) {
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getFretboardBean().getPrice());
            }

            if (mapleRadio.isSelected()) {

                FretboardBean fretboardBean = new FretboardBean(FretboardType.MAPLE);
                dreamGuitarBean.setFretboardBean(fretboardBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getFretboardBean().getPrice());
                // prezzo associato all'alternativa MAPLE

            } else if (rosewoodRadio.isSelected()) {

                FretboardBean fretboardBean = new FretboardBean(FretboardType.ROSEWOOD);
                dreamGuitarBean.setFretboardBean(fretboardBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getFretboardBean().getPrice());
                // prezzo associato all'alternativa ROSEWOOD

            } else if (ebonyRadio.isSelected()) {

                FretboardBean fretboardBean = new FretboardBean(FretboardType.EBONY);
                dreamGuitarBean.setFretboardBean(fretboardBean);

                // aggiorno il prezzo con l'aggiunta del nuovo componente
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getFretboardBean().getPrice());
                // prezzo associato all'alternativa EBONY

            }else{
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getFretboardBean().getPrice());
            }

            ChangePage istanza = ChangePage.getChangePage();
            istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean, recommendedGuitarBean);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
