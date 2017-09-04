package com.k2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HbaseController {
	

	@RequestMapping(value="/elabora", method = RequestMethod.POST)
	public String showTable(@ModelAttribute("codeSelected") String codice, ModelMap model) {
		
		model.addAttribute("codice",codice);
		return "/tabella";
	}
	
	
	
}









