package com.example.redisstudy;

import com.example.redisstudy.board.domain.Board;
import com.example.redisstudy.board.repository.BoardMapper;
import com.example.redisstudy.config.RedisConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//@SpringBootTest(classes = {RedisConfig.class})
@SpringBootTest
class RedisStudyApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    BoardMapper boardMapper;

    List<Board> boards = new ArrayList<>();


    @BeforeEach
    void setUp() {
        redisTemplate.delete("boardTest");
        Board board1 = Board.builder()
                .id("1")
                .title("제목1")
                .content("내용1")
                .name("작성자1")
                .expiredTime(60)
                .build();

        Board board2 = Board.builder()
                .id("2")
                .title("제목2")
                .content("내용2")
                .name("작성자2")
                .expiredTime(60)
                .build();

        boards.add(board1);
        boards.add(board2);
    }

    @Test
    void contextLoads() {
        boardMapper.save(boards.get(0));
        boardMapper.save(boards.get(1));
        Set<Object> all = boardMapper.getAll();
        System.out.println(all);
    }
}
