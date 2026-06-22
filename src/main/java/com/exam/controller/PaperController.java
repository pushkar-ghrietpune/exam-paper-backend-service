package com.exam.controller;

import com.exam.dto.PaperResponseDTO;
import com.exam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;

import java.util.List;

@RestController
@RequestMapping("/static/papers")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping
    public List<PaperResponseDTO> getPapers(
            @RequestParam Long subjectId) {

        return paperService.getPapers(subjectId);

    }

    @GetMapping("/view/{paperId}")
    public ResponseEntity<Resource> viewPaper(
            @PathVariable Long paperId) {

        return paperService.viewPaper(paperId);

    }

    @GetMapping("/download/{paperId}")
    public ResponseEntity<Resource> downloadPaper(
            @PathVariable Long paperId) {

        return paperService.downloadPaper(paperId);

    }

}