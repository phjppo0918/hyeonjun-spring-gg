package com.example.hyeonjunspringgg.querydsl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Car(String name) {
        this.name = name;
    }
}
