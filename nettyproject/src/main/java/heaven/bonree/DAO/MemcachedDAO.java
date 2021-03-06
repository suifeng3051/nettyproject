package heaven.bonree.DAO;
import heaven.bonree.domain.TMccStatAllelement;
import heaven.bonree.domain.TMccStatNavigate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.KeysUtils;
import util.MemcachedClientFactory;


import com.danga.MemCached.MemCachedClient;
/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-10
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: MBTaskResultDAO.java
 * @Package com.bonree.db.dao
 * Description:移动全元素测试结果接口DAO
 * Version: 1.0
 ******************************************************************************/
public class MemcachedDAO {
	//private final static Logger LOG = Logger.getLogger(Logger.class);
	MemCachedClient memcached= MemcachedClientFactory.getInstance(); 
	/**查询online**/
	private final static String ONLINE_TEST_SQL = "select ID,MONITOR_FUN,NET_MON from t_mcc_onlinetestnew t where id in ";
	/**查询网络环境数据SQL**/
	private final static String NET_SQL = "select STAT_MAIN_ID,C_CITYCODE,C_NETSERVICE_ID,C_DNS," +
			"C_LAST_IP,DIG_ERRORID,A_SET,CNAME_SET,QUERY_TIME,PING_ERRORID,PING_SERVERIP,PING_SET,PING_COUNT,DIG_SET,TRACERT_ERRORID,TRACERT_SERVERIP,TRACERT_COUNT,TRACERT_HOP_SET,MONITOR_TIME,TRACERT_TIME,CLIENT_NUM from t_mcc_stat_netenv where  STAT_MAIN_ID in ";	
	/**查询网页浏览数据SQL**/
	private final static String NAV_SQL = "select STAT_NAVIGATE_ID,STAT_MAIN_ID,ROLE_ID,USERNAME,"
			+ "ERRORID,REDIRECT,STEP1,STEP2,STEP3,STEP4,STEP5,STEP6,STEP7,STEP8,STEP9,round(STEP10, 3) as STEP10,round(STEP11, 3) as STEP11,"
			+ "round(STEP12, 2) as STEP12,FILE_SIZE,FILE_DOWN,to_char(MONITOR_TIME,'yyyy-mm-dd hh24:mi:ss') as MONITOR_TIME,"
			+ "round(BYTES_RECEIVED / 1024, 3) as BYTES_RECEIVED,DNS_LOOK_UPS,ROUND_TRIPS,"
			+ "TCP_CONNECTS,D_TIME,ROLE_IP,FIRST_TIME,ROLE_CITYCODE,ROLE_NETSERVICE,C_CITYCODE,"
			+ "C_CITY,C_DISTRICT,C_NETSERVICE_ID,C_NETSERVICE_NAME,C_DNS,C_NETSPEED,C_CLIENT_TYPE,"
			+ "C_LAST_IP,MIME_TYPE,HEADER,CPU_RATE,MEM_RATE,CYCLE_SPEED,ERRELE_FLAG,round(STEP13, 3) as STEP13,PROCESS_NUM,"
			+ "A1,A2,A3,A4,A5,A6,T1,T2,T3,T4,T5,T6,CLIENT_NUM,T_BLOCK_TIME,DOC_COMPLETE,IE_VERSION,"
			+ "OS_VERSION,PAGE_LOADED_S,REQ_HEADER,DOM_LOADED_S,MONITOR_TIME_CODE,CLIENT_NUM from t_mcc_stat_navigate where STAT_MAIN_ID in ";
	

