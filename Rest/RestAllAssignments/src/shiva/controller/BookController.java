package shiva.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shiva.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {
	
	Map<Integer, Book> bk = new HashMap<Integer,Book>();
	public BookController(){
		bk.put(1,new Book(1,"C",1972));
		bk.put(2,new Book(2,"DS",1988));
		bk.put(3,new Book(3,"Java",1998));
		bk.put(4,new Book(4,"HTML",2000));
		bk.put(5,new Book(5,"Spring",2010));
	}
	
	@RequestMapping("")
	public String getBookDetails() {
		String book = "";
		for (Map.Entry<Integer, Book> e : bk.entrySet()) 
            book+=e.getValue().toString()+"\n";
		return book;
	}
	
	@RequestMapping("/{id}")
	public String getBookDetails(@PathVariable int id) {
		Book book = bk.get(id);
		return book.toString();
	}
	
}
