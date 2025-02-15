package org.example.ispwprogect;

import org.example.ispwprogect.utils.dao.DAOFactory;
import org.example.ispwprogect.utils.enumeration.PersistenceProvider;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Config {

    public boolean setPersistenceProvider(Scanner s) {

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
}
