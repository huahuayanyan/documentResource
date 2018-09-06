package com.huateng.scf.bas.pbc.dao.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppliBaseBillNormalInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(20) 必填<br>
     * 申请号
     */
    private String appno;

    /**
     * VARCHAR(32)<br>
     * 工作流实例号
     */
    private String piid;

    /**
     * CHAR(4)<br>
     * 申请类型
     */
    private String appliType;

    /**
     * VARCHAR(250)<br>
     * 模板名
     */
    private String processTemplateName;

    /**
     * CHAR(2)<br>
     * 业务编号类型：01-主合同号、02-质押合同号、03-协议编号、04-客户号
     */
    private String businessnoType;

    /**
     * VARCHAR(20)<br>
     * 业务编号(根据业务编号类型存放对应的值)
     */
    private String businessno;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custcd;

    /**
     * DECIMAL(16,2)<br>
     * 业务金额
     */
    private BigDecimal amt;

    /**
     * VARCHAR(20)<br>
     * 流程发起机构
     */
    private String startBrcode;

    /**
     * VARCHAR(32)<br>
     * 流程发起人
     */
    private String startTlrcd;

    /**
     * CHAR(8)<br>
     * 发起日期
     */
    private String stratDate;

    /**
     * TIMESTAMP(11,6)<br>
     * 发起时间
     */
    private Date startTime;

    /**
     * CHAR(2)<br>
     * 申请类型
     */
    private String appliStatus;

    /**
     * VARCHAR(20)<br>
     * 审批机构
     */
    private String approveBrcode;

    /**
     * VARCHAR(32)<br>
     * 审批人
     */
    private String approver;

    /**
     * CHAR(8)<br>
     * 审批日期
     */
    private String approveDate;

    /**
     * TIMESTAMP(11,6)<br>
     * 审批时间
     */
    private Date approveTime;

    /**
     * VARCHAR(30)<br>
     * 工作流申请号
     */
    private String workflowAppno;

    /**
     * CHAR(3)<br>
     * 申请状态
     */
    private String appliStatusDtl;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * CHAR(8)<br>
     * 申请日期
     */
    private String appDate;

    /**
     * VARCHAR(32)<br>
     * 申请人
     */
    private String appTlrcd;

    /**
     * VARCHAR(20)<br>
     * 申请机构
     */
    private String appBrcode;

    /**
     * DECIMAL(16,2)<br>
     * 保证金金额
     */
    private BigDecimal bailAmount;

    /**
     * VARCHAR(20)<br>
     * 抵质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(20)<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(20)<br>
     * 协议号
     */
    private String protocolNo;

    /**
     * CHAR(4)<br>
     * 供应链产品类型
     */
    private String supplyChainPdId;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * VARCHAR(50)<br>
     * 信贷系统流水号
     */
    private String incomeAppno;

    /**
     * VARCHAR(15)<br>
     * 监管公司客户号
     */
    private String moniCustcd;

    /**
     * CHAR(1)<br>
     * 质押模式：1-动态、2-静态
     */
    private String pledgeMode;

    /**
     * VARCHAR(20)<br>
     * 关联协议号
     */
    private String otherProtocolNo;

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
     * VARCHAR(50)<br>
     * 网银流水号
     */
    private String ebankAppno;

    /**
     * VARCHAR(200)<br>
     * 信贷合同号
     */
    private String mastContcode;

    /**
     * CHAR(1)<br>
     * 渠道标识：1-供应链、2-企业网银、3-信贷系统
     */
    private String channelFlag;

    /**
     * CHAR(1)<br>
     * 流程是否结束：0-否、1-是
     */
    private String isFlowEnd;

    /**
     * VARCHAR(32)<br>
     * IFSP申请号
     */
    private String ifspAppno;

    /**
     * VARCHAR(32)<br>
     * IFSP订单编号
     */
    private String ifspOrderNo;
    
    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String billno;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String billcode;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String address;

    /**
     * CHAR(6)<br>
     * 
     */
    private String postno;

    /**
     * VARCHAR(19)<br>
     * 
     */
    private String warehouseId;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String storageAddress;

    /**
     * DATE(7)<br>
     * 
     */
    private Date signDate;

    /**
     * VARCHAR(30)<br>
     * 
     */
    private String phone;

    /**
     * VARCHAR(30)<br>
     * 
     */
    private String fax;

    /**
     * CHAR(8)<br>
     * 
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 
     */
    private String endDate;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String standLose;

    /**
     * CHAR(8)<br>
     * 
     */
    private String storageCostEndDate;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String tlrcd;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String status;

    /**
     * VARCHAR(500)<br>
     * 
     */
    private String reason;

    /**
     * VARCHAR(20) 必填<br>
     * 获得 申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 工作流实例号
     */
    public String getPiid() {
        return piid;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 工作流实例号
     */
    public void setPiid(String piid) {
        this.piid = piid == null ? null : piid.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 申请类型
     */
    public String getAppliType() {
        return appliType;
    }

    /**
     * CHAR(4)<br>
     * 设置 申请类型
     */
    public void setAppliType(String appliType) {
        this.appliType = appliType == null ? null : appliType.trim();
    }

    /**
     * VARCHAR(250)<br>
     * 获得 模板名
     */
    public String getProcessTemplateName() {
        return processTemplateName;
    }

    /**
     * VARCHAR(250)<br>
     * 设置 模板名
     */
    public void setProcessTemplateName(String processTemplateName) {
        this.processTemplateName = processTemplateName == null ? null : processTemplateName.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 业务编号类型：01-主合同号、02-质押合同号、03-协议编号、04-客户号
     */
    public String getBusinessnoType() {
        return businessnoType;
    }

    /**
     * CHAR(2)<br>
     * 设置 业务编号类型：01-主合同号、02-质押合同号、03-协议编号、04-客户号
     */
    public void setBusinessnoType(String businessnoType) {
        this.businessnoType = businessnoType == null ? null : businessnoType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务编号(根据业务编号类型存放对应的值)
     */
    public String getBusinessno() {
        return businessno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务编号(根据业务编号类型存放对应的值)
     */
    public void setBusinessno(String businessno) {
        this.businessno = businessno == null ? null : businessno.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 业务金额
     */
    public BigDecimal getAmt() {
        return amt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 业务金额
     */
    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 流程发起机构
     */
    public String getStartBrcode() {
        return startBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 流程发起机构
     */
    public void setStartBrcode(String startBrcode) {
        this.startBrcode = startBrcode == null ? null : startBrcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 流程发起人
     */
    public String getStartTlrcd() {
        return startTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 流程发起人
     */
    public void setStartTlrcd(String startTlrcd) {
        this.startTlrcd = startTlrcd == null ? null : startTlrcd.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 发起日期
     */
    public String getStratDate() {
        return stratDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 发起日期
     */
    public void setStratDate(String stratDate) {
        this.stratDate = stratDate == null ? null : stratDate.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 发起时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 发起时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * CHAR(2)<br>
     * 获得 申请类型
     */
    public String getAppliStatus() {
        return appliStatus;
    }

    /**
     * CHAR(2)<br>
     * 设置 申请类型
     */
    public void setAppliStatus(String appliStatus) {
        this.appliStatus = appliStatus == null ? null : appliStatus.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 审批机构
     */
    public String getApproveBrcode() {
        return approveBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 审批机构
     */
    public void setApproveBrcode(String approveBrcode) {
        this.approveBrcode = approveBrcode == null ? null : approveBrcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 审批人
     */
    public String getApprover() {
        return approver;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 审批人
     */
    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 审批日期
     */
    public String getApproveDate() {
        return approveDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 审批日期
     */
    public void setApproveDate(String approveDate) {
        this.approveDate = approveDate == null ? null : approveDate.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 审批时间
     */
    public Date getApproveTime() {
        return approveTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 审批时间
     */
    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    /**
     * VARCHAR(30)<br>
     * 获得 工作流申请号
     */
    public String getWorkflowAppno() {
        return workflowAppno;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 工作流申请号
     */
    public void setWorkflowAppno(String workflowAppno) {
        this.workflowAppno = workflowAppno == null ? null : workflowAppno.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 申请状态
     */
    public String getAppliStatusDtl() {
        return appliStatusDtl;
    }

    /**
     * CHAR(3)<br>
     * 设置 申请状态
     */
    public void setAppliStatusDtl(String appliStatusDtl) {
        this.appliStatusDtl = appliStatusDtl == null ? null : appliStatusDtl.trim();
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
     * CHAR(8)<br>
     * 获得 申请日期
     */
    public String getAppDate() {
        return appDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 申请日期
     */
    public void setAppDate(String appDate) {
        this.appDate = appDate == null ? null : appDate.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 申请人
     */
    public String getAppTlrcd() {
        return appTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 申请人
     */
    public void setAppTlrcd(String appTlrcd) {
        this.appTlrcd = appTlrcd == null ? null : appTlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 申请机构
     */
    public String getAppBrcode() {
        return appBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请机构
     */
    public void setAppBrcode(String appBrcode) {
        this.appBrcode = appBrcode == null ? null : appBrcode.trim();
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
     * CHAR(4)<br>
     * 获得 供应链产品类型
     */
    public String getSupplyChainPdId() {
        return supplyChainPdId;
    }

    /**
     * CHAR(4)<br>
     * 设置 供应链产品类型
     */
    public void setSupplyChainPdId(String supplyChainPdId) {
        this.supplyChainPdId = supplyChainPdId == null ? null : supplyChainPdId.trim();
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
     * 获得 信贷系统流水号
     */
    public String getIncomeAppno() {
        return incomeAppno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 信贷系统流水号
     */
    public void setIncomeAppno(String incomeAppno) {
        this.incomeAppno = incomeAppno == null ? null : incomeAppno.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管公司客户号
     */
    public String getMoniCustcd() {
        return moniCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管公司客户号
     */
    public void setMoniCustcd(String moniCustcd) {
        this.moniCustcd = moniCustcd == null ? null : moniCustcd.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 质押模式：1-动态、2-静态
     */
    public String getPledgeMode() {
        return pledgeMode;
    }

    /**
     * CHAR(1)<br>
     * 设置 质押模式：1-动态、2-静态
     */
    public void setPledgeMode(String pledgeMode) {
        this.pledgeMode = pledgeMode == null ? null : pledgeMode.trim();
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
     * VARCHAR(50)<br>
     * 获得 网银流水号
     */
    public String getEbankAppno() {
        return ebankAppno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 网银流水号
     */
    public void setEbankAppno(String ebankAppno) {
        this.ebankAppno = ebankAppno == null ? null : ebankAppno.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 信贷合同号
     */
    public String getMastContcode() {
        return mastContcode;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 信贷合同号
     */
    public void setMastContcode(String mastContcode) {
        this.mastContcode = mastContcode == null ? null : mastContcode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 渠道标识：1-供应链、2-企业网银、3-信贷系统
     */
    public String getChannelFlag() {
        return channelFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 渠道标识：1-供应链、2-企业网银、3-信贷系统
     */
    public void setChannelFlag(String channelFlag) {
        this.channelFlag = channelFlag == null ? null : channelFlag.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 流程是否结束：0-否、1-是
     */
    public String getIsFlowEnd() {
        return isFlowEnd;
    }

    /**
     * CHAR(1)<br>
     * 设置 流程是否结束：0-否、1-是
     */
    public void setIsFlowEnd(String isFlowEnd) {
        this.isFlowEnd = isFlowEnd == null ? null : isFlowEnd.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 IFSP申请号
     */
    public String getIfspAppno() {
        return ifspAppno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 IFSP申请号
     */
    public void setIfspAppno(String ifspAppno) {
        this.ifspAppno = ifspAppno == null ? null : ifspAppno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 IFSP订单编号
     */
    public String getIfspOrderNo() {
        return ifspOrderNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 IFSP订单编号
     */
    public void setIfspOrderNo(String ifspOrderNo) {
        this.ifspOrderNo = ifspOrderNo == null ? null : ifspOrderNo.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getBillno() {
        return billno;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getBillcode() {
        return billcode;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setBillcode(String billcode) {
        this.billcode = billcode == null ? null : billcode.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getAddress() {
        return address;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * CHAR(6)<br>
     */
    public String getPostno() {
        return postno;
    }

    /**
     * CHAR(6)<br>
     */
    public void setPostno(String postno) {
        this.postno = postno == null ? null : postno.trim();
    }

    /**
     * VARCHAR(19)<br>
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * VARCHAR(19)<br>
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getStorageAddress() {
        return storageAddress;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress == null ? null : storageAddress.trim();
    }

    /**
     * DATE(7)<br>
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * DATE(7)<br>
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * VARCHAR(30)<br>
     */
    public String getPhone() {
        return phone;
    }

    /**
     * VARCHAR(30)<br>
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * VARCHAR(30)<br>
     */
    public String getFax() {
        return fax;
    }

    /**
     * VARCHAR(30)<br>
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * CHAR(8)<br>
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getStandLose() {
        return standLose;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setStandLose(String standLose) {
        this.standLose = standLose == null ? null : standLose.trim();
    }

    /**
     * CHAR(8)<br>
     */
    public String getStorageCostEndDate() {
        return storageCostEndDate;
    }

    /**
     * CHAR(8)<br>
     */
    public void setStorageCostEndDate(String storageCostEndDate) {
        this.storageCostEndDate = storageCostEndDate == null ? null : storageCostEndDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(500)<br>
     */
    public String getReason() {
        return reason;
    }

    /**
     * VARCHAR(500)<br>
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}