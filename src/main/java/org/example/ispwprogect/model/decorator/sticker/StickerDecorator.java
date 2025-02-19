package org.example.ispwprogect.model.decorator.sticker;

import org.example.ispwprogect.model.decorator.Component;
import org.example.ispwprogect.model.decorator.Decorator;

public class StickerDecorator extends Decorator {

    // private immagine : GESTISCILE SUCCESSIVAMENTE
//    private double[] stickerSize = new double[2];
    private String sticker;

    //solitamente passo al costruttore dei ConcreteDecorator la dream guitar
    public StickerDecorator(Component component, String sticker) {
        // chiamo il costruttore del Decorator passandogli la chitarra
        super(component);
        this.sticker = sticker;
    }

    // aggiungo il prezzo dello sticker a quello della chitarra
    protected double applySticker(double ammount) {
        double newAmmount = ammount + 0.2;
        // per arrotondare correttamente
        return Math.round(newAmmount * 100.0) / 100.0;
    }

    // DA IMPLEMENTARE ANCORA
//    public void defineStickerSize(double width, double height) {
//        this.stickerSize[0] = width;
//        this.stickerSize[1] = height;
//    }

    @Override
    public double price() {
        // invoco price() in Decorator
        double preliminaryResult = super.price();
        preliminaryResult = this.applySticker(preliminaryResult);
        return preliminaryResult;
    }
}
