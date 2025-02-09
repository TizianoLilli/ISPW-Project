package org.example.ispwprogect.control.application;

import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitarDAO;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.dao.DAOFactory;
import org.example.ispwprogect.utils.enumeration.*;

import java.util.Collection;

public class BuyDreamGuitarApplicationController {

    private DreamGuitarDAO dreamGuitarDAO;

    public DreamGuitarBean newDreamGuitar(){
        DAOFactory daoFactory = DAOFactory.getInstance();
        dreamGuitarDAO = daoFactory.getDreamGuitarDAO();
        //DreamGuitar guitar = new DreamGuitar();
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

    public boolean verifyCompleteness(DreamGuitarBean g){
        Collection<GenericType> all = g.getAllComponents();
        for (GenericType t : all){
            // se mi accorgo che manca un componente esco e lo segnalo
            if (t == null){return false;}
        }
        return true;
    }

    public void saveDreamGuitar(DreamGuitarBean guitarB){
        // dovrei farlo comparire a schermo
        if (!verifyCompleteness(guitarB)) {
            System.out.println("Please, select all the components!");
            return;
        }

        DreamGuitar guitarM = new DreamGuitar(guitarB);
        DreamGuitarDAO guitarD = DAOFactory.getInstance().getDreamGuitarDAO();


    }

//
//    public DreamGuitarBean recoverDreamGuitar(){}

}
