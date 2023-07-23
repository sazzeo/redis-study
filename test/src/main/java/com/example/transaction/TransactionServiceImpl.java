package com.example.transaction;

import com.example.board.domain.Board;
import com.example.board.payload.BoardDto;
import com.example.board.repository.BoardRepository;
import com.example.exception.FailedInsertException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final BoardRepository boardRepository;
    private final TransactionalChildService transactionalChildService;

    @Transactional
    @Override
    public void insert() {
        BoardDto dto = BoardDto.getDefault();
        Board board = BoardDto.toEntity(dto);
        boardRepository.save(board);
        try {
            failedInsertWIthCheckedException();
        } catch (Exception e) {
            log.info("insert 실패 처리");
        }
    }

    @Transactional()
    @Override
    public void failedInsert() {
        BoardDto dto = BoardDto.getDefault();
        Board board = BoardDto.toEntity(dto);
        boardRepository.save(board);
        throw new FailedInsertException();

    }

    @Override
    public void failedInsertWIthCheckedException() throws Exception {
        BoardDto dto = BoardDto.getDefault();
        Board board = BoardDto.toEntity(dto);
        boardRepository.save(board);
        throw new Exception();
    }
}
