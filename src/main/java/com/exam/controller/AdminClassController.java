package com.exam.controller;

import com.exam.dto.ClassRequestDTO;
import com.exam.entity.ClassEntity;
import com.exam.service.AdminClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/classes")
public class AdminClassController {

    @Autowired
    private AdminClassService adminClassService;

    @PostMapping
    public ClassEntity createClass(
            @RequestBody ClassRequestDTO dto) {

        return adminClassService.createClass(
                dto);
    }

    @GetMapping
    public List<ClassEntity> getClasses() {

        return adminClassService.getClasses();
    }

    @PutMapping("/{id}")
    public ClassEntity updateClass(
            @PathVariable Long id,
            @RequestBody ClassRequestDTO dto) {

        return adminClassService.updateClass(
                id,
                dto);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(
            @PathVariable Long id) {

        adminClassService.deleteClass(
                id);
    }

}