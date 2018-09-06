package com.huateng.scf.rec.bcp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RBcpCostOut implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tlrnm;
    private String brname;
    
    public String getTlrnm() {
		return tlrnm;
	}

	public void setTlrnm(String tlrnm) {
		this.tlrnm = tlrnm;
	}

	public String getBrname() {
		return brname;
	}

	public void setBrname(String brname) {
		this.brname = brname;
	}

	/**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 业务编号
     */
    private String appno;

    /**
     * VARCHAR(4)<br>
     * 申请类型
     */
    private String applyType;

    /**
     * VARCHAR(32) 必填<br>
     * 费用基本表ID
     */
    private String costInfoId;

    /**
     * VARCHAR(4)<br>
     * 费用代码
     */
    private String costCode;

    /**
     * VARCHAR(100)<br>
     * 费用名称
     */
    private String costName;

    /**
     * CHAR(1)<br>
     * 扣取方式：1-外扣、2-内收
     */
    private String chargeType;

    /**
     * CHAR(1)<br>
     * 费用收取种类：1-整体，2-单张
     */
    private String costClass;

    /**
     * CHAR(1)<br>
     * 收取方式：1-先收、2-后收、3-免收
     */
    private String costType;

    /**
     * CHAR(1)<br>
     * 计算方式：1-固定、2-按比率
     */
    private String costCalcType;

    /**
     * DECIMAL(5,2)<br>
     * 费用比率
     */
    private BigDecimal costRate;

    /**
     * CHAR(1)<br>
     * 收取状态：1-已收、2-未收
     */
    private String status;

    /**
     * DECIMAL(16,2)<br>
     * 业务金额
     */
    private BigDecimal bussAmt;

    /**
     * DECIMAL(16,2)<br>
     * 固定费用
     */
    private BigDecimal costAmt;

    /**
     * DECIMAL(16,2)<br>
     * 减免金额
     */
    private BigDecimal reduceAmt;

    /**
     * DECIMAL(16,2)<br>
     * 实收费用金额
     */
    private BigDecimal receiveAmount;

    /**
     * VARCHAR(50)<br>
     * 扣费账号
     */
    private String costAccount;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String bussType;

    /**
     * CHAR(3)<br>
     * 币别
     */
    private String curcd;

    /**
     * VARCHAR(50)<br>
     * 备注
     */
    private String memo;

    /**
     * TIMESTAMP(11,6)<br>
     * 通用日期(扣收日期)
     */
    private Date commonDate;

    /**
     * CHAR(8)<br>
     * 插入日期
     */
    private String insertDate;

    /**
     * VARCHAR(20)<br>
     * 客户经理
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(15)<br>
     * 收费客户号
     */
    private String custcd;

    /**
     * DECIMAL(16,2)<br>
     * 费用小计
     */
    private BigDecimal totalAmt;

    /**
     * VARCHAR(2)<br>
     * 费用阶段
     */
    private String costPhase;

    /**
     * VARCHAR(20)<br>
     * 业务合同号
     */
    private String bussContno;

    /**
     * VARCHAR(50)<br>
     * 交易流水号
     */
    private String txFlowNo;

    /**
     * CHAR(1)<br>
     * 收费类型：1-系统收取、2-线下收取
     */
    private String chargeClass;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 申请类型
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 申请类型
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 费用基本表ID
     */
    public String getCostInfoId() {
        return costInfoId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 费用基本表ID
     */
    public void setCostInfoId(String costInfoId) {
        this.costInfoId = costInfoId == null ? null : costInfoId.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 费用代码
     */
    public String getCostCode() {
        return costCode;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 费用代码
     */
    public void setCostCode(String costCode) {
        this.costCode = costCode == null ? null : costCode.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 费用名称
     */
    public String getCostName() {
        return costName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 费用名称
     */
    public void setCostName(String costName) {
        this.costName = costName == null ? null : costName.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 扣取方式：1-外扣、2-内收
     */
    public String getChargeType() {
        return chargeType;
    }

    /**
     * CHAR(1)<br>
     * 设置 扣取方式：1-外扣、2-内收
     */
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 费用收取种类：1-整体，2-单张
     */
    public String getCostClass() {
        return costClass;
    }

    /**
     * CHAR(1)<br>
     * 设置 费用收取种类：1-整体，2-单张
     */
    public void setCostClass(String costClass) {
        this.costClass = costClass == null ? null : costClass.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 收取方式：1-先收、2-后收、3-免收
     */
    public String getCostType() {
        return costType;
    }

    /**
     * CHAR(1)<br>
     * 设置 收取方式：1-先收、2-后收、3-免收
     */
    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 计算方式：1-固定、2-按比率
     */
    public String getCostCalcType() {
        return costCalcType;
    }

    /**
     * CHAR(1)<br>
     * 设置 计算方式：1-固定、2-按比率
     */
    public void setCostCalcType(String costCalcType) {
        this.costCalcType = costCalcType == null ? null : costCalcType.trim();
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 费用比率
     */
    public BigDecimal getCostRate() {
        return costRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 费用比率
     */
    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    /**
     * CHAR(1)<br>
     * 获得 收取状态：1-已收、2-未收
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 收取状态：1-已收、2-未收
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 业务金额
     */
    public BigDecimal getBussAmt() {
        return bussAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 业务金额
     */
    public void setBussAmt(BigDecimal bussAmt) {
        this.bussAmt = bussAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 固定费用
     */
    public BigDecimal getCostAmt() {
        return costAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 固定费用
     */
    public void setCostAmt(BigDecimal costAmt) {
        this.costAmt = costAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 减免金额
     */
    public BigDecimal getReduceAmt() {
        return reduceAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 减免金额
     */
    public void setReduceAmt(BigDecimal reduceAmt) {
        this.reduceAmt = reduceAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 实收费用金额
     */
    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 实收费用金额
     */
    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 扣费账号
     */
    public String getCostAccount() {
        return costAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 扣费账号
     */
    public void setCostAccount(String costAccount) {
        this.costAccount = costAccount == null ? null : costAccount.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 币别
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * CHAR(3)<br>
     * 设置 币别
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 通用日期(扣收日期)
     */
    public Date getCommonDate() {
        return commonDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 通用日期(扣收日期)
     */
    public void setCommonDate(Date commonDate) {
        this.commonDate = commonDate;
    }

    /**
     * CHAR(8)<br>
     * 获得 插入日期
     */
    public String getInsertDate() {
        return insertDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 插入日期
     */
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate == null ? null : insertDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 客户经理
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 客户经理
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 经办机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 收费客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 收费客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 费用小计
     */
    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 费用小计
     */
    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    /**
     * VARCHAR(2)<br>
     * 获得 费用阶段
     */
    public String getCostPhase() {
        return costPhase;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 费用阶段
     */
    public void setCostPhase(String costPhase) {
        this.costPhase = costPhase == null ? null : costPhase.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务合同号
     */
    public String getBussContno() {
        return bussContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务合同号
     */
    public void setBussContno(String bussContno) {
        this.bussContno = bussContno == null ? null : bussContno.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 交易流水号
     */
    public String getTxFlowNo() {
        return txFlowNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 交易流水号
     */
    public void setTxFlowNo(String txFlowNo) {
        this.txFlowNo = txFlowNo == null ? null : txFlowNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 收费类型：1-系统收取、2-线下收取
     */
    public String getChargeClass() {
        return chargeClass;
    }

    /**
     * CHAR(1)<br>
     * 设置 收费类型：1-系统收取、2-线下收取
     */
    public void setChargeClass(String chargeClass) {
        this.chargeClass = chargeClass == null ? null : chargeClass.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", applyType=").append(applyType);
        sb.append(", costInfoId=").append(costInfoId);
        sb.append(", costCode=").append(costCode);
        sb.append(", costName=").append(costName);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", costClass=").append(costClass);
        sb.append(", costType=").append(costType);
        sb.append(", costCalcType=").append(costCalcType);
        sb.append(", costRate=").append(costRate);
        sb.append(", status=").append(status);
        sb.append(", bussAmt=").append(bussAmt);
        sb.append(", costAmt=").append(costAmt);
        sb.append(", reduceAmt=").append(reduceAmt);
        sb.append(", receiveAmount=").append(receiveAmount);
        sb.append(", costAccount=").append(costAccount);
        sb.append(", bussType=").append(bussType);
        sb.append(", curcd=").append(curcd);
        sb.append(", memo=").append(memo);
        sb.append(", commonDate=").append(commonDate);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", brcode=").append(brcode);
        sb.append(", custcd=").append(custcd);
        sb.append(", totalAmt=").append(totalAmt);
        sb.append(", costPhase=").append(costPhase);
        sb.append(", bussContno=").append(bussContno);
        sb.append(", txFlowNo=").append(txFlowNo);
        sb.append(", chargeClass=").append(chargeClass);
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
        RBcpCostOut other = (RBcpCostOut) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getApplyType() == null ? other.getApplyType() == null : this.getApplyType().equals(other.getApplyType()))
            && (this.getCostInfoId() == null ? other.getCostInfoId() == null : this.getCostInfoId().equals(other.getCostInfoId()))
            && (this.getCostCode() == null ? other.getCostCode() == null : this.getCostCode().equals(other.getCostCode()))
            && (this.getCostName() == null ? other.getCostName() == null : this.getCostName().equals(other.getCostName()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getCostClass() == null ? other.getCostClass() == null : this.getCostClass().equals(other.getCostClass()))
            && (this.getCostType() == null ? other.getCostType() == null : this.getCostType().equals(other.getCostType()))
            && (this.getCostCalcType() == null ? other.getCostCalcType() == null : this.getCostCalcType().equals(other.getCostCalcType()))
            && (this.getCostRate() == null ? other.getCostRate() == null : this.getCostRate().equals(other.getCostRate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBussAmt() == null ? other.getBussAmt() == null : this.getBussAmt().equals(other.getBussAmt()))
            && (this.getCostAmt() == null ? other.getCostAmt() == null : this.getCostAmt().equals(other.getCostAmt()))
            && (this.getReduceAmt() == null ? other.getReduceAmt() == null : this.getReduceAmt().equals(other.getReduceAmt()))
            && (this.getReceiveAmount() == null ? other.getReceiveAmount() == null : this.getReceiveAmount().equals(other.getReceiveAmount()))
            && (this.getCostAccount() == null ? other.getCostAccount() == null : this.getCostAccount().equals(other.getCostAccount()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getCommonDate() == null ? other.getCommonDate() == null : this.getCommonDate().equals(other.getCommonDate()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getTotalAmt() == null ? other.getTotalAmt() == null : this.getTotalAmt().equals(other.getTotalAmt()))
            && (this.getCostPhase() == null ? other.getCostPhase() == null : this.getCostPhase().equals(other.getCostPhase()))
            && (this.getBussContno() == null ? other.getBussContno() == null : this.getBussContno().equals(other.getBussContno()))
            && (this.getTxFlowNo() == null ? other.getTxFlowNo() == null : this.getTxFlowNo().equals(other.getTxFlowNo()))
            && (this.getChargeClass() == null ? other.getChargeClass() == null : this.getChargeClass().equals(other.getChargeClass()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
        result = prime * result + ((getCostInfoId() == null) ? 0 : getCostInfoId().hashCode());
        result = prime * result + ((getCostCode() == null) ? 0 : getCostCode().hashCode());
        result = prime * result + ((getCostName() == null) ? 0 : getCostName().hashCode());
        result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
        result = prime * result + ((getCostClass() == null) ? 0 : getCostClass().hashCode());
        result = prime * result + ((getCostType() == null) ? 0 : getCostType().hashCode());
        result = prime * result + ((getCostCalcType() == null) ? 0 : getCostCalcType().hashCode());
        result = prime * result + ((getCostRate() == null) ? 0 : getCostRate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBussAmt() == null) ? 0 : getBussAmt().hashCode());
        result = prime * result + ((getCostAmt() == null) ? 0 : getCostAmt().hashCode());
        result = prime * result + ((getReduceAmt() == null) ? 0 : getReduceAmt().hashCode());
        result = prime * result + ((getReceiveAmount() == null) ? 0 : getReceiveAmount().hashCode());
        result = prime * result + ((getCostAccount() == null) ? 0 : getCostAccount().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getCommonDate() == null) ? 0 : getCommonDate().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getTotalAmt() == null) ? 0 : getTotalAmt().hashCode());
        result = prime * result + ((getCostPhase() == null) ? 0 : getCostPhase().hashCode());
        result = prime * result + ((getBussContno() == null) ? 0 : getBussContno().hashCode());
        result = prime * result + ((getTxFlowNo() == null) ? 0 : getTxFlowNo().hashCode());
        result = prime * result + ((getChargeClass() == null) ? 0 : getChargeClass().hashCode());
        return result;
    }
}