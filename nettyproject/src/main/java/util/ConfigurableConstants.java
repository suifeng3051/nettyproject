package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司 Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights
 * Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-15 Author: <a
 * href=mailto:wanghd@bonree.com>王厚达</a>
 * 
 * @Title: ConfigurableConstants.java
 * @Package test.memcache.service Description: Version: 1.0
 ******************************************************************************/
public class ConfigurableConstants {

	protected static Properties p = new Properties();

	protected static void init(String propertyFileName) {
		InputStream in = null;
		try {
			in = ConfigurableConstants.class.getClassLoader()
					.getResourceAsStream(propertyFileName);
			if (in != null)
				p.load(in);
		} catch (IOException e) {
			// logger.error("load " + propertyFileName +
			// " into Constants error!");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

					// logger.error("close " + propertyFileName + " error!");
				}
			}
		}
	}

	protected static String getProperty(String key, String defaultValue) {
		return p.getProperty(key, defaultValue);
	}

	protected static int getProperty(String key, int defaultValue) {
		try {
			return Integer.parseInt(getProperty(key, ""));

		} catch (Exception e) {
			return defaultValue;
		}
	}
}
