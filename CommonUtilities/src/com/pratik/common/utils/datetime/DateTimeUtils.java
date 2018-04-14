package com.pratik.common.utils.datetime;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeUtils {
	static String pattern1 = "yyyy-mm-dd HH24:mi:ss";
	
	public static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	
	public static java.sql.Timestamp getCurrentFormattedTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	
	public static String convertTimestampToString(Timestamp ts) {
		if (ts ==null) return null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern1);
		Date date = new Date(ts.getTime());
		return sdf.format(date);
	}
	
	public static Timestamp convertStringToTimestamp(String s) {
		Timestamp ts = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern1);
		java.util.Date date;
		try {
			date = sdf.parse(s);
			ts = new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}

}
