package com.gms.commons;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gms.servlet.AdminLogin;
import com.monitorjbl.xlsx.exceptions.ParseException;

public class Common {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Common.class.getName());
	public static String StringToDate(String holidayDate) throws ParseException, java.text.ParseException {
	      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = formatter.parse(holidayDate);
	      String finalDate=(new SimpleDateFormat("dd-MM-yyyy").format(date));
	      return finalDate;
	   }
	public static String StringToDateFormat(String holidayDate) throws ParseException, java.text.ParseException {
		System.out.println(holidayDate);
	      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	      Date date = formatter.parse(holidayDate);
	      String finalDate=(new SimpleDateFormat("yyyy-MM-dd").format(date));
	      return finalDate;
	   }

	public static void LogError(Exception e)
	{
		String error_message = "*************" + e.getClass() + "*************\n";
		error_message += e.getMessage();
		error_message += e.getCause();
		StackTraceElement[] trace = e.getStackTrace();
	    for (StackTraceElement traceElement : trace)
	        error_message += "\tat " + traceElement + "\n";
		logger.info(error_message);
		
	}
}
