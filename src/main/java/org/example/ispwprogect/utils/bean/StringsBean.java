package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.StringsType;

public class StringsBean {

    private StringsType features; // contiene price, component, info
//    private String brilliance; // probabilmente va inclusa nell'enum

    public StringsBean(StringsType features){
        this.features = features;
    }

    public double getPrice(){ return features.price(); }

    public String getType(){ return features.type(); }

    public String getDescription(){
        return features.info();
    }

//    public String getBrilliance() {
//        return this.brilliance;
//    } // vedi che farci (neanche è scritta bene)

}
