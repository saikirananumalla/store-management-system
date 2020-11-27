package org.dbms.controller;

import java.util.List;

import org.dbms.model.item_voucher;
import org.dbms.service.item_voucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/item_voucher")
public class item_voucherController {
	@Autowired
	 item_voucherService item_voucherService;
	 
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("item_voucher/item_voucher_page");
	  
	  List list = item_voucherService.listAllitem_vouchers();
	  model.addObject("listitem_voucher", list);
	  
	  return model;
	 }
	 @RequestMapping(value="/listy", method=RequestMethod.GET)
	 public ModelAndView listy(){
	  ModelAndView model = new ModelAndView("item_voucher/item_voucher_page");
	  
	  List list = item_voucherService.listyitem_vouchers();
	  model.addObject("listitem_voucher", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("item_voucher/item_voucher_form");
	  List list = item_voucherService.listAllitem_vouchers();
	  item_voucher item_voucher = new item_voucher();
	  model.addObject("item_voucherForm", item_voucher);
	  model.addObject("listitem_voucher",list);
	  return model;
	 }
	 @RequestMapping(value="/add", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("item_voucherForm") item_voucher item_voucher){

	   item_voucherService.additem_voucher(item_voucher);
	
	  return new ModelAndView("redirect:/item_voucher/add");
	 }
	 @RequestMapping(value="/additems/{id}", method=RequestMethod.GET)
	 public ModelAndView additems(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("item_voucher/item_voucher_form");
	  item_voucher item_voucher = new item_voucher();
	  item_voucher.setVid(id);
	  model.addObject("item_voucherForm",item_voucher);
	  List list = item_voucherService.listyitem_vouchers();
	  model.addObject("listitem_voucher",list);
	  return model;
	 }
	 @RequestMapping(value="/addpost", method=RequestMethod.POST)
	 public ModelAndView addp(@ModelAttribute("item_voucherForm") item_voucher item_voucher){

	   item_voucherService.additem_voucher(item_voucher);
	
	  return new ModelAndView("redirect:/item_voucher/additems/"+item_voucher.getVid());
	 }
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
	  item_voucherService.deleteitem_voucher(id);
	  
	  return new ModelAndView("redirect:/item_voucher/list");
	 }
	 @ExceptionHandler
	 public ModelAndView handleException(Exception e) {
		 ModelAndView model = new ModelAndView("item_voucher/item_voucher_error");
		 model.addObject("errorMessage",e.getMessage());
		 return model;
	 }
}
