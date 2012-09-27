package org.love320.interfacem;

import org.love320.interfacem.services.ServicesBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@Autowired
	private ServicesBase servicesBase;
	
	public void setServicesBase(ServicesBase servicesBase) {
		this.servicesBase = servicesBase;
	}


	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		servicesBase.newText();
		return "helloWorld";
	}
	
}
