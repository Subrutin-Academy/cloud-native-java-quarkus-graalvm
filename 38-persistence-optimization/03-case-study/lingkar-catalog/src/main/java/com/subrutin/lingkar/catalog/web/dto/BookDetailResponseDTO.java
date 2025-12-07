package com.subrutin.lingkar.catalog.web.dto;

import java.util.Set;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record BookDetailResponseDTO(
    Long id, 
    String title,
    String description,
    Integer pages,
    Integer year,
    PublisherListResponseDTO publisher,
    Set<AuthorListResponseDTO> authors,
    Set<CategoryListResponseDTO> categories
) {

}
