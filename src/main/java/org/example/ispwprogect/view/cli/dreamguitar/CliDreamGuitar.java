package org.example.ispwprogect.view.cli.dreamguitar;

import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.SaveOrRecoverBean;
import org.example.ispwprogect.utils.enumeration.components.*;
import org.example.ispwprogect.utils.exception.SystemException;
import org.example.ispwprogect.view.cli.CliController;
import org.example.ispwprogect.view.cli.CliHome;
import org.example.ispwprogect.view.cli.CliLogin;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CliDreamGuitar extends CliController {

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;

    private int id;
    private String total = "TOT = 0.0$";

    private static boolean toRetrieve = false;

    public static void setToRetrieve(boolean value) {
        toRetrieve = value;
    }

    private void showBanner() {
        Scanner s = new Scanner(System.in);
        int choice = -1;
        boolean ok = false;
        do {
            System.out.println("1) Retrieve");
            System.out.println("2) New Guitar");
            System.out.println("\nPlease enter your choice: ");
            if (s.hasNextInt()) {
                choice = s.nextInt();
                if (choice == 1) {
                    SessionManager manager = SessionManager.getSessionManager();
                    Session session = manager.getSessionFromId(id);
                    String uid = session.getUserId();

                    SaveOrRecoverBean dataBean = new SaveOrRecoverBean(uid);

                    DreamGuitarBean oldGuitar = controller.recoverDreamGuitar(dataBean);
                    if (oldGuitar != null) {
                        this.dreamGuitarBean = oldGuitar;
                    } else {System.out.println("guitar not found");}
                } else if (choice == 2) {

                } else {
                    ok = true;
                }
            }
        } while (ok);
    }

    @Override
    public void init(int sessionId, DreamGuitarBean dreamGuitar) throws SystemException, IOException, LoginException, SQLException {
        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitar;
        this.id = id;

        if (toRetrieve) {
            showBanner();
            boolean value = false;
            setToRetrieve(value);
        }

        if (dreamGuitarBean != null) {
            total = "TOT = " + dreamGuitarBean.getPrice() + "$";
        }

        GenericType alternative;

        alternative = dreamGuitarBean.getComponent("body");
        bodyName = (alternative != null) ? ((BodyType) alternative).name() : "NONE";

        alternative = dreamGuitarBean.getComponent("bridge");
        bridgeName = (alternative != null) ? ((BridgeType) alternative).name() : "NONE";

        alternative = dreamGuitarBean.getComponent("fretboard");
        fretboardName = (alternative != null) ? ((FretboardType) alternative).name() : "NONE";

        alternative = dreamGuitarBean.getComponent("neck&headstock");
        nesName = (alternative != null) ? ((NesType) alternative).name() : "NONE";

        alternative = dreamGuitarBean.getComponent("pickup");
        pickupsName = (alternative != null) ? ((PickupType) alternative).name() : "NONE";

        alternative = dreamGuitarBean.getComponent("strings");
        stringsName = (alternative != null) ? ((StringsType) alternative).name() : "NONE";

        boolean loopCond;
        do {
            loopCond = true;
            int choice = userChoice("Dream Guitar: select a component");
            switch (choice) {
                case 1:
                    new CliBody().init(sessionId, dreamGuitarBean);
                    break;
                case 2:
                    new CliBridge().init(sessionId, dreamGuitarBean);
                    break;
                case 3:
                    new CliFretboard().init(sessionId, dreamGuitarBean);
                    break;
                case 4:
                    new CliNes().init(sessionId, dreamGuitarBean);
                    break;
                case 5:
                    new CliPickup().init(sessionId, dreamGuitarBean);
                    break;
                case 6:
                    new CliStrings().init(sessionId, dreamGuitarBean);
                    break;
                case 7:
                    new CliHome().init(sessionId, dreamGuitarBean);
                    break;
                case 8:
                    SessionManager manager = SessionManager.getSessionManager();
                    Session session = manager.getSessionFromId(id);
                    String uid = session.getUserId();

                    SaveOrRecoverBean dataBean = new SaveOrRecoverBean(uid);

                    if (!controller.saveDreamGuitar(dreamGuitarBean, dataBean)) {
                        System.out.println("Save failed\n");
                        loopCond = false;
                        break;
                    } else {
                        System.out.println("Save successfull\n");
                        new CliToLuthier().init(sessionId, dreamGuitarBean);
                    }
                    break;
                default:
                    System.out.println("Select a valid option!");
                    loopCond = false;
            }
        } while (!loopCond);
    }


    String bodyName;
    String bridgeName;
    String fretboardName;
    String nesName;
    String pickupsName;
    String stringsName;

    @Override
    protected List<String> getOptions() {
        return List.of(
                "Body -> " + bodyName,
                "Bridge -> " + bridgeName,
                "Fretboard -> " + fretboardName,
                "Neck&Headstock -> " + nesName,
                "Pickups -> " + pickupsName,
                "Strings -> " + stringsName,
                "Back",
                "Save"
        );
    }


}

