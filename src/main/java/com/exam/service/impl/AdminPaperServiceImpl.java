package com.exam.service.impl;

import com.exam.dto.PaperResponseDTO;
import com.exam.entity.Paper;
import com.exam.entity.Subject;
import com.exam.repository.PaperRepository;
import com.exam.repository.SubjectRepository;
import com.exam.service.AdminPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import java.util.List;

@Service
public class AdminPaperServiceImpl implements AdminPaperService {
    @Autowired
    private PaperRepository paperRepository;
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Paper createPaper(

            Integer year,

            Integer semester,

            String paperType,

            String paperTitle,

            Long subjectId,

            Boolean isActive,

            MultipartFile file) {

        try {

            Subject subject =
                    subjectRepository.findById(subjectId)
                            .orElseThrow(
                                    () -> new RuntimeException(
                                            "Subject not found"));

            // Create upload directory if not present
            Path uploadPath =
                    Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {

                Files.createDirectories(uploadPath);

            }

            // Generate unique filename
            String fileName =
                    UUID.randomUUID()
                            + "_"
                            + file.getOriginalFilename();

            // Save file
            Path destination =
                    uploadPath.resolve(fileName);

            Files.copy(
                    file.getInputStream(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING);

            // Create paper entity
            Paper paper =
                    new Paper();

            paper.setYear(year);

            paper.setSemester(semester);

            paper.setPaperType(paperType);

            paper.setPaperTitle(paperTitle);

            paper.setPdfFileName(fileName);

            paper.setPdfUrl( "/papers/" + fileName);

            paper.setSubject(subject);

            paper.setIsActive(isActive);

            paper.setViewCount(0L);

            paper.setDownloadCount(0L);

            return paperRepository.save(paper);

        }
        catch (IOException e) {

            throw new RuntimeException(
                    "Failed to upload paper",
                    e);
        }
    }
    @Override
    public List getPapers() {

        return paperRepository
                .findAll()
                .stream()
                .map(

                        paper ->

                                new PaperResponseDTO(

                                        paper.getId(),

                                        paper.getYear(),

                                        paper.getSemester(),

                                        paper.getPaperType(),

                                        paper.getPaperTitle(),

                                        paper.getSubject().getId(),

                                        paper.getSubject().getName(),

                                        paper.getPdfFileName(),

                                        paper.getPdfUrl(),

                                        paper.getIsActive()

                                )

                )
                .toList();

    }

    @Override
    public Paper updatePaper(

            Long id,

            Integer year,

            Integer semester,

            String paperType,

            String paperTitle,

            Long subjectId,

            Boolean isActive,

            MultipartFile file) {

        try {

            Paper paper =
                    paperRepository.findById(id)
                            .orElseThrow(
                                    () -> new RuntimeException(
                                            "Paper not found"));

            Subject subject =
                    subjectRepository.findById(subjectId)
                            .orElseThrow(
                                    () -> new RuntimeException(
                                            "Subject not found"));

            paper.setYear(year);

            paper.setSemester(semester);

            paper.setPaperType(paperType);

            paper.setPaperTitle(paperTitle);

            paper.setIsActive(isActive);

            paper.setSubject(subject);

            // Replace PDF only if a new file is provided
            if (file != null && !file.isEmpty()) {

                // delete old pdf
                Path oldFile =
                        Paths.get(
                                uploadDir,
                                paper.getPdfFileName());

                Files.deleteIfExists(oldFile);

                // generate new file name
                String fileName =
                        UUID.randomUUID()
                                + "_"
                                + file.getOriginalFilename();

                Path destination =
                        Paths.get(
                                uploadDir,
                                fileName);

                Files.copy(
                        file.getInputStream(),
                        destination,
                        StandardCopyOption.REPLACE_EXISTING);

                paper.setPdfFileName(fileName);

                paper.setPdfUrl("/papers/" + fileName);
            }

            return paperRepository.save(paper);

        }
        catch (IOException e) {

            throw new RuntimeException(
                    "Failed to update paper",
                    e);
        }
    }

    @Override
    public void deletePaper(
            Long id) {

        try {

            Paper paper =
                    paperRepository.findById(id)
                            .orElseThrow(
                                    () -> new RuntimeException(
                                            "Paper not found"));

            // delete physical file
            Path filePath =
                    Paths.get(
                            uploadDir,
                            paper.getPdfFileName());

            Files.deleteIfExists(
                    filePath);

            // delete database row
            paperRepository.delete(
                    paper);

        }
        catch (IOException e) {

            throw new RuntimeException(
                    "Failed to delete paper",
                    e);
        }
    }

}
