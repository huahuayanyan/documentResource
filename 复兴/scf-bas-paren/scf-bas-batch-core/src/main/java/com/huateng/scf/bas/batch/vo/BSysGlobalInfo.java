package com.huateng.scf.bas.batch.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>@Title: 交通银行个人贷款管理系统</p>
 * <p>@Description: </p>
 * <p>@Created time:2017-05-27  10:05 am</p>
 * <p>@Company:上海华腾软件系统有限公司</p>
 * <p>@author  fangquan</p>
 */

public class BSysGlobalInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bhdate;
	private String txdate;
	private String lbhdate;
	private String status;
	private String systemType; //系统类型

	
	public String getBhdate() {
		return bhdate;
	}

	public String getLbhdate() {
		return lbhdate;
	}

	public String getStatus() {
		return status;
	}

	public String getTxdate() {
		return txdate;
	}

	public void setBhdate(String date) {
		bhdate = date;
	}

	public void setLbhdate(String date) {
		lbhdate = date;
	}

	public void setStatus(String string) {
		status = string;
	}

	public void setTxdate(String date) {
		txdate = date;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String string) {
		systemType = string;
	}

}
