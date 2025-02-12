package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.Role;

public class AccountBean {

    private String userId;
    private String password;

    private Role role;

    public AccountBean(String id, String password, Role role) {
        this.userId = id;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {return userId;}
    public void setUserId(String id) {this.userId = id;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}
}
