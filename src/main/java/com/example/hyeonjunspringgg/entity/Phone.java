package com.example.hyeonjunspringgg.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Embeddable
public class Phone {
    @Id
    private Long id;

    private Integer pn;
}
