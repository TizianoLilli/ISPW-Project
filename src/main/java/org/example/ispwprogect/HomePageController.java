package org.example.ispwprogect;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;


import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController extends GraphicController {

    @FXML
    private ImageView bannerImage;

    public void init(IdSessionBean id, DreamGuitarBean dreamGuitarBean){
        // Carica l'immagine e impostala nell'ImageView
        Image banner = new Image("file:main/java/org/example/ispwprogect/images/banner.jpg");
        bannerImage.setImage(banner);
    }

}