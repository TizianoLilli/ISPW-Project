package org.example.ispwprogect.control.application;

import org.example.ispwprogect.model.DreamGuitar;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;

public class BuyDreamGuitarApplicationController {

    public DreamGuitarBean newDreamGuitar(){
        DreamGuitar guitar = new DreamGuitar();
        return new DreamGuitarBean();
    }

    public void addComponent(){}

//    public void verifyCompleteness(){}
//
//    public DreamGuitarBean recoverDreamGuitar(){}
//
//    public void storeDreamGuitar(DreamGuitarBean bean){}
}
