package com.shopify.ShoppingBackend.test;

	

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopify.ShoppingBackend.dao.CategoryDao;
import com.shopify.ShoppingBackend.dto.Category;

public class CategoryTestCase {
 private static AnnotationConfigApplicationContext  context;
 
 private static CategoryDao categoryDAO;
 private static Category category;
 @BeforeClass
 public static void init() {
	 context=new AnnotationConfigApplicationContext();
	 context.scan("com.shopify.ShoppingBackend");
	 context.refresh();
	 categoryDAO=(CategoryDao) context.getBean("categoryDAO");
 }
   @Test 
   public void testAddCategory() {
	   	category=new Category();
	   	category.setName("ccTV");
	   	category.setDescription("This is tvd");
	   	category.setImageURL("tvdf.png");
		
	   	assertEquals("Succesfully added a category inside the table!",true,categoryDAO.add(category));
   }
}
