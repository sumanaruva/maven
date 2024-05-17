package com.lenskart.service;

import java.util.List;

import com.lenskart.dto.CartDTO;
import com.lenskart.dto.DeletedCartDTO;
import com.lenskart.dto.OrdersDTO;


public interface OrdersService {
	
	public OrdersDTO addOrders(int custid);
//	public OrdersDTO updateOrders(OrdersDTO orderDTO);
	public String deleteOrders(int orderId);
	public OrdersDTO getById(int id);
	public List<OrdersDTO> findAl();
	public List<OrdersDTO> getOrderCustomerId(int customerId);
}
