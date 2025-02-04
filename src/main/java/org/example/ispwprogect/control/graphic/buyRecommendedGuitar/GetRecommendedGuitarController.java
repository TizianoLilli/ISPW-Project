package org.example.ispwprogect.control.graphic.buyRecommendedGuitar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.IdSessionBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetRecommendedGuitarController extends GraphicController {

    private IdSessionBean id;
    private List<String> selectedGuitarists = new ArrayList<>();
    private org.example.ispwproject.model.MusicShop musicShop;


    public void init(IdSessionBean id, DreamGuitarBean dreamGuitarBean) {
        this.id = id;
        musicShop = new org.example.ispwproject.model.MusicShop();
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
    private CheckBox pinoCheck;

    @FXML
    private CheckBox brittiCheck;

    @FXML
    private CheckBox celentanoCheck;

    @FXML
    private CheckBox claptonCheck;

    @FXML
    private CheckBox ultimoCheck;

    @FXML
    private CheckBox slashCheck;

    @FXML
    private Label pinoLabel;

    @FXML
    private Label brittiLabel;

    @FXML
    private Label celentanoLabel;

    @FXML
    private Label claptonLabel;

    @FXML
    private Label ultimoLabel;

    @FXML
    private Label slashLabel;



    private List<String> getSelectedArtists() {
        List<String> artists = new ArrayList<>();

        if (pinoCheck.isSelected()) artists.add("Pino Daniele");
        if (brittiCheck.isSelected()) artists.add("Alex Britti");
        if (celentanoCheck.isSelected()) artists.add("Adriano Celentano");
        if (claptonCheck.isSelected()) artists.add("Eric Clapton");
        if (ultimoCheck.isSelected()) artists.add("Ultimo");
        if (slashCheck.isSelected()) artists.add("Slash");

        return artists;
    }

    @FXML
    private void handleNextClick(ActionEvent event) {
        List<String> selectedArtists = getSelectedArtists();

        if (musicShop != null) {  // Controlla se musicShop è stato inizializzato
            musicShop.setSelectedArtists(selectedArtists); // Notifica observers
        } else {
            System.out.println("Errore: musicShop non inizializzato.");
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ispwprogect/view/getRecommendedGuitar/selectGuitar.fxml"));
            Parent root = loader.load();

            // Ottieni il controller della nuova scena
            SelectGuitarController controller = loader.getController();

            // Passa i nomi degli artisti selezionati

            controller.init(id, new DreamGuitarBean(), selectedArtists);

            // Cambia la scena
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.show();

        } catch (IOException e) {
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
