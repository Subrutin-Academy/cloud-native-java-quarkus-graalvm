package com.subrutin.lingkar.catalog.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AuthorRequestDTO(
    
    @NotBlank
    String name,
    @NotBlank
    String birthPlace,//snake_case
    @NotNull
    Long birthDate,
    String description
) {

}
