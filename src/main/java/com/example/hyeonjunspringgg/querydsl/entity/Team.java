package com.example.hyeonjunspringgg.querydsl.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();
}
