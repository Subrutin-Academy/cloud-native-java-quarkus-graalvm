package com.subrutin.lingkar.catalog.service.impl;

import java.time.LocalDate;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.repository.AuthorRepository;
import com.subrutin.lingkar.catalog.service.AuthorService;
import com.subrutin.lingkar.catalog.web.dto.AuthorCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorDetailResponseDTO;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(AuthorCreateRequestDTO dto) {
        // konversi dto -> entity
        Author author = new Author();
        author.setName(dto.name());
        author.setBirthPlace(dto.birthPlace());
        author.setBirthDate(LocalDate.ofEpochDay(dto.birthDate()));
        author.setDescription(dto.description());

        // entity -> class repository
        authorRepository.save(author);
    }

    @Override
    public AuthorDetailResponseDTO findAuthorDetail(Long authorId) {
        // get data from database
        Author author = authorRepository.findAuthorById(authorId)
                .orElseThrow(() -> new RuntimeException("authorid.notfound"));
        // author -> dto
        return new AuthorDetailResponseDTO(author.getId(),
         author.getName(), 
         author.getBirthPlace(), 
         author.getBirthDate().toEpochDay(),
         author.getDescription());
    }

}
