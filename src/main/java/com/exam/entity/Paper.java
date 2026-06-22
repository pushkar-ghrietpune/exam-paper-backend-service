package com.exam.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "papers")
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    private Integer semester;

    @Column(name = "exam_type")
    private String paperType;

    private String paperTitle;

    @Column(name = "pdf_file_name")
    private String pdfFileName;

    private String pdfUrl;

    private Long fileSizeKb;

    private Long viewCount;

    private Long downloadCount;

    private Boolean isActive;

    private LocalDateTime uploadDate;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Paper() {
    }


}