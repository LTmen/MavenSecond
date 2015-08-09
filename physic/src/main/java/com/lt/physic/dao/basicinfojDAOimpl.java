package com.lt.physic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp.DbcpException;

import com.lt.physic.pojo.accountk;
import com.lt.physic.pojo.basicinfoj;
import com.lt.physic.pojo.licensey;
import com.lt.physic.servlet.Servlet;


public class basicinfojDAOimpl {
	Servlet servlet = new Servlet();
	Statement stmt = servlet.getStmt();//�����ݿ��﷢sql���
	Connection conn = servlet.getConn();
	String sql = null;
	ResultSet rs = null;
	public List<basicinfoj> query(Statement stmt ){
		
		String sql="select * from basicinfoj";
		List<basicinfoj> l = new ArrayList<basicinfoj>();
		try{
			 rs = stmt.executeQuery(sql);
			 while(rs.next()){
				 basicinfoj basicinfoj = new basicinfoj();
				 basicinfoj.setJid(rs.getString("jid"));
				 basicinfoj.setJnumber(rs.getString("jnumber"));
				 basicinfoj.setJdossier(rs.getString("jdossier"));
				 l.add(basicinfoj);
			 }
		}catch(SQLException e){
			e.printStackTrace();
		}

		return l;
	}
	
	public void save(basicinfoj b,licensey l,accountk a){
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
			
			stmt.addBatch(sq1);
			stmt.addBatch(sq2);
			stmt.addBatch(sq3);
			
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
