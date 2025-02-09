package org.example.ispwprogect.model.decorator.dreamguitar;

public class InMemoryDreamGuitarDAO implements DreamGuitarDAO {

    private static InMemoryDreamGuitarDAO instance;

    private InMemoryDreamGuitarDAO() {
        // evito di istanziarlo dall'esterno
    }

    public static InMemoryDreamGuitarDAO getInstance() {
        if (instance == null) {
            instance = new InMemoryDreamGuitarDAO();
        }
        return instance;
    }

    @Override
    public void create(DreamGuitar guitarM) {

    }
}
