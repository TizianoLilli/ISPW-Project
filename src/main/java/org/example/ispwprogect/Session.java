package org.example.ispwprogect;

import org.example.ispwprogect.utils.bean.*;

public class Session {

     // DOVREI SALVARCI LE BEAN O I MODEL??
    private final UserBean userBean;
//    private final PremiumUserBean premiumUserBean;
//    private final LuthierBean luthierBean;

    private final int sessionId;

    public UserBean getUserBean() {return userBean;}
//    public PremiumUserBean getPremiumUserBean() {return premiumUserBean;}
//    public LuthierBean getLuthierBean() {return luthierBean;}

    public Session(int id, UserBean userBean) {
        this.userBean = userBean;
//        this.premiumUserBean = premiumUserBean;
//        this.luthierBean = luthierBean;
        this.sessionId = id;
    }

    public int getSessionId() {return sessionId;}
}
