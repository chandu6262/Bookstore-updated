package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dto.AuthorDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.Author;
@Component
public class ConverterAuthor {

	@Autowired
	public ModelMapper modelMapper;

	public AuthorDto convertToDto(Author authorObject) {
		return modelMapper.map(authorObject, AuthorDto.class);
	}

	public Author convertToEntity(AuthorDto userDtoObj) {
		return modelMapper.map(userDtoObj, Author.class);
	}

}
