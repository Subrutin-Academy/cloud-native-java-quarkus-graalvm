package com.subrutin.lingkar.catalog.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryUpdateRequestDTO(
    @NotBlank String name,
    String description
) {

}
