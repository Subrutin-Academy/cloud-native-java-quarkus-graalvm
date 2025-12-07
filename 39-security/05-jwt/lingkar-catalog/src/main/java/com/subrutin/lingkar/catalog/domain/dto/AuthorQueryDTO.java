package com.subrutin.lingkar.catalog.domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record AuthorQueryDTO(
    Long bookId,
	Long authorId,
	String authorName) {

}
