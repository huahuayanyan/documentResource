package com.huateng.scf.bas.cnt.model;

import java.io.Serializable;

public class MonitorProtocolDO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String protocolCode;//监管合同号
    
    private String secName;//出质人名称
    
    private String thrName;//监管公司名称
    
    private String productId;//业务品种

	public String getProtocolCode() {
		return protocolCode;
	}

	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getThrName() {
		return thrName;
	}

	public void setThrName(String thrName) {
		this.thrName = thrName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "MonitorProtocolDO [protocolCode=" + protocolCode + ", secName=" + secName + ", thrName=" + thrName
				+ ", productId=" + productId + "]";
	}

}