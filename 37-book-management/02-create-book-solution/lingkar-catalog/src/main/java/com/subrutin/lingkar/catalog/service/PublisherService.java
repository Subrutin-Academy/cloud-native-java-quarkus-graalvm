package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.web.dto.PublisherCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

public interface PublisherService {

    public void createPublisher(PublisherCreateRequestDTO dto);

    public PublisherDetailResponseDTO findPublisher(Long id);

    public Publisher findPublisherById(Long id);

    public ResultPageResponseDTO<PublisherListResponseDTO> findPubliherList(Integer pages,
    Integer limit,
    String sortBy,
    String direction,
    String publisherName);

    public void updatePublisher(Long id, PublisherUpdateRequestDTO dto);

    public void deletePublisher(Long id);

}
