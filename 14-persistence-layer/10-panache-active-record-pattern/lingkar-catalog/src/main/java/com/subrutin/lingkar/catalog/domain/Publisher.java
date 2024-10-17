package com.subrutin.lingkar.catalog.domain;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "description")
    public String description;

    public static List<Publisher> findAllPublishers(){
        return listAll();
    }

    public static Publisher findPublisherById(Long id){
        return findById(id);
    }

    public static void createPublisher(Publisher publisher){
        persist(publisher);
    }

    public static void updatePublisher(Publisher publisher){
        persist(publisher);
    }

    public static void deletePublisher(Long id){
        deleteById(id);
    }
    

}
