package com.shopify.ShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shopify.ShoppingBackend.Employee;

public class EmployeeTest {

	
	@Test
	   public void testPrintMessage() {	
	      System.out.println("Inside testPrintMessage()");  
	     Employee emp = new Employee();
	      int amt = emp.getOutswtanding("1");
	      assertEquals(11200,amt);     
	   }
}
