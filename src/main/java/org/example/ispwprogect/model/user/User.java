package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.enumeration.Role;

public class User {

    // corrisponde allo username (deve essere univoco)
    private int id;
    private Role role;

    private DreamGuitar guitar;

    private String name;
    private String surname;
    private String email;
    private String address;

    public User(UserBean user){
        this.id = user.getId();
        this.role = user.getRole();
        // l'inserimento della chitarra viene fatto separatamente
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.address = user.getAddress();
    }

    public int id() {return this.id;}
    public Role role() {return this.role;}

    public DreamGuitar dreamGuitar() {return guitar;}
    public void setDreamGuitar(DreamGuitar d) {this.guitar = d;}

    public String name() {return this.name;}
    public String surname() {return this.surname;}
    public String email() {return this.email;}
    public String address() {return this.address;}
}
