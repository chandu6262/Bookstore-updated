package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.BookDto;
import com.example.demo.Dto.Converter.ConverterBook;
import com.example.demo.Entity.Books;
import com.example.demo.Exception.BookNotFoundException;
import com.example.demo.Respository.BooksRepository;

@Component
@Service
public class BookService {
	public static Logger logger = Logger.getLogger(BookService.class);
	@Autowired
	BooksRepository booksRepo;
	@Autowired
	ConverterBook converterBook;

	public List<BookDto> getAllBooks()   //Get Books
	{
		return booksRepo.findAll().stream().map(converterBook::convertToDto).collect(Collectors.toList());
	}
	public BookDto getBooks(int book_id)
	{ try {
		logger.info("Book with book id:"+" "+book_id+" "+"is updated succesfully");  //logging
		Books b = booksRepo.findById(book_id).get();
		return converterBook.convertToDto(b);
	}catch(Exception e) {
		logger.info("Exception occured");    //logging
		throw new BookNotFoundException("Invalid Book id:"+" " +book_id);	// find by id
	}
	}
	public BookDto addAllBooks(Books books)
	{
		Books b = booksRepo.save(books);          //Add Book
		return converterBook.convertToDto(b);
	}
	public BookDto updateBooks(BookDto b)
	{
		Books b1 = converterBook.convertToEntity(b);
		Books b2 = booksRepo.save(b1);     //update
		return converterBook.convertToDto(b2);

	}

	public AddResponse deleteBooks(int book_id)
	{
		try {  
			booksRepo.deleteById(book_id);    //delete
			AddResponse res =  new AddResponse();
			res.setId(book_id);
			res.setMsge("Book deleted succesfully");
			return res; 
		}catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new BookNotFoundException("Invalid Book id:"+" " +book_id);	// find by id
		}
	}
}


