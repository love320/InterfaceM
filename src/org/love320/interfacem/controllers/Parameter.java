package org.love320.interfacem.controllers;

import org.love320.interfacem.services.ParameterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class Parameter {

	@Autowired
	private ParameterServices parameterServices; 
	
	@RequestMapping("/parameter-list")
	public String list(Model model){
		
		
		return null;
	}
	
	
}
