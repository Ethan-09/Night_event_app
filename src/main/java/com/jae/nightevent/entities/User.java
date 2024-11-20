package com.jae.nightevent.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name ="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

//    @ManyToMany
//    private List<User> userList;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserEventAssociation> lstRoleUserAssociation = new HashSet<>();
}
