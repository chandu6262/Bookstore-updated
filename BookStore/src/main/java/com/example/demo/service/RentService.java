package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.RentDto;
import com.example.demo.Dto.Converter.ConverterRent;
import com.example.demo.Entity.Rent;
import com.example.demo.Exception.RentNotFoundException;
import com.example.demo.Respository.RentRepository;

@Component
@Service
public class RentService {
	public static Logger logger = Logger.getLogger(RentService.class);
	@Autowired
	RentRepository rentRepo;
	@Autowired
	ConverterRent converterRent;
	public List<RentDto> getAllRents()
	{
		return rentRepo.findAll().stream().map(converterRent::convertToDto).collect(Collectors.toList());
	}
	public RentDto getRents(int rental_id)
	{
		try { 
			logger.info("Rent with rent id:"+" "+rental_id+" "+"is updated succesfully");  //logging
			Rent r = rentRepo.findById(rental_id).get(); 
			return converterRent.convertToDto(r);
		}catch(Exception e) {
			logger.info("Exception occured");   //logging
			throw new RentNotFoundException("Invalid rental id:"+" "+rental_id);	
		}
	}
	public RentDto addAllRent(Rent rent)
	{
		Rent r = rentRepo.save(rent);          // Add rent details
		return converterRent.convertToDto(r);
	}
	public RentDto updateRents(RentDto r)
	{
		Rent r1 = converterRent.convertToEntity(r);
		Rent r2 = rentRepo.save(r1);     //update
		return converterRent.convertToDto(r2);

	}

	public AddResponse deleteRents(int rental_id)
	{
		try { 
			logger.info("Rent with rent id:"+" "+rental_id+" "+"is updated succesfully");  //logging
			rentRepo.deleteById(rental_id);    //delete
			AddResponse res =  new AddResponse();
			res.setId(rental_id);
			res.setMsge("Rent details deleted succesfully");
			return res; 
		}catch(Exception e) {
			logger.info("Exception occured");   //logging
			throw new RentNotFoundException("Invalid rental id:"+" "+rental_id);	
		}
	}

}
