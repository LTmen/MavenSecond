package com.lt.physic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lt.physic.pojo.accountk;
import com.lt.physic.pojo.basicinfoj;
import com.lt.physic.pojo.gspg;
import com.lt.physic.pojo.licensey;
import com.lt.physic.pojo.organizationz;
import com.lt.physic.pojo.taxs;
import com.lt.physic.pojo.ylicensejj;
import com.lt.physic.servlet.Servlet;

public class basicinfojDAOimpl {
	Servlet servlet = new Servlet();
	Statement stmt = servlet.getStmt();// �����ݿ��﷢sql���
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
			int jname = 0 ;
			String sq1= null;
			String sq2= null;
			String sq3= null;
			String sq4= null;
			String sq5= null;
			String sq6= null;
			String sq7= null;
		//sq1-sq7 ���ͳһcommit���Ͳ���select 'jname',��ȫ��insertǰ,����insert basicinfoj��õ���janme��1 =,=�����ƶ�sql1��jname��ֵ
			sql = "insert into basicinfoj (jid,jnumber,jdossier) values ('"+b.getJid()+"','"+b.getJnumber()+"','"+b.getJdossier()+"')";
			int count = stmt.executeUpdate(sql);
			sq1 ="select jname from basicinfoj where jid = '"+b.getJid()+"'";	
			rs = stmt.executeQuery(sq1);
			while(rs.next())
				jname =rs.getInt("jname");
			sql = "delete from basicinfoj where jname = "+jname+"";
			count = stmt.executeUpdate(sql);
			System.out.println(jname++);
			System.out.println(jname);
			conn.setAutoCommit(false);
		//���ű�ͳһ����	
			sq1 = "insert into basicinfoj (jid,jnumber,jdossier) values ('"+b.getJid()+"','"+b.getJnumber()+"','"+b.getJdossier()+"')";
			sq2 ="insert into licensey (yid,yname,yaddress,yfddbr,yqyfzr,yzlfzr,yckdz,ytimeto,yjyfs,yfzjg,ytimestart,jname) values ("+l.getYid()+",'"+l.getYname()+"','"+l.getYaddress()+"','"+l.getYfddbr()+"','"+l.getYqyfzr()+"','"+l.getYzlzr()+"','"+l.getYckdz()+"','"+l.getYtimeto()+"','"+l.getYjyfs()+"','"+l.getYfzjg()+"','"+l.getYtimestart()+"',"+jname+")";
			sq3 ="insert into accountk (kname,kback,kid,jname) values ('"+ a.getKname()+"','"+a.getKback()+"','"+a.getKid()+"',"+jname+")";
			sq4 ="intset into gspg (gid,gname,gdz,grzfw,gtimeto,gfzjg,gtimestart,jname) values ( " +g.getGid()+",'"+g.getGname()+"','"+g.getGdz()+"','"+g.getGrzfw()+"',"+g.getGtimeto()+",'"+g.getGfzjg()+"',"+g.getGfzjg()+","+jname+"";
			sq5 ="insert into organizationz (zcod,zname,ztype,zaddress,ztimestart,ztimeto,zbadw,zid,jname) values ('"+o.getZcode()+"','"+o.getZname()+"','"+o.getZtype()+"'+'"+o.getZaddress()+"',"+o.getZtimestart()+","+o.getZtimeto()+",'"+o.getZbadw()+"','"+o.getZid()+"',"+jname+"";
			sq6 ="insert into taxs (sid,snsrname,sfddbr,sdz,sdjzclx,sjyfw,spzsljg,skjyw,sfzjg,sfzrq,jname) values ('"+t.getSid()+"','"+t.getSnsrname()+"','"+t.getSfddbr()+"','"+t.getSdz()+"','"+t.getSdjzclx()+"','"+t.getSjyfw()+"','"+t.getSpzsljg()+"','"+t.getSkjyw()+"','"+t.getSfzjg()+"',"+t.getSfzrq()+","+jname+"";
			sq7 ="insert into ylicensejj (jjid,jjname,jjzs,jjfddbrxm,jjzczb,jjsszb,jjgslx,jjjyfw,jjtimefound,jjtimestar,jjtimeto,jjfazj,jjtimeset,jname) values ('"+y.getJjid()+"','"+y.getJjname()+"','"+y.getJjzs()+"','"+y.getJjfddbrxm()+"',"+y.getJjzczb()+",'"+y.getJjssb()+",'"+y.getJjgslx()+"','"+y.getJjjyfw()+"',"+y.getJjtimefound()+","+y.getJjtimestar()+","+y.getJjtimeto()+",'"+y.getJjfazj()+"',"+y.getJjtimeset()+","+jname+"";
			stmt.addBatch(sq1);
			stmt.addBatch(sq2);
			stmt.addBatch(sq3);
			stmt.addBatch(sq4);
			stmt.addBatch(sq5);
			stmt.addBatch(sq6);
			stmt.addBatch(sq7);
			stmt.executeBatch();
			conn.commit();
//			int count2=stmt.executeUpdate(sql);
//			if(count2>0){
//				System.out.println("�ɹ�");
//			}
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback()����e1");
				e1.printStackTrace();
			}
			
		}
	}
}
