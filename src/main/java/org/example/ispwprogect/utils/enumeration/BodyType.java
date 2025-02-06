package org.example.ispwprogect.utils.enumeration;

public enum BodyType implements GenericType{

    MAPLE(100.0, "Coming soon..."),
    MAHOGANY(50.0,  "Coming soon..."),
    ASH(20.0, "Coming soon...");

    private final double price;
    private static final String TYPE = "Body";
    private final String info;

    BodyType(double price, String info) {
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
