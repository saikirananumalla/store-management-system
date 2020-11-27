package org.dbms.controller;

import java.util.List;

import org.dbms.model.customer;
import org.dbms.service.voucherService;
import org.dbms.service.customerService;
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
@RequestMapping(value="/customer")
public class customerController {
	@Autowired
	 customerService customerService;
	voucherService voucherService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("myempid")) {
	  ModelAndView model = new ModelAndView("customer/customer_page");
	  
	  List list = customerService.listAllcustomers();
	  model.addObject("listcustomer", list);
	  return model;}
			else {
				  ModelAndView model = new ModelAndView("customer/customer_page2");
				  
				  List list = customerService.listAllcustomers();
				  model.addObject("listcustomer", list);
				  return model;}
	  
	  
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("customer/customer_form");
	  
	  customer customer = new customer();
	  model.addObject("customerForm", customer);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("customerForm") customer customer){

	   customerService.addcustomer(customer);
	
	  return new ModelAndView("redirect:/voucher/add");
	 }
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("customer/customerupdate");
	  
	  customer customer = customerService.findcustomerbyId(id);
	  model.addObject("customerForm", customer);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("customerForm") customer customer){

	   customerService.updatecustomer(customer);
	
	  return new ModelAndView("redirect:/customer/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  customerService.deletecustomer(id);
	  
	  return new ModelAndView("redirect:/customer/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("customer/customer_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
