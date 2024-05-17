package com.lenskart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenskart.dto.OrdersDTO;
import com.lenskart.entity.Orders;
import com.lenskart.entity.Product;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
	//public List<OrdersDTO> findAl();

}
