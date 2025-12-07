package com.subrutin.lingkar.catalog.domain.dto;

import java.util.List;

public record PageQuery<E>(
    List<E> result,
    Integer pages,
    Long elements
) {

}
