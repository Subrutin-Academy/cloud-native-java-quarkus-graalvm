package com.subrutin.lingkar.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;
import com.subrutin.lingkar.catalog.service.PublisherService;
import com.subrutin.lingkar.catalog.util.PaginationUtil;
import com.subrutin.lingkar.catalog.web.dto.PublisherCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Inject
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    @Override
    public void createPublisher(PublisherCreateRequestDTO dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.name());
        publisher.setDescription(dto.description());
        publisherRepository.createPublisher(publisher);

    }

    @Override
    public PublisherDetailResponseDTO findPublisher(Long id) {
        Publisher publisher = publisherRepository.findPublisherById(id)
                .orElseThrow(() -> new RuntimeException("publisher.notfound"));

        return new PublisherDetailResponseDTO(publisher.getId(), publisher.getName(), publisher.getDescription());
    }

    @Transactional
    @Override
    public void updatePublisher(Long id, PublisherUpdateRequestDTO dto) {
        // get data publisher
        Publisher publisher = publisherRepository.findPublisherById(id)
                .orElseThrow(() -> new RuntimeException("publisher.notfound"));
        // update
        publisher.setName(dto.name());
        publisher.setDescription(dto.description());
        publisherRepository.updatePublisher(publisher);
    }

    @Transactional
    @Override
    public void deletePublisher(Long id) {
        publisherRepository.deletePublisher(id);

    }

    @Override
    public ResultPageResponseDTO<PublisherListResponseDTO> findPubliherList(Integer pages, Integer limit, String sortBy,
            String direction, String publisherName) {
        publisherName = StringUtil.isNullOrEmpty(publisherName) ? "%" : publisherName + "%";
        Sort sort = Sort.by(sortBy, PaginationUtil.getDirection(direction));
        Page page = Page.of(pages, limit);
        PageQuery<Publisher> pageResult = publisherRepository.findPublisherList(publisherName, sort, page);
        List<PublisherListResponseDTO> dtoList = pageResult.result().stream().map(p -> {
            return new PublisherListResponseDTO(p.getId(), p.getName());
        }).collect(Collectors.toList());
        return new ResultPageResponseDTO<>(dtoList, pageResult.pages(), pageResult.elements());
    }

}
