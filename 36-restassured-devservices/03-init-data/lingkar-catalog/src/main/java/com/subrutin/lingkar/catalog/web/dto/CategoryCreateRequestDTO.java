package com.subrutin.lingkar.catalog.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequestDTO(
    @NotBlank String code,
    @NotBlank String name,
    String description
) {

}
