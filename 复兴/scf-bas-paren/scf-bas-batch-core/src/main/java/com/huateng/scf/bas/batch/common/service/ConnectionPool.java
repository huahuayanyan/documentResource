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
public interface ConnectionPool extends Pool {
	
	java.sql.Connection get()
		throws java.sql.SQLException, ServiceNotInitialException;
	public java.sql.Connection get(int timeout)
		throws java.sql.SQLException, ServiceNotInitialException;
	public void release(java.sql.Connection connection);
}
