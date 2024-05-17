package com.lenskart.service;

import com.lenskart.dto.CartDTO;
import com.lenskart.dto.ProductDTO;

public interface CartService {
	
	public CartDTO addToCart(int custid,int productid);
//	public CartDTO updateCart(CartDTO cartDTO);
	public String deleteProduct(int custid, int prodid);
	

}
