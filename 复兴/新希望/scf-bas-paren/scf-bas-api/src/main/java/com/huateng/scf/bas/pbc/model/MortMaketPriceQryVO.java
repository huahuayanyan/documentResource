package com.huateng.scf.bas.pbc.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class MortMaketPriceQryVO extends CommonQryVO{
	
	public MortMaketPriceQryVO(){}

	private String mortgageLevelOne_Q;//押品一级
	private String mortgageLevelTwo_Q;//押品二级
	private String mortgageLevelThree_Q;//押品三级
	private String productName_Q;//产品名称
	private String productId_Q;//盯市编号
	private String mortgageLevelThreeName_Q;//押品三级名称
	private String marketPriceSrc_Q;//市价来源

	public String getMortgageLevelOne_Q() {
		return mortgageLevelOne_Q;
	}
	public void setMortgageLevelOne_Q(String mortgageLevelOne_Q) {
		this.mortgageLevelOne_Q = mortgageLevelOne_Q;
	}
	public String getMortgageLevelTwo_Q() {
		return mortgageLevelTwo_Q;
	}
	public void setMortgageLevelTwo_Q(String mortgageLevelTwo_Q) {
		this.mortgageLevelTwo_Q = mortgageLevelTwo_Q;
	}
	public String getMortgageLevelThree_Q() {
		return mortgageLevelThree_Q;
	}
	public void setMortgageLevelThree_Q(String mortgageLevelThree_Q) {
		this.mortgageLevelThree_Q = mortgageLevelThree_Q;
	}
	public String getProductName_Q() {
		return productName_Q;
	}
	public void setProductName_Q(String productName_Q) {
		this.productName_Q = productName_Q;
	}
	public String getProductId_Q() {
		return productId_Q;
	}
	public void setProductId_Q(String productId_Q) {
		this.productId_Q = productId_Q;
	}
	public String getMortgageLevelThreeName_Q() {
		return mortgageLevelThreeName_Q;
	}
	public void setMortgageLevelThreeName_Q(String mortgageLevelThreeName_Q) {
		this.mortgageLevelThreeName_Q = mortgageLevelThreeName_Q;
	}
	public String getMarketPriceSrc_Q() {
		return marketPriceSrc_Q;
	}
	public void setMarketPriceSrc_Q(String marketPriceSrc_Q) {
		this.marketPriceSrc_Q = marketPriceSrc_Q;
	}

}
