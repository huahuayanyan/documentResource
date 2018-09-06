package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrGntyInfo实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:44:07
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:44:07	     新增
 *
 * </pre>
 */
public class BCrrGntyInfo extends BCrrGntyRela implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(40) 必填<br>
     * 合同流水号，从担保合同表中带出
     */
    private String conId;
    public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId == null ? null : conId.trim();
	}
	
	/**
     * VARCHAR(40) 必填<br>
     * 担保合同编号，从担保合同表中带出
     */
    private String conNo;
    public String getConNo() {
		return conNo;
	}

	public void setConNo(String conNo) {
		this.conNo = conNo == null ? null : conNo.trim();
	}
	
    /**
     * VARCHAR(40) 必填<br>
     * 担保物编号
     */
    private String gntyId;

    /**
     * VARCHAR(80)<br>
     * 担保物名称
     */
    private String gntyNm;

    /**
     * VARCHAR(20)<br>
     * 担保物类型
     */
    private String gntyTyp;

    /**
     * VARCHAR(18)<br>
     * 权属人证件类型
     */
    private String certTyp;

    /**
     * VARCHAR(32)<br>
     * 权属人证件号码
     */
    private String certId;

    /**
     * VARCHAR(80)<br>
     * 权属人名称
     */
    private String ownerNm;

    /**
     * VARCHAR(32)<br>
     * 权属人贷款卡编号
     */
    private String certLnNo;

    /**
     * VARCHAR(20)<br>
     * 权属人类型
     */
    private String ownerTyp;

    /**
     * VARCHAR(40)<br>
     * 权证号
     */
    private String gntyRid;

    /**
     * VARCHAR(20)<br>
     * 担保物子类型/房产类型
     */
    private String gntySubTyp;

    /**
     * VARCHAR(20)<br>
     * 担保物子类名称
     */
    private String gntySubNm;

    /**
     * VARCHAR(200)<br>
     * 担保物地点位置/房屋详细地址
     */
    private String gntyLoc;

    /**
     * DECIMAL(24,6)<br>
     * 担保物数量/建筑面积(平方米)
     */
    private BigDecimal gntyArea;

    /**
     * VARCHAR(10)<br>
     * 土地性质
     */
    private String gntyAttr;

    /**
     * VARCHAR(10)<br>
     * 担保物取用方式
     */
    private String gntyOwnWay;

    /**
     * VARCHAR(10)<br>
     * 担保物使用类型
     */
    private String gntyUsing;

    /**
     * DECIMAL(24,6)<br>
     * 担保物原价值
     */
    private BigDecimal gntyPrc;

    /**
     * VARCHAR(20)<br>
     * 担保物价值评估方式
     */
    private String evalMthd;

    /**
     * VARCHAR(80)<br>
     * 评估单位名称
     */
    private String evalOrgNm;

    /**
     * VARCHAR(10)<br>
     * 评估日期
     */
    private String evalDt;

    /**
     * DECIMAL(24,6)<br>
     * 评估值
     */
    private BigDecimal evalNetVal;

    /**
     * DECIMAL(24,6)<br>
     * 认定价值
     */
    private BigDecimal confirmVal;

    /**
     * DECIMAL(24,6)<br>
     * 担保本金债权金额/权利取得价值（元）
     */
    private BigDecimal gntyAmt;

    /**
     * VARCHAR(10)<br>
     * 币种
     */
    private String curcd;

    /**
     * VARCHAR(80)<br>
     * 存单所属行/权利批准机构
     */
    private String gntyRegOrg;

    /**
     * VARCHAR(10)<br>
     * 开始日期
     */
    private String gntyRegDt;

    /**
     * VARCHAR(10)<br>
     * 到期日期
     */
    private String gntyWoDt;

    /**
     * DECIMAL(24,6)<br>
     * 金额（人民币 元）/应退未退税金额（元）
     */
    private BigDecimal abtAmt;

    /**
     * DECIMAL(24,6)<br>
     * 基金发行总额（元）
     */
    private BigDecimal abtSum1;

    /**
     * DECIMAL(24,6)<br>
     * 质押基金份额（元）
     */
    private BigDecimal abtSum2;

    /**
     * DECIMAL(24,6)<br>
     * 申请前一日基金收盘价（元）
     */
    private BigDecimal abtSum3;

    /**
     * DECIMAL(24,6)<br>
     * 质押基金份额占总额（%）/黄金质押率
     */
    private BigDecimal abtRate;

    /**
     * VARCHAR(32)<br>
     * 质押基金份额占总额（%）/黄金质押率
     */
    private String otRtnNo;

    /**
     * VARCHAR(20)<br>
     * 是否记名债券
     */
    private String flg1;

    /**
     * VARCHAR(20)<br>
     * 是否需要办理止付
     */
    private String flg2;

    /**
     * VARCHAR(20)<br>
     * 有无保兑
     */
    private String flg3;

    /**
     * VARCHAR(80)<br>
     * 通知行/出票人
     */
    private String ifrmBak;

    /**
     * VARCHAR(80)<br>
     * 保兑行/付款行
     */
    private String cfrmBak;

    /**
     * VARCHAR(20)<br>
     * 出票人
     */
    private String abtNm;

    /**
     * VARCHAR(20)<br>
     * 付款人
     */
    private String payNm;

    /**
     * VARCHAR(80)<br>
     * 保兑行所在国家和地区
     */
    private String cfrmArea;

    /**
     * VARCHAR(20)<br>
     * 抵质押物类型
     */
    private String sapVchTyp;

    /**
     * VARCHAR(10)<br>
     * 外汇存款类型
     */
    private String abtTyp;

    /**
     * VARCHAR(250)<br>
     * 备注
     */
    private String rem;

    /**
     * VARCHAR(40) 必填<br>
     * 获得 担保物编号
     */
    public String getGntyId() {
        return gntyId;
    }

    /**
     * VARCHAR(40) 必填<br>
     * 设置 担保物编号
     */
    public void setGntyId(String gntyId) {
        this.gntyId = gntyId == null ? null : gntyId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 担保物名称
     */
    public String getGntyNm() {
        return gntyNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 担保物名称
     */
    public void setGntyNm(String gntyNm) {
        this.gntyNm = gntyNm == null ? null : gntyNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 担保物类型
     */
    public String getGntyTyp() {
        return gntyTyp;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 担保物类型
     */
    public void setGntyTyp(String gntyTyp) {
        this.gntyTyp = gntyTyp == null ? null : gntyTyp.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 权属人证件类型
     */
    public String getCertTyp() {
        return certTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 权属人证件类型
     */
    public void setCertTyp(String certTyp) {
        this.certTyp = certTyp == null ? null : certTyp.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 权属人证件号码
     */
    public String getCertId() {
        return certId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 权属人证件号码
     */
    public void setCertId(String certId) {
        this.certId = certId == null ? null : certId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 权属人名称
     */
    public String getOwnerNm() {
        return ownerNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 权属人名称
     */
    public void setOwnerNm(String ownerNm) {
        this.ownerNm = ownerNm == null ? null : ownerNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 权属人贷款卡编号
     */
    public String getCertLnNo() {
        return certLnNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 权属人贷款卡编号
     */
    public void setCertLnNo(String certLnNo) {
        this.certLnNo = certLnNo == null ? null : certLnNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 权属人类型
     */
    public String getOwnerTyp() {
        return ownerTyp;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 权属人类型
     */
    public void setOwnerTyp(String ownerTyp) {
        this.ownerTyp = ownerTyp == null ? null : ownerTyp.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 权证号
     */
    public String getGntyRid() {
        return gntyRid;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 权证号
     */
    public void setGntyRid(String gntyRid) {
        this.gntyRid = gntyRid == null ? null : gntyRid.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 担保物子类型/房产类型
     */
    public String getGntySubTyp() {
        return gntySubTyp;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 担保物子类型/房产类型
     */
    public void setGntySubTyp(String gntySubTyp) {
        this.gntySubTyp = gntySubTyp == null ? null : gntySubTyp.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 担保物子类名称
     */
    public String getGntySubNm() {
        return gntySubNm;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 担保物子类名称
     */
    public void setGntySubNm(String gntySubNm) {
        this.gntySubNm = gntySubNm == null ? null : gntySubNm.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 担保物地点位置/房屋详细地址
     */
    public String getGntyLoc() {
        return gntyLoc;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 担保物地点位置/房屋详细地址
     */
    public void setGntyLoc(String gntyLoc) {
        this.gntyLoc = gntyLoc == null ? null : gntyLoc.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 担保物数量/建筑面积(平方米)
     */
    public BigDecimal getGntyArea() {
        return gntyArea;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 担保物数量/建筑面积(平方米)
     */
    public void setGntyArea(BigDecimal gntyArea) {
        this.gntyArea = gntyArea;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 土地性质
     */
    public String getGntyAttr() {
        return gntyAttr;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 土地性质
     */
    public void setGntyAttr(String gntyAttr) {
        this.gntyAttr = gntyAttr == null ? null : gntyAttr.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 担保物取用方式
     */
    public String getGntyOwnWay() {
        return gntyOwnWay;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 担保物取用方式
     */
    public void setGntyOwnWay(String gntyOwnWay) {
        this.gntyOwnWay = gntyOwnWay == null ? null : gntyOwnWay.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 担保物使用类型
     */
    public String getGntyUsing() {
        return gntyUsing;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 担保物使用类型
     */
    public void setGntyUsing(String gntyUsing) {
        this.gntyUsing = gntyUsing == null ? null : gntyUsing.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 担保物原价值
     */
    public BigDecimal getGntyPrc() {
        return gntyPrc;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 担保物原价值
     */
    public void setGntyPrc(BigDecimal gntyPrc) {
        this.gntyPrc = gntyPrc;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 担保物价值评估方式
     */
    public String getEvalMthd() {
        return evalMthd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 担保物价值评估方式
     */
    public void setEvalMthd(String evalMthd) {
        this.evalMthd = evalMthd == null ? null : evalMthd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 评估单位名称
     */
    public String getEvalOrgNm() {
        return evalOrgNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 评估单位名称
     */
    public void setEvalOrgNm(String evalOrgNm) {
        this.evalOrgNm = evalOrgNm == null ? null : evalOrgNm.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 评估日期
     */
    public String getEvalDt() {
        return evalDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 评估日期
     */
    public void setEvalDt(String evalDt) {
        this.evalDt = evalDt == null ? null : evalDt.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 评估值
     */
    public BigDecimal getEvalNetVal() {
        return evalNetVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 评估值
     */
    public void setEvalNetVal(BigDecimal evalNetVal) {
        this.evalNetVal = evalNetVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 认定价值
     */
    public BigDecimal getConfirmVal() {
        return confirmVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 认定价值
     */
    public void setConfirmVal(BigDecimal confirmVal) {
        this.confirmVal = confirmVal;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 担保本金债权金额/权利取得价值（元）
     */
    public BigDecimal getGntyAmt() {
        return gntyAmt;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 担保本金债权金额/权利取得价值（元）
     */
    public void setGntyAmt(BigDecimal gntyAmt) {
        this.gntyAmt = gntyAmt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 币种
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 币种
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 存单所属行/权利批准机构
     */
    public String getGntyRegOrg() {
        return gntyRegOrg;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 存单所属行/权利批准机构
     */
    public void setGntyRegOrg(String gntyRegOrg) {
        this.gntyRegOrg = gntyRegOrg == null ? null : gntyRegOrg.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 开始日期
     */
    public String getGntyRegDt() {
        return gntyRegDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 开始日期
     */
    public void setGntyRegDt(String gntyRegDt) {
        this.gntyRegDt = gntyRegDt == null ? null : gntyRegDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 到期日期
     */
    public String getGntyWoDt() {
        return gntyWoDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 到期日期
     */
    public void setGntyWoDt(String gntyWoDt) {
        this.gntyWoDt = gntyWoDt == null ? null : gntyWoDt.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 金额（人民币 元）/应退未退税金额（元）
     */
    public BigDecimal getAbtAmt() {
        return abtAmt;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 金额（人民币 元）/应退未退税金额（元）
     */
    public void setAbtAmt(BigDecimal abtAmt) {
        this.abtAmt = abtAmt;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 基金发行总额（元）
     */
    public BigDecimal getAbtSum1() {
        return abtSum1;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 基金发行总额（元）
     */
    public void setAbtSum1(BigDecimal abtSum1) {
        this.abtSum1 = abtSum1;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 质押基金份额（元）
     */
    public BigDecimal getAbtSum2() {
        return abtSum2;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 质押基金份额（元）
     */
    public void setAbtSum2(BigDecimal abtSum2) {
        this.abtSum2 = abtSum2;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 申请前一日基金收盘价（元）
     */
    public BigDecimal getAbtSum3() {
        return abtSum3;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 申请前一日基金收盘价（元）
     */
    public void setAbtSum3(BigDecimal abtSum3) {
        this.abtSum3 = abtSum3;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 质押基金份额占总额（%）/黄金质押率
     */
    public BigDecimal getAbtRate() {
        return abtRate;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 质押基金份额占总额（%）/黄金质押率
     */
    public void setAbtRate(BigDecimal abtRate) {
        this.abtRate = abtRate;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 质押基金份额占总额（%）/黄金质押率
     */
    public String getOtRtnNo() {
        return otRtnNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 质押基金份额占总额（%）/黄金质押率
     */
    public void setOtRtnNo(String otRtnNo) {
        this.otRtnNo = otRtnNo == null ? null : otRtnNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 是否记名债券
     */
    public String getFlg1() {
        return flg1;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 是否记名债券
     */
    public void setFlg1(String flg1) {
        this.flg1 = flg1 == null ? null : flg1.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 是否需要办理止付
     */
    public String getFlg2() {
        return flg2;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 是否需要办理止付
     */
    public void setFlg2(String flg2) {
        this.flg2 = flg2 == null ? null : flg2.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 有无保兑
     */
    public String getFlg3() {
        return flg3;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 有无保兑
     */
    public void setFlg3(String flg3) {
        this.flg3 = flg3 == null ? null : flg3.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 通知行/出票人
     */
    public String getIfrmBak() {
        return ifrmBak;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 通知行/出票人
     */
    public void setIfrmBak(String ifrmBak) {
        this.ifrmBak = ifrmBak == null ? null : ifrmBak.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 保兑行/付款行
     */
    public String getCfrmBak() {
        return cfrmBak;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 保兑行/付款行
     */
    public void setCfrmBak(String cfrmBak) {
        this.cfrmBak = cfrmBak == null ? null : cfrmBak.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 出票人
     */
    public String getAbtNm() {
        return abtNm;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 出票人
     */
    public void setAbtNm(String abtNm) {
        this.abtNm = abtNm == null ? null : abtNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 付款人
     */
    public String getPayNm() {
        return payNm;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 付款人
     */
    public void setPayNm(String payNm) {
        this.payNm = payNm == null ? null : payNm.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 保兑行所在国家和地区
     */
    public String getCfrmArea() {
        return cfrmArea;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 保兑行所在国家和地区
     */
    public void setCfrmArea(String cfrmArea) {
        this.cfrmArea = cfrmArea == null ? null : cfrmArea.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 抵质押物类型
     */
    public String getSapVchTyp() {
        return sapVchTyp;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 抵质押物类型
     */
    public void setSapVchTyp(String sapVchTyp) {
        this.sapVchTyp = sapVchTyp == null ? null : sapVchTyp.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 外汇存款类型
     */
    public String getAbtTyp() {
        return abtTyp;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 外汇存款类型
     */
    public void setAbtTyp(String abtTyp) {
        this.abtTyp = abtTyp == null ? null : abtTyp.trim();
    }

    /**
     * VARCHAR(250)<br>
     * 获得 备注
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(250)<br>
     * 设置 备注
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gntyId=").append(gntyId);
        sb.append(", gntyNm=").append(gntyNm);
        sb.append(", gntyTyp=").append(gntyTyp);
        sb.append(", certTyp=").append(certTyp);
        sb.append(", certId=").append(certId);
        sb.append(", ownerNm=").append(ownerNm);
        sb.append(", certLnNo=").append(certLnNo);
        sb.append(", ownerTyp=").append(ownerTyp);
        sb.append(", gntyRid=").append(gntyRid);
        sb.append(", gntySubTyp=").append(gntySubTyp);
        sb.append(", gntySubNm=").append(gntySubNm);
        sb.append(", gntyLoc=").append(gntyLoc);
        sb.append(", gntyArea=").append(gntyArea);
        sb.append(", gntyAttr=").append(gntyAttr);
        sb.append(", gntyOwnWay=").append(gntyOwnWay);
        sb.append(", gntyUsing=").append(gntyUsing);
        sb.append(", gntyPrc=").append(gntyPrc);
        sb.append(", evalMthd=").append(evalMthd);
        sb.append(", evalOrgNm=").append(evalOrgNm);
        sb.append(", evalDt=").append(evalDt);
        sb.append(", evalNetVal=").append(evalNetVal);
        sb.append(", confirmVal=").append(confirmVal);
        sb.append(", gntyAmt=").append(gntyAmt);
        sb.append(", curcd=").append(curcd);
        sb.append(", gntyRegOrg=").append(gntyRegOrg);
        sb.append(", gntyRegDt=").append(gntyRegDt);
        sb.append(", gntyWoDt=").append(gntyWoDt);
        sb.append(", abtAmt=").append(abtAmt);
        sb.append(", abtSum1=").append(abtSum1);
        sb.append(", abtSum2=").append(abtSum2);
        sb.append(", abtSum3=").append(abtSum3);
        sb.append(", abtRate=").append(abtRate);
        sb.append(", otRtnNo=").append(otRtnNo);
        sb.append(", flg1=").append(flg1);
        sb.append(", flg2=").append(flg2);
        sb.append(", flg3=").append(flg3);
        sb.append(", ifrmBak=").append(ifrmBak);
        sb.append(", cfrmBak=").append(cfrmBak);
        sb.append(", abtNm=").append(abtNm);
        sb.append(", payNm=").append(payNm);
        sb.append(", cfrmArea=").append(cfrmArea);
        sb.append(", sapVchTyp=").append(sapVchTyp);
        sb.append(", abtTyp=").append(abtTyp);
        sb.append(", rem=").append(rem);
        sb.append(", tlrNo=").append(tlrNo);
        sb.append(", tlrNm=").append(tlrNm);
        sb.append(", brCd=").append(brCd);
        sb.append(", brNm=").append(brNm);
        sb.append(", inpDt=").append(inpDt);
        sb.append(", lstUpdTlr=").append(lstUpdTlr);
        sb.append(", lstUpdTlrNm=").append(lstUpdTlrNm);
        sb.append(", lstUpdBrCd=").append(lstUpdBrCd);
        sb.append(", lstUpdBrNm=").append(lstUpdBrNm);
        sb.append(", lstUpdDt=").append(lstUpdDt);
        sb.append(", conId=").append(conId);
        sb.append(", conNo=").append(conNo);
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
        BCrrGntyInfo other = (BCrrGntyInfo) that;
        return (this.getGntyId() == null ? other.getGntyId() == null : this.getGntyId().equals(other.getGntyId()))
            && (this.getGntyNm() == null ? other.getGntyNm() == null : this.getGntyNm().equals(other.getGntyNm()))
            && (this.getGntyTyp() == null ? other.getGntyTyp() == null : this.getGntyTyp().equals(other.getGntyTyp()))
            && (this.getCertTyp() == null ? other.getCertTyp() == null : this.getCertTyp().equals(other.getCertTyp()))
            && (this.getCertId() == null ? other.getCertId() == null : this.getCertId().equals(other.getCertId()))
            && (this.getOwnerNm() == null ? other.getOwnerNm() == null : this.getOwnerNm().equals(other.getOwnerNm()))
            && (this.getCertLnNo() == null ? other.getCertLnNo() == null : this.getCertLnNo().equals(other.getCertLnNo()))
            && (this.getOwnerTyp() == null ? other.getOwnerTyp() == null : this.getOwnerTyp().equals(other.getOwnerTyp()))
            && (this.getGntyRid() == null ? other.getGntyRid() == null : this.getGntyRid().equals(other.getGntyRid()))
            && (this.getGntySubTyp() == null ? other.getGntySubTyp() == null : this.getGntySubTyp().equals(other.getGntySubTyp()))
            && (this.getGntySubNm() == null ? other.getGntySubNm() == null : this.getGntySubNm().equals(other.getGntySubNm()))
            && (this.getGntyLoc() == null ? other.getGntyLoc() == null : this.getGntyLoc().equals(other.getGntyLoc()))
            && (this.getGntyArea() == null ? other.getGntyArea() == null : this.getGntyArea().equals(other.getGntyArea()))
            && (this.getGntyAttr() == null ? other.getGntyAttr() == null : this.getGntyAttr().equals(other.getGntyAttr()))
            && (this.getGntyOwnWay() == null ? other.getGntyOwnWay() == null : this.getGntyOwnWay().equals(other.getGntyOwnWay()))
            && (this.getGntyUsing() == null ? other.getGntyUsing() == null : this.getGntyUsing().equals(other.getGntyUsing()))
            && (this.getGntyPrc() == null ? other.getGntyPrc() == null : this.getGntyPrc().equals(other.getGntyPrc()))
            && (this.getEvalMthd() == null ? other.getEvalMthd() == null : this.getEvalMthd().equals(other.getEvalMthd()))
            && (this.getEvalOrgNm() == null ? other.getEvalOrgNm() == null : this.getEvalOrgNm().equals(other.getEvalOrgNm()))
            && (this.getEvalDt() == null ? other.getEvalDt() == null : this.getEvalDt().equals(other.getEvalDt()))
            && (this.getEvalNetVal() == null ? other.getEvalNetVal() == null : this.getEvalNetVal().equals(other.getEvalNetVal()))
            && (this.getConfirmVal() == null ? other.getConfirmVal() == null : this.getConfirmVal().equals(other.getConfirmVal()))
            && (this.getGntyAmt() == null ? other.getGntyAmt() == null : this.getGntyAmt().equals(other.getGntyAmt()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getGntyRegOrg() == null ? other.getGntyRegOrg() == null : this.getGntyRegOrg().equals(other.getGntyRegOrg()))
            && (this.getGntyRegDt() == null ? other.getGntyRegDt() == null : this.getGntyRegDt().equals(other.getGntyRegDt()))
            && (this.getGntyWoDt() == null ? other.getGntyWoDt() == null : this.getGntyWoDt().equals(other.getGntyWoDt()))
            && (this.getAbtAmt() == null ? other.getAbtAmt() == null : this.getAbtAmt().equals(other.getAbtAmt()))
            && (this.getAbtSum1() == null ? other.getAbtSum1() == null : this.getAbtSum1().equals(other.getAbtSum1()))
            && (this.getAbtSum2() == null ? other.getAbtSum2() == null : this.getAbtSum2().equals(other.getAbtSum2()))
            && (this.getAbtSum3() == null ? other.getAbtSum3() == null : this.getAbtSum3().equals(other.getAbtSum3()))
            && (this.getAbtRate() == null ? other.getAbtRate() == null : this.getAbtRate().equals(other.getAbtRate()))
            && (this.getOtRtnNo() == null ? other.getOtRtnNo() == null : this.getOtRtnNo().equals(other.getOtRtnNo()))
            && (this.getFlg1() == null ? other.getFlg1() == null : this.getFlg1().equals(other.getFlg1()))
            && (this.getFlg2() == null ? other.getFlg2() == null : this.getFlg2().equals(other.getFlg2()))
            && (this.getFlg3() == null ? other.getFlg3() == null : this.getFlg3().equals(other.getFlg3()))
            && (this.getIfrmBak() == null ? other.getIfrmBak() == null : this.getIfrmBak().equals(other.getIfrmBak()))
            && (this.getCfrmBak() == null ? other.getCfrmBak() == null : this.getCfrmBak().equals(other.getCfrmBak()))
            && (this.getAbtNm() == null ? other.getAbtNm() == null : this.getAbtNm().equals(other.getAbtNm()))
            && (this.getPayNm() == null ? other.getPayNm() == null : this.getPayNm().equals(other.getPayNm()))
            && (this.getCfrmArea() == null ? other.getCfrmArea() == null : this.getCfrmArea().equals(other.getCfrmArea()))
            && (this.getSapVchTyp() == null ? other.getSapVchTyp() == null : this.getSapVchTyp().equals(other.getSapVchTyp()))
            && (this.getAbtTyp() == null ? other.getAbtTyp() == null : this.getAbtTyp().equals(other.getAbtTyp()))
            && (this.getRem() == null ? other.getRem() == null : this.getRem().equals(other.getRem()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getTlrNm() == null ? other.getTlrNm() == null : this.getTlrNm().equals(other.getTlrNm()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getBrNm() == null ? other.getBrNm() == null : this.getBrNm().equals(other.getBrNm()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()))
            && (this.getLstUpdTlr() == null ? other.getLstUpdTlr() == null : this.getLstUpdTlr().equals(other.getLstUpdTlr()))
            && (this.getLstUpdTlrNm() == null ? other.getLstUpdTlrNm() == null : this.getLstUpdTlrNm().equals(other.getLstUpdTlrNm()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdBrNm() == null ? other.getLstUpdBrNm() == null : this.getLstUpdBrNm().equals(other.getLstUpdBrNm()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()))
            && (this.getConId() == null ? other.getConId() == null : this.getConId().equals(other.getConId()))
            && (this.getConNo() == null ? other.getConNo() == null : this.getConNo().equals(other.getConNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGntyId() == null) ? 0 : getGntyId().hashCode());
        result = prime * result + ((getGntyNm() == null) ? 0 : getGntyNm().hashCode());
        result = prime * result + ((getGntyTyp() == null) ? 0 : getGntyTyp().hashCode());
        result = prime * result + ((getCertTyp() == null) ? 0 : getCertTyp().hashCode());
        result = prime * result + ((getCertId() == null) ? 0 : getCertId().hashCode());
        result = prime * result + ((getOwnerNm() == null) ? 0 : getOwnerNm().hashCode());
        result = prime * result + ((getCertLnNo() == null) ? 0 : getCertLnNo().hashCode());
        result = prime * result + ((getOwnerTyp() == null) ? 0 : getOwnerTyp().hashCode());
        result = prime * result + ((getGntyRid() == null) ? 0 : getGntyRid().hashCode());
        result = prime * result + ((getGntySubTyp() == null) ? 0 : getGntySubTyp().hashCode());
        result = prime * result + ((getGntySubNm() == null) ? 0 : getGntySubNm().hashCode());
        result = prime * result + ((getGntyLoc() == null) ? 0 : getGntyLoc().hashCode());
        result = prime * result + ((getGntyArea() == null) ? 0 : getGntyArea().hashCode());
        result = prime * result + ((getGntyAttr() == null) ? 0 : getGntyAttr().hashCode());
        result = prime * result + ((getGntyOwnWay() == null) ? 0 : getGntyOwnWay().hashCode());
        result = prime * result + ((getGntyUsing() == null) ? 0 : getGntyUsing().hashCode());
        result = prime * result + ((getGntyPrc() == null) ? 0 : getGntyPrc().hashCode());
        result = prime * result + ((getEvalMthd() == null) ? 0 : getEvalMthd().hashCode());
        result = prime * result + ((getEvalOrgNm() == null) ? 0 : getEvalOrgNm().hashCode());
        result = prime * result + ((getEvalDt() == null) ? 0 : getEvalDt().hashCode());
        result = prime * result + ((getEvalNetVal() == null) ? 0 : getEvalNetVal().hashCode());
        result = prime * result + ((getConfirmVal() == null) ? 0 : getConfirmVal().hashCode());
        result = prime * result + ((getGntyAmt() == null) ? 0 : getGntyAmt().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getGntyRegOrg() == null) ? 0 : getGntyRegOrg().hashCode());
        result = prime * result + ((getGntyRegDt() == null) ? 0 : getGntyRegDt().hashCode());
        result = prime * result + ((getGntyWoDt() == null) ? 0 : getGntyWoDt().hashCode());
        result = prime * result + ((getAbtAmt() == null) ? 0 : getAbtAmt().hashCode());
        result = prime * result + ((getAbtSum1() == null) ? 0 : getAbtSum1().hashCode());
        result = prime * result + ((getAbtSum2() == null) ? 0 : getAbtSum2().hashCode());
        result = prime * result + ((getAbtSum3() == null) ? 0 : getAbtSum3().hashCode());
        result = prime * result + ((getAbtRate() == null) ? 0 : getAbtRate().hashCode());
        result = prime * result + ((getOtRtnNo() == null) ? 0 : getOtRtnNo().hashCode());
        result = prime * result + ((getFlg1() == null) ? 0 : getFlg1().hashCode());
        result = prime * result + ((getFlg2() == null) ? 0 : getFlg2().hashCode());
        result = prime * result + ((getFlg3() == null) ? 0 : getFlg3().hashCode());
        result = prime * result + ((getIfrmBak() == null) ? 0 : getIfrmBak().hashCode());
        result = prime * result + ((getCfrmBak() == null) ? 0 : getCfrmBak().hashCode());
        result = prime * result + ((getAbtNm() == null) ? 0 : getAbtNm().hashCode());
        result = prime * result + ((getPayNm() == null) ? 0 : getPayNm().hashCode());
        result = prime * result + ((getCfrmArea() == null) ? 0 : getCfrmArea().hashCode());
        result = prime * result + ((getSapVchTyp() == null) ? 0 : getSapVchTyp().hashCode());
        result = prime * result + ((getAbtTyp() == null) ? 0 : getAbtTyp().hashCode());
        result = prime * result + ((getRem() == null) ? 0 : getRem().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getTlrNm() == null) ? 0 : getTlrNm().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getBrNm() == null) ? 0 : getBrNm().hashCode());
        result = prime * result + ((getInpDt() == null) ? 0 : getInpDt().hashCode());
        result = prime * result + ((getLstUpdTlr() == null) ? 0 : getLstUpdTlr().hashCode());
        result = prime * result + ((getLstUpdTlrNm() == null) ? 0 : getLstUpdTlrNm().hashCode());
        result = prime * result + ((getLstUpdBrCd() == null) ? 0 : getLstUpdBrCd().hashCode());
        result = prime * result + ((getLstUpdBrNm() == null) ? 0 : getLstUpdBrNm().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        result = prime * result + ((getConId() == null) ? 0 : getConId().hashCode());
        result = prime * result + ((getConNo() == null) ? 0 : getConNo().hashCode());
        return result;
    }
}