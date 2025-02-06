package org.example.ispwprogect.utils.enumeration;

public enum StringsType implements GenericType{

    NINEGAUGE(100.0, "Coming soon..."),
    TENGAUGE(50.0, "Coming soon..."),
    ELEVENGAUGE(20.0, "Coming soon...");

    private final double PRICE;
    private static final String TYPE = "Strings";
    private final String INFO;

    StringsType(double price, String info) {
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
