package com.BookOrderManagement.mapper;

import com.BookOrderManagement.dto.BookOrderDto;
import com.BookOrderManagement.dto.OrderDetailsDto;
import com.BookOrderManagement.entities.BookOrder;
import com.BookOrderManagement.entities.OrderDetails;

public class OrderDetailsMapper {
	public static OrderDetails toStatement(OrderDetailsDto orderdetailsDto)
	{
	OrderDetails orderdetails=new OrderDetails();
	orderdetails.setBook(orderdetailsDto.getBook());
	orderdetails.setBookOrder(orderdetailsDto.getBookOrder());
	orderdetails.setQuantity(orderdetailsDto.getQuantity());
	orderdetails.setSubtotal(orderdetailsDto.getSubtotal());
	return orderdetails;
}
	public static OrderDetailsDto toOrderDetailsDto(OrderDetails orderdetails) 
	{
		OrderDetailsDto orderdetailsdto = new OrderDetailsDto();
		orderdetailsdto.setBook(orderdetails.getBook());
		orderdetailsdto.setBookOrder(orderdetails.getBookOrder());
		orderdetailsdto.setQuantity(orderdetails.getQuantity());
		orderdetailsdto.setSubtotal(orderdetails.getSubtotal());
		return orderdetailsdto;
	}
	
	
}