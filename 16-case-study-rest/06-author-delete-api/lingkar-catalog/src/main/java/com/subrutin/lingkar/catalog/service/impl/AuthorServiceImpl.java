package com.subrutin.lingkar.catalog.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.repository.AuthorRepository;
import com.subrutin.lingkar.catalog.service.AuthorService;
import com.subrutin.lingkar.catalog.web.dto.AuthorRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorListResponseDTO;

import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(AuthorRequestDTO dto) {
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

    @Override
    public List<AuthorListResponseDTO> findAuthorList(String authorName) {
        authorName = StringUtil.isNullOrEmpty(authorName) ? "%" : authorName + "%";
        List<Author> authors = authorRepository.findAuthorsByName(authorName);
        return authors.stream().map(a -> {
            return new AuthorListResponseDTO(a.getId(), a.getName());
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void updateAuthor(Long id, AuthorRequestDTO dto) {
        // mengambil data dari database -> persistence layer
        Author author = authorRepository.findAuthorById(id)
                .orElseThrow(() -> new RuntimeException("authorid.notfound"));
        // update data
        author.setName(dto.name());
        author.setBirthPlace(dto.birthPlace());
        author.setBirthDate(LocalDate.ofEpochDay(dto.birthDate()));
        author.setDescription(dto.description());
        // menyimpan ke database
        authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
       authorRepository.delete(id);
    }

}
