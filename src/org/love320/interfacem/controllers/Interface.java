package org.love320.interfacem.controllers;

import java.util.List;
import java.util.Map;

import org.love320.interfacem.services.ServicesBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Interface {
	
	@Autowired
	private ServicesBase servicesBase; 
	
	@RequestMapping("/interface-list")
	public String list(Model model,@RequestParam(value="id",required=false) Integer id){
		if(id == null || id <= 0 ) id = 1;//初始化id值
		List listgroup = servicesBase.newFaceGroup();//获取组列表
		List listface = servicesBase.newFaceList(id);//获取指定组列表
		model.addAttribute("listgroup",listgroup);
		model.addAttribute("listface", listface);
		return "interface/list";
	}
	
	@RequestMapping("/interface-input")
	public String input(Model model,@RequestParam(value="id",required=false) Integer id){
		if(id != null || id >= 0 ) {
			Map entity = servicesBase.newInfo(id);
			model.addAttribute("entity",entity);
		}
		List listgroup = servicesBase.newFaceGroup();//获取组列表
		model.addAttribute("listgroup",listgroup);
		return "interface/input";
	}
	
	@RequestMapping("/interfacce-save")
	public ModelAndView  save(String name,
			@RequestParam(value="id",required=false)Integer id,
			@RequestParam(value="type",required=false)Integer type,
			@RequestParam(value="status",required=false)Integer status,
			@RequestParam(value="faceurl",required=false)String faceurl,
			@RequestParam(value="url",required=false)String url,
			@RequestParam(value="method",required=false)Integer method
			){
		if(id == null || id <= 0){
			//创建接口名
			id = servicesBase.newCreateFace(name);
			return new ModelAndView("redirect:/interface-input.do?id="+id); 
		}else{
			status = servicesBase.save(name, id, type, status, faceurl, url, method);
			return new ModelAndView("redirect:/interface-list.do?id=1"); 
		}
	}
	
	
}
