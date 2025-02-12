package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.login.AccountDAO;

import java.util.Collection;

public interface UserDAO {

    public void create(User model);

    // dovrei in realtà chiamare la dao di account in ogni user per tirare fuori lo username
    public User read(String userId, AccountDAO accountD);

    public Collection<User> readAll();

    public void delete(String userId);
}
