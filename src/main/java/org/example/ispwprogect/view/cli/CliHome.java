package org.example.ispwprogect.view.cli;

import javafx.scene.Node;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.control.graphic.buyDreamGuitar.BuyDreamGuitarControllerStart;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.SaveOrRecoverBean;
import org.example.ispwprogect.utils.exception.SystemException;
import org.example.ispwprogect.view.cli.dreamguitar.CliDreamGuitar;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CliHome extends CliController {

    public CliHome() {
        // costruttore vuoto
    }

    private int sessionId;
    private DreamGuitarBean dreamGuitarBean;
    private BuyDreamGuitarApplicationController controller;

    @Override
    public void init(int SessionId, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException {
        this.sessionId = SessionId;
        this.dreamGuitarBean = dreamGuitarBean;

        boolean loopCond = true;  // La variabile deve essere inizializzata a true per avviare il ciclo
        do {
            int choice = userChoice("Home Page");
            switch (choice) {
                case 1:
                    new CliLogin().login(sessionId, dreamGuitarBean);
                    break;
                case 2:
                    controller = new BuyDreamGuitarApplicationController();
                    dreamGuitarBean = controller.newDreamGuitar();
                    checkRetrive();
                    new CliDreamGuitar().init(sessionId, dreamGuitarBean);
                    break;
                case 3:
                    System.out.println("Noticeboard");
//                    Noticeborad.init();
                    break;
                case 4:
                    exit();
                    loopCond = false;  // La variabile viene aggiornata per fermare il ciclo
                    break;
                default:
                    System.out.println("Select a valid option!");
            }
        } while (loopCond);  // Il ciclo continua fino a quando loopCond è true
    }

    public void checkRetrive(){
        SessionManager manager = SessionManager.getSessionManager();
        Session session = manager.getSessionFromId(sessionId);

        SaveOrRecoverBean dataBean = new SaveOrRecoverBean(session.getUserId());
        boolean value = controller.checkGuitar(dataBean);
        CliDreamGuitar.setToRetrieve(value);
    }

    @Override
    protected List<String> getOptions() {
        return List.of(
            "Login",
            "NewDreamGuitar",
            "Noticeboard",
            "Exit"
        );
    }

    private void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
