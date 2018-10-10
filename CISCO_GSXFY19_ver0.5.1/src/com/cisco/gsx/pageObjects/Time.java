package com.cisco.gsx.pageObjects;


	import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
	 
	public class Time {
	 
	  public static void main(String[] args) throws ParseException {
	 
		  String time1 = "9:50:00";
		  String time2 = "9:55:00";

		  SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		  Date date1 = format.parse(time1);
		  Date date2 = format.parse(time2);
		  long difference = date2.getTime() - date1.getTime(); 
		  System.out.println("difference"+difference/ (60 * 1000) % 60);
	 
	  
	}
	 

}
