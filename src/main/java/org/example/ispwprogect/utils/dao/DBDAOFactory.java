package org.example.ispwprogect.utils.dao;

import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitarDAO;
import org.example.ispwprogect.model.decorator.dreamguitar.InMemoryDreamGuitarDAO;
import org.example.ispwprogect.model.login.InMemoryLoginDAO;
import org.example.ispwprogect.model.login.LoginDAO;
import org.example.ispwprogect.model.luthier.LuthierDAO;
import org.example.ispwprogect.model.noticeboard.NoticeboardDAO;
import org.example.ispwprogect.model.user.InMemoryUserDAO;
import org.example.ispwprogect.model.user.UserDAO;

public class DBDAOFactory extends DAOFactory {

    // OVVIAMENTE DA MDIFICARE CON DB
    @Override
    public DreamGuitarDAO getDreamGuitarDAO(){return InMemoryDreamGuitarDAO.getInstance();}

//    @Override
//    public NoticeboardDAO getNoticeboardDAO(){}
//
//    @Override
//    public LuthierDAO getLuthierDAO(){}

    @Override
    public UserDAO getUserDAO(){return InMemoryUserDAO.getIstance();}

    @Override
    public LoginDAO getLoginDAO() {return InMemoryLoginDAO.getIstance();}

}
