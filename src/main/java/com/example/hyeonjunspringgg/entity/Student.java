package com.example.hyeonjunspringgg.entity;


import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    Depart depart;
}
