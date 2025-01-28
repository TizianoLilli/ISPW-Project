package org.example.ispwprogect.utils.enumeration;

public enum BridgeType {

    HARDTAIL(100.0, "Coming soon..."),
    TREMOLO(50.0,  "Coming soon..."),
    TUNEOMATIC(20.0, "Coming soon...");

    private final double price;
//    private static final String type = "Bridge";
    private final String info;

    BridgeType(double price, String info) {
        this.price = price;
        this.info = info;
    }

    public double price() {
        return price;
    }

//    public String type() {
//        return type;
//    }

    public String info() {
        return info;
    }

}
