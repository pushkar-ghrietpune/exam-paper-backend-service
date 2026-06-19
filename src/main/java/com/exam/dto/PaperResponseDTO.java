package com.exam.dto;

public class PaperResponseDTO {

    private Long id;
    private Integer year;
    private Integer semester;
    private String paperType;
    private String paperTitle;
    private String pdfUrl;
    private String pdfFileName;

    public PaperResponseDTO() {
    }

    public PaperResponseDTO(Long id,
                            Integer year,
                            Integer semester,
                            String paperType,
                            String pdfUrl,
                            String paperTitle,
                            String pdfFileName) {

        this.id = id;
        this.year = year;
        this.semester = semester;
        this.paperType = paperType;
        this.paperTitle = paperTitle;
        this.pdfUrl = pdfUrl;
        this.pdfFileName = pdfFileName;
    }

    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getSemester() {
        return semester;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }


    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }
}