package com.example.demo.Dto.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dto.PublisherDto;
import com.example.demo.Entity.Publisher;

@Component
public class ConverterPublisher {

	@Autowired
	public ModelMapper modelMapper;

	public PublisherDto convertToDto(Publisher publisherObject) {
		return modelMapper.map(publisherObject, PublisherDto.class);
	}

	public Publisher convertToEntity(PublisherDto publisherDtoObj) {
		return modelMapper.map(publisherDtoObj, Publisher.class);
	}

}
