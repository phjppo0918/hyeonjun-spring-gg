package com.example.hyeonjunspringgg.service;

import com.example.hyeonjunspringgg.entity.Board;
import com.example.hyeonjunspringgg.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save() {
        Board board = Board.builder()
                .title("asdf")
                .build();
        boardRepository.save(board);
    }

    @Transactional
    public void update1() {
        Board result = boardRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
        result.setTitle("sdfadsf");
    }

    public void searchAll() {
        List<Board> all = boardRepository.findAll();
        all.get(0).setTitle("asdfasdfas");

        update1();
    }

    public void update2() {
        Board result = boardRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
        result.setTitle("sdfadsf");
        boardRepository.save(result);
    }

}
