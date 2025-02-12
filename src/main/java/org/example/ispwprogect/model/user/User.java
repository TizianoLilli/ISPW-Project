package org.example.ispwprogect.model.user;

import org.example.ispwprogect.model.decorator.dreamguitar.DreamGuitar;
import org.example.ispwprogect.model.login.Account;
import org.example.ispwprogect.utils.bean.UserBean;
import org.example.ispwprogect.utils.enumeration.Role;

public class User {

    // deve essere univoco
    private String username;

    private DreamGuitar guitar;

    private String name;
    private String surname;
    private String email;
    private String address;

    private Account account;

    public User(UserBean user){
        this.username = user.getId();
        // l'inserimento della chitarra/account viene fatto separatamente
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.address = user.getAddress();
    }

    public DreamGuitar dreamGuitar() {return guitar;}
    public void setDreamGuitar(DreamGuitar d) {this.guitar = d;}

    public Account account() {return account;}
    public void setAccount(Account a) {this.account = a;}

    public String username() {return username;}

    public String name() {return this.name;}
    public String surname() {return this.surname;}
    public String email() {return this.email;}
    public String address() {return this.address;}
}
