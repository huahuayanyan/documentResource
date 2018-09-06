package com.huateng.scf.rec.qry.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名：S034RspDataList.java
 * 功能描述：核心前台账号入账查询－输出报文体信息LIST-BEAN
 * 创建日期: 2013-7-13
 * 创建人: zhonghuabin
 * JDK版本: <1.5.0>
 * 程序版本: SupplyChainSysPortal <1.0> <br>
 * 修改历史 <br>
 *  date           | author  | desc <br>
 */
public class S034RspDataList {
	private int rowQt;	//总条数
	private int beginRow;	//开始条数
	private List<S034RspDataListRow> rowlist_01 = new ArrayList<S034RspDataListRow>();

	public int getRowQt() {
		return rowQt;
	}
	public void setRowQt(int rowQt) {
		this.rowQt = rowQt;
	}
	public int getBeginRow() {
		return beginRow;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public List<S034RspDataListRow> getRowlist_01() {
		return rowlist_01;
	}
	public void setRowlist_01(List<S034RspDataListRow> rowlist_01) {
		this.rowlist_01 = rowlist_01;
	}

}