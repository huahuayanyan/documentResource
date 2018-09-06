package com.huateng.scf.bas.cnt.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BCntMprotDealInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(20) 必填<br>
     * 协议编号
     */
    private String protocolNo;

    /**
     * DECIMAL(16,2)<br>
     * 保证金金额
     */
    private BigDecimal bailAmount;

    /**
     * DECIMAL(9,6)<br>
     * 首笔保证金比例
     */
    private BigDecimal firstBailRatio;

    /**
     * CHAR(1)<br>
     * 首笔保证金提货模式：1-首笔保证金可全额提货、2-首笔保证金在后期按比例提货、3-首笔保证金全额最后提货
     */
    private String firstBailType;

    /**
     * VARCHAR(20) 必填<br>
     * 出账方式：01-流贷、02-银承
     */
    private String loanWay;

    /**
     * DECIMAL(22)<br>
     * 融资期限
     */
    private Integer loanDays;

    /**
     * CHAR(2)<br>
     * 货物管理模式
     */
    private String arrivedManageMode;

    /**
     * VARCHAR(500)<br>
     * 货物名称
     */
    private String goodsNm;

    /**
     * VARCHAR(10)<br>
     * 提货方式：交保证金、提前还款、存单质押、其它现金等价物
     */
    private String takeMode;

    /**
     * CHAR(2)<br>
     * 上游厂商责任
     */
    private String coreCustDuty;

    /**
     * CHAR(2)<br>
     * 押品对应方式
     */
    private String mortgageManageMode;

    /**
     * CHAR(1)<br>
     * 是否购买保险：1-无需购买保险、2-购买综合保险、3-按单笔出账购买保险
     */
    private String isInsurance;

    /**
     * CHAR(2)<br>
     * 是否允许直接从上游厂商提货
     */
    private String fouAddress;

    /**
     * VARCHAR(200)<br>
     * 其它约定
     */
    private String triConventions;

    /**
     * VARCHAR(100)<br>
     * 收货人
     */
    private String condignee;

    /**
     * VARCHAR(100)<br>
     * 货物运输方式
     */
    private String trasportationMode;

    /**
     * VARCHAR(100)<br>
     * 货物交付地点
     */
    private String deliveryPoints;

    /**
     * VARCHAR(100)<br>
     * 目的港/站/地
     */
    private String destination;

    /**
     * DECIMAL(16,2)<br>
     * 本次提货金额
     */
    private BigDecimal deliveryAmount;

    /**
     * DECIMAL(16,2)<br>
     * 累计剩余提货金额
     */
    private BigDecimal amountIn;

    /**
     * DECIMAL(16,2)<br>
     * 累计提货金额（向监管）
     */
    private BigDecimal amountOut;

    /**
     * DECIMAL(16,2)<br>
     * 累计提货金额（向核心）
     */
    private BigDecimal amountUpOut;

    /**
     * DECIMAL(16,2)<br>
     * 累计收款金额
     */
    private BigDecimal loanAmt;

    /**
     * DECIMAL(16,2)<br>
     * 累计到货金额
     */
    private BigDecimal pledgeAmt;

    /**
     * VARCHAR(16)<br>
     * 卖方责任承担方式：授信逾期担保、违约退款
     */
    private String dutyAssumeType;

    /**
     * DECIMAL(16)<br>
     * 发货期限（天）
     */
    private Long consignmentDays;

    /**
     * VARCHAR(100)<br>
     * 其它参与方
     */
    private String otherCustName;

    /**
     * VARCHAR(20) 必填<br>
     * 获得 协议编号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 协议编号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保证金金额
     */
    public BigDecimal getBailAmount() {
        return bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金金额
     */
    public void setBailAmount(BigDecimal bailAmount) {
        this.bailAmount = bailAmount;
    }

    /**
     * DECIMAL(9,6)<br>
     * 获得 首笔保证金比例
     */
    public BigDecimal getFirstBailRatio() {
        return firstBailRatio;
    }

    /**
     * DECIMAL(9,6)<br>
     * 设置 首笔保证金比例
     */
    public void setFirstBailRatio(BigDecimal firstBailRatio) {
        this.firstBailRatio = firstBailRatio;
    }

    /**
     * CHAR(1)<br>
     * 获得 首笔保证金提货模式：1-首笔保证金可全额提货、2-首笔保证金在后期按比例提货、3-首笔保证金全额最后提货
     */
    public String getFirstBailType() {
        return firstBailType;
    }

    /**
     * CHAR(1)<br>
     * 设置 首笔保证金提货模式：1-首笔保证金可全额提货、2-首笔保证金在后期按比例提货、3-首笔保证金全额最后提货
     */
    public void setFirstBailType(String firstBailType) {
        this.firstBailType = firstBailType == null ? null : firstBailType.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 出账方式：01-流贷、02-银承
     */
    public String getLoanWay() {
        return loanWay;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 出账方式：01-流贷、02-银承
     */
    public void setLoanWay(String loanWay) {
        this.loanWay = loanWay == null ? null : loanWay.trim();
    }

    

    /**
	 * @return the loanDays
	 */
	public Integer getLoanDays() {
		return loanDays;
	}

	/**
	 * @param loanDays the loanDays to set
	 */
	public void setLoanDays(Integer loanDays) {
		this.loanDays = loanDays;
	}

	/**
     * CHAR(2)<br>
     * 获得 货物管理模式
     */
    public String getArrivedManageMode() {
        return arrivedManageMode;
    }

    /**
     * CHAR(2)<br>
     * 设置 货物管理模式
     */
    public void setArrivedManageMode(String arrivedManageMode) {
        this.arrivedManageMode = arrivedManageMode == null ? null : arrivedManageMode.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 货物名称
     */
    public String getGoodsNm() {
        return goodsNm;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 货物名称
     */
    public void setGoodsNm(String goodsNm) {
        this.goodsNm = goodsNm == null ? null : goodsNm.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 提货方式：交保证金、提前还款、存单质押、其它现金等价物
     */
    public String getTakeMode() {
        return takeMode;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 提货方式：交保证金、提前还款、存单质押、其它现金等价物
     */
    public void setTakeMode(String takeMode) {
        this.takeMode = takeMode == null ? null : takeMode.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 上游厂商责任
     */
    public String getCoreCustDuty() {
        return coreCustDuty;
    }

    /**
     * CHAR(2)<br>
     * 设置 上游厂商责任
     */
    public void setCoreCustDuty(String coreCustDuty) {
        this.coreCustDuty = coreCustDuty == null ? null : coreCustDuty.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 押品对应方式
     */
    public String getMortgageManageMode() {
        return mortgageManageMode;
    }

    /**
     * CHAR(2)<br>
     * 设置 押品对应方式
     */
    public void setMortgageManageMode(String mortgageManageMode) {
        this.mortgageManageMode = mortgageManageMode == null ? null : mortgageManageMode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否购买保险：1-无需购买保险、2-购买综合保险、3-按单笔出账购买保险
     */
    public String getIsInsurance() {
        return isInsurance;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否购买保险：1-无需购买保险、2-购买综合保险、3-按单笔出账购买保险
     */
    public void setIsInsurance(String isInsurance) {
        this.isInsurance = isInsurance == null ? null : isInsurance.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 是否允许直接从上游厂商提货
     */
    public String getFouAddress() {
        return fouAddress;
    }

    /**
     * CHAR(2)<br>
     * 设置 是否允许直接从上游厂商提货
     */
    public void setFouAddress(String fouAddress) {
        this.fouAddress = fouAddress == null ? null : fouAddress.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 其它约定
     */
    public String getTriConventions() {
        return triConventions;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 其它约定
     */
    public void setTriConventions(String triConventions) {
        this.triConventions = triConventions == null ? null : triConventions.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 收货人
     */
    public String getCondignee() {
        return condignee;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 收货人
     */
    public void setCondignee(String condignee) {
        this.condignee = condignee == null ? null : condignee.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 货物运输方式
     */
    public String getTrasportationMode() {
        return trasportationMode;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 货物运输方式
     */
    public void setTrasportationMode(String trasportationMode) {
        this.trasportationMode = trasportationMode == null ? null : trasportationMode.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 货物交付地点
     */
    public String getDeliveryPoints() {
        return deliveryPoints;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 货物交付地点
     */
    public void setDeliveryPoints(String deliveryPoints) {
        this.deliveryPoints = deliveryPoints == null ? null : deliveryPoints.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 目的港/站/地
     */
    public String getDestination() {
        return destination;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 目的港/站/地
     */
    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本次提货金额
     */
    public BigDecimal getDeliveryAmount() {
        return deliveryAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本次提货金额
     */
    public void setDeliveryAmount(BigDecimal deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计剩余提货金额
     */
    public BigDecimal getAmountIn() {
        return amountIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计剩余提货金额
     */
    public void setAmountIn(BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计提货金额（向监管）
     */
    public BigDecimal getAmountOut() {
        return amountOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计提货金额（向监管）
     */
    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计提货金额（向核心）
     */
    public BigDecimal getAmountUpOut() {
        return amountUpOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计提货金额（向核心）
     */
    public void setAmountUpOut(BigDecimal amountUpOut) {
        this.amountUpOut = amountUpOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计收款金额
     */
    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计收款金额
     */
    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计到货金额
     */
    public BigDecimal getPledgeAmt() {
        return pledgeAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计到货金额
     */
    public void setPledgeAmt(BigDecimal pledgeAmt) {
        this.pledgeAmt = pledgeAmt;
    }

    /**
     * VARCHAR(16)<br>
     * 获得 卖方责任承担方式：授信逾期担保、违约退款
     */
    public String getDutyAssumeType() {
        return dutyAssumeType;
    }

    /**
     * VARCHAR(16)<br>
     * 设置 卖方责任承担方式：授信逾期担保、违约退款
     */
    public void setDutyAssumeType(String dutyAssumeType) {
        this.dutyAssumeType = dutyAssumeType == null ? null : dutyAssumeType.trim();
    }

    /**
     * DECIMAL(16)<br>
     * 获得 发货期限（天）
     */
    public Long getConsignmentDays() {
        return consignmentDays;
    }

    /**
     * DECIMAL(16)<br>
     * 设置 发货期限（天）
     */
    public void setConsignmentDays(Long consignmentDays) {
        this.consignmentDays = consignmentDays;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 其它参与方
     */
    public String getOtherCustName() {
        return otherCustName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 其它参与方
     */
    public void setOtherCustName(String otherCustName) {
        this.otherCustName = otherCustName == null ? null : otherCustName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", firstBailRatio=").append(firstBailRatio);
        sb.append(", firstBailType=").append(firstBailType);
        sb.append(", loanWay=").append(loanWay);
        sb.append(", loanDays=").append(loanDays);
        sb.append(", arrivedManageMode=").append(arrivedManageMode);
        sb.append(", goodsNm=").append(goodsNm);
        sb.append(", takeMode=").append(takeMode);
        sb.append(", coreCustDuty=").append(coreCustDuty);
        sb.append(", mortgageManageMode=").append(mortgageManageMode);
        sb.append(", isInsurance=").append(isInsurance);
        sb.append(", fouAddress=").append(fouAddress);
        sb.append(", triConventions=").append(triConventions);
        sb.append(", condignee=").append(condignee);
        sb.append(", trasportationMode=").append(trasportationMode);
        sb.append(", deliveryPoints=").append(deliveryPoints);
        sb.append(", destination=").append(destination);
        sb.append(", deliveryAmount=").append(deliveryAmount);
        sb.append(", amountIn=").append(amountIn);
        sb.append(", amountOut=").append(amountOut);
        sb.append(", amountUpOut=").append(amountUpOut);
        sb.append(", loanAmt=").append(loanAmt);
        sb.append(", pledgeAmt=").append(pledgeAmt);
        sb.append(", dutyAssumeType=").append(dutyAssumeType);
        sb.append(", consignmentDays=").append(consignmentDays);
        sb.append(", otherCustName=").append(otherCustName);
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
        BCntMprotDealInfo other = (BCntMprotDealInfo) that;
        return (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getFirstBailRatio() == null ? other.getFirstBailRatio() == null : this.getFirstBailRatio().equals(other.getFirstBailRatio()))
            && (this.getFirstBailType() == null ? other.getFirstBailType() == null : this.getFirstBailType().equals(other.getFirstBailType()))
            && (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()))
            && (this.getLoanDays() == null ? other.getLoanDays() == null : this.getLoanDays().equals(other.getLoanDays()))
            && (this.getArrivedManageMode() == null ? other.getArrivedManageMode() == null : this.getArrivedManageMode().equals(other.getArrivedManageMode()))
            && (this.getGoodsNm() == null ? other.getGoodsNm() == null : this.getGoodsNm().equals(other.getGoodsNm()))
            && (this.getTakeMode() == null ? other.getTakeMode() == null : this.getTakeMode().equals(other.getTakeMode()))
            && (this.getCoreCustDuty() == null ? other.getCoreCustDuty() == null : this.getCoreCustDuty().equals(other.getCoreCustDuty()))
            && (this.getMortgageManageMode() == null ? other.getMortgageManageMode() == null : this.getMortgageManageMode().equals(other.getMortgageManageMode()))
            && (this.getIsInsurance() == null ? other.getIsInsurance() == null : this.getIsInsurance().equals(other.getIsInsurance()))
            && (this.getFouAddress() == null ? other.getFouAddress() == null : this.getFouAddress().equals(other.getFouAddress()))
            && (this.getTriConventions() == null ? other.getTriConventions() == null : this.getTriConventions().equals(other.getTriConventions()))
            && (this.getCondignee() == null ? other.getCondignee() == null : this.getCondignee().equals(other.getCondignee()))
            && (this.getTrasportationMode() == null ? other.getTrasportationMode() == null : this.getTrasportationMode().equals(other.getTrasportationMode()))
            && (this.getDeliveryPoints() == null ? other.getDeliveryPoints() == null : this.getDeliveryPoints().equals(other.getDeliveryPoints()))
            && (this.getDestination() == null ? other.getDestination() == null : this.getDestination().equals(other.getDestination()))
            && (this.getDeliveryAmount() == null ? other.getDeliveryAmount() == null : this.getDeliveryAmount().equals(other.getDeliveryAmount()))
            && (this.getAmountIn() == null ? other.getAmountIn() == null : this.getAmountIn().equals(other.getAmountIn()))
            && (this.getAmountOut() == null ? other.getAmountOut() == null : this.getAmountOut().equals(other.getAmountOut()))
            && (this.getAmountUpOut() == null ? other.getAmountUpOut() == null : this.getAmountUpOut().equals(other.getAmountUpOut()))
            && (this.getLoanAmt() == null ? other.getLoanAmt() == null : this.getLoanAmt().equals(other.getLoanAmt()))
            && (this.getPledgeAmt() == null ? other.getPledgeAmt() == null : this.getPledgeAmt().equals(other.getPledgeAmt()))
            && (this.getDutyAssumeType() == null ? other.getDutyAssumeType() == null : this.getDutyAssumeType().equals(other.getDutyAssumeType()))
            && (this.getConsignmentDays() == null ? other.getConsignmentDays() == null : this.getConsignmentDays().equals(other.getConsignmentDays()))
            && (this.getOtherCustName() == null ? other.getOtherCustName() == null : this.getOtherCustName().equals(other.getOtherCustName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getFirstBailRatio() == null) ? 0 : getFirstBailRatio().hashCode());
        result = prime * result + ((getFirstBailType() == null) ? 0 : getFirstBailType().hashCode());
        result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
        result = prime * result + ((getLoanDays() == null) ? 0 : getLoanDays().hashCode());
        result = prime * result + ((getArrivedManageMode() == null) ? 0 : getArrivedManageMode().hashCode());
        result = prime * result + ((getGoodsNm() == null) ? 0 : getGoodsNm().hashCode());
        result = prime * result + ((getTakeMode() == null) ? 0 : getTakeMode().hashCode());
        result = prime * result + ((getCoreCustDuty() == null) ? 0 : getCoreCustDuty().hashCode());
        result = prime * result + ((getMortgageManageMode() == null) ? 0 : getMortgageManageMode().hashCode());
        result = prime * result + ((getIsInsurance() == null) ? 0 : getIsInsurance().hashCode());
        result = prime * result + ((getFouAddress() == null) ? 0 : getFouAddress().hashCode());
        result = prime * result + ((getTriConventions() == null) ? 0 : getTriConventions().hashCode());
        result = prime * result + ((getCondignee() == null) ? 0 : getCondignee().hashCode());
        result = prime * result + ((getTrasportationMode() == null) ? 0 : getTrasportationMode().hashCode());
        result = prime * result + ((getDeliveryPoints() == null) ? 0 : getDeliveryPoints().hashCode());
        result = prime * result + ((getDestination() == null) ? 0 : getDestination().hashCode());
        result = prime * result + ((getDeliveryAmount() == null) ? 0 : getDeliveryAmount().hashCode());
        result = prime * result + ((getAmountIn() == null) ? 0 : getAmountIn().hashCode());
        result = prime * result + ((getAmountOut() == null) ? 0 : getAmountOut().hashCode());
        result = prime * result + ((getAmountUpOut() == null) ? 0 : getAmountUpOut().hashCode());
        result = prime * result + ((getLoanAmt() == null) ? 0 : getLoanAmt().hashCode());
        result = prime * result + ((getPledgeAmt() == null) ? 0 : getPledgeAmt().hashCode());
        result = prime * result + ((getDutyAssumeType() == null) ? 0 : getDutyAssumeType().hashCode());
        result = prime * result + ((getConsignmentDays() == null) ? 0 : getConsignmentDays().hashCode());
        result = prime * result + ((getOtherCustName() == null) ? 0 : getOtherCustName().hashCode());
        return result;
    }
}