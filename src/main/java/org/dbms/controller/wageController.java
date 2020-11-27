package org.dbms.controller;

import java.util.List;

import org.dbms.model.wage;
import org.dbms.service.wageService;
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
@RequestMapping(value="/admin/wage")
public class wageController {
	@Autowired
	 wageService wageService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("wage/wage_page");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    if(name.equals("myempid")) {
	  List list = wageService.listAllwages();
	  model.addObject("listwage", list);}
	  else {return new ModelAndView("error");}
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("wage/wage_form");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    if(name.equals("myempid")) {
	  wage wage = new wage();
	  model.addObject("wageForm", wage);}
	    else {return new ModelAndView("error");}
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("wageForm") wage wage){

	   wageService.addwage(wage);
	
	  return new ModelAndView("redirect:/wage/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("wage/wageupdate");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    if(name.equals("myempid")) {
	  wage wage = wageService.findwagebyId(id);
	  model.addObject("wageForm", wage);}
	    else {return new ModelAndView("error");}
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("wageForm") wage wage){

	   wageService.updatewage(wage);
	
	  return new ModelAndView("redirect:/wage/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String name = auth.getName();
		    if(name.equals("myempid")) {
	  wageService.deletewage(id);}
		    else {return new ModelAndView("error");}
	  return new ModelAndView("redirect:/wage/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("wage/wage_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }

}
