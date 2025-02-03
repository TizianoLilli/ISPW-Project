package org.example.ispwprogect.control.graphic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;

public class BuyAccessoriesController extends GraphicController {
    private IdSessionBean id;

    @FXML
    private ListView<String> guitaristListView;

    @FXML
    private ComboBox<String> priceRangeComboBox;

    @FXML
    private ImageView accessory1Image, accessory2Image, accessory3Image, accessory4Image;

    @FXML
    private Label accessory1Name, accessory2Name, accessory3Name, accessory4Name;

    @FXML
    private Label accessory1Price, accessory2Price, accessory3Price, accessory4Price;

    public void init(IdSessionBean id, DreamGuitarBean dreamGuitarBean) {
        this.id = id;
    }

    @FXML
    private void handleBackClick(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ChangePage istanza = ChangePage.getChangePage();
            istanza.setStage(currentStage);
            istanza.change("view/homepage.fxml", id, null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nel caricamento della schermata precedente.");
        }
    }


    @FXML
    private Button accessory1Button;
    @FXML
    private Button accessory2Button;
    @FXML
    private Button accessory3Button;
    @FXML
    private Button accessory4Button;


    @FXML
    private void handleAccessoryClick(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String accessoryName = clickedButton.getText();

        System.out.println("Hai selezionato: " + accessoryName);

        // Qui puoi aprire una nuova scena, mostrare dettagli, ecc.
    }


    // Metodo per gestire il click sul bottone di selezione prezzo
    @FXML
    private void handlePriceButtonClick() {
        if (priceRangeComboBox.isShowing()) {
            priceRangeComboBox.hide();
        } else {
            priceRangeComboBox.show();
        }
    }

    // Metodo per gestire la selezione della fascia di prezzo
    @FXML
    private void handlePriceSelection() {
        String selectedRange = priceRangeComboBox.getValue();
        System.out.println("Fascia di prezzo selezionata: " + selectedRange);

        // Qui puoi aggiungere codice per filtrare le chitarre in base al prezzo selezionato
    }

}