package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryUserDAO implements UserDAO {

    private static InMemoryUserDAO instance;
    private static Collection<User> usersList;

    private InMemoryUserDAO() {
        // evito di istanziarlo dall'esterno
    }

    public static UserDAO getIstance() {
        if (instance == null) {
            instance = new InMemoryUserDAO();
        }
        return instance;
    }

    //@Override
    public void create(User userM) {
        if (usersList == null) {
            usersList = new ArrayList<User>();
        }
        usersList.add(userM);
    }

/*
    //@Override
    public void delete(String userId) {
        if (usersList != null) {
            for (User u : usersList) {
                if (u.id() == userId) {
                    usersList.remove(u);
                    //aggiungi messaggi di successo
                    return;
                }
            }
        }
    }
*/
}
