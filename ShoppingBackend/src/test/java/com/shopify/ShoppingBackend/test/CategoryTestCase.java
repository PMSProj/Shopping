package com.shopify.ShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopify.ShoppingBackend.dao.CategoryDao;
import com.shopify.ShoppingBackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopify.ShoppingBackend");
		context.refresh();
		categoryDAO = (CategoryDao) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Laptop");
	 * category.setDescription("This is some description for Laptop");
	 * category.setImageURL("LAP_1.png");
	 * 
	 * assertEquals("successfully added a category inside the table!",
	 * true,categoryDAO.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.getCatById(3);
	 * assertEquals("successfully fetched a category", "Laptop",
	 * category.getName()); }
	 */

	/*
	 * @Test public void testupdateCategory() { category =
	 * categoryDAO.getCatById(2); category.setName("TV");
	 * assertEquals("successfully update a category",true,
	 * categoryDAO.update(category)); }
	 */
	/*
	 * @Test public void testupdateCategory() { category =
	 * categoryDAO.getCatById(2);
	 * 
	 * assertEquals("successfully update a category",true,
	 * categoryDAO.delete(category)); }
	 */
	/*
	 * @Test public void testupdateCategory() {
	 * 
	 * assertEquals("successfully update a category",1,
	 * categoryDAO.categorylist().size()); }
	 */
	@Test 
	public void testAddCategory() {
//		  category = new Category(); 
//		  category.setName("Laptop");
//		  category.setDescription("This is some description for Laptop");
//		  category.setImageURL("LAP.png");
//		  assertEquals("successfully added a category inside the table!", true,categoryDAO.add(category)); 
//		  
//		  category = new Category(); 
//		  category.setName("Television");
//		  category.setDescription("This is some description for tv");
//		  category.setImageURL("TV.png");
//		  assertEquals("successfully added a category inside the table!", true,categoryDAO.add(category)); 
//		  
//		  category = new Category(); 
//		  category.setName("Camera");
//		  category.setDescription("This is some description for Camera");
//		  category.setImageURL("CAM.png");
//		  assertEquals("successfully added a category inside the table!", true,categoryDAO.add(category)); 
		  
		   category = categoryDAO.getCatById(27);
		   category.setName("Lappy");
		   
		   assertEquals("successfully update a category",true, categoryDAO.update(category)); 
		   assertEquals("successfully update a category",true,categoryDAO.delete(category)); 
		   assertEquals("successfully update a category",2, categoryDAO.categorylist().size()); 
			  
		  }
		 
}
