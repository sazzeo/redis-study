package com.example.rediscouponconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //스프링 스케쥴러
@SpringBootApplication
public class RedisCouponConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCouponConsumerApplication.class, args);
    }

}
