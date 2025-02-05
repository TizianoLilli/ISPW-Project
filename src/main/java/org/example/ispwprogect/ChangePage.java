package org.example.ispwprogect;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.*;

public class ChangePage {

    private static ChangePage istanza = null;

    protected ChangePage(){}

    public static ChangePage getChangePage(){
        if (ChangePage.istanza == null) {
            ChangePage.istanza = new ChangePage();
        }
        return istanza;
    }

    private Stage stage;

    public void changeDreamGuitar(String fxml, IdSessionBean id, DreamGuitarBean dreamGuitarBean) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Scene newScene=null;

        try{
            newScene = new Scene(loader.load());
        }catch (Exception e) {
            e.printStackTrace();
        }
        //Uso del polimorfismo, uso una variabile di tipo ControllerGrafico (superclasse)
        //alla quale in base al pagina caricata associo l'istanza di uno dei controller grafici figli
        //l'operazione inizializza quindi avrà comportamenti diversi in base all'istanza
        GraphicController controller = loader.getController();
        controller.initDreamGuitar(id, dreamGuitarBean);
        this.stage.setScene(newScene);
        this.stage.show();


    }

    public void changeRecommendedGuitar(String fxml, IdSessionBean id, RecommendedGuitarBean recommendedGuitarBean) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Scene newScene = null;

        try {
            newScene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        GraphicController controller = loader.getController();
        controller.initRecommendedGuitar(id, recommendedGuitarBean); // Usa il nuovo init con RecommendedGuitarBean
        this.stage.setScene(newScene);
        this.stage.show();
    }


    public void setStage(Stage stageParam){
        this.stage=stageParam;
    }

    public Stage getStage(){
        return this.stage;
    }
}
