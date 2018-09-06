package com.huateng.scf.bas.batch.common;

import java.sql.Connection;
import java.text.DecimalFormat;



/**
 * <p>@Title: 交通银行个人贷款管理系统</p>
 * <p>@Description: 管理批量流水号</p>
 * <p>@Created time: Jan 26, 2005 11:30:50 AM</p>
 * <p>@Company:上海华腾软件系统有限公司</p>
 * <p>@author Ranger.Mao</p>
 */

public class Tlsrno {
	/**
	 * 主流水号
	 */
	private int msrno=0;
	/**
	 * 次流水号
	 */
	private int extno=0;
	/**
	 * 操作员号
	 */
	private String tlrno=null;
	/**
	 * 主流水号格式
	 */
	private DecimalFormat df6 = new DecimalFormat("000000");
	/**
	 * 次流水号格式
	 */
	private DecimalFormat df4 = new DecimalFormat("0000");
	public Tlsrno(Connection conn,String _tlrno) throws Exception{
		this.tlrno=_tlrno;
		msrno=BatchUtil.getTlsrno(conn,this.tlrno);
	}
	/**
	 * @Title: 返回10位长流水号
	 * @Description: 
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jan 26, 2005 11:41:27 AM
	 */
	public String getTlsrnoExt(){
		return (df6.format(msrno)+df4.format(extno));
	}
	/**
	 * @Title: 取得下一主流水号 
	 * @Description: 
	 * 
	 * @author Ranger.Mao
	 * @Created time: Jan 26, 2005 11:51:40 AM
	 */
	public void genNextMsrno(){
		msrno++;
		extno=0;
	}
	/**
	 * @Title: 取得下一次流水号 
	 * @Description: 
	 * 
	 * @author Ranger.Mao
	 * @Created time: Jan 26, 2005 11:51:51 AM
	 */
	public void genNextExtno(){
		extno++;
		if (extno>9999){
			msrno++;
			extno=0;
		}	
	}

	/**
	 * @Title: 更新数据库流水号
	 * @Description: 
	 * 
	 * @author Ranger.Mao
	 * @Created time: Jan 26, 2005 11:52:36 AM
	 */
	public void putTlsrno(Connection conn) throws Exception{
		BatchUtil.putTlsrno(conn,tlrno,msrno);
	}
}
