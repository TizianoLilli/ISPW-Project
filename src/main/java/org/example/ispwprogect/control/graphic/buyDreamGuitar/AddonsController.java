package org.example.ispwprogect.control.graphic.buyDreamGuitar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.model.decorator.Decorator;
import org.example.ispwprogect.utils.bean.AddonsBean;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;
import org.example.ispwprogect.utils.enumeration.Color;
import org.example.ispwprogect.utils.enumeration.components.Sticker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class AddonsController extends GraphicController {

    @FXML
    private ToggleGroup emptyGroup;

    @FXML
    private RadioButton redRadio;

    @FXML
    private RadioButton blueRadio;

    @FXML
    private RadioButton blackRadio;

    @FXML
    private RadioButton emptyRadio;

    @FXML
    private CheckBox blackMatteBox;

    @FXML
    private CheckBox redMatteBox;

    @FXML
    private CheckBox blueMatteBox;

    public void initialize() {
        // disabilito i checkbox anche all'inizio
        if (emptyRadio.isSelected()) {
            redMatteBox.setDisable(true);
            blueMatteBox.setDisable(true);
            blackMatteBox.setDisable(true);
        }
        // listener per gestire la selezione del RadioButton "empty"
        emptyGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == emptyRadio) {
                // se "empty" è selezionato, deseleziona tutti gli altri RadioButton
                redRadio.setSelected(false);
                blackRadio.setSelected(false);
                blueRadio.setSelected(false);
                // deseleziona i CheckBox
                redMatteBox.setSelected(false);
                blueMatteBox.setSelected(false);
                blackMatteBox.setSelected(false);
                // disabilita i CheckBox
                redMatteBox.setDisable(true);
                blueMatteBox.setDisable(true);
                blackMatteBox.setDisable(true);

                for (int i=0; i < colors.length; i++){
                    updateColor(i, false, false);
                }

                for (Sticker s : Sticker.values()) {
                    updateStickers(s.name(), 0);
                }
            }
        });
    }

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;
    private int id;

    @Override
    public void init(int sessionId, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean) {
        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;
    }

    // Inizializza l'array: 3 colori (nero, rosso, blu) e 2 stati (selezionato, opacità)
    private boolean[][] colors = new boolean[3][2];

    public void handleBlack(ActionEvent event) {
        if (blackRadio.isSelected()) {
            blackMatteBox.setDisable(false); // Abilita il CheckBox
            emptyRadio.setSelected(false); // Deseleziona "Vuoto" se un colore è selezionato
            updateColor(0, true, false);
        } else {
            blackMatteBox.setDisable(true); // Disabilita il CheckBox
            blackMatteBox.setSelected(false); // Deseleziona il CheckBox
            updateColor(0, false, false);
        }
    }

    public void handleRed(ActionEvent event) {
        if (redRadio.isSelected()) {
            redMatteBox.setDisable(false);
            emptyRadio.setSelected(false);
            updateColor(1, true, false);
        } else {
            redMatteBox.setDisable(true);
            redMatteBox.setSelected(false);
            updateColor(1, false, false);
        }
    }

    public void handleBlue(ActionEvent event) {
        if (blueRadio.isSelected()) {
            blueMatteBox.setDisable(false);
            emptyRadio.setSelected(false);
            updateColor(2, true, false);
        }
        else {
            blueMatteBox.setDisable(true);
            blueMatteBox.setSelected(false);
            updateColor(2, false, false);
        }
    }

    public void handleBlackMatte(ActionEvent event) {
        if (blackMatteBox.isSelected()) {
            updateColor(0, true, true);
        } else {
            updateColor(0, true, false);
        }
    }

    public void handleRedMatte(ActionEvent event) {
        if (redMatteBox.isSelected()) {
            updateColor(1, true, true);
        } else {
            updateColor(1, true, false);
        }
    }

    public void handleBlueMatte(ActionEvent event) {
        if (blueMatteBox.isSelected()) {
            updateColor(2, true, true);
        }
        else {
            updateColor(2, true, false);
        }
    }

    public void updateColor(int colorId, boolean selected, boolean matte) {
        colors[colorId][0] = selected;
        colors[colorId][1] = matte;
    }

    private HashMap<String, Integer> stickers = new HashMap<String, Integer>();

    @FXML
    private ComboBox comboBoxStar;

    @FXML
    private ComboBox comboBoxKiss;

    @FXML
    private ComboBox comboBoxPink;

    @FXML
    private ComboBox comboBoxFerrari;

    public void updateStickers(String name, int quantity) {
        stickers.put(name, quantity);
    }

//    public void handleCalculate(ActionEvent event) {
//        double extra = 0;
//        if (blackRadio.isSelected()) {
//            colors[0][1] = true;
//            if (blackMatteBox.isSelected()) {
//                colors[1][1] = true;
//                extra += Color.BLACK.getPrice() * 1.5;
//            } else {
//                colors[1][1] = false;
//                extra += Color.BLACK.getPrice();
//            }
//        }
//    }

    public void handleBackClick(ActionEvent event) {
    }

    public void handleNextClick(ActionEvent event) {
        SessionManager manager = SessionManager.getSessionManager();
        Session session = manager.getSessionFromId(id);
        String uid = session.getUserId();

        AddonsBean addonsBean = new AddonsBean(stickers, colors);
        controller.addDecorations(dreamGuitarBean, addonsBean);

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/toLuthier.fxml", id, dreamGuitarBean, null);
    }

}
