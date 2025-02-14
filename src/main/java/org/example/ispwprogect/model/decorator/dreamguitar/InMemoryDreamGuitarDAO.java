package org.example.ispwprogect.model.decorator.dreamguitar;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryDreamGuitarDAO implements DreamGuitarDAO {

    private static InMemoryDreamGuitarDAO instance;

    private Collection<DreamGuitar> dreamGuitars = new ArrayList<DreamGuitar>();

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
        dreamGuitars.add(guitarM);
    }

    @Override
    public DreamGuitar read(int guitarId){
        for (DreamGuitar g : dreamGuitars) {
            if (g.id() == guitarId) {
                return g;
            }
        }
        return null;
    }
}
