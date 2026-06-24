package com.exam.controller;

import com.exam.dto.SubjectRequestDTO;
import com.exam.entity.Subject;
import com.exam.service.AdminSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/subjects")
public class AdminSubjectController {

    @Autowired
    private AdminSubjectService adminSubjectService;

    // Create Subject
    @PostMapping
    public Subject createSubject(
            @RequestBody SubjectRequestDTO dto) {

        return adminSubjectService.createSubject(
                dto);
    }

    // Get All Subjects
    @GetMapping
    public List<Subject> getSubjects() {

        return adminSubjectService.getSubjects();
    }

    // Update Subject
    @PutMapping("/{id}")
    public Subject updateSubject(
            @PathVariable Long id,
            @RequestBody SubjectRequestDTO dto) {

        return adminSubjectService.updateSubject(
                id,
                dto);
    }

    // Delete Subject
    @DeleteMapping("/{id}")
    public void deleteSubject(
            @PathVariable Long id) {

        adminSubjectService.deleteSubject(
                id);
    }

}