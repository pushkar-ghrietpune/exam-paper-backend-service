package com.exam.service;

import com.exam.dto.ClassRequestDTO;
import com.exam.entity.ClassEntity;

import java.util.List;

public interface AdminClassService {
    ClassEntity createClass(
            ClassRequestDTO dto);

    List<ClassEntity> getClasses();

    ClassEntity updateClass(
            Long id,
            ClassRequestDTO dto);

    void deleteClass(
            Long id);
}
