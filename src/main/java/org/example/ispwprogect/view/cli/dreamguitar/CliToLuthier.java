package org.example.ispwprogect.view.cli.dreamguitar;

import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.exception.SystemException;
import org.example.ispwprogect.view.cli.CliController;
import org.example.ispwprogect.view.cli.CliHome;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CliToLuthier extends CliController {

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;

    private int id;

    @Override
    public void init(int sessionId, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException {
        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;

        boolean loopCond = true;
        do {
            int choice = userChoice("Dream Guitar: obtain your guitar or share it");
            switch (choice) {
                case 1:
                    System.out.println("Contacting Luthier ...");
                    break;
                case 2:
                    System.out.println("Sharing Dream Guitar ...");
                    break;
                case 3:
                    new CliHome().init(sessionId, dreamGuitarBean);
                    break;
                default:
                    System.out.println("Select a valid option!");
                    loopCond = false;
            }
        } while (!loopCond);
    }

    @Override
    protected List<String> getOptions() {
        return List.of(
                "Contact Luthier",
                "Publish Guitar",
                "Home"
        );
    }
}
