package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.RentedBooksDetailsDto;
import com.example.demo.Dto.Converter.ConverterRentedBookDetails;
import com.example.demo.Entity.RentedBooksDetails;
import com.example.demo.Exception.RentedBookDetailsNotFoundExp;
import com.example.demo.Respository.RentedBooksDetailsRepository;

@Component
@Service
public class RentedBookDetailsService {
	public static Logger logger = Logger.getLogger(RentedBookDetailsService.class);
	@Autowired
	RentedBooksDetailsRepository rentedBooksDetailsRepo;
	@Autowired
	ConverterRentedBookDetails crd;

	public List<RentedBooksDetailsDto> getAllRentedDetails()
	{
		return rentedBooksDetailsRepo.findAll().stream().map(crd::convertToDto).collect(Collectors.toList());
	}
	public RentedBooksDetailsDto getRentDetails(int rentedDetails_id)
	{
		try {
			logger.info("Rented book details with details id:"+" "+rentedDetails_id+" "+"is updated succesfully");  //logging
			RentedBooksDetails r = rentedBooksDetailsRepo.findById(rentedDetails_id).get();
			return crd.convertToDto(r);
		}catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new RentedBookDetailsNotFoundExp("Invalid id:"+" "+rentedDetails_id);	// find by id
		}
	}
	public RentedBooksDetailsDto addAllRentedDetails(RentedBooksDetails rentedDetails)
	{
		RentedBooksDetails r = rentedBooksDetailsRepo.save(rentedDetails);   //Add details
		return crd.convertToDto(r);
	}
	public RentedBooksDetailsDto updateAllRentedDetails(RentedBooksDetailsDto rd)
	{
		RentedBooksDetails rd1 = crd.convertToEntity(rd);
		RentedBooksDetails rd2 = rentedBooksDetailsRepo.save(rd1);     //update
		return crd.convertToDto(rd2);

	}	

	public AddResponse deleteAllRentedDetails(int rentedDetails_id)
	{
		try {
			logger.info("Rented book details with details id:"+" "+rentedDetails_id+" "+"is updated succesfully");  //logging
			rentedBooksDetailsRepo.deleteById(rentedDetails_id);    //delete
			AddResponse res =  new AddResponse();
			res.setId(rentedDetails_id);
			res.setMsge("Rented Books details deleted succesfully");
			return res; 
		}catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new RentedBookDetailsNotFoundExp("Invalid id:"+" "+rentedDetails_id);	// find by id
		}
	}

}
