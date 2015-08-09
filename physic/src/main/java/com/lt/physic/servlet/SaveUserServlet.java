package com.lt.physic.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lt.physic.dao.basicinfojDAOimpl;
import com.lt.physic.pojo.accountk;
import com.lt.physic.pojo.basicinfoj;
import com.lt.physic.pojo.licensey;



public class SaveUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String m =req.getParameter("m");
		
		 basicinfoj basicinfoj = new basicinfoj();
		 basicinfoj.setJid(req.getParameter("jid"));
		 basicinfoj.setJnumber( req.getParameter("jnumber"));
		 basicinfoj.setJdossier(req.getParameter("jdossier"));

		 licensey licensey = new licensey(); 
		 licensey.setYid(Integer.valueOf(req.getParameter("Yid")));
		 licensey.setYname(req.getParameter("Yname"));
		 licensey.setYaddress(req.getParameter("Yaddress"));
		 licensey.setYfddbr(req.getParameter("Yfddbr"));
		 licensey.setYqyfzr(req.getParameter("Yqyfzr"));
		 licensey.setYzlzr(req.getParameter("Yzlzr"));
		 licensey.setYckdz(req.getParameter("Yckdz"));
		 licensey.setYtimeto(req.getParameter("Ytimeto"));
		 licensey.setYjyfs(req.getParameter("Yjyfs"));
		 licensey.setYfzjg(req.getParameter("Yfzjg"));
		 licensey.setYtimestart(req.getParameter("Ytimestart"));
		
		 accountk accountk = new accountk();
		 accountk.setKback(req.getParameter("Kback"));
	
		basicinfojDAOimpl ba = new basicinfojDAOimpl();
	
		if(m.equals("save")){
			ba.save(basicinfoj,licensey,accountk);
		}else if(m.equals("edit")){
			
//			sql="update users set fristname='"+fristname+"',lastname ='"+lastname+"',phone ='"+phone+"',eamil = '"+email+"' where id='"+id+"'";
//		}else if(m.equals("remove")){
//			sql = "delete FROM users WHERE id='"+id+"'";
		}
		

	}
}
