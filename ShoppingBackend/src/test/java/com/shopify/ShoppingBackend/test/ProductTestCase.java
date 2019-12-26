package com.shopify.ShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopify.ShoppingBackend.dao.ProductDao;
import com.shopify.ShoppingBackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDao productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopify.ShoppingBackend");
		context.refresh();
		productDAO = (ProductDao) context.getBean("productDAO");
	}

	/*@Test
	public void testCRUDProduct() {
		// create Product
		
		 * product = new Product(); product.setName("ACER 14 Corei3");
		 * product.setBrand("ACER");
		 * product.setDescription("Some decription of Acer LAptop");
		 * product.setUnitPrice(65000); product.setActive(true);
		 * product.setCategoryId(2); product.setSupplierId(2);
		 * assertEquals("Something went wrong while inserting data", true,
		 * productDAO.insertProduct(product));
		 
//update Product

		product = productDAO.getProductById(62);
		product.setName("HP LAPPY");
		assertEquals("Something went wrong while updating data", true, productDAO.update(product));
		assertEquals("Something went wrong while deleting data", true, productDAO.delete(product));
		assertEquals("Something went wrong while fetching the records", 7, productDAO.productList().size());
*/
		@Test
		public void testListActiveProducts() {
			assertEquals("Something went wrong while fetching the records", 3, productDAO.listActiveProducts().size());
		
	}
		@Test
		public void testListActiveProductsByCategory() {
			assertEquals("Something went wrong while fetching the records", 1, productDAO.listActiveProductsByCategory(1).size());
			assertEquals("Something went wrong while fetching the records", 1, productDAO.listActiveProductsByCategory(3).size());
		
	}

		@Test
		public void testLatestActiveProducts() {
			assertEquals("Something went wrong while fetching the records", 3, productDAO.getLatestActiveProducts(3).size());
		
	}
}
