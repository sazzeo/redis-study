package com.example.rediscoupon.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AppliedUserRepository {

    private final RedisTemplate<Object, Object> redisTemplate;

    //set으로 userId 중복을 확인한다
    // set 반환 값: 중복이면 0 , 새값이면 1
    public Long add(Long userId) {
        return redisTemplate.opsForSet().add("applied_user", userId.toString());
    }
}
