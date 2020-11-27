package org.dbms.controller;

import java.util.List;

import org.dbms.model.distributor;
import org.dbms.service.distributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/distributor")
public class distributorController {
	@Autowired
	 distributorService distributorService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("myempid")) {
	  ModelAndView model = new ModelAndView("distributor/distributor_page");
	  
	  List list = distributorService.listAlldistributors();
	  model.addObject("listdistributor", list);
	  return model;}
			else {
				  ModelAndView model = new ModelAndView("distributor/distributor_page2");
				  
				  List list = distributorService.listAlldistributors();
				  model.addObject("listdistributor", list);
				  return model;}
	  
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("distributor/distributor_form");
	  
	  distributor distributor = new distributor();
	  model.addObject("distributorForm", distributor);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("distributorForm") distributor distributor){

	   distributorService.adddistributor(distributor);
	
	  return new ModelAndView("redirect:/distributor/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("distributor/distributorupdate");
	  
	  distributor distributor = distributorService.finddistributorbyId(id);
	  model.addObject("distributorForm", distributor);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("distributorForm") distributor distributor){

	   distributorService.updatedistributor(distributor);
	
	  return new ModelAndView("redirect:/distributor/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  distributorService.deletedistributor(id);
	  
	  return new ModelAndView("redirect:/distributor/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("distributor/distributor_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
