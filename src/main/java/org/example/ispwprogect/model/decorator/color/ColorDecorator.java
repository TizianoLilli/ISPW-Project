package org.example.ispwprogect.model.decorator.color;

import org.example.ispwprogect.model.decorator.Component;
import org.example.ispwprogect.model.decorator.Decorator;
import org.example.ispwprogect.utils.bean.ColorBean;
import org.example.ispwprogect.utils.enumeration.Color;

public class ColorDecorator extends Decorator {

    private int guitarId;

    private Color color;
    private boolean matteFinish;

    //inizialmente passo al costruttore dei ConcreteDecorator la dream guitar
    public ColorDecorator(Component component) {
        // chiamo il costruttore del Decorator passandogli la chitarra inizialmente
        super(component);
    }

    public ColorDecorator(Component component, Color color, boolean matteFinish) {
        super(component);
        this.color = color;
        this.matteFinish = matteFinish;
    }

    public void defineColor(Color c) {
        this.color = c;
    }

    public int gid(){return guitarId;}

    // aggiungo il prezzo del colore a quello della chitarra
    protected double applyColor(double previousPrice){
        if (color != null) {
            if (matteFinish) {
                return previousPrice + applyOpacity();
            } else return previousPrice + color.getPrice();
        }else return previousPrice;
    }

    protected double applyOpacity(){
        return color.getPrice() * 1.5;
    }

    @Override
    public double price(){
        // invoco price() in Decorator
        double preliminaryResult = super.price();
        preliminaryResult = this.applyColor(preliminaryResult);
        return preliminaryResult;
    }
}
