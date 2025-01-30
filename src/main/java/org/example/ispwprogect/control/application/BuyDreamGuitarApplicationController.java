package org.example.ispwprogect.control.application;

import org.example.ispwprogect.model.DreamGuitar;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.bean.PickupBean;
import org.example.ispwprogect.utils.bean.StringsBean;
import org.example.ispwprogect.utils.enumeration.PickupType;
import org.example.ispwprogect.utils.enumeration.StringsType;

public class BuyDreamGuitarApplicationController {

    public DreamGuitarBean newDreamGuitar(){
        DreamGuitar guitar = new DreamGuitar();
        return new DreamGuitarBean();
    }

    public void addPickup(DreamGuitarBean dreamGuitarBean, PickupType alternative){

        if (alternative != null) {

            if (dreamGuitarBean.getPickupBean() != null) {
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getPickupBean().getPrice());
            }

            PickupBean pickupBean = new PickupBean(alternative);
            dreamGuitarBean.setPickupBean(pickupBean);

            // aggiorno il prezzo con l'aggiunta del nuovo componente (prezzo associato all'alternativa selezionata)
            dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getPickupBean().getPrice());
        }

    }

    public void addStrings(DreamGuitarBean dreamGuitarBean, StringsType alternative){

        if (alternative != null) {

            if (dreamGuitarBean.getStringsBean() != null) {
                dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() - dreamGuitarBean.getStringsBean().getPrice());
            }

            StringsBean stringsBean = new StringsBean(alternative);
            dreamGuitarBean.setStringsBean(stringsBean);

            // aggiorno il prezzo con l'aggiunta del nuovo componente (prezzo associato all'alternativa selezionata)
            dreamGuitarBean.setPrice(dreamGuitarBean.getPrice() + dreamGuitarBean.getStringsBean().getPrice());
        }

    }

//    public void verifyCompleteness(){}
//
//    public DreamGuitarBean recoverDreamGuitar(){}
//
//    public void storeDreamGuitar(DreamGuitarBean bean){}
}
