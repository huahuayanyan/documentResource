package com.huateng.scf.bas.crr.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrLnApp实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月22日上午9:36:54
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月22日上午9:36:54	     新增
 *
 * </pre>
 */
public class BCrrLnApp implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(40) 必填<br>
     * 业务流水号
     */
    private String appId;

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
     * VARCHAR(30) 必填<br>
     * 客户代码
     */
    private String custId;

    /**
     * VARCHAR(60) 必填<br>
     * 客户名称
     */
    private String custNm;

    /**
     * VARCHAR(4)<br>
     * 产品分类
     */
    private String prdCl;

    /**
     * VARCHAR(40)<br>
     * 表单流水号
     */
    private String extId;

    /**
     * VARCHAR(60)<br>
     * 表单类型
     */
    private String extTyp;

    /**
     * CHAR(1)<br>
     * 发生类型
     */
    private String lnTyp;

    /**
     * CHAR(2)<br>
     * 贷款性质
     */
    private String lnNat;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(15,3)<br>
     * 汇率
     */
    private BigDecimal exchgRt;

    /**
     * DECIMAL(16,2)<br>
     * 金额
     */
    private BigDecimal lnAmt;

    /**
     * VARCHAR(10)<br>
     * 贷款起始日
     */
    private String lnStrtDt;

    /**
     * VARCHAR(10)<br>
     * 贷款到期日
     */
    private String lnEndDt;

    /**
     * CHAR(3)<br>
     * 期限时间类型
     */
    private String trmTyp;

    /**
     * VARCHAR(20)<br>
     * 期限
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
     * DECIMAL(16,9)<br>
     * 基准利率(年)
     */
    private BigDecimal basInt;

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
     * 还息周期
     */
    private String rtnIntInvl;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 固定周期
     */
    private BigDecimal rtnPd;

    /**
     * VARCHAR(10)<br>
     * 宽限方式
     */
    private String dogTyp;

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 宽限期天数
     */
    private BigDecimal dog;

    /**
     * CHAR(2)<br>
     * 主要担保方式
     */
    private String guatTypMain;

    /**
     * VARCHAR(5)<br>
     * 有无其他担保方式
     */
    private String guatTypOth;

    /**
     * VARCHAR(4)<br>
     * 贷款投向
     */
    private String lnDir;

    /**
     * VARCHAR(200)<br>
     * 投向名称
     */
    private String dirNm;

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
     * 手续费收取方式
     */
    private String feeTyp;

    /**
     * VARCHAR(5)<br>
     * 手续费收取周期
     */
    private String feePd;

    /**
     * VARCHAR(200)<br>
     * 还款来源
     */
    private String rtnSrc;

    /**
     * CHAR(1)<br>
     * 业务风险类别
     */
    private String riskCls;

    /**
     * VARCHAR(1000)<br>
     * 调查人结论
     */
    private String invstConcl;

    /**
     * CHAR(1)<br>
     * 占用额度模式
     */
    private String crMdl;

    /**
     * DECIMAL(16,2)<br>
     * 使用额度金额
     */
    private BigDecimal crAmt;

    /**
     * VARCHAR(32)<br>
     * 额度编号
     */
    private String crNo;

    /**
     * VARCHAR(32)<br>
     * 授信额度协议编号
     */
    private String bcCrId;

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
     * VARCHAR(10)<br>
     * 利率固定期标志
     */
    private String fixFlg;

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 浮动利率值
     */
    private BigDecimal fltIntVal;

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 浮动利率
     */
    private BigDecimal fltIntRt;

    /**
     * VARCHAR(10)<br>
     * 利率固定值
     */
    private String fixTrm;

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 固定期利率
     */
    private BigDecimal fixInt;

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 执行利率
     */
    private BigDecimal actInt;

    /**
     * VARCHAR(10)<br>
     * 罚息发动选项
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
     * 罚息浮动选项
     */
    private String pfltFltOpt;

    /**
     * CHAR(1)<br>
     * 单复利标志
     */
    private String isComint;

    /**
     * VARCHAR(10)<br>
     * 申请日期
     */
    private String appDt;

    /**
     * VARCHAR(10)<br>
     * 利率浮动方式
     */
    private String intFltTyp;

    /**
     * VARCHAR(20)<br>
     * 账务机构
     */
    private String actBrCd;

    /**
     * VARCHAR(4)<br>
     * 申请状态
     */
    private String appStat;

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
     * VARCHAR(32)<br>
     * 登记机构
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
     * VARCHAR(32)<br>
     * 更新人
     */
    private String lstUpdTlr;

    /**
     * VARCHAR(60)<br>
     * 更新人名称
     */
    private String lstUpdTlrNm;

    /**
     * VARCHAR(32)<br>
     * 更新机构
     */
    private String lstUpdBrCd;

    /**
     * VARCHAR(60)<br>
     * 更新机构名称
     */
    private String lstUpdBrNm;

    /**
     * VARCHAR(20)<br>
     * 更新日期
     */
    private String lstUpdDt;

    /**
     * VARCHAR(40) 必填<br>
     * 获得 业务流水号
     */
    public String getAppId() {
        return appId;
    }

    /**
     * VARCHAR(40) 必填<br>
     * 设置 业务流水号
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
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
     * VARCHAR(30) 必填<br>
     * 获得 客户代码
     */
    public String getCustId() {
        return custId;
    }

    /**
     * VARCHAR(30) 必填<br>
     * 设置 客户代码
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
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
     * VARCHAR(4)<br>
     * 获得 产品分类
     */
    public String getPrdCl() {
        return prdCl;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 产品分类
     */
    public void setPrdCl(String prdCl) {
        this.prdCl = prdCl == null ? null : prdCl.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 表单流水号
     */
    public String getExtId() {
        return extId;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 表单流水号
     */
    public void setExtId(String extId) {
        this.extId = extId == null ? null : extId.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 表单类型
     */
    public String getExtTyp() {
        return extTyp;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 表单类型
     */
    public void setExtTyp(String extTyp) {
        this.extTyp = extTyp == null ? null : extTyp.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 发生类型
     */
    public String getLnTyp() {
        return lnTyp;
    }

    /**
     * CHAR(1)<br>
     * 设置 发生类型
     */
    public void setLnTyp(String lnTyp) {
        this.lnTyp = lnTyp == null ? null : lnTyp.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 贷款性质
     */
    public String getLnNat() {
        return lnNat;
    }

    /**
     * CHAR(2)<br>
     * 设置 贷款性质
     */
    public void setLnNat(String lnNat) {
        this.lnNat = lnNat == null ? null : lnNat.trim();
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
     * DECIMAL(15,3)<br>
     * 获得 汇率
     */
    public BigDecimal getExchgRt() {
        return exchgRt;
    }

    /**
     * DECIMAL(15,3)<br>
     * 设置 汇率
     */
    public void setExchgRt(BigDecimal exchgRt) {
        this.exchgRt = exchgRt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 金额
     */
    public BigDecimal getLnAmt() {
        return lnAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 金额
     */
    public void setLnAmt(BigDecimal lnAmt) {
        this.lnAmt = lnAmt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 贷款起始日
     */
    public String getLnStrtDt() {
        return lnStrtDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 贷款起始日
     */
    public void setLnStrtDt(String lnStrtDt) {
        this.lnStrtDt = lnStrtDt == null ? null : lnStrtDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 贷款到期日
     */
    public String getLnEndDt() {
        return lnEndDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 贷款到期日
     */
    public void setLnEndDt(String lnEndDt) {
        this.lnEndDt = lnEndDt == null ? null : lnEndDt.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 期限时间类型
     */
    public String getTrmTyp() {
        return trmTyp;
    }

    /**
     * CHAR(3)<br>
     * 设置 期限时间类型
     */
    public void setTrmTyp(String trmTyp) {
        this.trmTyp = trmTyp == null ? null : trmTyp.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 期限
     */
    public String getTrm() {
        return trm;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 期限
     */
    public void setTrm(String trm) {
        this.trm = trm == null ? null : trm.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 期限年
     */
    public BigDecimal getTrmYear() {
        return trmYear;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 期限年
     */
    public void setTrmYear(BigDecimal trmYear) {
        this.trmYear = trmYear;
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
     * DECIMAL(16,9)<br>
     * 获得 基准利率(年)
     */
    public BigDecimal getBasInt() {
        return basInt;
    }

    /**
     * DECIMAL(16,9)<br>
     * 设置 基准利率(年)
     */
    public void setBasInt(BigDecimal basInt) {
        this.basInt = basInt;
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
     * 获得 还息周期
     */
    public String getRtnIntInvl() {
        return rtnIntInvl;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 还息周期
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
     * 获得 宽限方式
     */
    public String getDogTyp() {
        return dogTyp;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 宽限方式
     */
    public void setDogTyp(String dogTyp) {
        this.dogTyp = dogTyp == null ? null : dogTyp.trim();
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 获得 宽限期天数
     */
    public BigDecimal getDog() {
        return dog;
    }

    /**
     * DECIMAL(22) 默认值[0]<br>
     * 设置 宽限期天数
     */
    public void setDog(BigDecimal dog) {
        this.dog = dog;
    }

    /**
     * CHAR(2)<br>
     * 获得 主要担保方式
     */
    public String getGuatTypMain() {
        return guatTypMain;
    }

    /**
     * CHAR(2)<br>
     * 设置 主要担保方式
     */
    public void setGuatTypMain(String guatTypMain) {
        this.guatTypMain = guatTypMain == null ? null : guatTypMain.trim();
    }

    /**
     * VARCHAR(5)<br>
     * 获得 有无其他担保方式
     */
    public String getGuatTypOth() {
        return guatTypOth;
    }

    /**
     * VARCHAR(5)<br>
     * 设置 有无其他担保方式
     */
    public void setGuatTypOth(String guatTypOth) {
        this.guatTypOth = guatTypOth == null ? null : guatTypOth.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 贷款投向
     */
    public String getLnDir() {
        return lnDir;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 贷款投向
     */
    public void setLnDir(String lnDir) {
        this.lnDir = lnDir == null ? null : lnDir.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 投向名称
     */
    public String getDirNm() {
        return dirNm;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 投向名称
     */
    public void setDirNm(String dirNm) {
        this.dirNm = dirNm == null ? null : dirNm.trim();
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
     * 获得 手续费收取方式
     */
    public String getFeeTyp() {
        return feeTyp;
    }

    /**
     * VARCHAR(5)<br>
     * 设置 手续费收取方式
     */
    public void setFeeTyp(String feeTyp) {
        this.feeTyp = feeTyp == null ? null : feeTyp.trim();
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
     * VARCHAR(200)<br>
     * 获得 还款来源
     */
    public String getRtnSrc() {
        return rtnSrc;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 还款来源
     */
    public void setRtnSrc(String rtnSrc) {
        this.rtnSrc = rtnSrc == null ? null : rtnSrc.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 业务风险类别
     */
    public String getRiskCls() {
        return riskCls;
    }

    /**
     * CHAR(1)<br>
     * 设置 业务风险类别
     */
    public void setRiskCls(String riskCls) {
        this.riskCls = riskCls == null ? null : riskCls.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 调查人结论
     */
    public String getInvstConcl() {
        return invstConcl;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 调查人结论
     */
    public void setInvstConcl(String invstConcl) {
        this.invstConcl = invstConcl == null ? null : invstConcl.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 占用额度模式
     */
    public String getCrMdl() {
        return crMdl;
    }

    /**
     * CHAR(1)<br>
     * 设置 占用额度模式
     */
    public void setCrMdl(String crMdl) {
        this.crMdl = crMdl == null ? null : crMdl.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 使用额度金额
     */
    public BigDecimal getCrAmt() {
        return crAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 使用额度金额
     */
    public void setCrAmt(BigDecimal crAmt) {
        this.crAmt = crAmt;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 额度编号
     */
    public String getCrNo() {
        return crNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 额度编号
     */
    public void setCrNo(String crNo) {
        this.crNo = crNo == null ? null : crNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 授信额度协议编号
     */
    public String getBcCrId() {
        return bcCrId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 授信额度协议编号
     */
    public void setBcCrId(String bcCrId) {
        this.bcCrId = bcCrId == null ? null : bcCrId.trim();
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
     * VARCHAR(10)<br>
     * 获得 利率固定期标志
     */
    public String getFixFlg() {
        return fixFlg;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率固定期标志
     */
    public void setFixFlg(String fixFlg) {
        this.fixFlg = fixFlg == null ? null : fixFlg.trim();
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 获得 浮动利率值
     */
    public BigDecimal getFltIntVal() {
        return fltIntVal;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 设置 浮动利率值
     */
    public void setFltIntVal(BigDecimal fltIntVal) {
        this.fltIntVal = fltIntVal;
    }

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 获得 浮动利率
     */
    public BigDecimal getFltIntRt() {
        return fltIntRt;
    }

    /**
     * DECIMAL(7,4) 默认值[0]<br>
     * 设置 浮动利率
     */
    public void setFltIntRt(BigDecimal fltIntRt) {
        this.fltIntRt = fltIntRt;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 利率固定值
     */
    public String getFixTrm() {
        return fixTrm;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 利率固定值
     */
    public void setFixTrm(String fixTrm) {
        this.fixTrm = fixTrm == null ? null : fixTrm.trim();
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 获得 固定期利率
     */
    public BigDecimal getFixInt() {
        return fixInt;
    }

    /**
     * DECIMAL(8,6) 默认值[0]<br>
     * 设置 固定期利率
     */
    public void setFixInt(BigDecimal fixInt) {
        this.fixInt = fixInt;
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
     * 获得 罚息发动选项
     */
    public String getPfltIntOpt() {
        return pfltIntOpt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 罚息发动选项
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
     * 获得 罚息浮动选项
     */
    public String getPfltFltOpt() {
        return pfltFltOpt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 罚息浮动选项
     */
    public void setPfltFltOpt(String pfltFltOpt) {
        this.pfltFltOpt = pfltFltOpt == null ? null : pfltFltOpt.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 单复利标志
     */
    public String getIsComint() {
        return isComint;
    }

    /**
     * CHAR(1)<br>
     * 设置 单复利标志
     */
    public void setIsComint(String isComint) {
        this.isComint = isComint == null ? null : isComint.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 申请日期
     */
    public String getAppDt() {
        return appDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 申请日期
     */
    public void setAppDt(String appDt) {
        this.appDt = appDt == null ? null : appDt.trim();
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
     * VARCHAR(4)<br>
     * 获得 申请状态
     */
    public String getAppStat() {
        return appStat;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 申请状态
     */
    public void setAppStat(String appStat) {
        this.appStat = appStat == null ? null : appStat.trim();
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
     * VARCHAR(32)<br>
     * 获得 登记机构
     */
    public String getBrCd() {
        return brCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记机构
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
     * VARCHAR(32)<br>
     * 获得 更新人
     */
    public String getLstUpdTlr() {
        return lstUpdTlr;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新人
     */
    public void setLstUpdTlr(String lstUpdTlr) {
        this.lstUpdTlr = lstUpdTlr == null ? null : lstUpdTlr.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 更新人名称
     */
    public String getLstUpdTlrNm() {
        return lstUpdTlrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 更新人名称
     */
    public void setLstUpdTlrNm(String lstUpdTlrNm) {
        this.lstUpdTlrNm = lstUpdTlrNm == null ? null : lstUpdTlrNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新机构
     */
    public String getLstUpdBrCd() {
        return lstUpdBrCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新机构
     */
    public void setLstUpdBrCd(String lstUpdBrCd) {
        this.lstUpdBrCd = lstUpdBrCd == null ? null : lstUpdBrCd.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 更新机构名称
     */
    public String getLstUpdBrNm() {
        return lstUpdBrNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 更新机构名称
     */
    public void setLstUpdBrNm(String lstUpdBrNm) {
        this.lstUpdBrNm = lstUpdBrNm == null ? null : lstUpdBrNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 更新日期
     */
    public String getLstUpdDt() {
        return lstUpdDt;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 更新日期
     */
    public void setLstUpdDt(String lstUpdDt) {
        this.lstUpdDt = lstUpdDt == null ? null : lstUpdDt.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appId=").append(appId);
        sb.append(", prdId=").append(prdId);
        sb.append(", prdNm=").append(prdNm);
        sb.append(", custId=").append(custId);
        sb.append(", custNm=").append(custNm);
        sb.append(", prdCl=").append(prdCl);
        sb.append(", extId=").append(extId);
        sb.append(", extTyp=").append(extTyp);
        sb.append(", lnTyp=").append(lnTyp);
        sb.append(", lnNat=").append(lnNat);
        sb.append(", curcd=").append(curcd);
        sb.append(", exchgRt=").append(exchgRt);
        sb.append(", lnAmt=").append(lnAmt);
        sb.append(", lnStrtDt=").append(lnStrtDt);
        sb.append(", lnEndDt=").append(lnEndDt);
        sb.append(", trmTyp=").append(trmTyp);
        sb.append(", trm=").append(trm);
        sb.append(", trmYear=").append(trmYear);
        sb.append(", trmMon=").append(trmMon);
        sb.append(", trmDay=").append(trmDay);
        sb.append(", basInt=").append(basInt);
        sb.append(", rtnTyp=").append(rtnTyp);
        sb.append(", rtnInvl=").append(rtnInvl);
        sb.append(", rtnIntInvl=").append(rtnIntInvl);
        sb.append(", rtnPd=").append(rtnPd);
        sb.append(", dogTyp=").append(dogTyp);
        sb.append(", dog=").append(dog);
        sb.append(", guatTypMain=").append(guatTypMain);
        sb.append(", guatTypOth=").append(guatTypOth);
        sb.append(", lnDir=").append(lnDir);
        sb.append(", dirNm=").append(dirNm);
        sb.append(", feeAmt=").append(feeAmt);
        sb.append(", feeRat=").append(feeRat);
        sb.append(", feeTyp=").append(feeTyp);
        sb.append(", feePd=").append(feePd);
        sb.append(", rtnSrc=").append(rtnSrc);
        sb.append(", riskCls=").append(riskCls);
        sb.append(", invstConcl=").append(invstConcl);
        sb.append(", crMdl=").append(crMdl);
        sb.append(", crAmt=").append(crAmt);
        sb.append(", crNo=").append(crNo);
        sb.append(", bcCrId=").append(bcCrId);
        sb.append(", rtnDtTyp=").append(rtnDtTyp);
        sb.append(", rtnDt=").append(rtnDt);
        sb.append(", intAdj=").append(intAdj);
        sb.append(", intAdjDt=").append(intAdjDt);
        sb.append(", intCd=").append(intCd);
        sb.append(", fixFlg=").append(fixFlg);
        sb.append(", fltIntVal=").append(fltIntVal);
        sb.append(", fltIntRt=").append(fltIntRt);
        sb.append(", fixTrm=").append(fixTrm);
        sb.append(", fixInt=").append(fixInt);
        sb.append(", actInt=").append(actInt);
        sb.append(", pfltIntOpt=").append(pfltIntOpt);
        sb.append(", pfltCd=").append(pfltCd);
        sb.append(", pfltFlt=").append(pfltFlt);
        sb.append(", pfltInt=").append(pfltInt);
        sb.append(", pfltFltOpt=").append(pfltFltOpt);
        sb.append(", isComint=").append(isComint);
        sb.append(", appDt=").append(appDt);
        sb.append(", intFltTyp=").append(intFltTyp);
        sb.append(", actBrCd=").append(actBrCd);
        sb.append(", appStat=").append(appStat);
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
        BCrrLnApp other = (BCrrLnApp) that;
        return (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getPrdId() == null ? other.getPrdId() == null : this.getPrdId().equals(other.getPrdId()))
            && (this.getPrdNm() == null ? other.getPrdNm() == null : this.getPrdNm().equals(other.getPrdNm()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getCustNm() == null ? other.getCustNm() == null : this.getCustNm().equals(other.getCustNm()))
            && (this.getPrdCl() == null ? other.getPrdCl() == null : this.getPrdCl().equals(other.getPrdCl()))
            && (this.getExtId() == null ? other.getExtId() == null : this.getExtId().equals(other.getExtId()))
            && (this.getExtTyp() == null ? other.getExtTyp() == null : this.getExtTyp().equals(other.getExtTyp()))
            && (this.getLnTyp() == null ? other.getLnTyp() == null : this.getLnTyp().equals(other.getLnTyp()))
            && (this.getLnNat() == null ? other.getLnNat() == null : this.getLnNat().equals(other.getLnNat()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getExchgRt() == null ? other.getExchgRt() == null : this.getExchgRt().equals(other.getExchgRt()))
            && (this.getLnAmt() == null ? other.getLnAmt() == null : this.getLnAmt().equals(other.getLnAmt()))
            && (this.getLnStrtDt() == null ? other.getLnStrtDt() == null : this.getLnStrtDt().equals(other.getLnStrtDt()))
            && (this.getLnEndDt() == null ? other.getLnEndDt() == null : this.getLnEndDt().equals(other.getLnEndDt()))
            && (this.getTrmTyp() == null ? other.getTrmTyp() == null : this.getTrmTyp().equals(other.getTrmTyp()))
            && (this.getTrm() == null ? other.getTrm() == null : this.getTrm().equals(other.getTrm()))
            && (this.getTrmYear() == null ? other.getTrmYear() == null : this.getTrmYear().equals(other.getTrmYear()))
            && (this.getTrmMon() == null ? other.getTrmMon() == null : this.getTrmMon().equals(other.getTrmMon()))
            && (this.getTrmDay() == null ? other.getTrmDay() == null : this.getTrmDay().equals(other.getTrmDay()))
            && (this.getBasInt() == null ? other.getBasInt() == null : this.getBasInt().equals(other.getBasInt()))
            && (this.getRtnTyp() == null ? other.getRtnTyp() == null : this.getRtnTyp().equals(other.getRtnTyp()))
            && (this.getRtnInvl() == null ? other.getRtnInvl() == null : this.getRtnInvl().equals(other.getRtnInvl()))
            && (this.getRtnIntInvl() == null ? other.getRtnIntInvl() == null : this.getRtnIntInvl().equals(other.getRtnIntInvl()))
            && (this.getRtnPd() == null ? other.getRtnPd() == null : this.getRtnPd().equals(other.getRtnPd()))
            && (this.getDogTyp() == null ? other.getDogTyp() == null : this.getDogTyp().equals(other.getDogTyp()))
            && (this.getDog() == null ? other.getDog() == null : this.getDog().equals(other.getDog()))
            && (this.getGuatTypMain() == null ? other.getGuatTypMain() == null : this.getGuatTypMain().equals(other.getGuatTypMain()))
            && (this.getGuatTypOth() == null ? other.getGuatTypOth() == null : this.getGuatTypOth().equals(other.getGuatTypOth()))
            && (this.getLnDir() == null ? other.getLnDir() == null : this.getLnDir().equals(other.getLnDir()))
            && (this.getDirNm() == null ? other.getDirNm() == null : this.getDirNm().equals(other.getDirNm()))
            && (this.getFeeAmt() == null ? other.getFeeAmt() == null : this.getFeeAmt().equals(other.getFeeAmt()))
            && (this.getFeeRat() == null ? other.getFeeRat() == null : this.getFeeRat().equals(other.getFeeRat()))
            && (this.getFeeTyp() == null ? other.getFeeTyp() == null : this.getFeeTyp().equals(other.getFeeTyp()))
            && (this.getFeePd() == null ? other.getFeePd() == null : this.getFeePd().equals(other.getFeePd()))
            && (this.getRtnSrc() == null ? other.getRtnSrc() == null : this.getRtnSrc().equals(other.getRtnSrc()))
            && (this.getRiskCls() == null ? other.getRiskCls() == null : this.getRiskCls().equals(other.getRiskCls()))
            && (this.getInvstConcl() == null ? other.getInvstConcl() == null : this.getInvstConcl().equals(other.getInvstConcl()))
            && (this.getCrMdl() == null ? other.getCrMdl() == null : this.getCrMdl().equals(other.getCrMdl()))
            && (this.getCrAmt() == null ? other.getCrAmt() == null : this.getCrAmt().equals(other.getCrAmt()))
            && (this.getCrNo() == null ? other.getCrNo() == null : this.getCrNo().equals(other.getCrNo()))
            && (this.getBcCrId() == null ? other.getBcCrId() == null : this.getBcCrId().equals(other.getBcCrId()))
            && (this.getRtnDtTyp() == null ? other.getRtnDtTyp() == null : this.getRtnDtTyp().equals(other.getRtnDtTyp()))
            && (this.getRtnDt() == null ? other.getRtnDt() == null : this.getRtnDt().equals(other.getRtnDt()))
            && (this.getIntAdj() == null ? other.getIntAdj() == null : this.getIntAdj().equals(other.getIntAdj()))
            && (this.getIntAdjDt() == null ? other.getIntAdjDt() == null : this.getIntAdjDt().equals(other.getIntAdjDt()))
            && (this.getIntCd() == null ? other.getIntCd() == null : this.getIntCd().equals(other.getIntCd()))
            && (this.getFixFlg() == null ? other.getFixFlg() == null : this.getFixFlg().equals(other.getFixFlg()))
            && (this.getFltIntVal() == null ? other.getFltIntVal() == null : this.getFltIntVal().equals(other.getFltIntVal()))
            && (this.getFltIntRt() == null ? other.getFltIntRt() == null : this.getFltIntRt().equals(other.getFltIntRt()))
            && (this.getFixTrm() == null ? other.getFixTrm() == null : this.getFixTrm().equals(other.getFixTrm()))
            && (this.getFixInt() == null ? other.getFixInt() == null : this.getFixInt().equals(other.getFixInt()))
            && (this.getActInt() == null ? other.getActInt() == null : this.getActInt().equals(other.getActInt()))
            && (this.getPfltIntOpt() == null ? other.getPfltIntOpt() == null : this.getPfltIntOpt().equals(other.getPfltIntOpt()))
            && (this.getPfltCd() == null ? other.getPfltCd() == null : this.getPfltCd().equals(other.getPfltCd()))
            && (this.getPfltFlt() == null ? other.getPfltFlt() == null : this.getPfltFlt().equals(other.getPfltFlt()))
            && (this.getPfltInt() == null ? other.getPfltInt() == null : this.getPfltInt().equals(other.getPfltInt()))
            && (this.getPfltFltOpt() == null ? other.getPfltFltOpt() == null : this.getPfltFltOpt().equals(other.getPfltFltOpt()))
            && (this.getIsComint() == null ? other.getIsComint() == null : this.getIsComint().equals(other.getIsComint()))
            && (this.getAppDt() == null ? other.getAppDt() == null : this.getAppDt().equals(other.getAppDt()))
            && (this.getIntFltTyp() == null ? other.getIntFltTyp() == null : this.getIntFltTyp().equals(other.getIntFltTyp()))
            && (this.getActBrCd() == null ? other.getActBrCd() == null : this.getActBrCd().equals(other.getActBrCd()))
            && (this.getAppStat() == null ? other.getAppStat() == null : this.getAppStat().equals(other.getAppStat()))
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
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getPrdId() == null) ? 0 : getPrdId().hashCode());
        result = prime * result + ((getPrdNm() == null) ? 0 : getPrdNm().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustNm() == null) ? 0 : getCustNm().hashCode());
        result = prime * result + ((getPrdCl() == null) ? 0 : getPrdCl().hashCode());
        result = prime * result + ((getExtId() == null) ? 0 : getExtId().hashCode());
        result = prime * result + ((getExtTyp() == null) ? 0 : getExtTyp().hashCode());
        result = prime * result + ((getLnTyp() == null) ? 0 : getLnTyp().hashCode());
        result = prime * result + ((getLnNat() == null) ? 0 : getLnNat().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getExchgRt() == null) ? 0 : getExchgRt().hashCode());
        result = prime * result + ((getLnAmt() == null) ? 0 : getLnAmt().hashCode());
        result = prime * result + ((getLnStrtDt() == null) ? 0 : getLnStrtDt().hashCode());
        result = prime * result + ((getLnEndDt() == null) ? 0 : getLnEndDt().hashCode());
        result = prime * result + ((getTrmTyp() == null) ? 0 : getTrmTyp().hashCode());
        result = prime * result + ((getTrm() == null) ? 0 : getTrm().hashCode());
        result = prime * result + ((getTrmYear() == null) ? 0 : getTrmYear().hashCode());
        result = prime * result + ((getTrmMon() == null) ? 0 : getTrmMon().hashCode());
        result = prime * result + ((getTrmDay() == null) ? 0 : getTrmDay().hashCode());
        result = prime * result + ((getBasInt() == null) ? 0 : getBasInt().hashCode());
        result = prime * result + ((getRtnTyp() == null) ? 0 : getRtnTyp().hashCode());
        result = prime * result + ((getRtnInvl() == null) ? 0 : getRtnInvl().hashCode());
        result = prime * result + ((getRtnIntInvl() == null) ? 0 : getRtnIntInvl().hashCode());
        result = prime * result + ((getRtnPd() == null) ? 0 : getRtnPd().hashCode());
        result = prime * result + ((getDogTyp() == null) ? 0 : getDogTyp().hashCode());
        result = prime * result + ((getDog() == null) ? 0 : getDog().hashCode());
        result = prime * result + ((getGuatTypMain() == null) ? 0 : getGuatTypMain().hashCode());
        result = prime * result + ((getGuatTypOth() == null) ? 0 : getGuatTypOth().hashCode());
        result = prime * result + ((getLnDir() == null) ? 0 : getLnDir().hashCode());
        result = prime * result + ((getDirNm() == null) ? 0 : getDirNm().hashCode());
        result = prime * result + ((getFeeAmt() == null) ? 0 : getFeeAmt().hashCode());
        result = prime * result + ((getFeeRat() == null) ? 0 : getFeeRat().hashCode());
        result = prime * result + ((getFeeTyp() == null) ? 0 : getFeeTyp().hashCode());
        result = prime * result + ((getFeePd() == null) ? 0 : getFeePd().hashCode());
        result = prime * result + ((getRtnSrc() == null) ? 0 : getRtnSrc().hashCode());
        result = prime * result + ((getRiskCls() == null) ? 0 : getRiskCls().hashCode());
        result = prime * result + ((getInvstConcl() == null) ? 0 : getInvstConcl().hashCode());
        result = prime * result + ((getCrMdl() == null) ? 0 : getCrMdl().hashCode());
        result = prime * result + ((getCrAmt() == null) ? 0 : getCrAmt().hashCode());
        result = prime * result + ((getCrNo() == null) ? 0 : getCrNo().hashCode());
        result = prime * result + ((getBcCrId() == null) ? 0 : getBcCrId().hashCode());
        result = prime * result + ((getRtnDtTyp() == null) ? 0 : getRtnDtTyp().hashCode());
        result = prime * result + ((getRtnDt() == null) ? 0 : getRtnDt().hashCode());
        result = prime * result + ((getIntAdj() == null) ? 0 : getIntAdj().hashCode());
        result = prime * result + ((getIntAdjDt() == null) ? 0 : getIntAdjDt().hashCode());
        result = prime * result + ((getIntCd() == null) ? 0 : getIntCd().hashCode());
        result = prime * result + ((getFixFlg() == null) ? 0 : getFixFlg().hashCode());
        result = prime * result + ((getFltIntVal() == null) ? 0 : getFltIntVal().hashCode());
        result = prime * result + ((getFltIntRt() == null) ? 0 : getFltIntRt().hashCode());
        result = prime * result + ((getFixTrm() == null) ? 0 : getFixTrm().hashCode());
        result = prime * result + ((getFixInt() == null) ? 0 : getFixInt().hashCode());
        result = prime * result + ((getActInt() == null) ? 0 : getActInt().hashCode());
        result = prime * result + ((getPfltIntOpt() == null) ? 0 : getPfltIntOpt().hashCode());
        result = prime * result + ((getPfltCd() == null) ? 0 : getPfltCd().hashCode());
        result = prime * result + ((getPfltFlt() == null) ? 0 : getPfltFlt().hashCode());
        result = prime * result + ((getPfltInt() == null) ? 0 : getPfltInt().hashCode());
        result = prime * result + ((getPfltFltOpt() == null) ? 0 : getPfltFltOpt().hashCode());
        result = prime * result + ((getIsComint() == null) ? 0 : getIsComint().hashCode());
        result = prime * result + ((getAppDt() == null) ? 0 : getAppDt().hashCode());
        result = prime * result + ((getIntFltTyp() == null) ? 0 : getIntFltTyp().hashCode());
        result = prime * result + ((getActBrCd() == null) ? 0 : getActBrCd().hashCode());
        result = prime * result + ((getAppStat() == null) ? 0 : getAppStat().hashCode());
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