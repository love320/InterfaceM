package org.love320.interfacem.services;

import org.springframework.stereotype.Service;

@Service
public class ServicesBase {

	public boolean newText() {
		String sql = "SELECT * FROM interface";
		return true;
	}

}
