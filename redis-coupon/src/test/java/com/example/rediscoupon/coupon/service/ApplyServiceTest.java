package com.example.rediscoupon.coupon.service;


import com.example.rediscoupon.coupon.repository.CouponRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ApplyServiceTest {

    @Autowired
    private ApplyService applyService;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @BeforeEach
    void setUp() {
        couponRepository.deleteAll();
    }

    @Test
    public void 한번만응묘() {
        applyService.apply(1L);
        long count = couponRepository.count();
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 여러명응모() throws InterruptedException {
        int threadCount = 1000;

        //ExecutorService : 각기 다른 Thread를 생성해서 작업을 처리하고 처리가 완료되면 Thread를 제거하는 작업을 자동으로 해줌
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        
        //다른 스레드에서 사용하는 작업을 기다려주는 클래스
        CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i=0 ; i < threadCount ; i++) {
            long userId = i;
            executorService.submit(()-> {
                try {
                    applyService.apply(userId);
                }finally {
                    latch.countDown();
                }
            });
        }
        latch.await(); //메인스레드 멈춤 (위 코드가 다 실행되고 아래 코드를 실행시켜준다)
        
        long count = couponRepository.count();
        assertThat(count).isEqualTo(100);
    }
}