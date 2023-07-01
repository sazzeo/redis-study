package com.example.rediscoupon.coupon.controller;

import com.example.rediscoupon.coupon.service.ApplyService;
import com.example.rediscoupon.user.payload.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/coupon")
@RestController
public class CouponController {

    private final ApplyService applyService;

    @PostMapping
    public String addCoupon(@RequestBody UserDto userDto) {
        applyService.apply(userDto.getUserId());
        return "ok";
    }
}
