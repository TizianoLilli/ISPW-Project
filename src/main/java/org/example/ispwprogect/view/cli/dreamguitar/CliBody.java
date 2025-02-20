package org.example.ispwprogect.view.cli.dreamguitar;

import org.example.ispwprogect.control.application.BuyDreamGuitarApplicationController;
import org.example.ispwprogect.utils.bean.AddComponentBean;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.enumeration.components.BodyType;
import org.example.ispwprogect.utils.exception.SystemException;
import org.example.ispwprogect.view.cli.CliController;
import org.example.ispwprogect.view.cli.CliHome;
import org.example.ispwprogect.view.cli.CliLogin;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CliBody extends CliController {

    private BuyDreamGuitarApplicationController controller;
    private DreamGuitarBean dreamGuitarBean;

    private int id;
    private String total = "TOT = 0.0$";

    @Override
    public void init(int id, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException {

        controller = new BuyDreamGuitarApplicationController();
        this.dreamGuitarBean = dreamGuitarBean;
        this.id = id;

        try {
            BodyType alternative = null;

            boolean loopCond = true;
            do {
                int choice = userChoice("Body: select an alternative");
                switch (choice) {
                    case 1:
                        alternative = BodyType.MAPLE;
                        break;
                    case 2:
                        alternative = BodyType.MAHOGANY;
                        break;
                    case 3:
                        alternative = BodyType.ASH;
                        break;
                    case 4:
                        new CliHome().init(id, dreamGuitarBean);
                        break;
                    default:
                        System.out.println("Select a valid option!");
                        loopCond = false;
                }
            } while (!loopCond);

            AddComponentBean addComponentBean = new AddComponentBean("body", alternative);
            controller.addComponent(dreamGuitarBean, addComponentBean);

        } catch (Exception e) {
        throw new RuntimeException(e);
        }

        if (dreamGuitarBean != null) {
            total = "TOT = " + dreamGuitarBean.getPrice() + "$\n";
        }

        System.out.println(total);
        new CliDreamGuitar().init(id, dreamGuitarBean);
    }

    @Override
    protected List<String> getOptions() {
        return List.of(
                "Maple: +100$",
                "Mahogany: +50$",
                "Ash: +20$"
        );
    }
}
