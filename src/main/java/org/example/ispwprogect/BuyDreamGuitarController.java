package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class BuyDreamGuitarController {

    //le seguenti linee non funzionano!
    // Carico l'immagine dall'fxml (probabilmente invece vorrei farlo da quì dopo che clicco un bottone)
    @FXML
    private ImageView humbuckerImage;

    public void initialize(URL location, ResourceBundle resources) {
        // Carica l'immagine e impostala nell'ImageView
        Image humbucker = new Image("file:main/java/org/example/ispwprogect/images/humbucker.png");
        humbuckerImage.setImage(humbucker);
    }

}
