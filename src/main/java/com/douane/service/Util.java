package com.douane.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Util {
	
	public List<Date> getDatesBetweenUsingJava7(Date startDate, Date endDate) {
		List<Date> datesInRange = new ArrayList<>();
		Calendar calendar = new GregorianCalendar(); 
		
		calendar.setTime(startDate);

		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);

		while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
			Date result = calendar.getTime();
			datesInRange.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		return datesInRange;
	}
	

	public Date addDaysToDate(Date date, int dayAdd) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(dateFormat.format(date));

		// convert date to calendar
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		
		c.add(Calendar.DATE, dayAdd); // same with c.add(Calendar.DAY_OF_MONTH, 1);


		// convert calendar to date
		Date dateaddDays = c.getTime();
		System.out.println(dateFormat.format(dateaddDays));

		return dateaddDays;

	}
	
	
	public String  StringDateFormat(Date date )  {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String dateString = simpleDateFormat.format(date);
		
		return  dateString ; 
	}
	
	
	public List<String> listDateFormat (List<Date> dates) {
		List<String>dateString = new ArrayList<String>() ; 
		
		for (Date date : dates) {
			dateString.add(this.StringDateFormat(date)) ; 
			
		}
		
		return  dateString ; 
	}

}
