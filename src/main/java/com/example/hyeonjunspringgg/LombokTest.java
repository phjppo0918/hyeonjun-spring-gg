package com.example.hyeonjunspringgg;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class LombokTest {


    private int age;
    private String name;
}

class A {
    LombokTest lombokTest = LombokTest.builder()
            .age(23)
            .name("adsf")
            .build();
}
