package com.ytj.minishop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "categories")
@Entity
@Getter
@Setter
@ToString
public class Category {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Category parent;
    private Category[] children;

    protected Category() {}
    public Category(String name) {
        this.name = name;
    }
}
