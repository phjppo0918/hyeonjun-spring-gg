package com.example.hyeonjunspringgg.lamda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SupplierTest {

    @Test
    @DisplayName("SupplierTest")
    void supplierTest() throws Exception {
        //given
        Supplier<String> supplier = () -> "hello";
        //when
        String result = supplier.get();
        //then
        assertThat(result).isEqualTo("hello");
    }

    @Test
    @DisplayName("ConsumerTest")
    void consumerTest() throws Exception {
        //given
        Consumer<String> consumer = (str) -> log.info(str);
        Consumer<String> consumer2 = log::info;

        //when
        consumer.accept("안녕!");
        consumer2.accept("안녕안녕!!");
        //then

    }

    
}
