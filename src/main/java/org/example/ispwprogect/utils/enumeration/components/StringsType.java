package org.example.ispwprogect.utils.enumeration.components;

public enum StringsType implements GenericType {

    NINEGAUGE(100.0, "Coming soon..."),
    TENGAUGE(50.0, "Coming soon..."),
    ELEVENGAUGE(20.0, "Coming soon...");

    private final double price;
    private static final String TYPE = "Strings";
    private final String info;

    StringsType(double price, String info) {
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
