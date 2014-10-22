package heaven.bonree.domain;

import java.io.Serializable;




/**
 * 移动测试页面浏览信息封装类
 * wanghouda
 * ***/
public class TMccStatNavigate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//基本
	private Long mid;
	private Integer monitorFun;//监测类型 2单元素，3全元素
	private String url;//监测url
	private int city;//监测点城市
	private int netServiceId;//监测点运营商
	private String monitorTime;//监测时间
	private String ip;//监测点ip
	private String dns;//经纬度
	private int type;//监测点类型
	private double netSpeed;//监测点宽带
	private int cpuRate;//手机制式
	private int procnum;//信号强度
	private int errorid;//错误id
	private long clientNum;//客户端id
	private double step2;//DNS
	private double step3;//TCP
	private double step13;//SSL
	private double step4;//Request
	private double step5;//Response
	private double step6;//Redirect
	private double step7;//Doc Download
	private double step8;//Resources Download
	private double dtime;//Time
	private double firstTime;//First Screen
	private double step9;//First Byte
	private double pageLoadeds;//Page Loaded 页面加载完成时间
	private double domLoadeds;//Dom Loaded加载完成时间
	private double downSpeed;//页面整体速度
	private int roundTrips;//网络Round Trips
	private double step10;//基础文档速度
	private int dnsLookUps;//DNS查询总次数
	private double step11;//渲染速度
	private int tcpConnects;//TCP建立连接总次数
	private double bytesReceived;//下载总字节数
	private double fileDown;//基础文档下载字节数
	private double fileSize;//First Byte
	private String header;//header
	private String reqHeader;//REQ_HEADER
	private Integer monitorSet8; //（网页浏览：返回Header：0-不返回；1-返回基础文档Header；2-返回所有Header）
	private Integer imgFlag;//错误快照开关 0-关
	private boolean checkImgUrl;//缩略图url连接是否有效标识符
	private boolean slowFlag;//最耗时元素图表标识
	private String chart1URL;//最耗时元素图表url
	private String imagemap;//最耗时元素图表图片
	//网络
	//private String netenv;
	//隐藏域数据
	private double docComplete;//文档下载完成用时
	private String mtype;//访问入参mtype
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public Integer getMonitorFun() {
		return monitorFun;
	}
	public void setMonitorFun(Integer monitorFun) {
		this.monitorFun = monitorFun;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getNetServiceId() {
		return netServiceId;
	}
	public void setNetServiceId(int netServiceId) {
		this.netServiceId = netServiceId;
	}
	
	
	public String getMonitorTime() {
		return monitorTime;
	}
	public void setMonitorTime(String monitorTime) {
		this.monitorTime = monitorTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getNetSpeed() {
		return netSpeed;
	}
	public void setNetSpeed(double netSpeed) {
		this.netSpeed = netSpeed;
	}
	public int getCpuRate() {
		return cpuRate;
	}
	public void setCpuRate(int cpuRate) {
		this.cpuRate = cpuRate;
	}
	public int getProcnum() {
		return procnum;
	}
	public void setProcnum(int procnum) {
		this.procnum = procnum;
	}
	public int getErrorid() {
		return errorid;
	}
	public void setErrorid(int errorid) {
		this.errorid = errorid;
	}
	
	public long getClientNum() {
		return clientNum;
	}
	public void setClientNum(long clientNum) {
		this.clientNum = clientNum;
	}
	public double getStep2() {
		return step2;
	}
	public void setStep2(double step2) {
		this.step2 = step2;
	}
	public double getStep3() {
		return step3;
	}
	public void setStep3(double step3) {
		this.step3 = step3;
	}
	public double getStep13() {
		return step13;
	}
	public void setStep13(double step13) {
		this.step13 = step13;
	}
	public double getStep4() {
		return step4;
	}
	public void setStep4(double step4) {
		this.step4 = step4;
	}
	public double getStep5() {
		return step5;
	}
	public void setStep5(double step5) {
		this.step5 = step5;
	}
	public double getStep6() {
		return step6;
	}
	public void setStep6(double step6) {
		this.step6 = step6;
	}
	public double getStep7() {
		return step7;
	}
	public void setStep7(double step7) {
		this.step7 = step7;
	}
	public double getStep8() {
		return step8;
	}
	public void setStep8(double step8) {
		this.step8 = step8;
	}
	public double getDtime() {
		return dtime;
	}
	public void setDtime(double dtime) {
		this.dtime = dtime;
	}
	public double getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(double firstTime) {
		this.firstTime = firstTime;
	}
	public double getStep9() {
		return step9;
	}
	public void setStep9(double step9) {
		this.step9 = step9;
	}
	public double getPageLoadeds() {
		return pageLoadeds;
	}
	public void setPageLoadeds(double pageLoadeds) {
		this.pageLoadeds = pageLoadeds;
	}
	public double getDomLoadeds() {
		return domLoadeds;
	}
	public void setDomLoadeds(double domLoadeds) {
		this.domLoadeds = domLoadeds;
	}
	public double getDownSpeed() {
		return downSpeed;
	}
	public void setDownSpeed(double downSpeed) {
		this.downSpeed = downSpeed;
	}
	public int getRoundTrips() {
		return roundTrips;
	}
	public void setRoundTrips(int roundTrips) {
		this.roundTrips = roundTrips;
	}
	
	public double getStep10() {
		return step10;
	}
	public void setStep10(double step10) {
		this.step10 = step10;
	}
	public int getDnsLookUps() {
		return dnsLookUps;
	}
	public void setDnsLookUps(int dnsLookUps) {
		this.dnsLookUps = dnsLookUps;
	}
	public double getStep11() {
		return step11;
	}
	public void setStep11(double step11) {
		this.step11 = step11;
	}
	public int getTcpConnects() {
		return tcpConnects;
	}
	public void setTcpConnects(int tcpConnects) {
		this.tcpConnects = tcpConnects;
	}
	public double getBytesReceived() {
		return bytesReceived;
	}
	public void setBytesReceived(double bytesReceived) {
		this.bytesReceived = bytesReceived;
	}
	public double getFileDown() {
		return fileDown;
	}
	public void setFileDown(double fileDown) {
		this.fileDown = fileDown;
	}
	public double getFileSize() {
		return fileSize;
	}
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getReqHeader() {
		return reqHeader;
	}
	public void setReqHeader(String reqHeader) {
		this.reqHeader = reqHeader;
	}
	public Integer getMonitorSet8() {
		return monitorSet8;
	}
	public void setMonitorSet8(Integer monitorSet8) {
		this.monitorSet8 = monitorSet8;
	}
	public Integer getImgFlag() {
		return imgFlag;
	}
	public void setImgFlag(Integer imgFlag) {
		this.imgFlag = imgFlag;
	}
	public boolean isCheckImgUrl() {
		return checkImgUrl;
	}
	public void setCheckImgUrl(boolean checkImgUrl) {
		this.checkImgUrl = checkImgUrl;
	}
	public boolean isSlowFlag() {
		return slowFlag;
	}
	public void setSlowFlag(boolean slowFlag) {
		this.slowFlag = slowFlag;
	}
	public String getChart1URL() {
		return chart1URL;
	}
	public void setChart1URL(String chart1url) {
		chart1URL = chart1url;
	}
	public String getImagemap() {
		return imagemap;
	}
	public void setImagemap(String imagemap) {
		this.imagemap = imagemap;
	}
	
	public double getDocComplete() {
		return docComplete;
	}
	public void setDocComplete(double docComplete) {
		this.docComplete = docComplete;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	@Override
	public String toString() {
		return "TMccStatNavigate [bytesReceived=" + bytesReceived
				+ ", chart1URL=" + chart1URL + ", checkImgUrl=" + checkImgUrl
				+ ", city=" + city + ", clientNum=" + clientNum + ", cpuRate="
				+ cpuRate + ", dns=" + dns + ", dnsLookUps=" + dnsLookUps
				+ ", docComplete=" + docComplete + ", domLoadeds=" + domLoadeds
				+ ", downSpeed=" + downSpeed + ", dtime=" + dtime
				+ ", errorid=" + errorid + ", fileDown=" + fileDown
				+ ", fileSize=" + fileSize + ", firstTime=" + firstTime
				+ ", header=" + header + ", imagemap=" + imagemap
				+ ", imgFlag=" + imgFlag + ", ip=" + ip + ", mid=" + mid
				+ ", monitorFun=" + monitorFun + ", monitorSet8=" + monitorSet8
				+ ", monitorTime=" + monitorTime + ", mtype=" + mtype
				+ ", netServiceId=" + netServiceId + ", netSpeed=" + netSpeed
				+ ", pageLoadeds=" + pageLoadeds + ", procnum=" + procnum
				+ ", reqHeader=" + reqHeader + ", roundTrips=" + roundTrips
				+ ", slowFlag=" + slowFlag + ", step10=" + step10 + ", step11="
				+ step11 + ", step13=" + step13 + ", step2=" + step2
				+ ", step3=" + step3 + ", step4=" + step4 + ", step5=" + step5
				+ ", step6=" + step6 + ", step7=" + step7 + ", step8=" + step8
				+ ", step9=" + step9 + ", tcpConnects=" + tcpConnects
				+ ", type=" + type + ", url=" + url + "]";
	}
	
	
	
	
}
