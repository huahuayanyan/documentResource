/**
 * 
 */
package com.huateng.scf.bas.sys.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huateng.flowsharp.entity.ProcessEntity;
import com.huateng.scf.bas.sys.service.IScfSysCacheService;
import com.huateng.scf.bas.sys.service.impl.ScfMcachedClientServiceImpl;

/**
 * <p>MemCached缓存测试</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月25日上午9:40:48
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月25日上午9:40:48              新增
 *
 * </pre>
 */
public class MemCachedTest {
	private final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 存入缓存测试
	 * @throws Exception
	 */
	@Test
	public void putMemCachedTest() throws Exception{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
////		ScubeClientCall.setCtx(ctx);
//		IScfSysCacheService scfSysCacheService =  ctx.getBean("scfSysCacheService", IScfSysCacheService.class);
//		ProcessEntity processEntity=new ProcessEntity();
//		processEntity.setBizId("scf001");
//		processEntity.setModelId("md201611022511");
//		boolean appnoFlag=scfSysCacheService.putWithExptime("scfAppNo", "scf2016112501", ScfMcachedClientServiceImpl.EXP_TIME);
//		log.info("--------------appnoFlag:"+appnoFlag);
//		boolean processFlag=scfSysCacheService.putWithExptime("processEntity", processEntity, ScfMcachedClientServiceImpl.EXP_TIME);
//		log.info("--------------processFlag:"+processFlag);
	}
	/**
	 * 取出缓存信息测试
	 * @throws Exception
	 */
	@Test
	public void getMemCachedTest() throws Exception{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:test-scf-bas-sys-spring-service.xml");
//		ScubeClientCall.setCtx(ctx);
//		IScfSysCacheService scfSysCacheService =  ctx.getBean("scfSysCacheService", IScfSysCacheService.class);
//		ProcessEntity processEntity=scfSysCacheService.get("processEntity");
//		if(null!=processEntity){
//			log.info("----------------biz id:"+processEntity.getBizId());
//			log.info("----------------ModelId:"+processEntity.getModelId());
//		}
//		String scfAppNo=scfSysCacheService.get("scfAppNo");
//		log.info("--------------------scfAppNo:"+scfAppNo);
	}
}
