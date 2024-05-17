package com.lenskart.dto;

import com.lenskart.entity.Category;

import lombok.Data;

@Data
public class ProductDTO {
	
	private int productId;
	private String productName;
	private double productPrice;
	private String productImage;
	private int quantity;
	private Category category;
	private String brand;
	
	

}
