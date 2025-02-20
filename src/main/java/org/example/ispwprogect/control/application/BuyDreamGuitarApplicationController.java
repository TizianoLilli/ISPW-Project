package org.example.ispwprogect.control.application;

import org.example.ispwprogect.model.decorator.Component;
import org.example.ispwprogect.model.decorator.color.ColorDAO;
import org.example.ispwprogect.model.decorator.color.ColorDecorator;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitarDAO;
import org.example.ispwprogect.model.decorator.sticker.StickerDAO;
import org.example.ispwprogect.model.decorator.sticker.StickerDecorator;
import org.example.ispwprogect.model.user.User;
import org.example.ispwprogect.model.user.UserDAO;
import org.example.ispwprogect.utils.bean.AddComponentBean;
import org.example.ispwprogect.utils.bean.AddonsBean;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.SaveOrRecoverBean;
import org.example.ispwprogect.utils.dao.DAOFactory;
import org.example.ispwprogect.utils.enumeration.Color;
import org.example.ispwprogect.utils.enumeration.components.GenericType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BuyDreamGuitarApplicationController {

    private DAOFactory daoFactory;
    private UserDAO userDAO;
    private DreamGuitarDAO dreamGuitarDAO;
    private StickerDAO stickerDAO;
    private ColorDAO colorDAO;

    public BuyDreamGuitarApplicationController() {
        daoFactory = DAOFactory.getInstance();
        userDAO = daoFactory.getUserDAO();
        dreamGuitarDAO = daoFactory.getDreamGuitarDAO();
        stickerDAO = daoFactory.getStickerDAO();
        colorDAO = daoFactory.getColorDAO();
    }

    public DreamGuitarBean newDreamGuitar(){
        return new DreamGuitarBean();
    }

    public void addComponent(DreamGuitarBean guitar, AddComponentBean a){

        String component = a.getComponentKey();
        GenericType alternative = a.getAlternative();

        if (alternative != null) {
            // tolgo il prezzo della vecchia alternativa (se presente)
            GenericType oldComponent = guitar.getComponent(component);
            if (oldComponent != null) {
                guitar.setPrice(guitar.getPrice() - oldComponent.price());
            }

            // aggiungo la nuova alternativa e aggiorno il prezzo
            guitar.setComponent(component, alternative);
            guitar.setPrice(guitar.getPrice() + alternative.price());
        }
    }

    private Component fullGuitar;

    public void registerGuitar(Component guitar){this.fullGuitar = guitar;}

    private HashMap<String, Integer> stickers = new HashMap<>();
    private List<Color> type = new ArrayList<>();

    public double addDecorations(DreamGuitarBean guitarB, AddonsBean addonsB){
        DreamGuitar guitarM = new DreamGuitar(guitarB);
        registerGuitar(guitarM);

        stickers = addonsB.getStickerMap();
        for (String key : stickers.keySet()) {
            Integer value = stickers.get(key);
            for (int i=0; i < value; i++) {
                fullGuitar = new StickerDecorator(fullGuitar, key);
            }
        }

        boolean[][] colors = addonsB.getColorArray();
        // metto tutti i colori di Color in una lista
        type = new ArrayList<>(Arrays.asList(Color.values()));
        for (int x = 0; x < colors.length; x++) {
            // se il colore è selezionato
            if (colors[x][0]) {
                boolean matte = colors[x][1];
                fullGuitar = new ColorDecorator(fullGuitar, type.get(x), matte);
            }
        }

        // ORA DOVREI CHIAMARE LE DAO PER SALVARE
        return fullGuitar.price();
    }

    public boolean saveDreamGuitar(DreamGuitarBean guitarB, SaveOrRecoverBean dataB){

        String uid = dataB.getUserId();

        if (!guitarB.isFull()) {
            System.out.println("Please, select all the components!");
            return false;
        }

        System.out.println(guitarB.getId());
        DreamGuitar guitarM = new DreamGuitar(guitarB);
        try {
            System.out.println(guitarM.id());
            dreamGuitarDAO.create(guitarM);
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        }
        User userM = null;
        try {
            userM = userDAO.read(uid);
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        }
        try {
            userDAO.update(userM, guitarM.id());
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    // per verificare se un utente ha una chitarra associata
    public boolean checkGuitar(SaveOrRecoverBean dataB){
        User userM = null;
        String id = dataB.getUserId();
        try {
            userM = userDAO.read(id);
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        }
        DreamGuitar guitarM = userM.dreamGuitar();
        return guitarM != null;
    }

    public DreamGuitarBean recoverDreamGuitar(SaveOrRecoverBean dataB) {
        User userM = null;
        String uid = dataB.getUserId();
        try {
            userM = userDAO.read(uid);
        } catch (org.example.ispwprogect.utils.exception.SystemException e) {
            throw new RuntimeException(e);
        }
        DreamGuitar guitarM = userM.dreamGuitar();
        if (guitarM != null) {
            // la devo passare al controller grafico
            DreamGuitarBean guitarB = new DreamGuitarBean(guitarM);
            return guitarB;
        } // altrimenti continuo con una nuova chitarra
        return null;
    }

}
