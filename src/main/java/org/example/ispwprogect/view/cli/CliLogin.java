package org.example.ispwprogect.view.cli;

import javafx.scene.Node;
import javafx.stage.Stage;
import org.example.ispwprogect.ChangePage;
import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.control.application.LoginApplicationController;
import org.example.ispwprogect.utils.bean.CredentialBean;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.enumeration.Role;
import org.example.ispwprogect.utils.exception.SystemException;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class CliLogin extends CliController {

    private int sessionId;
    private DreamGuitarBean dreamGuitarBean;

    @Override
    public void init(int SessionId, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException {
        this.sessionId = SessionId;
        this.dreamGuitarBean = dreamGuitarBean;
    }

    public void register(String id, String password, Role role, String email, String address) {
        UserBean user = new UserBean(id, password, role, email, address);
        LoginApplicationController controller = new LoginApplicationController();
        controller.register(user);
    }

    public void login(int SessionId, DreamGuitarBean dreamGuitarBean) throws IOException, SystemException, SQLException, LoginException {
        init(SessionId, dreamGuitarBean);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Login");

        System.out.print("Inserisci username: ");
        String username = reader.readLine();

        System.out.print("Inserisci password: ");
        String pwd = reader.readLine();

        LoginApplicationController controller = new LoginApplicationController();
        CredentialBean credential = new CredentialBean(username, pwd);

        sessionId = controller.login(credential);

        SessionManager manager = SessionManager.getSessionManager();
        Session session = manager.getSessionFromId(sessionId);
        System.out.println();

        if (sessionId != -1) {
            System.out.println("Hi, " + session.getUserId());
            new CliHome().init(sessionId, dreamGuitarBean);
        } else {
            System.out.println("Invalid username or password.");
            boolean loopCond = true;
            do {
                int choice = userChoice("Login");
                switch (choice) {
                    case 1:
                    new CliLogin().init(sessionId, dreamGuitarBean);
                        break;
                    case 2:
                        new CliHome().init(sessionId, dreamGuitarBean);
                        break;
                    default:
                        System.out.println("Select a valid option!");
                }
            } while (loopCond);
        }
    }

    @Override
    protected List<String> getOptions() {
        return List.of("Try Again", "Exit");
    }
}
