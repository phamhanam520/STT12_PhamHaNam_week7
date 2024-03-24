package org.example.book.repositories;

import org.example.book.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // find book by author id
    List<Book> findByAuthorId(Long authorId);
}
