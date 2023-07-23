package com.example.rediscouponconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class RedisCouponConsumerApplicationTests {

    @Test
    void contextLoads() {
        TestService testService = new TestService();
    }


    private class TestService {
    }
}
