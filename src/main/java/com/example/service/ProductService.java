package com.example.service;

import java.util.List;

import com.example.domain.Product;

public interface ProductService {
	
	List<Product> getProducts();
	
	Product getProduct(String serial);

	void saveOrUpdateProduct(Product product);
	
	void deleteProduct(String serial);
}
