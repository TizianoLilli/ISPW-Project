package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.login.Account;
import org.example.ispwprogect.model.login.AccountDAO;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryUserDAO implements UserDAO {

    private static InMemoryUserDAO instance;

    private InMemoryUserDAO() {
        // evito di istanziarlo dall'esterno
    }

    public static UserDAO getIstance() {
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
    public User read(String userId, AccountDAO accountD){
        for (User u : usersList) {
            if (u.username().equals(userId)) {
                Account a = accountD.read(userId);
                u.setAccount(a);
                return u;
            }
        }
        return null;
    }

    @Override
    public Collection<User> readAll() {
        return usersList;
    }

//    // PER ADESSO FA LA SESSA COSA DEL CREATE
//    @Override
//    public void update(User userM){
//        if (usersMap.containsKey(userM.username())) {
//            usersMap.put(userM.username(), userM);
//        }
//    }

    @Override
    public void delete(String userId) {
        for (User u : usersList) {
            if (u.username().equals(userId)) {
                usersList.remove(u);
            }
        }
    }

}
