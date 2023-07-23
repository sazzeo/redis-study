package com.example.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionalChildService {
    void failedInsert();

    void failedInsertWIthCheckedException() throws Exception;
}
