package com.example.transaction;

import com.example.board.domain.Board;
import com.example.board.payload.BoardDto;
import com.example.board.repository.BoardRepository;
import com.example.exception.FailedInsertException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@RequiredArgsConstructor
@Service
public class TransactionalChildServiceImpl implements TransactionalChildService {
    private final BoardRepository boardRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void failedInsert() {
        BoardDto dto = BoardDto.getDefault();
        Board board = BoardDto.toEntity(dto);
        boardRepository.save(board);
        throw new FailedInsertException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void failedInsertWIthCheckedException() throws Exception {
        BoardDto dto = BoardDto.getDefault();
        Board board = BoardDto.toEntity(dto);
        boardRepository.save(board);
        throw new Exception();
    }
}
