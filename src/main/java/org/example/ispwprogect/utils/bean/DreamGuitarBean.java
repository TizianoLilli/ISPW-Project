package org.example.ispwprogect.utils.bean;

public class DreamGuitarBean {

    private PickupBean pickupBean;
    private FretboardBean fretboardBean;
    private StringsBean stringsBean;
//    private NeckEHeadstockBean neckEHeadstockBean;
//    private BridgeBean bridgeBean;
//    private BodyBean bodyBean;

    public DreamGuitarBean(PickupBean pickupBean, FretboardBean fretboardBean, StringsBean stringsBean) {
        this.pickupBean = pickupBean;
        this.fretboardBean = fretboardBean;
        this.stringsBean = stringsBean;
    }

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
}
