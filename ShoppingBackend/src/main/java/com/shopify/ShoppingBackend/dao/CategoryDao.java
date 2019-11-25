package com.shopify.ShoppingBackend.dao;

import java.util.List;

import com.shopify.ShoppingBackend.dto.Category;

public interface CategoryDao {
	List<Category> list();

	Category get(int id);	

}
