package com.lt.physic.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		
			String m =req.getParameter("m");
			
			 basicinfoj basicinfoj = new basicinfoj();
			 basicinfoj.setJid(req.getParameter("name"));
			 basicinfoj.setJnumber( req.getParameter("serchKey"));
			 basicinfoj.setJdossier(req.getParameter("fileNumber"));
	
			 licensey licensey = new licensey(); 
			 licensey.setYid(Integer.valueOf(req.getParameter("infoLicenseForTrading.licenceNumber")));
			 licensey.setYname(req.getParameter("infoLicenseForTrading.enterpriseName"));
			 licensey.setYaddress(req.getParameter("infoLicenseForTrading.registerAddress"));
			 licensey.setYfddbr(req.getParameter("infoLicenseForTrading.legalPerson"));
			 licensey.setYqyfzr(req.getParameter("infoLicenseForTrading.enterpriseManager"));
			 licensey.setYzlzr(req.getParameter("infoLicenseForTrading.qualityManager"));
			 licensey.setYckdz(req.getParameter("infoLicenseForTrading.warehouseAddress"));
			 licensey.setYtimeto(df.parse(req.getParameter("infoLicenseForTrading.validityDate")));
			 licensey.setYjyfs(req.getParameter("infoLicenseForTrading.businessPractice"));
			 licensey.setYjyfw(new String(req.getParameter("infoLicenseForTrading.businessScope").getBytes("iso-8859-1"), "UTF-8"));
			 licensey.setYfzjg(req.getParameter("infoLicenseForTrading.certificateDept"));
			 licensey.setYtimestart(df.parse(req.getParameter("infoLicenseForTrading.certificateDate")));
			
			 accountk accountk = new accountk();
			 accountk.setKback(req.getParameter("infoAccount.accountName"));
			 accountk.setKid(req.getParameter("infoAccount.accountBank"));
			 accountk.setKname(req.getParameter("infoAccount.account"));
		
			 gspg gspg = new gspg();
			 gspg.setGdz(req.getParameter("infoGsp.enterpriseAddress"));
			 gspg.setGfzjg(req.getParameter("infoGsp.certificateDept"));
			 gspg.setGid(Integer.parseInt(req.getParameter("infoGsp.certificateNumber")));
			 gspg.setGname(req.getParameter("infoGsp.enterpriseName"));
			 gspg.setGrzfw(req.getParameter("infoGsp.certificateScope"));
			 gspg.setGtimestart(df.parse(req.getParameter("infoGsp.certificateDate")));
			 gspg.setGtimeto(df.parse(req.getParameter("infoGsp.validityDate")));
			 
			 organizationz organizationz = new organizationz();
			 organizationz.setZaddress(req.getParameter("infoOrganizationCode.address"));
			 organizationz.setZbadw(req.getParameter("infoOrganizationCode.certificateDept"));
			 organizationz.setZcode(req.getParameter("infoOrganizationCode.code"));
			 organizationz.setZid(req.getParameter("infoOrganizationCode.registerNumber"));
			 organizationz.setZname(req.getParameter("infoOrganizationCode.name"));
			 organizationz.setZtimestart(df.parse(req.getParameter("infoOrganizationCode.validityTimeFrom")));
			 organizationz.setZtimeto(df.parse(req.getParameter("infoOrganizationCode.validityTimeTo")));
			 organizationz.setZtype(req.getParameter("infoOrganizationCode.type"));
			 
			 taxs taxs = new taxs();
			 taxs.setSdjzclx(req.getParameter("infoTax.registerType"));
			 taxs.setSdz(req.getParameter("infoTax.address"));
			 taxs.setSfddbr(req.getParameter("infoTax.legalPerson"));
			 taxs.setSfzjg(req.getParameter("infoTax.certificateDept"));
			 taxs.setSfzrq(df.parse(req.getParameter("infoTax.certificateDate")));
			 taxs.setSid(req.getParameter("infoTax.number"));
			 taxs.setSjyfw(req.getParameter("infoTax.businessScope"));
			 taxs.setSkjyw(req.getParameter("infoTax.withholdings"));
			 taxs.setSnsrname(req.getParameter("infoTax.name"));
			 taxs.setSpzsljg(req.getParameter("infoTax.authorizeDept"));
			 							
			 ylicensejj ylicensejj = new ylicensejj();
			 ylicensejj.setJjfazj(req.getParameter("infoLicenseForBusiness.certificateDept"));
			 ylicensejj.setJjfddbrxm(req.getParameter("infoLicenseForBusiness.legalPersonName"));
			 ylicensejj.setJjgslx(req.getParameter("infoLicenseForBusiness.companyType"));
			 ylicensejj.setJjid(req.getParameter("infoLicenseForBusiness.registerNumber"));
			 ylicensejj.setJjjyfw(req.getParameter("infoLicenseForBusiness.scope"));
			 ylicensejj.setJjname(req.getParameter("infoLicenseForBusiness.name"));
			 ylicensejj.setJjssb(Double.valueOf(req.getParameter("infoLicenseForBusiness.actualPrincipal")));
			 ylicensejj.setJjtimefound(df.parse(req.getParameter("infoLicenseForBusiness.dateOfEstablishment")));
			 ylicensejj.setJjtimeset(df.parse(req.getParameter("infoLicenseForBusiness.certificateDate")));
			 ylicensejj.setJjtimestar(df.parse(req.getParameter("infoLicenseForBusiness.allotedTimeFrom")));
			 ylicensejj.setJjtimeto(df.parse(req.getParameter("infoLicenseForBusiness.allotedTimeTo")));
			 ylicensejj.setJjzczb(Double.valueOf(req.getParameter("infoLicenseForBusiness.registerPrincipal")));
			 ylicensejj.setJjzs(req.getParameter("infoLicenseForBusiness.domicile"));
			 
		
			basicinfojDAOimpl ba = new basicinfojDAOimpl();
			if(m.equals("save")){
				ba.save(basicinfoj,licensey,accountk,gspg,organizationz,taxs,ylicensejj);
			}else if(m.equals("edit")){
				
	//			sql="update users set fristname='"+fristname+"',lastname ='"+lastname+"',phone ='"+phone+"',eamil = '"+email+"' where id='"+id+"'";
	//		}else if(m.equals("remove")){
	//			sql = "delete FROM users WHERE id='"+id+"'";
			}
		} catch (ParseException e) {
				e.printStackTrace();
		}

	}
}
