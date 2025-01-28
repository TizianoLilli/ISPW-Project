package org.example.ispwprogect.utils.enumeration;

public enum NesType {

    MAPLE(100.0, "Coming soon..."),
    ROSEWOOD(50.0,  "Coming soon..."),
    EBONY(20.0, "Coming soon...");

    private final double price;
    private static final String type = "Neck&Headstock";
    private final String info;

    NesType(double price, String info) {
        this.price = price;
        this.info = info;
    }

    public double price() {
        return price;
    }

    public String type() {
        return type;
    }

    public String info() {
        return info;
    }

}