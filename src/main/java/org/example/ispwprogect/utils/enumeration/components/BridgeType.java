package org.example.ispwprogect.utils.enumeration.components;

public enum BridgeType implements GenericType {

    HARDTAIL(100.0, "Coming soon..."),
    TREMOLO(50.0,  "Coming soon..."),
    TUNEOMATIC(20.0, "Coming soon...");

    private final double price;
    private static final String TYPE = "Bridge";
    private final String info;

    BridgeType(double price, String info) {
        this.price = price;
        this.info = info;
    }

    @Override
    public double price() {
        return price;
    }

    public String type() {
        return TYPE;
    }

    @Override
    public String info() {
        return info;
    }

}
