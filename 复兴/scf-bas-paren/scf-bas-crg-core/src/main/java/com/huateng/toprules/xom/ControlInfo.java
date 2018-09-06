package com.huateng.toprules.xom;

import java.io.Serializable;

import com.huateng.toprules.core.annotation.ModelField;
import com.huateng.toprules.core.annotation.ModelInstance;

/**
 * 控制类信息
 *
 * 控制信息配置规定：触发规则号，处理标志, 规则评分，挂起类型，渠道交易码，控制金额下限，挂起渠道，挂起频率
 *
 * @author zkj
 *
 */
@ModelInstance(description="控制信息")
public class ControlInfo implements Serializable {

	private static final long serialVersionUID = -5412644597224338493L;

	private String ruleId; // 触发规则号

	@ModelField(name="处理标志",bindDomain="com.huateng.toprules.xom.DealFlagDomain")
	private String dealFlag; // 处理标志: 1：挂起 2：阻断  3:评分

	private int grade = 0; // 规则评分

	private String holdType; // 挂起类型 01：客户号 02：付款账号 03：收款账号 04：付款账号+商户 05：付款账号+收款账户 06：高风险收款帐户

	private String chanlTradNo; //渠道交易码

	private double lowerLimitAmt; // 控制金额下限

	private String suspendChannel; //挂起渠道

	private String suspendFrequency; //挂起频率
	
	@ModelField(name="评分", bindDomain="")
	private Double score = 0d;

	@ModelField(name="评分结论", bindDomain="")
	private String scoreConclusion = "";
	
	@ModelField(name="信用额度", bindDomain="")
	private Double loanableLines = 0d;
	
	public String getScoreConclusion() {
		return scoreConclusion;
	}

	public void setScoreConclusion(String scoreConclusion) {
		this.scoreConclusion = scoreConclusion;
	}

	public ControlInfo() {

	}
	
	public Double getLoanableLines() {
		return loanableLines;
	}

	public void setLoanableLines(Double loanableLines) {
		this.loanableLines = loanableLines;
	}

	public ControlInfo(String ruleId, String dealFlag, int grade){
		this();
		this.ruleId = ruleId;
		this.dealFlag = dealFlag;
		this.grade = grade;
	}

	public ControlInfo(String ruleId, String dealFlag, int grade,
			String holdType, String chanlTradNo, double lowerLimitAmt,
			String suspendChannel, String suspendFrequency) {
		this();
		this.ruleId = ruleId;
		this.dealFlag = dealFlag;
		this.grade = grade;
		this.holdType = holdType;
		this.chanlTradNo = chanlTradNo;
		this.lowerLimitAmt = lowerLimitAmt;
		this.suspendChannel = suspendChannel;
		this.suspendFrequency = suspendFrequency;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getHoldType() {
		return holdType;
	}

	public void setHoldType(String holdType) {
		this.holdType = holdType;
	}

	public String getChanlTradNo() {
		return chanlTradNo;
	}

	public void setChanlTradNo(String chanlTradNo) {
		this.chanlTradNo = chanlTradNo;
	}

	public double getLowerLimitAmt() {
		return lowerLimitAmt;
	}

	public void setLowerLimitAmt(double lowerLimitAmt) {
		this.lowerLimitAmt = lowerLimitAmt;
	}

	public String getSuspendChannel() {
		return suspendChannel;
	}

	public void setSuspendChannel(String suspendChannel) {
		this.suspendChannel = suspendChannel;
	}

	public String getSuspendFrequency() {
		return suspendFrequency;
	}

	public void setSuspendFrequency(String suspendFrequency) {
		this.suspendFrequency = suspendFrequency;
	}

	@Override
	public String toString() {
		String symbol = ",,,,," ;

		if(chanlTradNo==null){
			chanlTradNo ="";
		}else{
			chanlTradNo =chanlTradNo.trim();
		}

		if(chanlTradNo!=null && chanlTradNo.length()>0){
			return ruleId+","+dealFlag+","+grade+","+holdType+","+chanlTradNo+","+String.valueOf(lowerLimitAmt)+","+suspendChannel+","+suspendFrequency;
		}
		return ruleId+","+dealFlag+","+grade+symbol;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
	
}
