package org.example.ispwprogect.model.decorator.sticker;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryStickerDAO implements StickerDAO {

    private static InMemoryStickerDAO instance;

    private InMemoryStickerDAO() {
        // evito di istanziarlo dall'esterno
    }

    public static InMemoryStickerDAO getIstance() {
        if (instance == null) {
            instance = new InMemoryStickerDAO();
        }
        return instance;
    }

    private Collection<StickerDecorator> stickerList = new ArrayList<>();

    @Override
    public void create(StickerDecorator sticker) {
        stickerList.add(sticker);
    }
}
