package org.love320.interfacem.controllers;

import org.love320.interfacem.services.ServicesBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@Autowired
	private ServicesBase servicesBase;

	public void setServicesBase(ServicesBase servicesBase) {
		this.servicesBase = servicesBase;
	}

	@RequestMapping("/helloWorld")
	public String helloWorld(Model model, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "type", required = false) String type) {
		model.addAttribute("message", "Hello World!");
		System.out.println(model);
		model.addAttribute("name", name);
		servicesBase.newText();
		System.out.println("name:" + name);
		//return "WEB-INF/view/helloWorld.ftl";
		return "helloWorld";
	}

}
