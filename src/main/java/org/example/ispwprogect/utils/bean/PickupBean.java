package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.PickupType;

public class PickupBean {

    private PickupType features; // contiene price, component, info
//    private String brilliance; // probabilmente va inclusa nell'enum

    public PickupBean(PickupType features){
        this.features = features;
    }

    public double getPrice(){ return features.price(); }

//    public String getType(){ return features.type(); }

    public String getType(){ return features.name();}

    public String getDescription(){
        return features.info();
    }

//    public String getBrilliance() {
//        return this.brilliance;
//    } // vedi che farci (neanche è scritta bene)

}
