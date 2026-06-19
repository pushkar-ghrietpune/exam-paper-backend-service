package com.exam.service.impl;

import com.exam.dto.ClassResponseDTO;
import com.exam.entity.ClassEntity;
import com.exam.repository.ClassRepository;
import com.exam.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<ClassResponseDTO> getClasses() {

        List<ClassEntity> classes =
                classRepository.findAll();

        List<ClassResponseDTO> response =
                new ArrayList<>();

        for (ClassEntity classEntity : classes) {

            ClassResponseDTO dto =
                    new ClassResponseDTO();

            dto.setId(classEntity.getId());
            dto.setName(classEntity.getName());

            response.add(dto);
        }

        return response;
    }
}