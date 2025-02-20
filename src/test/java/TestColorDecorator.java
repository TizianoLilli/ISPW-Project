import org.example.ispwprogect.model.decorator.color.ColorDecorator;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.utils.enumeration.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColorDecorator {

    private DreamGuitar guitar;
    private ColorDecorator colorDecorator;

    @BeforeEach
    public void setUp() {
        // Creiamo una DreamGuitar con un prezzo base di 100
        guitar = new DreamGuitar(100.0);
    }

    @Test
    public void testColorDecoratorPriceWithColor() {
        // Aggiungiamo un colore (ad esempio "Red") e nessuna finitura opaca
        colorDecorator = new ColorDecorator(guitar, Color.RED, false);

        // Il prezzo finale dovrebbe essere il prezzo base + il prezzo del colore (Red)
        double expectedPrice = 100.0 + Color.RED.getPrice();
        double actualPrice = colorDecorator.price();

        // Verifica che il prezzo finale sia corretto
        assertEquals(expectedPrice, actualPrice, "Il prezzo con il colore dovrebbe essere corretto.");
    }

    @Test
    public void testColorDecoratorPriceWithMatteFinish() {
        // Aggiungiamo un colore (ad esempio "Blue") con finitura opaca
        colorDecorator = new ColorDecorator(guitar, Color.BLUE, true);

        // Il prezzo finale dovrebbe essere il prezzo base + il prezzo del colore (Blue) + un extra per la finitura opaca
        double expectedPrice = 100.0 + Color.BLUE.getPrice() * 1.5;
        double actualPrice = colorDecorator.price();

        // Verifica che il prezzo con la finitura opaca sia corretto
        assertEquals(expectedPrice, actualPrice, "Il prezzo con il colore e finitura opaca dovrebbe essere corretto.");
    }

    @Test
    public void testColorDecoratorPriceWithoutColor() {
        // Decora la chitarra senza definire un colore (quindi il colore sarà null)
        colorDecorator = new ColorDecorator(guitar);

        // In questo caso, il prezzo non dovrebbe cambiare
        double expectedPrice = 100.0;
        double actualPrice = colorDecorator.price();

        // Verifica che il prezzo non cambi se il colore è null
        assertEquals(expectedPrice, actualPrice, "Il prezzo non dovrebbe cambiare se non è stato definito un colore.");
    }
}

