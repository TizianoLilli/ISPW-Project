package org.example.ispwprogect.model.decorator.dreamguitar;

import org.example.ispwprogect.model.decorator.color.ColorDecorator;
import org.example.ispwprogect.utils.exception.SystemException;

public interface DreamGuitarDAO {

    // da implementare nelle sottoclassi
    void create(DreamGuitar guitar) throws SystemException;

    DreamGuitar read(int guitarId) throws SystemException;

    public void delete(int guitarId) throws SystemException;

}
