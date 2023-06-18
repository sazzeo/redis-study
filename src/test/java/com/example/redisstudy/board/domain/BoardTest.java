package com.example.redisstudy.board.domain;

import com.example.redisstudy.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

@DataRedisTest
class BoardTest {

    @Autowired
    private BoardRepository boardRepository;


    @Test
    void redisTest() {
        Board board = Board.builder()
                .id("3")
                .title("board")
                .content("ㅇㅇ")
                .name("지영")
                .expiredTime(10)
                .build();
        boardRepository.save(board);
    }
    
    @Test
    void expiredTest() {
        Board board = boardRepository.findById("3").get();
        System.out.println(board);
    }

}