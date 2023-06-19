package com.example.rediscoupon.coupon.repository;

import com.example.rediscoupon.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon , Long> {
}
