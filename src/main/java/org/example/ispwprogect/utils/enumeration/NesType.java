package org.example.ispwprogect.utils.enumeration;

public enum NesType implements GenericType {

    MAPLE(100.0, "Coming soon..."),
    ROSEWOOD(50.0,  "Coming soon..."),
    EBONY(20.0, "Coming soon...");

    private final double PRICE;
    private static final String TYPE = "Neck&Headstock";
    private final String INFO;

    NesType(double price, String info) {
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
