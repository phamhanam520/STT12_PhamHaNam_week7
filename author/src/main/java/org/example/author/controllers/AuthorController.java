package org.example.author.controllers;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.example.author.models.Author;
import org.example.author.models.Book;
import org.example.author.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/getBooksByAuthorId/{authorId}")
    @Retry(name = "retry1")
    ResponseEntity getBooksByAuthorId(@PathVariable Long authorId){

        Object list = restTemplate.getForObject("http://localhost:8801/books/"+authorId.toString(), List.class);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/")
    Author post(){
        Author b = new Author();
        b.setName("post new author");
        Author save = authorRepository.save(b);
        return save;
    }

    @GetMapping("/")
    List<Author> get(){
        List<Author> list = authorRepository.findAll();
        return list;
    }
}
