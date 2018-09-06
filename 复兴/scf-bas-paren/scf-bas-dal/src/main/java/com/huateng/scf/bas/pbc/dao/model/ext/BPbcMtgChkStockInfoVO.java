package com.huateng.scf.bas.pbc.dao.model.ext;

import java.math.BigDecimal;

import com.huateng.scf.bas.pbc.dao.model.BPbcMtgChkStockInfo;

/**
 * 对账信息VO
 * @author gongzhao
 *
 */
public class BPbcMtgChkStockInfoVO extends BPbcMtgChkStockInfo{
 
	private static final long serialVersionUID = -6593345250431773549L;

	private String cname;//出质人名称
	private String prtclBrNm;//监管公司名称	
	private String prtclNo;//监管合同编号
	private String productId;//业务品种
	private BigDecimal mortgageTotAmount;//押品总价值
	private String tlrNm;//客户经理
	private String brNm;//经办机构名称
	private String vidPrdNm;//业务品种名称
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPrtclBrNm() {
		return prtclBrNm;
	}
	public void setPrtclBrNm(String prtclBrNm) {
		this.prtclBrNm = prtclBrNm;
	}
	public String getPrtclNo() {
		return prtclNo;
	}
	public void setPrtclNo(String prtclNo) {
		this.prtclNo = prtclNo;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public BigDecimal getMortgageTotAmount() {
		return mortgageTotAmount;
	}
	public void setMortgageTotAmount(BigDecimal mortgageTotAmount) {
		this.mortgageTotAmount = mortgageTotAmount;
	}
	public String getTlrNm() {
		return tlrNm;
	}
	public void setTlrNm(String tlrNm) {
		this.tlrNm = tlrNm;
	}
	public String getBrNm() {
		return brNm;
	}
	public void setBrNm(String brNm) {
		this.brNm = brNm;
	}
	public String getVidPrdNm() {
		return vidPrdNm;
	}
	public void setVidPrdNm(String vidPrdNm) {
		this.vidPrdNm = vidPrdNm;
	}
	
}
