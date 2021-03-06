package com.shopify.Shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopify.ShoppingBackend.dao.CategoryDao;
import com.shopify.ShoppingBackend.dao.ProductDao;
import com.shopify.ShoppingBackend.dto.Category;
import com.shopify.ShoppingBackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private ProductDao productDao;
	
	

	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside index method-INFO");
	    logger.debug("Inside index method-DEBUG");
		
		mv.addObject("userClickedHome", true);
		mv.addObject("categories", categoryDAO.categorylist());

		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickedAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickedContact", true);
		return mv;
	}

	/* Methods to load all the products and based on category */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllproducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		// passing the list of catgories
		mv.addObject("categories", categoryDAO.categorylist());
		mv.addObject("userClickedAllProducts", true);
		return mv;
	}

	@RequestMapping(value ="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("page");
		// category dao to fetch single category
		Category category = null;
		category = categoryDAO.getCatById(id);

		mv.addObject("title", category.getName());
		// passing the list of catgories
		mv.addObject("categories", categoryDAO.categorylist());
		//passing the single category object
		mv.addObject("category", category);
		mv.addObject("userClickedCategoryProducts", true);
		return mv;
	}
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView ShowSingleProduct(@PathVariable("id") Integer id) {
		ModelAndView mv=new ModelAndView("page");
	   Product product=productDao.getProductById(id);
	   //update the view Count
	   product.setViews(product.getViews() +1);
	   	productDao.update(product);
	   	mv.addObject("title", product.getName());
	   	mv.addObject("product",product);
	   	mv.addObject("userClickedShowProduct",true);
	   	return mv;
	}
	
	
}
