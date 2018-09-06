/**
 * 
 */
package com.huateng.scf.bas.common.startup;

import com.huateng.scf.bas.common.constant.ScfBasConstant;
import com.huateng.scf.bas.common.util.ContextUtil;
import com.huateng.scf.bas.sys.service.IScfSysCacheService;
import com.huateng.scube.exception.ScubeBizException;

/**
 * <p>供应链系统缓存工具类</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月25日下午4:17:17	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月25日下午4:17:17              新增
 *
 * </pre>
 */
public class ScfMcachedUtil {
	private static IScfSysCacheService scfMcachedClient;
	/**
	 * 存放入缓存
	 * @param ctx
	 * 		ApplicationContext对象
	 * @param key
	 * 		String-缓存key
	 * @param obj
	 * 		Object-存入的对象
	 * @param expTime
	 * 		int-超时时间
	 * @return boolean
	 * @throws ScubeBizException
	 */
	public static boolean putObject(String key,Object obj,int expTime) throws ScubeBizException{
		scfMcachedClient=(IScfSysCacheService)ContextUtil.getBean("scfMcachedClient");
//		scfMcachedClient=(IScfSysCacheService)ctx.getBean("scfMcachedClient");
		boolean flag = scfMcachedClient.putWithExptime(key, obj, expTime);
		return flag;
	}
	/**
	 * 存放入缓存(指定beanId)
	 * @param key
	 * 		String-缓存key
	 * @param obj
	 * 		Object-存入的对象
	 * @param expTime\
	 * 		int-超时时间
	 * @param beanId
	 * 		String-IScfSysCacheService注册的spring beanId
	 * @return
	 * @throws ScubeBizException
	 */
	public static boolean putObject(String key,Object obj,int expTime,String beanId) throws ScubeBizException{
		scfMcachedClient=(IScfSysCacheService)ContextUtil.getBean(beanId);
		boolean flag = scfMcachedClient.putWithExptime(key, obj, expTime);
		return flag;
	}
	/**
	 * 根据KEY取缓存对象信息
	 * @param ctx
	 * 		ApplicationContext对象
	 * @param key
	 * 		String-缓存key
	 * @return boolean
	 * @throws ScubeBizException
	 */
	@SuppressWarnings("unchecked")
	public static  <T> T getObject(String key) throws ScubeBizException{
		scfMcachedClient=(IScfSysCacheService)ContextUtil.getBean("scfMcachedClient");
//		scfMcachedClient=(IScfSysCacheService)ctx.getBean("scfMcachedClient");
		T t=null;
		t=(T)scfMcachedClient.get(ScfBasConstant.SCF_CACHE_PUT_KEY_SCFGLOBALINFO);
		return t;
	}
}
