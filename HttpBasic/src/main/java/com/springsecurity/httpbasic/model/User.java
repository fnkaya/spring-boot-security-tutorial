package com.springsecurity.httpbasic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"username"})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    private Authority role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(columnDefinition = "user_id"),
            inverseJoinColumns = @JoinColumn(columnDefinition = "authority_id"))
    private Set<Authority> authorities = new HashSet<>();

    public User(String username, String password, Authority role, Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorities = authorities;
    }
}
