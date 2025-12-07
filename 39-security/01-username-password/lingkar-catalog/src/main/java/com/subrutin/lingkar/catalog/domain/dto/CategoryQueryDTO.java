package com.subrutin.lingkar.catalog.domain.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record CategoryQueryDTO(
	Long bookId,
	String categoryCode,
	String categoryName    
) {

}
