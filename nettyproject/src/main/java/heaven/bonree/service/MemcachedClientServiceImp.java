package heaven.bonree.service;

import heaven.bonree.domain.CacheItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.KeysUtils;
import util.MemcachedClientFactory;


import com.danga.MemCached.MemCachedClient;
import com.schooner.MemCached.MemcachedItem;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-15
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: MemcachedClientJava.java
 * @Package test.memcache.service
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class MemcachedClientServiceImp implements MemcachedClientService{
	MemCachedClient mmc = MemcachedClientFactory.getInstance();  
    public boolean add(String key, Object value) {  
        return mmc.add(key, value);  
    }  
  
    public boolean cas(String key, String value, long unique) {  
        return mmc.cas(key, value, unique);  
    }  
  
    public String get(String key) {  
        return (String) mmc.get(key);  
    }  
  
    public CacheItem getsCacheItem(String key) {  
        MemcachedItem item = mmc.gets(key);  
        return new CacheItem(key, (String) item.getValue(), item.getCasUnique());  
    }  
    public MemcachedItem getsMemcachedItem(String key) {  
       
        return mmc.gets(key);
    } 
  
    public boolean set(String key, String value) {  
        return mmc.set(key, value);  
    }  
  
    public boolean delete(String key) {  
        return mmc.delete(key);  
    }  
  
    public boolean flushAll() {  
        return mmc.flushAll();  
    }
    
	public Object getUserData(String userId, String taskId, String timeStamp) {
		String keyPrefix=new StringBuilder("userid:").append(userId).append("_taskid:").append(taskId).toString();
		List<String> timeStrs=KeysUtils.parseTimeToKeys(timeStamp);
		String [] keys=new String[timeStrs.size()];
		for(int i=0;i<timeStrs.size();i++){
			keys[i]=keyPrefix+"_"+timeStrs.get(i);
		}
		return getMulti(keys);
	}
	
	
	public Object getUserData(String userId) {
		Object value=get(userId);
		String[] userkeys=(String[])value;
		return getMulti(userkeys);
	}


	public Map<String,Object> getMulti(String[] keys) {
		return mmc.getMulti(keys);
	}


	public String[] getNoneExistKeys(String[] keys) {
		List<String> noneExistKeyList=new ArrayList<String>();
		for(String key:keys){
			if(!mmc.keyExists(key)){
				noneExistKeyList.add(key);
			}
		}
		String [] noneExistKeyArray=(String[])noneExistKeyList.toArray(new String[noneExistKeyList.size()]);
		return noneExistKeyArray;
	}

	/*@Override
	public KeyFuture getKeyFuture(String[] keys) {
		KeyFuture future=new KeyFuture();
		List<String> existKeyList=new ArrayList<String>();
		List<String> noneExistKeyList=new ArrayList<String>();
		for(String key:keys){
			if(mmc.keyExists(key)){
				existKeyList.add(key);
			}else{
				noneExistKeyList.add(key);
			}
		}
		String [] existKeyArray=new String[existKeyList.size()];
		existKeyArray=(String[])existKeyList.toArray();
		String [] noneExistKeyArray=new String[noneExistKeyList.size()];
		noneExistKeyArray=(String[])noneExistKeyList.toArray();
		future.setExistKeys(existKeyArray);
		future.setNoneExistKeys(noneExistKeyArray);
		return future;
	}  */
	
}

