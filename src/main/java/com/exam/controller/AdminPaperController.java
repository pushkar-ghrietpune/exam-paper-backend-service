package com.exam.controller;

import com.exam.dto.PaperRequestDTO;
import com.exam.dto.PaperResponseDTO;
import com.exam.entity.Paper;
import com.exam.service.AdminPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin/papers")
public class AdminPaperController {

    @Autowired
    private AdminPaperService adminPaperService;


    // Create Paper
    @PostMapping
    public Paper createPaper(

            @RequestParam Integer year,

            @RequestParam Integer semester,

            @RequestParam String paperType,

            @RequestParam String paperTitle,

            @RequestParam Long subjectId,

            @RequestParam Boolean isActive,

            @RequestParam MultipartFile file) {

        return adminPaperService.createPaper(

                year,

                semester,

                paperType,

                paperTitle,

                subjectId,

                isActive,

                file);
    }


    // Get All Papers
    @GetMapping
    public List<PaperResponseDTO> getPapers() {

        return adminPaperService.getPapers();
    }


    // Update Paper
    @PutMapping("/{id}")
    public Paper updatePaper(

            @PathVariable Long id,

            @RequestParam Integer year,

            @RequestParam Integer semester,

            @RequestParam String paperType,

            @RequestParam String paperTitle,

            @RequestParam Long subjectId,

            @RequestParam Boolean isActive,

            @RequestParam(required = false)
            MultipartFile file) {

        return adminPaperService.updatePaper(

                id,

                year,

                semester,

                paperType,

                paperTitle,

                subjectId,

                isActive,

                file);
    }


    // Delete Paper
    @DeleteMapping("/{id}")
    public void deletePaper(
            @PathVariable Long id) {

        adminPaperService.deletePaper(
                id);
    }


}