package com.lenskart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenskart.dto.CartDTO;
import com.lenskart.dto.DeletedCartDTO;
import com.lenskart.dto.OrdersDTO;
import com.lenskart.entity.DeletedCart;
import com.lenskart.entity.Orders;
import com.lenskart.serviceimpl.OrdersServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersServiceImpl ordersServiceImpl;

	// User Register
	@PostMapping("/placeOrder/{custid}")
	public OrdersDTO addOrder(@PathVariable(value = "custid") int custid) {
		return ordersServiceImpl.addOrders(custid);
	}

	// User Register
	@GetMapping("/find/{orderId}")
	public OrdersDTO FindById(@PathVariable(value = "orderId") int orderId) {
		return ordersServiceImpl.getById(orderId);
	}

	// User Register
	@GetMapping("/findall")
	public List<OrdersDTO> FindAllOrders() {
		return ordersServiceImpl.findAl();
	}

	// delete users
	@DeleteMapping("/deleteOrder/{no}")
	public String deleteOrder(@PathVariable(value = "no") int no) {
		return ordersServiceImpl.deleteOrders(no);

	}
	
	// User Register
		@GetMapping("/findBycustId/{custId}")
		public List<OrdersDTO> getOrderCustId(@PathVariable(value = "custId") int custId) {
			return ordersServiceImpl.getOrderCustomerId(custId);
		}
}
