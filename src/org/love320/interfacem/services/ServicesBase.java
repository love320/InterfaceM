package org.love320.interfacem.services;

import java.util.List;

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

}
