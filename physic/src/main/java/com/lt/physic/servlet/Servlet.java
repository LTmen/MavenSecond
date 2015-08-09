package com.lt.physic.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class Servlet {
	Connection conn = null;
	Statement stmt = null;//向数据库里发sql语句
	public Servlet() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		String url="jdbc:mysql://localhost:3306/ypglxt";
		String username="root";
		String password="12345";
		
		try{
			conn = DriverManager.getConnection(url,username,password);
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		try{
			stmt = conn.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
	public Connection getConn() {
		return conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	
	
}
