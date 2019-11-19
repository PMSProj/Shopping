package com.shopify.Shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index() { 
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("userClickedHome",true);
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickedAbout",true);
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickedContact",true);
		return mv;
	}
}
