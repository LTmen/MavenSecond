package com.lt.physic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
			//sq1-sq7 如果统一commit，就不能select 'jname',在全部insert前,单独insert basicinfoj表得到的janme加1 =,=可以推断sql1后jname的值
//			sql = "insert into basicinfoj (jid,jnumber,jdossier) values ('"+b.getJid()+"','"+b.getJnumber()+"','"+b.getJdossier()+"')";
//			int count = stmt.executeUpdate(sql);
//			sq1 ="select jname from basicinfoj where jid = '"+b.getJid()+"'";	
//			rs = stmt.executeQuery(sq1);
//			while(rs.next())
//				jname =rs.getInt("jname");
//			sql = "delete from basicinfoj where jname = "+jname+"";
//			count = stmt.executeUpdate(sql);
//			System.out.println(jname++);
//			System.out.println(jname);
			conn.setAutoCommit(false);
		//七张表统一插入	
			sq1 = "insert into basicinfoj (jid,jnumber,jdossier) values ('"+b.getJid()+"','"+b.getJnumber()+"','"+b.getJdossier()+"')";
			sql = "select @jn :=:jname from basicinfoj where jid = '"+b.getJid()+"'";
			sq2 ="insert into licensey (yjyfw,yid,yname,yaddress,yfddbr,yqyfzr,yzlfzr,yckdz,ytimeto,yjyfs,yfzjg,ytimestart,jname) values ('"+l.getYjyfw()+"',"+l.getYid()+",'"+l.getYname()+"','"+l.getYaddress()+"','"+l.getYfddbr()+"','"+l.getYqyfzr()+"','"+l.getYzlzr()+"','"+l.getYckdz()+"','"+df.dateformat(l.getYtimeto())+"','"+l.getYjyfs()+"','"+l.getYfzjg()+"','"+df.dateformat(l.getYtimestart())+"',@jn)";
			sq3 ="insert into accountk (kname,kback,kid,jname) values ('"+ a.getKname()+"','"+a.getKback()+"','"+a.getKid()+"',@jn)";
			sq4 ="insert into gspg (gid,gname,gdz,grzfw,gtimeto,gfzjg,gtimestart,jname) values ( " +g.getGid()+",'"+g.getGname()+"','"+g.getGdz()+"','"+g.getGrzfw()+"','"+df.dateformat(g.getGtimeto())+"','"+g.getGfzjg()+"','"+df.dateformat(g.getGtimestart())+"',@jn)";
			sq5 ="insert into organizationz (zcode,zname,ztype,zaddress,ztimestart,ztimeto,zbadw,zid,jname) values ('"+o.getZcode()+"','"+o.getZname()+"','"+o.getZtype()+"','"+o.getZaddress()+"','"+df.dateformat(o.getZtimestart())+"','"+df.dateformat(o.getZtimeto())+"','"+o.getZbadw()+"','"+o.getZid()+"',@jn)";
			sq6 ="insert into taxs (sid,snsrname,sfddbr,sdz,sdjzclx,sjyfw,spzsljg,skjyw,sfzjg,sfzrq,jname) values ('"+t.getSid()+"','"+t.getSnsrname()+"','"+t.getSfddbr()+"','"+t.getSdz()+"','"+t.getSdjzclx()+"','"+t.getSjyfw()+"','"+t.getSpzsljg()+"','"+t.getSkjyw()+"','"+t.getSfzjg()+"','"+df.dateformat(t.getSfzrq())+"',@jn)";
			sq7 ="insert into ylicensejj (jjid,jjname,jjzs,jjfddbrxm,jjzczb,jjsszb,jjgslx,jjjyfw,jjtimefound,jjtimestar,jjtimeto,jjfazj,jjtimeset,jname) values ('"+y.getJjid()+"','"+y.getJjname()+"','"+y.getJjzs()+"','"+y.getJjfddbrxm()+"',"+y.getJjzczb()+","+y.getJjssb()+",'"+y.getJjgslx()+"','"+y.getJjjyfw()+"','"+df.dateformat(y.getJjtimefound())+"','"+df.dateformat(y.getJjtimestar())+"','"+df.dateformat(y.getJjtimeto())+"','"+y.getJjfazj()+"','"+df.dateformat(y.getJjtimeset())+"',@jn)";
			System.out.println(sq6);
			System.out.println(sq2);
			System.out.println(sq3);
			System.out.println(sq4);
			System.out.println(sq5);
			System.out.println(sq1);
			System.out.println(sq7);

			stmt.addBatch(sq1);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bDAOimpl;
	}
	public bDAOimpl edit(basicinfoj b,licensey l,accountk a,gspg g,organizationz o,taxs t,ylicensejj y){
		bDAOimpl bDAOimpl = new bDAOimpl();
		return bDAOimpl;
	}


}
