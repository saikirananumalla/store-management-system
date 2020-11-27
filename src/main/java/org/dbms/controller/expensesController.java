package org.dbms.controller;

import java.util.List;

import org.dbms.model.expenses;
import org.dbms.service.expensesService;
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
@RequestMapping(value="/admin/expenses")
public class expensesController {
	@Autowired
	 expensesService expensesService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("expenses/expenses_page");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if(name.equals("myempid")) {
	  List list = expensesService.listAllexpensess();
	  model.addObject("listexpenses", list);}
		 else {return new ModelAndView("error");}
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("expenses/expenses_form");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if(name.equals("myempid")) {
	  expenses expenses = new expenses();
	  model.addObject("expensesForm", expenses);}
		else {return new ModelAndView("error");}
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("expensesForm") expenses expenses){

	   expensesService.addexpenses(expenses);
	
	  return new ModelAndView("redirect:/admin/expenses/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("expenses/expensesupdate");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if(name.equals("myempid")) {
	  expenses expenses = expensesService.findexpensesbyId(id);
	  model.addObject("expensesForm", expenses);}
		else {return new ModelAndView("error");}
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("expensesForm") expenses expenses){

	   expensesService.updateexpenses(expenses);
	
	  return new ModelAndView("redirect:/admin/expenses/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("myempid")) {
	  expensesService.deleteexpenses(id);}
			else {return new ModelAndView("error");}
	  return new ModelAndView("redirect:/admin/expenses/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("expenses/expenses_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }

}
