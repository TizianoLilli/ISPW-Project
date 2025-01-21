package org.example.ispwprogect;

//attualmente contiene tutte le pagine FXML di buyDreamGuitar

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class BuyDreamGuitarController {

    @FXML private Button bodyButton;

    @FXML private Button bridgeButton;

    @FXML private Button pickupsButton;

    @FXML private Button fretboardButton;

    @FXML private Button stringsButton;

    @FXML private Button nesButton;

    @FXML private Button backButtonStart;

    @FXML private Button backButton;

    private Map<Button, String> page = new HashMap<>();

    @FXML
    private void initialize() {

        page.put(bodyButton, "view/buyDreamGuitarBo.fxml");
        page.put(bridgeButton, "view/buyDreamGuitarBr.fxml");
        page.put(pickupsButton, "view/buyDreamGuitarP.fxml");
        page.put(fretboardButton, "view/buyDreamGuitarF.fxml");
        page.put(stringsButton, "view/buyDreamGuitarS.fxml");
        page.put(nesButton, "view/buyDreamGuitarNH.fxml");

        page.put(backButtonStart, "view/homePage.fxml");
        page.put(backButton, "view/buyDreamGuitarStart.fxml");

    }

    @FXML
    private void handleClick(ActionEvent event) {

        Button clickedButton = (Button) event.getSource();
        String fxmlFile = page.get(clickedButton);

        if (fxmlFile != null) {
            changePage(fxmlFile, event);
        }

    }

    private void changePage(String fxmlFile, ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene newScene = new Scene(loader.load());
            Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
