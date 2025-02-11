package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.model.login.Login;
import org.example.ispwprogect.utils.enumeration.Role;

public class LoginBean {

    private String userId;
    private String password;

    private Role role;

    public LoginBean(String id, String password) {
        this.userId = id;
        this.password = password;
    }

    public String getUserId() {return userId;}
    public void setUserId(String id) {this.userId = id;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}
}
