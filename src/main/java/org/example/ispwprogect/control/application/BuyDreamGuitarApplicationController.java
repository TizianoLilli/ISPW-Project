package org.example.ispwprogect.control.application;

import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.control.graphic.buyDreamGuitar.BuyDreamGuitarControllerStart;
import org.example.ispwprogect.model.decorator.Component;
import org.example.ispwprogect.model.decorator.color.ColorDecorator;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitarDAO;
import org.example.ispwprogect.model.decorator.sticker.StickerDecorator;
import org.example.ispwprogect.model.user.User;
import org.example.ispwprogect.model.user.UserDAO;
import org.example.ispwprogect.utils.bean.AddonsBean;
import org.example.ispwprogect.utils.bean.ColorBean;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.dao.DAOFactory;
import org.example.ispwprogect.utils.enumeration.components.GenericType;

import java.util.HashMap;
import java.util.Set;

public class BuyDreamGuitarApplicationController {

    private DAOFactory daoFactory;
    private UserDAO userDAO;
    private DreamGuitarDAO dreamGuitarDAO;

    public BuyDreamGuitarApplicationController() {
        daoFactory = DAOFactory.getInstance();
        userDAO = daoFactory.getUserDAO();
        dreamGuitarDAO = daoFactory.getDreamGuitarDAO();
    }

    public DreamGuitarBean newDreamGuitar(){
        return new DreamGuitarBean();
    }

    public void addComponent(DreamGuitarBean guitar, String componentKey, GenericType alternative){

        if (alternative != null) {
            // tolgo il prezzo della vecchia alternativa (se presente)
            GenericType oldComponent = guitar.getComponent(componentKey);
            if (oldComponent != null) {
                guitar.setPrice(guitar.getPrice() - oldComponent.price());
            }

            // aggiungo la nuova alternativa e aggiorno il prezzo
            guitar.setComponent(componentKey, alternative);
            guitar.setPrice(guitar.getPrice() + alternative.price());
        }
    }

    private Component fullGuitar;

    public void registerGuitar(Component guitar){this.fullGuitar = guitar;}

    //POTREI ANCHE FARLA PRIVATA CHIAMATA DA SAVE GUITAR
    //POTREI ANCHE PASSARE COME PARAMETRO UNA LSTA DI DECORATOR
    public void addDecorations(DreamGuitarBean guitarB, AddonsBean addonsB){
        DreamGuitar guitarM = new DreamGuitar(guitarB);
        registerGuitar(guitarM);

        HashMap<String, Integer> stickers = addonsB.getStickerMap();
        for (String key : stickers.keySet()) {
            fullGuitar = new StickerDecorator(fullGuitar, stickerBean);
        }

        if (colorB != null) {
            fullGuitar = new ColorDecorator(fullGuitar, colorB);
        }
        double finalPrice = fullGuitar.price();
        // NON SO SE ORA DOVREI CHIAMARE LA DAO DELLA CHITARRA PER SALVARE
    }

    public boolean saveDreamGuitar(DreamGuitarBean guitarB, String uid){

        if (!guitarB.isFull()) {
            System.out.println("Please, select all the components!");
            return false;
        }

        DreamGuitar guitarM = new DreamGuitar(guitarB);
        dreamGuitarDAO.create(guitarM);
        User userM = userDAO.read(uid);
        userDAO.update(userM, guitarM.id());

        return true;
    }

    // per verificare se un utente ha una chitarra associata
    public boolean checkGuitar(String id){
        User userM = userDAO.read(id);
        DreamGuitar guitarM = userM.dreamGuitar();
        return guitarM != null;
    }

    public DreamGuitarBean recoverDreamGuitar(String uid) {
        User userM = userDAO.read(uid);
        DreamGuitar guitarM = userM.dreamGuitar();
        if (guitarM != null) {
            // la devo passare al controller grafico
            DreamGuitarBean guitarB = new DreamGuitarBean(guitarM);
            return guitarB;
        } // altrimenti continuo con una nuova chitarra
        return null;
    }

}
