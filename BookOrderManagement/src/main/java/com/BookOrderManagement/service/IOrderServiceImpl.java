package com.BookOrderManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookOrderManagement.dto.BookOrderDto;
import com.BookOrderManagement.dto.OrderDetailsDto;
import com.BookOrderManagement.entities.BookOrder;
import com.BookOrderManagement.entities.Customer;
import com.BookOrderManagement.entities.OrderDetails;
import com.BookOrderManagement.exceptions.OrderAlreadyExistsExceptions;
import com.BookOrderManagement.exceptions.OrderIdNotFoundExceptions;
import com.BookOrderManagement.mapper.BookOrderMapper;
import com.BookOrderManagement.mapper.OrderDetailsMapper;
import com.BookOrderManagement.repository.OrderRepository;

@Service
public class IOrderServiceImpl implements IOrderService {
	
	@Autowired
	OrderRepository or;
	
	@Override
	public List<OrderDetails> listAllOrders() {
		// TODO Auto-generated method stub
		return or.findAll();
	}

	/*@Override
	public List<OrderDetails> listOrderByCustomer(Customer cs) {
		// TODO Auto-generated method stub
		return ;
	}*/

	@Override
	public String cancelOrder(int id) {
		// TODO Auto-generated method stub
		Optional<OrderDetails> cat = or.findById(id);
		if(cat.isPresent()) {
			 or.deleteById(id);
			 return "DELETED";
		}
		else {
			throw new OrderIdNotFoundExceptions("Id not found");
		}
	}

	@Override
	public OrderDetails addOrder(OrderDetailsDto od) {
		// TODO Auto-generated method stub
		OrderDetails orderdetailsobj = OrderDetailsMapper.toStatement(od);
		return or.save(orderdetailsobj);
		
	
	}

	@Override
	public OrderDetails updateOrder(OrderDetailsDto od) {
		// TODO Auto-generated method stub
		OrderDetails orderdetailsobj2= OrderDetailsMapper.toStatement(od);
		return or.save(orderdetailsobj2);
	}

	@Override
	public OrderDetails getOrderById(int id) {
		// TODO Auto-generated method stub
		Optional<OrderDetails> cat = or.findById(id);
		if(cat.isPresent()) {
			return cat.get();
		}
		throw new OrderIdNotFoundExceptions("Id not found");
	}
	

}
