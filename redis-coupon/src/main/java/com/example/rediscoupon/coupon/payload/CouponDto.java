package com.example.rediscoupon.coupon.payload;

import com.example.rediscoupon.coupon.domain.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
@AllArgsConstructor
@Getter
public class CouponDto {

    private Long id;

    private Long userId;

    private LocalDateTime issueAt;

    public static Coupon toEntity(CouponDto dto) {
        return Coupon.builder()
                .userId(dto.userId)
                .issueAt(LocalDateTime.now())
                .build();
    }
}
