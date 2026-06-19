package com.exam.service.impl;

import com.exam.dto.SubjectResponseDTO;
import com.exam.entity.Paper;
import com.exam.entity.Subject;
import com.exam.repository.PaperRepository;
import com.exam.repository.SubjectRepository;
import com.exam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private PaperRepository paperRepository;

    @Override
    public List<SubjectResponseDTO> getSubjects() {

        List<Subject> subjects = subjectRepository.findAll();

        List<SubjectResponseDTO> response = new ArrayList<>();

        for (Subject subject : subjects) {

            SubjectResponseDTO dto =
                    new SubjectResponseDTO();

            dto.setId(subject.getId());
            dto.setName(subject.getName());

            response.add(dto);
        }

        return response;
    }

    @Override
    public List<SubjectResponseDTO> getSubjects(Long classId) {

        List<Subject> subjects = subjectRepository.findByClassEntityId(classId);

        List<SubjectResponseDTO> response = new ArrayList<>();

        for (Subject subject : subjects) {

            SubjectResponseDTO dto =
                    new SubjectResponseDTO();

            dto.setId(subject.getId());
            dto.setName(subject.getName());

            response.add(dto);
        }

        return response;
    }

}