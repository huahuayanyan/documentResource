package com.huateng.scf.bas.cnt.dao.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.common.dao.model.CommonQryVO;


/**
 * <p></p>
 *
 * @author 	huangshuidan
 * @date 2016年11月22日下午4:20:53	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午4:20:53              新增
 *
 * </pre>
 */
public class DeliveryQryVO extends CommonQryVO{
	private static final long serialVersionUID = -8033449740444574847L;
	private String coreCustcd;//核心厂商
	private String fouCd;//回购厂商
	private String debetNo;//借据号
	private BigDecimal amount1;//金额从
	private BigDecimal amount2;//金额止
	private String appno;//申请编号
	private String loanWay;//出账方式
	private String startDate;//出账日期
	private String startDate1;//日期起
	private String startDate2;//日期止
	private String startDate3;//日期3
	private String startDate4;//日期4
	private String tradeContno;//购销合同号
	private String status;//状态
	private String debetId;//借据号
	private String coreNm;//核心厂商客户名称
	private String buyBackNm;//回购厂商名称
	private String bussTypeName;
	private String operationType;//操作类型
	private String businessNo;//关联业务合同号
	private String id;
	private String state;//协议状态
	private String sellerNm;//买方名称
	private String fouName;//担保方名称
	private String protocolNo;//担保提货协议号
	private String brcode;
	private String protocolCode;
	
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public DeliveryQryVO() {
		
	}
	public DeliveryQryVO(String coreCustcd, String fouCd, String debetNo, String startDate1, String startDate2,
			BigDecimal amount1, BigDecimal amount2, String appno, String loanWay, String startDate, String startDate3,
			String startDate4, String tradeContno, String status, String debetId, String coreNm, String buyBackNm,
			String bussTypeName, String operationType, String businessNo, String id, String state) {
		this.coreCustcd = coreCustcd;
		this.fouCd = fouCd;
		this.debetNo = debetNo;
		this.startDate1 = startDate1;
		this.startDate2 = startDate2;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.appno = appno;
		this.loanWay = loanWay;
		this.startDate = startDate;
		this.startDate3 = startDate3;
		this.startDate4 = startDate4;
		this.tradeContno = tradeContno;
		this.status = status;
		this.debetId = debetId;
		this.coreNm = coreNm;
		this.buyBackNm = buyBackNm;
		this.bussTypeName = bussTypeName;
		this.operationType = operationType;
		this.businessNo = businessNo;
		this.id = id;
		this.state = state;
	}
	/**
	 * @return the coreCustcd
	 */
	public String getCoreCustcd() {
		return coreCustcd;
	}
	/**
	 * @param coreCustcd the coreCustcd to set
	 */
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	/**
	 * @return the fouCd
	 */
	public String getFouCd() {
		return fouCd;
	}
	/**
	 * @param fouCd the fouCd to set
	 */
	public void setFouCd(String fouCd) {
		this.fouCd = fouCd;
	}
	/**
	 * @return the debetNo
	 */
	public String getDebetNo() {
		return debetNo;
	}
	/**
	 * @param debetNo the debetNo to set
	 */
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	/**
	 * @return the startDate1
	 */
	public String getStartDate1() {
		return startDate1;
	}
	/**
	 * @param startDate1 the startDate1 to set
	 */
	public void setStartDate1(String startDate1) {
		this.startDate1 = startDate1;
	}
	/**
	 * @return the startDate2
	 */
	public String getStartDate2() {
		return startDate2;
	}
	/**
	 * @param startDate2 the startDate2 to set
	 */
	public void setStartDate2(String startDate2) {
		this.startDate2 = startDate2;
	}
	/**
	 * @return the amount1
	 */
	public BigDecimal getAmount1() {
		return amount1;
	}
	/**
	 * @param amount1 the amount1 to set
	 */
	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}
	/**
	 * @return the amount2
	 */
	public BigDecimal getAmount2() {
		return amount2;
	}
	/**
	 * @param amount2 the amount2 to set
	 */
	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}
	/**
	 * @return the appno
	 */
	public String getAppno() {
		return appno;
	}
	/**
	 * @param appno the appno to set
	 */
	public void setAppno(String appno) {
		this.appno = appno;
	}
	/**
	 * @return the loanWay
	 */
	public String getLoanWay() {
		return loanWay;
	}
	/**
	 * @param loanWay the loanWay to set
	 */
	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the startDate3
	 */
	public String getStartDate3() {
		return startDate3;
	}
	/**
	 * @param startDate3 the startDate3 to set
	 */
	public void setStartDate3(String startDate3) {
		this.startDate3 = startDate3;
	}
	/**
	 * @return the startDate4
	 */
	public String getStartDate4() {
		return startDate4;
	}
	/**
	 * @param startDate4 the startDate4 to set
	 */
	public void setStartDate4(String startDate4) {
		this.startDate4 = startDate4;
	}
	/**
	 * @return the tradeContno
	 */
	public String getTradeContno() {
		return tradeContno;
	}
	/**
	 * @param tradeContno the tradeContno to set
	 */
	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the debetId
	 */
	public String getDebetId() {
		return debetId;
	}
	/**
	 * @param debetId the debetId to set
	 */
	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
	/**
	 * @return the coreNm
	 */
	public String getCoreNm() {
		return coreNm;
	}
	/**
	 * @param coreNm the coreNm to set
	 */
	public void setCoreNm(String coreNm) {
		this.coreNm = coreNm;
	}
	/**
	 * @return the buyBackNm
	 */
	public String getBuyBackNm() {
		return buyBackNm;
	}
	/**
	 * @param buyBackNm the buyBackNm to set
	 */
	public void setBuyBackNm(String buyBackNm) {
		this.buyBackNm = buyBackNm;
	}
	/**
	 * @return the bussTypeName
	 */
	public String getBussTypeName() {
		return bussTypeName;
	}
	/**
	 * @param bussTypeName the bussTypeName to set
	 */
	public void setBussTypeName(String bussTypeName) {
		this.bussTypeName = bussTypeName;
	}
	/**
	 * @return the operationType
	 */
	public String getOperationType() {
		return operationType;
	}
	/**
	 * @param operationType the operationType to set
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	/**
	 * @return the businessNo
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * @param businessNo the businessNo to set
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the sellerNm
	 */
	public String getSellerNm() {
		return sellerNm;
	}
	/**
	 * @param sellerNm the sellerNm to set
	 */
	public void setSellerNm(String sellerNm) {
		this.sellerNm = sellerNm;
	}
	/**
	 * @return the fouName
	 */
	public String getFouName() {
		return fouName;
	}
	/**
	 * @param fouName the fouName to set
	 */
	public void setFouName(String fouName) {
		this.fouName = fouName;
	}
	/**
	 * @return the protocolNo
	 */
	public String getProtocolNo() {
		return protocolNo;
	}
	/**
	 * @param protocolNo the protocolNo to set
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	public String getProtocolCode() {
		return protocolCode;
	}
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}
	
	
	
	
	
	
	
}
