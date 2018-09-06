/**
 * 
 */
package com.huateng.scf.bas.web.startup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huateng.scf.bas.common.util.ContextUtil;

/**
 * <p>系统环境、全局变量初始化</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月7日下午7:20:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月7日下午7:20:42	                                 新增
 *
 * </pre>
 */
public class ScfBasContextInit implements ServletContextListener{
	private final Logger log = LoggerFactory.getLogger(getClass());
	private static ApplicationContext context;
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent context) {
//		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context.getServletContext());
		/** 设置单例模式的context */
		setContext(WebApplicationContextUtils.getRequiredWebApplicationContext(context.getServletContext()));
		ContextUtil.setApplicationContext(ScfBasContextInit.context);
		/** 基础平台系统初始化 */
		log.info("......基础平台系统初始化..Begin");
		ScfBaseInit scfBaseInit=new ScfBaseInit();
		scfBaseInit.init();
		log.info("......基础平台系统初始化..End");
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent context) {
		try {
			ScfBaseInit.destroy();
			log.info("Release base data object successfully!");
		} catch (Exception e) {
			log.error("Relase bese data object failed："+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @return the context
	 */
	public static ApplicationContext getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public static void setContext(ApplicationContext context) {
		ScfBasContextInit.context = context;
	}
	
	
	
}
