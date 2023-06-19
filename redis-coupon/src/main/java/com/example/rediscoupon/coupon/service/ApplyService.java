package com.example.rediscoupon.coupon.service;

import com.example.rediscoupon.coupon.domain.Coupon;
import com.example.rediscoupon.coupon.repository.CouponCountRepository;
import com.example.rediscoupon.coupon.repository.CouponRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApplyService {
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository;


    public void apply(Long userId) {
        long count = couponCountRepository.increment();
        if (count > 100) {
            return;
        }
        couponRepository.save(Coupon.builder().userId(userId).build());
    }
}
