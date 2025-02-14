package org.example.ispwprogect.model.user;

import java.util.Collection;

public interface UserDAO {

    public void create(User model);

    // dovrei in realtà chiamare la dao di account in ogni user per tirare fuori lo username
    public User read(String userId);

    public Collection<User> readAll();

    void update(User userM, int guitarId);

    public void delete(String userId);
}
