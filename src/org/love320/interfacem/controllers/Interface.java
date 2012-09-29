package org.love320.interfacem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Interface {
	
	@RequestMapping("/interface-list")
	public String list(){
		System.out.println(">>>>");
		return "interface/list";
	}
	
}
