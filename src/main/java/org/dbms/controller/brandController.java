package org.dbms.controller;

import java.util.List;


import org.dbms.model.brand;

import org.dbms.service.brandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.boot.web.server.ErrorPage;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController

@RequestMapping(value="/brand")
public class brandController {

	@Autowired
	 brandService brandService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("myempid")) {
	  ModelAndView model = new ModelAndView("brand/brand_page");
	  List list = brandService.listAllBrands();
	  model.addObject("listbrand", list);
	  return model;
	  }
			else {
				ModelAndView model = new ModelAndView("brand/brand_page2");
				List list = brandService.listAllBrands();
				  model.addObject("listbrand", list);
				  return model;
			}
//	  List list = brandService.listAllBrands();
//	  model.addObject("listbrand", list);
//	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("brand/brand_form");
	  
	  brand brand = new brand();
	  model.addObject("brandForm", brand);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("brandForm") brand brand){

	   brandService.addBrand(brand);
	
	  return new ModelAndView("redirect:/brand/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") String id){
	  ModelAndView model = new ModelAndView("brand/brandupdate");
	  
	  brand brand = brandService.findBrandbyId(id);
	  model.addObject("brandForm", brand);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("brandForm") brand brand){

	   brandService.updateBrand(brand);
	
	  return new ModelAndView("redirect:/brand/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") String id){
	  brandService.deleteBrand(id);
	  
	  return new ModelAndView("redirect:/brand/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("brand/brand_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}