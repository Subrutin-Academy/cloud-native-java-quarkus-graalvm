package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.PublisherCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherDetailResponseDTO;

public interface PublisherService {

    public void createPublisher(PublisherCreateRequestDTO dto);

    public PublisherDetailResponseDTO findPublisher(Long id);

}
