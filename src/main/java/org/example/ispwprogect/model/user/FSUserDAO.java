package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.decorator.dreamguitar.DBDreamGuitarDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.utils.enumeration.Role;
import org.example.ispwprogect.utils.exception.SystemException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FSUserDAO implements UserDAO {

    private static final String FILE_PATH = "user.csv";
    private static final String DELIMITER = ",";

    @Override
    public void create(User userM) throws SystemException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            // Controlla se l'utente esiste già
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                if (data[0].equals(userM.username())) {
                    return; // Utente già esistente, non aggiungerlo
                }
            }

            // Scrive l'utente nel file
            writer.write(userM.username() + DELIMITER +
                    userM.password() + DELIMITER +
                    userM.role().name() + DELIMITER +
                    userM.email() + DELIMITER +
                    userM.address() + DELIMITER +
                    "-1" + "\n"); // -1 indica nessuna dream guitar
        } catch (IOException e) {
            throw new SystemException("Failed to create user in FS");
        }
    }

    @Override
    public User read(String userId) throws SystemException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                if (data[0].equals(userId)) {
                    int dreamGuitarId = Integer.parseInt(data[5]);
                    DreamGuitar guitar = (dreamGuitarId != -1) ? new DBDreamGuitarDAO().read(dreamGuitarId) : null;

                    User user = new User(data[0], data[1], Role.valueOf(data[2]), data[3], data[4]);
                    user.setDreamGuitar(guitar);
                    return user;
                }
            }
        } catch (IOException e) {
            throw new SystemException("Failed to read user in FS");
        }
        return null;
    }

    @Override
    public void update(User userM, int guitarId) throws SystemException {
        List<String> users = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                if (data[0].equals(userM.username())) {
                    data[5] = String.valueOf(guitarId);
                    updated = true;
                }
                users.add(String.join(DELIMITER, data));
            }
        } catch (IOException e) {
            throw new SystemException("Failed to read users in FS");
        }

        if (!updated) return; // L'utente non esiste, nessun aggiornamento

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String user : users) {
                writer.write(user + "\n");
            }
        } catch (IOException e) {
            throw new SystemException("EFailed to update user in FS");
        }
    }

    @Override
    public void delete(String userId) throws SystemException {
        List<String> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                if (!data[0].equals(userId)) {
                    users.add(line);
                }
            }
        } catch (IOException e) {
            throw new SystemException("Failed to read user in FS");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String user : users) {
                writer.write(user + "\n");
            }
        } catch (IOException e) {
            throw new SystemException("Failed to delete user in FS");
        }
    }
}
