package com.fnkaya.springsecurity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"authority"})
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }
}
