package org.example.ispwprogect.utils.enumeration;

public enum PickupType {

    HUMBUCKER(100.0, "Pickup Humbucker, ideale per suoni caldi e pieni"),
    SINGLECOIL(50.0, "Pickup Single Coil, ideale per suoni puliti e brillanti"),
    P90(20.0, "Pickup P-90, ha caratteristiche ibride tra Humbucker e Single Coil");

    private final double price;
//    private static final String type = "Pickup";
    private final String info;

    PickupType(double price, String info) {
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
