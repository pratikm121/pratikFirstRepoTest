package com.pratik.common.utils.string;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

public class StringUtil {
	private static int ccount = 1;
	private static final String baseDigits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/*-~!@#";
	private static Logger log = Logger.getLogger(Logger.class);
	/**
	 * Null safe trim for a String
	 * 
	 * @param s to trim
	 * @return the trimmed String
	 */
	public static String trim(String s) {
		if (s == null) return "";
		return s.trim();
	}
	
	/** 
	 * Tests to see if the String is empty
     */
	public static boolean empty(String s) {
		return s == null || s.trim().length() == 0;
	}
	
	/**
	 * lower case String
	 */
	public static String toLower(String s) {
		if (s == null) return null;
		return s.toLowerCase();
	}
	/**
	 * upper case String
	 */
	public static String toUpper(String s) {
		if (s == null) return null;
		return s.toUpperCase();
	}

	/**
	 * left justify data
	 */
	public static String leftJustify(String field, int size) throws Exception {
		if (field.length() > size) {
			throw new Exception("field length too long [" + field + "], length [" + size + "]");
		}
		StringBuffer buf =  new StringBuffer(field);
		for (int i=field.length(); i<size; i++) {
			buf.append(" ");
		}
		return buf.toString();
	}
	/**
	 * create unique correlation id per context
	 */
	
	public synchronized static String createCorrelationId() {
		if (ccount > 99) {
			ccount = 1;
		}
		SimpleDateFormat sdate = new SimpleDateFormat("DDDHHmmssSSS");
		DecimalFormat df2  = new DecimalFormat("00");
		String val =  sdate.format(new Date())+ df2.format(ccount++);
		
		if (val.startsWith("0")) {
			val = "9" + val.substring(1);
		}
		return val;
	}
	public static String decimalToBase(int base, int decimalNumber) {   
        int mod = 0;
        String tempVal = decimalNumber == 0 ? "0" : "";   
        while (decimalNumber != 0) {   
            mod = decimalNumber % base;   
            tempVal = baseDigits.substring(mod, mod + 1) + tempVal;   
            decimalNumber = decimalNumber/base;   
        }
        return tempVal;   
    }   

	public static BigDecimal safeBigDecimal(String value) {
		BigDecimal bd = null;
		try{
			bd = new BigDecimal(value);
		} catch (java.lang.NumberFormatException nfe){
			bd = new BigDecimal(0);
		}		
		return bd;
	}
	
	public static String defaultEmpty(String value) {
		if (value == null) {
			value = "";
		}
		return value;
	}
	
	public static String defaultEmptyOrTrim(String value) {
		if (value == null) {
			value = "";
		} else {
			value = value.trim();
		}
		return value;
	}

	public static String serialize(Object obj) throws Exception {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
		} finally {
			try {
				oos.close();
			} catch (Exception ignore) {
			}
		}
		return bos.toString();
	}
	
	public static byte[] serializeToBytes(Object obj) throws Exception {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
		} finally {
			try {
				oos.close();
			} catch (Exception ignore) {
			}
		}
		return bos.toByteArray();
	}
	
	public static Object deserialize(String serializedString) throws Exception {
		Object obj = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new ByteArrayInputStream(serializedString.getBytes()));
			obj = ois.readObject();
		} finally {
			try {
				ois.close();
			} catch (Exception ignore) {
			}
		}
		return obj;
	}
	
	
	public static String getProperty(Map<String, String> map, String key, String defaultValue) {
		String result = null;
		String val = map.get(key);
		if (val == null || val.trim().equals("")) {
			result = defaultValue;
		} else {
			result = val;
		}
		if (log != null) {
			log.debug("init parm: "+key+"="+result);
		}
		return result;
	}

	public static int getIntProperty(Map<String, String> map, String key, int defaultValue) {
		int result = defaultValue;
		String val = map.get(key);
		if (val != null && ! val.trim().equals("")) {
			try {
				result = Integer.parseInt(val);
			} catch (Exception e) {
			}
		}
		if (log != null) {
			log.debug("init parm: "+key+"="+result);
		}
		return result;
	}
	
	public static String getNullAsEmpty(String param) {
		String result = "";
		if (!empty(param) && !"NULL".equalsIgnoreCase(param)) {
			result = param;
		}
		return result;
	}
}