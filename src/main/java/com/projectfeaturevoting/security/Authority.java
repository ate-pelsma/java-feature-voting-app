package com.projectfeaturevoting.security;

import com.projectfeaturevoting.domain.User;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

// THIS BECOMES A TABLE THAT HOLDS THE AUTHORITIES A CERTAIN USER HAS
@Entity
public class Authority implements GrantedAuthority {

    private Long id;
    private String authority;
    private User user;

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
