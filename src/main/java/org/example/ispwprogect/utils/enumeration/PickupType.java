package org.example.ispwprogect.utils.enumeration;

public enum PickupType implements GenericType {

    HUMBUCKER(100.0, 3),
    SINGLECOIL(50.0, 5),
    P90(20.0, 4);

    private final double PRICE;
    private static final String TYPE = "Pickup";
    private final int INFO;

    PickupType(double price, int info) {
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
        return "Brilliance: " + INFO + "/5";
    }
}
