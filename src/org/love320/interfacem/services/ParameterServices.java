package org.love320.interfacem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ParameterServices extends ServicesBase {
	@Autowired
	private JdbcTemplate resJdbc;

	public List newListAll() {
		String sql = "SELECT * FROM parameter";
		return resJdbc.queryForList(sql);
	}

	public int newSave(Integer id,Integer faceid, Integer type, Integer isnull, String name,
			String nametext) {
		String sql = "";
		int num = 0;
		if(id > 0 ){
			sql = "UPDATE `parameter` SET `faceid`=?, `type`=?, `name`=?, `nametext`=?, `isnull`=? WHERE  `id`=? LIMIT 1;";
			num = resJdbc.update(sql,faceid,type,name,nametext,isnull,id);
		}else{
			sql = "INSERT INTO `parameter` (`faceid`, `type`, `name`, `nametext`, `isnull`) VALUES (?,?,?,?,?);";
			num = resJdbc.update(sql,faceid,type,name,nametext,isnull);
		}
		return num;
	}

	public List newListById(Integer id) {
		String sql = "SELECT * FROM parameter where faceid = ?";
		return resJdbc.queryForList(sql,id);
	}
	
	
	
}
