package org.dbms.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    
	@RequestMapping("/")
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    if(name.equals("myempid")) {
	    modelAndView.setViewName("index");
	    }
	    else {
	    	modelAndView.setViewName("index2");
	    	}
	    return modelAndView;
	}
	@RequestMapping("/views")
	public ModelAndView views () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("viu");
	    return modelAndView;
	}
	@RequestMapping("/login")
	public ModelAndView login () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("login");
	    return modelAndView;
	}
	@RequestMapping("/logoutcomplete")
	public ModelAndView logout () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("logoutpage");
	    return modelAndView;
	}
	 
	@GetMapping(value="/error")
	  public String error() {
		 return "error";
	   }
	@RequestMapping("/admin")
	public ModelAndView owner () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("owner");
	    return modelAndView;
	}
}
