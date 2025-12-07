package com.subrutin.lingkar.catalog.web.dto;

import java.util.List;

public record BookUpdateRequestDTO(
    String title,
    String description,
    Integer pages,
    Integer year,
    Long publisherId,
    List<Long> authorIds,
    List<String> categoryCodes
) {
}