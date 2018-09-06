package com.huateng.scf.bas.cnt.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BCntMprotBaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(20) 必填<br>
     * 主键协议编号
     */
    private String protocolNo;

    /**
     * VARCHAR(200)<br>
     * 文本协议编号
     */
    private String protocolCode;

    /**
     * CHAR(2) 必填<br>
     * 协议类型：
01-监管协议
02-四方保兑仓协议
03-汽车金融协议
04-保理协议
05-应收账款质押协议
06-订单协议
07-三方保兑仓协议
     */
    private String protocolType;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String productId;

    /**
     * CHAR(8)<br>
     * 签署日期
     */
    private String signDate;

    /**
     * CHAR(8) 必填<br>
     * 协议生效日期
     */
    private String startDate;

    /**
     * CHAR(8) 必填<br>
     * 协议到期日
     */
    private String endDate;

    /**
     * VARCHAR(6)<br>
     * 期限：共6位，前两位是年，中间两位是月，后两位是日，没有值的话用零代替
     */
    private String tenor;

    /**
     * CHAR(3) 必填<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(16,2)<br>
     * 协议金额
     */
    private BigDecimal protAmt;

    /**
     * VARCHAR(100)<br>
     * 签署地
     */
    private String signIn;

    /**
     * CHAR(2)<br>
     * 回执状态
     */
    private String status;

    /**
     * VARCHAR(500)<br>
     * 其他描述
     */
    private String otherDes;

    /**
     * CHAR(1)<br>
     * 协议状态：0-无效、1-有效
     */
    private String state;

    /**
     * VARCHAR(32) 必填<br>
     * 客户经理
     */
    private String tlrno;

    /**
     * VARCHAR(20) 必填<br>
     * 经办机构
     */
    private String brcode;

    /**
     * CHAR(1)<br>
     * 协议更新状态：0-解除、1-新增、2-修改
     */
    private String updateState;

    /**
     * TIMESTAMP(11,6)<br>
     * 协议更新时间
     */
    private Date updateDate;

    /**
     * VARCHAR(20)<br>
     * 关联协议号(先票款后货协议)
     */
    private String otherprotocolNo;

    /**
     * DECIMAL(9,6)<br>
     * 质押率(%)
     */
    private BigDecimal loanPercent;

    /**
     * CHAR(1)<br>
     * 货押模式：1-动态、2-静态
     */
    private String moniType;

    /**
     * DECIMAL(16,2)<br>
     * 监管底线
     */
    private BigDecimal lowPriceNew;

    /**
     * CHAR(2)<br>
     * 货物管理模式：01-总量对应/池模式、02-一一对应/单笔模式
     */
    private String arrivedManageMode;

    /**
     * CHAR(1)<br>
     * 是否签订委托变卖协议：0-否、1-是
     */
    private String sellOffFlag;

    /**
     * DECIMAL(9,6)<br>
     * 价格跌幅预警(%)
     */
    private BigDecimal priceDropRate;

    /**
     * VARCHAR(20)<br>
     * 合作机构(村镇银行)
     */
    private String cooperationBrcode;

    /**
     * CHAR(1)<br>
     * 循环走款标识：1,是；0，否
     */
    private String circleLoanFlag;

    /**
     * CHAR(1)<br>
     * 三方协议类型：大三方、小三方
     */
    private String tripleProtocolType;

    /**
     * VARCHAR(2)<br>
     * 提货模式
     */
    private String deliveryMode;

    /**
     * VARCHAR(20) 必填<br>
     * 获得 主键协议编号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 主键协议编号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 文本协议编号
     */
    public String getProtocolCode() {
        return protocolCode;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 文本协议编号
     */
    public void setProtocolCode(String protocolCode) {
        this.protocolCode = protocolCode == null ? null : protocolCode.trim();
    }

    /**
     * CHAR(2) 必填<br>
     * 获得 协议类型：
01-监管协议
02-四方保兑仓协议
03-汽车金融协议
04-保理协议
05-应收账款质押协议
06-订单协议
07-三方保兑仓协议
     */
    public String getProtocolType() {
        return protocolType;
    }

    /**
     * CHAR(2) 必填<br>
     * 设置 协议类型：
01-监管协议
02-四方保兑仓协议
03-汽车金融协议
04-保理协议
05-应收账款质押协议
06-订单协议
07-三方保兑仓协议
     */
    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType == null ? null : protocolType.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 签署日期
     */
    public String getSignDate() {
        return signDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 签署日期
     */
    public void setSignDate(String signDate) {
        this.signDate = signDate == null ? null : signDate.trim();
    }

    /**
     * CHAR(8) 必填<br>
     * 获得 协议生效日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8) 必填<br>
     * 设置 协议生效日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8) 必填<br>
     * 获得 协议到期日
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8) 必填<br>
     * 设置 协议到期日
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 期限：共6位，前两位是年，中间两位是月，后两位是日，没有值的话用零代替
     */
    public String getTenor() {
        return tenor;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 期限：共6位，前两位是年，中间两位是月，后两位是日，没有值的话用零代替
     */
    public void setTenor(String tenor) {
        this.tenor = tenor == null ? null : tenor.trim();
    }

    /**
     * CHAR(3) 必填<br>
     * 获得 币种
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * CHAR(3) 必填<br>
     * 设置 币种
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 协议金额
     */
    public BigDecimal getProtAmt() {
        return protAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 协议金额
     */
    public void setProtAmt(BigDecimal protAmt) {
        this.protAmt = protAmt;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 签署地
     */
    public String getSignIn() {
        return signIn;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 签署地
     */
    public void setSignIn(String signIn) {
        this.signIn = signIn == null ? null : signIn.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 回执状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(2)<br>
     * 设置 回执状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 其他描述
     */
    public String getOtherDes() {
        return otherDes;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 其他描述
     */
    public void setOtherDes(String otherDes) {
        this.otherDes = otherDes == null ? null : otherDes.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 协议状态：0-无效、1-有效
     */
    public String getState() {
        return state;
    }

    /**
     * CHAR(1)<br>
     * 设置 协议状态：0-无效、1-有效
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 客户经理
     */
    public String getTlrno() {
        return tlrno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 客户经理
     */
    public void setTlrno(String tlrno) {
        this.tlrno = tlrno == null ? null : tlrno.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 经办机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 经办机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 协议更新状态：0-解除、1-新增、2-修改
     */
    public String getUpdateState() {
        return updateState;
    }

    /**
     * CHAR(1)<br>
     * 设置 协议更新状态：0-解除、1-新增、2-修改
     */
    public void setUpdateState(String updateState) {
        this.updateState = updateState == null ? null : updateState.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 协议更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 协议更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 关联协议号(先票款后货协议)
     */
    public String getOtherprotocolNo() {
        return otherprotocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 关联协议号(先票款后货协议)
     */
    public void setOtherprotocolNo(String otherprotocolNo) {
        this.otherprotocolNo = otherprotocolNo == null ? null : otherprotocolNo.trim();
    }

    /**
     * DECIMAL(9,6)<br>
     * 获得 质押率(%)
     */
    public BigDecimal getLoanPercent() {
        return loanPercent;
    }

    /**
     * DECIMAL(9,6)<br>
     * 设置 质押率(%)
     */
    public void setLoanPercent(BigDecimal loanPercent) {
        this.loanPercent = loanPercent;
    }

    /**
     * CHAR(1)<br>
     * 获得 货押模式：1-动态、2-静态
     */
    public String getMoniType() {
        return moniType;
    }

    /**
     * CHAR(1)<br>
     * 设置 货押模式：1-动态、2-静态
     */
    public void setMoniType(String moniType) {
        this.moniType = moniType == null ? null : moniType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 监管底线
     */
    public BigDecimal getLowPriceNew() {
        return lowPriceNew;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 监管底线
     */
    public void setLowPriceNew(BigDecimal lowPriceNew) {
        this.lowPriceNew = lowPriceNew;
    }

    /**
     * CHAR(2)<br>
     * 获得 货物管理模式：01-总量对应/池模式、02-一一对应/单笔模式
     */
    public String getArrivedManageMode() {
        return arrivedManageMode;
    }

    /**
     * CHAR(2)<br>
     * 设置 货物管理模式：01-总量对应/池模式、02-一一对应/单笔模式
     */
    public void setArrivedManageMode(String arrivedManageMode) {
        this.arrivedManageMode = arrivedManageMode == null ? null : arrivedManageMode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否签订委托变卖协议：0-否、1-是
     */
    public String getSellOffFlag() {
        return sellOffFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否签订委托变卖协议：0-否、1-是
     */
    public void setSellOffFlag(String sellOffFlag) {
        this.sellOffFlag = sellOffFlag == null ? null : sellOffFlag.trim();
    }

    /**
     * DECIMAL(9,6)<br>
     * 获得 价格跌幅预警(%)
     */
    public BigDecimal getPriceDropRate() {
        return priceDropRate;
    }

    /**
     * DECIMAL(9,6)<br>
     * 设置 价格跌幅预警(%)
     */
    public void setPriceDropRate(BigDecimal priceDropRate) {
        this.priceDropRate = priceDropRate;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 合作机构(村镇银行)
     */
    public String getCooperationBrcode() {
        return cooperationBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 合作机构(村镇银行)
     */
    public void setCooperationBrcode(String cooperationBrcode) {
        this.cooperationBrcode = cooperationBrcode == null ? null : cooperationBrcode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 循环走款标识：1,是；0，否
     */
    public String getCircleLoanFlag() {
        return circleLoanFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 循环走款标识：1,是；0，否
     */
    public void setCircleLoanFlag(String circleLoanFlag) {
        this.circleLoanFlag = circleLoanFlag == null ? null : circleLoanFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 三方协议类型：大三方、小三方
     */
    public String getTripleProtocolType() {
        return tripleProtocolType;
    }

    /**
     * CHAR(1)<br>
     * 设置 三方协议类型：大三方、小三方
     */
    public void setTripleProtocolType(String tripleProtocolType) {
        this.tripleProtocolType = tripleProtocolType == null ? null : tripleProtocolType.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 提货模式
     */
    public String getDeliveryMode() {
        return deliveryMode;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 提货模式
     */
    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode == null ? null : deliveryMode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", protocolCode=").append(protocolCode);
        sb.append(", protocolType=").append(protocolType);
        sb.append(", productId=").append(productId);
        sb.append(", signDate=").append(signDate);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", tenor=").append(tenor);
        sb.append(", curcd=").append(curcd);
        sb.append(", protAmt=").append(protAmt);
        sb.append(", signIn=").append(signIn);
        sb.append(", status=").append(status);
        sb.append(", otherDes=").append(otherDes);
        sb.append(", state=").append(state);
        sb.append(", tlrno=").append(tlrno);
        sb.append(", brcode=").append(brcode);
        sb.append(", updateState=").append(updateState);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", otherprotocolNo=").append(otherprotocolNo);
        sb.append(", loanPercent=").append(loanPercent);
        sb.append(", moniType=").append(moniType);
        sb.append(", lowPriceNew=").append(lowPriceNew);
        sb.append(", arrivedManageMode=").append(arrivedManageMode);
        sb.append(", sellOffFlag=").append(sellOffFlag);
        sb.append(", priceDropRate=").append(priceDropRate);
        sb.append(", cooperationBrcode=").append(cooperationBrcode);
        sb.append(", circleLoanFlag=").append(circleLoanFlag);
        sb.append(", tripleProtocolType=").append(tripleProtocolType);
        sb.append(", deliveryMode=").append(deliveryMode);
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
        BCntMprotBaseInfo other = (BCntMprotBaseInfo) that;
        return (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getProtocolCode() == null ? other.getProtocolCode() == null : this.getProtocolCode().equals(other.getProtocolCode()))
            && (this.getProtocolType() == null ? other.getProtocolType() == null : this.getProtocolType().equals(other.getProtocolType()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getSignDate() == null ? other.getSignDate() == null : this.getSignDate().equals(other.getSignDate()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getTenor() == null ? other.getTenor() == null : this.getTenor().equals(other.getTenor()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getProtAmt() == null ? other.getProtAmt() == null : this.getProtAmt().equals(other.getProtAmt()))
            && (this.getSignIn() == null ? other.getSignIn() == null : this.getSignIn().equals(other.getSignIn()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOtherDes() == null ? other.getOtherDes() == null : this.getOtherDes().equals(other.getOtherDes()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getTlrno() == null ? other.getTlrno() == null : this.getTlrno().equals(other.getTlrno()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getUpdateState() == null ? other.getUpdateState() == null : this.getUpdateState().equals(other.getUpdateState()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getOtherprotocolNo() == null ? other.getOtherprotocolNo() == null : this.getOtherprotocolNo().equals(other.getOtherprotocolNo()))
            && (this.getLoanPercent() == null ? other.getLoanPercent() == null : this.getLoanPercent().equals(other.getLoanPercent()))
            && (this.getMoniType() == null ? other.getMoniType() == null : this.getMoniType().equals(other.getMoniType()))
            && (this.getLowPriceNew() == null ? other.getLowPriceNew() == null : this.getLowPriceNew().equals(other.getLowPriceNew()))
            && (this.getArrivedManageMode() == null ? other.getArrivedManageMode() == null : this.getArrivedManageMode().equals(other.getArrivedManageMode()))
            && (this.getSellOffFlag() == null ? other.getSellOffFlag() == null : this.getSellOffFlag().equals(other.getSellOffFlag()))
            && (this.getPriceDropRate() == null ? other.getPriceDropRate() == null : this.getPriceDropRate().equals(other.getPriceDropRate()))
            && (this.getCooperationBrcode() == null ? other.getCooperationBrcode() == null : this.getCooperationBrcode().equals(other.getCooperationBrcode()))
            && (this.getCircleLoanFlag() == null ? other.getCircleLoanFlag() == null : this.getCircleLoanFlag().equals(other.getCircleLoanFlag()))
            && (this.getTripleProtocolType() == null ? other.getTripleProtocolType() == null : this.getTripleProtocolType().equals(other.getTripleProtocolType()))
            && (this.getDeliveryMode() == null ? other.getDeliveryMode() == null : this.getDeliveryMode().equals(other.getDeliveryMode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getProtocolCode() == null) ? 0 : getProtocolCode().hashCode());
        result = prime * result + ((getProtocolType() == null) ? 0 : getProtocolType().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getTenor() == null) ? 0 : getTenor().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getProtAmt() == null) ? 0 : getProtAmt().hashCode());
        result = prime * result + ((getSignIn() == null) ? 0 : getSignIn().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOtherDes() == null) ? 0 : getOtherDes().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getTlrno() == null) ? 0 : getTlrno().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getUpdateState() == null) ? 0 : getUpdateState().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getOtherprotocolNo() == null) ? 0 : getOtherprotocolNo().hashCode());
        result = prime * result + ((getLoanPercent() == null) ? 0 : getLoanPercent().hashCode());
        result = prime * result + ((getMoniType() == null) ? 0 : getMoniType().hashCode());
        result = prime * result + ((getLowPriceNew() == null) ? 0 : getLowPriceNew().hashCode());
        result = prime * result + ((getArrivedManageMode() == null) ? 0 : getArrivedManageMode().hashCode());
        result = prime * result + ((getSellOffFlag() == null) ? 0 : getSellOffFlag().hashCode());
        result = prime * result + ((getPriceDropRate() == null) ? 0 : getPriceDropRate().hashCode());
        result = prime * result + ((getCooperationBrcode() == null) ? 0 : getCooperationBrcode().hashCode());
        result = prime * result + ((getCircleLoanFlag() == null) ? 0 : getCircleLoanFlag().hashCode());
        result = prime * result + ((getTripleProtocolType() == null) ? 0 : getTripleProtocolType().hashCode());
        result = prime * result + ((getDeliveryMode() == null) ? 0 : getDeliveryMode().hashCode());
        return result;
    }
}