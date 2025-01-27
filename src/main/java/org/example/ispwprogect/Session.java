package org.example.ispwprogect;

import org.example.ispwprogect.utils.bean.*;

public class Session {

//    private final UserBean userBean;
//    private final PremiumUserBean premiumUserBean;
//    private final LuthierBean luthierBean;

    private final IdSessionBean idSessionBean;

//    public UserBean getUserBean() {return userBean;}
//    public PremiumUserBean getPremiumUserBean() {return premiumUserBean;}
//    public LuthierBean getLuthierBean() {return luthierBean;}

    public Session(IdSessionBean idSessioneBean) {
//        this.userBean = userBean;
//        this.premiumUserBean = premiumUserBean;
//        this.luthierBean = luthierBean;
        this.idSessionBean = idSessioneBean;
    }

    public IdSessionBean getIdSessionBean() {return idSessionBean;}
}
