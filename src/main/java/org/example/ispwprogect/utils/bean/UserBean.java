package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.Role;

public class UserBean {

    private String id;

    private String guitarId;

    private String password;
    private Role role;
    private String email;
    private String address;

    public UserBean(String id, String password, Role role, String email, String address) {
        this.id = id;
        // l'inserimento della chitarra viene fatto separatamente
        this.password = password;
        this.role = role;
        this.email = email;
        this.address = address;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getDreamGuitar() {return guitarId;}
    public void setDreamGuitar(String g) {this.guitarId = g;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

}
