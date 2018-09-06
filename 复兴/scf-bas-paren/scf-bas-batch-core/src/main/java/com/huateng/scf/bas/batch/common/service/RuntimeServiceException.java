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
public class RuntimeServiceException extends RuntimeException {

	private Exception rootException;

	/**
	 * 
	 *
	 */
	public RuntimeServiceException() {
		super();
	}
	/**
	 * 
	 * @param e
	 */
	public RuntimeServiceException(Exception e) {
		rootException = e;
	}
	/**
	 * 
	 * @param s
	 */
	public RuntimeServiceException(String s) {
		super(s);
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
