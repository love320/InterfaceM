package org.love320.interfacem.controllers;

import java.util.List;
import java.util.Map;

import org.love320.interfacem.services.InterfaceServices;
import org.love320.interfacem.services.ParameterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Interface {
	
	@Autowired
	private InterfaceServices interfaceServices; 
	
	@RequestMapping("/interface-list")
	public String list(Model model,@RequestParam(value="id",required=false) Integer id){
		if(id == null || id <= 0 ) id = 1;//初始化id值
		List listgroup = interfaceServices.newFaceGroup();//获取组列表
		List listface = interfaceServices.newFaceListInfo(id);//获取指定组列表并详细参数信息
		model.addAttribute("listgroup",listgroup);
		model.addAttribute("listface", listface);
		model.addAttribute("groupid",id);
		return "interface/list";
	}
	
	@RequestMapping("/interface-input")
	public String input(Model model,@RequestParam(value="id",required=false) Integer id){
		if(id != null || id >= 0 ) {
			Map entity = interfaceServices.newInfo(id);
			model.addAttribute("entity",entity);
		}
		List listgroup = interfaceServices.newFaceGroup();//获取组列表
		model.addAttribute("listgroup",listgroup);
		return "interface/input";
	}
	
	@RequestMapping("/interface-save")
	public ModelAndView  save(String name,Integer groupid,
			@RequestParam(value="id",required=false)Integer id,
			@RequestParam(value="type",required=false)Integer type,
			@RequestParam(value="status",required=false)Integer status,
			@RequestParam(value="faceurl",required=false)String faceurl,
			@RequestParam(value="method",required=false)Integer method,
			@RequestParam(value="url",required=false)String url,
			@RequestParam(value="writers",required=false)String writers,
			@RequestParam(value="version",required=false)String version,
			@RequestParam(value="text",required=false)String text,
			@RequestParam(value="returntext",required=false)String returntext
			){
		if(id == null || id <= 0){
			//创建接口名
			id = interfaceServices.newCreateFace(name,groupid);
			return new ModelAndView("redirect:/interface-input.do?id="+id); 
		}else{
			status = interfaceServices.save(name, id, groupid,type, status, faceurl, method, url, writers, version, text, returntext);
			return new ModelAndView("redirect:/interface-list.do?id=1"); 
		}
	}
	
	@RequestMapping("/interface-delete")
	public ModelAndView delete(Model model,Integer id,Integer groupid){
		int stauts = interfaceServices.delete(id);
		return new ModelAndView("redirect:/interface-list.do?id="+groupid); 
	}
	
	
}
