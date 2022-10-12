package com.example.hyeonjunspringgg.repository;

import com.example.hyeonjunspringgg.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class BoardRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("생성 테스트")
    void input() throws Exception {
        //given
        Board  board = Board.builder()
                .title("asdf")
                .content("sdaf")
                .build();
        //when
        boardRepository.save(board);

        //then

    }
}