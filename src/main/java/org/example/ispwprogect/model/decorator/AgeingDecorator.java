package org.example.ispwprogect.model.decorator;

import org.example.ispwprogect.utils.enumeration.AgeOfWood;

// PROBABILMENTE NON LO IMPLEMENTERò
public class AgeingDecorator extends Decorator {

    private AgeOfWood age;

    public AgeingDecorator(Component component) {
        // chiamo il costruttore del Decorator passandogli la chitarra
        super(component);
    }

    public void defineAge(AgeOfWood a) {
        this.age = a;
    }

    // uso dei moltiplicatori per l'invecchiamento: più è vecchio il legno, più è grande il moltiplicatore
    protected double applyAgeing(double ammount) {
        if (age != null) {
            return ammount * age.getMultiplier();
        } else return ammount;
    }

    @Override
    public double price() {
        // invoco price() in Decorator
        double preliminaryResult = super.price();
        preliminaryResult = this.applyAgeing(preliminaryResult);
        return preliminaryResult;
    }
}
