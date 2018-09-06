/**
 * 
 */
package com.huateng.scf.bas.common.startup;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>供应链全局信息对象
 * 1.工作日<br>
 * 2.用户信息<br>
 * 3.机构信息<br>
 * </p>
 *
 * @author 	huangshuidan
 * @date 2016年11月25日下午2:20:50	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月25日下午2:20:50              新增
 *
 * </pre>
 */
public class ScfGlobalInfo implements Serializable{
	private static final long serialVersionUID = -1280594220740371533L;
	
	private String sysCode;//系统代码
    private String systemName;//系统简称
    private String txnDate;//交易日期/工作日
    private String batDate;//批量日期
    private String lastBatDate;//上一批量日期（换日后更新）
    private String tlrNo;//操作员
    private String tlrName;//操作员
    private String brCode;//机构号
    private String brName;//机构号
    private String sysDate;//系统时间yyyyMMdd
    private String txnStatus;//交易状态
    private Date timestamps;//交易日期/工作日时间戳
    
	public ScfGlobalInfo() {
		
	}

	public ScfGlobalInfo(String sysCode, String systemName, String txnDate, String batDate, String lastBatDate,
			String tlrNo, String tlrName, String brCode, String brName, String sysDate, String txnStatus) {
		this.sysCode = sysCode;
		this.systemName = systemName;
		this.txnDate = txnDate;
		this.batDate = batDate;
		this.lastBatDate = lastBatDate;
		this.tlrNo = tlrNo;
		this.tlrName = tlrName;
		this.brCode = brCode;
		this.brName = brName;
		this.sysDate = sysDate;
		this.txnStatus = txnStatus;
	}

	/**
	 * @return the sysCode
	 */
	public String getSysCode() {
		return sysCode;
	}

	/**
	 * @param sysCode the sysCode to set
	 */
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	/**
	 * @return the systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * @param systemName the systemName to set
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * @return the txnDate
	 */
	public String getTxnDate() {
		return txnDate;
	}

	/**
	 * @param txnDate the txnDate to set
	 */
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	/**
	 * @return the batDate
	 */
	public String getBatDate() {
		return batDate;
	}

	/**
	 * @param batDate the batDate to set
	 */
	public void setBatDate(String batDate) {
		this.batDate = batDate;
	}

	/**
	 * @return the lastBatDate
	 */
	public String getLastBatDate() {
		return lastBatDate;
	}

	/**
	 * @param lastBatDate the lastBatDate to set
	 */
	public void setLastBatDate(String lastBatDate) {
		this.lastBatDate = lastBatDate;
	}

	/**
	 * @return the tlrNo
	 */
	public String getTlrNo() {
		return tlrNo;
	}

	/**
	 * @param tlrNo the tlrNo to set
	 */
	public void setTlrNo(String tlrNo) {
		this.tlrNo = tlrNo;
	}

	/**
	 * @return the tlrName
	 */
	public String getTlrName() {
		return tlrName;
	}

	/**
	 * @param tlrName the tlrName to set
	 */
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	/**
	 * @return the brCode
	 */
	public String getBrCode() {
		return brCode;
	}

	/**
	 * @param brCode the brCode to set
	 */
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	/**
	 * @return the brName
	 */
	public String getBrName() {
		return brName;
	}

	/**
	 * @param brName the brName to set
	 */
	public void setBrName(String brName) {
		this.brName = brName;
	}

	/**
	 * @return the sysDate
	 */
	public String getSysDate() {
		return sysDate;
	}

	/**
	 * @param sysDate the sysDate to set
	 */
	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}

	/**
	 * @return the txnStatus
	 */
	public String getTxnStatus() {
		return txnStatus;
	}

	/**
	 * @param txnStatus the txnStatus to set
	 */
	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

	/**
	 * @return the timestamps
	 */
	public Date getTimestamps() {
		return timestamps;
	}

	/**
	 * @param timestamps the timestamps to set
	 */
	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}
	
	
	
    
    
}
