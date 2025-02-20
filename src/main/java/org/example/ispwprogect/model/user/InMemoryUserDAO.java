package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.decorator.dreamguitar.InMemoryDreamGuitarDAO;
import org.example.ispwprogect.utils.exception.SystemException;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryUserDAO implements UserDAO {

    private static InMemoryUserDAO instance;

    private InMemoryUserDAO() {
        // evito di istanziarlo dall'esterno
    }

    public static InMemoryUserDAO getIstance() {
        if (instance == null) {
            instance = new InMemoryUserDAO();
        }
        return instance;
    }

    private Collection<User> usersList = new ArrayList<>();

    // funziona anche come update
    @Override
    public void create(User userM) throws SystemException {
        usersList.add(userM);
    }

    // mantengo il rifermento alla dao account: accedo per indirizzo (non valore) allo username
    @Override
    public User read(String userId) throws SystemException {
        for (User u : usersList) {
            if (u.username().equals(userId)) {
                return u;
            }
        }
        return null;
    }

    // aggiorno l'utente aggiungendo una dream guitar
    @Override
    public void update(User userM, int guitarId) throws SystemException {
        delete(userM.username());
        // user dao interagisce con la dao della chitarra
        userM.setDreamGuitar(InMemoryDreamGuitarDAO.getInstance().read(guitarId));
        usersList.add(userM);
    }

    @Override
    public void delete(String userId) throws SystemException {
        try {
            usersList.remove(read(userId));
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }

}
