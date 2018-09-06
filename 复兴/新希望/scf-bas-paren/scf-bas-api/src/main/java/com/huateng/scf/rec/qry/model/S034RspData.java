package com.huateng.scf.rec.qry.model;



/**
 * 文件名：S034RspData.java
 * 功能描述：核心前台账号入账查询－输出报文体信息
 * 创建日期: 2013-7-13
 * 创建人: zhonghuabin
 * JDK版本: <1.5.0>
 * 程序版本: SupplyChainSysPortal <1.0> <br>
 * 修改历史 <br>
 *  date           | author  | desc <br>
 */
public class S034RspData {
	private String kehuzh;	//客户账号
	private String kehumc;	//客户账户名称
	private int qishbs;	//起始笔数
	private int cxunbs;	//查询笔数
	private int zbishu;	//总笔数
	private S034RspDataList list_01;	//账号入账查询输出列表

	public String getKehuzh() {
		return kehuzh;
	}
	public void setKehuzh(String kehuzh) {
		this.kehuzh = kehuzh;
	}
	public String getKehumc() {
		return kehumc;
	}
	public void setKehumc(String kehumc) {
		this.kehumc = kehumc;
	}
	public int getQishbs() {
		return qishbs;
	}
	public void setQishbs(int qishbs) {
		this.qishbs = qishbs;
	}
	public int getCxunbs() {
		return cxunbs;
	}
	public void setCxunbs(int cxunbs) {
		this.cxunbs = cxunbs;
	}
	public int getZbishu() {
		return zbishu;
	}
	public void setZbishu(int zbishu) {
		this.zbishu = zbishu;
	}
	public S034RspDataList getList_01() {
		return list_01;
	}
	public void setList_01(S034RspDataList list_01) {
		this.list_01 = list_01;
	}

}