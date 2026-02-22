package com.example.EcomApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Table(name= "ecom_products")
public class Product { //name of the table in the database

    //ORM -> Object Relation Mapping

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;  //column in the table

    @Column(name = "product_name", nullable = false)
    String name;

    @Column(name="product_description")
    String description;

    @Min(1)
    @Column(name = "price",nullable = false)
    float price;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
