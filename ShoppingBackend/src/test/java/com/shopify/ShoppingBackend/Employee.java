package com.shopify.ShoppingBackend;

public class Employee {

	
	public int getOutswtanding(String empId) {
		Salary sal = new Salary();
		int curSal = sal.getCurrentMonthSal(empId);
		int basic = curSal *12/100;
		return curSal + basic;
		
		
	}
	
}
