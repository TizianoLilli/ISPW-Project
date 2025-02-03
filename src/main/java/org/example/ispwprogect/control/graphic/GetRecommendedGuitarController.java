package org.example.ispwprogect.control.graphic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;

public class GetRecommendedGuitarController extends GraphicController{

    private IdSessionBean id;

    public void init(IdSessionBean id, DreamGuitarBean dreamGuitarBean) {
        this.id = id;
    }

    public void handleBackClick(ActionEvent event) {
        try {

            Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            ChangePage istanza = ChangePage.getChangePage();
            istanza.setStage(currentStage);
            istanza.change("view/homePage.fxml", id, null);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nel caricamento della HomePage.");
        }
    }

    @FXML
    private void handleNextClick(ActionEvent event) {
        // Logica per passare alla prossima schermata
        try {
            Stage currentStage = (Stage) ((Node)  event.getSource()).getScene().getWindow();
            ChangePage istanza = ChangePage.getChangePage();
            istanza.setStage(currentStage);
            istanza.change("view/getRecommendedGuitar/selectGuitar.fxml", id, null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nel caricamento della pagina Select Guitar.");
        }
    }

    @FXML
    private void handleSettingsClick() {
        System.out.println("Settings clicked!");
    }

}
