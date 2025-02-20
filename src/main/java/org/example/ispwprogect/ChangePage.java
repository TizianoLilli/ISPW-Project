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

    public void change(String fxml, int id, DreamGuitarBean dreamGuitarBean) {
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
        try {
            controller.init(id, dreamGuitarBean);
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        } catch (javax.security.auth.login.LoginException e) {
            throw new RuntimeException(e);
        } catch (java.sql.SQLException throwables) {
            throw new RuntimeException(throwables);
        }
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
