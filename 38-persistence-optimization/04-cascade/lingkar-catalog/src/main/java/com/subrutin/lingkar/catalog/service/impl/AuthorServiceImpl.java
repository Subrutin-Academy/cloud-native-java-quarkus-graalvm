package com.subrutin.lingkar.catalog.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.domain.dto.AuthorQueryDTO;
import com.subrutin.lingkar.catalog.exception.ResourceNotFoundException;
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

    @Override
    public Set<Author> findAllAuthors(List<Long> authorIds) {
        List<Author> authors =  authorRepository.findAuthorsByIdIn(authorIds);
        if(authors.isEmpty() || authors.size() != authorIds.size())
            throw new ResourceNotFoundException("authorid not found");
       return new HashSet<>(authors);
    }

    @Override
    public Map<Long, Set<AuthorListResponseDTO>> findAuthorMap(Set<Long> bookIdSet) {
		Set<AuthorQueryDTO> authorsQuery= authorRepository.findAuthorsByBookIdSet(bookIdSet);
		Map<Long, Set<AuthorListResponseDTO>> authorsMap = new HashMap<>();
		Set<AuthorListResponseDTO> authorsDTO =null;
		for(AuthorQueryDTO q:authorsQuery) {
			if(!authorsMap.containsKey(q.bookId())) {
				authorsDTO = new HashSet<>();
			}else {
				authorsDTO = authorsMap.get(q.bookId());
			}
			authorsDTO.add(new AuthorListResponseDTO(q.authorId(), q.authorName()));
			authorsMap.put(q.bookId(), authorsDTO);
		}
		return authorsMap;    
    }

}
