package org.example.ispwprogect.model.user;

import org.example.ispwprogect.utils.exception.SystemException;

public interface UserDAO {

    public void create(User model) throws SystemException;

    // dovrei in realtà chiamare la dao di account in ogni user per tirare fuori lo username
    public User read(String userId) throws SystemException;

    void update(User userM, int guitarId) throws SystemException;

    public void delete(String userId) throws SystemException;
}
