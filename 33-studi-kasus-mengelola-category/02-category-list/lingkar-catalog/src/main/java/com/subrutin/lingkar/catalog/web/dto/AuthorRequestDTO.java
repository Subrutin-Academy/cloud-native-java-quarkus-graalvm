package com.subrutin.lingkar.catalog.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.subrutin.lingkar.catalog.validator.annotation.PastDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AuthorRequestDTO(
    
    @NotBlank
    String name,
    @NotBlank
    String birthPlace,//snake_case
    @NotNull @PastDate
    Long birthDate,
    @Size(max = 2000)
    String description
) {

}
