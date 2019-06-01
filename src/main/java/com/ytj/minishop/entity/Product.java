package com.ytj.minishop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Double price;
    private Long category;
    private Long saleVolume;
}