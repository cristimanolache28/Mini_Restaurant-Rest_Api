package com.restaurant.entity;


import lombok.Data;


import javax.persistence.*;

@Entity
@Table (name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

}
