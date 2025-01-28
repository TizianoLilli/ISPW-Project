package org.example.ispwprogect.utils.bean;

public class DreamGuitarBean {

    private PickupBean pickupBean;
    private FretboardBean fretboardBean;
    private StringsBean stringsBean;
    private NesBean nesBean;
    private BridgeBean bridgeBean;
    private BodyBean bodyBean;

    private double price;

    public DreamGuitarBean() {this.price = 0;} // inizialmente tutte le componenti sono null

    public PickupBean getPickupBean() {
        return pickupBean;
    }

    public void setPickupBean(PickupBean pickupBean) {
        this.pickupBean = pickupBean;
    }

    public FretboardBean getFretboardBean() {
        return fretboardBean;
    }

    public void setFretboardBean(FretboardBean fretboardBean) {
        this.fretboardBean = fretboardBean;
    }

    public StringsBean getStringsBean() {
        return stringsBean;
    }

    public void setStringsBean(StringsBean stringsBean) {
        this.stringsBean = stringsBean;
    }

    public BodyBean getBodyBean() {
        return bodyBean;
    }

    public void setBodyBean(BodyBean bodyBean) {
        this.bodyBean = bodyBean;
    }

    public BridgeBean getBridgeBean() {
        return bridgeBean;
    }

    public void setBridgeBean(BridgeBean bridgeBean) {
        this.bridgeBean = bridgeBean;
    }

    public NesBean getNesBean() {
        return nesBean;
    }

    public void setNesBean(NesBean nesBean) {
        this.nesBean = nesBean;
    }

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

}
