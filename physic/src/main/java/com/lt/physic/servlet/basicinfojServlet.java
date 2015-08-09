package com.lt.physic.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lt.physic.dao.basicinfojDAOimpl;
import com.lt.physic.pojo.basicinfoj;
import com.lt.physic.util.JsonUtil;



public class basicinfojServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Servlet servlet = new Servlet();
		Statement stmt = servlet.getStmt();//向数据库里发sql语句
		basicinfojDAOimpl basicinfoj = new basicinfojDAOimpl();
		String jsonStr = JsonUtil.toJson(basicinfoj.query(stmt));
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

}
