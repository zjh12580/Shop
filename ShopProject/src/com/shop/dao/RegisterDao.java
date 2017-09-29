package com.shop.dao;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.shop.domain.RegisterUser;
import com.shop.domain.User;
import com.shop.utils.DataSourceUtils;


public class RegisterDao {

	public boolean queryUserIsExist(String userName) {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select count(*) from user where username=?";
		Long users = null;
		try {
			users = (Long) runner.query(sql, new ScalarHandler(), userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  return (users.longValue() > 0);
	}

	public boolean registerUser(RegisterUser user) throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user (uid,username,password,name,email,birthday,sex) values (?,?,?,?,?,?,?)";
		int rs = runner.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getBirthday(),user.getSex());
		return rs > 0;
	}

	public User quaryUser(String userName, String password) throws SQLException {
  
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = runner.query(sql, new BeanHandler<>(User.class),userName,password);
		return user;
	}

	
	
}
