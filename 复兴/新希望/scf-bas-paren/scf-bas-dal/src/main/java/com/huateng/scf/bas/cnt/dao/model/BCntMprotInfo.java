package com.huateng.scf.bas.cnt.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCntMprotInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(20) 必填<br>
	 * 货物ID
	 */
	private String mortgageNo;

	/**
	 * VARCHAR(20)<br>
	 * 购销合同号
	 */
	private String tradeContno;
	/**
	 * VARCHAR(20)<br>
	 * 购销合同号(真正的购销合同号)
	 */
	private String tradeContcode;

	/**
	 * VARCHAR(20)<br>
	 * 三方/四方协议号
	 */
	private String protocolNo;

	/**
	 * VARCHAR(100)<br>
	 * 押品名称
	 */
	private String mortgageName;

	/**
	 * VARCHAR(100)<br>
	 * 押品一级
	 */
	private String mortgageLevelOne;
	/**
	 * VARCHAR(100)<br>
	 * 押品一级名称
	 */
	private String mortgageLevelOneNm;

	/**
	 * VARCHAR(100)<br>
	 * 押品二级
	 */
	private String mortgageLevelTwo;
	/**
	 * VARCHAR(100)<br>
	 * 押品二级名称
	 */
	private String mortgageLevelTwoNm;

	/**
	 * VARCHAR(100)<br>
	 * 押品三级
	 */
	private String mortgageLevelThree;

	/**
	 * VARCHAR(100)<br>
	 * 押品四级
	 */
	private String mortgageLevelFour;

	/**
	 * VARCHAR(100)<br>
	 * 规格/型号
	 */
	private String mortgageModel;

	/**
	 * DECIMAL(16,2)<br>
	 * 数量/重量
	 */
	private BigDecimal quantity;

	/**
	 * DECIMAL(16,2)<br>
	 * 单价
	 */
	private BigDecimal price;

	/**
	 * DECIMAL(16,2)<br>
	 * 总价
	 */
	private BigDecimal totPrice;

	/**
	 * VARCHAR(50)<br>
	 * 单位
	 */
	private String mortgageUnits;

	/**
	 * DECIMAL(16,2)<br>
	 * 质押总额
	 */
	private BigDecimal pledgedAmount;

	/**
	 * CHAR(3)<br>
	 * 币种
	 */
	private String curcd;

	/**
	 * DECIMAL(16,2)<br>
	 * 剩余总价
	 */
	private BigDecimal balAmount;

	/**
	 * DECIMAL(16,2)<br>
	 * 剩余数量
	 */
	private BigDecimal balQuantity;

	/**
	 * VARCHAR(200)<br>
	 * 合格证号
	 */
	private String certificationNo;

	/**
	 * VARCHAR(200)<br>
	 * 车架号
	 */
	private String chassisNo;

	/**
	 * VARCHAR(80)<br>
	 * 生产厂家
	 */
	private String manufacturer;

	/**
	 * CHAR(8)<br>
	 * 出厂日期
	 */
	private String manufactureDate;

	/**
	 * VARCHAR(20) 必填<br>
	 * 获得 货物ID
	 */
	public String getMortgageNo() {
		return mortgageNo;
	}

	/**
	 * VARCHAR(20) 必填<br>
	 * 设置 货物ID
	 */
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo == null ? null : mortgageNo.trim();
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 购销合同号
	 */
	public String getTradeContno() {
		return tradeContno;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 购销合同号
	 */
	public void setTradeContno(String tradeContno) {
		this.tradeContno = tradeContno == null ? null : tradeContno.trim();
	}

	public String getTradeContcode() {
		return tradeContcode;
	}

	public void setTradeContcode(String tradeContcode) {
		this.tradeContcode = tradeContcode;
	}

	/**
	 * VARCHAR(20)<br>
	 * 获得 三方/四方协议号
	 */
	public String getProtocolNo() {
		return protocolNo;
	}

	/**
	 * VARCHAR(20)<br>
	 * 设置 三方/四方协议号
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo == null ? null : protocolNo.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品名称
	 */
	public String getMortgageName() {
		return mortgageName;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品名称
	 */
	public void setMortgageName(String mortgageName) {
		this.mortgageName = mortgageName == null ? null : mortgageName.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品一级
	 */
	public String getMortgageLevelOne() {
		return mortgageLevelOne;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品一级
	 */
	public void setMortgageLevelOne(String mortgageLevelOne) {
		this.mortgageLevelOne = mortgageLevelOne == null ? null : mortgageLevelOne.trim();
	}

	public String getMortgageLevelOneNm() {
		return mortgageLevelOneNm;
	}

	public void setMortgageLevelOneNm(String mortgageLevelOneNm) {
		this.mortgageLevelOneNm = mortgageLevelOneNm;
	}

	public String getMortgageLevelTwoNm() {
		return mortgageLevelTwoNm;
	}

	public void setMortgageLevelTwoNm(String mortgageLevelTwoNm) {
		this.mortgageLevelTwoNm = mortgageLevelTwoNm;
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品二级
	 */
	public String getMortgageLevelTwo() {
		return mortgageLevelTwo;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品二级
	 */
	public void setMortgageLevelTwo(String mortgageLevelTwo) {
		this.mortgageLevelTwo = mortgageLevelTwo == null ? null : mortgageLevelTwo.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品三级
	 */
	public String getMortgageLevelThree() {
		return mortgageLevelThree;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品三级
	 */
	public void setMortgageLevelThree(String mortgageLevelThree) {
		this.mortgageLevelThree = mortgageLevelThree == null ? null : mortgageLevelThree.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 押品四级
	 */
	public String getMortgageLevelFour() {
		return mortgageLevelFour;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 押品四级
	 */
	public void setMortgageLevelFour(String mortgageLevelFour) {
		this.mortgageLevelFour = mortgageLevelFour == null ? null : mortgageLevelFour.trim();
	}

	/**
	 * VARCHAR(100)<br>
	 * 获得 规格/型号
	 */
	public String getMortgageModel() {
		return mortgageModel;
	}

	/**
	 * VARCHAR(100)<br>
	 * 设置 规格/型号
	 */
	public void setMortgageModel(String mortgageModel) {
		this.mortgageModel = mortgageModel == null ? null : mortgageModel.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 数量/重量
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 数量/重量
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 单价
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 单价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 总价
	 */
	public BigDecimal getTotPrice() {
		return totPrice;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 总价
	 */
	public void setTotPrice(BigDecimal totPrice) {
		this.totPrice = totPrice;
	}

	/**
	 * VARCHAR(50)<br>
	 * 获得 单位
	 */
	public String getMortgageUnits() {
		return mortgageUnits;
	}

	/**
	 * VARCHAR(50)<br>
	 * 设置 单位
	 */
	public void setMortgageUnits(String mortgageUnits) {
		this.mortgageUnits = mortgageUnits == null ? null : mortgageUnits.trim();
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 质押总额
	 */
	public BigDecimal getPledgedAmount() {
		return pledgedAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 质押总额
	 */
	public void setPledgedAmount(BigDecimal pledgedAmount) {
		this.pledgedAmount = pledgedAmount;
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
	 * DECIMAL(16,2)<br>
	 * 获得 剩余总价
	 */
	public BigDecimal getBalAmount() {
		return balAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 剩余总价
	 */
	public void setBalAmount(BigDecimal balAmount) {
		this.balAmount = balAmount;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 获得 剩余数量
	 */
	public BigDecimal getBalQuantity() {
		return balQuantity;
	}

	/**
	 * DECIMAL(16,2)<br>
	 * 设置 剩余数量
	 */
	public void setBalQuantity(BigDecimal balQuantity) {
		this.balQuantity = balQuantity;
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 合格证号
	 */
	public String getCertificationNo() {
		return certificationNo;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 合格证号
	 */
	public void setCertificationNo(String certificationNo) {
		this.certificationNo = certificationNo == null ? null : certificationNo.trim();
	}

	/**
	 * VARCHAR(200)<br>
	 * 获得 车架号
	 */
	public String getChassisNo() {
		return chassisNo;
	}

	/**
	 * VARCHAR(200)<br>
	 * 设置 车架号
	 */
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo == null ? null : chassisNo.trim();
	}

	/**
	 * VARCHAR(80)<br>
	 * 获得 生产厂家
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * VARCHAR(80)<br>
	 * 设置 生产厂家
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer == null ? null : manufacturer.trim();
	}

	/**
	 * CHAR(8)<br>
	 * 获得 出厂日期
	 */
	public String getManufactureDate() {
		return manufactureDate;
	}

	/**
	 * CHAR(8)<br>
	 * 设置 出厂日期
	 */
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate == null ? null : manufactureDate.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", mortgageNo=").append(mortgageNo);
		sb.append(", tradeContno=").append(tradeContno);
		sb.append(", protocolNo=").append(protocolNo);
		sb.append(", mortgageName=").append(mortgageName);
		sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
		sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
		sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
		sb.append(", mortgageLevelFour=").append(mortgageLevelFour);
		sb.append(", mortgageModel=").append(mortgageModel);
		sb.append(", quantity=").append(quantity);
		sb.append(", price=").append(price);
		sb.append(", totPrice=").append(totPrice);
		sb.append(", mortgageUnits=").append(mortgageUnits);
		sb.append(", pledgedAmount=").append(pledgedAmount);
		sb.append(", curcd=").append(curcd);
		sb.append(", balAmount=").append(balAmount);
		sb.append(", balQuantity=").append(balQuantity);
		sb.append(", certificationNo=").append(certificationNo);
		sb.append(", chassisNo=").append(chassisNo);
		sb.append(", manufacturer=").append(manufacturer);
		sb.append(", manufactureDate=").append(manufactureDate);
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
		BCntMprotInfo other = (BCntMprotInfo) that;
		return (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
				&& (this.getTradeContno() == null ? other.getTradeContno() == null : this.getTradeContno().equals(other.getTradeContno()))
				&& (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
				&& (this.getMortgageName() == null ? other.getMortgageName() == null : this.getMortgageName().equals(other.getMortgageName()))
				&& (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null
						: this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
				&& (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null
						: this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
				&& (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null
						: this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
				&& (this.getMortgageLevelFour() == null ? other.getMortgageLevelFour() == null
						: this.getMortgageLevelFour().equals(other.getMortgageLevelFour()))
				&& (this.getMortgageModel() == null ? other.getMortgageModel() == null : this.getMortgageModel().equals(other.getMortgageModel()))
				&& (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
				&& (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
				&& (this.getTotPrice() == null ? other.getTotPrice() == null : this.getTotPrice().equals(other.getTotPrice()))
				&& (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
				&& (this.getPledgedAmount() == null ? other.getPledgedAmount() == null : this.getPledgedAmount().equals(other.getPledgedAmount()))
				&& (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
				&& (this.getBalAmount() == null ? other.getBalAmount() == null : this.getBalAmount().equals(other.getBalAmount()))
				&& (this.getBalQuantity() == null ? other.getBalQuantity() == null : this.getBalQuantity().equals(other.getBalQuantity()))
				&& (this.getCertificationNo() == null ? other.getCertificationNo() == null
						: this.getCertificationNo().equals(other.getCertificationNo()))
				&& (this.getChassisNo() == null ? other.getChassisNo() == null : this.getChassisNo().equals(other.getChassisNo()))
				&& (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
				&& (this.getManufactureDate() == null ? other.getManufactureDate() == null
						: this.getManufactureDate().equals(other.getManufactureDate()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
		result = prime * result + ((getTradeContno() == null) ? 0 : getTradeContno().hashCode());
		result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
		result = prime * result + ((getMortgageName() == null) ? 0 : getMortgageName().hashCode());
		result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
		result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
		result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
		result = prime * result + ((getMortgageLevelFour() == null) ? 0 : getMortgageLevelFour().hashCode());
		result = prime * result + ((getMortgageModel() == null) ? 0 : getMortgageModel().hashCode());
		result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
		result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
		result = prime * result + ((getTotPrice() == null) ? 0 : getTotPrice().hashCode());
		result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
		result = prime * result + ((getPledgedAmount() == null) ? 0 : getPledgedAmount().hashCode());
		result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
		result = prime * result + ((getBalAmount() == null) ? 0 : getBalAmount().hashCode());
		result = prime * result + ((getBalQuantity() == null) ? 0 : getBalQuantity().hashCode());
		result = prime * result + ((getCertificationNo() == null) ? 0 : getCertificationNo().hashCode());
		result = prime * result + ((getChassisNo() == null) ? 0 : getChassisNo().hashCode());
		result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
		result = prime * result + ((getManufactureDate() == null) ? 0 : getManufactureDate().hashCode());
		return result;
	}
}