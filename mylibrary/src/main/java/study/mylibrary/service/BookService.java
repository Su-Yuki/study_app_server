package study.mylibrary.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.mylibrary.repository.BookRepository;
import study.mylibrary.entity.Book;
import study.mylibrary.entity.Status;;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public List<Book> findByStatusIn(List<Status> statuses) {
        return repository.findByStatusIn(statuses.toArray(new Status[0]));
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public Optional<Book> findById(UUID id) {
        return repository.findById(id);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
