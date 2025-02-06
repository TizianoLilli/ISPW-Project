package org.example.ispwprogect.model.decorator;

public class StickerDecorator extends Decorator {

    // private immagine : GESTISCILE SUCCESSIVAMENTE
    private double[] stickerSize = new double[2];

    //solitamente passo al costruttore dei ConcreteDecorator la dream guitar
    public StickerDecorator(Component component) {
        // chiamo il costruttore del Decorator passandogli la chitarra
        super(component);
    }

    // aggiungo il prezzo dello sticker a quello della chitarra
    protected double applySticker(double ammount) {
        return ammount + 0.2;
    }

    // DA IMPLEMENTARE ANCORA
    public void defineStickerSize(double width, double height) {
        this.stickerSize[0] = width;
        this.stickerSize[1] = height;
    }

    @Override
    public double price() {
        // invoco price() in Decorator
        double preliminaryResult = super.price();
        preliminaryResult = this.applySticker(preliminaryResult);
        return preliminaryResult;
    }
}
