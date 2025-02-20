package org.example.ispwprogect;

import org.example.ispwprogect.utils.dao.DAOFactory;
import org.example.ispwprogect.utils.enumeration.PersistenceProvider;
import org.example.ispwprogect.utils.enumeration.Ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Config {

    public boolean setPersistenceProvider() {

        Scanner s = new Scanner(System.in);
        PersistenceProvider provider = null;
        boolean ok = false;

        while (!ok){
            try {
                System.out.println("Select a Persistence Provider (1-4): \n1. In Memory\n2. File System\n3. DBMS\n4. Exit");
                int choice = Integer.parseInt(String.valueOf(s.nextInt()));
                ok = true;
                switch (choice) {
                    case 1:
                        provider = PersistenceProvider.IN_MEMORY;
                        break;
                    case 2:
                        provider = PersistenceProvider.FS;
                        break;
                    case 3:
                        provider = PersistenceProvider.DB;
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        s.close();
                        return false;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        ok = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                s.nextLine();
            }
        }

        System.out.println("Using " + provider.name() + " Persistence Provider");

        DAOFactory.setPersistenceProvider(provider);
        return true;
    }

    public Ui setUI() {
        Scanner s = new Scanner(System.in);
        int uiValue = -1;

        while (uiValue == -1) {
            try {
                System.out.println("Select a UI (1-3): \n1. GUI\n2. CLI\n3. Exit");
                uiValue = s.nextInt();

                switch (uiValue) {
                    case 1:
                        System.out.println("Using GUI");
                        break;
                    case 2:
                        System.out.println("Using CLI");
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return Ui.NONE;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        uiValue = -1;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                s.nextLine();
            }
        }

        return Ui.fromInt(uiValue);  // restituire l'enum

    }
}
