package study.booksearch;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import study.booksearch.entity.Book;
import study.booksearch.repository.BookRepository;


@RestController
public class Controller {

	@Autowired
    BookRepository bookRepository;

	@RequestMapping(value="/books", method=RequestMethod.GET)
	public List<Book> getBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@RequestMapping(value="/books", method=RequestMethod.POST)
	@Transactional(timeout=3)
	public ResponseEntity<Book> createBook(@RequestBody Book body) {
		// create a book
		Book book = bookRepository.save(body);
		return new ResponseEntity<Book>(book, null, HttpStatus.CREATED);
	}
}