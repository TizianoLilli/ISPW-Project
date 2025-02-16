package org.example.ispwprogect;

import org.example.ispwprogect.utils.bean.*;

public class Session {

    private String uid;
//    private final PremiumUserBean premiumUserBean;
//    private final LuthierBean luthierBean;

    private final int sessionId;

    public String getUserId() {return uid;}
//    public PremiumUserBean getPremiumUserBean() {return premiumUserBean;}
//    public LuthierBean getLuthierBean() {return luthierBean;}

    public Session(int id, String uid) {
        this.uid = uid;
//        this.premiumUserBean = premiumUserBean;
//        this.luthierBean = luthierBean;
        this.sessionId = id;
    }

    public int getSessionId() {return sessionId;}
}
