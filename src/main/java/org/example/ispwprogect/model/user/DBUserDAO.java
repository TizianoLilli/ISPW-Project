package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.decorator.dreamguitar.DBDreamGuitarDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.utils.db.ConnectionDB;
import org.example.ispwprogect.utils.enumeration.Role;
import org.example.ispwprogect.utils.exception.SystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUserDAO implements UserDAO {

    @Override
    public void create(User userM) throws SystemException {

        String checkUserQuery = "SELECT COUNT(*) FROM users WHERE username = ?";
        String insertUserQuery = "INSERT INTO users (username, password, role, email, address, dream_guitar_id) VALUES (?, ?, ?, ?, ?, NULL)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement checkStmt = connection.prepareStatement(checkUserQuery);
             PreparedStatement insertStmt = connection.prepareStatement(insertUserQuery)) {

            checkStmt.setString(1, userM.username());
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                insertStmt.setString(1, userM.username());
                insertStmt.setString(2, userM.password());
                // Ruolo come stringa
                insertStmt.setString(3, userM.role().name());
                insertStmt.setString(4, userM.email());
                insertStmt.setString(5, userM.address());

                insertStmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new SystemException("Errore durante l'inserimento dell'utente nel database");
        }
    }

    @Override
    public User read(String userId) throws SystemException {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int dreamGuitarId = resultSet.getInt("dream_guitar_id");
                System.out.println(dreamGuitarId);
                DreamGuitar guitar = dreamGuitarId != -1 ? new DBDreamGuitarDAO().read(dreamGuitarId) : null;

                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                // trasformo la stringa in un enum Role
                Role role = Role.valueOf(resultSet.getString("role"));
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                // Crea e restituisci l'utente
                User user = new User(username, password, role, email, address);
                user.setDreamGuitar(guitar);
                return user;
            } else {
                return null;  // Utente non trovato
            }
        } catch (SQLException e) {
            throw new SystemException("Errore durante la lettura dell'utente dal database");
        }
    }

//    @Override
//    public Collection<User> readAll() throws SystemException {
//        return List.of();
//    }

    @Override
    public void update(User userM, int guitarId) throws SystemException {
        String query = "UPDATE users SET dream_guitar_id = ? WHERE username = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            deleteGuitar(userM);
            statement.setInt(1, guitarId);
            statement.setString(2, userM.username());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SystemException("Errore durante l'aggiornamento dell'utente nel database");
        }
    }

    private void deleteGuitar(User userM) throws SystemException {
        String query = "UPDATE users SET dream_guitar_id = NULL WHERE username = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userM.username());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SystemException("Errore durante la rimozione della chitarra dei sogni dell'utente nel database");
        }
    }

    @Override
    public void delete(String userId) throws SystemException {
        String query = "DELETE FROM users WHERE username = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SystemException("Errore durante la cancellazione dell'utente dal database");
        }

    }
}
