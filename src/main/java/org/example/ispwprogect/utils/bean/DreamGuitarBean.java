package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DreamGuitarBean {

    // uso una hash map per memorizzare tutte le componenti e il tipo relativo
    private final Map<String, GenericType> components = new HashMap<>();

    private double price;

    public DreamGuitarBean() {setPrice(0);} // inizialmente tutte le componenti sono null

    public GenericType getComponent(String key) {return components.get(key);}

    public void setComponent(String key, GenericType type) {
        if (components == null) return;
        //aggiunge il nuovo componente (o lo sovrascrive) -> posso avere solo valore collegato a una chiave (quindi solo un'alterativa per tipo)
        components.put(key, type);
    }

    public Collection<GenericType> getAllComponents(){return components.values();}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

}
