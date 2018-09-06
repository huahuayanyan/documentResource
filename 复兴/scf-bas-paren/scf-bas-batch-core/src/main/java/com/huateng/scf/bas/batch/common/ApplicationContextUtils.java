/**
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2007-2008 Huateng Software System.  All rights
 * reserved.
 * @author Maik.chen
 * create time :2008-02-11 18:23:38
 * ==================================================================
 */
package com.huateng.scf.bas.batch.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;


public class ApplicationContextUtils {
	private static ApplicationContext _context = null;

	private static Log log = LogFactory.getLog(ApplicationContextUtils.class);

	public static synchronized void init(String location)
			throws Exception {
		try {
			if (null == _context) {


				String[] locations = StringUtils.tokenizeToStringArray(
						location, ",");


				if (log.isInfoEnabled()) {
					for ( int i=0; i<locations.length; i++ ){
						//log.info("Loading spring config from files:" + locations[i].trim());
						System.out.println("Loading spring config from files");
					}
					log.info("Loading spring config from files:" + location);
				}
				_context = new ClassPathXmlApplicationContext(locations);
	//			com.huateng.ebank.framework.util.ApplicationContextUtils.setContext(_context);
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("初始化spring配置失败。", ex);
			}

		}
	}

	/*
	 * public static synchronized ApplicationContext getApplicationContext()
	 * throws CommonException { init(); return _context; }
	 */

	public static Object getBean(String beanName) {
		//ApplicationContext ac = getApplicationContext();
		if (null == _context)
			throw new IllegalStateException("ApplicationContext没有被初始化.");
		return _context.getBean(beanName);
	}

	public synchronized static void close() {
		_context = null;
	}

	public static ApplicationContext get_context() {
		return _context;
	}

}
