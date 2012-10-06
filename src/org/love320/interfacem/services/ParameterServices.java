package org.love320.interfacem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public int newSave(Integer id,Integer species,Integer faceid,Integer superior, Integer type, Integer isnull, String name,
			String nametext) {
		String sql = "";
		int num = 0;
		if(id > 0 ){
			sql = "UPDATE `parameter` SET `faceid`=?, `type`=?, `name`=?, `nametext`=?, `isnull`=?, `updatetime`=now() WHERE  `id`=? LIMIT 1;";
			num = resJdbc.update(sql,faceid,type,name,nametext,isnull,id);
			num = id;
		}else{
			sql = "INSERT INTO `parameter` (`faceid`, `superior`,`type`, `name`, `nametext`, `isnull`,`species`,`createtime`) VALUES (?,?,?,?,?,?,?,now());";
			num = resJdbc.update(sql,faceid,superior,type,name,nametext,isnull,species);
			
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
		String sql = "SELECT * FROM parameter where faceid = ? and species = 1 order by id asc";
		return resJdbc.queryForList(sql,id);
	}
	
	public List newListByIdAndSuperior(Integer faceid,Integer species) {
		List list = newListData(faceid,0,species);
		List newlist = new ArrayList();
		newTreeToList(newlist,list,-1);
		return newlist;
	}
	
	//从树形转list
	public void newTreeToList(List newlist,List list,Integer level){
		level++;
		for(Object object : list){
			if(object instanceof Map){
				Map objectMap = (Map)object;
				objectMap.put("level", level);
				newlist.add(object);
			}
			if(object instanceof List){
				newTreeToList(newlist,(List)object,level);
			}
		}
	}
	
	//递归
	public List newListData(Integer faceid,Integer id,Integer species){
		List list = new ArrayList();
		String sql = "SELECT * FROM parameter where faceid = ? and superior = ? and species = ? order by id asc";
		List sqlist = resJdbc.queryForList(sql,faceid,id,species);
		for(Object object : sqlist){
			Map sing = (Map)object;
			Integer intid = (Integer)sing.get("id");
			list.add(object);
			list.add(newListData(faceid,intid,species));
		}
		return list;
	}

	public int newDelete(Integer id) {
		String sql = "DELETE FROM `parameter` WHERE  `id`=? LIMIT 1;";
		return resJdbc.update(sql,id);
	}
	
	
	
}
