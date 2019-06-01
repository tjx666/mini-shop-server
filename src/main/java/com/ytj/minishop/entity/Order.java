package com.ytj.minishop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @GeneratedValue
    @Id
    private Long id;
    private String products;
    private Integer status;
}
