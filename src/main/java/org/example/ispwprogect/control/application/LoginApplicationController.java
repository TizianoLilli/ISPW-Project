package org.example.ispwprogect.control.application;

import org.example.ispwprogect.model.login.Account;
import org.example.ispwprogect.model.login.AccountDAO;
import org.example.ispwprogect.model.user.User;
import org.example.ispwprogect.model.user.UserDAO;
import org.example.ispwprogect.utils.bean.AccountBean;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.dao.DAOFactory;

public class LoginApplicationController {

    DAOFactory daoFactory;
    UserDAO userD;
    AccountDAO accountD;

    public LoginApplicationController(UserBean userB, AccountBean accountB) {
        daoFactory = DAOFactory.getInstance();
        userD = daoFactory.getUserDAO();

        // prendo i dati dalle bean e ci creo i model
        User userM = new User(userB);
        Account accountM = new Account(accountB);
        accountD.create(accountM);
        if (accountM.userId().equals(userM.username())){
            // collego l'account con lo user relativo e lo salvo
            userM.setAccount(accountM);
            userD.create(userM);
        }  // ECCEZIONE
    }

    public void registration() {}

    public void login(UserBean userB) {
        daoFactory = DAOFactory.getInstance();
        userD = daoFactory.getUserDAO();

        User userM = new User(userB);
        userD.create(userM);
//        if (userD.read(userB.getId()) == null) {
//            userD.create(userM);
//        }
    }

}