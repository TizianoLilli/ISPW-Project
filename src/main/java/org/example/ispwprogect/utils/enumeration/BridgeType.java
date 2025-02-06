package org.example.ispwprogect.utils.enumeration;

public enum BridgeType implements GenericType{

    HARDTAIL(100.0, "Coming soon..."),
    TREMOLO(50.0,  "Coming soon..."),
    TUNEOMATIC(20.0, "Coming soon...");

    private final double PRICE;
    private static final String TYPE = "Bridge";
    private final String INFO;

    BridgeType(double price, String info) {
        this.PRICE = price;
        this.INFO = info;
    }

    @Override
    public double price() {
        return PRICE;
    }

    public String type() {
        return TYPE;
    }

    @Override
    public String info() {
        return INFO;
    }

}
