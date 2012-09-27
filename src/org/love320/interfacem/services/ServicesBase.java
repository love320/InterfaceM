package org.love320.interfacem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServicesBase {
	
	@Autowired
	private JdbcTemplate resJdbcTemplate;

	public void setResJdbcTemplate(JdbcTemplate resJdbcTemplate) {
		this.resJdbcTemplate = resJdbcTemplate;
	}
	
	public boolean newText(){
		String sql = "SELECT * FROM BootAnimation";
		List list = resJdbcTemplate.queryForList(sql);
		System.out.println(list);
		return true;
	}
	
	
}
