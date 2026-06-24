package com.exam.controller;

import com.exam.dto.BoardRequestDTO;
import com.exam.entity.Board;
import com.exam.service.AdminBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/boards")
public class AdminBoardController {

    @Autowired
    private AdminBoardService adminBoardService;

    // Create Board
    @PostMapping
    public Board createBoard(
            @RequestBody BoardRequestDTO boardRequestDTO) {

        return adminBoardService.createBoard(boardRequestDTO);
    }

    // Get All Boards
    @GetMapping
    public List<Board> getBoards() {

        return adminBoardService.getBoards();
    }

    // Update Board
    @PutMapping("/{id}")
    public Board updateBoard(
            @PathVariable Long id,
            @RequestBody BoardRequestDTO boardRequestDTO) {

        return adminBoardService.updateBoard(
                id,
                boardRequestDTO);
    }

    // Delete Board
    @DeleteMapping("/{id}")
    public void deleteBoard(
            @PathVariable Long id) {

        adminBoardService.deleteBoard(id);
    }

}