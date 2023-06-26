package com.example.rediscoupon.coupon.service;

import com.example.rediscoupon.coupon.domain.Coupon;
import com.example.rediscoupon.coupon.event.CouponTransactionListener;
import com.example.rediscoupon.coupon.payload.CouponDto;
import com.example.rediscoupon.coupon.repository.CouponCountRepository;
import com.example.rediscoupon.coupon.repository.CouponRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@Service
public class ApplyService {
    private final CouponRepository couponRepository;

    private final CouponCountRepository couponCountRepository;

    private final CouponTransactionListener couponTransactionListener;


    public void apply(Long userId) {
        long count = couponCountRepository.increment();
        if (count > 100) {
            return;
        }
        couponRepository.save(Coupon.builder().userId(userId).build());
    }

    @Transactional
    public void create(CouponDto couponDto) {
        Coupon coupon = CouponDto.toEntity(couponDto);
        couponRepository.save(coupon);
        couponTransactionListener.afterRollback(coupon);
        log.info("service :: issueAt "  + coupon.getIssueAt());
        throw new RuntimeException();
    }
}
