package org.example.ispwprogect.view.cli;

import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.exception.SystemException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public abstract class CliController extends GraphicController {

    public CliController() {}

    public abstract void init(int sessionId, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException;

    protected int operationMenu(String title, List<String> options) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.printf(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, options.get(i));
        }

        do {
            System.out.println();
            System.out.printf("Select an option (1-%d): ", options.size());

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > options.size()) {
                    System.out.printf("Please, select a number between (1-%d)", options.size());
                    choice = 0;
                }
            } else {
                System.out.printf("Input not valid. Please, insert a number.");
                scanner.next();
            }
        } while (choice == 0);

        return choice;
    }

    protected abstract List<String> getOptions();

    public int userChoice(String title) {
        List<String> options = getOptions();
        return operationMenu(title + "\n", options);
    }
}
