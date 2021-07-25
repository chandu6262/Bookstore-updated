package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.AddressDto;
import com.example.demo.Dto.Converter.ConverterAddress;
import com.example.demo.Entity.Address;
import com.example.demo.Exception.AddressNotFoundException;
import com.example.demo.Respository.AddressRepository;

@Component
@Service
public class AddressService {
	public static Logger logger = Logger.getLogger(AddressService.class);

	@Autowired
	AddressRepository addressRepo;

	@Autowired
	ConverterAddress converterAddress;
	public List<AddressDto> getAllAddress()
	{
		return addressRepo.findAll().stream().map(converterAddress::convertToDto).collect(Collectors.toList());
	}
	public AddressDto getAddress(int address_id)
	{
		try {
			logger.info("Address with address id:"+" "+address_id+" "+"is updated succesfully");  //logging
			Address add = addressRepo.findById(address_id).get(); 
			return converterAddress.convertToDto(add);
		}
		catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new AddressNotFoundException("Invalid address id :" +" "+ address_id);	// find by id
		}
	}
	public AddressDto addAllAddress(Address address)
	{ 
		Address add = addressRepo.save(address);          //Add address
		return converterAddress.convertToDto(add);
	}
	public AddressDto updateAllAddress(AddressDto ad)
	{
		Address add =converterAddress.convertToEntity(ad);
		Address a1 = addressRepo.save(add);     //update
		return converterAddress.convertToDto(a1);
	}

	public AddResponse deleteAllAddress(int address_id)
	{

		List<Address> address =addressRepo.findAll();
		logger.info("Checking condition");       //logging
		for(Address adds:address)
		{
			if(adds.getAddress_id()!=address_id) {
				logger.info("Exception occured");    //logging
				throw new AddressNotFoundException("Invalid address id :" +" "+ address_id);	// find by id
			}
			else {
				logger.info("Address with address id:"+" "+address_id+" "+"is updated succesfully");  //logging
				addressRepo.deleteById(address_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(address_id);
				res.setMsge("Address deleted succesfully");
				return res; }
		}
		return null;
	}
}
