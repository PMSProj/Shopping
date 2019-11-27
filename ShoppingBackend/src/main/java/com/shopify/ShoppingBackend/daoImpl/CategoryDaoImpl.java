package com.shopify.ShoppingBackend.daoImpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopify.ShoppingBackend.dao.CategoryDao;
import com.shopify.ShoppingBackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category>  categories =new ArrayList<>();
	
	static {
		Category cat=new Category();
		cat.setId(1);
		cat.setName("TV");
		cat.setDescription("This is tv");
		cat.setImageURL("tv.png");
		categories.add(cat);
		
		cat=new Category();
		cat.setId(2);
		cat.setName("ccTV");
		cat.setDescription("This is tvd");
		cat.setImageURL("tvdf.png");
		categories.add(cat);
		
		cat=new Category();
		cat.setId(3);
		cat.setName("Laptop");
		cat.setDescription("This is tdsv");
		cat.setImageURL("tv.png");
		categories.add(cat);
		
		
	}
	
	
	

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}




	@Override
	public Category get(int id) {
		//froeach loop
		for(Category category:categories) {
			if(category.getId()==id)
				return category;
		}
		return null;
	}



    @Transactional
	@Override
	public boolean add(Category category) {
		try {
		  //add the category
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		
		return false;
		}
	}

	
}
