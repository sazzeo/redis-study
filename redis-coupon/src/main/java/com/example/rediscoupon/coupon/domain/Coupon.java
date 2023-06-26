package com.example.rediscoupon.coupon.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDateTime issueAt;

    @Builder.Default
    private boolean isUpdate = false;

    public void setUpdate(boolean update) {
        this.isUpdate = update;
        this.issueAt = LocalDateTime.now();
    }
}
