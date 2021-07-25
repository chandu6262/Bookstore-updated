package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.PublisherDto;
import com.example.demo.Dto.Converter.ConverterPublisher;
import com.example.demo.Entity.Publisher;
import com.example.demo.Exception.PublisherNotFoundException;
import com.example.demo.Respository.PublisherRepository;

@Component
@Service
public class PublisherService {
	public static Logger logger = Logger.getLogger(PublisherService.class);

	@Autowired
	PublisherRepository publisherRepo;
	@Autowired
	ConverterPublisher converterPublisher;

	public List<PublisherDto> getAllPublishers()   //Get publisher details
	{
		return publisherRepo.findAll().stream().map(converterPublisher::convertToDto).collect(Collectors.toList());
	}
	public PublisherDto getPublishers(int publisher_id)
	{
		try {
			logger.info("Publisher with publisher id:"+" "+publisher_id+" "+"is updated succesfully");  //logging
			Publisher p = publisherRepo.findById(publisher_id).get();
			return converterPublisher.convertToDto(p);
		}catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new PublisherNotFoundException("Invalid publisher id:"+" "+publisher_id);	// find by id
		}
	}
	public PublisherDto addAllPublisher(Publisher publisher)
	{ 
		Publisher p1 = publisherRepo.save(publisher);         //Add publisher details
		return converterPublisher.convertToDto(p1);
	}
	public PublisherDto updatePublishers(PublisherDto p)
	{
		Publisher p1 = converterPublisher.convertToEntity(p);
		Publisher p2 = publisherRepo.save(p1);     //update
		return converterPublisher.convertToDto(p2);

	}

	public AddResponse deletePublsihers(int publisher_id)
	{
		try {
			logger.info("Publisher with publisher id:"+" "+publisher_id+" "+"is updated succesfully");  //logging
			publisherRepo.deleteById(publisher_id);    //delete
			AddResponse res =  new AddResponse();
			res.setId(publisher_id);
			res.setMsge("Publisher deleted succesfully");
			return res; 
		}catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new PublisherNotFoundException("Invalid publisher id:"+" "+publisher_id);	// find by id
		}
	}
}
