package com.example.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.domain.Product;

public final class ProductGenerator {
	
	private static Random random = new Random();
	
	private ProductGenerator(){}
	
	public static List<Product> generateProducts(int n){
		List<Product> products = new ArrayList<>();
		for(int i=0;i<n;i++) products.add(generateProduct());
		return products;
	}
	
	private static String getSerial(int n){
		String source ="0123456789abcdefghijklmnqoprstuvwxyz";
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(source.charAt(random.nextInt(source.length())));
		}
		return sb.toString();
	}
	
	public static String getProductSerial(){
		return getSerial(10);
	}
	
	private static Product generateProduct(){
		Double [] prices = {100.55,5.45,2.35,0.99,2.99,3.99,20.55,20.99,35.25};
		String [] urls ={"url1", "url2","url3","url4","url5","url6","url7","url8"};
		String serial = getSerial(10);
		return new Product(serial,"Product"+serial,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
				prices[random.nextInt(prices.length)],urls[random.nextInt(urls.length)]);
	}
	
}
