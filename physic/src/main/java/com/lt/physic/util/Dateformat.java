package com.lt.physic.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateformat {
	public String dateformat(Date date){
		String s = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
	        s = simpleDateFormat.format(date);
	    } catch (Exception e) {
	 
	    }
		return s;
	}
}
