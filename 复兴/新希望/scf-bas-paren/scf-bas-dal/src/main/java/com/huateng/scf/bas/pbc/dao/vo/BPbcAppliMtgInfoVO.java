package com.huateng.scf.bas.pbc.dao.vo;

import java.math.BigDecimal;

import com.huateng.scf.bas.pbc.dao.model.BPbcAppliMtgInfo;

public class BPbcAppliMtgInfoVO extends BPbcAppliMtgInfo {
    private static final long serialVersionUID = 1L;

    private String billcode;

	private String cname;
    
    private BigDecimal invQuantity;//数量
    private BigDecimal totChangePrice;//调整后总价值
    private BigDecimal afterConfirmPrice;//调价后单价
    

	public BigDecimal getTotChangePrice() {
		return totChangePrice;
	}

	public void setTotChangePrice(BigDecimal totChangePrice) {
		this.totChangePrice = totChangePrice;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

    public String getBillcode() {
		return billcode;
	}

	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}

	private String mortgageLevelOneName;
    private String mortgageLevelTwoName;
    
    public String getMortgageLevelOneName() {
		return mortgageLevelOneName;
	}

	public void setMortgageLevelOneName(String mortgageLevelOneName) {
		this.mortgageLevelOneName = mortgageLevelOneName;
	}

	public String getMortgageLevelTwoName() {
		return mortgageLevelTwoName;
	}

	public void setMortgageLevelTwoName(String mortgageLevelTwoName) {
		this.mortgageLevelTwoName = mortgageLevelTwoName;
	}

	public BigDecimal getAfterConfirmPrice() {
		return afterConfirmPrice;
	}

	public void setAfterConfirmPrice(BigDecimal afterConfirmPrice) {
		this.afterConfirmPrice = afterConfirmPrice;
	}

	public BigDecimal getInvQuantity() {
		return invQuantity;
	}

	public void setInvQuantity(BigDecimal invQuantity) {
		this.invQuantity = invQuantity;
	}
}