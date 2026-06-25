package com.exam.service.impl;

import com.exam.dto.PaperResponseDTO;
import com.exam.entity.Paper;
import com.exam.exception.PaperNotFoundException;
import com.exam.repository.PaperRepository;
import com.exam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaperServiceImpl
        implements PaperService {

    @Autowired
    private PaperRepository paperRepository;
    @Value("${file.upload-dir}")
    private String uploadDir;

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
    public ResponseEntity viewPaper(
            Long paperId) {

        Paper paper =
                paperRepository.findById(
                                paperId)

                        .orElseThrow(

                                () -> new PaperNotFoundException(

                                        "Paper not found with id : "
                                                + paperId));

        try {

            Path path =
                    Paths.get(
                            uploadDir,
                            paper.getPdfFileName());

            Resource resource =
                    new UrlResource(
                            path.toUri());

            if (
                    !resource.exists()
            ) {

                throw new RuntimeException(
                        "PDF file not found");

            }

            System.out.println(
                    "uploadDir = " + uploadDir);

            System.out.println(
                    "pdfFileName = " + paper.getPdfFileName());

            System.out.println(
                    "Full Path = "
                            + Paths.get(
                                    uploadDir,
                                    paper.getPdfFileName())
                            .toAbsolutePath());

            return ResponseEntity.ok()

                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,

                            "inline; filename=\""
                                    +
                                    paper.getPdfFileName()
                                    +
                                    "\"")

                    .contentType(
                            MediaType.APPLICATION_PDF)

                    .body(
                            resource);

        }

        catch (MalformedURLException e) {

            throw new RuntimeException(
                    "Unable to load PDF",
                    e);

        }

    }
    @Override
    public ResponseEntity<Resource> downloadPaper(Long paperId) {


        Paper paper =
                paperRepository.findById(paperId)
                        .orElseThrow(() ->
                                new PaperNotFoundException(
                                        "Paper not found with id : " + paperId));

        try {

            Path path =
                    Paths.get(
                            uploadDir,
                            paper.getPdfFileName());

            Resource resource =
                    new UrlResource(
                            path.toUri());

            if (!resource.exists()) {

                throw new RuntimeException(
                        "PDF file not found : "
                                + path.toAbsolutePath());

            }

            return ResponseEntity.ok()

                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\""
                                    + paper.getPdfFileName()
                                    + "\"")

                    .contentType(
                            MediaType.APPLICATION_PDF)

                    .body(
                            resource);

        }

        catch (MalformedURLException e) {

            throw new RuntimeException(
                    "Unable to load PDF",
                    e);

        }


    }

}