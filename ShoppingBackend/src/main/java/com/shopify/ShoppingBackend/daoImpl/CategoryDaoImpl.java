package com.shopify.ShoppingBackend.daoImpl;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopify.ShoppingBackend.dao.CategoryDao;
import com.shopify.ShoppingBackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> categorylist() {
		String selectActiveCategory="FROM TBL_CATEGORY  WHERE IS_ACTIVE =:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active",true);
		return query.getResultList();
	
	}
	@Override
	public Category getCatById(Integer id) {
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

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



//update single category
	@Override
	public boolean update(Category category) {
		try {
			  //update  the category
				sessionFactory.getCurrentSession().update(category);
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
					return false;
			}
	}




	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			  //update  the category
				sessionFactory.getCurrentSession().update(category);
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
					return false;
			}
	}





}
