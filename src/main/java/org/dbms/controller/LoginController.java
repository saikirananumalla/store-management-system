package org.dbms.controller;

import java.util.List;

import org.dbms.model.Login;
import org.dbms.service.LoginService;
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

@RequestMapping(value="/admin/Login")
public class LoginController {
	@Autowired
	 LoginService LoginService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("Login/Login_page");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    if(name.equals("myempid")) {
	  List list = LoginService.listAllLogins();
	  model.addObject("listLogin", list);}
	    else {return new ModelAndView("error");}
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("Login/Login_form");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    if(name.equals("myempid")) {
	  Login Login = new Login();
	  model.addObject("LoginForm", Login);}
	    else {return new ModelAndView("error");}
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("LoginForm") Login Login){

	   LoginService.addLogin(Login);
	
	  return new ModelAndView("redirect:/admin/Login/list");
	 }
	 
	 @RequestMapping(value="/update/{empId}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("empId") String empId){
	  ModelAndView model = new ModelAndView("Login/Loginupdate");
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    if(name.equals("myempid")) {
	  Login Login = LoginService.findLoginbyId(empId);
	  model.addObject("LoginForm", Login);}
	    else {return new ModelAndView("error");}
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("LoginForm") Login Login){

	   LoginService.updateLogin(Login);
	
	  return new ModelAndView("redirect:/admin/Login/list");
	 }
	 
	 @RequestMapping(value="/delete/{empId}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("empId") String empId){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String name = auth.getName();
		    if(name.equals("myempid")) {
	  LoginService.deleteLogin(empId);}
		    else {return new ModelAndView("error");}
	  return new ModelAndView("redirect:/admin/Login/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("Login/Login_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
