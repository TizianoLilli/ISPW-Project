package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.*;

public class DreamGuitarBean {

    private PickupType pickup;
    private FretboardType fretboard;
    private StringsType strings;
    private NesType nes;
    private BridgeType bridge;
    private BodyType body;

    private double price;

    public DreamGuitarBean() {setPrice(0);} // inizialmente tutte le componenti sono null

    public PickupType getPickup() {
        return pickup;
    }

    public void setPickup(PickupType pickup) {
        this.pickup = pickup;
    }

    public FretboardType getFretboard() {
        return fretboard;
    }

    public void setFretboard(FretboardType fretboard) {
        this.fretboard = fretboard;
    }

    public StringsType getStrings() {
        return strings;
    }

    public void setStrings(StringsType strings) {
        this.strings = strings;
    }

    public BodyType getBody() {
        return body;
    }

    public void setBody(BodyType body) {
        this.body = body;
    }

    public BridgeType getBridge() {
        return bridge;
    }

    public void setBridge(BridgeType bridge) {
        this.bridge = bridge;
    }

    public NesType getNes() {
        return nes;
    }

    public void setNes(NesType nes) {
        this.nes = nes;
    }

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

}
