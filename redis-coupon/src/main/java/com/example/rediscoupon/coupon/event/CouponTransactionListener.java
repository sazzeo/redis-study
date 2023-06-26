package com.example.rediscoupon.coupon.event;

import com.example.rediscoupon.coupon.domain.Coupon;
import com.example.rediscoupon.coupon.repository.CouponRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class CouponTransactionListener {

    private final CouponRepository couponRepository;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(Coupon coupon) {
        coupon.setUpdate(true); //트랜잭션 물고 들어오는지 확인
        log.info( "afterCommit :: issueAt " + coupon.getIssueAt());
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void afterCompletion(CouponEvent event) {
        log.info("afterCompletion");
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void afterRollback(Coupon coupon) {
        couponRepository.save(coupon);
        log.info("afterRollback");
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(CouponEvent event) {
        log.info("beforeCommit");
    }


}
