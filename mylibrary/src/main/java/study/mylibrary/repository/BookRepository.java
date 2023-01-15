package study.mylibrary.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.mylibrary.entity.Book;
import study.mylibrary.entity.Status;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findByStatusIn(Status... statuses);
}
