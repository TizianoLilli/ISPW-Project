package org.example.ispwprogect;

import org.example.ispwprogect.utils.bean.*;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private List<Session> activeSessions = new ArrayList<Session>();

    private static SessionManager instance = null;

    protected SessionManager(int i) {}

    public static SessionManager getSessionManager() {
        if (SessionManager.instance == null) {
            SessionManager.instance = new SessionManager(0);
        }
        return instance;
    }

    public Session createSession(DreamGuitarBean dreamGuitarBean, PickupBean pickupBean, FretboardBean fretboardBean, StringsBean stringsBean, IdSessionBean idSessioneBean) {
        return new Session(dreamGuitarBean, pickupBean, fretboardBean, stringsBean, idSessioneBean);
    }

    public Session getSessionFromId(IdSessionBean id){
        for (Session session : activeSessions) {
            if(session.getIdSessionBean().getId() == id.getId()){
                return session;
            }
        }
        return null;
    }

    public void newSession(Session session) {activeSessions.add(session);}
    public void removeSession(IdSessionBean id) {activeSessions.removeIf(session -> session.getIdSessionBean().getId() == id.getId());}
}
