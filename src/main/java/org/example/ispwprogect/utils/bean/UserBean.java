package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.Role;

public class UserBean {

    private int id;
    private Role role;

    private DreamGuitarBean guitarB;

    private String name;
    private String surname;
    private String email;
    private String address;

    public UserBean(int id, Role role, String name, String surname, String email, String address) {
        this.id = id;
        this.role = role;
        // l'inserimento della chitarra viene fatto separatamente
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public DreamGuitarBean getDreamGuitar() {return guitarB;}
    public void setDreamGuitar(DreamGuitarBean guitarB) {this.guitarB = guitarB;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
}
