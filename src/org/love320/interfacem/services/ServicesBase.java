package org.love320.interfacem.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServicesBase {

	@Autowired
	private JdbcTemplate resJdbc;

	public boolean newText() {
		String sql = "SELECT * FROM interface";
		List list = resJdbc.queryForList(sql);
		return true;
	}

	/** 获取接口组名列表 */
	public List newFaceGroup() {
		String sql = "SELECT  `id`,  `name`,  `type`,  `status`,  LEFT(`text`, 256) as text,  `createtime` FROM `interfacegroup`";
		return resJdbc.queryForList(sql);
	}

	/** 获取指定组接口列表 */
	public List newFaceList(Integer id) {
		String sql = "SELECT * FROM interface ";
		sql += " where groupid = ?";
		return resJdbc.queryForList(sql, id);
	}

	public Map newInfo(Integer id) {
		String sql = "SELECT * FROM interface WHERE id = ?";
		try {
			return resJdbc.queryForMap(sql, id);
		} catch (Exception e) {
		}
		return null;
	}

	/** 创建接口名 */
	public int newCreateFace(String name) {
		// 创建接口
		String sql = "INSERT INTO `interface` (`name`) VALUES (?);";
		int id = resJdbc.update(sql, name);
		// 查询接口id
		// 使用LAST_INSERT_ID()数据库方式获取新增id （线程是安全的）
		id = resJdbc
				.queryForInt("SELECT LAST_INSERT_ID() from interface limit 1");
		if (id <= 0) {
			// 使用获取新增最大id，获取新新增id (线程是不安全)
			id = resJdbc.queryForInt("select max(id) from interface ");
		}
		return id;
	}

	/**保存接口信息*/
	public int save(String name, Integer id, Integer type, Integer status,
			String faceurl, String url, Integer method) {
		String sql = "UPDATE `interface` SET `name`=?, `type`=?, `status`=?, `faceurl`=?, `url`=?, `method`=? WHERE  `id`=? LIMIT 1;";
		return resJdbc.update(sql,name,type,status,faceurl,url,method,id);
	}

}
