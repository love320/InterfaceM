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
			sql = "UPDATE `parameter` SET `faceid`=?, `type`=?, `name`=?, `nametext`=?, `isnull`=?, `updatetime`=now() WHERE  `id`=? LIMIT 1;";
			num = resJdbc.update(sql,faceid,type,name,nametext,isnull,id);
			num = id;
		}else{
			sql = "INSERT INTO `parameter` (`faceid`, `type`, `name`, `nametext`, `isnull`,`createtime`) VALUES (?,?,?,?,?,now());";
			num = resJdbc.update(sql,faceid,type,name,nametext,isnull);
			
			// 查询接口id
			// 使用LAST_INSERT_ID()数据库方式获取新增id （线程是安全的）
			num = resJdbc	.queryForInt("SELECT LAST_INSERT_ID() from parameter limit 1");
			if (num <= 0) {
					// 使用获取新增最大id，获取新新增id (线程是不安全)
				num = resJdbc.queryForInt("select max(id) from parameter ");
			}
		}
		
		
		return num;
	}

	public List newListById(Integer id) {
		String sql = "SELECT * FROM parameter where faceid = ? order by id asc";
		return resJdbc.queryForList(sql,id);
	}

	public int newDelete(Integer id) {
		String sql = "DELETE FROM `parameter` WHERE  `id`=? LIMIT 1;";
		return resJdbc.update(sql,id);
	}
	
	
	
}
