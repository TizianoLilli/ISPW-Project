package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.SessionManager;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.utils.enumeration.components.GenericType;

import java.util.HashMap;
import java.util.Map;

public class DreamGuitarBean {

    // uso una hash map per memorizzare tutte le componenti e il tipo relativo
    private Map<String, GenericType> components = new HashMap<>();

    private int gid;
    private double price;

    // inizialmente ho una hash map vuota
    public DreamGuitarBean() {
        gid = SessionManager.getSessionManager().curGuitarId();
        setPrice(0);
    }

    public DreamGuitarBean(DreamGuitar guitar) {
        this.components = new HashMap<>(guitar.allComponents());
        this.price = guitar.price();
        this.gid = guitar.id();
    }

    public GenericType getComponent(String key) {return components.get(key);}

    public void setComponent(String key, GenericType type) {
        //aggiunge il nuovo componente (o lo sovrascrive) -> posso avere solo valore collegato a una chiave (quindi solo un'alterativa per tipo)
        components.put(key, type);
    }

    public Map<String, GenericType> getAllComponents(){return components;}

    // POTREI ANCHE IMPLEMENTARLO TRAMITE UNA VARIABILE CHE AUMENTA DI 1 OGNI VOLTA CHE AGGIUNGO UN COMPONENTE (POI FACCIO LA VERIFICA)
    public boolean isFull() {return components.size() == 6;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public int getId() {return gid;}
    public void setId(int id) {this.gid = id;}

}
