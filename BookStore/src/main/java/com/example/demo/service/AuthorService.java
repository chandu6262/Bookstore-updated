package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.AuthorDto;
import com.example.demo.Dto.Converter.ConverterAuthor;
import com.example.demo.Entity.Author;
import com.example.demo.Exception.AuthorNotFoundException;
import com.example.demo.Respository.AuthorRepository;

@Component
@Service
public class AuthorService {
	public static Logger logger = Logger.getLogger(AuthorService.class);
	@Autowired
	AuthorRepository authorRepo;

	@Autowired
	ConverterAuthor converterAuthor;
	
	public List<AuthorDto> getAllAuthors()
	{
		return authorRepo.findAll().stream().map(converterAuthor::convertToDto).collect(Collectors.toList());
	}
	public AuthorDto getAuthors(int author_id)
	{
		try {
				logger.info("Author with author id:"+" "+author_id+" "+"is updated succesfully");  //logging
				Author a = authorRepo.findById(author_id).get();
				return converterAuthor.convertToDto(a);
			}catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new AuthorNotFoundException("Invalid author id:"+" "+author_id);	// find by id
			}
	}
	public AuthorDto addAllAuthor(Author author)
	{
		Author a = authorRepo.save(author);        //Add author details
		return converterAuthor.convertToDto(a);
	}
	public AuthorDto updateAuthors(AuthorDto a)
	{
		Author a1 = converterAuthor.convertToEntity(a);
		Author a2 = authorRepo.save(a1);     //update
		return converterAuthor.convertToDto(a2);
	}
	public AddResponse deleteAuthors(int author_id)
	{
		List<Author> author =authorRepo.findAll();
		logger.info("Checking condition");       //logging  
		for(Author au:author)
		{
			if(au.getAuthor_id()!=author_id) {
				logger.info("Exception occured");    //logging
				throw new AuthorNotFoundException("Invalid author id:"+" "+author_id);	// find by id
			}
			else { 
				logger.info("Author with author id:"+" "+author_id+" "+"is updated succesfully");  //logging
				authorRepo.deleteById(author_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(author_id);
				res.setMsge("Author deleted succesfully");
				return res; }
		}
		return null;
	}

}
