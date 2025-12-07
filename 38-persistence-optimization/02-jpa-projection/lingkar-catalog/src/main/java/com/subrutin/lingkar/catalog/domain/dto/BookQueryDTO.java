package com.subrutin.lingkar.catalog.domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record BookQueryDTO(
    Long bookId,
    String bookTitle,
    String bookDescription,
    Long publisherId,
    String publisherName
) {

}
