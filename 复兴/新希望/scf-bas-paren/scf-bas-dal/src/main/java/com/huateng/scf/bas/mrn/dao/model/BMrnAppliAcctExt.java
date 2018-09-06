package com.huateng.scf.bas.mrn.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BMrnAppliAcctExt implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 账务机构名称
     */
    private String actBrNm;

    public String getActBrNm() {
		return actBrNm;
	}

	public void setActBrNm(String actBrNm) {
		this.actBrNm = actBrNm;
	}

    /**
     * VARCHAR(50)<br>
     * 信贷系统流水号
     */
    private String incomeAppno;
    
    public String getIncomeAppno() {
		return incomeAppno;
	}

	public void setIncomeAppno(String incomeAppno) {
		this.incomeAppno = incomeAppno;
	}

	/**
     * 敞口余额
     */
    private BigDecimal riskAmt;

    /**
     * VARCHAR(50)<br>
     * 融资出账流水号
     */
    private String loanAppno;
    
    public BigDecimal getRiskAmt() {
		return riskAmt;
	}

	public void setRiskAmt(BigDecimal riskAmt) {
		this.riskAmt = riskAmt;
	}
	
	/**
     * VARCHAR(50)<br>
     * 获得 融资出账流水号
     */
    public String getLoanAppno() {
        return loanAppno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 融资出账流水号
     */
    public void setLoanAppno(String loanAppno) {
        this.loanAppno = loanAppno == null ? null : loanAppno.trim();
    }
    
    /**
     * CHAR(2)<br>
     * 借据类型：01-流动资金贷款、02-银行承兑汇票
     */
    private String lnciType;
    
    /**
     * VARCHAR(100) 必填<br>
     * 借据号/承兑协议号
     */
    private String debetId;

    /**
     * CHAR(1)<br>
     * 借据状态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    private String lnciStatus;

    /**
     * DECIMAL(16,2)<br>
     * 借据金额
     */
    private BigDecimal lnciAmt;

    /**
     * DECIMAL(16,2)<br>
     * 借据余额
     */
    private BigDecimal lnciBal;

    /**
     * CHAR(8)<br>
     * 起息日期
     */
    private String startDate;

    /**
     * CHAR(8)<br>
     * 到期日期
     */
    private String endDate;

    /**
     * DECIMAL(16,2)<br>
     * 剩余提货金额
     */
    private BigDecimal amountIn;

    /**
     * DECIMAL(16,2)<br>
     * 追加保证金金额
     */
    private BigDecimal addBailAmount;

    /**
     * DECIMAL(16,2)<br>
     * 应收欠息
     */
    private BigDecimal receivableInt;

    /**
     * CHAR(2)<br>
     * 获得 借据类型：01-流动资金贷款、02-银行承兑汇票
     */
    public String getLnciType() {
        return lnciType;
    }

    /**
     * CHAR(2)<br>
     * 设置 借据类型：01-流动资金贷款、02-银行承兑汇票
     */
    public void setLnciType(String lnciType) {
        this.lnciType = lnciType == null ? null : lnciType.trim();
    }
    
    /**
     * VARCHAR(100) 必填<br>
     * 获得 借据号/承兑协议号
     */
    public String getDebetId() {
        return debetId;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 借据号/承兑协议号
     */
    public void setDebetId(String debetId) {
        this.debetId = debetId == null ? null : debetId.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 借据状态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    public String getLnciStatus() {
        return lnciStatus;
    }

    /**
     * CHAR(1)<br>
     * 设置 借据状态：0-正常、1-逾期、2-呆滞、3-呆账
     */
    public void setLnciStatus(String lnciStatus) {
        this.lnciStatus = lnciStatus == null ? null : lnciStatus.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 借据金额
     */
    public BigDecimal getLnciAmt() {
        return lnciAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 借据金额
     */
    public void setLnciAmt(BigDecimal lnciAmt) {
        this.lnciAmt = lnciAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 借据余额
     */
    public BigDecimal getLnciBal() {
        return lnciBal;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 借据余额
     */
    public void setLnciBal(BigDecimal lnciBal) {
        this.lnciBal = lnciBal;
    }

    /**
     * CHAR(8)<br>
     * 获得 起息日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 起息日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 到期日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 到期日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 剩余提货金额
     */
    public BigDecimal getAmountIn() {
        return amountIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 剩余提货金额
     */
    public void setAmountIn(BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 追加保证金金额
     */
    public BigDecimal getAddBailAmount() {
        return addBailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 追加保证金金额
     */
    public void setAddBailAmount(BigDecimal addBailAmount) {
        this.addBailAmount = addBailAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收欠息
     */
    public BigDecimal getReceivableInt() {
        return receivableInt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收欠息
     */
    public void setReceivableInt(BigDecimal receivableInt) {
        this.receivableInt = receivableInt;
    }

}