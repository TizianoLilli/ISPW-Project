package org.example.ispwprogect.control.graphic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView pinoImage;

    @FXML
    private ImageView brittiImage;

    @FXML
    private ImageView celentanoImage;

    @FXML
    private ImageView claptonImage;

    @FXML
    private ImageView ultimoImage;

    @FXML
    private ImageView slashImage;

    public void initialize() {
        // Carica l'immagine
        String pinoImagePath = getClass().getResource("/org/example/ispwprogect/images/guitarists/pino_daniele.jpeg").toExternalForm();
        Image pinoImage = new Image(pinoImagePath);
        this.pinoImage.setImage(pinoImage);

        String brittiImagePath = getClass().getResource("/org/example/ispwprogect/images/guitarists/alex_britti.jpg").toExternalForm();
        Image brittiImage = new Image(brittiImagePath);
        this.brittiImage.setImage(brittiImage);

        String celentanoImagePath = getClass().getResource("/org/example/ispwprogect/images/guitarists/adriano_celentano.jpg").toExternalForm();
        Image celentanoImage = new Image(celentanoImagePath);
        this.celentanoImage.setImage(celentanoImage);

        String claptonImagePath = getClass().getResource("/org/example/ispwprogect/images/guitarists/eric_clapton.jpg").toExternalForm();
        Image claptonImage = new Image(claptonImagePath);
        this.claptonImage.setImage(claptonImage);

        String ultimoImagePath = getClass().getResource("/org/example/ispwprogect/images/guitarists/ultimo.jpg").toExternalForm();
        Image ultimoImage = new Image(ultimoImagePath);
        this.ultimoImage.setImage(ultimoImage);

        String slashImagePath = getClass().getResource("/org/example/ispwprogect/images/guitarists/slash.jpg").toExternalForm();
        Image slashImage = new Image(slashImagePath);
        this.slashImage.setImage(slashImage);
    }

    @FXML
    private void handleSettingsClick() {
        System.out.println("Settings clicked!");
    }

}
