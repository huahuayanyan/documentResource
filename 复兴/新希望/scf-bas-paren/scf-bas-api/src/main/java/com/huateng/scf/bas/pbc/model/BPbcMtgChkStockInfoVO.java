package com.huateng.scf.bas.pbc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcMtgChkStockInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 关联协议号
     */
    private String otherProtocolNo;

    /**
     * VARCHAR(20)<br>
     * 质押合同号
     */
    private String slaveContno;

    /**
     * CHAR(8)<br>
     * 核库日期
     */
    private String checkStockDate;

    /**
     * TIMESTAMP(11,6)<br>
     * 核库时间
     */
    private Date checkStockTime;

    /**
     * VARCHAR(32)<br>
     * 核库人
     */
    private String checkStockTlrcd;

    /**
     * CHAR(2)<br>
     * 核库类型
     */
    private String checkStockType;

    /**
     * CHAR(2)<br>
     * 核库方式
     */
    private String checkStockWay;

    /**
     * CHAR(2)<br>
     * 核库结果
     */
    private String checkStockResults;

    /**
     * VARCHAR(32)<br>
     * 登记人
     */
    private String recordTlrcd;

    /**
     * VARCHAR(20)<br>
     * 登记机构
     */
    private String recordBrcode;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(20)<br>
     * 仓库编号
     */
    private String warehouseId;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniOfCustcd;

    /**
     * CHAR(2)<br>
     * 状态：00-未提交；01-有效；02-无效
     */
    private String status;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * CHAR(1)<br>
     * 权属检查
     */
    private String powerCheckType;

    /**
     * VARCHAR(200)<br>
     * 权属检查存在瑕疵的原因
     */
    private String powerCheckFaildes;

    /**
     * VARCHAR(200)<br>
     * 权属检查其它说明
     */
    private String powerCheckOtherdes;

    /**
     * CHAR(1)<br>
     * 监管场地
     */
    private String checkAddressType;

    /**
     * VARCHAR(200)<br>
     * 监管场地不符合的原因
     */
    private String checkAddressFaildes;

    /**
     * CHAR(1)<br>
     * 是否需要检验
     */
    private String checkNeedType;

    /**
     * CHAR(1)<br>
     * 检验方式
     */
    private String checkMethodType;

    /**
     * DECIMAL(6,4)<br>
     * 检验依据
     */
    private BigDecimal checkMethodData;

    /**
     * CHAR(1)<br>
     * 检验结果
     */
    private String checkResultType;

    /**
     * VARCHAR(200)<br>
     * 检验不达标原因
     */
    private String checkResultFaildes;

    /**
     * VARCHAR(20)<br>
     * 核库报告编号
     */
    private String checkReportNo;

    /**
     * DECIMAL(16,2)<br>
     * 当前授信敞口
     */
    private BigDecimal currentCreditAmt;

    /**
     * DECIMAL(5,2)<br>
     * 质押率
     */
    private BigDecimal ration;

    /**
     * CHAR(2)<br>
     * 是否跌破监管下限
     */
    private String checkLowPriceType;

    /**
     * CHAR(1)<br>
     * 是否有发货
     */
    private String invoiceFlag;

    /**
     * VARCHAR(20)<br>
     * 通知书编号
     */
    private String noticeNo;

    /**
     * VARCHAR(500)<br>
     * 原因
     */
    private String reason;

    /**
     * VARCHAR(50)<br>
     * 库存通知编号
     */
    private String adviceid;

    /**
     * VARCHAR(50)<br>
     * 外系统流水号
     */
    private String applyid;

    /**
     * VARCHAR(20)<br>
     * 协议号
     */
    private String protocolNo;

    /**
     * VARCHAR(100)<br>
     * 仓库名
     */
    private String warehouseName;

    /**
     * VARCHAR(20)<br>
     * 业务申请编号
     */
    private String appno;

    /**
     * VARCHAR(100)<br>
     * 监管方负责人
     */
    private String moniPrincipal;

    /**
     * CHAR(8)<br>
     * 对账确认日期
     */
    private String checkStockConfirmDate;

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
     * 获得 关联协议号
     */
    public String getOtherProtocolNo() {
        return otherProtocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 关联协议号
     */
    public void setOtherProtocolNo(String otherProtocolNo) {
        this.otherProtocolNo = otherProtocolNo == null ? null : otherProtocolNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 核库日期
     */
    public String getCheckStockDate() {
        return checkStockDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 核库日期
     */
    public void setCheckStockDate(String checkStockDate) {
        this.checkStockDate = checkStockDate == null ? null : checkStockDate.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 核库时间
     */
    public Date getCheckStockTime() {
        return checkStockTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 核库时间
     */
    public void setCheckStockTime(Date checkStockTime) {
        this.checkStockTime = checkStockTime;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 核库人
     */
    public String getCheckStockTlrcd() {
        return checkStockTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 核库人
     */
    public void setCheckStockTlrcd(String checkStockTlrcd) {
        this.checkStockTlrcd = checkStockTlrcd == null ? null : checkStockTlrcd.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 核库类型
     */
    public String getCheckStockType() {
        return checkStockType;
    }

    /**
     * CHAR(2)<br>
     * 设置 核库类型
     */
    public void setCheckStockType(String checkStockType) {
        this.checkStockType = checkStockType == null ? null : checkStockType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 核库方式
     */
    public String getCheckStockWay() {
        return checkStockWay;
    }

    /**
     * CHAR(2)<br>
     * 设置 核库方式
     */
    public void setCheckStockWay(String checkStockWay) {
        this.checkStockWay = checkStockWay == null ? null : checkStockWay.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 核库结果
     */
    public String getCheckStockResults() {
        return checkStockResults;
    }

    /**
     * CHAR(2)<br>
     * 设置 核库结果
     */
    public void setCheckStockResults(String checkStockResults) {
        this.checkStockResults = checkStockResults == null ? null : checkStockResults.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记人
     */
    public String getRecordTlrcd() {
        return recordTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记人
     */
    public void setRecordTlrcd(String recordTlrcd) {
        this.recordTlrcd = recordTlrcd == null ? null : recordTlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 登记机构
     */
    public String getRecordBrcode() {
        return recordBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 登记机构
     */
    public void setRecordBrcode(String recordBrcode) {
        this.recordBrcode = recordBrcode == null ? null : recordBrcode.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 仓库编号
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 仓库编号
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管公司客户号
     */
    public String getMoniOfCustcd() {
        return moniOfCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管公司客户号
     */
    public void setMoniOfCustcd(String moniOfCustcd) {
        this.moniOfCustcd = moniOfCustcd == null ? null : moniOfCustcd.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 状态：00-未提交；01-有效；02-无效
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(2)<br>
     * 设置 状态：00-未提交；01-有效；02-无效
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 主合同号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 主合同号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 权属检查
     */
    public String getPowerCheckType() {
        return powerCheckType;
    }

    /**
     * CHAR(1)<br>
     * 设置 权属检查
     */
    public void setPowerCheckType(String powerCheckType) {
        this.powerCheckType = powerCheckType == null ? null : powerCheckType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 权属检查存在瑕疵的原因
     */
    public String getPowerCheckFaildes() {
        return powerCheckFaildes;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 权属检查存在瑕疵的原因
     */
    public void setPowerCheckFaildes(String powerCheckFaildes) {
        this.powerCheckFaildes = powerCheckFaildes == null ? null : powerCheckFaildes.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 权属检查其它说明
     */
    public String getPowerCheckOtherdes() {
        return powerCheckOtherdes;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 权属检查其它说明
     */
    public void setPowerCheckOtherdes(String powerCheckOtherdes) {
        this.powerCheckOtherdes = powerCheckOtherdes == null ? null : powerCheckOtherdes.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 监管场地
     */
    public String getCheckAddressType() {
        return checkAddressType;
    }

    /**
     * CHAR(1)<br>
     * 设置 监管场地
     */
    public void setCheckAddressType(String checkAddressType) {
        this.checkAddressType = checkAddressType == null ? null : checkAddressType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 监管场地不符合的原因
     */
    public String getCheckAddressFaildes() {
        return checkAddressFaildes;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 监管场地不符合的原因
     */
    public void setCheckAddressFaildes(String checkAddressFaildes) {
        this.checkAddressFaildes = checkAddressFaildes == null ? null : checkAddressFaildes.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否需要检验
     */
    public String getCheckNeedType() {
        return checkNeedType;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否需要检验
     */
    public void setCheckNeedType(String checkNeedType) {
        this.checkNeedType = checkNeedType == null ? null : checkNeedType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 检验方式
     */
    public String getCheckMethodType() {
        return checkMethodType;
    }

    /**
     * CHAR(1)<br>
     * 设置 检验方式
     */
    public void setCheckMethodType(String checkMethodType) {
        this.checkMethodType = checkMethodType == null ? null : checkMethodType.trim();
    }

    /**
     * DECIMAL(6,4)<br>
     * 获得 检验依据
     */
    public BigDecimal getCheckMethodData() {
        return checkMethodData;
    }

    /**
     * DECIMAL(6,4)<br>
     * 设置 检验依据
     */
    public void setCheckMethodData(BigDecimal checkMethodData) {
        this.checkMethodData = checkMethodData;
    }

    /**
     * CHAR(1)<br>
     * 获得 检验结果
     */
    public String getCheckResultType() {
        return checkResultType;
    }

    /**
     * CHAR(1)<br>
     * 设置 检验结果
     */
    public void setCheckResultType(String checkResultType) {
        this.checkResultType = checkResultType == null ? null : checkResultType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 检验不达标原因
     */
    public String getCheckResultFaildes() {
        return checkResultFaildes;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 检验不达标原因
     */
    public void setCheckResultFaildes(String checkResultFaildes) {
        this.checkResultFaildes = checkResultFaildes == null ? null : checkResultFaildes.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 核库报告编号
     */
    public String getCheckReportNo() {
        return checkReportNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 核库报告编号
     */
    public void setCheckReportNo(String checkReportNo) {
        this.checkReportNo = checkReportNo == null ? null : checkReportNo.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 当前授信敞口
     */
    public BigDecimal getCurrentCreditAmt() {
        return currentCreditAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 当前授信敞口
     */
    public void setCurrentCreditAmt(BigDecimal currentCreditAmt) {
        this.currentCreditAmt = currentCreditAmt;
    }

    /**
     * DECIMAL(5,2)<br>
     * 获得 质押率
     */
    public BigDecimal getRation() {
        return ration;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 质押率
     */
    public void setRation(BigDecimal ration) {
        this.ration = ration;
    }

    /**
     * CHAR(2)<br>
     * 获得 是否跌破监管下限
     */
    public String getCheckLowPriceType() {
        return checkLowPriceType;
    }

    /**
     * CHAR(2)<br>
     * 设置 是否跌破监管下限
     */
    public void setCheckLowPriceType(String checkLowPriceType) {
        this.checkLowPriceType = checkLowPriceType == null ? null : checkLowPriceType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否有发货
     */
    public String getInvoiceFlag() {
        return invoiceFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否有发货
     */
    public void setInvoiceFlag(String invoiceFlag) {
        this.invoiceFlag = invoiceFlag == null ? null : invoiceFlag.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 通知书编号
     */
    public String getNoticeNo() {
        return noticeNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 通知书编号
     */
    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo == null ? null : noticeNo.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 库存通知编号
     */
    public String getAdviceid() {
        return adviceid;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 库存通知编号
     */
    public void setAdviceid(String adviceid) {
        this.adviceid = adviceid == null ? null : adviceid.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 外系统流水号
     */
    public String getApplyid() {
        return applyid;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 外系统流水号
     */
    public void setApplyid(String applyid) {
        this.applyid = applyid == null ? null : applyid.trim();
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
     * VARCHAR(100)<br>
     * 获得 仓库名
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 仓库名
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 监管方负责人
     */
    public String getMoniPrincipal() {
        return moniPrincipal;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 监管方负责人
     */
    public void setMoniPrincipal(String moniPrincipal) {
        this.moniPrincipal = moniPrincipal == null ? null : moniPrincipal.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 对账确认日期
     */
    public String getCheckStockConfirmDate() {
        return checkStockConfirmDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 对账确认日期
     */
    public void setCheckStockConfirmDate(String checkStockConfirmDate) {
        this.checkStockConfirmDate = checkStockConfirmDate == null ? null : checkStockConfirmDate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", otherProtocolNo=").append(otherProtocolNo);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", checkStockDate=").append(checkStockDate);
        sb.append(", checkStockTime=").append(checkStockTime);
        sb.append(", checkStockTlrcd=").append(checkStockTlrcd);
        sb.append(", checkStockType=").append(checkStockType);
        sb.append(", checkStockWay=").append(checkStockWay);
        sb.append(", checkStockResults=").append(checkStockResults);
        sb.append(", recordTlrcd=").append(recordTlrcd);
        sb.append(", recordBrcode=").append(recordBrcode);
        sb.append(", custcd=").append(custcd);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", moniOfCustcd=").append(moniOfCustcd);
        sb.append(", status=").append(status);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", powerCheckType=").append(powerCheckType);
        sb.append(", powerCheckFaildes=").append(powerCheckFaildes);
        sb.append(", powerCheckOtherdes=").append(powerCheckOtherdes);
        sb.append(", checkAddressType=").append(checkAddressType);
        sb.append(", checkAddressFaildes=").append(checkAddressFaildes);
        sb.append(", checkNeedType=").append(checkNeedType);
        sb.append(", checkMethodType=").append(checkMethodType);
        sb.append(", checkMethodData=").append(checkMethodData);
        sb.append(", checkResultType=").append(checkResultType);
        sb.append(", checkResultFaildes=").append(checkResultFaildes);
        sb.append(", checkReportNo=").append(checkReportNo);
        sb.append(", currentCreditAmt=").append(currentCreditAmt);
        sb.append(", ration=").append(ration);
        sb.append(", checkLowPriceType=").append(checkLowPriceType);
        sb.append(", invoiceFlag=").append(invoiceFlag);
        sb.append(", noticeNo=").append(noticeNo);
        sb.append(", reason=").append(reason);
        sb.append(", adviceid=").append(adviceid);
        sb.append(", applyid=").append(applyid);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", warehouseName=").append(warehouseName);
        sb.append(", appno=").append(appno);
        sb.append(", moniPrincipal=").append(moniPrincipal);
        sb.append(", checkStockConfirmDate=").append(checkStockConfirmDate);
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
        BPbcMtgChkStockInfoVO other = (BPbcMtgChkStockInfoVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOtherProtocolNo() == null ? other.getOtherProtocolNo() == null : this.getOtherProtocolNo().equals(other.getOtherProtocolNo()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getCheckStockDate() == null ? other.getCheckStockDate() == null : this.getCheckStockDate().equals(other.getCheckStockDate()))
            && (this.getCheckStockTime() == null ? other.getCheckStockTime() == null : this.getCheckStockTime().equals(other.getCheckStockTime()))
            && (this.getCheckStockTlrcd() == null ? other.getCheckStockTlrcd() == null : this.getCheckStockTlrcd().equals(other.getCheckStockTlrcd()))
            && (this.getCheckStockType() == null ? other.getCheckStockType() == null : this.getCheckStockType().equals(other.getCheckStockType()))
            && (this.getCheckStockWay() == null ? other.getCheckStockWay() == null : this.getCheckStockWay().equals(other.getCheckStockWay()))
            && (this.getCheckStockResults() == null ? other.getCheckStockResults() == null : this.getCheckStockResults().equals(other.getCheckStockResults()))
            && (this.getRecordTlrcd() == null ? other.getRecordTlrcd() == null : this.getRecordTlrcd().equals(other.getRecordTlrcd()))
            && (this.getRecordBrcode() == null ? other.getRecordBrcode() == null : this.getRecordBrcode().equals(other.getRecordBrcode()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
            && (this.getMoniOfCustcd() == null ? other.getMoniOfCustcd() == null : this.getMoniOfCustcd().equals(other.getMoniOfCustcd()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getPowerCheckType() == null ? other.getPowerCheckType() == null : this.getPowerCheckType().equals(other.getPowerCheckType()))
            && (this.getPowerCheckFaildes() == null ? other.getPowerCheckFaildes() == null : this.getPowerCheckFaildes().equals(other.getPowerCheckFaildes()))
            && (this.getPowerCheckOtherdes() == null ? other.getPowerCheckOtherdes() == null : this.getPowerCheckOtherdes().equals(other.getPowerCheckOtherdes()))
            && (this.getCheckAddressType() == null ? other.getCheckAddressType() == null : this.getCheckAddressType().equals(other.getCheckAddressType()))
            && (this.getCheckAddressFaildes() == null ? other.getCheckAddressFaildes() == null : this.getCheckAddressFaildes().equals(other.getCheckAddressFaildes()))
            && (this.getCheckNeedType() == null ? other.getCheckNeedType() == null : this.getCheckNeedType().equals(other.getCheckNeedType()))
            && (this.getCheckMethodType() == null ? other.getCheckMethodType() == null : this.getCheckMethodType().equals(other.getCheckMethodType()))
            && (this.getCheckMethodData() == null ? other.getCheckMethodData() == null : this.getCheckMethodData().equals(other.getCheckMethodData()))
            && (this.getCheckResultType() == null ? other.getCheckResultType() == null : this.getCheckResultType().equals(other.getCheckResultType()))
            && (this.getCheckResultFaildes() == null ? other.getCheckResultFaildes() == null : this.getCheckResultFaildes().equals(other.getCheckResultFaildes()))
            && (this.getCheckReportNo() == null ? other.getCheckReportNo() == null : this.getCheckReportNo().equals(other.getCheckReportNo()))
            && (this.getCurrentCreditAmt() == null ? other.getCurrentCreditAmt() == null : this.getCurrentCreditAmt().equals(other.getCurrentCreditAmt()))
            && (this.getRation() == null ? other.getRation() == null : this.getRation().equals(other.getRation()))
            && (this.getCheckLowPriceType() == null ? other.getCheckLowPriceType() == null : this.getCheckLowPriceType().equals(other.getCheckLowPriceType()))
            && (this.getInvoiceFlag() == null ? other.getInvoiceFlag() == null : this.getInvoiceFlag().equals(other.getInvoiceFlag()))
            && (this.getNoticeNo() == null ? other.getNoticeNo() == null : this.getNoticeNo().equals(other.getNoticeNo()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getAdviceid() == null ? other.getAdviceid() == null : this.getAdviceid().equals(other.getAdviceid()))
            && (this.getApplyid() == null ? other.getApplyid() == null : this.getApplyid().equals(other.getApplyid()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getWarehouseName() == null ? other.getWarehouseName() == null : this.getWarehouseName().equals(other.getWarehouseName()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getMoniPrincipal() == null ? other.getMoniPrincipal() == null : this.getMoniPrincipal().equals(other.getMoniPrincipal()))
            && (this.getCheckStockConfirmDate() == null ? other.getCheckStockConfirmDate() == null : this.getCheckStockConfirmDate().equals(other.getCheckStockConfirmDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOtherProtocolNo() == null) ? 0 : getOtherProtocolNo().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getCheckStockDate() == null) ? 0 : getCheckStockDate().hashCode());
        result = prime * result + ((getCheckStockTime() == null) ? 0 : getCheckStockTime().hashCode());
        result = prime * result + ((getCheckStockTlrcd() == null) ? 0 : getCheckStockTlrcd().hashCode());
        result = prime * result + ((getCheckStockType() == null) ? 0 : getCheckStockType().hashCode());
        result = prime * result + ((getCheckStockWay() == null) ? 0 : getCheckStockWay().hashCode());
        result = prime * result + ((getCheckStockResults() == null) ? 0 : getCheckStockResults().hashCode());
        result = prime * result + ((getRecordTlrcd() == null) ? 0 : getRecordTlrcd().hashCode());
        result = prime * result + ((getRecordBrcode() == null) ? 0 : getRecordBrcode().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getMoniOfCustcd() == null) ? 0 : getMoniOfCustcd().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getPowerCheckType() == null) ? 0 : getPowerCheckType().hashCode());
        result = prime * result + ((getPowerCheckFaildes() == null) ? 0 : getPowerCheckFaildes().hashCode());
        result = prime * result + ((getPowerCheckOtherdes() == null) ? 0 : getPowerCheckOtherdes().hashCode());
        result = prime * result + ((getCheckAddressType() == null) ? 0 : getCheckAddressType().hashCode());
        result = prime * result + ((getCheckAddressFaildes() == null) ? 0 : getCheckAddressFaildes().hashCode());
        result = prime * result + ((getCheckNeedType() == null) ? 0 : getCheckNeedType().hashCode());
        result = prime * result + ((getCheckMethodType() == null) ? 0 : getCheckMethodType().hashCode());
        result = prime * result + ((getCheckMethodData() == null) ? 0 : getCheckMethodData().hashCode());
        result = prime * result + ((getCheckResultType() == null) ? 0 : getCheckResultType().hashCode());
        result = prime * result + ((getCheckResultFaildes() == null) ? 0 : getCheckResultFaildes().hashCode());
        result = prime * result + ((getCheckReportNo() == null) ? 0 : getCheckReportNo().hashCode());
        result = prime * result + ((getCurrentCreditAmt() == null) ? 0 : getCurrentCreditAmt().hashCode());
        result = prime * result + ((getRation() == null) ? 0 : getRation().hashCode());
        result = prime * result + ((getCheckLowPriceType() == null) ? 0 : getCheckLowPriceType().hashCode());
        result = prime * result + ((getInvoiceFlag() == null) ? 0 : getInvoiceFlag().hashCode());
        result = prime * result + ((getNoticeNo() == null) ? 0 : getNoticeNo().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getAdviceid() == null) ? 0 : getAdviceid().hashCode());
        result = prime * result + ((getApplyid() == null) ? 0 : getApplyid().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getWarehouseName() == null) ? 0 : getWarehouseName().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getMoniPrincipal() == null) ? 0 : getMoniPrincipal().hashCode());
        result = prime * result + ((getCheckStockConfirmDate() == null) ? 0 : getCheckStockConfirmDate().hashCode());
        return result;
    }
}