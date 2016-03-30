package com.cjw.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	final static String pattern1 = "yyyy-MM-dd HH:mm:ss";
	
	final static String pattern2 = "yyyy-MM-dd";
	
	public static String toDateTimeStr(Date date){
		return DateFormatUtils.format(date,pattern1);
	}
	public static String toDateTimeStr(Date date,String pattern){
		return DateFormatUtils.format(date,pattern);
	}
	/**
	 * 
	 * @param strDate
	 * @param pattern 如:yyyy-MM-dd HH24:mi:ss
	 * @return
	 * @throws ParseException
	 */
    public static Date parse(String strDate, String pattern) throws ParseException {  
        return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(pattern).parse(strDate);  
    }
    
    
    /**
     * 
     * @param strDate
     * use default pattern1: yyyy-MM-dd HH24:mi:ss
     * @return
     * @throws ParseException
     */
    public static Date parse(String strDate) throws ParseException {  
        return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(pattern1).parse(strDate);  
    }
    
    /**
     * 
     * @param strDate
     * use default pattern1: yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date parseSimple(String strDate) throws ParseException {  
        return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(pattern2).parse(strDate);  
    }
    
    
    public static Date getNow(){
    	return new Date();
    }
    /*
     * 将Date格式转换为XMLGregorianCalendar格式
     */
    public static XMLGregorianCalendar dateToGregorian(Date date) {
		DatatypeFactory dataTypeFactory;
		try {
			dataTypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(date.getTime());
		return dataTypeFactory.newXMLGregorianCalendar(gc);
	}
    /*
     * 将XMLGregorianCalendar格式转换为Date格式
     */
    public static Date gregorianToDate(XMLGregorianCalendar gc) throws Exception{
    	GregorianCalendar ca = gc.toGregorianCalendar();  
        return ca.getTime();  
    	   	
    }
    /*
     * 获取年份
     */
    public static int getYear(){
    	Calendar a=Calendar.getInstance();
		return a.get(Calendar.YEAR);
    	
    }
    
	/**
	 * 时间整小时移动
	 * 
	 * @param date
	 * @param delayHour
	 * @return
	 */
	public static Date getDateDelayHour(Date date, long delayHour) {
		if (date == null) {
			date = new Date();
		}
		long time = date.getTime() + 1000 * 60 * 60 * delayHour;
		return new Date(time);
	}
	
	 /**
	 * 比较两个日期的大小
	 * 
	 * @param date1
	 * @param date2
	 * @return date1小于date2 返回-1，date1大于date2返回1，相等返回0
	 */
	public static int compareDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		// different date might have different offset
		cal1.setTime(date1);
		long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET)
				+ cal1.get(Calendar.DST_OFFSET);

		cal2.setTime(date2);
		long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET)
				+ cal2.get(Calendar.DST_OFFSET);

		long dateDiff = ldate1 - ldate2;
		return dateDiff > 0 ? 1 : (dateDiff == 0 ? 0 : -1);
	}
	
	/**
     * 返回今天的剩余时间（秒数）
     * @return
     */
    public  static int getTodayTime(){
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(calendar.SECOND, 0);
        return (int) ((calendar.getTimeInMillis() - now.getTime())/1000);
    }
	/**
	 * 把日期格式化成一字符串
	 * 
	 * @param date
	 * @param fmt
	 * @return
	 */
	public static String getDateStr(Date date, String fmt) {
		String retValue = "";
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		try {
			retValue = sdf.format(date);
		} catch (Exception ex) {
			System.out.println("format date error" + ex.getMessage());
		}
		return retValue;
	}
}
