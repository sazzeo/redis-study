package com.example.rediscoupon;

import com.example.rediscoupon.coupon.payload.CouponDto;
import com.example.rediscoupon.coupon.service.ApplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisCouponApplicationTests {

    @Autowired
    private ApplyService applyService;

    @Test
    void contextLoads() {
    }


}
