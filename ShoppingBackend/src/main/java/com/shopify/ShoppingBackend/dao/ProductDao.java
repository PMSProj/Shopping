package com.shopify.ShoppingBackend.dao;

import java.util.List;

import com.shopify.ShoppingBackend.dto.Product;

public interface ProductDao {
	public Product getProductById(Integer id);
	public List<Product> productList();	
	boolean insertProduct(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(Integer categoryId);
	List<Product>  getLatestActiveProducts(Integer count);
	
	

}
