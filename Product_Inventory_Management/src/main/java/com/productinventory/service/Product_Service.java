package com.productinventory.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productinventory.dao.Product_Dao;
import com.productinventory.enitiy.ProductEntity;
@Service
public class Product_Service {

	@Autowired
	Product_Dao dao;
	
	public String insertProduct(ProductEntity product) {
		String msg = dao.insertProduct( product);
		if(Objects.isNull(msg)) {
			msg = "Data is not inserted there is a problem please check";
		}
		return msg;
	}

	public String updateProduct(ProductEntity product, int productId) {
		String msg = dao.updateProduct(product, productId);
		if(Objects.isNull(msg)) {
			msg = "Data is not updated there is a problem please check";
		}
		return msg;
	}

	public String deleteProduct(int productId) {
		String msg =dao.deleteProduct(productId);
		if(Objects.isNull(msg)) {
			msg = "Data is not deleted there is a problem please check";
		}
		return msg;
	}

	public ProductEntity getSingleProduct(int productId) {
		ProductEntity product = dao.getSingleProduct(productId);
		if(Objects.isNull(product)) {
			product = null;
		}
		return product;
	}

	public 	List<ProductEntity> getAllProduct() {
		List<ProductEntity> records = dao.getAllProduct();
		if(Objects.isNull(records)) {
			records= null;
		}
		return records;
	}
}
