package study.booksearch.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.booksearch.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {}
