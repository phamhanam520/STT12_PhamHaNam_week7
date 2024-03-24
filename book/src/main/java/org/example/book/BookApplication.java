package org.example.book;

import org.example.book.models.Author;
import org.example.book.models.Book;
import org.example.book.repositories.AuthorRepository;
import org.example.book.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
    // init data
     @Bean
     CommandLineRunner initDatabase(BookRepository bookRepository, AuthorRepository authorRepository) {
         return args -> {
             Author author1 = new Author();
                author1.setName("Author 1");
                authorRepository.save(author1);
             Book book1 = new Book();
                book1.setName("Book 1");
                book1.setAuthor(author1);
             bookRepository.save(book1);
            Book book2 = new Book();
                book2.setName("Book 2");
                book2.setAuthor(author1);
             bookRepository.save(book2);

             Author author2 = new Author();
                author2.setName("Author 2");
                authorRepository.save(author2);
            Book book3 = new Book();
                book3.setName("Book 3");
                book3.setAuthor(author2);
             bookRepository.save(book3);
         };
     }
}
