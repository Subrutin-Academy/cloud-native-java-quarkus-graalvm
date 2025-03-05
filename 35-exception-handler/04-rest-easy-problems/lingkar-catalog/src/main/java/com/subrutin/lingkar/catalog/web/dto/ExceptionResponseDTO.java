package com.subrutin.lingkar.catalog.web.dto;

public record ExceptionResponseDTO(
    String status,
    String detail,
    String message
) {

}
