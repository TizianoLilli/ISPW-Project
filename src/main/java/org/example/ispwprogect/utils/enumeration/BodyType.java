package org.example.ispwprogect.utils.enumeration;

public enum BodyType {

    MAPLE(100.0, "Coming soon..."),
    MAHOGANY(50.0,  "Coming soon..."),
    ASH(20.0, "Coming soon...");

    private final double price;
    private static final String type = "Body";
    private final String info;

    BodyType(double price, String info) {
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
