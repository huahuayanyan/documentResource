/**
 * 
 */
package com.huateng.scf.bas.sys.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.cnt.dao.IBCntMprotBaseInfoDAO;
import com.huateng.scf.bas.sys.service.IScfSysCacheService;
import com.huateng.scube.server.annotation.ScubeService;
import com.whalin.MemCached.MemCachedClient;

/**
 * <p>Memcached缓存客户端</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月24日下午7:55:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月24日下午7:55:58              新增
 *
 * </pre>
 */
@ScubeService
@Service("scfMcachedClient")
public class ScfMcachedClientServiceImpl implements IScfSysCacheService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	public static final int EXP_TIME=86400;//默认超时时间，单位秒
//	private MemCachedClient memCachedClient;
	@Resource(name = "memCachedClient")
	private MemCachedClient memCachedClient;

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IScfSysCacheService#put(java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean put(String key, Object value) {
		boolean flag=true;
		try {
			memCachedClient.set(key, value);
		} catch (Exception e) {
			flag=false;
			log.error("put value into memcached error:"+e.getMessage());
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IScfSysCacheService#putWithExptime(java.lang.String, java.lang.Object, int)
	 */
	@Override
	public boolean putWithExptime(String key, Object value, int expTime) {
		boolean flag=true;
		try {
			memCachedClient.add(key, value, expTime);
		} catch (Exception e) {
			flag=false;
			log.error("memCachedClient put value into memcached error:"+e.getMessage());
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IScfSysCacheService#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String key) {
		boolean flag=true;
		try {
			flag=memCachedClient.delete(key);
		} catch (Exception e) {
			flag=false;
			log.error(" memCachedClient delete value from memcached error:"+e.getMessage());
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IScfSysCacheService#get(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key) {
		T t=null;
		try {
			t=(T)memCachedClient.get(key);
		} catch (Exception e) {
			log.error("memCachedClient get value from memcached error:"+e.getMessage());
		}
		return t;
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IScfSysCacheService#expire(java.lang.String)
	 */
	@Override
	public void expire(String key) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.huateng.scf.bas.sys.service.IScfSysCacheService#actTime(java.lang.String)
	 */
	@Override
	public Long actTime(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the memCachedClient
	 */
	public MemCachedClient getMemCachedClient() {
		return memCachedClient;
	}

	/**
	 * @param memCachedClient the memCachedClient to set
	 */
	public void setMemCachedClient(MemCachedClient memCachedClient) {
		this.memCachedClient = memCachedClient;
	}
	
	
	
}
