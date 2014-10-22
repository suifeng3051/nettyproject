package util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.impl.cookie.DateUtils;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-16
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: KeysUtils.java
 * @Package test.memcache.domain
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class KeysUtils {
	public String[] existKeyArray;
	public String[] noneExistKeyArray;
	
	public static String[] parseSQLToKeys(String sql){
		
		return null;
	}
	public static ArrayList<String> parseKeysToSQL(String[] keys) throws ParseException{
		ArrayList<String> sqlArrayList=new ArrayList<String>();
		for(String key:keys){
			String[] keyArray=key.split("&");
			String dateFormat=keyArray[2];
			String [] datePairs=dateFormat.split("~");
			Date beginDate=DateUtil.parse(DateUtil.YYYY_MM_DD_HH, datePairs[0]);
			Date endDate=DateUtil.parse(DateUtil.YYYY_MM_DD_HH, datePairs[1]);
			String sql="select * from "+keyArray[0]+" where role_id = " +keyArray[1]+" and monitor_date between "+beginDate+" and "+endDate+";";
			sqlArrayList.add(sql);
		}
		
		return sqlArrayList;
	}
	public static String parseKeyToSQL(String key) throws ParseException{
	
			String[] keyArray=key.split("&");
			String dateFormat=keyArray[2];
			String [] datePairs=dateFormat.split("~");
			Date beginDate=DateUtil.parse(DateUtil.YYYY_MM_DD_HH, datePairs[0]);
			Date endDate=DateUtil.parse(DateUtil.YYYY_MM_DD_HH, datePairs[1]);
			//String sql="select * from "+keyArray[0]+" where role_id = " +keyArray[1]+" and MONITOR_TIME between "+beginDate+" and "+endDate+";";
			String sql="select * from "+keyArray[0]+" where role_id = " +keyArray[1]+";";

		return sql;
	}
	public String[] getExistKeyArray() {
		return existKeyArray;
	}
	public void setExistKeyArray(String[] existKeyArray) {
		this.existKeyArray = existKeyArray;
	}
	public String[] getNoneExistKeyArray() {
		return noneExistKeyArray;
	}
	public void setNoneExistKeyArray(String[] noneExistKeyArray) {
		this.noneExistKeyArray = noneExistKeyArray;
	}
	public static List<String> parseTimeToKeys(String timeStamp) {
		// TODO Auto-generated method stub
		return null;
	}
	public static String[] parseParamToKeys(String tableName, String roleId,
			String timeFormat) throws ParseException {
		String[] timeStamp=timeFormat.split("~");
		Date beginDate=DateUtil.parse(DateUtil.YYYY_MM_DD_HH, timeStamp[0]);
		Date endDate=DateUtil.parse(DateUtil.YYYY_MM_DD_HH, timeStamp[1]);
		int hours=DateUtil.hourDiff(beginDate, endDate);
		String [] key=new String[hours];
		for(int i=0;i<hours;i++){
			key[i]=tableName+"&"+roleId+"&"+DateUtil.format(DateUtil.YYYY_MM_DD_HH, DateUtil.addHour(beginDate, i))+"~"+DateUtil.format(DateUtil.YYYY_MM_DD_HH, DateUtil.addHour(beginDate, i+1));
		}
		return key;
	}
	

}

