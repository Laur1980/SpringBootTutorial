package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.Product;
import com.example.util.ProductGenerator;

@Service
public class ProductServiceImpl implements ProductService {
	
	private Map<String,Product> products;
	
	 public ProductServiceImpl() {
		 populateProducts();
	}
	
	@Override
	public List<Product> getProducts() {
		return new ArrayList(products.values());
	}
	
	private void populateProducts(){
		List<Product> productList = ProductGenerator.generateProducts(10);
		products = new HashMap<>();
		productList.forEach( e -> products.put(e.getSerial(), e));
	}

	@Override
	public Product getProduct(String serial) {
		return products.get(serial);
	}

	@Override
	public void saveOrUpdateProduct(Product product) {
		String serial = product.getSerial();
		products.put(serial,product);
	}

	@Override
	public void deleteProduct(String serial) {
		products.remove(serial);
	}
	
}
