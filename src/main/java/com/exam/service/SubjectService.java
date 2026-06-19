package com.exam.service;

import com.exam.dto.SubjectResponseDTO;

import java.util.List;

public interface SubjectService {

    List<SubjectResponseDTO> getSubjects();

    List<SubjectResponseDTO> getSubjects(Long classId);

}