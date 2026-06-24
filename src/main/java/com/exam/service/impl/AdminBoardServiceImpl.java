package com.exam.service.impl;

import com.exam.dto.BoardRequestDTO;
import com.exam.entity.Board;
import com.exam.repository.BoardRepository;
import com.exam.service.AdminBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminBoardServiceImpl implements AdminBoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board createBoard(BoardRequestDTO dto) {
        Board board = new Board();
        board.setName(dto.getName());

        return boardRepository.save(board);
    }

    @Override
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    @Override
    public Board updateBoard(Long id, BoardRequestDTO dto) {
        Board board =
                boardRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Board not found"));

        board.setName(dto.getName());

        return boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
