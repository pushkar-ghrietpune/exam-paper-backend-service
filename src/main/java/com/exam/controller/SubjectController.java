package com.exam.controller;

import com.exam.dto.SubjectResponseDTO;
import com.exam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<SubjectResponseDTO> getSubjectsByClassId(@RequestParam Long classId) {

        return subjectService.getSubjects(classId);

    }
}