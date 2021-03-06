package heaven.bonree.domain;

import java.util.List;

public class MBNavDataVo {
	//基本
	private String mid;
	private Integer monitorFun;//监测类型 2单元素，3全元素
	private String url;//监测url
	private String city;//监测点城市
	private String netServiceName;//监测点运营商
	private String monitorTime;//监测时间
	private String ip;//监测点ip
	private String dns;//经纬度
	private String type;//监测点类型
	private String netSpeed;//监测点宽带
	private String cpuRate;//手机制式
	private String procnum;//信号强度
	private String errorid;//错误id
	private String client_num;//客户端id
	//第一个表格
	private String step2;//DNS
	private String step3;//TCP
	private String step13;//SSL
	private String step4;//Request
	private String step5;//Response
	private String step6;//Redirect
	private String step7;//Doc Download
	private String step8;//Resources Download
	private String dtime;//Time
	private String firstTime;//First Screen
	private String step9;//First Byte

	private String pageLoadeds;//Page Loaded 页面加载完成时间
	private String domLoadeds;//Dom Loaded加载完成时间
	//第二个表格
	private String downspeed;//页面整体速度
	private String roundtrips;//网络Round Trips
	private String step10;//基础文档速度
	private String dnsLookUps;//DNS查询总次数
	private String step11;//渲染速度
	private String tcpConnects;//TCP建立连接总次数
	private String bytesReceived;//下载总字节数
	private String file_down;//基础文档下载字节数
	private String file_size;//First Byte
	//header和截图
	private String header;//header
	private String reqHeader;//REQ_HEADER
	private Integer monitorSet8; //（网页浏览：返回Header：0-不返回；1-返回基础文档Header；2-返回所有Header）
	private Integer imgFlag;//错误快照开关 0-关
	private String imgUrl;//缩略图url
	private boolean checkImgUrl;//缩略图url连接是否有效标识符
	//耗时元素图表和表格
	private boolean slowFlag;//最耗时元素图表标识
	private String chart1URL;//最耗时元素图表url
	private String imagemap;//最耗时元素图表图片
	private List<ElementVo> element;//最耗时元素图表表格
	//private XYChart slowXYChart;//最耗时元素图片对象
	//网络
	private String netenv;
	//隐藏域数据
	private String docComplete;//文档下载完成用时
	private String mtype;//访问入参mtype
	private String nav_title;//页面详细元素瀑布图第一行
	private String clientInfo;//页面详细元素瀑布图第二行
	private String clientInfo1;//页面详细元素瀑布图第三行
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNetServiceName() {
		return netServiceName;
	}
	public void setNetServiceName(String netServiceName) {
		this.netServiceName = netServiceName;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNetSpeed() {
		return netSpeed;
	}
	public void setNetSpeed(String netSpeed) {
		this.netSpeed = netSpeed;
	}
	public String getCpuRate() {
		return cpuRate;
	}
	public void setCpuRate(String cpuRate) {
		this.cpuRate = cpuRate;
	}
	public String getProcnum() {
		return procnum;
	}
	public void setProcnum(String procnum) {
		this.procnum = procnum;
	}
	public String getStep2() {
		return step2;
	}
	public void setStep2(String step2) {
		this.step2 = step2;
	}
	public String getStep3() {
		return step3;
	}
	public void setStep3(String step3) {
		this.step3 = step3;
	}
	public String getStep13() {
		return step13;
	}
	public void setStep13(String step13) {
		this.step13 = step13;
	}
	public String getStep4() {
		return step4;
	}
	public void setStep4(String step4) {
		this.step4 = step4;
	}
	public String getStep5() {
		return step5;
	}
	public void setStep5(String step5) {
		this.step5 = step5;
	}
	public String getStep6() {
		return step6;
	}
	public void setStep6(String step6) {
		this.step6 = step6;
	}
	public String getStep7() {
		return step7;
	}
	public void setStep7(String step7) {
		this.step7 = step7;
	}
	public String getStep8() {
		return step8;
	}
	public void setStep8(String step8) {
		this.step8 = step8;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	public String getStep9() {
		return step9;
	}
	public void setStep9(String step9) {
		this.step9 = step9;
	}
	public String getDownspeed() {
		return downspeed;
	}
	public void setDownspeed(String downspeed) {
		this.downspeed = downspeed;
	}
	public String getRoundtrips() {
		return roundtrips;
	}
	public void setRoundtrips(String roundtrips) {
		this.roundtrips = roundtrips;
	}
	public String getStep10() {
		return step10;
	}
	public void setStep10(String step10) {
		this.step10 = step10;
	}
	public String getDnsLookUps() {
		return dnsLookUps;
	}
	public void setDnsLookUps(String dnsLookUps) {
		this.dnsLookUps = dnsLookUps;
	}
	public String getStep11() {
		return step11;
	}
	public void setStep11(String step11) {
		this.step11 = step11;
	}
	public String getTcpConnects() {
		return tcpConnects;
	}
	public void setTcpConnects(String tcpConnects) {
		this.tcpConnects = tcpConnects;
	}
	public String getBytesReceived() {
		return bytesReceived;
	}
	public void setBytesReceived(String bytesReceived) {
		this.bytesReceived = bytesReceived;
	}
	public String getFile_down() {
		return file_down;
	}
	public void setFile_down(String file_down) {
		this.file_down = file_down;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	public void setChart1URL(String chart1URL) {
		this.chart1URL = chart1URL;
	}
	public String getImagemap() {
		return imagemap;
	}
	public void setImagemap(String imagemap) {
		this.imagemap = imagemap;
	}
	public List<ElementVo> getElement() {
		return element;
	}
	public void setElement(List<ElementVo> element) {
		this.element = element;
	}
	public String getNetenv() {
		return netenv;
	}
	public void setNetenv(String netenv) {
		this.netenv = netenv;
	}
	public String getDocComplete() {
		return docComplete;
	}
	public void setDocComplete(String docComplete) {
		this.docComplete = docComplete;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getNav_title() {
		return nav_title;
	}
	public void setNav_title(String nav_title) {
		this.nav_title = nav_title;
	}
	public String getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}
	public String getClientInfo1() {
		return clientInfo1;
	}
	public void setClientInfo1(String clientInfo1) {
		this.clientInfo1 = clientInfo1;
	}
	public String getErrorid() {
		return errorid;
	}
	public void setErrorid(String errorid) {
		this.errorid = errorid;
	}
	public String getPageLoadeds() {
		return pageLoadeds;
	}
	public void setPageLoadeds(String pageLoadeds) {
		this.pageLoadeds = pageLoadeds;
	}
	public String getDomLoadeds() {
		return domLoadeds;
	}
	public void setDomLoadeds(String domLoadeds) {
		this.domLoadeds = domLoadeds;
	}
	public String getReqHeader() {
		return reqHeader;
	}
	public void setReqHeader(String reqHeader) {
		this.reqHeader = reqHeader;
	}
	/*public XYChart getSlowXYChart() {
		return slowXYChart;
	}
	public void setSlowXYChart(XYChart slowXYChart) {
		this.slowXYChart = slowXYChart;
	}*/
	public String getClient_num() {
		return client_num;
	}
	public void setClient_num(String client_num) {
		this.client_num = client_num;
	}
	
	
}
