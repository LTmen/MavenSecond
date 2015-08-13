package test.com.physic.dao.basicinfojDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lt.physic.dao.basicinfojDAOimpl;
import com.lt.physic.pojo.accountk;
import com.lt.physic.pojo.basicinfoj;
import com.lt.physic.pojo.gspg;
import com.lt.physic.pojo.licensey;
import com.lt.physic.pojo.organizationz;
import com.lt.physic.pojo.taxs;
import com.lt.physic.pojo.ylicensejj;


public class basicinfojDAO {
	private basicinfojDAOimpl bDao ;
	@Before
	public void setUp(){
		bDao = new basicinfojDAOimpl();
		
		
	}
	@After
	public void tearDown(){
		
	}
	@Test
	public void testSave(){
		try {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		basicinfoj basicinfoj = new basicinfoj();
		basicinfoj.setJid("name");
		basicinfoj.setJnumber( "serchKey");
		basicinfoj.setJdossier("fileNumber");

		 licensey licensey = new licensey(); 
		 licensey.setYid(1);
		 licensey.setYname("enterpriseName");
		 licensey.setYaddress("registerAddress");
		 licensey.setYfddbr("legalPerson");
		 licensey.setYqyfzr("enterpriseManager");
		 licensey.setYzlzr("qualityManager");
		 licensey.setYckdz("warehouseAddress");
		 
		licensey.setYtimeto(df.parse("08/20/2015"));
		
		 licensey.setYjyfs("businessPractice");
		 licensey.setYjyfw("businessScope");
		 licensey.setYfzjg("certificateDept");
		 licensey.setYtimestart(df.parse("08/20/2015"));
		
		 accountk accountk = new accountk();
		 accountk.setKback("accountName");
		 accountk.setKid("accountBank");
		 accountk.setKname("account");
	
		 gspg gspg = new gspg();
		 gspg.setGdz("enterpriseAddress");
		 gspg.setGfzjg("certificateDept");
		 gspg.setGid(1);
		 gspg.setGname("enterpriseName");
		 gspg.setGrzfw("certificateScope");
		 gspg.setGtimestart(df.parse("08/20/2015"));
		 gspg.setGtimeto(df.parse("08/20/2015"));
		 
		 organizationz organizationz = new organizationz();
		 organizationz.setZaddress("address");
		 organizationz.setZbadw("certificateDept");
		 organizationz.setZcode("code");
		 organizationz.setZid("registerNumber");
		 organizationz.setZname("name");
		 organizationz.setZtimestart(df.parse("08/20/2015"));
		 organizationz.setZtimeto(df.parse("08/20/2015"));
		 organizationz.setZtype("type");
		 
		 taxs taxs = new taxs();
		 taxs.setSdjzclx("infoTax.registerType");
		 taxs.setSdz("infoTax.address");
		 taxs.setSfddbr("infoTax.legalPerson");
		 taxs.setSfzjg("infoTax.certificateDept");
		 taxs.setSfzrq(df.parse("08/20/2015"));
		 taxs.setSid("infoTax.number");
		 taxs.setSjyfw("infoTax.businessScope");
		 taxs.setSkjyw("infoTax.withholdings");
		 taxs.setSnsrname("infoTax.name");
		 taxs.setSpzsljg("infoTax.authorizeDept");
		 							
		 ylicensejj ylicensejj = new ylicensejj();
		 ylicensejj.setJjfazj("certificateDept");
		 ylicensejj.setJjfddbrxm("legalPersonName");
		 ylicensejj.setJjgslx("companyType");
		 ylicensejj.setJjid("registerNumber");
		 ylicensejj.setJjjyfw("scope");
		 ylicensejj.setJjname("name");
		 ylicensejj.setJjssb(Double.valueOf("actualPrincipal"));
		 ylicensejj.setJjtimefound(df.parse("08/20/2015"));
		 ylicensejj.setJjtimeset(df.parse("08/20/2015"));
		 ylicensejj.setJjtimestar(df.parse("08/20/2015"));
		 ylicensejj.setJjtimeto(df.parse("08/20/2015"));
		 ylicensejj.setJjzczb(Double.valueOf("registerPrincipal"));
		 ylicensejj.setJjzs("domicile");
				 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
