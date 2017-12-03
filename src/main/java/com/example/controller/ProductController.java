package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.Product;
import com.example.service.ProductService;
import com.example.util.ProductGenerator;

@Controller
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@RequestMapping("/products")
	public String listProducts(Model model){
		model.addAttribute("products", productService.getProducts());
		return "products";
	}
	
	@RequestMapping("/product/{serial}")
	public String getProduct(@PathVariable String serial, Model model){
		model.addAttribute("product",productService.getProduct(serial));
		return "product";
	}
	
	@RequestMapping("/product/new")
	public String newProduct(Model model){
		model.addAttribute("product", new Product());
		return "productForm";
	}
	
	@RequestMapping(value="/product",method = RequestMethod.POST)
	public String saveOrUpdate(Product product){
		if(product.getSerial() == null) product.setSerial(ProductGenerator.getProductSerial());
		productService.saveOrUpdateProduct(product);
		return "redirect:/products";
	}
	
	@RequestMapping("/product/update/{serial}")
	public String updateProduct(@PathVariable String serial, Model model){
		Product product = productService.getProduct(serial);
		model.addAttribute("product",product);
		return "updateProductForm";
	}
	
	@RequestMapping("/product/delete/{serial}")
	public String deleteProduct(@PathVariable String serial){
		productService.deleteProduct(serial);
		return "redirect:/products";
	}
}
