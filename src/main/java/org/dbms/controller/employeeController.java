package org.dbms.controller;

import java.util.List;

import org.dbms.model.employee;
import org.dbms.service.employeeService;
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
@RequestMapping(value="/admin/employee")
public class employeeController {
	@Autowired
	 employeeService employeeService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		
	  ModelAndView model = new ModelAndView("employee/employee_page");
	  if(name.equals("myempid")) {
	  List list = employeeService.listAllemployees();
	  model.addObject("listemployee", list);
	  }
	  else {return new ModelAndView("error");}
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("employee/employee_form");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	  employee employee = new employee();
	  if(name.equals("myempid")) {
	  model.addObject("employeeForm", employee);}
	  else {return new ModelAndView("/error");}
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("employeeForm") employee employee){

	   employeeService.addemployee(employee);
	
	  return new ModelAndView("redirect:/admin/employee/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") String id){
	  ModelAndView model = new ModelAndView("employee/employeeupdate");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	  employee employee = employeeService.findemployeebyId(id);
	  if(name.equals("myempid")) {
	  model.addObject("employeeForm", employee);}
	  else {return new ModelAndView("error");}
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("employeeForm") employee employee){

	   employeeService.updateemployee(employee);
	
	  return new ModelAndView("redirect:/admin/employee/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") String id){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			if(name.equals("myempid")) {
	  employeeService.deleteemployee(id);}
			else {return new ModelAndView("error");}
	  
	  return new ModelAndView("redirect:/admin/employee/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("employee/employee_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 
}
}
