package org.example.ispwprogect.model.login;

import org.example.ispwprogect.utils.bean.AccountBean;
import org.example.ispwprogect.utils.enumeration.Role;

public class Account {

    private String username;
    private String password;

    private Role role;

    public Account(AccountBean account) {
        this.username = account.getUserId();
        this.password = account.getPassword();
        this.role = account.getRole();
    }

    public String userId() {return username;}
    public String password() {return password;}
    public Role role() {return role;}

}
