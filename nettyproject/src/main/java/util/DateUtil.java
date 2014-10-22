package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
    public static final int SECOND=1000;
    public static final int MINTER=60*SECOND;
    public static final int HOUR=60*MINTER;
    public static final int DAY=24*HOUR;
	public static final Map<String, SimpleDateFormat> sdfMap = new HashMap<String, SimpleDateFormat>();
    public static final String YYYY_MM_DD_HH_MM_SS="yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM ="yyyy-MM-dd HH:mm:00";
    public static final String YYYY_MM_DD="yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH="yyyy-MM-dd HH";
    public static final String MM_DD_HH_MM="MM-dd HH:mm";
    public static final String YYMMDDHHMMSS = "yyMMddHHmm";
    public static final String YYYY$ = "yyyy年";
    public static final String YYYYMM$ = "yyyy年MM月";
    public static final String YYYYMMDD$ = "yyyy年MM月dd日";
    public static final String YYYYMMDDHH$ = "yyyy年MM月dd日 HH时";
    public static final String YYYYMMDDHHMM$ = "yyyy年MM月dd日 HH时mm分";
    public static final String YYYYWW$ = "yyyy年 ww周";
    public static final String TIMECODE = "yyyyMMddHHmm";
    public static final String WEEKCODE = "yyyyww";
    public static final String YYYYMMDD_HH="yyyyMMdd/HH";
	static {
		sdfMap.put(YYYY_MM_DD_HH_MM_SS, new SimpleDateFormat(
				YYYY_MM_DD_HH_MM_SS));
		sdfMap.put(YYYY_MM_DD, new SimpleDateFormat(
				YYYY_MM_DD));
		sdfMap.put(YYYY_MM_DD_HH_MM, new SimpleDateFormat(
				YYYY_MM_DD_HH_MM));
		sdfMap.put(MM_DD_HH_MM, new SimpleDateFormat(
				MM_DD_HH_MM));
		sdfMap.put(YYYY_MM_DD_HH, new SimpleDateFormat(
				YYYY_MM_DD_HH));
		sdfMap.put(YYMMDDHHMMSS, new SimpleDateFormat(
				YYMMDDHHMMSS));
		sdfMap.put(YYYY$, new SimpleDateFormat(
				YYYY$));
		sdfMap.put(YYYYMM$, new SimpleDateFormat(
				YYYYMM$));
		sdfMap.put(YYYYMMDD$, new SimpleDateFormat(
				YYYYMMDD$));
		sdfMap.put(YYYYMMDDHH$, new SimpleDateFormat(
				YYYYMMDDHH$));
		sdfMap.put(YYYYMMDDHHMM$, new SimpleDateFormat(
				YYYYMMDDHHMM$));
		sdfMap.put(YYYYWW$, new SimpleDateFormat(
				YYYYWW$));
		sdfMap.put(TIMECODE, new SimpleDateFormat(
				TIMECODE));
		sdfMap.put(WEEKCODE, new SimpleDateFormat(
				WEEKCODE));
		sdfMap.put(YYYYMMDD_HH, new SimpleDateFormat(
				YYYYMMDD_HH));
	}
	public static String format(Date source) {
		return sdfMap.get(YYYY_MM_DD_HH_MM_SS).format(source);
	}	

	public static Date parse(String source) throws ParseException {
		return sdfMap.get(YYYY_MM_DD_HH_MM_SS).parse(source);
	}
	/**
	 * 概述：获取日期中的小时
	 * @Title: getHour 
	 * @param d 日期
	 * @return
	 * int 小时
	 * @user <a href=mailto:luojun@bonree.com>罗俊</a>
	 */
	public static int getHour(Date d){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	
	/**
	 * 日期加减
	 * @param d 日期
	 * @param df 加减的天数
	 * @return
	 * @author jun
	 */
	public static Date dateDiff(Date d,int df){
		if(d == null) return new Date();
		long temp = 24*60*60*1000;
		return new Date(d.getTime() - df*temp);
	}
	
	public static int dayDiff(Date begin,Date end){
		return hourDiff(begin,end)/24;
	}
	
	public static int hourDiff(Date begin,Date end){
		long beingTime=begin.getTime();
		long endTime=end.getTime();
		int diff=(int) ((endTime-beingTime)/(1000*60*60));
		return diff;
	}
	
	/**
	 * 日期加减
	 * @param d 日期
	 * @param dfmi 加减的分钟数
	 * @return
	 * @author jun
	 */
	public static Date dateDiffMI(Date d,double dfmi){
		if(d == null) return new Date();
		GregorianCalendar gc = new GregorianCalendar() ; 
		gc.setTime(d  ) ; 
		gc.add(GregorianCalendar.MINUTE, (int)-dfmi) ; 
		return gc.getTime() ; 
	}
	
	/**
	 * 日期加减
	 * @param d 日期
	 * @param dfmi 加减的分钟数
	 * @return
	 */
	public static Date DateDiffMI(Date d,long dfmi){
		if(d == null) return new Date();
		GregorianCalendar gc = new GregorianCalendar() ; 
		gc.setTime(d  ) ; 
		gc.add(GregorianCalendar.MINUTE, (int)-dfmi) ; 
		return gc.getTime() ; 
	}

	/**
	 * 概述：格式化日期
	 * @Title: format
	 * @param partten 日期格式
	 * @param source 日期
	 * @return
	 * String
	 * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
	 */
	public static String format(String partten, Date source) {
		SimpleDateFormat formatter = sdfMap.get(partten);
        if(formatter == null){
        	formatter = new SimpleDateFormat(partten);
        } 
		return formatter.format(source);
	}
	
	/**
	 * 概述：格式化字符串日期
	 * @Title: parse
	 * @param partten 字符串日期格式
	 * @param source 字符串日期
	 * @return
	 * @throws ParseException
	 * Date
	 * @user <a href=mailto:zhangnl@bonree.com>张念礼</a>
	 */
	public static Date parse(String partten,String source) throws ParseException {
		SimpleDateFormat formatter = sdfMap.get(partten);
        if(formatter == null){
        	formatter = new SimpleDateFormat(partten);
        } 
		return formatter.parse(source);
	}
	
	/**
	 * 获取当前日期的字符串格式
	 * @author ZNL
	 * @date Jul 23, 2013 1:24:23 PM
	 * @param formats 字符串格式
	 * @return 字符串日期
	 */
    public static String getCurrentTime(String formats){  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = sdfMap.get(formats);
        if(formatter == null){
        	formatter = new SimpleDateFormat(formats);
        }   
        return formatter.format(currentTime);  
    }  
    
    /**
     * 日期比较
     * @author ZNL
     * @date Jul 23, 2013 1:20:44 PM
     * @param t1 日期1
     * @param t2 日期2
     * @param pattern 日期的字符串格式
     * @return t1 > t2: 正数 ,t1 < t2: 负数 ,t1 = t2: 0
     */
    public static int timeCompare(String t1,String t2,String pattern){  
    	SimpleDateFormat formatter = sdfMap.get(pattern);
		if(formatter == null){
			formatter = new SimpleDateFormat(pattern);
		}   
        Calendar c1=Calendar.getInstance();  
        Calendar c2=Calendar.getInstance();  
        try {  
            c1.setTime(formatter.parse(t1));  
            c2.setTime(formatter.parse(t2));  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        int result=c1.compareTo(c2);  
        return result;  
    }  
    
	
    /**
     * 计算两个日期之间的间隔
     * 
     * @author ZNL
     * @date Jul 24, 2013 3:41:33 PM
     * @param startTime 开始时间
     * @param endTime 结束时间
	 * @param pattern 格式化时间字符串格式
     * @return 时间间隔(分钟粒度)
     */
    public static int getDateInterval(String startTime,String endTime, String pattern){
		int result = 0;
		try {
			SimpleDateFormat formart = sdfMap.get(pattern);
			if(formart == null){
				formart = new SimpleDateFormat(pattern);
			} 
			Date date1 = formart.parse( endTime );
			Date date2 = formart.parse( startTime );
			long temp = Math.abs(date1.getTime() - date2.getTime());
			result = (int)(temp / 1000 / 60 );
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return result;
	}
    
    
    
    
    public static Date addHour(Date date,int hour){
        return operateDate(date, Calendar.HOUR_OF_DAY, hour);
    }
    
    public static Date operateDate(Date currentDate,int field,int amount){
        Calendar calendar = Calendar.getInstance();;
        calendar.setTime(currentDate);
        calendar.add(field, amount);
        return calendar.getTime();
    }
}
