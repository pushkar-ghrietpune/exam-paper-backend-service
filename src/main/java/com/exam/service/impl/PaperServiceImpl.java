package com.exam.service.impl;

import com.exam.dto.PaperResponseDTO;
import com.exam.entity.Paper;
import com.exam.exception.PaperNotFoundException;
import com.exam.repository.PaperRepository;
import com.exam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaperServiceImpl
        implements PaperService {

    @Autowired
    private PaperRepository paperRepository;

    @Override
    public List<PaperResponseDTO> getPapers(
            Long subjectId) {

        List<Paper> papers =
                paperRepository
                        .findBySubjectIdOrderByYearDesc(
                                subjectId);

        List<PaperResponseDTO> response =
                new ArrayList<>();

        for (Paper paper : papers) {

            PaperResponseDTO dto =
                    new PaperResponseDTO();

            dto.setId(paper.getId());
            dto.setYear(paper.getYear());
            dto.setSemester(paper.getSemester());
            dto.setPaperType(paper.getPaperType());
            dto.setPaperTitle(paper.getPaperTitle());
            dto.setPdfUrl(paper.getPdfUrl());


            response.add(dto);

        }

        return response;

    }

    @Override
    public ResponseEntity<Resource> viewPaper(Long paperId) {

        Paper paper =
                paperRepository.findById(paperId)
                        .orElseThrow(() ->
                                new PaperNotFoundException(
                                        "Paper not found with id : " + paperId));

        Resource resource =
                new ClassPathResource(
                        "papers/" + paper.getPdfFileName());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" +
                                paper.getPdfFileName() + "\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
    @Override
    public ResponseEntity<Resource> downloadPaper(Long paperId) {

        Paper paper =
                paperRepository.findById(paperId)
                        .orElseThrow(() ->
                                new PaperNotFoundException(
                                        "Paper not found with id : " + paperId));

        Resource resource =
                new ClassPathResource(
                        "papers/" + paper.getPdfFileName());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" +
                                paper.getPdfFileName() + "\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

}