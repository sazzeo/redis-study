package com.example.rediscoupon.coupon.service;

import com.example.rediscoupon.coupon.domain.Coupon;
import com.example.rediscoupon.coupon.repository.CouponRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApplyService {
    private final CouponRepository couponRepository;

    public void apply(Long userId) {
        long count = couponRepository.count();
        if(count > 100) {
            return;
        }
        couponRepository.save(Coupon.builder().userId(userId).build());
    }
}
