package com.huateng.scf.bas.cnt.dao.model.ext;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 三方保兑仓协议
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月22日下午4:24:51
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午4:24:51              新增
 *
 *            </pre>
 */
public class MonitorProtocolInfo implements Serializable {
	private static final long serialVersionUID = 5172307236300515578L;
	private String protocolNo;
	private String protocolCode;// 监管合同号
	private String productId;// 业务品种
	private String productName;// 业务品种名称
	private String moniType;// 货押模式
	private String curcdNm;// 币种
	private String secName;// 出质人名称
	private String secCd;// 出质人编号
	private String thrName;// 监管公司名称
	private String thrCode;// 监管公司编号
	private String moniOfCustCd;// 监管公司编号
	private String startDate;// 合同生效日
	private String endDate;// 合同到期日
	private String sellOffFlag;// 是否签订委托变卖协议
	private String isPledge;// 是否抵押
	private String state;// 合同状态
	private String cooperationBrcode;// 合作机构号
	private String cooperationBrcodeNm;// 合作机构
	private String tlrNo;// 客户经理编号
	private String tlrName;// 客户经理
	private String brcode;// 经办机构号
	private String brcodeNm;// 经办机构
	private String warehouseType;// 场地权属类型
	private BigDecimal priceDropRate;// 价格跌幅预警（%）
	private String logisticsMoniCondition;// 物流监管条件
	private String levels;// 监管公司等级
	private String monitorArea;// 监管区域
	private String monitortype;// 监管模式
	private String detailMonitorArea;// 具体监管区域（省/市）
	private BigDecimal limitSum;// 监管限额(元)
	private String monitorStatus;// 合作状态
	private String levelCogniDate;// 等级认定日
	private String levelEndDate;// 等级到期日
	private String otherDes;// 备注
	private String otherprotocolNo;//先票/款后货协议号
	
	public String getProtocolNo() {
		return protocolNo;
	}

	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}

	public String getProtocolCode() {
		return protocolCode;
	}

	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMoniType() {
		return moniType;
	}

	public void setMoniType(String moniType) {
		this.moniType = moniType;
	}

	public String getCurcdNm() {
		return curcdNm;
	}

	public void setCurcdNm(String curcdNm) {
		this.curcdNm = curcdNm;
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

	public String getThrName() {
		return thrName;
	}

	public void setThrName(String thrName) {
		this.thrName = thrName;
	}

	public String getThrCode() {
		return thrCode;
	}

	public void setThrCode(String thrCode) {
		this.thrCode = thrCode;
	}

	public String getMoniOfCustCd() {
		return moniOfCustCd;
	}

	public void setMoniOfCustCd(String moniOfCustCd) {
		this.moniOfCustCd = moniOfCustCd;
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

	public String getSellOffFlag() {
		return sellOffFlag;
	}

	public void setSellOffFlag(String sellOffFlag) {
		this.sellOffFlag = sellOffFlag;
	}

	public String getIsPledge() {
		return isPledge;
	}

	public void setIsPledge(String isPledge) {
		this.isPledge = isPledge;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCooperationBrcode() {
		return cooperationBrcode;
	}

	public void setCooperationBrcode(String cooperationBrcode) {
		this.cooperationBrcode = cooperationBrcode;
	}

	public String getCooperationBrcodeNm() {
		return cooperationBrcodeNm;
	}

	public void setCooperationBrcodeNm(String cooperationBrcodeNm) {
		this.cooperationBrcodeNm = cooperationBrcodeNm;
	}

	public String getTlrNo() {
		return tlrNo;
	}

	public void setTlrNo(String tlrNo) {
		this.tlrNo = tlrNo;
	}

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

	public String getBrcodeNm() {
		return brcodeNm;
	}

	public void setBrcodeNm(String brcodeNm) {
		this.brcodeNm = brcodeNm;
	}

	public String getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(String warehouseType) {
		this.warehouseType = warehouseType;
	}

	public BigDecimal getPriceDropRate() {
		return priceDropRate;
	}

	public void setPriceDropRate(BigDecimal priceDropRate) {
		this.priceDropRate = priceDropRate;
	}

	public String getLogisticsMoniCondition() {
		return logisticsMoniCondition;
	}

	public void setLogisticsMoniCondition(String logisticsMoniCondition) {
		this.logisticsMoniCondition = logisticsMoniCondition;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getMonitorArea() {
		return monitorArea;
	}

	public void setMonitorArea(String monitorArea) {
		this.monitorArea = monitorArea;
	}

	public String getMonitortype() {
		return monitortype;
	}

	public void setMonitortype(String monitortype) {
		this.monitortype = monitortype;
	}

	public String getDetailMonitorArea() {
		return detailMonitorArea;
	}

	public void setDetailMonitorArea(String detailMonitorArea) {
		this.detailMonitorArea = detailMonitorArea;
	}

	public BigDecimal getLimitSum() {
		return limitSum;
	}

	public void setLimitSum(BigDecimal limitSum) {
		this.limitSum = limitSum;
	}

	public String getMonitorStatus() {
		return monitorStatus;
	}

	public void setMonitorStatus(String monitorStatus) {
		this.monitorStatus = monitorStatus;
	}

	public String getLevelCogniDate() {
		return levelCogniDate;
	}

	public void setLevelCogniDate(String levelCogniDate) {
		this.levelCogniDate = levelCogniDate;
	}

	public String getLevelEndDate() {
		return levelEndDate;
	}

	public void setLevelEndDate(String levelEndDate) {
		this.levelEndDate = levelEndDate;
	}

	public String getOtherDes() {
		return otherDes;
	}

	public void setOtherDes(String otherDes) {
		this.otherDes = otherDes;
	}

	@Override
	public String toString() {
		return "MonitorProtocolInfo [protocolNo=" + protocolNo + ", protocolCode=" + protocolCode + ", productId=" + productId + ", productName="
				+ productName + ", moniType=" + moniType + ", curcdNm=" + curcdNm + ", secName=" + secName + ", secCd=" + secCd + ", thrName="
				+ thrName + ", thrCode=" + thrCode + ", moniOfCustCd=" + moniOfCustCd + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", sellOffFlag=" + sellOffFlag + ", isPledge=" + isPledge + ", state=" + state + ", cooperationBrcode=" + cooperationBrcode
				+ ", cooperationBrcodeNm=" + cooperationBrcodeNm + ", tlrNo=" + tlrNo + ", tlrName=" + tlrName + ", brcode=" + brcode + ", brcodeNm="
				+ brcodeNm + ", warehouseType=" + warehouseType + ", priceDropRate=" + priceDropRate + ", logisticsMoniCondition="
				+ logisticsMoniCondition + ", levels=" + levels + ", monitorArea=" + monitorArea + ", monitortype=" + monitortype
				+ ", detailMonitorArea=" + detailMonitorArea + ", limitSum=" + limitSum + ", monitorStatus=" + monitorStatus + ", levelCogniDate="
				+ levelCogniDate + ", levelEndDate=" + levelEndDate + ", otherDes=" + otherDes + "]";
	}

	public String getOtherprotocolNo() {
		return otherprotocolNo;
	}

	public void setOtherprotocolNo(String otherprotocolNo) {
		this.otherprotocolNo = otherprotocolNo;
	}

}
