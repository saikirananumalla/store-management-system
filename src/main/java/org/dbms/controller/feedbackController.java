package org.dbms.controller;

import java.util.List;

import org.dbms.model.feedback;
import org.dbms.service.feedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/feedback")
public class feedbackController {
	@Autowired
	 feedbackService feedbackService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("feedback/feedback_page");
	  
	  List list = feedbackService.listAllfeedbacks();
	  model.addObject("listfeedback", list);
	  
	  return model;
	 }
	 @RequestMapping("/thanks")
		public ModelAndView index () {
		    ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("feedback/thanks");
		    return modelAndView;
		}
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("feedback/feedback_form");
	  
	  feedback feedback = new feedback();
	  model.addObject("feedbackForm", feedback);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("feedbackForm") feedback feedback){

	   feedbackService.addfeedback(feedback);
	
	  return new ModelAndView("redirect:/feedback/thanks");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("feedback/feedbackupdate");
	  
	  feedback feedback = feedbackService.findfeedbackbyId(id);
	  model.addObject("feedbackForm", feedback);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("feedbackForm") feedback feedback){

	   feedbackService.updatefeedback(feedback);
	
	  return new ModelAndView("redirect:/feedback/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  feedbackService.deletefeedback(id);
	  
	  return new ModelAndView("redirect:/feedback/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("feedback/feedback_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
