package com.shopify.ShoppingBackend.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopify.ShoppingBackend.dao.ProductDao;
import com.shopify.ShoppingBackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	//Single category
	@Override
	public Product getProductById(Integer id) {
		try
		{
			
			return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(id));
		}
		catch(Exception e) {
	    e.printStackTrace();
			}
		return null;
		}
 //List
	@Override
	public List<Product> productList() {
		return sessionFactory.getCurrentSession().createQuery("From TBL_CATEGORY",Product.class).getResultList();
	}

	//Insert
	@Override
	public boolean insertProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true ;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false 	;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
		  product.setActive(false);
		  return this.update(product);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts="From TBL_PRODUCT where IS_ACTIVE =:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveProducts);
		query.setParameter("active",true);
		return query.getResultList();
	
//		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class).setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(Integer categoryId) {
		String selectActiveProductsBYCategory="From TBL_PRODUCT where IS_ACTIVE =:active AND categoryId=:categoryId";
		
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsBYCategory,Product.class).setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(Integer count) {
		
		return sessionFactory.getCurrentSession().createQuery("From TBL_PRODUCT  where IS_ACTIVE =:active ORDER BY id",Product.class).setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
