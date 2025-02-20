package org.example.ispwprogect.control.application;

import org.example.ispwprogect.Session;
import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.model.user.User;
import org.example.ispwprogect.model.user.UserDAO;
import org.example.ispwprogect.utils.bean.CheckRoleBean;
import org.example.ispwprogect.utils.bean.CredentialBean;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.dao.DAOFactory;
import org.example.ispwprogect.utils.enumeration.Role;

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
        try {
            userD.create(userM);
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        }

    }

    public int login(CredentialBean credB) {
        // entro con le credenziali di un utente preimpostato
        User userM = null;

        String username = credB.getUsername();
        String password = credB.getPassword();
        try {
            userM = userD.read(username);
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        }
        if (userM != null && userM.username().equals(username) && userM.password().equals(password)) {
            SessionManager manager = SessionManager.getSessionManager();
            // il controller passa dati all'esterno sotto forma di bean
            Session session = manager.createSession(username);
            manager.addSession(session);
            return session.getSessionId();
        }
        return -1;
    }

    public boolean checkRole(CheckRoleBean roleB) {
        User userM = null;

        String uid = roleB.getUid();
        Role role = roleB.getRole();
        try {
            userM = userD.read(uid);
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        }
        if (role != userM.role()){
            return false;
        } else {return true;}
    }
}