package org.example.ispwprogect;

import org.example.ispwprogect.utils.bean.*;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private List<Session> activeSessions = new ArrayList<Session>();

    private static SessionManager instance = null;

    private int nextId = -1;

    protected SessionManager() {}

    public static SessionManager getSessionManager() {
        if (SessionManager.instance == null) {
            SessionManager.instance = new SessionManager();
        }
        return instance;
    }

    public Session createSession(UserBean userBean) {
        nextId++;
        return new Session(nextId, userBean);
    }

    public Session getSessionFromId(int id){
        for (Session session : activeSessions) {
            if(session.getSessionId() == id){
                return session;
            }
        }
        return null;
    }

    public int getCurrentId() {return nextId;}
    public void addSession(Session session) {activeSessions.add(session);}
    public void removeSession(int id) {activeSessions.removeIf(session -> session.getSessionId() == id);}
}
