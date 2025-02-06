package org.example.ispwprogect.model.decorator;

import org.example.ispwprogect.utils.enumeration.Color;

public class ColorDecorator extends Decorator {

    private Color color;
    private boolean matteFinish;

    //solitamente passo al costruttore dei ConcreteDecorator la dream guitar
    public ColorDecorator(Component component) {
        // chiamo il costruttore del Decorator passandogli la chitarra
        super(component);
    }

    // forse nel costruttore devo riempire le variabili

    public void defineColor(Color c) {
        this.color = c;
    }

    // aggiungo il prezzo del colore a quello della chitarra
    protected double applyColor(double previousPrice){
        if (color != null) {
            return previousPrice + color.getPrice();
        }else return previousPrice;
    }

    protected double applyOpacity(double coloredPrice){
        if (matteFinish && color != null) {
            // applico l'opacità solo se ho il colore
            return coloredPrice * 1.5;
        } else return coloredPrice;
    }

    @Override
    public double price(){
        // invoco price() in Decorator
        double preliminaryResult = super.price();
        preliminaryResult = this.applyOpacity(this.applyColor(preliminaryResult));
        return preliminaryResult;
    }
}
