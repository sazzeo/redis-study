package com.example.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionService {

    void insert();

    void failedInsert();

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void failedInsertWIthCheckedException() throws Exception;
}
