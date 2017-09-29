package com.shop.service;

import java.sql.SQLException;

import com.shop.dao.RegisterDao;
import com.shop.domain.RegisterUser;
import com.shop.domain.User;

public class RegisterService {

	public boolean queryUserNameIsExist(String userName) {

		RegisterDao dao = new RegisterDao();
		return dao.queryUserIsExist(userName);
	}

	public boolean registerUser(RegisterUser user) {
  
		RegisterDao dao = new RegisterDao();
		boolean isSucceed = false;
		try {
			isSucceed = dao.registerUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          return isSucceed;
	}

	public User quaryUser(String userName, String password) {
		RegisterDao dao = new RegisterDao();
		User user = null;
		try {
			user = dao.quaryUser(userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}	
	
}
