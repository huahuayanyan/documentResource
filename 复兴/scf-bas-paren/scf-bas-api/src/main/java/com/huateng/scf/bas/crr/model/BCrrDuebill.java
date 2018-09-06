package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrDuebill实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:42:40	     新增
 *
 * </pre>
 */
public class BCrrDuebill extends BCrrModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 借据号
     */
    private String cino;

    /**
     * VARCHAR(20)<br>
     * 合同号
     */
    private String conNo;

    /**
     * VARCHAR(40)<br>
     * 贷款账号/结算帐号
     */
    private String lnNo;

    /**
     * VARCHAR(20)<br>
     * 客户号
     */
    private String custCd;

    /**
     * VARCHAR(60) 必填<br>
     * 客户名称
     */
    private String custNm;

    /**
     * VARCHAR(20)<br>
     * 账务机构
     */
    private String actBrCd;

    /**
     * VARCHAR(6)<br>
     * 产品编号
     */
    private String prdId;

    /**
     * VARCHAR(60) 必填<br>
     * 产品名称
     */
    private String prdNm;

    /**
     * VARCHAR(10)<br>
     * 放款日期
     */
    private String isDt;

    /**
     * VARCHAR(10)<br>
     * 到期日期
     */
    private String teDt;

    /**
     * VARCHAR(10)<br>
     * 期限控制方式
     */
    private String trmCtlTyp;

    /**
     * VARCHAR(20)<br>
     * 贷款期限
     */
    private String trm;

    /**
     * DECIMAL(22)<br>
     * 期限年
     */
    private BigDecimal trmYear;

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
     * CHAR(2)<br>
     * 期限范围
     */
    private String trmRge;

    /**
     * VARCHAR(32)<br>
     * 相关流水号
     */
    private String relaId;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 当前已还期数
     */
    private BigDecimal perAdjEql;

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 贷款金额
     */
    private BigDecimal lnAmt;

    /**
     * VARCHAR(10)<br>
     * 还款方式
     */
    private String rtnTyp;

    /**
     * VARCHAR(10)<br>
     * 还款间隔
     */
    private String rtnInvl;

    /**
     * VARCHAR(10)<br>
     * 计息周期
     */
    private String rtnIntInvl;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 固定周期
     */
    private BigDecimal rtnPd;

    /**
     * VARCHAR(10)<br>
     * 不等额方式
     */
    private String nonEqlMd;

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 不等额方式金额
     */
    private BigDecimal nonEqlAmt;

    /**
     * VARCHAR(10)<br>
     * 还款途径
     */
    private String rtnMd;

    /**
     * VARCHAR(20)<br>
     * 还款卡号
     */
    private String rtnNo;

    /**
     * VARCHAR(20)<br>
     * 还款账号
     */
    private String rtnActNo;

    /**
     * VARCHAR(10)<br>
     * 还款日确定方式
     */
    private String rtnDtTyp;

    /**
     * VARCHAR(10)<br>
     * 还款日
     */
    private String rtnDt;

    /**
     * CHAR(1)<br>
     * 是否分阶段标志
     */
    private String phsFlg;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 阶段数
     */
    private BigDecimal phsNo;

    /**
     * VARCHAR(10)<br>
     * 利率调整方式
     */
    private String intAdj;

    /**
     * VARCHAR(10)<br>
     * 利率调整日期
     */
    private String intAdjDt;

    /**
     * CHAR(4)<br>
     * 利率代码
     */
    private String intCd;

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 基准利率
     */
    private BigDecimal basInt;

    /**
     * VARCHAR(10)<br>
     * 利率确定日期
     */
    private String ratDt;

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 利率浮动
     */
    private BigDecimal fltInt;

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 利率浮动值
     */
    private BigDecimal fltIntVal;

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 执行利率
     */
    private BigDecimal actInt;

    /**
     * VARCHAR(10)<br>
     * 罚息浮动选项
     */
    private String pfltIntOpt;

    /**
     * CHAR(4)<br>
     * 罚息利率代码
     */
    private String pfltCd;

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 罚息浮动率
     */
    private BigDecimal pfltFlt;

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 罚息利率
     */
    private BigDecimal pfltInt;

    /**
     * VARCHAR(10)<br>
     * 挪用罚息浮动选项
     */
    private String mispPfltOpt;

    /**
     * CHAR(4)<br>
     * 挪用罚息利率代码
     */
    private String mispPfltCd;

    /**
     * DECIMAL(22,4) 默认值[0]<br>
     * 挪用罚息浮动率
     */
    private BigDecimal mispPfltFlt;

    /**
     * DECIMAL(22,6) 默认值[0]<br>
     * 挪用罚息利率
     */
    private BigDecimal mispPfltInt;

    /**
     * VARCHAR(10)<br>
     * 计复息标志
     */
    private String isComint;

    /**
     * VARCHAR(10)<br>
     * 放款方向
     */
    private String payDrct;

    /**
     * VARCHAR(10)<br>
     * 放款途径
     */
    private String payMd;

    /**
     * VARCHAR(20)<br>
     * 放款卡号
     */
    private String payCdNo;

    /**
     * VARCHAR(20)<br>
     * 放款账号
     */
    private String payActNo;

    /**
     * VARCHAR(10)<br>
     * 保证金账号
     */
    private String bailActNo;

    /**
     * DECIMAL(5,2) 默认值[0]<br>
     * 保证金比例
     */
    private BigDecimal bailRat;

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 保证金金额
     */
    private BigDecimal bailAmt;

    /**
     * VARCHAR(10)<br>
     * 五级分类
     */
    private String clrCls;

    /**
     * VARCHAR(10)<br>
     * 清分日期
     */
    private String clrDt;

    /**
     * VARCHAR(10)<br>
     * 逾期计息方式
     */
    private String ovdRatTyp;

    /**
     * VARCHAR(10)<br>
     * 最早逾期日期
     */
    private String longOweDt;

    /**
     * CHAR(2)<br>
     * 逾期天数状态
     */
    private String ovdDaysStat;

    /**
     * CHAR(1)<br>
     * 放款形态
     */
    private String trmCls;

    /**
     * CHAR(1)<br>
     * 月初放款形态
     */
    private String monTrmCls;

    /**
     * CHAR(1)<br>
     * 贷款结清类型
     */
    private String clsTyp;

    /**
     * VARCHAR(10)<br>
     * 结转日期
     */
    private String trsfDt;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 累计逾期次数
     */
    private BigDecimal totOvdTms;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 当前逾期期数
     */
    private BigDecimal ovdPer;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 最高逾期期数
     */
    private BigDecimal maxOvdPer;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 已还款期数
     */
    private BigDecimal rtnPers;

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 累计已还本金
     */
    private BigDecimal totRtnAmt;

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 累计已还利息
     */
    private BigDecimal totRtnInt;

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 累计已还利息复利
     */
    private BigDecimal totRtnCint;

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 累计已还罚息
     */
    private BigDecimal totRtnPint;

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 累计已还罚息复利
     */
    private BigDecimal totRtnCpint;

    /**
     * DECIMAL(22,15)<br>
     * 累计未还罚息复利
     */
    private BigDecimal totOweCpint;

    /**
     * DECIMAL(22,15)<br>
     * 累计未还罚息
     */
    private BigDecimal totOwePint;

    /**
     * DECIMAL(22,15)<br>
     * 累计未还利息复利
     */
    private BigDecimal totOweCint;

    /**
     * DECIMAL(22,15)<br>
     * 累计未还利息
     */
    private BigDecimal totOweInt;

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 累计未还本金
     */
    private BigDecimal totOweAmt;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 展期次数
     */
    private BigDecimal extCnt;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 延期次数
     */
    private BigDecimal deferCnt;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 缩期次数
     */
    private BigDecimal shortenCnt;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 加按次数
     */
    private BigDecimal addCnt;

    /**
     * CHAR(1)<br>
     * 是否允许非本机构账号
     */
    private String isSelfBrno;

    /**
     * VARCHAR(256)<br>
     * 手续费收取方式
     */
    private String feeTyp;

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 手续费
     */
    private BigDecimal feeAmt;

    /**
     * DECIMAL(5,2) 默认值[0]<br>
     * 手续费比例
     */
    private BigDecimal feeRat;

    /**
     * VARCHAR(5)<br>
     * 手续费收取周期
     */
    private String feePd;

    /**
     * VARCHAR(20)<br>
     * 还款卡号2
     */
    private String rtnNo2;

    /**
     * VARCHAR(10)<br>
     * 利率浮动方式
     */
    private String intFltTyp;

    /**
     * VARCHAR(10)<br>
     * 罚息收取方式
     */
    private String pfltIntMd;

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 罚金金额
     */
    private BigDecimal pfltIntAmt;

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 复利浮动比
     */
    private BigDecimal refltInt;

    /**
     * VARCHAR(10)<br>
     * 最后一次扣款日
     */
    private String lplanRtnDt;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * VARCHAR(32)<br>
     * 出票人帐号
     */
    private String wrtNo;

    /**
     * CHAR(1)<br>
     * 借据状态
     */
    private String lnStat;

    /**
     * VARCHAR(10)<br>
     * 最后一次结息日
     */
    private String lplanRtnIntDt;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 借据号
     */
    public String getCino() {
        return cino;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 借据号
     */
    public void setCino(String cino) {
        this.cino = cino == null ? null : cino.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 合同号
     */
    public String getConNo() {
        return conNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 合同号
     */
    public void setConNo(String conNo) {
        this.conNo = conNo == null ? null : conNo.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 贷款账号/结算帐号
     */
    public String getLnNo() {
        return lnNo;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 贷款账号/结算帐号
     */
    public void setLnNo(String lnNo) {
        this.lnNo = lnNo == null ? null : lnNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 客户号
     */
    public String getCustCd() {
        return custCd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 客户号
     */
    public void setCustCd(String custCd) {
        this.custCd = custCd == null ? null : custCd.trim();
    }

    /**
     * VARCHAR(60) 必填<br>
     * 获得 客户名称
     */
    public String getCustNm() {
        return custNm;
    }

    /**
     * VARCHAR(60) 必填<br>
     * 设置 客户名称
     */
    public void setCustNm(String custNm) {
        this.custNm = custNm == null ? null : custNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 账务机构
     */
    public String getActBrCd() {
        return actBrCd;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 账务机构
     */
    public void setActBrCd(String actBrCd) {
        this.actBrCd = actBrCd == null ? null : actBrCd.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 产品编号
     */
    public String getPrdId() {
        return prdId;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 产品编号
     */
    public void setPrdId(String prdId) {
        this.prdId = prdId == null ? null : prdId.trim();
    }

    /**
     * VARCHAR(60) 必填<br>
     * 获得 产品名称
     */
    public String getPrdNm() {
        return prdNm;
    }

    /**
     * VARCHAR(60) 必填<br>
     * 设置 产品名称
     */
    public void setPrdNm(String prdNm) {
        this.prdNm = prdNm == null ? null : prdNm.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 放款日期
     */
    public String getIsDt() {
        return isDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 放款日期
     */
    public void setIsDt(String isDt) {
        this.isDt = isDt == null ? null : isDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 到期日期
     */
    public String getTeDt() {
        return teDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 到期日期
     */
    public void setTeDt(String teDt) {
        this.teDt = teDt == null ? null : teDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 期限控制方式
     */
    public String getTrmCtlTyp() {
        return trmCtlTyp;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 期限控制方式
     */
    public void setTrmCtlTyp(String trmCtlTyp) {
        this.trmCtlTyp = trmCtlTyp == null ? null : trmCtlTyp.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 贷款期限
     */
    public String getTrm() {
        return trm;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 贷款期限
     */
    public void setTrm(String trm) {
        this.trm = trm == null ? null : trm.trim();
    }

    /**
     * DECIMAL(22)<br>
     */
    public BigDecimal getTrmYear() {
        return trmYear;
    }

    /**
     * DECIMAL(22)<br>
     */
    public void setTrmYear(BigDecimal trmYear) {
        this.trmYear = trmYear;
    }

    /**
     * DECIMAL(22)<br>
     */
    public BigDecimal getTrmMon() {
        return trmMon;
    }

    /**
     * DECIMAL(22)<br>
     */
    public void setTrmMon(BigDecimal trmMon) {
        this.trmMon = trmMon;
    }

    /**
     * DECIMAL(22)<br>
     */
    public BigDecimal getTrmDay() {
        return trmDay;
    }

    /**
     * DECIMAL(22)<br>
     */
    public void setTrmDay(BigDecimal trmDay) {
        this.trmDay = trmDay;
    }

    /**
     * CHAR(2)<br>
     * 获得 期限范围
     */
    public String getTrmRge() {
        return trmRge;
    }

    /**
     * CHAR(2)<br>
     * 设置 期限范围
     */
    public void setTrmRge(String trmRge) {
        this.trmRge = trmRge == null ? null : trmRge.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 相关流水号
     */
    public String getRelaId() {
        return relaId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 相关流水号
     */
    public void setRelaId(String relaId) {
        this.relaId = relaId == null ? null : relaId.trim();
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 当前已还期数
     */
    public BigDecimal getPerAdjEql() {
        return perAdjEql;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 当前已还期数
     */
    public void setPerAdjEql(BigDecimal perAdjEql) {
        this.perAdjEql = perAdjEql;
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 获得 贷款金额
     */
    public BigDecimal getLnAmt() {
        return lnAmt;
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 设置 贷款金额
     */
    public void setLnAmt(BigDecimal lnAmt) {
        this.lnAmt = lnAmt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 还款方式
     */
    public String getRtnTyp() {
        return rtnTyp;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 还款方式
     */
    public void setRtnTyp(String rtnTyp) {
        this.rtnTyp = rtnTyp == null ? null : rtnTyp.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 还款间隔
     */
    public String getRtnInvl() {
        return rtnInvl;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 还款间隔
     */
    public void setRtnInvl(String rtnInvl) {
        this.rtnInvl = rtnInvl == null ? null : rtnInvl.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 计息周期
     */
    public String getRtnIntInvl() {
        return rtnIntInvl;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 计息周期
     */
    public void setRtnIntInvl(String rtnIntInvl) {
        this.rtnIntInvl = rtnIntInvl == null ? null : rtnIntInvl.trim();
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 固定周期
     */
    public BigDecimal getRtnPd() {
        return rtnPd;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 固定周期
     */
    public void setRtnPd(BigDecimal rtnPd) {
        this.rtnPd = rtnPd;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 不等额方式
     */
    public String getNonEqlMd() {
        return nonEqlMd;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 不等额方式
     */
    public void setNonEqlMd(String nonEqlMd) {
        this.nonEqlMd = nonEqlMd == null ? null : nonEqlMd.trim();
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 获得 不等额方式金额
     */
    public BigDecimal getNonEqlAmt() {
        return nonEqlAmt;
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 设置 不等额方式金额
     */
    public void setNonEqlAmt(BigDecimal nonEqlAmt) {
        this.nonEqlAmt = nonEqlAmt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 还款途径
     */
    public String getRtnMd() {
        return rtnMd;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 还款途径
     */
    public void setRtnMd(String rtnMd) {
        this.rtnMd = rtnMd == null ? null : rtnMd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 还款卡号
     */
    public String getRtnNo() {
        return rtnNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 还款卡号
     */
    public void setRtnNo(String rtnNo) {
        this.rtnNo = rtnNo == null ? null : rtnNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 还款账号
     */
    public String getRtnActNo() {
        return rtnActNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 还款账号
     */
    public void setRtnActNo(String rtnActNo) {
        this.rtnActNo = rtnActNo == null ? null : rtnActNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 还款日确定方式
     */
    public String getRtnDtTyp() {
        return rtnDtTyp;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 还款日确定方式
     */
    public void setRtnDtTyp(String rtnDtTyp) {
        this.rtnDtTyp = rtnDtTyp == null ? null : rtnDtTyp.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 还款日
     */
    public String getRtnDt() {
        return rtnDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 还款日
     */
    public void setRtnDt(String rtnDt) {
        this.rtnDt = rtnDt == null ? null : rtnDt.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否分阶段标志
     */
    public String getPhsFlg() {
        return phsFlg;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否分阶段标志
     */
    public void setPhsFlg(String phsFlg) {
        this.phsFlg = phsFlg == null ? null : phsFlg.trim();
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 阶段数
     */
    public BigDecimal getPhsNo() {
        return phsNo;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 阶段数
     */
    public void setPhsNo(BigDecimal phsNo) {
        this.phsNo = phsNo;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率调整方式
     */
    public String getIntAdj() {
        return intAdj;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率调整方式
     */
    public void setIntAdj(String intAdj) {
        this.intAdj = intAdj == null ? null : intAdj.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率调整日期
     */
    public String getIntAdjDt() {
        return intAdjDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率调整日期
     */
    public void setIntAdjDt(String intAdjDt) {
        this.intAdjDt = intAdjDt == null ? null : intAdjDt.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 利率代码
     */
    public String getIntCd() {
        return intCd;
    }

    /**
     * CHAR(4)<br>
     * 设置 利率代码
     */
    public void setIntCd(String intCd) {
        this.intCd = intCd == null ? null : intCd.trim();
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 获得 基准利率
     */
    public BigDecimal getBasInt() {
        return basInt;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 设置 基准利率
     */
    public void setBasInt(BigDecimal basInt) {
        this.basInt = basInt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率确定日期
     */
    public String getRatDt() {
        return ratDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率确定日期
     */
    public void setRatDt(String ratDt) {
        this.ratDt = ratDt == null ? null : ratDt.trim();
    }

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 获得 利率浮动
     */
    public BigDecimal getFltInt() {
        return fltInt;
    }

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 设置 利率浮动
     */
    public void setFltInt(BigDecimal fltInt) {
        this.fltInt = fltInt;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 获得 利率浮动值
     */
    public BigDecimal getFltIntVal() {
        return fltIntVal;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 设置 利率浮动值
     */
    public void setFltIntVal(BigDecimal fltIntVal) {
        this.fltIntVal = fltIntVal;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 获得 执行利率
     */
    public BigDecimal getActInt() {
        return actInt;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 设置 执行利率
     */
    public void setActInt(BigDecimal actInt) {
        this.actInt = actInt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 罚息浮动选项
     */
    public String getPfltIntOpt() {
        return pfltIntOpt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 罚息浮动选项
     */
    public void setPfltIntOpt(String pfltIntOpt) {
        this.pfltIntOpt = pfltIntOpt == null ? null : pfltIntOpt.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 罚息利率代码
     */
    public String getPfltCd() {
        return pfltCd;
    }

    /**
     * CHAR(4)<br>
     * 设置 罚息利率代码
     */
    public void setPfltCd(String pfltCd) {
        this.pfltCd = pfltCd == null ? null : pfltCd.trim();
    }

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 获得 罚息浮动率
     */
    public BigDecimal getPfltFlt() {
        return pfltFlt;
    }

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 设置 罚息浮动率
     */
    public void setPfltFlt(BigDecimal pfltFlt) {
        this.pfltFlt = pfltFlt;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 获得 罚息利率
     */
    public BigDecimal getPfltInt() {
        return pfltInt;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 设置 罚息利率
     */
    public void setPfltInt(BigDecimal pfltInt) {
        this.pfltInt = pfltInt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 挪用罚息浮动选项
     */
    public String getMispPfltOpt() {
        return mispPfltOpt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 挪用罚息浮动选项
     */
    public void setMispPfltOpt(String mispPfltOpt) {
        this.mispPfltOpt = mispPfltOpt == null ? null : mispPfltOpt.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 挪用罚息利率代码
     */
    public String getMispPfltCd() {
        return mispPfltCd;
    }

    /**
     * CHAR(4)<br>
     * 设置 挪用罚息利率代码
     */
    public void setMispPfltCd(String mispPfltCd) {
        this.mispPfltCd = mispPfltCd == null ? null : mispPfltCd.trim();
    }

    /**
     * DECIMAL(22,4) 默认值[0]<br>
     * 获得 挪用罚息浮动率
     */
    public BigDecimal getMispPfltFlt() {
        return mispPfltFlt;
    }

    /**
     * DECIMAL(22,4) 默认值[0]<br>
     * 设置 挪用罚息浮动率
     */
    public void setMispPfltFlt(BigDecimal mispPfltFlt) {
        this.mispPfltFlt = mispPfltFlt;
    }

    /**
     * DECIMAL(22,6) 默认值[0]<br>
     * 获得 挪用罚息利率
     */
    public BigDecimal getMispPfltInt() {
        return mispPfltInt;
    }

    /**
     * DECIMAL(22,6) 默认值[0]<br>
     * 设置 挪用罚息利率
     */
    public void setMispPfltInt(BigDecimal mispPfltInt) {
        this.mispPfltInt = mispPfltInt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 计复息标志
     */
    public String getIsComint() {
        return isComint;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 计复息标志
     */
    public void setIsComint(String isComint) {
        this.isComint = isComint == null ? null : isComint.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 放款方向
     */
    public String getPayDrct() {
        return payDrct;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 放款方向
     */
    public void setPayDrct(String payDrct) {
        this.payDrct = payDrct == null ? null : payDrct.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 放款途径
     */
    public String getPayMd() {
        return payMd;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 放款途径
     */
    public void setPayMd(String payMd) {
        this.payMd = payMd == null ? null : payMd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 放款卡号
     */
    public String getPayCdNo() {
        return payCdNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 放款卡号
     */
    public void setPayCdNo(String payCdNo) {
        this.payCdNo = payCdNo == null ? null : payCdNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 放款账号
     */
    public String getPayActNo() {
        return payActNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 放款账号
     */
    public void setPayActNo(String payActNo) {
        this.payActNo = payActNo == null ? null : payActNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 保证金账号
     */
    public String getBailActNo() {
        return bailActNo;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 保证金账号
     */
    public void setBailActNo(String bailActNo) {
        this.bailActNo = bailActNo == null ? null : bailActNo.trim();
    }

    /**
     * DECIMAL(5,2) 默认值[0]<br>
     * 获得 保证金比例
     */
    public BigDecimal getBailRat() {
        return bailRat;
    }

    /**
     * DECIMAL(5,2) 默认值[0]<br>
     * 设置 保证金比例
     */
    public void setBailRat(BigDecimal bailRat) {
        this.bailRat = bailRat;
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 获得 保证金金额
     */
    public BigDecimal getBailAmt() {
        return bailAmt;
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 设置 保证金金额
     */
    public void setBailAmt(BigDecimal bailAmt) {
        this.bailAmt = bailAmt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 五级分类
     */
    public String getClrCls() {
        return clrCls;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 五级分类
     */
    public void setClrCls(String clrCls) {
        this.clrCls = clrCls == null ? null : clrCls.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 清分日期
     */
    public String getClrDt() {
        return clrDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 清分日期
     */
    public void setClrDt(String clrDt) {
        this.clrDt = clrDt == null ? null : clrDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 逾期计息方式
     */
    public String getOvdRatTyp() {
        return ovdRatTyp;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 逾期计息方式
     */
    public void setOvdRatTyp(String ovdRatTyp) {
        this.ovdRatTyp = ovdRatTyp == null ? null : ovdRatTyp.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 最早逾期日期
     */
    public String getLongOweDt() {
        return longOweDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 最早逾期日期
     */
    public void setLongOweDt(String longOweDt) {
        this.longOweDt = longOweDt == null ? null : longOweDt.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 逾期天数状态
     */
    public String getOvdDaysStat() {
        return ovdDaysStat;
    }

    /**
     * CHAR(2)<br>
     * 设置 逾期天数状态
     */
    public void setOvdDaysStat(String ovdDaysStat) {
        this.ovdDaysStat = ovdDaysStat == null ? null : ovdDaysStat.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 放款形态
     */
    public String getTrmCls() {
        return trmCls;
    }

    /**
     * CHAR(1)<br>
     * 设置 放款形态
     */
    public void setTrmCls(String trmCls) {
        this.trmCls = trmCls == null ? null : trmCls.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 月初放款形态
     */
    public String getMonTrmCls() {
        return monTrmCls;
    }

    /**
     * CHAR(1)<br>
     * 设置 月初放款形态
     */
    public void setMonTrmCls(String monTrmCls) {
        this.monTrmCls = monTrmCls == null ? null : monTrmCls.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 贷款结清类型
     */
    public String getClsTyp() {
        return clsTyp;
    }

    /**
     * CHAR(1)<br>
     * 设置 贷款结清类型
     */
    public void setClsTyp(String clsTyp) {
        this.clsTyp = clsTyp == null ? null : clsTyp.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 结转日期
     */
    public String getTrsfDt() {
        return trsfDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 结转日期
     */
    public void setTrsfDt(String trsfDt) {
        this.trsfDt = trsfDt == null ? null : trsfDt.trim();
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 累计逾期次数
     */
    public BigDecimal getTotOvdTms() {
        return totOvdTms;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 累计逾期次数
     */
    public void setTotOvdTms(BigDecimal totOvdTms) {
        this.totOvdTms = totOvdTms;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 当前逾期期数
     */
    public BigDecimal getOvdPer() {
        return ovdPer;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 当前逾期期数
     */
    public void setOvdPer(BigDecimal ovdPer) {
        this.ovdPer = ovdPer;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 最高逾期期数
     */
    public BigDecimal getMaxOvdPer() {
        return maxOvdPer;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 最高逾期期数
     */
    public void setMaxOvdPer(BigDecimal maxOvdPer) {
        this.maxOvdPer = maxOvdPer;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 已还款期数
     */
    public BigDecimal getRtnPers() {
        return rtnPers;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 已还款期数
     */
    public void setRtnPers(BigDecimal rtnPers) {
        this.rtnPers = rtnPers;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 获得 累计已还本金
     */
    public BigDecimal getTotRtnAmt() {
        return totRtnAmt;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 设置 累计已还本金
     */
    public void setTotRtnAmt(BigDecimal totRtnAmt) {
        this.totRtnAmt = totRtnAmt;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 获得 累计已还利息
     */
    public BigDecimal getTotRtnInt() {
        return totRtnInt;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 设置 累计已还利息
     */
    public void setTotRtnInt(BigDecimal totRtnInt) {
        this.totRtnInt = totRtnInt;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 获得 累计已还利息复利
     */
    public BigDecimal getTotRtnCint() {
        return totRtnCint;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 设置 累计已还利息复利
     */
    public void setTotRtnCint(BigDecimal totRtnCint) {
        this.totRtnCint = totRtnCint;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 获得 累计已还罚息
     */
    public BigDecimal getTotRtnPint() {
        return totRtnPint;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 设置 累计已还罚息
     */
    public void setTotRtnPint(BigDecimal totRtnPint) {
        this.totRtnPint = totRtnPint;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 获得 累计已还罚息复利
     */
    public BigDecimal getTotRtnCpint() {
        return totRtnCpint;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 设置 累计已还罚息复利
     */
    public void setTotRtnCpint(BigDecimal totRtnCpint) {
        this.totRtnCpint = totRtnCpint;
    }

    /**
     * DECIMAL(22,15)<br>
     * 获得 累计未还罚息复利
     */
    public BigDecimal getTotOweCpint() {
        return totOweCpint;
    }

    /**
     * DECIMAL(22,15)<br>
     * 设置 累计未还罚息复利
     */
    public void setTotOweCpint(BigDecimal totOweCpint) {
        this.totOweCpint = totOweCpint;
    }

    /**
     * DECIMAL(22,15)<br>
     * 获得 累计未还罚息
     */
    public BigDecimal getTotOwePint() {
        return totOwePint;
    }

    /**
     * DECIMAL(22,15)<br>
     * 设置 累计未还罚息
     */
    public void setTotOwePint(BigDecimal totOwePint) {
        this.totOwePint = totOwePint;
    }

    /**
     * DECIMAL(22,15)<br>
     * 获得 累计未还利息复利
     */
    public BigDecimal getTotOweCint() {
        return totOweCint;
    }

    /**
     * DECIMAL(22,15)<br>
     * 设置 累计未还利息复利
     */
    public void setTotOweCint(BigDecimal totOweCint) {
        this.totOweCint = totOweCint;
    }

    /**
     * DECIMAL(22,15)<br>
     * 获得 累计未还利息
     */
    public BigDecimal getTotOweInt() {
        return totOweInt;
    }

    /**
     * DECIMAL(22,15)<br>
     * 设置 累计未还利息
     */
    public void setTotOweInt(BigDecimal totOweInt) {
        this.totOweInt = totOweInt;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 获得 累计未还本金
     */
    public BigDecimal getTotOweAmt() {
        return totOweAmt;
    }

    /**
     * DECIMAL(22,15) 默认值[0]<br>
     * 设置 累计未还本金
     */
    public void setTotOweAmt(BigDecimal totOweAmt) {
        this.totOweAmt = totOweAmt;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 展期次数
     */
    public BigDecimal getExtCnt() {
        return extCnt;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 展期次数
     */
    public void setExtCnt(BigDecimal extCnt) {
        this.extCnt = extCnt;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 延期次数
     */
    public BigDecimal getDeferCnt() {
        return deferCnt;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 延期次数
     */
    public void setDeferCnt(BigDecimal deferCnt) {
        this.deferCnt = deferCnt;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 缩期次数
     */
    public BigDecimal getShortenCnt() {
        return shortenCnt;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 缩期次数
     */
    public void setShortenCnt(BigDecimal shortenCnt) {
        this.shortenCnt = shortenCnt;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 加按次数
     */
    public BigDecimal getAddCnt() {
        return addCnt;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 加按次数
     */
    public void setAddCnt(BigDecimal addCnt) {
        this.addCnt = addCnt;
    }

    /**
     * CHAR(1)<br>
     * 获得 是否允许非本机构账号
     */
    public String getIsSelfBrno() {
        return isSelfBrno;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否允许非本机构账号
     */
    public void setIsSelfBrno(String isSelfBrno) {
        this.isSelfBrno = isSelfBrno == null ? null : isSelfBrno.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 手续费收取方式
     */
    public String getFeeTyp() {
        return feeTyp;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 手续费收取方式
     */
    public void setFeeTyp(String feeTyp) {
        this.feeTyp = feeTyp == null ? null : feeTyp.trim();
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 获得 手续费
     */
    public BigDecimal getFeeAmt() {
        return feeAmt;
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 设置 手续费
     */
    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    /**
     * DECIMAL(5,2) 默认值[0]<br>
     * 获得 手续费比例
     */
    public BigDecimal getFeeRat() {
        return feeRat;
    }

    /**
     * DECIMAL(5,2) 默认值[0]<br>
     * 设置 手续费比例
     */
    public void setFeeRat(BigDecimal feeRat) {
        this.feeRat = feeRat;
    }

    /**
     * VARCHAR(5)<br>
     * 获得 手续费收取周期
     */
    public String getFeePd() {
        return feePd;
    }

    /**
     * VARCHAR(5)<br>
     * 设置 手续费收取周期
     */
    public void setFeePd(String feePd) {
        this.feePd = feePd == null ? null : feePd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 还款卡号2
     */
    public String getRtnNo2() {
        return rtnNo2;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 还款卡号2
     */
    public void setRtnNo2(String rtnNo2) {
        this.rtnNo2 = rtnNo2 == null ? null : rtnNo2.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率浮动方式
     */
    public String getIntFltTyp() {
        return intFltTyp;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率浮动方式
     */
    public void setIntFltTyp(String intFltTyp) {
        this.intFltTyp = intFltTyp == null ? null : intFltTyp.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 罚息收取方式
     */
    public String getPfltIntMd() {
        return pfltIntMd;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 罚息收取方式
     */
    public void setPfltIntMd(String pfltIntMd) {
        this.pfltIntMd = pfltIntMd == null ? null : pfltIntMd.trim();
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 获得 罚金金额
     */
    public BigDecimal getPfltIntAmt() {
        return pfltIntAmt;
    }

    /**
     * DECIMAL(15,2) 默认值[0]<br>
     * 设置 罚金金额
     */
    public void setPfltIntAmt(BigDecimal pfltIntAmt) {
        this.pfltIntAmt = pfltIntAmt;
    }

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 获得 复利浮动比
     */
    public BigDecimal getRefltInt() {
        return refltInt;
    }

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 设置 复利浮动比
     */
    public void setRefltInt(BigDecimal refltInt) {
        this.refltInt = refltInt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 最后一次扣款日
     */
    public String getLplanRtnDt() {
        return lplanRtnDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 最后一次扣款日
     */
    public void setLplanRtnDt(String lplanRtnDt) {
        this.lplanRtnDt = lplanRtnDt == null ? null : lplanRtnDt.trim();
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
     * VARCHAR(32)<br>
     * 获得 出票人帐号
     */
    public String getWrtNo() {
        return wrtNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 出票人帐号
     */
    public void setWrtNo(String wrtNo) {
        this.wrtNo = wrtNo == null ? null : wrtNo.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 借据状态
     */
    public String getLnStat() {
        return lnStat;
    }

    /**
     * CHAR(1)<br>
     * 设置 借据状态
     */
    public void setLnStat(String lnStat) {
        this.lnStat = lnStat == null ? null : lnStat.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 最后一次结息日
     */
    public String getLplanRtnIntDt() {
        return lplanRtnIntDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 最后一次结息日
     */
    public void setLplanRtnIntDt(String lplanRtnIntDt) {
        this.lplanRtnIntDt = lplanRtnIntDt == null ? null : lplanRtnIntDt.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cino=").append(cino);
        sb.append(", conNo=").append(conNo);
        sb.append(", lnNo=").append(lnNo);
        sb.append(", custCd=").append(custCd);
        sb.append(", custNm=").append(custNm);
        sb.append(", actBrCd=").append(actBrCd);
        sb.append(", prdId=").append(prdId);
        sb.append(", prdNm=").append(prdNm);
        sb.append(", isDt=").append(isDt);
        sb.append(", teDt=").append(teDt);
        sb.append(", trmCtlTyp=").append(trmCtlTyp);
        sb.append(", trm=").append(trm);
        sb.append(", trmYear=").append(trmYear);
        sb.append(", trmMon=").append(trmMon);
        sb.append(", trmDay=").append(trmDay);
        sb.append(", trmRge=").append(trmRge);
        sb.append(", relaId=").append(relaId);
        sb.append(", perAdjEql=").append(perAdjEql);
        sb.append(", lnAmt=").append(lnAmt);
        sb.append(", rtnTyp=").append(rtnTyp);
        sb.append(", rtnInvl=").append(rtnInvl);
        sb.append(", rtnIntInvl=").append(rtnIntInvl);
        sb.append(", rtnPd=").append(rtnPd);
        sb.append(", nonEqlMd=").append(nonEqlMd);
        sb.append(", nonEqlAmt=").append(nonEqlAmt);
        sb.append(", rtnMd=").append(rtnMd);
        sb.append(", rtnNo=").append(rtnNo);
        sb.append(", rtnActNo=").append(rtnActNo);
        sb.append(", rtnDtTyp=").append(rtnDtTyp);
        sb.append(", rtnDt=").append(rtnDt);
        sb.append(", phsFlg=").append(phsFlg);
        sb.append(", phsNo=").append(phsNo);
        sb.append(", intAdj=").append(intAdj);
        sb.append(", intAdjDt=").append(intAdjDt);
        sb.append(", intCd=").append(intCd);
        sb.append(", basInt=").append(basInt);
        sb.append(", ratDt=").append(ratDt);
        sb.append(", fltInt=").append(fltInt);
        sb.append(", fltIntVal=").append(fltIntVal);
        sb.append(", actInt=").append(actInt);
        sb.append(", pfltIntOpt=").append(pfltIntOpt);
        sb.append(", pfltCd=").append(pfltCd);
        sb.append(", pfltFlt=").append(pfltFlt);
        sb.append(", pfltInt=").append(pfltInt);
        sb.append(", mispPfltOpt=").append(mispPfltOpt);
        sb.append(", mispPfltCd=").append(mispPfltCd);
        sb.append(", mispPfltFlt=").append(mispPfltFlt);
        sb.append(", mispPfltInt=").append(mispPfltInt);
        sb.append(", isComint=").append(isComint);
        sb.append(", payDrct=").append(payDrct);
        sb.append(", payMd=").append(payMd);
        sb.append(", payCdNo=").append(payCdNo);
        sb.append(", payActNo=").append(payActNo);
        sb.append(", bailActNo=").append(bailActNo);
        sb.append(", bailRat=").append(bailRat);
        sb.append(", bailAmt=").append(bailAmt);
        sb.append(", clrCls=").append(clrCls);
        sb.append(", clrDt=").append(clrDt);
        sb.append(", ovdRatTyp=").append(ovdRatTyp);
        sb.append(", longOweDt=").append(longOweDt);
        sb.append(", ovdDaysStat=").append(ovdDaysStat);
        sb.append(", trmCls=").append(trmCls);
        sb.append(", monTrmCls=").append(monTrmCls);
        sb.append(", clsTyp=").append(clsTyp);
        sb.append(", trsfDt=").append(trsfDt);
        sb.append(", totOvdTms=").append(totOvdTms);
        sb.append(", ovdPer=").append(ovdPer);
        sb.append(", maxOvdPer=").append(maxOvdPer);
        sb.append(", rtnPers=").append(rtnPers);
        sb.append(", totRtnAmt=").append(totRtnAmt);
        sb.append(", totRtnInt=").append(totRtnInt);
        sb.append(", totRtnCint=").append(totRtnCint);
        sb.append(", totRtnPint=").append(totRtnPint);
        sb.append(", totRtnCpint=").append(totRtnCpint);
        sb.append(", totOweCpint=").append(totOweCpint);
        sb.append(", totOwePint=").append(totOwePint);
        sb.append(", totOweCint=").append(totOweCint);
        sb.append(", totOweInt=").append(totOweInt);
        sb.append(", totOweAmt=").append(totOweAmt);
        sb.append(", extCnt=").append(extCnt);
        sb.append(", deferCnt=").append(deferCnt);
        sb.append(", shortenCnt=").append(shortenCnt);
        sb.append(", addCnt=").append(addCnt);
        sb.append(", isSelfBrno=").append(isSelfBrno);
        sb.append(", feeTyp=").append(feeTyp);
        sb.append(", feeAmt=").append(feeAmt);
        sb.append(", feeRat=").append(feeRat);
        sb.append(", feePd=").append(feePd);
        sb.append(", rtnNo2=").append(rtnNo2);
        sb.append(", intFltTyp=").append(intFltTyp);
        sb.append(", pfltIntMd=").append(pfltIntMd);
        sb.append(", pfltIntAmt=").append(pfltIntAmt);
        sb.append(", refltInt=").append(refltInt);
        sb.append(", lplanRtnDt=").append(lplanRtnDt);
        sb.append(", curcd=").append(curcd);
        sb.append(", wrtNo=").append(wrtNo);
        sb.append(", lnStat=").append(lnStat);
        sb.append(", lplanRtnIntDt=").append(lplanRtnIntDt);
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
        BCrrDuebill other = (BCrrDuebill) that;
        return (this.getCino() == null ? other.getCino() == null : this.getCino().equals(other.getCino()))
            && (this.getConNo() == null ? other.getConNo() == null : this.getConNo().equals(other.getConNo()))
            && (this.getLnNo() == null ? other.getLnNo() == null : this.getLnNo().equals(other.getLnNo()))
            && (this.getCustCd() == null ? other.getCustCd() == null : this.getCustCd().equals(other.getCustCd()))
            && (this.getCustNm() == null ? other.getCustNm() == null : this.getCustNm().equals(other.getCustNm()))
            && (this.getActBrCd() == null ? other.getActBrCd() == null : this.getActBrCd().equals(other.getActBrCd()))
            && (this.getPrdId() == null ? other.getPrdId() == null : this.getPrdId().equals(other.getPrdId()))
            && (this.getPrdNm() == null ? other.getPrdNm() == null : this.getPrdNm().equals(other.getPrdNm()))
            && (this.getIsDt() == null ? other.getIsDt() == null : this.getIsDt().equals(other.getIsDt()))
            && (this.getTeDt() == null ? other.getTeDt() == null : this.getTeDt().equals(other.getTeDt()))
            && (this.getTrmCtlTyp() == null ? other.getTrmCtlTyp() == null : this.getTrmCtlTyp().equals(other.getTrmCtlTyp()))
            && (this.getTrm() == null ? other.getTrm() == null : this.getTrm().equals(other.getTrm()))
            && (this.getTrmYear() == null ? other.getTrmYear() == null : this.getTrmYear().equals(other.getTrmYear()))
            && (this.getTrmMon() == null ? other.getTrmMon() == null : this.getTrmMon().equals(other.getTrmMon()))
            && (this.getTrmDay() == null ? other.getTrmDay() == null : this.getTrmDay().equals(other.getTrmDay()))
            && (this.getTrmRge() == null ? other.getTrmRge() == null : this.getTrmRge().equals(other.getTrmRge()))
            && (this.getRelaId() == null ? other.getRelaId() == null : this.getRelaId().equals(other.getRelaId()))
            && (this.getPerAdjEql() == null ? other.getPerAdjEql() == null : this.getPerAdjEql().equals(other.getPerAdjEql()))
            && (this.getLnAmt() == null ? other.getLnAmt() == null : this.getLnAmt().equals(other.getLnAmt()))
            && (this.getRtnTyp() == null ? other.getRtnTyp() == null : this.getRtnTyp().equals(other.getRtnTyp()))
            && (this.getRtnInvl() == null ? other.getRtnInvl() == null : this.getRtnInvl().equals(other.getRtnInvl()))
            && (this.getRtnIntInvl() == null ? other.getRtnIntInvl() == null : this.getRtnIntInvl().equals(other.getRtnIntInvl()))
            && (this.getRtnPd() == null ? other.getRtnPd() == null : this.getRtnPd().equals(other.getRtnPd()))
            && (this.getNonEqlMd() == null ? other.getNonEqlMd() == null : this.getNonEqlMd().equals(other.getNonEqlMd()))
            && (this.getNonEqlAmt() == null ? other.getNonEqlAmt() == null : this.getNonEqlAmt().equals(other.getNonEqlAmt()))
            && (this.getRtnMd() == null ? other.getRtnMd() == null : this.getRtnMd().equals(other.getRtnMd()))
            && (this.getRtnNo() == null ? other.getRtnNo() == null : this.getRtnNo().equals(other.getRtnNo()))
            && (this.getRtnActNo() == null ? other.getRtnActNo() == null : this.getRtnActNo().equals(other.getRtnActNo()))
            && (this.getRtnDtTyp() == null ? other.getRtnDtTyp() == null : this.getRtnDtTyp().equals(other.getRtnDtTyp()))
            && (this.getRtnDt() == null ? other.getRtnDt() == null : this.getRtnDt().equals(other.getRtnDt()))
            && (this.getPhsFlg() == null ? other.getPhsFlg() == null : this.getPhsFlg().equals(other.getPhsFlg()))
            && (this.getPhsNo() == null ? other.getPhsNo() == null : this.getPhsNo().equals(other.getPhsNo()))
            && (this.getIntAdj() == null ? other.getIntAdj() == null : this.getIntAdj().equals(other.getIntAdj()))
            && (this.getIntAdjDt() == null ? other.getIntAdjDt() == null : this.getIntAdjDt().equals(other.getIntAdjDt()))
            && (this.getIntCd() == null ? other.getIntCd() == null : this.getIntCd().equals(other.getIntCd()))
            && (this.getBasInt() == null ? other.getBasInt() == null : this.getBasInt().equals(other.getBasInt()))
            && (this.getRatDt() == null ? other.getRatDt() == null : this.getRatDt().equals(other.getRatDt()))
            && (this.getFltInt() == null ? other.getFltInt() == null : this.getFltInt().equals(other.getFltInt()))
            && (this.getFltIntVal() == null ? other.getFltIntVal() == null : this.getFltIntVal().equals(other.getFltIntVal()))
            && (this.getActInt() == null ? other.getActInt() == null : this.getActInt().equals(other.getActInt()))
            && (this.getPfltIntOpt() == null ? other.getPfltIntOpt() == null : this.getPfltIntOpt().equals(other.getPfltIntOpt()))
            && (this.getPfltCd() == null ? other.getPfltCd() == null : this.getPfltCd().equals(other.getPfltCd()))
            && (this.getPfltFlt() == null ? other.getPfltFlt() == null : this.getPfltFlt().equals(other.getPfltFlt()))
            && (this.getPfltInt() == null ? other.getPfltInt() == null : this.getPfltInt().equals(other.getPfltInt()))
            && (this.getMispPfltOpt() == null ? other.getMispPfltOpt() == null : this.getMispPfltOpt().equals(other.getMispPfltOpt()))
            && (this.getMispPfltCd() == null ? other.getMispPfltCd() == null : this.getMispPfltCd().equals(other.getMispPfltCd()))
            && (this.getMispPfltFlt() == null ? other.getMispPfltFlt() == null : this.getMispPfltFlt().equals(other.getMispPfltFlt()))
            && (this.getMispPfltInt() == null ? other.getMispPfltInt() == null : this.getMispPfltInt().equals(other.getMispPfltInt()))
            && (this.getIsComint() == null ? other.getIsComint() == null : this.getIsComint().equals(other.getIsComint()))
            && (this.getPayDrct() == null ? other.getPayDrct() == null : this.getPayDrct().equals(other.getPayDrct()))
            && (this.getPayMd() == null ? other.getPayMd() == null : this.getPayMd().equals(other.getPayMd()))
            && (this.getPayCdNo() == null ? other.getPayCdNo() == null : this.getPayCdNo().equals(other.getPayCdNo()))
            && (this.getPayActNo() == null ? other.getPayActNo() == null : this.getPayActNo().equals(other.getPayActNo()))
            && (this.getBailActNo() == null ? other.getBailActNo() == null : this.getBailActNo().equals(other.getBailActNo()))
            && (this.getBailRat() == null ? other.getBailRat() == null : this.getBailRat().equals(other.getBailRat()))
            && (this.getBailAmt() == null ? other.getBailAmt() == null : this.getBailAmt().equals(other.getBailAmt()))
            && (this.getClrCls() == null ? other.getClrCls() == null : this.getClrCls().equals(other.getClrCls()))
            && (this.getClrDt() == null ? other.getClrDt() == null : this.getClrDt().equals(other.getClrDt()))
            && (this.getOvdRatTyp() == null ? other.getOvdRatTyp() == null : this.getOvdRatTyp().equals(other.getOvdRatTyp()))
            && (this.getLongOweDt() == null ? other.getLongOweDt() == null : this.getLongOweDt().equals(other.getLongOweDt()))
            && (this.getOvdDaysStat() == null ? other.getOvdDaysStat() == null : this.getOvdDaysStat().equals(other.getOvdDaysStat()))
            && (this.getTrmCls() == null ? other.getTrmCls() == null : this.getTrmCls().equals(other.getTrmCls()))
            && (this.getMonTrmCls() == null ? other.getMonTrmCls() == null : this.getMonTrmCls().equals(other.getMonTrmCls()))
            && (this.getClsTyp() == null ? other.getClsTyp() == null : this.getClsTyp().equals(other.getClsTyp()))
            && (this.getTrsfDt() == null ? other.getTrsfDt() == null : this.getTrsfDt().equals(other.getTrsfDt()))
            && (this.getTotOvdTms() == null ? other.getTotOvdTms() == null : this.getTotOvdTms().equals(other.getTotOvdTms()))
            && (this.getOvdPer() == null ? other.getOvdPer() == null : this.getOvdPer().equals(other.getOvdPer()))
            && (this.getMaxOvdPer() == null ? other.getMaxOvdPer() == null : this.getMaxOvdPer().equals(other.getMaxOvdPer()))
            && (this.getRtnPers() == null ? other.getRtnPers() == null : this.getRtnPers().equals(other.getRtnPers()))
            && (this.getTotRtnAmt() == null ? other.getTotRtnAmt() == null : this.getTotRtnAmt().equals(other.getTotRtnAmt()))
            && (this.getTotRtnInt() == null ? other.getTotRtnInt() == null : this.getTotRtnInt().equals(other.getTotRtnInt()))
            && (this.getTotRtnCint() == null ? other.getTotRtnCint() == null : this.getTotRtnCint().equals(other.getTotRtnCint()))
            && (this.getTotRtnPint() == null ? other.getTotRtnPint() == null : this.getTotRtnPint().equals(other.getTotRtnPint()))
            && (this.getTotRtnCpint() == null ? other.getTotRtnCpint() == null : this.getTotRtnCpint().equals(other.getTotRtnCpint()))
            && (this.getTotOweCpint() == null ? other.getTotOweCpint() == null : this.getTotOweCpint().equals(other.getTotOweCpint()))
            && (this.getTotOwePint() == null ? other.getTotOwePint() == null : this.getTotOwePint().equals(other.getTotOwePint()))
            && (this.getTotOweCint() == null ? other.getTotOweCint() == null : this.getTotOweCint().equals(other.getTotOweCint()))
            && (this.getTotOweInt() == null ? other.getTotOweInt() == null : this.getTotOweInt().equals(other.getTotOweInt()))
            && (this.getTotOweAmt() == null ? other.getTotOweAmt() == null : this.getTotOweAmt().equals(other.getTotOweAmt()))
            && (this.getExtCnt() == null ? other.getExtCnt() == null : this.getExtCnt().equals(other.getExtCnt()))
            && (this.getDeferCnt() == null ? other.getDeferCnt() == null : this.getDeferCnt().equals(other.getDeferCnt()))
            && (this.getShortenCnt() == null ? other.getShortenCnt() == null : this.getShortenCnt().equals(other.getShortenCnt()))
            && (this.getAddCnt() == null ? other.getAddCnt() == null : this.getAddCnt().equals(other.getAddCnt()))
            && (this.getIsSelfBrno() == null ? other.getIsSelfBrno() == null : this.getIsSelfBrno().equals(other.getIsSelfBrno()))
            && (this.getFeeTyp() == null ? other.getFeeTyp() == null : this.getFeeTyp().equals(other.getFeeTyp()))
            && (this.getFeeAmt() == null ? other.getFeeAmt() == null : this.getFeeAmt().equals(other.getFeeAmt()))
            && (this.getFeeRat() == null ? other.getFeeRat() == null : this.getFeeRat().equals(other.getFeeRat()))
            && (this.getFeePd() == null ? other.getFeePd() == null : this.getFeePd().equals(other.getFeePd()))
            && (this.getRtnNo2() == null ? other.getRtnNo2() == null : this.getRtnNo2().equals(other.getRtnNo2()))
            && (this.getIntFltTyp() == null ? other.getIntFltTyp() == null : this.getIntFltTyp().equals(other.getIntFltTyp()))
            && (this.getPfltIntMd() == null ? other.getPfltIntMd() == null : this.getPfltIntMd().equals(other.getPfltIntMd()))
            && (this.getPfltIntAmt() == null ? other.getPfltIntAmt() == null : this.getPfltIntAmt().equals(other.getPfltIntAmt()))
            && (this.getRefltInt() == null ? other.getRefltInt() == null : this.getRefltInt().equals(other.getRefltInt()))
            && (this.getLplanRtnDt() == null ? other.getLplanRtnDt() == null : this.getLplanRtnDt().equals(other.getLplanRtnDt()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getWrtNo() == null ? other.getWrtNo() == null : this.getWrtNo().equals(other.getWrtNo()))
            && (this.getLnStat() == null ? other.getLnStat() == null : this.getLnStat().equals(other.getLnStat()))
            && (this.getLplanRtnIntDt() == null ? other.getLplanRtnIntDt() == null : this.getLplanRtnIntDt().equals(other.getLplanRtnIntDt()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getTlrNm() == null ? other.getTlrNm() == null : this.getTlrNm().equals(other.getTlrNm()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getBrNm() == null ? other.getBrNm() == null : this.getBrNm().equals(other.getBrNm()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()))
            && (this.getLstUpdTlr() == null ? other.getLstUpdTlr() == null : this.getLstUpdTlr().equals(other.getLstUpdTlr()))
            && (this.getLstUpdTlrNm() == null ? other.getLstUpdTlrNm() == null : this.getLstUpdTlrNm().equals(other.getLstUpdTlrNm()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdBrNm() == null ? other.getLstUpdBrNm() == null : this.getLstUpdBrNm().equals(other.getLstUpdBrNm()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCino() == null) ? 0 : getCino().hashCode());
        result = prime * result + ((getConNo() == null) ? 0 : getConNo().hashCode());
        result = prime * result + ((getLnNo() == null) ? 0 : getLnNo().hashCode());
        result = prime * result + ((getCustCd() == null) ? 0 : getCustCd().hashCode());
        result = prime * result + ((getCustNm() == null) ? 0 : getCustNm().hashCode());
        result = prime * result + ((getActBrCd() == null) ? 0 : getActBrCd().hashCode());
        result = prime * result + ((getPrdId() == null) ? 0 : getPrdId().hashCode());
        result = prime * result + ((getPrdNm() == null) ? 0 : getPrdNm().hashCode());
        result = prime * result + ((getIsDt() == null) ? 0 : getIsDt().hashCode());
        result = prime * result + ((getTeDt() == null) ? 0 : getTeDt().hashCode());
        result = prime * result + ((getTrmCtlTyp() == null) ? 0 : getTrmCtlTyp().hashCode());
        result = prime * result + ((getTrm() == null) ? 0 : getTrm().hashCode());
        result = prime * result + ((getTrmYear() == null) ? 0 : getTrmYear().hashCode());
        result = prime * result + ((getTrmMon() == null) ? 0 : getTrmMon().hashCode());
        result = prime * result + ((getTrmDay() == null) ? 0 : getTrmDay().hashCode());
        result = prime * result + ((getTrmRge() == null) ? 0 : getTrmRge().hashCode());
        result = prime * result + ((getRelaId() == null) ? 0 : getRelaId().hashCode());
        result = prime * result + ((getPerAdjEql() == null) ? 0 : getPerAdjEql().hashCode());
        result = prime * result + ((getLnAmt() == null) ? 0 : getLnAmt().hashCode());
        result = prime * result + ((getRtnTyp() == null) ? 0 : getRtnTyp().hashCode());
        result = prime * result + ((getRtnInvl() == null) ? 0 : getRtnInvl().hashCode());
        result = prime * result + ((getRtnIntInvl() == null) ? 0 : getRtnIntInvl().hashCode());
        result = prime * result + ((getRtnPd() == null) ? 0 : getRtnPd().hashCode());
        result = prime * result + ((getNonEqlMd() == null) ? 0 : getNonEqlMd().hashCode());
        result = prime * result + ((getNonEqlAmt() == null) ? 0 : getNonEqlAmt().hashCode());
        result = prime * result + ((getRtnMd() == null) ? 0 : getRtnMd().hashCode());
        result = prime * result + ((getRtnNo() == null) ? 0 : getRtnNo().hashCode());
        result = prime * result + ((getRtnActNo() == null) ? 0 : getRtnActNo().hashCode());
        result = prime * result + ((getRtnDtTyp() == null) ? 0 : getRtnDtTyp().hashCode());
        result = prime * result + ((getRtnDt() == null) ? 0 : getRtnDt().hashCode());
        result = prime * result + ((getPhsFlg() == null) ? 0 : getPhsFlg().hashCode());
        result = prime * result + ((getPhsNo() == null) ? 0 : getPhsNo().hashCode());
        result = prime * result + ((getIntAdj() == null) ? 0 : getIntAdj().hashCode());
        result = prime * result + ((getIntAdjDt() == null) ? 0 : getIntAdjDt().hashCode());
        result = prime * result + ((getIntCd() == null) ? 0 : getIntCd().hashCode());
        result = prime * result + ((getBasInt() == null) ? 0 : getBasInt().hashCode());
        result = prime * result + ((getRatDt() == null) ? 0 : getRatDt().hashCode());
        result = prime * result + ((getFltInt() == null) ? 0 : getFltInt().hashCode());
        result = prime * result + ((getFltIntVal() == null) ? 0 : getFltIntVal().hashCode());
        result = prime * result + ((getActInt() == null) ? 0 : getActInt().hashCode());
        result = prime * result + ((getPfltIntOpt() == null) ? 0 : getPfltIntOpt().hashCode());
        result = prime * result + ((getPfltCd() == null) ? 0 : getPfltCd().hashCode());
        result = prime * result + ((getPfltFlt() == null) ? 0 : getPfltFlt().hashCode());
        result = prime * result + ((getPfltInt() == null) ? 0 : getPfltInt().hashCode());
        result = prime * result + ((getMispPfltOpt() == null) ? 0 : getMispPfltOpt().hashCode());
        result = prime * result + ((getMispPfltCd() == null) ? 0 : getMispPfltCd().hashCode());
        result = prime * result + ((getMispPfltFlt() == null) ? 0 : getMispPfltFlt().hashCode());
        result = prime * result + ((getMispPfltInt() == null) ? 0 : getMispPfltInt().hashCode());
        result = prime * result + ((getIsComint() == null) ? 0 : getIsComint().hashCode());
        result = prime * result + ((getPayDrct() == null) ? 0 : getPayDrct().hashCode());
        result = prime * result + ((getPayMd() == null) ? 0 : getPayMd().hashCode());
        result = prime * result + ((getPayCdNo() == null) ? 0 : getPayCdNo().hashCode());
        result = prime * result + ((getPayActNo() == null) ? 0 : getPayActNo().hashCode());
        result = prime * result + ((getBailActNo() == null) ? 0 : getBailActNo().hashCode());
        result = prime * result + ((getBailRat() == null) ? 0 : getBailRat().hashCode());
        result = prime * result + ((getBailAmt() == null) ? 0 : getBailAmt().hashCode());
        result = prime * result + ((getClrCls() == null) ? 0 : getClrCls().hashCode());
        result = prime * result + ((getClrDt() == null) ? 0 : getClrDt().hashCode());
        result = prime * result + ((getOvdRatTyp() == null) ? 0 : getOvdRatTyp().hashCode());
        result = prime * result + ((getLongOweDt() == null) ? 0 : getLongOweDt().hashCode());
        result = prime * result + ((getOvdDaysStat() == null) ? 0 : getOvdDaysStat().hashCode());
        result = prime * result + ((getTrmCls() == null) ? 0 : getTrmCls().hashCode());
        result = prime * result + ((getMonTrmCls() == null) ? 0 : getMonTrmCls().hashCode());
        result = prime * result + ((getClsTyp() == null) ? 0 : getClsTyp().hashCode());
        result = prime * result + ((getTrsfDt() == null) ? 0 : getTrsfDt().hashCode());
        result = prime * result + ((getTotOvdTms() == null) ? 0 : getTotOvdTms().hashCode());
        result = prime * result + ((getOvdPer() == null) ? 0 : getOvdPer().hashCode());
        result = prime * result + ((getMaxOvdPer() == null) ? 0 : getMaxOvdPer().hashCode());
        result = prime * result + ((getRtnPers() == null) ? 0 : getRtnPers().hashCode());
        result = prime * result + ((getTotRtnAmt() == null) ? 0 : getTotRtnAmt().hashCode());
        result = prime * result + ((getTotRtnInt() == null) ? 0 : getTotRtnInt().hashCode());
        result = prime * result + ((getTotRtnCint() == null) ? 0 : getTotRtnCint().hashCode());
        result = prime * result + ((getTotRtnPint() == null) ? 0 : getTotRtnPint().hashCode());
        result = prime * result + ((getTotRtnCpint() == null) ? 0 : getTotRtnCpint().hashCode());
        result = prime * result + ((getTotOweCpint() == null) ? 0 : getTotOweCpint().hashCode());
        result = prime * result + ((getTotOwePint() == null) ? 0 : getTotOwePint().hashCode());
        result = prime * result + ((getTotOweCint() == null) ? 0 : getTotOweCint().hashCode());
        result = prime * result + ((getTotOweInt() == null) ? 0 : getTotOweInt().hashCode());
        result = prime * result + ((getTotOweAmt() == null) ? 0 : getTotOweAmt().hashCode());
        result = prime * result + ((getExtCnt() == null) ? 0 : getExtCnt().hashCode());
        result = prime * result + ((getDeferCnt() == null) ? 0 : getDeferCnt().hashCode());
        result = prime * result + ((getShortenCnt() == null) ? 0 : getShortenCnt().hashCode());
        result = prime * result + ((getAddCnt() == null) ? 0 : getAddCnt().hashCode());
        result = prime * result + ((getIsSelfBrno() == null) ? 0 : getIsSelfBrno().hashCode());
        result = prime * result + ((getFeeTyp() == null) ? 0 : getFeeTyp().hashCode());
        result = prime * result + ((getFeeAmt() == null) ? 0 : getFeeAmt().hashCode());
        result = prime * result + ((getFeeRat() == null) ? 0 : getFeeRat().hashCode());
        result = prime * result + ((getFeePd() == null) ? 0 : getFeePd().hashCode());
        result = prime * result + ((getRtnNo2() == null) ? 0 : getRtnNo2().hashCode());
        result = prime * result + ((getIntFltTyp() == null) ? 0 : getIntFltTyp().hashCode());
        result = prime * result + ((getPfltIntMd() == null) ? 0 : getPfltIntMd().hashCode());
        result = prime * result + ((getPfltIntAmt() == null) ? 0 : getPfltIntAmt().hashCode());
        result = prime * result + ((getRefltInt() == null) ? 0 : getRefltInt().hashCode());
        result = prime * result + ((getLplanRtnDt() == null) ? 0 : getLplanRtnDt().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getWrtNo() == null) ? 0 : getWrtNo().hashCode());
        result = prime * result + ((getLnStat() == null) ? 0 : getLnStat().hashCode());
        result = prime * result + ((getLplanRtnIntDt() == null) ? 0 : getLplanRtnIntDt().hashCode());
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
        return result;
    }
}