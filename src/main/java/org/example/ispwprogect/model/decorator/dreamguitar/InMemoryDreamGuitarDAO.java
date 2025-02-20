package org.example.ispwprogect.model.decorator.dreamguitar;

import org.example.ispwprogect.model.decorator.color.ColorDecorator;
import org.example.ispwprogect.model.decorator.color.InMemoryColorDAO;
import org.example.ispwprogect.utils.exception.SystemException;

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
    public void create(DreamGuitar guitarM) throws SystemException {
        dreamGuitars.add(guitarM);
    }

    @Override
    public DreamGuitar read(int guitarId) throws SystemException {
        for (DreamGuitar g : dreamGuitars) {
            if (g.id() == guitarId) {

//                Collection<ColorDecorator> selectedColor = InMemoryColorDAO.getIstance().read(guitarId);
//                for (ColorDecorator c : selectedColor) {
//                    // DA FINIRE
//                }
                return g;
            }
        }
        return null;
    }

//    @Override
//    public void update(DreamGuitar guitarM, ColorDecorator colorDecoratorM) throws SystemException {
//        // user dao interagisce con la dao dei decorator
//        InMemoryColorDAO.getIstance().create(colorDecoratorM);
//    }

    @Override
    public void delete(int guitarId) throws SystemException {
        try {
            dreamGuitars.remove(read(guitarId));
        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }

}
