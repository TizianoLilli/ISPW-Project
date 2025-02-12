package org.example.ispwprogect.model.login;

public interface AccountDAO {

    public void create(Account account);
    public Account read(String username);

}
