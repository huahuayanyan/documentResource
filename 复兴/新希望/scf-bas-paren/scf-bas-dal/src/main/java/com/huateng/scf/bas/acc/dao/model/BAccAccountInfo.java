package com.huateng.scf.bas.acc.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.huateng.scf.bas.dao.common.model.ScfBaseModel;

public class BAccAccountInfo extends ScfBaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键UUID
	 */
	private String id;

	/**
	 * VARCHAR(15)<br>
	 * 客户号
	 */
	private String custcd;

	/**
	 * CHAR(1)<br>
	 * 账户类型：1-结算账户;2-回款账户;3-保证金账户;4-保理专户;5-待核查账户
	 */
	private String accountType;

	/**
	 * CHAR(3)<br>
	 * 币种
	 */
	private String curcd;

	/**
	 * VARCHAR(50)<br>
	 * 账号
	 */
	private String accountNo;

	/**
	 * VARCHAR(120)<br>
	 * 账户名称
	 */
	private String accountName;

	/**
	 * DECIMAL(16,2)<br>
	 * 账户金额/余额
	 */
	private BigDecimal account;

	/**
	 * CHAR(1)<br>
	 * 账户状态：0-无效、1-有效
	 */
	private String status;

	/**
	 * VARCHAR(32)<br>
	 * 客户经理
	 */
	private String mgrno;
	/**
	 * VARCHAR(32)<br>
	 * 客户经理名称
	 */
	private String mgrName;

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	/**
	 * CHAR(1)<br>
	 * 是否我行账户：0-否、1-是
	 */
	private String myBankAccFlg;

	/**
	 * VARCHAR(120)<br>
	 * 开户行名称
	 */
	private String openAccBankNm;

	/**
	 * VARCHAR(12)<br>
	 * 开户行行号
	 */
	private String openAccBankNo;

	/**
	 * VARCHAR(32)<br>
	 * 创建人
	 */
	private String tlrcd;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 创建时间
	 */
	private Date crtTime;

	/**
	 * VARCHAR(20)<br>
	 * 经办机构
	 */
	private String brcode;

	/**
	 * VARCHAR(32)<br>
	 * 最后更新操作员
	 */
	private String lastUpdTlrcd;

	/**
	 * TIMESTAMP(11,6)<br>
	 * 最后更新时间
	 */
	private Date lastUpdTime;

	/**
	 * VARCHAR(20)<br>
	 * 最后更新机构
	 */
	private String lastUpdBrcode;
	/**
	 * 
	 * 创建人姓名
	 */
	private String tlrName;
	/**
	 * 
	 * 经办机构名称
	 */
	private String brName;
	/**
	 * 
	 * 最后更新操作员名称
	 */
	private String lastUpdTlrName;
	/**
	 * 
	 * 最后更新机构名称
	 */
	private String lastUpdBrName;

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getLastUpdTlrName() {
		return lastUpdTlrName;
	}

	public void setLastUpdTlrName(String lastUpdTlrName) {
		this.lastUpdTlrName = lastUpdTlrName;
	}

	public String getLastUpdBrName() {
		return lastUpdBrName;
	}

	public void setLastUpdBrName(String lastUpdBrName) {
		this.lastUpdBrName = lastUpdBrName;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 获得 主键UUID
	 */
	public String getId() {
		return id;
	}

	/**
	 * VARCHAR(32) 必填<br>
	 * 设置 主键UUID
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * VARCHAR(15)<br>
	 * 获得 客户号
	 */
	public String getCustcd() {
		return custcd;
	}

	/**
	 * VARCHAR(15)<br>
	 * 设置 客户号
	 */
	public void setCustcd(String custcd) {
		this.custcd = custcd == null ? null : custcd.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 账户类型：1-结算账户;2-回款账户;3-保证金账户;4-保理专户;5-待核查账户
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 账户类型：1-结算账户;2-回款账户;3-保证金账户;4-保理专户;5-待核查账户
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType == null ? null : accountType.trim();
	}

	/**
	 * CHAR(3)<br>
	 * 获得 币种
	 */
	public String getCurcd() {
		return curcd;
	}

	/**
	 * CHAR(3)<br>
	 * 设置 币种
	 */
	public void setCurcd(String curcd) {
		this.curcd = curcd == null ? null : curcd.trim();
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 账号
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 账号
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo == null ? null : accountNo.trim();
	}

	/**
	 * VARCHAR(120)<br>
	 * 获得 账户名称
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * VARCHAR(120)<br>
	 * 设置 账户名称
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName == null ? null : accountName.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 账户金额/余额
	 */
	public BigDecimal getAccount() {
		return account;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 账户金额/余额
	 */
	public void setAccount(BigDecimal account) {
		this.account = account;
	}

	/**
	 * CHAR(1)<br>
	 * 获得 账户状态：0-无效、1-有效
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 账户状态：0-无效、1-有效
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 客户经理
	 */
	public String getMgrno() {
		return mgrno;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 客户经理
	 */
	public void setMgrno(String mgrno) {
		this.mgrno = mgrno == null ? null : mgrno.trim();
	}

	/**
	 * CHAR(1)<br>
	 * 获得 是否我行账户：0-否、1-是
	 */
	public String getMyBankAccFlg() {
		return myBankAccFlg;
	}

	/**
	 * CHAR(1)<br>
	 * 设置 是否我行账户：0-否、1-是
	 */
	public void setMyBankAccFlg(String myBankAccFlg) {
		this.myBankAccFlg = myBankAccFlg == null ? null : myBankAccFlg.trim();
	}

	/**
	 * VARCHAR(120)<br>
	 * 获得 开户行名称
	 */
	public String getOpenAccBankNm() {
		return openAccBankNm;
	}

	/**
	 * VARCHAR(120)<br>
	 * 设置 开户行名称
	 */
	public void setOpenAccBankNm(String openAccBankNm) {
		this.openAccBankNm = openAccBankNm == null ? null : openAccBankNm.trim();
	}

	/**
	 * VARCHAR(12)<br>
	 * 获得 开户行行号
	 */
	public String getOpenAccBankNo() {
		return openAccBankNo;
	}

	/**
	 * VARCHAR(12)<br>
	 * 设置 开户行行号
	 */
	public void setOpenAccBankNo(String openAccBankNo) {
		this.openAccBankNo = openAccBankNo == null ? null : openAccBankNo.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 创建人
	 */
	public String getTlrcd() {
		return tlrcd;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 创建人
	 */
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd == null ? null : tlrcd.trim();
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 创建时间
	 */
	public Date getCrtTime() {
		return crtTime;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 设置 创建时间
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 经办机构
	 */
	public String getBrcode() {
		return brcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 经办机构
	 */
	public void setBrcode(String brcode) {
		this.brcode = brcode == null ? null : brcode.trim();
	}

	/**
	 * VARCHAR(32)<br>
	 * 获得 最后更新操作员
	 */
	public String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}

	/**
	 * VARCHAR(32)<br>
	 * 设置 最后更新操作员
	 */
	public void setLastUpdTlrcd(String lastUpdTlrcd) {
		this.lastUpdTlrcd = lastUpdTlrcd == null ? null : lastUpdTlrcd.trim();
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 获得 最后更新时间
	 */
	public Date getLastUpdTime() {
		return lastUpdTime;
	}

	/**
	 * TIMESTAMP(11,6)<br>
	 * 设置 最后更新时间
	 */
	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 最后更新机构
	 */
	public String getLastUpdBrcode() {
		return lastUpdBrcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 最后更新机构
	 */
	public void setLastUpdBrcode(String lastUpdBrcode) {
		this.lastUpdBrcode = lastUpdBrcode == null ? null : lastUpdBrcode.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", custcd=").append(custcd);
		sb.append(", accountType=").append(accountType);
		sb.append(", curcd=").append(curcd);
		sb.append(", accountNo=").append(accountNo);
		sb.append(", accountName=").append(accountName);
		sb.append(", account=").append(account);
		sb.append(", status=").append(status);
		sb.append(", mgrno=").append(mgrno);
		sb.append(", myBankAccFlg=").append(myBankAccFlg);
		sb.append(", openAccBankNm=").append(openAccBankNm);
		sb.append(", openAccBankNo=").append(openAccBankNo);
		sb.append(", tlrcd=").append(tlrcd);
		sb.append(", crtTime=").append(crtTime);
		sb.append(", brcode=").append(brcode);
		sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
		sb.append(", lastUpdTime=").append(lastUpdTime);
		sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		BAccAccountInfo other = (BAccAccountInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
				&& (this.getAccountType() == null ? other.getAccountType() == null
						: this.getAccountType().equals(other.getAccountType()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getAccountNo() == null ? other.getAccountNo() == null
						: this.getAccountNo().equals(other.getAccountNo()))
				&& (this.getAccountName() == null ? other.getAccountName() == null
						: this.getAccountName().equals(other.getAccountName()))
				&& (this.getAccount() == null ? other.getAccount() == null
						: this.getAccount().equals(other.getAccount()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getMgrno() == null ? other.getMgrno() == null : this.getMgrno().equals(other.getMgrno()))
				&& (this.getMyBankAccFlg() == null ? other.getMyBankAccFlg() == null
						: this.getMyBankAccFlg().equals(other.getMyBankAccFlg()))
				&& (this.getOpenAccBankNm() == null ? other.getOpenAccBankNm() == null
						: this.getOpenAccBankNm().equals(other.getOpenAccBankNm()))
				&& (this.getOpenAccBankNo() == null ? other.getOpenAccBankNo() == null
						: this.getOpenAccBankNo().equals(other.getOpenAccBankNo()))
				&& (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
				&& (this.getCrtTime() == null ? other.getCrtTime() == null
						: this.getCrtTime().equals(other.getCrtTime()))
				&& (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
				&& (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null
						: this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
				&& (this.getLastUpdTime() == null ? other.getLastUpdTime() == null
						: this.getLastUpdTime().equals(other.getLastUpdTime()))
				&& (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null
						: this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
		result = prime * result + ((getAccountType() == null) ? 0 : getAccountType().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
		result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
		result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getMgrno() == null) ? 0 : getMgrno().hashCode());
		result = prime * result + ((getMyBankAccFlg() == null) ? 0 : getMyBankAccFlg().hashCode());
		result = prime * result + ((getOpenAccBankNm() == null) ? 0 : getOpenAccBankNm().hashCode());
		result = prime * result + ((getOpenAccBankNo() == null) ? 0 : getOpenAccBankNo().hashCode());
		result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
		result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
		result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
		result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
		return result;
	}
}