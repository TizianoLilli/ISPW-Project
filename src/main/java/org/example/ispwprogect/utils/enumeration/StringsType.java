package org.example.ispwprogect.utils.enumeration;

public enum StringsType {

    NINEGAUGE(100.0, "Coming soon..."),
    TENGAUGE(50.0, "Coming soon..."),
    ELEVENGAUGE(20.0, "Coming soon...");

    private final double price;
//    private static final String type = "Strings";
    private final String info;

    StringsType(double price, String info) {
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
