package com.huateng.scf.bas.mrn.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BMrnAcctBussInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(15) 必填<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(20)<br>
     * 协议号
     */
    private String protocolNo;

    /**
     * VARCHAR(20)<br>
     * 合同号
     */
    private String mastContno;

    /**
     * VARCHAR(32)<br>
     * 借据表主键
     */
    private String debetNo;

    /**
     * VARCHAR(50)<br>
     * 保证金或现金等价物账号
     */
    private String bailAccountno;

    /**
     * VARCHAR(2)<br>
     * 保证金等价物类型：01-存单;02-银票;03-保证金
     */
    private String bailType;

    /**
     * CHAR(2)<br>
     * 保证金初始化类型：01-初始;02-追加;03-最高额
     */
    private String initType;

    /**
     * DECIMAL(16,2)<br>
     * 保证金或现金等价物登记金额
     */
    private BigDecimal bailAmount;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(6,2)<br>
     * 质押率(%)
     */
    private BigDecimal bailRate;

    /**
     * CHAR(2)<br>
     * 保证金及现金等价物确认状态：01-已确认;02-未确认;03-已解押;04-解押中
     */
    private String confirmStatus;

    /**
     * VARCHAR(20)<br>
     * 抵质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(10)<br>
     * 保证金账户性质：活期、定期
     */
    private String bailAcctAttr;

    /**
     * DECIMAL(10,6)<br>
     * 冻结保证金比例
     */
    private BigDecimal bailFrozenPercent;

    /**
     * DECIMAL(16,2)<br>
     * 冻结保证金金额
     */
    private BigDecimal bailFrozenAmt;

    /**
     * VARCHAR(32)<br>
     * 票据ID
     */
    private String billId;

    /**
     * VARCHAR(100)<br>
     * 票据号码
     */
    private String billNo;

    /**
     * VARCHAR(10)<br>
     * 子帐号序号
     */
    private String subAcctSeqno;

    /**
     * VARCHAR(50)<br>
     * 保证金冻结编号
     */
    private String bailFrozenNo;

    /**
     * VARCHAR(20)<br>
     * 业务流水号
     */
    private String appno;

    /**
     * VARCHAR(32)<br>
     * 创建人
     */
    private String tlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date crtTime;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
     */
    private String lastUpdTlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新时间
     */
    private Date lastUpdTime;

    /**
     * VARCHAR(20)<br>
     * 最后更新机构
     */
    private String lastUpdBrcode;

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
     * VARCHAR(15) 必填<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 合同号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 合同号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 借据表主键
     */
    public String getDebetNo() {
        return debetNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 借据表主键
     */
    public void setDebetNo(String debetNo) {
        this.debetNo = debetNo == null ? null : debetNo.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 保证金或现金等价物账号
     */
    public String getBailAccountno() {
        return bailAccountno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 保证金或现金等价物账号
     */
    public void setBailAccountno(String bailAccountno) {
        this.bailAccountno = bailAccountno == null ? null : bailAccountno.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 保证金等价物类型：01-存单;02-银票;03-保证金
     */
    public String getBailType() {
        return bailType;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 保证金等价物类型：01-存单;02-银票;03-保证金
     */
    public void setBailType(String bailType) {
        this.bailType = bailType == null ? null : bailType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 保证金初始化类型：01-初始;02-追加;03-最高额
     */
    public String getInitType() {
        return initType;
    }

    /**
     * CHAR(2)<br>
     * 设置 保证金初始化类型：01-初始;02-追加;03-最高额
     */
    public void setInitType(String initType) {
        this.initType = initType == null ? null : initType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保证金或现金等价物登记金额
     */
    public BigDecimal getBailAmount() {
        return bailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金或现金等价物登记金额
     */
    public void setBailAmount(BigDecimal bailAmount) {
        this.bailAmount = bailAmount;
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
     * DECIMAL(6,2)<br>
     * 获得 质押率(%)
     */
    public BigDecimal getBailRate() {
        return bailRate;
    }

    /**
     * DECIMAL(6,2)<br>
     * 设置 质押率(%)
     */
    public void setBailRate(BigDecimal bailRate) {
        this.bailRate = bailRate;
    }

    /**
     * CHAR(2)<br>
     * 获得 保证金及现金等价物确认状态：01-已确认;02-未确认;03-已解押;04-解押中
     */
    public String getConfirmStatus() {
        return confirmStatus;
    }

    /**
     * CHAR(2)<br>
     * 设置 保证金及现金等价物确认状态：01-已确认;02-未确认;03-已解押;04-解押中
     */
    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus == null ? null : confirmStatus.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 抵质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 抵质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 保证金账户性质：活期、定期
     */
    public String getBailAcctAttr() {
        return bailAcctAttr;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 保证金账户性质：活期、定期
     */
    public void setBailAcctAttr(String bailAcctAttr) {
        this.bailAcctAttr = bailAcctAttr == null ? null : bailAcctAttr.trim();
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 冻结保证金比例
     */
    public BigDecimal getBailFrozenPercent() {
        return bailFrozenPercent;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 冻结保证金比例
     */
    public void setBailFrozenPercent(BigDecimal bailFrozenPercent) {
        this.bailFrozenPercent = bailFrozenPercent;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 冻结保证金金额
     */
    public BigDecimal getBailFrozenAmt() {
        return bailFrozenAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 冻结保证金金额
     */
    public void setBailFrozenAmt(BigDecimal bailFrozenAmt) {
        this.bailFrozenAmt = bailFrozenAmt;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 票据ID
     */
    public String getBillId() {
        return billId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 票据ID
     */
    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 票据号码
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 票据号码
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 子帐号序号
     */
    public String getSubAcctSeqno() {
        return subAcctSeqno;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 子帐号序号
     */
    public void setSubAcctSeqno(String subAcctSeqno) {
        this.subAcctSeqno = subAcctSeqno == null ? null : subAcctSeqno.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 保证金冻结编号
     */
    public String getBailFrozenNo() {
        return bailFrozenNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 保证金冻结编号
     */
    public void setBailFrozenNo(String bailFrozenNo) {
        this.bailFrozenNo = bailFrozenNo == null ? null : bailFrozenNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务流水号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务流水号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 创建人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
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
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员
     */
    public void setLastUpdTlrcd(String lastUpdTlrcd) {
        this.lastUpdTlrcd = lastUpdTlrcd == null ? null : lastUpdTlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最后更新时间
     */
    public Date getLastUpdTime() {
        return lastUpdTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最后更新时间
     */
    public void setLastUpdTime(Date lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 最后更新机构
     */
    public String getLastUpdBrcode() {
        return lastUpdBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 最后更新机构
     */
    public void setLastUpdBrcode(String lastUpdBrcode) {
        this.lastUpdBrcode = lastUpdBrcode == null ? null : lastUpdBrcode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custcd=").append(custcd);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", debetNo=").append(debetNo);
        sb.append(", bailAccountno=").append(bailAccountno);
        sb.append(", bailType=").append(bailType);
        sb.append(", initType=").append(initType);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", curcd=").append(curcd);
        sb.append(", bailRate=").append(bailRate);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", bailAcctAttr=").append(bailAcctAttr);
        sb.append(", bailFrozenPercent=").append(bailFrozenPercent);
        sb.append(", bailFrozenAmt=").append(bailFrozenAmt);
        sb.append(", billId=").append(billId);
        sb.append(", billNo=").append(billNo);
        sb.append(", subAcctSeqno=").append(subAcctSeqno);
        sb.append(", bailFrozenNo=").append(bailFrozenNo);
        sb.append(", appno=").append(appno);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", crtTime=").append(crtTime);
        sb.append(", brcode=").append(brcode);
        sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
        sb.append(", lastUpdTime=").append(lastUpdTime);
        sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
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
        BMrnAcctBussInfo other = (BMrnAcctBussInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getDebetNo() == null ? other.getDebetNo() == null : this.getDebetNo().equals(other.getDebetNo()))
            && (this.getBailAccountno() == null ? other.getBailAccountno() == null : this.getBailAccountno().equals(other.getBailAccountno()))
            && (this.getBailType() == null ? other.getBailType() == null : this.getBailType().equals(other.getBailType()))
            && (this.getInitType() == null ? other.getInitType() == null : this.getInitType().equals(other.getInitType()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getBailRate() == null ? other.getBailRate() == null : this.getBailRate().equals(other.getBailRate()))
            && (this.getConfirmStatus() == null ? other.getConfirmStatus() == null : this.getConfirmStatus().equals(other.getConfirmStatus()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getBailAcctAttr() == null ? other.getBailAcctAttr() == null : this.getBailAcctAttr().equals(other.getBailAcctAttr()))
            && (this.getBailFrozenPercent() == null ? other.getBailFrozenPercent() == null : this.getBailFrozenPercent().equals(other.getBailFrozenPercent()))
            && (this.getBailFrozenAmt() == null ? other.getBailFrozenAmt() == null : this.getBailFrozenAmt().equals(other.getBailFrozenAmt()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillNo() == null ? other.getBillNo() == null : this.getBillNo().equals(other.getBillNo()))
            && (this.getSubAcctSeqno() == null ? other.getSubAcctSeqno() == null : this.getSubAcctSeqno().equals(other.getSubAcctSeqno()))
            && (this.getBailFrozenNo() == null ? other.getBailFrozenNo() == null : this.getBailFrozenNo().equals(other.getBailFrozenNo()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getDebetNo() == null) ? 0 : getDebetNo().hashCode());
        result = prime * result + ((getBailAccountno() == null) ? 0 : getBailAccountno().hashCode());
        result = prime * result + ((getBailType() == null) ? 0 : getBailType().hashCode());
        result = prime * result + ((getInitType() == null) ? 0 : getInitType().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getBailRate() == null) ? 0 : getBailRate().hashCode());
        result = prime * result + ((getConfirmStatus() == null) ? 0 : getConfirmStatus().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getBailAcctAttr() == null) ? 0 : getBailAcctAttr().hashCode());
        result = prime * result + ((getBailFrozenPercent() == null) ? 0 : getBailFrozenPercent().hashCode());
        result = prime * result + ((getBailFrozenAmt() == null) ? 0 : getBailFrozenAmt().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillNo() == null) ? 0 : getBillNo().hashCode());
        result = prime * result + ((getSubAcctSeqno() == null) ? 0 : getSubAcctSeqno().hashCode());
        result = prime * result + ((getBailFrozenNo() == null) ? 0 : getBailFrozenNo().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}