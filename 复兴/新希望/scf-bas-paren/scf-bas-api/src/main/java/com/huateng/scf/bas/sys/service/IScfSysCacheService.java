/**
 * 
 */
package com.huateng.scf.bas.sys.service;

import com.huateng.scube.server.annotation.ScubeParam;

/**
 * <p>供应链缓存接口</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月24日下午7:40:51	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月24日下午7:40:51              新增
 *
 * </pre>
 */
public interface IScfSysCacheService {
	public static final String BEAN_ID = "scfSysCacheService";
	/**
	 * 放入缓存（使用默认超时时间）
	 * @param key
	 * 		String-放入缓存ID
	 * @param value
	 * 		Object-放入缓存对象
	 * @return boolean
	 */
	public boolean put(@ScubeParam("key") String key,@ScubeParam("value") Object value);
	/**
	 * 放入缓存（指定超时时间)
	 * @param key
	 * 		String-放入缓存ID
	 * @param value
	 * 		Object-放入缓存对象
	 * @param expTime
	 * 		int-超时时间单位秒
	 * @return boolean
	 */
	public boolean putWithExptime(@ScubeParam("key") String key,@ScubeParam("value") Object value,@ScubeParam("expTime") int expTime);
	/**
	 * 根据缓存ID，删除对应的缓存信息
	 * @param key
	 * 		String-缓存ID
	 * @return boolean
	 */
	public boolean delete(@ScubeParam("key") String key);
	/**
	 * 根据缓存ID取出缓存信息
	 * @param key
	 * @return
	 */
	public <T> T get(@ScubeParam("key") String key);
	/**
	 * 根据缓存ID，重置失效时间
	 * @param key
	 */
	public void expire(@ScubeParam("key") String key);
	/**
	 * 根据缓存ID，取有效时间
	 * @param key
	 * @return
	 */
	public Long actTime(@ScubeParam("key") String key);
	
	
}
