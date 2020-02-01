package com.shopify.Shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopify.ShoppingBackend.dao.ProductDao;
import com.shopify.ShoppingBackend.dto.Product;
@Controller
@RequestMapping("/json/data")
public class jsonDataController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		return productDao.listActiveProducts();
	}
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable  Integer id){
		return productDao.listActiveProductsByCategory(id);
	}

	
}
