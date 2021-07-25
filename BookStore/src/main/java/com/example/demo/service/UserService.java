package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.UserDto;
import com.example.demo.Dto.Converter.ConverterUser;
import com.example.demo.Entity.User;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Respository.UserRepository;

@Component
@Service
public class UserService {
	public static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	UserRepository userRepo;

	@Autowired
	public ConverterUser converterService;

	
	@Autowired
	public ModelMapper modelMapper;
	public List<UserDto> getAllUsers()   //Get user
	{
		List<User> u1 = userRepo.findAll();
		return u1.stream().map(converterService::convertToDto).collect(Collectors.toList()); 	
	}
	public UserDto getUser(int user_id)          // find by id
	{
		try {
			logger.info("User with user_id:"+" "+user_id+" "+"is updated succesfully");  //logging
			User u = userRepo.findById(user_id).get(); 
			return converterService.convertToDto(u);
		}
		catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new UserNotFoundException("Invalid user id:"+" "+user_id); 
		}

	}
	public UserDto addAllUser(User user)
	{
		/*String pwd= user.getPassword();
		 String encrptedPwd = passwordEncoder.encode(pwd);
		 user.setPassword(encrptedPwd);*/
		User u = userRepo.save(user);    //add user
		return converterService.convertToDto(u);
	}

	public UserDto updateUsers(UserDto existingUser)
	{
		User userReq = converterService.convertToEntity(existingUser);
		User u1 = userRepo.save(userReq);  //update
		return converterService.convertToDto(u1);
	}

	public AddResponse deleteUsers(int user_id)
	{

		try {
			logger.info("User with user_id:"+" "+user_id+" "+"is deleted succesfully");
			userRepo.deleteById(user_id);    //delete
			AddResponse res =  new AddResponse();
			res.setId(user_id);
			res.setMsge("user deleted succesfully");
			return res;
		}
		catch(Exception e){
			logger.info("Exception occured");
			throw new UserNotFoundException("not valid");

		}


	}

}

