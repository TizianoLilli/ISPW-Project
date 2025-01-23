package org.example.ispwprogect.utils.enumeration;

public enum StringsType {

    NINEGAUGE(100.0, "Strings", "Coming soon..."),
    TENGAUGE(50.0, "Strings", "Coming soon..."),
    ELEVENGAUGE(20.0, "Strings", "Coming soon...");

    private final double price;
    private final String type;
    private final String info;

    StringsType(double price, String type, String info) {
        this.price = price;
        this.type = type;
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
