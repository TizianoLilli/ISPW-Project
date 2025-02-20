package org.example.ispwprogect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import org.example.ispwprogect.control.graphic.LoginController;
import org.example.ispwprogect.utils.enumeration.Role;
import org.example.ispwprogect.utils.exception.SystemException;
import org.example.ispwprogect.view.cli.CliHome;
import org.example.ispwprogect.view.cli.CliLogin;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;

public class MyGuitar extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MyGuitar.class.getResource("view/homePage.fxml"));
        Parent root = fxmlLoader.load();

        primaryStage.getIcons().add(new Image("logoApp.png"));

        primaryStage.setTitle("MyGuitar");
        primaryStage.setResizable(false); // Opzionale: finestra non ridimensionabile
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) throws SystemException, SQLException, LoginException, IOException {

        Config conf = new Config();

        // inizializzo il tipo di persistenza in base all'input dell'utente
        if (!conf.setPersistenceProvider()) System.exit(0);

        switch (conf.setUI()){
            case CLI:
                // inizializzo degli utenti fittizzi
                CliLogin account = new CliLogin();
                account.register("ciccio123", "2025a", Role.BASE, "fra@gmail.com", "via del campo 22");
                account.register("clau456", "1000b", Role.PREMIUM, "cla@gmail.com", "via del campo 11");
                account.register("a", "a", Role.PREMIUM, "a@gmail.com", "via a 11");

                new CliHome().init(-1, null);
                break;
            case GUI:
                // inizializzo degli utenti fittizzi
                LoginController registration = new LoginController();
                registration.registerUser("ciccio123", "2025a", Role.BASE, "fra@gmail.com", "via del campo 22");
                registration.registerUser("clau456", "1000b", Role.PREMIUM, "cla@gmail.com", "via del campo 11");
                registration.registerUser("a", "a", Role.PREMIUM, "a@gmail.com", "via a 11");

                launch();
                break;
            // POTREI ANCHE EVITARE QUESTO CASO (IL PROGRAMMA TERMINA DA SOLO)
            case NONE: System.exit(0);
        }

    }
}