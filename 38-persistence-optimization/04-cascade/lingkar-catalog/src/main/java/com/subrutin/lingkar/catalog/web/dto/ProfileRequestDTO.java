package com.subrutin.lingkar.catalog.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProfileRequestDTO(
    Long birthDate, 
    String address, 
    String zipCode
) {

}
