package com.huateng.scf.bas.nte.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BNteNoticeBill implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 申请编号
     */
    private String appno;

    /**
     * VARCHAR(32)<br>
     * 单据ID
     */
    private String billId;

    /**
     * VARCHAR(10)<br>
     * 期限
     */
    private String loanDays;

    /**
     * VARCHAR(100)<br>
     * 单据号码
     */
    private String billNo;

    /**
     * CHAR(8)<br>
     * 插入日期
     */
    private String insertDate;

    /**
     * CHAR(8)<br>
     * 起始日
     */
    private String billDate;

    /**
     * CHAR(8)<br>
     * 结束日
     */
    private String billEndDate;

    /**
     * CHAR(8)<br>
     * 交易日期
     */
    private String applyDate;

    /**
     * CHAR(8)<br>
     * 扩展日期1
     */
    private String extDate;

    /**
     * DECIMAL(16,2)<br>
     * 金额
     */
    private BigDecimal amount;

    /**
     * DECIMAL(16,2)<br>
     * 扩展金额1
     */
    private BigDecimal ext1Amount;

    /**
     * DECIMAL(16,2)<br>
     * 扩展金额2
     */
    private BigDecimal ext2Amount;

    /**
     * CHAR(1)<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(32)<br>
     * 经办人
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(50)<br>
     * 扩展字段1
     */
    private String ext1;

    /**
     * VARCHAR(100)<br>
     * 扩展字段2
     */
    private String ext2;

    /**
     * VARCHAR(200)<br>
     * 扩展字段3
     */
    private String ext3;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * VARCHAR(50)<br>
     * 提到号
     */
    private String ladingno;

    /**
     * VARCHAR(100)<br>
     * 装箱号
     */
    private String packingno;

    /**
     * CHAR(1)<br>
     * 单据类型
     */
    private String billType;

    /**
     * VARCHAR(256)<br>
     * 单据描述
     */
    private String billsMesc;

    /**
     * VARCHAR(80)<br>
     * 出票人
     */
    private String drawer;

    /**
     * VARCHAR(80)<br>
     * 收款人
     */
    private String payee;

    /**
     * VARCHAR(32)<br>
     * 通知书表主键
     */
    private String pid;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键UUID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键UUID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 单据ID
     */
    public String getBillId() {
        return billId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 单据ID
     */
    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 期限
     */
    public String getLoanDays() {
        return loanDays;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 期限
     */
    public void setLoanDays(String loanDays) {
        this.loanDays = loanDays == null ? null : loanDays.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 单据号码
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 单据号码
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
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
     * CHAR(8)<br>
     * 获得 起始日
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 起始日
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 结束日
     */
    public String getBillEndDate() {
        return billEndDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 结束日
     */
    public void setBillEndDate(String billEndDate) {
        this.billEndDate = billEndDate == null ? null : billEndDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 交易日期
     */
    public String getApplyDate() {
        return applyDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 交易日期
     */
    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate == null ? null : applyDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 扩展日期1
     */
    public String getExtDate() {
        return extDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 扩展日期1
     */
    public void setExtDate(String extDate) {
        this.extDate = extDate == null ? null : extDate.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 扩展金额1
     */
    public BigDecimal getExt1Amount() {
        return ext1Amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 扩展金额1
     */
    public void setExt1Amount(BigDecimal ext1Amount) {
        this.ext1Amount = ext1Amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 扩展金额2
     */
    public BigDecimal getExt2Amount() {
        return ext2Amount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 扩展金额2
     */
    public void setExt2Amount(BigDecimal ext2Amount) {
        this.ext2Amount = ext2Amount;
    }

    /**
     * CHAR(1)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 经办人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 经办人
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
     * VARCHAR(50)<br>
     * 获得 扩展字段1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 扩展字段1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 扩展字段2
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 扩展字段2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 扩展字段3
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 扩展字段3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 提到号
     */
    public String getLadingno() {
        return ladingno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 提到号
     */
    public void setLadingno(String ladingno) {
        this.ladingno = ladingno == null ? null : ladingno.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 装箱号
     */
    public String getPackingno() {
        return packingno;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 装箱号
     */
    public void setPackingno(String packingno) {
        this.packingno = packingno == null ? null : packingno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 单据类型
     */
    public String getBillType() {
        return billType;
    }

    /**
     * CHAR(1)<br>
     * 设置 单据类型
     */
    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 单据描述
     */
    public String getBillsMesc() {
        return billsMesc;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 单据描述
     */
    public void setBillsMesc(String billsMesc) {
        this.billsMesc = billsMesc == null ? null : billsMesc.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 出票人
     */
    public String getDrawer() {
        return drawer;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 出票人
     */
    public void setDrawer(String drawer) {
        this.drawer = drawer == null ? null : drawer.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 收款人
     */
    public String getPayee() {
        return payee;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 收款人
     */
    public void setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 通知书表主键
     */
    public String getPid() {
        return pid;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 通知书表主键
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", billId=").append(billId);
        sb.append(", loanDays=").append(loanDays);
        sb.append(", billNo=").append(billNo);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", billDate=").append(billDate);
        sb.append(", billEndDate=").append(billEndDate);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", extDate=").append(extDate);
        sb.append(", amount=").append(amount);
        sb.append(", ext1Amount=").append(ext1Amount);
        sb.append(", ext2Amount=").append(ext2Amount);
        sb.append(", status=").append(status);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", brcode=").append(brcode);
        sb.append(", ext1=").append(ext1);
        sb.append(", ext2=").append(ext2);
        sb.append(", ext3=").append(ext3);
        sb.append(", memo=").append(memo);
        sb.append(", ladingno=").append(ladingno);
        sb.append(", packingno=").append(packingno);
        sb.append(", billType=").append(billType);
        sb.append(", billsMesc=").append(billsMesc);
        sb.append(", drawer=").append(drawer);
        sb.append(", payee=").append(payee);
        sb.append(", pid=").append(pid);
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
        BNteNoticeBill other = (BNteNoticeBill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getLoanDays() == null ? other.getLoanDays() == null : this.getLoanDays().equals(other.getLoanDays()))
            && (this.getBillNo() == null ? other.getBillNo() == null : this.getBillNo().equals(other.getBillNo()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getBillEndDate() == null ? other.getBillEndDate() == null : this.getBillEndDate().equals(other.getBillEndDate()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getExtDate() == null ? other.getExtDate() == null : this.getExtDate().equals(other.getExtDate()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getExt1Amount() == null ? other.getExt1Amount() == null : this.getExt1Amount().equals(other.getExt1Amount()))
            && (this.getExt2Amount() == null ? other.getExt2Amount() == null : this.getExt2Amount().equals(other.getExt2Amount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
            && (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
            && (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getLadingno() == null ? other.getLadingno() == null : this.getLadingno().equals(other.getLadingno()))
            && (this.getPackingno() == null ? other.getPackingno() == null : this.getPackingno().equals(other.getPackingno()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getBillsMesc() == null ? other.getBillsMesc() == null : this.getBillsMesc().equals(other.getBillsMesc()))
            && (this.getDrawer() == null ? other.getDrawer() == null : this.getDrawer().equals(other.getDrawer()))
            && (this.getPayee() == null ? other.getPayee() == null : this.getPayee().equals(other.getPayee()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getLoanDays() == null) ? 0 : getLoanDays().hashCode());
        result = prime * result + ((getBillNo() == null) ? 0 : getBillNo().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getBillEndDate() == null) ? 0 : getBillEndDate().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getExtDate() == null) ? 0 : getExtDate().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getExt1Amount() == null) ? 0 : getExt1Amount().hashCode());
        result = prime * result + ((getExt2Amount() == null) ? 0 : getExt2Amount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
        result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
        result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getLadingno() == null) ? 0 : getLadingno().hashCode());
        result = prime * result + ((getPackingno() == null) ? 0 : getPackingno().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getBillsMesc() == null) ? 0 : getBillsMesc().hashCode());
        result = prime * result + ((getDrawer() == null) ? 0 : getDrawer().hashCode());
        result = prime * result + ((getPayee() == null) ? 0 : getPayee().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        return result;
    }
}