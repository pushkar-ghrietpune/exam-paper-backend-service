package com.exam.service;

import com.exam.dto.PaperRequestDTO;
import com.exam.dto.PaperResponseDTO;
import com.exam.entity.Paper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminPaperService {

    Paper createPaper(

            Integer year,

            Integer semester,

            String paperType,

            String paperTitle,

            Long subjectId,

            Boolean isActive,

            MultipartFile file);

    List<PaperResponseDTO> getPapers();

    Paper updatePaper(

            Long id,

            Integer year,

            Integer semester,

            String paperType,

            String paperTitle,

            Long subjectId,

            Boolean isActive,

            MultipartFile file);

    void deletePaper(
            Long id);

}