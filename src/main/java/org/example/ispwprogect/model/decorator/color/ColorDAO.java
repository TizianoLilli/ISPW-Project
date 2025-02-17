package org.example.ispwprogect.model.decorator.color;

import java.util.Collection;

public interface ColorDAO {

    void create(ColorDecorator color);

    Collection<ColorDecorator> read(int guitarId);
}
