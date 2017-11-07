package com.my.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleExecutor implements Executor {

	public static final String URL = "jdbc:mysql://192.168.1.87:3306/ld_wenbo_pingtai";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	public static final String sql = "select * from u001 u where u.C880001= \'%1$s\'";
	
	
	@Override
	public <T> T query(String statement, Object parameter) {
		try(
	        //1. 获得数据库连接
				Connection  conn = DriverManager.getConnection(URL, USER, PASSWORD);
	        //2.操作数据库，实现增删改查
				PreparedStatement stmt = conn.prepareStatement(String.format(statement,(String)parameter));
				ResultSet rs = stmt.executeQuery()){
	        //如果有数据，rs.next()返回true
	        while(rs.next()){
	        	UserInfo user=new UserInfo();
	        	user.setUserName(rs.getString("C880002"));
	        	user.setEmail1(rs.getString("C880009"));
	        	return (T)user;
	        }
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		return null;
	}
	
	static class UserInfo{
		String userName;
		
		String email1;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail1() {
			return email1;
		}

		public void setEmail1(String email1) {
			this.email1 = email1;
		}
		
		
	}

}
