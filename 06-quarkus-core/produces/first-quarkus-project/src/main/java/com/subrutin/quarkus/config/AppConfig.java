package com.subrutin.quarkus.config;

import com.subrutin.quarkus.domain.Author;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public class AppConfig {

    //@Bean
    @Produces
    public  Author author() {
        Author author = new Author();
        author.setName("Karen Armstrong");
        return author;
    }

}
