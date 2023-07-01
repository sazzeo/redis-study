package com.example.rediscoupon.coupon.service;

import com.example.rediscoupon.coupon.domain.Coupon;
import com.example.rediscoupon.coupon.payload.CouponDto;
import com.example.rediscoupon.coupon.repository.CouponCountRepository;
import com.example.rediscoupon.coupon.repository.CouponRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class ApplyService {
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository;

    public void apply(Long userId) {
        long count = couponCountRepository.increment();
        if (count > 50000) {
            return;
        }
        couponRepository.save(Coupon.builder().userId(userId).build());
    }
}
