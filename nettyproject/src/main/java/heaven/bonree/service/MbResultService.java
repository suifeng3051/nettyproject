package heaven.bonree.service;

import heaven.bonree.DAO.QueryTestResultDAO;
import heaven.bonree.protobuf.tasks.PBMBTaskNavigateResult.PB_MBTaskNavigateResult;
import heaven.bonree.protobuf.tasks.PBMBTaskNetenvResult.PB_MBTaskNetenvResult;
import heaven.bonree.protobuf.tasks.PBMBTaskNetenvResult.PB_TaskDnsResult;
import heaven.bonree.protobuf.tasks.PBMBTaskNetenvResult.PB_TaskIcmpResult;

import java.util.ArrayList;
import java.util.List;


public class MbResultService {
	private QueryTestResultDAO resultDAO=new QueryTestResultDAO();
	
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
