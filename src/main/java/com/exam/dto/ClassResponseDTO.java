package com.exam.dto;

public class ClassResponseDTO {


    private Long id;

    private String name;

    private Integer displayOrder;

    private Long boardId;

    private String boardName;

    public ClassResponseDTO() {
    }

    public ClassResponseDTO(
            Long id,
            String name,
            Integer displayOrder,
            Long boardId,
            String boardName) {

        this.id = id;
        this.name = name;
        this.displayOrder = displayOrder;
        this.boardId = boardId;
        this.boardName = boardName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }


}
