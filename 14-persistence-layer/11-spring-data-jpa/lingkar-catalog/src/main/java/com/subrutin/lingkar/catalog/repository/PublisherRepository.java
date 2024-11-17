package com.subrutin.lingkar.catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {

    //SQL select * from publisher
    //query method/@Query
    //select * from publisher where name='Erlangga'
    //select * from publisher where upper(name) like upper('er%')
    public List<Publisher> findAllByNameLikeIgnoreCase(String name);

    //SQL select * from publisher where id = 1
    public Optional<Publisher> findById(Long id);

    //update -> save()

    //create -> save()

    //delete? -> delete()
}
