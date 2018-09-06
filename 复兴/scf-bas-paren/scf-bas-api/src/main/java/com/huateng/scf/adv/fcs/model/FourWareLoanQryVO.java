/**
 * 
 */
package com.huateng.scf.adv.fcs.model;

import java.math.BigDecimal;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * <p>四方保兑仓VO类</p>
 *
 * @author 	shangxiujuan
 * @date 2017年5月4日下午4:41:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年5月4日下午4:41:02              新增
 *
 * </pre>
 */
public class FourWareLoanQryVO extends CommonQryVO{

	private static final long serialVersionUID = -7535151073096535464L;
	private String appno;//协议号
	private String debetNo;//借据号
	private String mortgageNo;//押品编号
	private String slaveContcode;//抵质押合同号
	private String monitorProtocolCode;//监管协议号
	private String otherProtocolNo;//关联协议
	private String protocolType;//协议类型
	private String tradeContno;//购销合同号
	private String tradeContcode;//购销合同编号
	private String coreCustcd;//核心厂商ID
	private String custName;//经销商名称
	private String coreCustName;//核心厂商名称
	private String status;//状态
	private String noticeType;//通知书类型
	private String num;//通知书编号
	private BigDecimal lnciAmtFrom;//借据金额从
	private BigDecimal lnciAmtTo;//借据金额到
	private String startDate;//开始日期
	private String endDate;//结束日期
	private String supplyChainPdId;//业务品种

	private String loanWay; //出账方式
	private String endStartDate; //到期日起/止
	private String endEndDate;
	private BigDecimal amtOutTo; //累计出账金额起/止
	private BigDecimal amtOutFrom;
	private String confirmStatus; //收款确认状态
	private String brname; //经办机构

	private String monitCname;//监管公司名称
	private String opFlag; //台账查询操作标识
	private String deliFlag; //提货标识

	private String commonDateStart;//收款日期 起
	private String commonDateEnd;//收款日期 止

	private String channelFlag;




	public String getDeliFlag() {
		return deliFlag;
	}

	public void setDeliFlag(String deliFlag) {
		this.deliFlag = deliFlag;
	}

	public String getCommonDateStart() {
		return commonDateStart;
	}

	public void setCommonDateStart(String commonDateStart) {
		this.commonDateStart = commonDateStart;
	}

	public String getCommonDateEnd() {
		return commonDateEnd;
	}

	public void setCommonDateEnd(String commonDateEnd) {
		this.commonDateEnd = commonDateEnd;
	}

	public String getChannelFlag() {
		return channelFlag;
	}

	public void setChannelFlag(String channelFlag) {
		this.channelFlag = channelFlag;
	}

	public FourWareLoanQryVO() {
	}

	public String getDebetNo() {
		return debetNo;
	}
	public void setDebetNo(String debetNo) {
		this.debetNo = debetNo;
	}
	public String getTradeContno() {
		return tradeContno;
	}
	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno;
	}
	public String getCoreCustcd() {
		return coreCustcd;
	}
	public void setCoreCustcd(String coreCustcd) {
		this.coreCustcd = coreCustcd;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCoreCustName() {
		return coreCustName;
	}
	public void setCoreCustName(String coreCustName) {
		this.coreCustName = coreCustName;
	}

	public String getMonitorProtocolCode() {
		return monitorProtocolCode;
	}
	public void setMonitorProtocolCode(String monitorProtocolCode) {
		this.monitorProtocolCode = monitorProtocolCode;
	}
	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getOtherProtocolNo() {
		return otherProtocolNo;
	}
	public void setOtherProtocolNo(String otherProtocolNo) {
		this.otherProtocolNo = otherProtocolNo;
	}
	public String getProtocolType() {
		return protocolType;
	}
	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTradeContcode() {
		return tradeContcode;
	}
	public void setTradeContcode(String tradeContcode) {
		this.tradeContcode = tradeContcode;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public BigDecimal getLnciAmtFrom() {
		return lnciAmtFrom;
	}

	public void setLnciAmtFrom(BigDecimal lnciAmtFrom) {
		this.lnciAmtFrom = lnciAmtFrom;
	}

	public BigDecimal getLnciAmtTo() {
		return lnciAmtTo;
	}

	public void setLnciAmtTo(BigDecimal lnciAmtTo) {
		this.lnciAmtTo = lnciAmtTo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getMortgageNo() {
		return mortgageNo;
	}

	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo;
	}

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}

	public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay;
	}

	public String getEndStartDate() {
		return endStartDate;
	}

	public void setEndStartDate(String endStartDate) {
		this.endStartDate = endStartDate;
	}

	public String getEndEndDate() {
		return endEndDate;
	}

	public void setEndEndDate(String endEndDate) {
		this.endEndDate = endEndDate;
	}

	public BigDecimal getAmtOutTo() {
		return amtOutTo;
	}

	public void setAmtOutTo(BigDecimal amtOutTo) {
		this.amtOutTo = amtOutTo;
	}

	public BigDecimal getAmtOutFrom() {
		return amtOutFrom;
	}

	public void setAmtOutFrom(BigDecimal amtOutFrom) {
		this.amtOutFrom = amtOutFrom;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getBrname() {
		return brname;
	}

	public void setBrname(String brname) {
		this.brname = brname;
	}

	public String getMonitCname() {
		return monitCname;
	}

	public void setMonitCname(String monitCname) {
		this.monitCname = monitCname;
	}

	public String getOpFlag() {
		return opFlag;
	}

	public void setOpFlag(String opFlag) {
		this.opFlag = opFlag;
	}

	/**
	 * @return the slaveContcode
	 */
	public String getSlaveContcode() {
		return slaveContcode;
	}

	/**
	 * @param slaveContcode the slaveContcode to set
	 */
	public void setSlaveContcode(String slaveContcode) {
		this.slaveContcode = slaveContcode;
	}

}
