package org.example.ispwprogect.model.decorator.dreamguitar;

import org.example.ispwprogect.model.decorator.color.ColorDecorator;
import org.example.ispwprogect.utils.exception.SystemException;

public interface DreamGuitarDAO {

    // da implementare nelle sottoclassi
    void create(DreamGuitar guitar) throws SystemException;

    DreamGuitar read(int guitarId) throws SystemException;

//    public void update(DreamGuitar guitar, ColorDecorator colorDecorator) throws SystemException;

//    public void retrieve();

    public void delete(int guitarId) throws SystemException;

}
