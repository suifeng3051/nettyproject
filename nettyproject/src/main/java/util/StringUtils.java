package util;
/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2013-10-9
 * Author: <a href=mailto:luojun@bonree.com>罗俊</a>
 * @Title: StringUtils.java
 * @Package com.bonree.util
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class StringUtils {
	public static final String NullToEmpty(String ss){
		if(ss != null){
			return ss;
		}
		return "";
	}
}

