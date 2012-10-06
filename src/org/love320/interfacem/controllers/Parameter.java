package org.love320.interfacem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.love320.interfacem.services.ParameterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class Parameter {

	@Autowired
	private ParameterServices parameterServices; 
	
	@RequestMapping("/parameter-list")
	public @ResponseBody  Object list(Model model,Integer id){
		//List list = parameterServices.newListAll();
		List list = parameterServices.newListById(id);
		Gson gson = new Gson();
		Map dataMap = new HashMap();
		dataMap.put("Lists", list);
		return gson.toJson(dataMap);
	}
	
	@RequestMapping("/parameter-save")
	public @ResponseBody Object save(Model model,Integer id,Integer faceid,Integer type,Integer isnull,@RequestParam(value="",required=false)String name,@RequestParam(value="",required=false)String nametext){
		int stauts = parameterServices.newSave(id,faceid,type, isnull, name, nametext);
		Map objectMap = new HashMap();
		objectMap.put("code",1);
		objectMap.put("id", stauts);
		Gson gson = new Gson();
		return gson.toJson(objectMap);
	}
	
	@RequestMapping("/parameter-delete")
	public @ResponseBody Object delete(Integer id){
		int stauts = parameterServices.newDelete(id);
		return null;
	}
	
}
