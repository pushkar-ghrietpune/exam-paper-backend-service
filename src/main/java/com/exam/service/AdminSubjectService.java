package com.exam.service;

import com.exam.dto.SubjectRequestDTO;
import com.exam.entity.Subject;

import java.util.List;

public interface AdminSubjectService {
    Subject createSubject(
            SubjectRequestDTO dto);

    List<Subject> getSubjects();

    Subject updateSubject(
            Long id,
            SubjectRequestDTO dto);

    void deleteSubject(
            Long id);
}
