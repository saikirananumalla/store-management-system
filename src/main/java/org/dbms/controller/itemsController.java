package org.dbms.controller;

import java.util.List;

import org.dbms.model.items;
import org.dbms.service.itemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

@RequestMapping(value="/items")
public class itemsController {
	@Autowired
	 itemsService itemsService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("items/items_page");
	  
	  List list = itemsService.listAllitemss();
	  model.addObject("listitems", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("items/items_form");
	  
	  items items = new items();
	  model.addObject("itemsForm", items);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("itemsForm") items items){

	   itemsService.additems(items);
	
	  return new ModelAndView("redirect:/items/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") String id){
	  ModelAndView model = new ModelAndView("items/itemsupdate");
	  
	  items items = itemsService.finditemsbyId(id);
	  model.addObject("itemsForm", items);
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("itemsForm") items items){

	   itemsService.updateitems(items);
	
	  return new ModelAndView("redirect:/items/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") String id){
	  itemsService.deleteitems(id);
	  
	  return new ModelAndView("redirect:/items/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("items/items_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
