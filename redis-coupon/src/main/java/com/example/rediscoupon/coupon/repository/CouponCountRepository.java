package com.example.rediscoupon.coupon.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CouponCountRepository {

    private final RedisTemplate<String , String> redisTemplate;

    //incr : 1씩 증가시켜주는 명령어
    public Long increment() {
        return redisTemplate
                .opsForValue()
                .increment("coupon_count");
    }

}
