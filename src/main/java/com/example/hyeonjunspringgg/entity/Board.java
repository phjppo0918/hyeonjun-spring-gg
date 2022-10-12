package com.example.hyeonjunspringgg.entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @BatchSize(size = 50)
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
