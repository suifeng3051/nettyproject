package heaven.bonree.service;

import heaven.bonree.DAO.MemcachedDAO;
import heaven.bonree.protobuf.tasks.PBMBTaskNavigateResult.PB_MBTaskNavigateResult;
import heaven.bonree.protobuf.tasks.PBMBTaskNetenvResult.PB_MBTaskNetenvResult;
import heaven.bonree.protobuf.tasks.PBMBTaskNetenvResult.PB_TaskDnsResult;
import heaven.bonree.protobuf.tasks.PBMBTaskNetenvResult.PB_TaskIcmpResult;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import util.DateUtil;
import util.KeysUtils;



/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-11
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: MBTaskResultBusiness.java
 * @Package com.bonree.business
 * Description:移动全元素测试结果业务类
 * Version: 1.0
 ******************************************************************************/
public class MemcachedService {
	//private final static Logger log = Logger.getLogger(Logger.class);
	
	/**注入DAO对象，查询数据库**/
	private MemcachedDAO dao=new MemcachedDAO();
	private MemcachedClientServiceImp service=new MemcachedClientServiceImp();

	/**
	 * 概述：获取移动全元素任务测试结果方法 
	 * @Title: buildMBTaskResult
	 * @param navTaskIdList
	 * @return PB_MBTaskResult
	 * @throws ParseException
	 * @user <a href=mailto:wanghd@bonree.com>王厚达</a>
	 */
	public Map<String, Object> queryBusinessData(String tableName,String roleId,String timeFormat) throws ParseException {
		//缓存数据
		memcacheData(tableName,roleId,timeFormat);
		//转换成keys
		String[] keys=KeysUtils.parseParamToKeys(tableName,roleId,timeFormat);
		//从缓存提取数据
		Map<String, Object> memcachedMap=service.getMulti(keys);
		return memcachedMap;
	}

	/**
	 * 概述：把查询的数据缓存到缓存
	 * @Title: memcacheData
	 * @param tableName
	 * @param roleId
	 * @param timeformat
	 * @throws ParseException 
	 * @user <a href=mailto:wanghd@bonree.com>王厚达</a>
	 */
	private void memcacheData(String tableName, String roleId, String timeformat) throws ParseException {
		//分解成keys
		String [] keys=KeysUtils.parseParamToKeys(tableName,roleId,timeformat);
		String [] noneExsitKeys=service.getNoneExistKeys(keys);
		for(String key:noneExsitKeys){
			//String sql=KeysUtils.parseKeyToSQL(key);
			String[] keyArray=key.split("&");
			String dateFormat=keyArray[2];
			String [] datePairs=dateFormat.split("~");
			Date beginDate=DateUtil.parse(DateUtil.YYYY_MM_DD_HH, datePairs[0]);
			Date endDate=DateUtil.parse(DateUtil.YYYY_MM_DD_HH, datePairs[1]);
			String sql="select * from t_mcc_stat_navigate where role_id = ? and MONITOR_TIME between ? and ? ";
			Object dbData=dao.queryBusinessData(sql,Long.valueOf(keyArray[1]),new java.sql.Timestamp(beginDate.getTime()),new java.sql.Timestamp(endDate.getTime()));
			service.add(key, dbData);
		}
		
	}
	
	
	public Iterable<? extends PB_MBTaskNetenvResult> getNetData(
			List<String> taskList) {
		//return resultDAO.queryNetData(taskList)
		List<PB_MBTaskNetenvResult> list = new ArrayList<PB_MBTaskNetenvResult>();
		PB_MBTaskNetenvResult.Builder envResult=PB_MBTaskNetenvResult.newBuilder();
		envResult.setCitycode(1);
		envResult.setClientNum(2);
		envResult.setDns("dns");
		envResult.setDnsResult(PB_TaskDnsResult.newBuilder().setASet("aset").setCname("cname").setDigErrorId(23));
		envResult.setIcmpResult(PB_TaskIcmpResult.newBuilder().setIcmpErrorId(34).setIcmpTimeMs(56).setServerip("serverip"));
		envResult.setStatMainId(12365);
		
		list.add(envResult.build());
		
		
		
		return list;
	}

	public Iterable<? extends PB_MBTaskNavigateResult> getNavData(
			List<String> taskList) {
		//return resultDAO.queryNavData(taskList)
		List<PB_MBTaskNavigateResult> list = new ArrayList<PB_MBTaskNavigateResult>();
		PB_MBTaskNavigateResult.Builder nav=PB_MBTaskNavigateResult.newBuilder();
		nav.setChart1URL("REDIRECT");
		nav.setDns("STEP2");
		nav.setStep3("STEP3");
		nav.setClientInfo1("info1");
		nav.setFileSize( "FILE_SIZE");
		nav.setFileDown( "FILE_DOWN");
		nav.setCpuRate("cpurate");
		list.add(nav.build());
		return list;
	}

	
	
}
