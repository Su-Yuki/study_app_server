package study.mylibrary.controllers;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.mylibrary.entity.Book;
import study.mylibrary.service.BookService;

@RestController
@RequestMapping("/mylibrary/books")
public class BookController {

	@Autowired
    BookService service;

	@GetMapping("")
	public List<Book> getBooks() {
		List<Book> books = service.findAll();
		return books;
	}

	@GetMapping("{id}")
	public ResponseEntity<Book> getBook(@PathVariable UUID id) {
		Optional<Book> book = service.findById(id);
		if (book.isPresent()) {
			return new ResponseEntity<>(book.get(), null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<Book> createBook(@RequestBody Book body) {
		Book book = service.save(body);
		return new ResponseEntity<Book>(book, null, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") UUID id, @RequestBody Book body) {
		Optional<Book> book = service.findById(id);
		if (book.isPresent()) {
			Book updatedBook = service.save(body);
			return new ResponseEntity<Book>(updatedBook, null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{id}")
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
