package com.lenskart.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double productPrice;
	private String productImage;
	private int quantity;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private String brand;
	public Product(int productId, String productName, double productPrice, String productImage, int quantity,
			Category category, String brand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.quantity = quantity;
		this.category = category;
		this.brand = brand;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
