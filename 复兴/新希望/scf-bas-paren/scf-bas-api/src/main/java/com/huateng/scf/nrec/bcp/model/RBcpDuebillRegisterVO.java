package com.huateng.scf.nrec.bcp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RBcpDuebillRegisterVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private BigDecimal dueAmount;//对应放款编号申请余额
    
    
    public BigDecimal getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(BigDecimal dueAmount) {
		this.dueAmount = dueAmount;
	}

	private String businessName;//贸易对手名称
    private String cname;//融资企业
    private String returnAccountName;//回款帐号名称
    private String returnAccountBank;//回款帐号开户行
    private String accountName;//收款账户名称
    private String accountBank;//收款账户开户行
    private String actBrNm;//资金提供方客户名
    private String payActName;//资金提供方账户名称
    private String payActBank;//资金提供方开户行
    private BigDecimal feeAmt;//手续费用
    public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getReturnAccountName() {
		return returnAccountName;
	}

	public void setReturnAccountName(String returnAccountName) {
		this.returnAccountName = returnAccountName;
	}

	public String getReturnAccountBank() {
		return returnAccountBank;
	}

	public void setReturnAccountBank(String returnAccountBank) {
		this.returnAccountBank = returnAccountBank;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getActBrNm() {
		return actBrNm;
	}

	public void setActBrNm(String actBrNm) {
		this.actBrNm = actBrNm;
	}

	public String getPayActName() {
		return payActName;
	}

	public void setPayActName(String payActName) {
		this.payActName = payActName;
	}

	public String getPayActBank() {
		return payActBank;
	}

	public void setPayActBank(String payActBank) {
		this.payActBank = payActBank;
	}

	public BigDecimal getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(BigDecimal feeAmt) {
		this.feeAmt = feeAmt;
	}

	/**
     * VARCHAR(32) 必填<br>
     * 出账凭证号
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 接收凭证号
     */
    private String receiveNo;

    /**
     * VARCHAR(32) 必填<br>
     * 放款编号
     */
    private String appno;

    /**
     * VARCHAR(40)<br>
     * 合同流水号
     */
    private String mastContno;

    /**
     * VARCHAR(3)<br>
     * 出账状态
     */
    private String state;

    /**
     * VARCHAR(15) 必填<br>
     * 融资企业
     */
    private String custcd;

    /**
     * VARCHAR(15) 必填<br>
     * 买方客户号/承租人客户号
     */
    private String businessCustcd;

    /**
     * VARCHAR(10) 必填<br>
     * 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
     */
    private String supplyChainPdId;

    /**
     * DECIMAL(22,2) 默认值[0]<br>
     * 放款金额
     */
    private BigDecimal lnAmt;

    /**
     * DECIMAL(22,2)<br>
     * 放款余额
     */
    private BigDecimal lnSum;

    /**
     * VARCHAR(50)<br>
     * 结算账号/收款账号
     */
    private String accountNo;

    /**
     * VARCHAR(50)<br>
     * 回款专户
     */
    private String returnAccount;

    /**
     * VARCHAR(20)<br>
     * 账务机构/资金提供方
     */
    private String actBrCd;

    /**
     * VARCHAR(20)<br>
     * 放款账号/资金提供方帐号
     */
    private String payActNo;

    /**
     * DECIMAL(10,6) 默认值[0]<br>
     * 执行利率
     */
    private BigDecimal actInt;

    /**
     * DECIMAL(11,7)<br>
     * 手续费/管理费率
     */
    private BigDecimal feeRate;

    /**
     * DECIMAL(11,7)<br>
     * 保理费率
     */
    private BigDecimal blFeeRate;

    /**
     * VARCHAR(10)<br>
     * 计息周期
     */
    private String jxPeriod;

    /**
     * DECIMAL(2)<br>
     * 结息日
     */
    private Short jxDay;

    /**
     * VARCHAR(10)<br>
     * 收费/还款方式
     */
    private String returnType;

    /**
     * DECIMAL(2)<br>
     * 逾期限期
     */
    private Short yqDay;

    /**
     * DECIMAL(11,7)<br>
     * 逾期罚息费率
     */
    private BigDecimal yqRate;

    /**
     * DECIMAL(22)<br>
     * 期限月
     */
    private BigDecimal trmMon;

    /**
     * DECIMAL(22)<br>
     * 期限日
     */
    private BigDecimal trmDay;

    /**
     * CHAR(8)<br>
     * 合同生效日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 合同到期日期
     */
    private String endDate;

    /**
     * VARCHAR(32)<br>
     * 登记人
     */
    private String tlrNo;

    /**
     * VARCHAR(60)<br>
     * 登记人姓名
     */
    private String tlrNm;

    /**
     * VARCHAR(20)<br>
     * 机构号
     */
    private String brCd;

    /**
     * VARCHAR(60)<br>
     * 登记机构名称
     */
    private String brNm;

    /**
     * VARCHAR(20)<br>
     * 登记时间
     */
    private String inpDt;

    /**
     * VARCHAR(20)<br>
     * 备注1
     */
    private String ext1;

    /**
     * VARCHAR(20)<br>
     * 备注2
     */
    private String ext2;

    /**
     * VARCHAR(20)<br>
     * 备注3
     */
    private String ext3;

    /**
     * VARCHAR(20)<br>
     * 备注4
     */
    private String ext4;

    /**
     * VARCHAR(20)<br>
     * 备注5
     */
    private String ext5;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 出账凭证号
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 出账凭证号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 接收凭证号
     */
    public String getReceiveNo() {
        return receiveNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 接收凭证号
     */
    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo == null ? null : receiveNo.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 放款编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 放款编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 合同流水号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 合同流水号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * VARCHAR(3)<br>
     * 获得 出账状态
     */
    public String getState() {
        return state;
    }

    /**
     * VARCHAR(3)<br>
     * 设置 出账状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 融资企业
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 融资企业
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 买方客户号/承租人客户号
     */
    public String getBusinessCustcd() {
        return businessCustcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 买方客户号/承租人客户号
     */
    public void setBusinessCustcd(String businessCustcd) {
        this.businessCustcd = businessCustcd == null ? null : businessCustcd.trim();
    }

    /**
     * VARCHAR(10) 必填<br>
     * 获得 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
     */
    public String getSupplyChainPdId() {
        return supplyChainPdId;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 业务种类：国内保理;反向保理;应收账款质押;国内双保理;信保保理;租赁保理
     */
    public void setSupplyChainPdId(String supplyChainPdId) {
        this.supplyChainPdId = supplyChainPdId == null ? null : supplyChainPdId.trim();
    }

    /**
     * DECIMAL(22,2) 默认值[0]<br>
     * 获得 放款金额
     */
    public BigDecimal getLnAmt() {
        return lnAmt;
    }

    /**
     * DECIMAL(22,2) 默认值[0]<br>
     * 设置 放款金额
     */
    public void setLnAmt(BigDecimal lnAmt) {
        this.lnAmt = lnAmt;
    }

    /**
     * DECIMAL(22,2)<br>
     * 获得 放款余额
     */
    public BigDecimal getLnSum() {
        return lnSum;
    }

    /**
     * DECIMAL(22,2)<br>
     * 设置 放款余额
     */
    public void setLnSum(BigDecimal lnSum) {
        this.lnSum = lnSum;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 结算账号/收款账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 结算账号/收款账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 回款专户
     */
    public String getReturnAccount() {
        return returnAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 回款专户
     */
    public void setReturnAccount(String returnAccount) {
        this.returnAccount = returnAccount == null ? null : returnAccount.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 账务机构/资金提供方
     */
    public String getActBrCd() {
        return actBrCd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 账务机构/资金提供方
     */
    public void setActBrCd(String actBrCd) {
        this.actBrCd = actBrCd == null ? null : actBrCd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 放款账号/资金提供方帐号
     */
    public String getPayActNo() {
        return payActNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 放款账号/资金提供方帐号
     */
    public void setPayActNo(String payActNo) {
        this.payActNo = payActNo == null ? null : payActNo.trim();
    }

    /**
     * DECIMAL(10,6) 默认值[0]<br>
     * 获得 执行利率
     */
    public BigDecimal getActInt() {
        return actInt;
    }

    /**
     * DECIMAL(10,6) 默认值[0]<br>
     * 设置 执行利率
     */
    public void setActInt(BigDecimal actInt) {
        this.actInt = actInt;
    }

    /**
     * DECIMAL(11,7)<br>
     * 获得 手续费/管理费率
     */
    public BigDecimal getFeeRate() {
        return feeRate;
    }

    /**
     * DECIMAL(11,7)<br>
     * 设置 手续费/管理费率
     */
    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    /**
     * DECIMAL(11,7)<br>
     * 获得 保理费率
     */
    public BigDecimal getBlFeeRate() {
        return blFeeRate;
    }

    /**
     * DECIMAL(11,7)<br>
     * 设置 保理费率
     */
    public void setBlFeeRate(BigDecimal blFeeRate) {
        this.blFeeRate = blFeeRate;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 计息周期
     */
    public String getJxPeriod() {
        return jxPeriod;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 计息周期
     */
    public void setJxPeriod(String jxPeriod) {
        this.jxPeriod = jxPeriod == null ? null : jxPeriod.trim();
    }

    /**
     * DECIMAL(2)<br>
     * 获得 结息日
     */
    public Short getJxDay() {
        return jxDay;
    }

    /**
     * DECIMAL(2)<br>
     * 设置 结息日
     */
    public void setJxDay(Short jxDay) {
        this.jxDay = jxDay;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 收费/还款方式
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 收费/还款方式
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType == null ? null : returnType.trim();
    }

    /**
     * DECIMAL(2)<br>
     * 获得 逾期限期
     */
    public Short getYqDay() {
        return yqDay;
    }

    /**
     * DECIMAL(2)<br>
     * 设置 逾期限期
     */
    public void setYqDay(Short yqDay) {
        this.yqDay = yqDay;
    }

    /**
     * DECIMAL(11,7)<br>
     * 获得 逾期罚息费率
     */
    public BigDecimal getYqRate() {
        return yqRate;
    }

    /**
     * DECIMAL(11,7)<br>
     * 设置 逾期罚息费率
     */
    public void setYqRate(BigDecimal yqRate) {
        this.yqRate = yqRate;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 期限月
     */
    public BigDecimal getTrmMon() {
        return trmMon;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 期限月
     */
    public void setTrmMon(BigDecimal trmMon) {
        this.trmMon = trmMon;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 期限日
     */
    public BigDecimal getTrmDay() {
        return trmDay;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 期限日
     */
    public void setTrmDay(BigDecimal trmDay) {
        this.trmDay = trmDay;
    }

    /**
     * CHAR(8)<br>
     * 获得 合同生效日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 合同生效日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 合同到期日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 合同到期日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记人
     */
    public String getTlrNo() {
        return tlrNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记人
     */
    public void setTlrNo(String tlrNo) {
        this.tlrNo = tlrNo == null ? null : tlrNo.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 登记人姓名
     */
    public String getTlrNm() {
        return tlrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 登记人姓名
     */
    public void setTlrNm(String tlrNm) {
        this.tlrNm = tlrNm == null ? null : tlrNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 机构号
     */
    public String getBrCd() {
        return brCd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 机构号
     */
    public void setBrCd(String brCd) {
        this.brCd = brCd == null ? null : brCd.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 登记机构名称
     */
    public String getBrNm() {
        return brNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 登记机构名称
     */
    public void setBrNm(String brNm) {
        this.brNm = brNm == null ? null : brNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 登记时间
     */
    public String getInpDt() {
        return inpDt;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 登记时间
     */
    public void setInpDt(String inpDt) {
        this.inpDt = inpDt == null ? null : inpDt.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 备注1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 备注1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 备注2
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 备注2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 备注3
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 备注3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 备注4
     */
    public String getExt4() {
        return ext4;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 备注4
     */
    public void setExt4(String ext4) {
        this.ext4 = ext4 == null ? null : ext4.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 备注5
     */
    public String getExt5() {
        return ext5;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 备注5
     */
    public void setExt5(String ext5) {
        this.ext5 = ext5 == null ? null : ext5.trim();
    }
}