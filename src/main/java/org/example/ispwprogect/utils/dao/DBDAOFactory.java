package org.example.ispwprogect.utils.dao;

import org.example.ispwprogect.model.decorator.color.ColorDAO;
import org.example.ispwprogect.model.decorator.color.InMemoryColorDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.DBDreamGuitarDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitarDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.InMemoryDreamGuitarDAO;
import org.example.ispwprogect.model.decorator.sticker.InMemoryStickerDAO;
import org.example.ispwprogect.model.decorator.sticker.StickerDAO;
import org.example.ispwprogect.model.user.DBUserDAO;
import org.example.ispwprogect.model.user.InMemoryUserDAO;
import org.example.ispwprogect.model.user.UserDAO;

public class DBDAOFactory extends DAOFactory {

    // OVVIAMENTE DA MDIFICARE CON DB
    @Override
    public DreamGuitarDAO getDreamGuitarDAO(){return new DBDreamGuitarDAO();}

    @Override
    public ColorDAO getColorDAO(){return InMemoryColorDAO.getIstance();}

    @Override
    public StickerDAO getStickerDAO(){return InMemoryStickerDAO.getIstance();}

//    @Override
//    public NoticeboardDAO getNoticeboardDAO(){}
//
//    @Override
//    public LuthierDAO getLuthierDAO(){}

    @Override
    public UserDAO getUserDAO(){return new DBUserDAO();}

}
