package com.exam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaperRequestDTO {
    private Integer year;

    private Integer semester;

    private String paperType;

    private String paperTitle;

    private Long subjectId;

    private Boolean isActive;
}
