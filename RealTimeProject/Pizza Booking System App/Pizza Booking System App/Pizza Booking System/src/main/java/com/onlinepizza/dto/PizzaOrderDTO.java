package com.onlinepizza.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.onlinepizza.util.PizzaStatus;

public class PizzaOrderDTO {
	private Integer bookingOrderId;
	private LocalDateTime dateTimeOfOrder;
	private Integer quantity;
	private Double totalCost;
	private List<PizzaDTO> pizzaList;
	private CustomerDTO customer;
	private PizzaStatus status;

}
