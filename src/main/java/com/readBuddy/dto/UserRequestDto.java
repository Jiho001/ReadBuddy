package com.readBuddy.dto;

import com.readBuddy.domain.Genre;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    private String name;
    private Genre genre;
}
