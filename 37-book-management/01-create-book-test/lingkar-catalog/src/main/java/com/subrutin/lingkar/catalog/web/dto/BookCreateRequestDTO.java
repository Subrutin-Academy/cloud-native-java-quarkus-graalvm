package com.subrutin.lingkar.catalog.web.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record BookCreateRequestDTO(
        String title,
        String description,
        Integer pages,
        Integer year,
        Integer publisherId,
        List<Integer> authorsId,
        List<String> categoriesCode) {

}
