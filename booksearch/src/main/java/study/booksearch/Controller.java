package study.booksearch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import study.booksearch.entity.Book;
import study.booksearch.entity.Status;


@RestController
public class Controller {

	@RequestMapping(value="/books", method=RequestMethod.GET)
	public List<Book> getBooks() {
		Book b1 = new Book("id1", "title", "TECH", Status.DONE, "url", "image_url");
		Book b2 = new Book("id2", "title", "TECH", Status.DONE, "url", "image_url");
		List<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		return books;
	}
}