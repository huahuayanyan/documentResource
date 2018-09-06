package com.huateng.scf.bas.crm.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

public class CustomerQryVO extends CommonQryVO {

	private String custRole_Q;// 客户角色
	private String custno_Q;// 核心客户号
	private String cname_Q;// 客户名称
	private String orgCode_Q;// 组织机构代码
	private String value;//输入值
	private String custType_Q;
	private String custClass_Q;
	private String id_Q;
	private String secCd_Q;
	private String industryType_Q;
	private String queryType_Q;

	private String custStatus_Q;
	private String coreFlag_Q;
	private String supplyPosition_Q;////供应链所处位置 01 上游；02下游
	private String otherCustcd_Q;// 关联关系客户
	private String otherCname_Q; // 关系客户名称
	
	private String creditFlag_Q;//授信客户标识
	private String blackFlag_Q;//黑名单标识
	private String insureFlag_Q;//是否保险公司0-否、1-是
	private String factorFlag_Q;//是否保理商
	private String importantFlag_Q;//是否贸易融资重点客户
	private String commercialFlag_Q;//是否贸易对手
	private String overseasFlag_Q;//是否境外
	private String banksCustFlag_Q;//是否是本行客户
	private String efBuyerFlag_Q;//是否EF进口商
	private String ifSellerFlag_Q;//是否IF出库商
	
	private java.lang.String efName_Q;//EF名称
	private java.lang.String fciCode_Q;//EF名称	
	
	public String getCname_Q() {
		return cname_Q;
	}

	public void setCname_Q(String cname_Q) {
		this.cname_Q = cname_Q;
	}

	public String getOtherCustcd_Q() {
		return otherCustcd_Q;
	}

	public void setOtherCustcd_Q(String otherCustcd_Q) {
		this.otherCustcd_Q = otherCustcd_Q;
	}

	public String getOtherCname_Q() {
		return otherCname_Q;
	}

	public void setOtherCname_Q(String otherCname_Q) {
		this.otherCname_Q = otherCname_Q;
	}

	public java.lang.String getFciCode_Q() {
		return fciCode_Q;
	}

	public void setFciCode_Q(java.lang.String fciCode_Q) {
		this.fciCode_Q = fciCode_Q;
	}

	public CustomerQryVO() {

	}


	public String getCustRole_Q() {
		return custRole_Q;
	}

	public void setCustRole_Q(String custRole_Q) {
		this.custRole_Q = custRole_Q;
	}

	public String getCustno_Q() {
		return custno_Q;
	}

	public void setCustno_Q(String custno_Q) {
		this.custno_Q = custno_Q;
	}

	public String getOrgCode_Q() {
		return orgCode_Q;
	}

	public void setOrgCode_Q(String orgCode_Q) {
		this.orgCode_Q = orgCode_Q;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCustType_Q() {
		return custType_Q;
	}

	public void setCustType_Q(String custType_Q) {
		this.custType_Q = custType_Q;
	}

	public String getCustClass_Q() {
		return custClass_Q;
	}

	public void setCustClass_Q(String custClass_Q) {
		this.custClass_Q = custClass_Q;
	}

	public String getId_Q() {
		return id_Q;
	}

	public void setId_Q(String id_Q) {
		this.id_Q = id_Q;
	}

	public String getSecCd_Q() {
		return secCd_Q;
	}

	public void setSecCd_Q(String secCd_Q) {
		this.secCd_Q = secCd_Q;
	}

	public String getIndustryType_Q() {
		return industryType_Q;
	}

	public void setIndustryType_Q(String industryType_Q) {
		this.industryType_Q = industryType_Q;
	}

	public String getQueryType_Q() {
		return queryType_Q;
	}

	public void setQueryType_Q(String queryType_Q) {
		this.queryType_Q = queryType_Q;
	}

	public String getCustStatus_Q() {
		return custStatus_Q;
	}

	public void setCustStatus_Q(String custStatus_Q) {
		this.custStatus_Q = custStatus_Q;
	}

	public String getCoreFlag_Q() {
		return coreFlag_Q;
	}

	public void setCoreFlag_Q(String coreFlag_Q) {
		this.coreFlag_Q = coreFlag_Q;
	}

	public String getSupplyPosition_Q() {
		return supplyPosition_Q;
	}

	public void setSupplyPosition_Q(String supplyPosition_Q) {
		this.supplyPosition_Q = supplyPosition_Q;
	}

	public String getCreditFlag_Q() {
		return creditFlag_Q;
	}

	public void setCreditFlag_Q(String creditFlag_Q) {
		this.creditFlag_Q = creditFlag_Q;
	}

	public String getBlackFlag_Q() {
		return blackFlag_Q;
	}

	public void setBlackFlag_Q(String blackFlag_Q) {
		this.blackFlag_Q = blackFlag_Q;
	}

	public String getInsureFlag_Q() {
		return insureFlag_Q;
	}

	public void setInsureFlag_Q(String insureFlag_Q) {
		this.insureFlag_Q = insureFlag_Q;
	}

	public String getFactorFlag_Q() {
		return factorFlag_Q;
	}

	public void setFactorFlag_Q(String factorFlag_Q) {
		this.factorFlag_Q = factorFlag_Q;
	}

	public String getImportantFlag_Q() {
		return importantFlag_Q;
	}

	public void setImportantFlag_Q(String importantFlag_Q) {
		this.importantFlag_Q = importantFlag_Q;
	}

	public String getCommercialFlag_Q() {
		return commercialFlag_Q;
	}

	public void setCommercialFlag_Q(String commercialFlag_Q) {
		this.commercialFlag_Q = commercialFlag_Q;
	}

	public String getOverseasFlag_Q() {
		return overseasFlag_Q;
	}

	public void setOverseasFlag_Q(String overseasFlag_Q) {
		this.overseasFlag_Q = overseasFlag_Q;
	}

	public String getBanksCustFlag_Q() {
		return banksCustFlag_Q;
	}

	public void setBanksCustFlag_Q(String banksCustFlag_Q) {
		this.banksCustFlag_Q = banksCustFlag_Q;
	}

	public String getEfBuyerFlag_Q() {
		return efBuyerFlag_Q;
	}

	public void setEfBuyerFlag_Q(String efBuyerFlag_Q) {
		this.efBuyerFlag_Q = efBuyerFlag_Q;
	}

	public String getIfSellerFlag_Q() {
		return ifSellerFlag_Q;
	}

	public void setIfSellerFlag_Q(String ifSellerFlag_Q) {
		this.ifSellerFlag_Q = ifSellerFlag_Q;
	}

	public java.lang.String getEfName_Q() {
		return efName_Q;
	}

	public void setEfName_Q(java.lang.String efName_Q) {
		this.efName_Q = efName_Q;
	}

	
	
	
}

