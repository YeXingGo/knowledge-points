package com.ssm.BeanUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringFomateDate {
   public static String SimpleFomate(Date date){
	   String formatStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
	   return formatStr;
   }
   public static Date SimpleFomate(String ss) throws ParseException{
	   SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = sdf.parse(ss); 
		return date;
   }
}
