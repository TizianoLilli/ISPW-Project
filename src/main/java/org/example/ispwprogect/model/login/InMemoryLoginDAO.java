package org.example.ispwprogect.model.login;

import org.example.ispwprogect.model.user.InMemoryUserDAO;
import org.example.ispwprogect.model.user.User;
import org.example.ispwprogect.model.user.UserDAO;

import java.util.Collection;

public class InMemoryLoginDAO implements LoginDAO {

    private static InMemoryLoginDAO instance;

    private InMemoryLoginDAO() {
        // evito di istanziarlo dall'esterno
    }

    public static LoginDAO getIstance() {
        if (instance == null) {
            instance = new InMemoryLoginDAO();
        }
        return instance;
    }

}
