package com.subrutin.lingkar.catalog.domain;

import java.util.Iterator;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "publisher")
@SQLRestriction("deleted = false")
public class Publisher extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "publisher" )
    private List<Book> books;

    public void addBook(Book book){
        this.books.add(book);
        book.setPublisher(this);
    }

    public void removeBook(Book book){
        book.setPublisher(null);
        this.books.remove(book);
    }

    public void removeBooks(){
        Iterator<Book> iterator = this.books.iterator();
        while(iterator.hasNext()){
            Book book = iterator.next();
            book.setPublisher(null);
            iterator.remove();
        }
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    

}
