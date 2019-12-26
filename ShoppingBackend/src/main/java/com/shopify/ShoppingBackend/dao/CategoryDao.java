package com.shopify.ShoppingBackend.dao;

import java.util.List;

import com.shopify.ShoppingBackend.dto.Category;

public interface CategoryDao {
	public Category getCatById(Integer id);	
	public List<Category> categorylist();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	

}
