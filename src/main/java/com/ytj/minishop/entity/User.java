package com.ytj.minishop.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    private String email;
    private String name;
    private String password;
    private String orders;

    protected User() {}
    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}

