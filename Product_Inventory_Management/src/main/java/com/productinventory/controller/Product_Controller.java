package com.productinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productinventory.enitiy.ProductEntity;
import com.productinventory.service.Product_Service;

@RestController
@RequestMapping("/productinventory")
public class Product_Controller {

	@Autowired
	Product_Service service;

	@PostMapping("/addProduct")
	public String insertProduct(@RequestBody ProductEntity product) {
		String msg = service.insertProduct(product);
		return msg;
	}

	@PutMapping("/updateProduct/{productId}")
	public String updateProduct(@RequestBody ProductEntity product,@PathVariable int productId) {
		String msg = service.updateProduct(product, productId);
		return msg;
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		String msg = service.deleteProduct(productId);
		return msg;
	}

	@GetMapping("/fetchSingleData")
	public ProductEntity getSingleProduct(@RequestParam int productId) {
		ProductEntity product = service.getSingleProduct(productId);
		return product;
	}

	@GetMapping("/fetchAllData")
	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> records = service.getAllProduct();
		return records;
	}
}
