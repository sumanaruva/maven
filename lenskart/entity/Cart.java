package com.lenskart.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "carts")
@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany
	@JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products = new ArrayList<Product>();

	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	private int totalQuantity;
	private double totalPrice;
	public Cart(int id, List<Product> products, CustomerEntity customer, int totalQuantity, double totalPrice) {
		super();
		this.id = id;
		this.products = products;
		this.customer = customer;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clearCart()
	{
		products.clear();
	}


}
