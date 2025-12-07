package com.subrutin.lingkar.catalog.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record LoginRequestDTO(
    @NotBlank
    String username,
    @NotBlank
    String password
) {

}
