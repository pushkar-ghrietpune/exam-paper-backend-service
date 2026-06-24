package com.exam.service.impl;

import com.exam.dto.SubjectRequestDTO;
import com.exam.entity.ClassEntity;
import com.exam.entity.Subject;
import com.exam.repository.ClassRepository;
import com.exam.repository.SubjectRepository;
import com.exam.service.AdminSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSubjectServiceImpl implements AdminSubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ClassRepository classRepository;
    @Override
    public Subject createSubject(
            SubjectRequestDTO dto) {

        ClassEntity classEntity =
                classRepository.findById(
                                dto.getClassId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Class not found"));

        Subject subject =
                new Subject();

        subject.setName(
                dto.getName());

        subject.setClassEntity(
                classEntity);

        return subjectRepository.save(
                subject);
    }

    @Override
    public List<Subject> getSubjects() {

        return subjectRepository.findAll();
    }

    @Override
    public Subject updateSubject(
            Long id,
            SubjectRequestDTO dto) {

        Subject subject =
                subjectRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Subject not found"));

        ClassEntity classEntity =
                classRepository.findById(
                                dto.getClassId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Class not found"));

        subject.setName(
                dto.getName());

        subject.setClassEntity(
                classEntity);

        return subjectRepository.save(
                subject);
    }

    @Override
    public void deleteSubject(
            Long id) {

        subjectRepository.deleteById(id);
    }
}
