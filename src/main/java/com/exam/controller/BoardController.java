package com.exam.controller;

import com.exam.dto.BoardResponseDTO;
import com.exam.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<BoardResponseDTO> getBoards() {

        return boardService.getBoards();

    }
}