package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.PublisherCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherUpdateRequestDTO;

public interface PublisherService {

    public void createPublisher(PublisherCreateRequestDTO dto);

    public PublisherDetailResponseDTO findPublisher(Long id);

    public void updatePublisher(Long id, PublisherUpdateRequestDTO dto);

    public void deletePublisher(Long id);

}
