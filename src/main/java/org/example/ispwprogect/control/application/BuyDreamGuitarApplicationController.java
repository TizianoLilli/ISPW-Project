package org.example.ispwprogect.control.application;

import org.example.ispwprogect.model.DreamGuitar;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.enumeration.*;

public class BuyDreamGuitarApplicationController {

    public DreamGuitarBean newDreamGuitar(){
        DreamGuitar guitar = new DreamGuitar();
        return new DreamGuitarBean();
    }

    public void addComponent(DreamGuitarBean dreamGuitarBean, GenericType alternative){

        if (alternative != null) {

                // Pattern Matching
                switch (alternative) {
                    // controllo il tipo dell'oggetto nello switch e assegno automaticamene l'oggetto a pickup in questo caso
                    case PickupType pickup -> {
                        if (dreamGuitarBean.getPickup() != null) {
                            dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getPickup().price());
                        }

                        dreamGuitarBean.setPickup(pickup);

                        // aggiorno il prezzo con l'aggiunta del nuovo componente (prezzo associato all'alternativa selezionata)
                        dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getPickup().price());
                    }
                    case StringsType strings -> {
                        if (dreamGuitarBean.getStrings() != null) {
                            dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getStrings().price());
                        }

                        dreamGuitarBean.setStrings(strings);

                        // aggiorno il prezzo con l'aggiunta del nuovo componente (prezzo associato all'alternativa selezionata)
                        dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getStrings().price());
                    }
                    case NesType nes -> {
                        if (dreamGuitarBean.getNes() != null) {
                            dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getNes().price());
                        }

                        dreamGuitarBean.setNes(nes);

                        // aggiorno il prezzo con l'aggiunta del nuovo componente (prezzo associato all'alternativa selezionata)
                        dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getNes().price());
                    }
                    case FretboardType fretboard -> {
                        if (dreamGuitarBean.getFretboard() != null) {
                            dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getFretboard().price());
                        }

                        dreamGuitarBean.setFretboard(fretboard);

                        // aggiorno il prezzo con l'aggiunta del nuovo componente (prezzo associato all'alternativa selezionata)
                        dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getFretboard().price());
                    }
                    case BridgeType bridge -> {
                        if (dreamGuitarBean.getBridge() != null) {
                            dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getBridge().price());
                        }

                        dreamGuitarBean.setBridge(bridge);

                        // aggiorno il prezzo con l'aggiunta del nuovo componente (prezzo associato all'alternativa selezionata)
                        dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getBridge().price());
                    }
                    case BodyType body -> {
                        if (dreamGuitarBean.getBody() != null) {
                            dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getBody().price());
                        }

                        dreamGuitarBean.setBody(body);

                        // aggiorno il prezzo con l'aggiunta del nuovo componente (prezzo associato all'alternativa selezionata)
                        dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getBody().price());
                    }
                    default -> System.out.println("Invalid alternative type");
                }
        }
    }

    public boolean verifyCompleteness(DreamGuitarBean g){
        return g.getPickup() != null && g.getStrings() != null && g.getNes() != null && g.getFretboard() != null && g.getBody() != null && g.getBridge() != null;
    }

    public void storeDreamGuitar(DreamGuitarBean guitar){
        // dovrei farlo comparire a schermo
        if (!verifyCompleteness(guitar)) {System.out.println("Please, select all the components!");}
    }

//
//    public DreamGuitarBean recoverDreamGuitar(){}

}
