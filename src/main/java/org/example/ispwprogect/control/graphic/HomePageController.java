package org.example.ispwprogect.control.graphic;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import javafx.event.ActionEvent;
import org.example.ispwprogect.utils.bean.RecommendedGuitarBean;

public class HomePageController extends GraphicController {

    @FXML
    private ImageView bannerImage;


    @Override
    public void init(int id, DreamGuitarBean dreamGuitarBean, RecommendedGuitarBean recommendedGuitarBean){
        // Carica l'immagine e impostala nell'ImageView
        Image banner = new Image("file:main/java/org/example/ispwprogect/images/banner.jpg");
        bannerImage.setImage(banner);
        this.id = id;
    }

    private int id;

    @FXML
    public void handleClick(ActionEvent event){

        BuyDreamGuitarApplicationController controller = new BuyDreamGuitarApplicationController();
        DreamGuitarBean dreamGuitarBean = controller.newDreamGuitar();

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ChangePage istanza = ChangePage.getChangePage();
        istanza.setStage(currentStage);
        istanza.change("view/buyDreamGuitar/buyDreamGuitarStart.fxml", id, dreamGuitarBean, null);

    }

}