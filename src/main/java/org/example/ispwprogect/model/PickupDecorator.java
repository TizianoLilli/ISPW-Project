package org.example.ispwprogect.model;

public class PickupDecorator extends Decorator{

//    private double price;
//    private String component;
//    private String info;
//    private String brilliance;

    //solitamente passo al costruttore dei ConcreteDecorator la dream guitar
    public PickupDecorator(Component component) {
        // chiamo il costruttore del Decorator passandogli la chitarra
        super(component);
    }

    double toDefine=3; //momentanea!!
    protected double applySupplement(double previousPrice){
        return previousPrice + toDefine; //toDefine sarebbe il prezzo di uno dei PickupType (enum)
    }

    @Override
    public double price(){
        // invoco price() in Decorator
        double preliminaryResult = super.price();
        double price = this.applySupplement(preliminaryResult);
        return price;
    }
}
