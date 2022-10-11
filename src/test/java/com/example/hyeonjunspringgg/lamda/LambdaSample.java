package com.example.hyeonjunspringgg.lamda;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
class UserAge {
    int age;
}
public class LambdaSample {
    @Test
    @DisplayName("test")
    void test() throws Exception {
        //given

        List<String> string = Arrays.asList("1", "2", "3");

        string.stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .map(i -> i * 10)
                .peek(System.out::println)
                .mapToObj(UserAge::new)
                .collect(toList());
        //when

        //then

    }


}
