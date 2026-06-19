package com.exam.service.impl;

import com.exam.dto.BoardResponseDTO;
import com.exam.entity.Board;
import com.exam.repository.BoardRepository;
import com.exam.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardResponseDTO> getBoards() {

        List<Board> boards = boardRepository.findAll();

        List<BoardResponseDTO> response =
                new ArrayList<>();

        for (Board board : boards) {

            BoardResponseDTO dto =
                    new BoardResponseDTO();

            dto.setId(board.getId());
            dto.setName(board.getName());

            response.add(dto);
        }

        return response;
    }
}