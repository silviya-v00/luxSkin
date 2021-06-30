package com.ss.luxSkin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinTable(name = "login_roles",
            joinColumns = @JoinColumn(name = "login_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private List<Roles> roles;

    public Login() {
        this.roles = new ArrayList<>();
    }

    public Login(Long id, String name, String password) {
        this();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Login(Long id, String name, String password, List<Roles> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
