package com.example.rediscouponconsumer.coupon.service;

import com.example.rediscouponconsumer.coupon.domain.Coupon;
import com.example.rediscouponconsumer.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class CouponCreateConsumer {

    private final CouponRepository couponRepository;

    @KafkaListener(topics = "coupon_create" , groupId = "group_1")
    public void listener(Long userId) {
       couponRepository.save(Coupon.builder().userId(userId).build());
    }

}
