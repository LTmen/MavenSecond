package com.lt.physic.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lt.physic.dao.basicinfojDAOimpl;
import com.lt.physic.pojo.accountk;
import com.lt.physic.pojo.basicinfoj;
import com.lt.physic.pojo.gspg;
import com.lt.physic.pojo.licensey;
import com.lt.physic.pojo.organizationz;
import com.lt.physic.pojo.taxs;
import com.lt.physic.pojo.ylicensejj;



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
		 accountk.setKid(req.getParameter("Kid"));
		 accountk.setKname(req.getParameter("Kname"));
	
		 gspg gspg = new gspg();
		 gspg.setGdz(req.getParameter("Gdz"));
		 gspg.setGfzjg(req.getParameter("Gfzjg"));
		 gspg.setGid(Integer.valueOf(req.getParameter("Gid")));
		 gspg.setGname(req.getParameter("Gname"));
		 gspg.setGrzfw(req.getParameter("Grzfw"));
		 gspg.setGtimeto(Date.valueOf(req.getParameter("Gtimeto")));
		 gspg.setGtimestart(Date.valueOf(req.getParameter("Gtime")));
		 
		 organizationz organizationz = new organizationz();
		 organizationz.setZaddress(req.getParameter("Zaddress"));
		 organizationz.setZbadw(req.getParameter("Zbadw"));
		 organizationz.setZcode(req.getParameter("Zcode"));
		 organizationz.setZid(req.getParameter("Zid"));
		 organizationz.setZname(req.getParameter("Zname"));
		 organizationz.setZtimestart(req.getParameter("Ztimestart"));
		 organizationz.setZtimeto(req.getParameter("Ztimeto"));
		 organizationz.setZtype(req.getParameter("Ztype"));
		 
		 taxs taxs = new taxs();
		 taxs.setSdjzclx(req.getParameter("Sdjzclx"));
		 taxs.setSdz(req.getParameter("Sdz"));
		 taxs.setSfddbr(req.getParameter("Sfddbr"));
		 taxs.setSfzjg(req.getParameter("Sfzjg"));
		 taxs.setSfzrq(Date.valueOf(req.getParameter("Sfzrq")));
		 taxs.setSid(req.getParameter("Sid"));
		 taxs.setSjyfw(req.getParameter("Sjyfw"));
		 taxs.setSkjyw(req.getParameter("Skjyw"));
		 taxs.setSnsrname(req.getParameter("Snsrname"));
		 taxs.setSpzsljg(req.getParameter("Spzsljg"));
		 							
		 ylicensejj ylicensejj = new ylicensejj();
		 ylicensejj.setJjfazj(req.getParameter("Jjfazj"));
		 ylicensejj.setJjfddbrxm(req.getParameter("Jjfddbrxm"));
		 ylicensejj.setJjgslx(req.getParameter("Jjgslx"));
		 ylicensejj.setJjid(req.getParameter("Jjid"));
		 ylicensejj.setJjjyfw(req.getParameter("Jjjyfw"));
		 ylicensejj.setJjname(req.getParameter("Jjname"));
		 ylicensejj.setJjssb(Double.valueOf(req.getParameter("Jjssb")));
		 ylicensejj.setJjtimefound(req.getParameter("Jjtimefound"));
		 ylicensejj.setJjtimeset(req.getParameter("Jjtimeset"));
		 ylicensejj.setJjtimestar(req.getParameter("Jjtimestar"));
		 ylicensejj.setJjtimeto(req.getParameter("Jtimeto"));
		 ylicensejj.setJjzczb(Double.valueOf(req.getParameter("Jjzczb")));
		 ylicensejj.setJjzs(req.getParameter(req.getParameter("Jjzs")));
		 
		 
		basicinfojDAOimpl ba = new basicinfojDAOimpl();
	
		if(m.equals("save")){
			ba.save(basicinfoj,licensey,accountk,gspg,organizationz,taxs,ylicensejj);
		}else if(m.equals("edit")){
			
//			sql="update users set fristname='"+fristname+"',lastname ='"+lastname+"',phone ='"+phone+"',eamil = '"+email+"' where id='"+id+"'";
//		}else if(m.equals("remove")){
//			sql = "delete FROM users WHERE id='"+id+"'";
		}
		

	}
}
