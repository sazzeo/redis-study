package com.example.rediscouponconsumer.coupon.repository;


import com.example.rediscouponconsumer.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
