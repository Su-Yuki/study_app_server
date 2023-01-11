package study.mylibrary;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import study.mylibrary.entity.Book;
import study.mylibrary.service.BookService;


@RestController
public class Controller {

	@Autowired
    BookService service;

	@RequestMapping(value="/books", method=RequestMethod.GET)
	public List<Book> getBooks() {
		List<Book> books = service.findAll();
		return books;
	}

	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable UUID id) {
		Optional<Book> book = service.findById(id);
		if (book.isPresent()) {
			return new ResponseEntity<>(book.get(), null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value="/books", method=RequestMethod.POST)
	public ResponseEntity<Book> createBook(@RequestBody Book body) {
		Book book = service.save(body);
		return new ResponseEntity<Book>(book, null, HttpStatus.CREATED);
	}

	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@PathVariable("id") UUID id, @RequestBody Book body) {
		Optional<Book> book = service.findById(id);
		if (book.isPresent()) {
			Book updatedBook = service.save(body);
			return new ResponseEntity<Book>(updatedBook, null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBook(@PathVariable("id") UUID id) {
		Optional<Book> book = service.findById(id);
		if (book.isPresent()) {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
