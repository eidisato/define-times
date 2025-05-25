package com.satobrothers.defineTimes.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "M_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String username;  // login do usuário

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;  // senha criptografada

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    private boolean superAdmin;

    public Usuario() {}

    public Usuario(String nome, String username, String email, String password, boolean superAdmin) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.superAdmin = superAdmin;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public boolean isSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }
}
