package org.dbms.controller;

import java.util.List;

import org.dbms.model.payment;
import org.dbms.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/payment")
public class paymentController {
	@Autowired
	 paymentService paymentService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("payment/payment_page");
	  
	  List list = paymentService.listAllpayments();
	  model.addObject("listpayment", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("payment/payment_form");
	  
	  payment payment = new payment();
	  model.addObject("paymentForm", payment);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("paymentForm") payment payment){

	   paymentService.addpayment(payment);
	
	  return new ModelAndView("redirect:/payment/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") String id){
	  ModelAndView model = new ModelAndView("payment/paymentupdate");
	  
	  payment payment = paymentService.findpaymentbyId(id);
	  model.addObject("paymentForm", payment);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("paymentForm") payment payment){

	   paymentService.updatepayment(payment);
	
	  return new ModelAndView("redirect:/payment/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") String id){
	  paymentService.deletepayment(id);
	  
	  return new ModelAndView("redirect:/payment/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("payment/payment_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 
}
}
