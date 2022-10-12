package com.example.hyeonjunspringgg.entity;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SmartPhone {

    @Id
    private Long id;
    private String sc;

    @Embedded
    private Phone phone;
}
