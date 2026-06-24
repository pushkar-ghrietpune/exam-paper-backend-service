package com.exam.service;

import com.exam.dto.BoardRequestDTO;
import com.exam.entity.Board;

import java.util.List;

public interface AdminBoardService {
    Board createBoard(BoardRequestDTO dto);

    List<Board> getBoards();

    Board updateBoard(Long id, BoardRequestDTO dto);

    void deleteBoard(Long id);
}
