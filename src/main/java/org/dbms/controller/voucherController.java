package org.dbms.controller;

import java.util.List;

import org.dbms.model.voucher;
import org.dbms.service.voucherService;
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
@RequestMapping(value="/voucher")
public class voucherController {
	@Autowired
	 voucherService voucherService;
	@Autowired
	 org.dbms.service.customerService customerService;
	@Autowired
	org.dbms.service.item_voucherService item_voucherService;
	 
	 @RequestMapping(value="/listy", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("voucher/voucher_page2");
	  
	  List list = voucherService.listyvouchers();
	  model.addObject("listvoucher", list);
	  
	  return model;
	 }
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView listy(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("myempid")) {
	  ModelAndView model = new ModelAndView("voucher/voucher_page");
	  
	  List list = voucherService.listAllvouchers();
	  model.addObject("listvoucher", list);
	  
	  return model;}
			else {
				  ModelAndView model = new ModelAndView("voucher/voucher_page2");
				  
				  List list = voucherService.listAllvouchers();
				  model.addObject("listvoucher", list);
				  
				  return model;}
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("voucher/voucher_form");
	  List list = customerService.listycustomers();
	  voucher voucher = new voucher();
	  model.addObject("voucherForm", voucher);
	  model.addObject("listcustomer",list);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("voucherForm") voucher voucher){
	   voucherService.addvoucher(voucher);
	  return new ModelAndView("redirect:/voucher/listy");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("voucher/voucherupdate");
	  
	  voucher voucher = voucherService.findvoucherbyId(id);
	  model.addObject("voucherForm", voucher);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("voucherForm") voucher voucher){

	   voucherService.updatevoucher(voucher);
	
	  return new ModelAndView("redirect:/voucher/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  voucherService.deletevoucher(id);
	  
	  return new ModelAndView("redirect:/voucher/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("voucher/voucher_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
