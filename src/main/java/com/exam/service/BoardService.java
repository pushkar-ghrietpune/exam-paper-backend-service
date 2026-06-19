package com.exam.service;

import com.exam.dto.BoardResponseDTO;

import java.util.List;

public interface BoardService {

    List<BoardResponseDTO> getBoards();

}