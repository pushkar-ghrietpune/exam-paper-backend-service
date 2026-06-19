package com.exam.service;

import com.exam.dto.PaperResponseDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaperService {

    List<PaperResponseDTO> getPapers(
            Long subjectId);

    ResponseEntity<Resource> viewPaper(Long paperId);
    ResponseEntity<Resource> downloadPaper(Long paperId);

}