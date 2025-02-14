package org.example.ispwprogect.control.application;

import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.model.user.User;
import org.example.ispwprogect.model.user.UserDAO;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.dao.DAOFactory;

public class LoginApplicationController {

    DAOFactory daoFactory;
    UserDAO userD;

    public LoginApplicationController() {
        daoFactory = DAOFactory.getInstance();
        userD = daoFactory.getUserDAO();
    }

    public void register(UserBean userB) {

        // registro gli utenti fittizzi
        User userM = new User(userB);
        userD.create(userM);

    }

    public int login(String username, String password) {
        // entro con le credenziali di un utente preimpostato
        User userM = userD.read(username);
        if (userM != null) {
            if (userM.username().equals(username) && userM.password().equals(password)) {
                SessionManager manager = SessionManager.getSessionManager();
                UserBean userB = new UserBean(userM.username(), userM.password(), userM.role(), userM.email(), userM.address());
                // il controller passa dati all'esterno sotto forma di bean
                Session session = manager.createSession(userB);
                manager.addSession(session);
                return session.getSessionId();
            }
        }
        return -1;
    }

}