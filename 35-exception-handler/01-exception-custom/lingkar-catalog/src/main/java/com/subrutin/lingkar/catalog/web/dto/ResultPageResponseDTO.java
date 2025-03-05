package com.subrutin.lingkar.catalog.web.dto;

import java.util.List;

public record ResultPageResponseDTO<T>(
    List<T> result,
    Integer pages,
    Long elements
) {

}
