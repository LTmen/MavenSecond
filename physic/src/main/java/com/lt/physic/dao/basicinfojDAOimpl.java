package com.lt.physic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lt.physic.pojo.accountk;
import com.lt.physic.pojo.bDAOimpl;
import com.lt.physic.pojo.basicinfoj;
import com.lt.physic.pojo.gspg;
import com.lt.physic.pojo.licensey;
import com.lt.physic.pojo.organizationz;
import com.lt.physic.pojo.taxs;
import com.lt.physic.pojo.ylicensejj;
import com.lt.physic.servlet.Servlet;
import com.lt.physic.util.Dateformat;


public class basicinfojDAOimpl {
	
	Servlet servlet = new Servlet();
	Statement stmt = servlet.getStmt();// 向数据库里发sql语句
	Connection conn = servlet.getConn();
	String sql = null;
	ResultSet rs = null;
	public List<basicinfoj> query(Statement stmt) {

		String sql = "select * from basicinfoj";
		List<basicinfoj> l = new ArrayList<basicinfoj>();
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				basicinfoj basicinfoj = new basicinfoj();
				basicinfoj.setJid(rs.getString("jid"));
				basicinfoj.setJnumber(rs.getString("jnumber"));
				basicinfoj.setJdossier(rs.getString("jdossier"));
				basicinfoj.setJname(rs.getInt("jname"));
				l.add(basicinfoj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}
	
	public void save(basicinfoj b,licensey l,accountk a,gspg g,organizationz o,taxs t,ylicensejj y){
		try{
			Dateformat dateformat = new Dateformat();//Date转化类型
			Dateformat df = new Dateformat();
			int jname = 0 ;
			String sq1= null;
			String sq2= null;
			String sq3= null;
			String sq4= null;
			String sq5= null;
			String sq6= null;
			String sq7= null;

			conn.setAutoCommit(false);
		//七张表统一插入	
			sq1 = "insert into basicinfoj (jid,jnumber,jdossier) values ('"+b.getJid()+"','"+b.getJnumber()+"','"+b.getJdossier()+"')";

			PreparedStatement pstmt = conn.prepareStatement(sq1,Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = null ;
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next())
				jname = rs.getInt(1);
			System.out.println(jname);
			sq2 ="insert into licensey (yjyfw,yid,yname,yaddress,yfddbr,yqyfzr,yzlfzr,yckdz,ytimeto,yjyfs,yfzjg,ytimestart,jname) values ('"+l.getYjyfw()+"',"+l.getYid()+",'"+l.getYname()+"','"+l.getYaddress()+"','"+l.getYfddbr()+"','"+l.getYqyfzr()+"','"+l.getYzlzr()+"','"+l.getYckdz()+"','"+df.dateformat(l.getYtimeto())+"','"+l.getYjyfs()+"','"+l.getYfzjg()+"','"+df.dateformat(l.getYtimestart())+"',"+jname+")";
			sq3 ="insert into accountk (kname,kback,kid,jname) values ('"+ a.getKname()+"','"+a.getKback()+"','"+a.getKid()+"',"+jname+")";
			sq4 ="insert into gspg (gid,gname,gdz,grzfw,gtimeto,gfzjg,gtimestart,jname) values ( " +g.getGid()+",'"+g.getGname()+"','"+g.getGdz()+"','"+g.getGrzfw()+"','"+df.dateformat(g.getGtimeto())+"','"+g.getGfzjg()+"','"+df.dateformat(g.getGtimestart())+"',"+jname+")";
			sq5 ="insert into organizationz (zcode,zname,ztype,zaddress,ztimestart,ztimeto,zbadw,zid,jname) values ('"+o.getZcode()+"','"+o.getZname()+"','"+o.getZtype()+"','"+o.getZaddress()+"','"+df.dateformat(o.getZtimestart())+"','"+df.dateformat(o.getZtimeto())+"','"+o.getZbadw()+"','"+o.getZid()+"',"+jname+")";
			sq6 ="insert into taxs (sid,snsrname,sfddbr,sdz,sdjzclx,sjyfw,spzsljg,skjyw,sfzjg,sfzrq,jname) values ('"+t.getSid()+"','"+t.getSnsrname()+"','"+t.getSfddbr()+"','"+t.getSdz()+"','"+t.getSdjzclx()+"','"+t.getSjyfw()+"','"+t.getSpzsljg()+"','"+t.getSkjyw()+"','"+t.getSfzjg()+"','"+df.dateformat(t.getSfzrq())+"',"+jname+")";
			sq7 ="insert into ylicensejj (jjid,jjname,jjzs,jjfddbrxm,jjzczb,jjsszb,jjgslx,jjjyfw,jjtimefound,jjtimestar,jjtimeto,jjfazj,jjtimeset,jname) values ('"+y.getJjid()+"','"+y.getJjname()+"','"+y.getJjzs()+"','"+y.getJjfddbrxm()+"',"+y.getJjzczb()+","+y.getJjssb()+",'"+y.getJjgslx()+"','"+y.getJjjyfw()+"','"+df.dateformat(y.getJjtimefound())+"','"+df.dateformat(y.getJjtimestar())+"','"+df.dateformat(y.getJjtimeto())+"','"+y.getJjfazj()+"','"+df.dateformat(y.getJjtimeset())+"',"+jname+")";
			
			System.out.println(sq6);
			System.out.println(sq2);
			System.out.println(sq3);
			System.out.println(sq4);
			System.out.println(sq5);
			System.out.println(sq1);
			System.out.println(sq7);
			System.out.println(sql);

			stmt.addBatch(sq2);
			stmt.addBatch(sq3);
			stmt.addBatch(sq4);
			stmt.addBatch(sq5);
			stmt.addBatch(sq6);
			stmt.addBatch(sq7);
			stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				System.out.println("rollback()不对e1");
				e1.printStackTrace();
			}
			
		}
	}
	public bDAOimpl delete(basicinfoj b){
		bDAOimpl bDAOimpl = new bDAOimpl();
		int count =1 ;
		String[] sql = new String[8];
			sql[1]= "delete FROM ylicensejj WHERE jname="+b.getJname()+"";
			
			sql[2]= "delete FROM accountk WHERE jname="+b.getJname()+"";
			sql[3]= "delete FROM gspg WHERE jname="+b.getJname()+"";
			sql[4]= "delete FROM licensey WHERE jname="+b.getJname()+"";
			sql[5]= "delete FROM organizationz WHERE jname="+b.getJname()+"";
			sql[6]= "delete FROM taxs WHERE jname="+b.getJname()+"";
			sql[7]= "delete FROM basicinfoj WHERE jname="+b.getJname()+"";

			System.out.println(sql[1]);			
			System.out.println(sql[2]);
			System.out.println(sql[3]);
			System.out.println(sql[4]);
			System.out.println(sql[5]);
			System.out.println(sql[6]);
			System.out.println(sql[7]);
		try {
			for (int i = 1; i < 8; i++) {
				 if(stmt.executeUpdate(sql[i])<0){
					 count = -1;
				 }
			}

			if(count>=0){
				bDAOimpl.setMsg("success");
				bDAOimpl.setTxt("删除成功");
			}else{
				bDAOimpl.setMsg("error");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return bDAOimpl;
	}
	public bDAOimpl edit(basicinfoj b,licensey l,accountk a,gspg g,organizationz o,taxs t,ylicensejj y){
		bDAOimpl bimpl = new bDAOimpl();
		try{
			Dateformat dateformat = new Dateformat();//Date转化类型
			Dateformat df = new Dateformat();
			int jname = 0 ;
			int count = 0;
			String[] sql = new String[8];
			conn.setAutoCommit(false);
		//七张表统一插入	
			sql[1] ="update basicinfoj set jid='"+b.getJid()+"',jnumber = '"+b.getJnumber()+"', jdossier ='"+b.getJdossier()+"' where jname="+b.getJname()+"";
			sql[2] ="update licensey set yjyfw ='"+l.getYjyfw()+"' ,yid ="+l.getYid()+",yname='"+l.getYname()+"',yaddress='"+l.getYaddress()+"',yfddbr='"+l.getYfddbr()+"',yqyfzr='"+l.getYqyfzr()+"',yzlfzr='"+l.getYzlzr()+"',yckdz='"+l.getYckdz()+"',ytimeto='"+df.dateformat(l.getYtimeto())+"',yjyfs='"+l.getYjyfs()+"',yfzjg='"+l.getYfzjg()+"',ytimestart='"+df.dateformat(l.getYtimestart())+"' where jname="+b.getJname()+"";
			sql[3] ="update accountk set kname='"+ a.getKname()+"',kback='"+a.getKback()+"',kid='"+a.getKid()+"'  where jname="+b.getJname()+"";
			sql[4] ="update gspg set gid=" +g.getGid()+",gname='"+g.getGname()+"',gdz='"+g.getGdz()+"',grzfw='"+g.getGrzfw()+"',gtimeto='"+df.dateformat(g.getGtimeto())+"',gfzjg='"+g.getGfzjg()+"',gtimestart='"+df.dateformat(g.getGtimestart())+"' where jname="+b.getJname()+"";  
			sql[5] ="update organizationz set zcode='"+o.getZcode()+"',zname='"+o.getZname()+"',ztype='"+o.getZtype()+"',zaddress='"+o.getZaddress()+"',ztimestart='"+df.dateformat(o.getZtimestart())+"',ztimeto='"+df.dateformat(o.getZtimeto())+"',zbadw='"+o.getZbadw()+"',zid='"+o.getZid()+"' where jname="+b.getJname()+""; 
			sql[6] ="update taxs set sid='"+t.getSid()+"',snsrname='"+t.getSnsrname()+"',sfddbr='"+t.getSfddbr()+"',sdz='"+t.getSdz()+"',sdjzclx='"+t.getSdjzclx()+"',sjyfw='"+t.getSjyfw()+"',spzsljg='"+t.getSpzsljg()+"',skjyw='"+t.getSkjyw()+"',sfzjg='"+t.getSfzjg()+"',sfzrq='"+df.dateformat(t.getSfzrq())+"' where jname="+b.getJname()+""; 																 
			sql[7] ="update ylicensejj set jjid='"+y.getJjid()+"',jjname='"+y.getJjname()+"',jjzs='"+y.getJjzs()+"',jjfddbrxm='"+y.getJjfddbrxm()+"',jjzczb="+y.getJjzczb()+",jjsszb="+y.getJjssb()+",jjgslx='"+y.getJjgslx()+"',jjjyfw='"+y.getJjjyfw()+"',jjtimefound='"+df.dateformat(y.getJjtimefound())+"',jjtimestar='"+df.dateformat(y.getJjtimestar())+"',jjtimeto='"+df.dateformat(y.getJjtimeto())+"',jjfazj='"+y.getJjfazj()+"',jjtimeset='"+df.dateformat(y.getJjtimeset())+"' where jname="+b.getJname()+"";
				for (int i = 1; i < 8; i++) {
					System.out.println(sql[i]);
					stmt.addBatch(sql[i]);;
				}
			stmt.executeBatch();
			conn.commit();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					System.out.println("rollback()不对e1");
					e.printStackTrace();
				}
				
				e1.printStackTrace();
			}
		return bimpl;
	}


}
