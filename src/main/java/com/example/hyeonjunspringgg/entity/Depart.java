package com.example.hyeonjunspringgg.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Depart {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "depart")
    private List<Student> students = new ArrayList<>();
}