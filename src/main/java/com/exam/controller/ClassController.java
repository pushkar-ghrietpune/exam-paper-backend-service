package com.exam.controller;

import com.exam.dto.ClassResponseDTO;
import com.exam.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassResponseDTO> getClasses() {

        return classService.getClasses();

    }
}