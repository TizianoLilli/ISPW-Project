package org.example.ispwprogect.model.login;

import org.example.ispwprogect.utils.bean.LoginBean;
import org.example.ispwprogect.utils.enumeration.Role;

public class Login {

    private String username;
    private String password;

    private Role role;

    public Login(LoginBean login) {
        this.username = login.getUserId();
        this.password = login.getPassword();
        this.role = login.getRole();
    }

    public String userId() {return username;}
    public String password() {return password;}
    public Role role() {return role;}

}
