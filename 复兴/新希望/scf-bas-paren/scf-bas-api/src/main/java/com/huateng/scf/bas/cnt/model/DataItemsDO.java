package com.huateng.scf.bas.cnt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class DataItemsDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String productId;// 业务品种id

	private String parentId;// 业务大类id

	private String mortgageCode;// 押品代码

	private String parentCode;// 上级押品代码

	private String levels;// 押品等级

	private String slaveContcode;// 抵质押合同号

	private String secName;

	private String secCd;

	private String custcd;
	
	private List<BigDecimal> mortgageCodeList;//押品codeList

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMortgageCode() {
		return mortgageCode;
	}

	public void setMortgageCode(String mortgageCode) {
		this.mortgageCode = mortgageCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getSlaveContcode() {
		return slaveContcode;
	}

	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getSecCd() {
		return secCd;
	}

	public void setSecCd(String secCd) {
		this.secCd = secCd;
	}

	public String getCustcd() {
		return custcd;
	}

	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}

	@Override
	public String toString() {
		return "DataItemsDO [productId=" + productId + ", parentId=" + parentId + ", mortgageCode=" + mortgageCode + ", parentCode=" + parentCode
				+ ", levels=" + levels + ", secName=" + secName + ", secCd=" + secCd + ", custcd=" + custcd + "]";
	}

	public List<BigDecimal> getMortgageCodeList() {
		return mortgageCodeList;
	}

	public void setMortgageCodeList(List<BigDecimal> mortgageCodeList) {
		this.mortgageCodeList = mortgageCodeList;
	}

}
