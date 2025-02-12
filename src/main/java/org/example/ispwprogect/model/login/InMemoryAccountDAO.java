package org.example.ispwprogect.model.login;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryAccountDAO implements AccountDAO {

    private static InMemoryAccountDAO instance;

    private InMemoryAccountDAO() {
        // evito di istanziarlo dall'esterno
    }

    public static AccountDAO getIstance() {
        if (instance == null) {
            instance = new InMemoryAccountDAO();
        }
        return instance;
    }

    private Collection<Account> accountsList = new ArrayList<>();

    @Override
    public void create(Account account) {
        accountsList.add(account);
    }

    @Override
    public Account read(String id) {
        for (Account a : accountsList) {
            if (id.equals(a.userId())) {
                return a;
            }
        }
        return null;
    }
}
