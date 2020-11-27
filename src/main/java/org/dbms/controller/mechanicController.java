package org.dbms.controller;

import java.util.List;

import org.dbms.model.mechanic;
import org.dbms.service.mechanicService;
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
@RequestMapping(value="/mechanic")
public class mechanicController {
	@Autowired
	 mechanicService mechanicService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("myempid")) {	
	  ModelAndView model = new ModelAndView("mechanic/mechanic_page");
	  
	  List list = mechanicService.listAllmechanics();
	  model.addObject("listmechanic", list);
	  
	  return model;}
			else {	
				  ModelAndView model = new ModelAndView("mechanic/mechanic_page2");
				  
				  List list = mechanicService.listAllmechanics();
				  model.addObject("listmechanic", list);
				  
				  return model;}
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("mechanic/mechanic_form");
	  
	  mechanic mechanic = new mechanic();
	  model.addObject("mechanicForm", mechanic);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("mechanicForm") mechanic mechanic){

	   mechanicService.addmechanic(mechanic);
	
	  return new ModelAndView("redirect:/mechanic/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("mechanic/mechanicupdate");
	  
	  mechanic mechanic = mechanicService.findmechanicbyId(id);
	  model.addObject("mechanicForm", mechanic);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("mechanicForm") mechanic mechanic){

	   mechanicService.updatemechanic(mechanic);
	
	  return new ModelAndView("redirect:/mechanic/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  mechanicService.deletemechanic(id);
	  
	  return new ModelAndView("redirect:/mechanic/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("mechanic/mechanic_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
