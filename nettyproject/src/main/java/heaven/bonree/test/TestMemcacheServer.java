package heaven.bonree.test;

import heaven.bonree.service.MemcachedService;

import java.text.ParseException;


/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-5-4
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: TestMemcacheServer.java
 * @Package NettyDemo.bonree.test
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class TestMemcacheServer {
	public static void main(String[] args) {
		MemcachedService service = new MemcachedService();
		try {
			service.queryBusinessData("t_mcc_stat_navigate", "229882", "2012-12-31 5~2012-12-31 6");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

