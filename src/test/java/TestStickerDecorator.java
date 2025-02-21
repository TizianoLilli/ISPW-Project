import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.model.decorator.sticker.StickerDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStickerDecorator {

    private DreamGuitar guitar;
    private StickerDecorator stickerDecorator;

    @BeforeEach
    public void setUp() {
        // Crea una DreamGuitar con un prezzo base di 100
        guitar = new DreamGuitar(100);
    }

    @Test
    public void testStickerDecoratorPrice() {

        stickerDecorator = new StickerDecorator(guitar, "Star");

        // Calcola il prezzo finale della chitarra con lo sticker
        double expectedPrice = 100.0 + 0.2; // prezzo base + prezzo dello sticker (0.2)
        double actualPrice = stickerDecorator.price();

        // Verifica che il prezzo finale sia quello previsto
        assertEquals(expectedPrice, actualPrice, "Il prezzo finale con lo sticker dovrebbe essere corretto");
    }

}
