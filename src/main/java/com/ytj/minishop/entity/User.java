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
    private Integer permission;
    private String name;
    private String password;
    private String orders;
    private String phone;

    protected User() {}
    public User(String email, String name, String password, String phone) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }
}

