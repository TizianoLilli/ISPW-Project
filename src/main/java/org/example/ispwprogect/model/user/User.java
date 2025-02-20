package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.enumeration.Role;

public class User {

    // deve essere univoco
    private String username;

    private DreamGuitar guitar;

    private String password;
    private Role role;
    private String email;
    private String address;

    public User(UserBean user){
        this.username = user.getId();
        // l'inserimento della chitarra/account viene fatto separatamente
        this.password = user.getPassword();
        this.role = user.getRole();
        this.email = user.getEmail();
        this.address = user.getAddress();
    }

    public User(String username, String password, Role role, String email, String address){
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.address = address;
    }

    public DreamGuitar dreamGuitar() {return guitar;}
    public void setDreamGuitar(DreamGuitar d) {this.guitar = d;}

    public Role role() {return role;}
    public void setRole(Role role) {this.role = role;}

    public String username() {return username;}

    public String password() {return this.password;}
    public String email() {return this.email;}
    public String address() {return this.address;}
}
