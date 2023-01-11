package study.mylibrary.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study.mylibrary.repository.BookRepository;

import study.mylibrary.entity.Book;;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    @Transactional(timeout = 500)
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Transactional(timeout = 500)
    public Book save(Book book) {
        return repository.save(book);
    }

    @Transactional(timeout = 500)
    public Optional<Book> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional(timeout = 500)
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
