package com.example.rediscoupon.coupon.service;

import com.example.rediscoupon.coupon.domain.Coupon;
import com.example.rediscoupon.coupon.payload.CouponDto;
import com.example.rediscoupon.coupon.repository.CouponCountRepository;
import com.example.rediscoupon.coupon.repository.CouponRepository;
import com.example.rediscoupon.producer.CouponCreateProducer;
import com.example.rediscoupon.user.repository.AppliedUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class ApplyService {

    private final CouponCountRepository couponCountRepository;

    private final CouponCreateProducer couponCreateProducer;

    private final AppliedUserRepository appliedUserRepository;

    public void apply(Long userId) {
        Long add = appliedUserRepository.add(userId); //set으로 중복 잡기
        if (add != 1) {
            return;
        }
        long count = couponCountRepository.increment();

        if (count > 1000) {
            return;
        }
        couponCreateProducer.create(userId);
    }

}
