/*
 * 创建日期 2007-8-31
 *
 * 更改所生成文件模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
package com.huateng.scf.bas.batch.common.service;

/**
 * @author ShaoZhiGang
 *
 * 更改所生成类型注释的模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
public class ServiceException extends Exception {

	/**
	* ServiceException 构造子注解。
	*/
	public ServiceException() {
		super();
	}
	/**
	 * ServiceException 构造子注解。
	 * @param s java.lang.String
	 */
	public ServiceException(String s) {
		super(s);
	}

	private Exception rootException;

	/**
	 * 
	 * @param e
	 */
	public ServiceException(Exception e) {
		rootException = e;
	}

	/**
	 * 
	 */
	public String toString() {
		if (rootException == null) {
			return super.toString();
		} else {
			return super.toString() + ": Root Exception is: " + rootException;
		}
	}

}
