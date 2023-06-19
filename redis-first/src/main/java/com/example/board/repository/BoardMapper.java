package com.example.board.repository;

import com.example.board.domain.Board;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BoardMapper {

    private final SetOperations<String, Object> setOperations;

    public BoardMapper(final RedisTemplate<String, Object> redisTemplate) {
         this.setOperations = redisTemplate.opsForSet();
    }

    public void save(Board board) {
        setOperations.add("boardTest" , board);
    }

    public Set<Object> getAll() {
        return setOperations.members("boardTest");
    }
}
