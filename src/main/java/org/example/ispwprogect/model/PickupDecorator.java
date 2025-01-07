package org.example.ispwprogect.model;

public class PickupDecorator extends Decorator{

    private double price;
//    private String component;
//    private String info;
//    private String brilliance;

    public PickupDecorator(Component component) {
        super(component);
        this.price = 3.2;
    }

    @Override
    public double price(){
        double preliminaryResult = super.price();
        return price;
    }
}
