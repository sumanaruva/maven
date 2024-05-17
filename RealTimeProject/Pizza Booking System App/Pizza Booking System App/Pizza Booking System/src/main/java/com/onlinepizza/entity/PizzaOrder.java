package com.onlinepizza.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.onlinepizza.util.PizzaStatus;

public class PizzaOrder {
	private Integer bookingOrderId;
	private LocalDateTime dateTimeOfOrder;
	private Integer quantity;
	private Double totalCost;
	private List<Pizza> pizzaList;
	private Customer customer;
	private PizzaStatus status;

}
