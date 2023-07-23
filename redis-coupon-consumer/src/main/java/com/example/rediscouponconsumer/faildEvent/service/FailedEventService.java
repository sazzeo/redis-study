package com.example.rediscouponconsumer.faildEvent.service;

import com.example.rediscouponconsumer.faildEvent.repository.FailedEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class FailedEventService {

    private final FailedEventRepository failedEventRepository;

    @Scheduled(fixedDelay = 1000)
    public void run() {
        System.out.println("hello!!");
    }



}
