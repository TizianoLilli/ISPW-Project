package org.example.ispwprogect.utils.bean;

import org.example.ispwprogect.utils.enumeration.Role;

public class CheckRoleBean {

    private String uid;
    private Role role;

    public CheckRoleBean(String uid, Role role) {
        this.uid = uid;
        this.role = role;
    }

    public String getUid() {return uid;}
    public Role getRole() {return role;}
}
