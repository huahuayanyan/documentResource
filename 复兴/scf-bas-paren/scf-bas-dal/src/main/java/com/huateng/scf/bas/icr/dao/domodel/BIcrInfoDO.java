package com.huateng.scf.bas.icr.dao.domodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BIcrInfoDO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String brcodeName;
    
    public String getBrcodeName() {
		return brcodeName;
	}

	public void setBrcodeName(String brcodeName) {
		this.brcodeName = brcodeName;
	}

	/**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * CHAR(1) 必填<br>
     * 关联类型：1-合同、2-借据
     */
    private String relaType;
    
    /**
     * VARCHAR(100)<br>
     * 业务合同编号
     */
    private String businessNo;
    
    /**
     * VARCHAR(20) 必填<br>
     * 额度编号
     */
    private String creditNo;

    /**
     * CHAR(1)<br>
     * 额度种类：1-直接授信额度、2-第三方授信额度、3-间接额度、4-买方授信限额
     */
    private String creditClass;

    /**
     * VARCHAR(20)<br>
     * 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    private String creditType;

    /**
     * CHAR(1)<br>
     * 节点类型：1-根节点、2-子节点
     */
    private String nodeType;

    /**
     * VARCHAR(100)<br>
     * 上级额度编号
     */
    private String upCreditNo;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(15)<br>
     * 交易对手客户号
     */
    private String otherCustcd;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * CHAR(1)<br>
     * 是否循环：0-非循环、1-循环
     */
    private String controlType;

    /**
     * DECIMAL(16,2)<br>
     * 额度金额
     */
    private BigDecimal creditAmount;

    /**
     * DECIMAL(16,2)<br>
     * 可用额度
     */
    private BigDecimal creditUsableAmount;

    /**
     * DECIMAL(16,2)<br>
     * 预占用额度
     */
    private BigDecimal preUsedAmount;

    /**
     * DECIMAL(16,2)<br>
     * 已占额度
     */
    private BigDecimal usedAmount;

    /**
     * DECIMAL(16,2)<br>
     * 冻结额度
     */
    private BigDecimal frzAmount;

    /**
     * CHAR(1)<br>
     * 状态：1-正常、2-终止
     */
    private String status;

    /**
     * CHAR(8)<br>
     * 额度生效日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 额度到期日期
     */
    private String endDate;

    /**
     * CHAR(6)<br>
     * 期限YYMMDD

010101代表一年零一月零一天
     */
    private String term;

    /**
     * CHAR(8)<br>
     * 审批通过日期
     */
    private String validDate;

    /**
     * VARCHAR(100)<br>
     * 授信批复号
     */
    private String approvalNo;

    /**
     * CHAR(1)<br>
     * 是否要求领用审批
     */
    private String isNeedAudit;

    /**
     * CHAR(1)<br>
     * 审批类型：1-直接授予、2-间接授予
     */
    private String approveType;

    /**
     * VARCHAR(20)<br>
     * 客户经理
     */
    private String mgrno;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String remark;

    /**
     * VARCHAR(20)<br>
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
     * VARCHAR(20)<br>
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
     * CHAR(1) 必填<br>
     * 获得 关联类型：1-合同、2-借据
     */
    public String getRelaType() {
        return relaType;
    }

    /**
     * CHAR(1) 必填<br>
     * 设置 关联类型：1-合同、2-借据
     */
    public void setRelaType(String relaType) {
        this.relaType = relaType == null ? null : relaType.trim();
    }
    
    /**
     * VARCHAR(100)<br>
     * 获得 业务合同编号
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 业务合同编号
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }
    
    /**
     * VARCHAR(20) 必填<br>
     * 获得 额度编号
     */
    public String getCreditNo() {
        return creditNo;
    }
    
    /**
     * VARCHAR(20) 必填<br>
     * 设置 额度编号
     */
    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 额度种类：1-直接授信额度、2-第三方授信额度、3-间接额度、4-买方授信限额
     */
    public String getCreditClass() {
        return creditClass;
    }

    /**
     * CHAR(1)<br>
     * 设置 额度种类：1-直接授信额度、2-第三方授信额度、3-间接额度、4-买方授信限额
     */
    public void setCreditClass(String creditClass) {
        this.creditClass = creditClass == null ? null : creditClass.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 额度类型：保理买方额度、担保提货卖方、先票/款后货卖方、商票保贴交易对手、订单融资的买方
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 节点类型：1-根节点、2-子节点
     */
    public String getNodeType() {
        return nodeType;
    }

    /**
     * CHAR(1)<br>
     * 设置 节点类型：1-根节点、2-子节点
     */
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType == null ? null : nodeType.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 上级额度编号
     */
    public String getUpCreditNo() {
        return upCreditNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 上级额度编号
     */
    public void setUpCreditNo(String upCreditNo) {
        this.upCreditNo = upCreditNo == null ? null : upCreditNo.trim();
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
     * VARCHAR(15)<br>
     * 获得 交易对手客户号
     */
    public String getOtherCustcd() {
        return otherCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 交易对手客户号
     */
    public void setOtherCustcd(String otherCustcd) {
        this.otherCustcd = otherCustcd == null ? null : otherCustcd.trim();
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
     * CHAR(1)<br>
     * 获得 是否循环：0-非循环、1-循环
     */
    public String getControlType() {
        return controlType;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否循环：0-非循环、1-循环
     */
    public void setControlType(String controlType) {
        this.controlType = controlType == null ? null : controlType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 额度金额
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 额度金额
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 可用额度
     */
    public BigDecimal getCreditUsableAmount() {
        return creditUsableAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 可用额度
     */
    public void setCreditUsableAmount(BigDecimal creditUsableAmount) {
        this.creditUsableAmount = creditUsableAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 预占用额度
     */
    public BigDecimal getPreUsedAmount() {
        return preUsedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 预占用额度
     */
    public void setPreUsedAmount(BigDecimal preUsedAmount) {
        this.preUsedAmount = preUsedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已占额度
     */
    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已占额度
     */
    public void setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 冻结额度
     */
    public BigDecimal getFrzAmount() {
        return frzAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 冻结额度
     */
    public void setFrzAmount(BigDecimal frzAmount) {
        this.frzAmount = frzAmount;
    }

    /**
     * CHAR(1)<br>
     * 获得 状态：1-正常、2-终止
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态：1-正常、2-终止
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 额度生效日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 额度生效日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 额度到期日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 额度到期日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * CHAR(6)<br>
     * 获得 期限YYMMDD

010101代表一年零一月零一天
     */
    public String getTerm() {
        return term;
    }

    /**
     * CHAR(6)<br>
     * 设置 期限YYMMDD

010101代表一年零一月零一天
     */
    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 审批通过日期
     */
    public String getValidDate() {
        return validDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 审批通过日期
     */
    public void setValidDate(String validDate) {
        this.validDate = validDate == null ? null : validDate.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 授信批复号
     */
    public String getApprovalNo() {
        return approvalNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 授信批复号
     */
    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo == null ? null : approvalNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否要求领用审批
     */
    public String getIsNeedAudit() {
        return isNeedAudit;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否要求领用审批
     */
    public void setIsNeedAudit(String isNeedAudit) {
        this.isNeedAudit = isNeedAudit == null ? null : isNeedAudit.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 审批类型：1-直接授予、2-间接授予
     */
    public String getApproveType() {
        return approveType;
    }

    /**
     * CHAR(1)<br>
     * 设置 审批类型：1-直接授予、2-间接授予
     */
    public void setApproveType(String approveType) {
        this.approveType = approveType == null ? null : approveType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 客户经理
     */
    public String getMgrno() {
        return mgrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 客户经理
     */
    public void setMgrno(String mgrno) {
        this.mgrno = mgrno == null ? null : mgrno.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
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
     * VARCHAR(20)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(20)<br>
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

}