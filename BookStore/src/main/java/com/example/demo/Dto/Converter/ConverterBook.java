package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dto.BookDto;
import com.example.demo.Entity.Books;

@Component
public class ConverterBook {

	@Autowired
	public ModelMapper modelMapper;
	
	public BookDto convertToDto(Books bookObject) {
		return modelMapper.map(bookObject, BookDto.class);
	}
	
	public Books convertToEntity(BookDto b) {
		return modelMapper.map(b, Books.class);
	}

}
