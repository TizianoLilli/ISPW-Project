package org.example.ispwprogect.model.decorator.dreamguitar;

import org.example.ispwprogect.model.decorator.color.ColorDecorator;

public interface DreamGuitarDAO {

    // da implementare nelle sottoclassi
    void create(DreamGuitar guitar);

    DreamGuitar read(int guitarId);

    public void update(DreamGuitar guitar, ColorDecorator colorDecorator);

//    public void retrieve();

    public void delete(int guitarId);

}
