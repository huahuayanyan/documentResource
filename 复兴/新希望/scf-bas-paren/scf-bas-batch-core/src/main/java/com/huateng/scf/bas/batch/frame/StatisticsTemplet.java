/*
 * 创建日期 2007-9-21
 * <p>Title: 交通银行个人贷款管理系统</p>
 * <p>Description: 批量子步骤模板</p>
 * @author pei
 * @version :2007-9-21 9:39:14
 */
package com.huateng.scf.bas.batch.frame;

import java.sql.Connection;
import java.util.Date;

import com.huateng.scf.bas.batch.vo.LoanInfoWrapVO;


public abstract class StatisticsTemplet {
	
	protected String breakPoint;
	
	protected Connection conn;
	
	protected Date bhdate;
	
	protected static final String dotSplit = ".";

	/**
	 * 默认的构造方法，用于控制程序通过反射实例化子程序
	 */
	public StatisticsTemplet() {
		super();
	}
	
	/**
	 * 方法init(),用于初始化子程序，子类实现，控制程序调用
	 * @throws Exception
	 */
	public void init() throws Exception{
		
		
	}
	
	/**
	 * 抽象方法process(),用于对每条主控程序传输的值对象进行处理
	 * @param loanInfoWarpVo 数据传输对象
	 * @throws Exception
	 */
	public abstract void singleStepProcess(LoanInfoWrapVO loanInfoWarpVo) throws Exception;

    /**
     * 方法processCommit(),用于对数据提交，提供默认实现，子类可重写，控制程序调用
     * @throws Exception
     */
    public void processCommit() throws Exception{
    	
    }
	
	/**
	 * 抽象方法endProcess(),用于结束处理，子类实现，控制程序调用
	 * @throws Exception
	 */
	public abstract void endProcess() throws Exception;
	
	/**
	 * 设置断点值。用于控制程序初始化子程序时调用，防子类重写
	 * @param breakPoint
	 */
    public final void setBreakPoint(String breakPoint){
		
		this.breakPoint = breakPoint;
	}
	
	/**
	 * 设置数据库连接对象，用于控制程序初始化子程序的时候调用，防子类重写
	 * @param conn
	 */
	
	public final void setConnection(Connection conn){
		
		this.conn = conn;
	}

	/**
	 * 设置批量执行日期
	 */
	public void setBhdate(Date date) {
		bhdate = date;
	}

}
