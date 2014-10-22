package util;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;



/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司
 * Copyright: Copyright (c) 2007博睿宏远科技发展有限公司,Inc.All Rights Reserved.
 * 
 * BidPlanStructForm.java Created on 2014-4-15
 * Author: <a href=mailto:wanghd@bonree.com>王厚达</a>
 * @Title: MemcachedClientFactory.java
 * @Package test.memcache.service
 * Description:
 * Version: 1.0
 ******************************************************************************/
public class MemcachedClientFactory extends ConfigurableConstants{
	private static volatile MemCachedClient mmc;  
	/**静态方法，初始化Memcached Client连接池**/
    static {  
        init("memcached-client.properties");  
        String[] servers = getProperty("memcached-servers","").split(",");  
        System.out.println(servers.length+servers[0]);
        Integer[] weights = null;  
        String weightsCfg = getProperty("memcached-weights","");  
        if(weightsCfg != null){  
            String[] wcfg = weightsCfg.split(",");  
            weights = new Integer[wcfg.length];  
            for (int i = 0; i < weights.length; i++) {  
                weights[i] = Integer.valueOf(wcfg[i]);  
            }  
        }else{  
            weights = new Integer[servers.length];  
            for (int i = 0; i < weights.length; i++) {  
                weights[i] = 1;  
            }  
        }     
        SockIOPool pool = SockIOPool.getInstance();  
        pool.setServers(servers);  
        pool.setWeights(weights);  
        System.out.println(weights);
        pool.setHashingAlg(SockIOPool.CONSISTENT_HASH);  
        pool.setInitConn(getProperty("memcached-initConn",5));  
        pool.setMinConn(getProperty("memcached-minConn",5));  
        pool.setMaxConn(getProperty("memcached-maxConn",250));  
        pool.setMaxIdle(1000 * 60 * 60 * 6);  
        pool.setMaintSleep(30);  
        pool.setNagle(false);  
        pool.setSocketTO(3000);  
        pool.setSocketConnectTO(0);  
        pool.initialize();  
    }  
    
    /**
     * 私有构造方法，保护静态工程不被实例化
     */
    private MemcachedClientFactory() { 
    }  
  
    /**
     * 概述：创建Memcached Client单例
     * @Title: getInstance
     * @return MemCachedClient
     * @user <a href=mailto:wanghd@bonree.com>王厚达</a>
     */
    public static MemCachedClient getInstance() {  
        if (mmc == null) {  
            synchronized (MemCachedClient.class) {  
                if (mmc == null) {  
                    mmc = new MemCachedClient();  
                }  
            }  
        }  
        return mmc;  
    }  
}

