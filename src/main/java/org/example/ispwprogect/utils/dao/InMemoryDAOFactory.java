package org.example.ispwprogect.utils.dao;

import org.example.ispwprogect.model.decorator.color.ColorDAO;
import org.example.ispwprogect.model.decorator.color.InMemoryColorDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitarDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.InMemoryDreamGuitarDAO;
import org.example.ispwprogect.model.decorator.sticker.InMemoryStickerDAO;
import org.example.ispwprogect.model.decorator.sticker.StickerDAO;
import org.example.ispwprogect.model.user.InMemoryUserDAO;
import org.example.ispwprogect.model.user.UserDAO;

public class InMemoryDAOFactory extends DAOFactory {

    @Override
    public DreamGuitarDAO getDreamGuitarDAO(){return InMemoryDreamGuitarDAO.getInstance();}

    @Override
    public ColorDAO getColorDAO(){return InMemoryColorDAO.getIstance();}

    @Override
    public StickerDAO getStickerDAO(){return InMemoryStickerDAO.getIstance();}

    @Override
    public UserDAO getUserDAO(){return InMemoryUserDAO.getIstance();}

}
