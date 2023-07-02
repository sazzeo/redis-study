package com.example.rediscouponconsumer.faildEvent.repository;

import com.example.rediscouponconsumer.faildEvent.domain.FailedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailedEventRepository extends JpaRepository<FailedEvent, Long> {
}
