package org.dbms.controller;

import java.util.List;

import org.dbms.model.distributorbrand;
import org.dbms.service.distributorbrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/distributorbrand")
public class distributorbrandController {
	@Autowired
	distributorbrandService distributorbrandService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("distributorbrand/distributorbrand_page");
	  
	  List list = distributorbrandService.listAlldistributorbrands();
	  model.addObject("listdistributorbrand", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("distributorbrand/distributorbrand_form");
	  
	  distributorbrand distributorbrand = new distributorbrand();
	  model.addObject("distributorbrandForm", distributorbrand);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("distributorbrandForm") distributorbrand distributorbrand){

	   distributorbrandService.adddistributorbrand(distributorbrand);
	
	  return new ModelAndView("redirect:/distributorbrand/list");
	 }
	 @RequestMapping(value="/delete", method=RequestMethod.GET)
	 public ModelAndView delete(){
	  ModelAndView model = new ModelAndView("distributorbrand/distributorbrand_delete");
	  
	  distributorbrand distributorbrand = new distributorbrand();
	  model.addObject("distributorbranddeleteForm", distributorbrand);
	  return model;
	 }
	 @RequestMapping(value="/deletepost", method=RequestMethod.POST)
	 public ModelAndView deletepost(@ModelAttribute("distributorbranddeleteForm") distributorbrand distributorbrand){

	   distributorbrandService.deletedistributorbrand(distributorbrand);
	
	  return new ModelAndView("redirect:/distributorbrand/list");
	 }
	 
	
	 
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("distributorbrand/distributorbrand_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
