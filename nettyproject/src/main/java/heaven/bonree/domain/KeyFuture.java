package heaven.bonree.domain;
/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-24
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: KeyFuture.java
 * @Package test.memcache.domain
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class KeyFuture {
	private String [] existKeys;
	private String [] noneExistKeys;
	public String[] getExistKeys() {
		return existKeys;
	}
	public void setExistKeys(String[] existKeys) {
		this.existKeys = existKeys;
	}
	public String[] getNoneExistKeys() {
		return noneExistKeys;
	}
	public void setNoneExistKeys(String[] noneExistKeys) {
		this.noneExistKeys = noneExistKeys;
	}
	

}

