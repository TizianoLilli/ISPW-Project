package org.example.ispwprogect.utils.dao;

import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitarDAO;
import org.example.ispwprogect.model.luthier.LuthierDAO;
import org.example.ispwprogect.model.noticeboard.NoticeboardDAO;
import org.example.ispwprogect.model.user.UserDAO;
import org.example.ispwprogect.utils.enumeration.PersistenceProvider;
import org.example.ispwprogect.utils.exception.NoPersistenceProviderException;

import java.lang.reflect.InvocationTargetException;

public abstract class DAOFactory {

    private static DAOFactory daoFactoryIstance = null;
    private static PersistenceProvider persistenceProvider = null;

    protected DAOFactory() {}

    public abstract DreamGuitarDAO getDreamGuitarDAO();
//    public abstract NoticeboardDAO getNoticeboardDAO();
//    public abstract LuthierDAO getLuthierDAO();
//    public abstract UserDAO getUserDAO();

    public static DAOFactory getInstance() throws NoPersistenceProviderException {
        if (daoFactoryIstance == null) {
            try {
                daoFactoryIstance = persistenceProvider.getDaoFactoryClass().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                     InvocationTargetException | NoSuchMethodException | SecurityException e ) {
                throw new NoPersistenceProviderException(persistenceProvider, e);
            }
            return daoFactoryIstance;
        }
        return daoFactoryIstance;
    }
    public static void setPersistenceProvider(PersistenceProvider provider){persistenceProvider = provider;}

}
