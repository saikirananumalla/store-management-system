package org.dbms.controller;

import java.util.List;

import org.dbms.model.supplies;
import org.dbms.service.suppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequestMapping(value="/supplies")
public class suppliesController {
	@Autowired
	 suppliesService suppliesService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("supplies/supplies_page");
	  
	  List list = suppliesService.listAllsuppliess();
	  model.addObject("listsupplies", list);
	  
	  return model;
	 }
	 @RequestMapping(value="/listy", method=RequestMethod.GET)
	 public ModelAndView listy(){
	  ModelAndView model = new ModelAndView("supplies/supplies_page");
	  
	  List list = suppliesService.listysuppliess();
	  model.addObject("listsupplies", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add/{id}", method=RequestMethod.GET)
	 public ModelAndView add(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("supplies/supplies_form");
	
	  supplies supplies = new supplies();
	  model.addObject("suppliesForm", supplies);
	  supplies.setInvoiceId(id);
	  List list = suppliesService.listysuppliess();
	  model.addObject("listsupplies", list);
	  
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("suppliesForm") supplies supplies){

	   suppliesService.addsupplies(supplies);
	
	  return new ModelAndView("redirect:/supplies/add/"+supplies.getInvoiceId());
	 }
	 
	 @RequestMapping(value="/update/{sid}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("sid") int sid){
	  ModelAndView model = new ModelAndView("supplies/suppliesupdate");
	  
	  supplies supplies = suppliesService.findsuppliesbyId(sid);
	  model.addObject("suppliesForm", supplies);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("suppliesForm") supplies supplies){

	   suppliesService.updatesupplies(supplies);
	
	  return new ModelAndView("redirect:/supplies/list");
	 }
	 
	 @RequestMapping(value="/delete/{sid}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("sid") int sid){
	  suppliesService.deletesupplies(sid);
	  
	  return new ModelAndView("redirect:/supplies/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("supplies/supplies_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
