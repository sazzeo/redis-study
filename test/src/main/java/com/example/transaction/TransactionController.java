package com.example.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/transaction")
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public String update() {
        transactionService.insert();
        return "ok";
    }

}
