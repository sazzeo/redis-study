package com.example.redisstudy.board.repository;

import com.example.redisstudy.board.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, String> {
}
