package com.exam.service.impl;

import com.exam.dto.ClassRequestDTO;
import com.exam.entity.Board;
import com.exam.entity.ClassEntity;
import com.exam.repository.BoardRepository;
import com.exam.repository.ClassRepository;
import com.exam.service.AdminClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminClassServiceImpl implements AdminClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public ClassEntity createClass(
            ClassRequestDTO dto) {

        Board board =
                boardRepository.findById(
                                dto.getBoardId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Board not found"));

        ClassEntity classEntity =
                new ClassEntity();

        classEntity.setName(
                dto.getName());

        classEntity.setDisplayOrder(
                dto.getDisplayOrder());

        classEntity.setBoard(
                board);

        return classRepository.save(
                classEntity);
    }

    @Override
    public List<ClassEntity> getClasses() {

        return classRepository.findAll();
    }

    @Override
    public ClassEntity updateClass(
            Long id,
            ClassRequestDTO dto) {

        ClassEntity classEntity =
                classRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Class not found"));

        Board board =
                boardRepository.findById(
                                dto.getBoardId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Board not found"));

        classEntity.setName(
                dto.getName());

        classEntity.setDisplayOrder(
                dto.getDisplayOrder());

        classEntity.setBoard(
                board);

        return classRepository.save(
                classEntity);
    }

    @Override
    public void deleteClass(
            Long id) {

        classRepository.deleteById(id);
    }
}
