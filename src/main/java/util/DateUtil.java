package main.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private DateUtil() {}

	public static int compareDates(String date1, String date2) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d1 = dateFormat.parse(date1);
		
		Date d2 = dateFormat.parse(date2);
		
		return d1.compareTo(d2);
	}
}
