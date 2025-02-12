package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.Role;

public class UserBean {

    private String id;

    private String guitarId;

    private String name;
    private String surname;
    private String email;
    private String address;

    //private String accountId;

    public UserBean(String id, String name, String surname, String email, String address) {
        this.id = id;
        // l'inserimento della chitarra/account viene fatto separatamente
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getDreamGuitar() {return guitarId;}
    public void setDreamGuitar(String g) {this.guitarId = g;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    // uso l'id
//    public String getAccount() {return accountId;}
//    public void setAccount(String a) {this.accountId = a;}
}
