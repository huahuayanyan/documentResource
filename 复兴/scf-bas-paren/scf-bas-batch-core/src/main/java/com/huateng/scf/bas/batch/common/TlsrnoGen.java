package com.huateng.scf.bas.batch.common;

import java.sql.Connection;

/**
 * <p>@Title: 交通银行个人贷款管理系统</p>
 * <p>@Description: 分行并行用,未开办业务的分行批量操作员可能不存在</p>
 * <p>@Created time: Mar 9, 2005 4:26:55 PM</p>
 * <p>@Company:上海华腾软件系统有限公司</p>
 * <p>@author Ranger.Mao</p>
 */

public class TlsrnoGen {
	private String tlrno=null;
	private Tlsrno tlsrno=null;
	private Connection conn=null;
	public TlsrnoGen(Connection _conn,String _tlrno){
		this.conn=_conn;
		this.tlrno=_tlrno;
	}
	/**
	 * @Title: 返回10位长流水号
	 * @Description: 
	 * @return
	 * @author Ranger.Mao
	 * @Created time: Jan 26, 2005 11:41:27 AM
	 */
	private Tlsrno getTLsrno() throws Exception{
		if (tlsrno==null)
			tlsrno=new Tlsrno(conn,tlrno);
		return tlsrno;
	}
	
	public String getTlsrnoExt() throws Exception{
		if (tlsrno==null)
			tlsrno=new Tlsrno(conn,tlrno);
		return tlsrno.getTlsrnoExt();
	}
	/**
	 * @Title: 取得下一主流水号 
	 * @Description: 
	 * 
	 * @author Ranger.Mao
	 * @Created time: Jan 26, 2005 11:51:40 AM
	 */
	public void genNextMsrno() throws Exception{
		if (tlsrno==null)
			tlsrno=new Tlsrno(conn,tlrno);
		tlsrno.genNextMsrno();
	}
	/**
	 * @Title: 取得下一次流水号 
	 * @Description: 
	 * 
	 * @author Ranger.Mao
	 * @Created time: Jan 26, 2005 11:51:51 AM
	 */
	public void genNextExtno() throws Exception{
		if (tlsrno==null)
			tlsrno=new Tlsrno(conn,tlrno);
		tlsrno.genNextExtno();
	}

	/**
	 * @Title: 更新数据库流水号
	 * @Description: 
	 * 
	 * @author Ranger.Mao
	 * @Created time: Jan 26, 2005 11:52:36 AM
	 */
	public void putTlsrno(Connection _conn) throws Exception{
		if (tlsrno==null)
			tlsrno=new Tlsrno(_conn,tlrno);
		tlsrno.putTlsrno(_conn);
	}
}
