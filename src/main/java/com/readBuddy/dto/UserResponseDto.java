package com.readBuddy.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;

    public UserResponseDto(Long id) {
        this.id = id;
    }
}
