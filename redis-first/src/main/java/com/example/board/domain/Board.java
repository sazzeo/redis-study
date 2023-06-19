package com.example.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@ToString
@AllArgsConstructor
@Getter
@Builder
@RedisHash("board")
public class Board {
    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private String title;

    private String content;

    @TimeToLive
    private long expiredTime;

}
