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
	
	
	
}
