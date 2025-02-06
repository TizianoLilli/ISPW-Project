package org.example.ispwprogect.utils.enumeration;

public enum BodyType implements GenericType{

    MAPLE(100.0, "Coming soon..."),
    MAHOGANY(50.0,  "Coming soon..."),
    ASH(20.0, "Coming soon...");

    private final double PRICE;
    private static final String TYPE = "Body";
    private final String INFO;

    BodyType(double price, String info) {
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
