package com.readBuddy.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;

    public BookDto(Long id) {
        this.id = id;
    }
}
