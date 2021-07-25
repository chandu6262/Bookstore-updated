package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Dto.Converter.ConverterOrder;
import com.example.demo.Entity.Orders;
import com.example.demo.Exception.OrderNotFoundException;
import com.example.demo.Respository.OrdersRepository;

@Component
@Service
public class OrderService {
	public static Logger logger = Logger.getLogger(OrderService.class);
	@Autowired
	OrdersRepository ordersRepo;
	@Autowired
	ConverterOrder converterOrder;
	public List<OrderDto> getAllOrders()
	{
		return ordersRepo.findAll().stream().map(converterOrder::convertToDto).collect(Collectors.toList());
	}
	public OrderDto getOrders(int order_id)
	{
		try {
			logger.info("Order with order id:"+" "+order_id+" "+"is updated succesfully");  //logging
			Orders o =  ordersRepo.findById(order_id).get();
			return converterOrder.convertToDto(o);
		}catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new OrderNotFoundException("Invalid oder id:" +" "+ order_id);	// find by id
		}
	}
	public OrderDto addAllOrders(Orders order)
	{
		Orders o1 = ordersRepo.save(order);        //Add Order details
		return converterOrder.convertToDto(o1);
	}
	public OrderDto updateOrders(OrderDto o)
	{

		Orders o1 = converterOrder.convertToEntity(o);
		Orders o2 = ordersRepo.save(o1);     //update
		return converterOrder.convertToDto(o2);

	}

	public AddResponse deleteOrders(int order_id)
	{
		try {
			logger.info("Order with order id:"+" "+order_id+" "+"is updated succesfully");  //logging
			ordersRepo.deleteById(order_id);    //delete
			AddResponse res =  new AddResponse();
			res.setId(order_id);
			res.setMsge("Order details deleted succesfully");
			return res; 
		}catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new OrderNotFoundException("Invalid oder id:" +" "+ order_id);	// find by id
		}
	}
}
