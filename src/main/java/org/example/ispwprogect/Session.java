package org.example.ispwprogect;

import org.example.ispwprogect.utils.bean.*;

public class Session {

    private final DreamGuitarBean dreamGuitarBean;
    private final PickupBean pickupBean;
    private final FretboardBean fretboardBean;
    private final StringsBean stringsBean;
//    private final NeckEHeadstockBean neckEHeadstockBean;
//    private final BridgeBean bridgeBean;
//    private final BodyBean bodyBean;
    private final IdSessionBean idSessionBean;

    public DreamGuitarBean getDreamGuitarBean() {return dreamGuitarBean;}
    public PickupBean getPickupBean() {return pickupBean;}
    public FretboardBean getFretboardBean() {return fretboardBean;}
    public StringsBean getStringsBean() {return stringsBean;}

    public Session(DreamGuitarBean dreamGuitarBean, PickupBean pickupBean, FretboardBean fretboardBean, StringsBean stringsBean, IdSessionBean idSessioneBean) {
        this.dreamGuitarBean = dreamGuitarBean;
        this.pickupBean = pickupBean;
        this.fretboardBean = fretboardBean;
        this.stringsBean = stringsBean;
        this.idSessionBean = idSessioneBean;
    }

    public IdSessionBean getIdSessionBean() {return idSessionBean;}
}
