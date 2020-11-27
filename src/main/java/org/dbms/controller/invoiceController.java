package org.dbms.controller;

import java.util.List;

import org.dbms.model.invoice;
import org.dbms.service.invoiceService;
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

@RequestMapping(value="/invoice")
public class invoiceController {
	@Autowired
	 invoiceService invoiceService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("myempid")) {
	  ModelAndView model = new ModelAndView("invoice/invoice_page");
	  
	  List list = invoiceService.listAllinvoices();
	  model.addObject("listinvoice", list);
	  
	  return model;}
			else {
				  ModelAndView model = new ModelAndView("invoice/invoice_page2");
				  
				  List list = invoiceService.listAllinvoices();
				  model.addObject("listinvoice", list);
				  
				  return model;}
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("invoice/invoice_form");
	  
	  invoice invoice = new invoice();
	  model.addObject("invoiceForm", invoice);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("invoiceForm") invoice invoice){

	   invoiceService.addinvoice(invoice);
	
	  return new ModelAndView("redirect:/supplies/add/"+invoice.getId());
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("invoice/invoiceupdate");
	  
	  invoice invoice = invoiceService.findinvoicebyId(id);
	  model.addObject("invoiceForm", invoice);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("invoiceForm") invoice invoice){

	   invoiceService.updateinvoice(invoice);
	
	  return new ModelAndView("redirect:/invoice/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  invoiceService.deleteinvoice(id);
	  
	  return new ModelAndView("redirect:/invoice/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("invoice/invoice_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
