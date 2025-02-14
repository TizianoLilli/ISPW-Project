package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.decorator.dreamguitar.InMemoryDreamGuitarDAO;

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
    public void create(User userM) {
        usersList.add(userM);
    }


    // mantengo il rifermento alla dao account: accedo per indirizzo (non valore) allo username
    @Override
    public User read(String userId){
        for (User u : usersList) {
            if (u.username().equals(userId)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Collection<User> readAll() {
        return usersList;
    }

    // aggiorno l'utente aggiungendo una dream guitar
    @Override
    public void update(User userM, int guitarId){
        delete(userM.username());
        // user dao interagisce con la dao della chitarra
        userM.setDreamGuitar(InMemoryDreamGuitarDAO.getInstance().read(guitarId));
        usersList.add(userM);
    }

    @Override
    public void delete(String userId) {
        usersList.remove(read(userId));
    }

}
