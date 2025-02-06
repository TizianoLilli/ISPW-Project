package org.example.ispwprogect.utils.enumeration;

import org.example.ispwprogect.utils.dao.DAOFactory;
import org.example.ispwprogect.utils.dao.DBDAOFactory;
import org.example.ispwprogect.utils.dao.FSDAOFactory;
import org.example.ispwprogect.utils.dao.InMemoryDAOFactory;

public enum PersistenceProvider {

    IN_MEMORY(InMemoryDAOFactory.class),
    FS(FSDAOFactory.class),
    DB(DBDAOFactory.class);

    private final Class<? extends DAOFactory> daoFactoryClass;

    PersistenceProvider(Class<? extends DAOFactory> daoFactoryClass) {
        this.daoFactoryClass = daoFactoryClass;
    }

    public Class<? extends DAOFactory> getDaoFactoryClass() {return daoFactoryClass;}

}
