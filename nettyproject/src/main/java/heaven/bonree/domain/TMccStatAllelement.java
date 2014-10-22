package heaven.bonree.domain;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-22
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: TMccStatAllelement.java
 * @Package test.memcache.domain
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class TMccStatAllelement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long allelementId;
	private long statmainId;
	private int roleId;
	private String userName;
	private String roleIp;
	private double downSize;
	private String mimeType;
	private int statusCode;
	private String url;
	private String header;
	private long stime;
	private double b1;
	private double b2;
	private double b3;
	private double b4;
	private double b5;
	private double b6;
	private double b7;
	private Date monitorTime;
	private int cCitycode;
	private String cCity;
	private String cDistrict;
	private int cNetserviceId;
	private String cNetserviceName;
	private String cDNS;
	private double cNetspeed;
	private double cClientType;
	private String cLastIp;
	private double d8;
	private int tcpNum;
	private long urlCode;
	private int firstFlag;
	private int monitorTimeCode;
	private String reqMethod;
	public long getAllelementId() {
		return allelementId;
	}
	public void setAllelementId(long allelementId) {
		this.allelementId = allelementId;
	}
	public long getStatmainId() {
		return statmainId;
	}
	public void setStatmainId(long statmainId) {
		this.statmainId = statmainId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleIp() {
		return roleIp;
	}
	public void setRoleIp(String roleIp) {
		this.roleIp = roleIp;
	}
	public double getDownSize() {
		return downSize;
	}
	public void setDownSize(double downSize) {
		this.downSize = downSize;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public long getStime() {
		return stime;
	}
	public void setStime(long stime) {
		this.stime = stime;
	}
	public double getB1() {
		return b1;
	}
	public void setB1(double b1) {
		this.b1 = b1;
	}
	public double getB2() {
		return b2;
	}
	public void setB2(double b2) {
		this.b2 = b2;
	}
	public double getB3() {
		return b3;
	}
	public void setB3(double b3) {
		this.b3 = b3;
	}
	public double getB4() {
		return b4;
	}
	public void setB4(double b4) {
		this.b4 = b4;
	}
	public double getB5() {
		return b5;
	}
	public void setB5(double b5) {
		this.b5 = b5;
	}
	public double getB6() {
		return b6;
	}
	public void setB6(double b6) {
		this.b6 = b6;
	}
	public double getB7() {
		return b7;
	}
	public void setB7(double b7) {
		this.b7 = b7;
	}
	public Date getMonitorTime() {
		return monitorTime;
	}
	public void setMonitorTime(Date monitorTime) {
		this.monitorTime = monitorTime;
	}
	public int getcCitycode() {
		return cCitycode;
	}
	public void setcCitycode(int cCitycode) {
		this.cCitycode = cCitycode;
	}
	public String getcCity() {
		return cCity;
	}
	public void setcCity(String cCity) {
		this.cCity = cCity;
	}
	public String getcDistrict() {
		return cDistrict;
	}
	public void setcDistrict(String cDistrict) {
		this.cDistrict = cDistrict;
	}
	public int getcNetserviceId() {
		return cNetserviceId;
	}
	public void setcNetserviceId(int cNetserviceId) {
		this.cNetserviceId = cNetserviceId;
	}
	public String getcNetserviceName() {
		return cNetserviceName;
	}
	public void setcNetserviceName(String cNetserviceName) {
		this.cNetserviceName = cNetserviceName;
	}
	public String getcDNS() {
		return cDNS;
	}
	public void setcDNS(String cDNS) {
		this.cDNS = cDNS;
	}
	public double getcNetspeed() {
		return cNetspeed;
	}
	public void setcNetspeed(double cNetspeed) {
		this.cNetspeed = cNetspeed;
	}
	public double getcClientType() {
		return cClientType;
	}
	public void setcClientType(double cClientType) {
		this.cClientType = cClientType;
	}
	public String getcLastIp() {
		return cLastIp;
	}
	public void setcLastIp(String cLastIp) {
		this.cLastIp = cLastIp;
	}
	public double getD8() {
		return d8;
	}
	public void setD8(double d8) {
		this.d8 = d8;
	}
	public int getTcpNum() {
		return tcpNum;
	}
	public void setTcpNum(int tcpNum) {
		this.tcpNum = tcpNum;
	}
	
	public long getUrlCode() {
		return urlCode;
	}
	public void setUrlCode(long urlCode) {
		this.urlCode = urlCode;
	}
	public int getFirstFlag() {
		return firstFlag;
	}
	public void setFirstFlag(int firstFlag) {
		this.firstFlag = firstFlag;
	}
	public int getMonitorTimeCode() {
		return monitorTimeCode;
	}
	public void setMonitorTimeCode(int monitorTimeCode) {
		this.monitorTimeCode = monitorTimeCode;
	}
	public String getReqMethod() {
		return reqMethod;
	}
	public void setReqMethod(String reqMethod) {
		this.reqMethod = reqMethod;
	}
	
	
	
}

