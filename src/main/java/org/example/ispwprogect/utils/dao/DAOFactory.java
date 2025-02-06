package org.example.ispwprogect.utils.dao;

public abstract class DAOFactory {

    private static DAOFactory daoFactoryIstance;
    private static PersistenceProvider persistenceProvider;

    protected DAOFactory() {}

    public abstract NoticeboardDAO getNoticeboardDAO(){}
    public abstract DreamGuitarDAO getDreamGuitarDAO(){}
    public abstract LuthierDAO getLuthierDAO(){}
    public abstract UserDAO getUserDAO(){}

    public static DAOFactory getInstance(){}
    public static PersistenceProvider setPersistenceProvider(){}

}
