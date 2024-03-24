package org.example.book.controllers;

import lombok.AllArgsConstructor;
import org.example.book.models.Book;
import org.example.book.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @PostMapping("/")
    Book post(){
        Book b = new Book();
        b.setName("test");
        Book save = bookRepository.save(b);
        return save;
    }

    @GetMapping("/{authorId}")
    List<Book> getBooksByAuthorId(@PathVariable Long authorId){
        List<Book> list = bookRepository.findByAuthorId(authorId);
        return list;
    }


    @GetMapping("/")
    List<Book> get(){
        List<Book> list = bookRepository.findAll();
        return list;
    }
}
