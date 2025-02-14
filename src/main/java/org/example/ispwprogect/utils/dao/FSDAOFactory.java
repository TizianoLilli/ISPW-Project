package org.example.ispwprogect.utils.dao;

import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitarDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.InMemoryDreamGuitarDAO;
import org.example.ispwprogect.model.user.InMemoryUserDAO;
import org.example.ispwprogect.model.user.UserDAO;

public class FSDAOFactory extends DAOFactory {

    // OVVIAMENTE DA MDIFICARE CON FS
    @Override
    public DreamGuitarDAO getDreamGuitarDAO(){return InMemoryDreamGuitarDAO.getInstance();}

//    @Override
//    public NoticeboardDAO getNoticeboardDAO(){}

//    @Override
//    public LuthierDAO getLuthierDAO(){}

    @Override
    public UserDAO getUserDAO(){return InMemoryUserDAO.getIstance();}

}
