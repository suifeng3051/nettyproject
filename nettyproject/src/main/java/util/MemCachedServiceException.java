package util;
/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-5-8
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: MemCachedServiceException.java
 * @Package NettyDemo.util
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class MemCachedServiceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Long  errorCode;//错误码。
		public  MemCachedServiceException() {  
			super();  
		}  
		public MemCachedServiceException(String msg) {  
		super(msg);  
		}  
		public MemCachedServiceException(String msg, Throwable cause) {  
		super(msg, cause);  
		}  
		public MemCachedServiceException(Throwable cause) {  
			super(cause);  
		}
		public void setErrorCode(Long errorCode) {
			this.errorCode = errorCode;
		}
		public Long getErrorCode() {
			return errorCode;
		}  
}

