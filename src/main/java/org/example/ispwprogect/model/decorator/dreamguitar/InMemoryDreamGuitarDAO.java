package org.example.ispwprogect.model.decorator.dreamguitar;

public class InMemoryDreamGuitarDAO extends DreamGuitarDAO {

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
}
