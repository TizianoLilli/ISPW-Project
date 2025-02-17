package org.example.ispwprogect.model.decorator.color;

import org.example.ispwprogect.model.user.InMemoryUserDAO;
import org.example.ispwprogect.model.user.User;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryColorDAO implements ColorDAO {

    private static InMemoryColorDAO instance;

    private InMemoryColorDAO() {
        // evito di istanziarlo dall'esterno
    }

    public static InMemoryColorDAO getIstance() {
        if (instance == null) {
            instance = new InMemoryColorDAO();
        }
        return instance;
    }

    private Collection<ColorDecorator> colorList = new ArrayList<>();

    @Override
    public void create(ColorDecorator color) {
        colorList.add(color);
    }

    @Override
    public Collection<ColorDecorator> read(int gid) {
        Collection<ColorDecorator> selectedColor = new ArrayList<>();
        for (ColorDecorator c : colorList) {
            if (c.gid() == gid){
                selectedColor.add(c);
            }
        }
        return selectedColor;
    }
}