	public List<TMccStatNavigate> queryBusinessData(String sql,long roleId,java.sql.Timestamp begin,java.sql.Timestamp end ){
		List<TMccStatNavigate> tMccStatNavigates = new ArrayList<TMccStatNavigate>();
		Connection conn = null ;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection(false);
			ps = conn.prepareStatement(sql);	
			ps.setLong(1, roleId);
			ps.setTimestamp(2, begin);
			ps.setTimestamp(3, end);
			rs = ps.executeQuery();
			int keyIndex=0;
			while(rs.next()){
				TMccStatNavigate navigate = new TMccStatNavigate();
				navigate.setMid(rs.getLong("STAT_MAIN_ID"));//设置任务id
				navigate.setDocComplete(rs.getLong("DOC_COMPLETE"));//文档下载完成时间
				navigate.setCity(rs.getInt("C_CITYCODE"));//设置监测点城市
				navigate.setNetServiceId(rs.getInt("C_NETSERVICE_ID"));//设置监测点运营商
				navigate.setMonitorTime(rs.getString("MONITOR_TIME"));//监测时间
				navigate.setIp(rs.getString("C_LAST_IP"));//监测点		
				navigate.setDns(rs.getString("C_DNS"));//经纬度
				navigate.setType(rs.getInt("C_CLIENT_TYPE"));//监测点类型
				navigate.setNetSpeed(rs.getDouble("C_NETSPEED"));//监测点带宽
				navigate.setCpuRate(rs.getInt("CPU_RATE"));//手机制式
				navigate.setProcnum(rs.getInt("PROCESS_NUM"));//信号强度
				navigate.setErrorid(rs.getInt("ERRORID"));//错误id
				navigate.setClientNum(rs.getLong("CLIENT_NUM"));//客户端id
				navigate.setStep2(rs.getDouble("STEP2"));//dns查询时间		
				navigate.setStep3(rs.getDouble("STEP3"));//TCP连接时间
				navigate.setStep4(rs.getDouble("STEP4"));//request请求时间			
				navigate.setStep5(rs.getDouble("STEP5"));//response服务器响应时间
				navigate.setStep6(rs.getDouble("STEP6"));//重定向时间
				navigate.setStep7(rs.getDouble("STEP7"));//基础文档下载时间
				navigate.setStep8(rs.getDouble("STEP8"));//渲染时间
				navigate.setStep13(rs.getDouble("STEP13"));//基础文档SSL握手用时
				navigate.setDtime(rs.getDouble("D_TIME"));//整体用时
				navigate.setFirstTime(rs.getDouble("FIRST_TIME"));//首屏时间
				navigate.setStep9(rs.getDouble("STEP9"));//首包时间
				navigate.setDomLoadeds(rs.getDouble("DOM_LOADED_S"));
				navigate.setPageLoadeds(rs.getDouble("PAGE_LOADED_S"));//页面加载完成时间
				navigate.setDownSpeed(rs.getDouble("STEP12"));//页面整体速度
				navigate.setRoundTrips(rs.getInt("ROUND_TRIPS"));//网络roundtrips
				navigate.setStep10(rs.getDouble("STEP10"));//基础文档速度
				navigate.setDnsLookUps(rs.getInt("DNS_LOOK_UPS"));//DNS查询总次数
				navigate.setStep11(rs.getLong("STEP11"));//渲染速度
				navigate.setTcpConnects(rs.getInt("TCP_CONNECTS"));//TCP建立链接总次数
				navigate.setBytesReceived(rs.getDouble("BYTES_RECEIVED"));//下载总字节数
				navigate.setFileDown(rs.getDouble("FILE_DOWN"));//基础文档下载字节数
				navigate.setFileSize(rs.getDouble("FILE_SIZE"));//基础文档实际大小	
				navigate.setHeader(rs.getString("HEADER"));//Header信息
				navigate.setReqHeader(rs.getString("REQ_HEADER"));//REQ_HEADER
				tMccStatNavigates.add(navigate);
				if(tMccStatNavigates.size()==1000){
					memcached.set("navsql2"+keyIndex++, tMccStatNavigates);
					tMccStatNavigates=new ArrayList<TMccStatNavigate>();		
				}
				
			}			
		}catch (Exception e) {
			e.printStackTrace();	
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}	
		return tMccStatNavigates;	
	}
	private KeysUtils getKeysUtils(String[] keys) {
		KeysUtils keysUtils=new KeysUtils();
		StringBuilder existBuilder=new StringBuilder();
		StringBuilder noneExistBuilder=new StringBuilder();
		for(String key:keys){
			if(memcached.keyExists(key)){
				existBuilder.append(key).append("");
			}else{
				noneExistBuilder.append(key).append("");
			}
		}
		keysUtils.setExistKeyArray(existBuilder.toString().split(""));
		keysUtils.setNoneExistKeyArray(noneExistBuilder.toString().split(""));
		return keysUtils;
	}
	/** 
	* @Title: queryMBTaskNavigateResult 
	* @Description: 查询网络浏览结果 
	* @param taskId  
	* @return List<TMccStatNavigate>  
	* @author wanghouda  
	* @date 2014-4-9 上午09:46:36 
	* @version V1.0
	*/
	public List<TMccStatNavigate> queryMBTaskNavigateResult(String navsql,String userId) {
		long beginTime=System.currentTimeMillis();	
		List<TMccStatNavigate> tMccStatNavigates = new ArrayList<TMccStatNavigate>();
		Connection conn = null ;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection(false);
			ps = conn.prepareStatement(navsql);			
			rs = ps.executeQuery();
			long queryTime=System.currentTimeMillis();
			System.out.println("数据库查询时间（秒）："+(queryTime-beginTime)/1000);
			int itemCount=0;
			int size=0;
			int keyIndex=0;
			while(rs.next()){
				TMccStatNavigate navigate = new TMccStatNavigate();
				navigate.setMid(rs.getLong("STAT_MAIN_ID"));//设置任务id
				navigate.setDocComplete(rs.getLong("DOC_COMPLETE"));//文档下载完成时间
				navigate.setCity(rs.getInt("C_CITYCODE"));//设置监测点城市
				navigate.setNetServiceId(rs.getInt("C_NETSERVICE_ID"));//设置监测点运营商
				navigate.setMonitorTime(rs.getString("MONITOR_TIME"));//监测时间
				navigate.setIp(rs.getString("C_LAST_IP"));//监测点		
				navigate.setDns(rs.getString("C_DNS"));//经纬度
				navigate.setType(rs.getInt("C_CLIENT_TYPE"));//监测点类型
				navigate.setNetSpeed(rs.getDouble("C_NETSPEED"));//监测点带宽
				navigate.setCpuRate(rs.getInt("CPU_RATE"));//手机制式
				navigate.setProcnum(rs.getInt("PROCESS_NUM"));//信号强度
				navigate.setErrorid(rs.getInt("ERRORID"));//错误id
				navigate.setClientNum(rs.getLong("CLIENT_NUM"));//客户端id
				navigate.setStep2(rs.getDouble("STEP2"));//dns查询时间		
				navigate.setStep3(rs.getDouble("STEP3"));//TCP连接时间
				navigate.setStep4(rs.getDouble("STEP4"));//request请求时间			
				navigate.setStep5(rs.getDouble("STEP5"));//response服务器响应时间
				navigate.setStep6(rs.getDouble("STEP6"));//重定向时间
				navigate.setStep7(rs.getDouble("STEP7"));//基础文档下载时间
				navigate.setStep8(rs.getDouble("STEP8"));//渲染时间
				navigate.setStep13(rs.getDouble("STEP13"));//基础文档SSL握手用时
				navigate.setDtime(rs.getDouble("D_TIME"));//整体用时
				navigate.setFirstTime(rs.getDouble("FIRST_TIME"));//首屏时间
				navigate.setStep9(rs.getDouble("STEP9"));//首包时间
				navigate.setDomLoadeds(rs.getDouble("DOM_LOADED_S"));
				navigate.setPageLoadeds(rs.getDouble("PAGE_LOADED_S"));//页面加载完成时间
				navigate.setDownSpeed(rs.getDouble("STEP12"));//页面整体速度
				navigate.setRoundTrips(rs.getInt("ROUND_TRIPS"));//网络roundtrips
				navigate.setStep10(rs.getDouble("STEP10"));//基础文档速度
				navigate.setDnsLookUps(rs.getInt("DNS_LOOK_UPS"));//DNS查询总次数
				navigate.setStep11(rs.getLong("STEP11"));//渲染速度
				navigate.setTcpConnects(rs.getInt("TCP_CONNECTS"));//TCP建立链接总次数
				navigate.setBytesReceived(rs.getDouble("BYTES_RECEIVED"));//下载总字节数
				navigate.setFileDown(rs.getDouble("FILE_DOWN"));//基础文档下载字节数
				navigate.setFileSize(rs.getDouble("FILE_SIZE"));//基础文档实际大小	
				navigate.setHeader(rs.getString("HEADER"));//Header信息
				navigate.setReqHeader(rs.getString("REQ_HEADER"));//REQ_HEADER
				tMccStatNavigates.add(navigate);
				size++;
				if(size==1000){
					memcached.set("navsql2"+keyIndex++, tMccStatNavigates);
					tMccStatNavigates=new ArrayList<TMccStatNavigate>();
					size=0;
				}
				itemCount++;
			}
			long otherTime=System.currentTimeMillis();
			System.out.println("其它处理时间(毫秒):"+(otherTime-queryTime));
			System.out.println("总数量："+itemCount);	
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		return tMccStatNavigates;
	}

	/** 
	* @Title: queryMBTaskNavigateResult 
	* @Description: 查询网络浏览结果 
	* @param taskId  
	* @return List<TMccStatNavigate>  
	* @author wanghouda  
	* @date 2014-4-9 上午09:46:36 
	* @version V1.0
	*/
	public List<TMccStatAllelement> queryAllelement(String sql,int itemSize,int totalItems) {
		long beginTime=System.currentTimeMillis();	
		List<TMccStatAllelement> tMccStatAllelements = new ArrayList<TMccStatAllelement>();
		Connection conn = null ;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, totalItems);
			rs = ps.executeQuery();
			long queryTime=System.currentTimeMillis();
			System.out.println("数据库查询时间（秒）："+(queryTime-beginTime)/1000);
			int size=0;
			int keyIndex=0;
			int itemCount=0;
			while(rs.next()){
				TMccStatAllelement element = new TMccStatAllelement();
				element.setAllelementId(rs.getLong("ALLELEMENT_ID"));
				element.setB1(rs.getDouble("B1"));
				element.setB2(rs.getDouble("B2"));
				element.setB3(rs.getDouble("B3"));
				element.setB4(rs.getDouble("B4"));
				element.setB5(rs.getDouble("B5"));
				element.setB6(rs.getDouble("B6"));
				element.setB7(rs.getDouble("B7"));
				element.setcCity(rs.getString("C_CITY"));
				element.setcCitycode(rs.getInt("C_CITYCODE"));
				element.setcClientType(rs.getDouble("C_CLIENT_TYPE"));
				element.setcDistrict(rs.getString("C_DISTRICT"));
				element.setcDNS(rs.getString("C_DNS"));
				element.setcLastIp(rs.getString("C_LAST_IP"));
				element.setcNetserviceId(rs.getInt("C_NETSERVICE_ID"));
				element.setcNetserviceName(rs.getString("C_NETSERVICE_NAME"));
				element.setcNetspeed(rs.getDouble("C_NETSPEED"));
				element.setD8(rs.getDouble("B8"));
				element.setDownSize(rs.getDouble("DOWN_SIZE"));
				element.setFirstFlag(rs.getInt("FIRST_FLAG"));
				element.setHeader(rs.getString("HEADER"));
				element.setMimeType(rs.getString("MIME_TYPE"));
				element.setMonitorTime(rs.getDate("MONITOR_TIME"));
				element.setMonitorTimeCode(rs.getInt("MONITOR_TIME_CODE"));
				element.setReqMethod(rs.getString("REQ_METHOD"));
				element.setRoleId(rs.getInt("ROLE_ID"));
				element.setRoleIp(rs.getString("ROLE_IP"));
				element.setStatmainId(rs.getLong("STAT_MAIN_ID"));
				element.setStatusCode(rs.getInt("STATUS_CODE"));
				element.setStime(rs.getLong("S_TIME"));
				element.setTcpNum(rs.getInt("TCPNUM"));
				element.setUrl(rs.getString("URL"));
				element.setUrlCode(rs.getLong("URL_CODE"));
				element.setUserName(rs.getString("USERNAME"));
				
				tMccStatAllelements.add(element);
				size++;
				if(size==itemSize){
					boolean flag=memcached.set("key"+keyIndex++, tMccStatAllelements);
					System.out.println("缓存key"+keyIndex+":"+flag);
					tMccStatAllelements=new ArrayList<TMccStatAllelement>();
					size=0;
					
				} 
				itemCount++;
			}
			if(size>0&&size<itemSize){
				boolean flag=memcached.set("key"+keyIndex++, tMccStatAllelements);
				System.out.println("缓存key"+keyIndex+":"+flag);
			}
			System.out.println("itemCount:"+itemCount+";keyCount:"+keyIndex);
			
			/*for(int i=0;i<500;i++){
				long begin=System.currentTimeMillis();
				boolean flag=memcached.set("key"+i++, tMccStatAllelements);
				System.out.println("结果："+flag+";时间："+(System.currentTimeMillis()-begin));
				
			}*/
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		
		return tMccStatAllelements;
	}
	public List<TMccStatAllelement> queryValues(int size) {
		List<TMccStatAllelement> list=new ArrayList<TMccStatAllelement>();
		String [] keys=new String[size];
		int n=0;
		int m=0;
		for(int i=0;i<size;i++){
			keys[i]="key"+i;
			boolean flag=memcached.keyExists(keys[i]);
			
			if(!flag){
				n++;
			}else{
				m++;
			}
		}
		System.out.println("m="+m+";n="+n);
		/*Map<String, Object> values=memcached.getMulti(keys);
		Set<Entry<String, Object>> entry=values.entrySet();
		Iterator<Entry<String, Object>> it= entry.iterator();
		while(it.hasNext()){
			Entry<String, Object> en=it.next();
			System.out.println(en.getKey());
			//list.addAll((List<TMccStatAllelement>)en.getValue());
		}*/
		return list;
	}
	public boolean deleteKey(int size){
		for(int i=0;i<size;i++){
			System.out.println(memcached.delete("key"+i));
		}
		return true;
	}

	public static void main(String[] args) {
		MemcachedDAO dao=new MemcachedDAO();
		System.out.println(dao.memcached.get("key179"));;
	}
}
