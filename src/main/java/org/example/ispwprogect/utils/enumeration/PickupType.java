package org.example.ispwprogect.utils.enumeration;

public enum PickupType implements GenericType {

    HUMBUCKER(100.0, 3),
    SINGLECOIL(50.0, 5),
    P90(20.0, 4);

    private final double price;
    private static final String TYPE = "Pickup";
    private final int info;

    PickupType(double price, int info) {
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
        return "Brilliance: " + info + "/5";
    }
}
