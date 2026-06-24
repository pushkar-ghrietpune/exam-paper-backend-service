package com.exam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaperResponseDTO {


    private Long id;

    private Integer year;

    private Integer semester;

    private String paperType;

    private String paperTitle;

    private Long subjectId;

    private String subjectName;

    private String pdfFileName;

    private String pdfUrl;

    private Boolean isActive;

    public PaperResponseDTO() {
    }

    public PaperResponseDTO(
            Long id,
            Integer year,
            Integer semester,
            String paperType,
            String paperTitle,
            Long subjectId,
            String subjectName,
            String pdfFileName,
            String pdfUrl,
            Boolean isActive) {

        this.id = id;
        this.year = year;
        this.semester = semester;
        this.paperType = paperType;
        this.paperTitle = paperTitle;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.pdfFileName = pdfFileName;
        this.pdfUrl = pdfUrl;
        this.isActive = isActive;
    }


}
