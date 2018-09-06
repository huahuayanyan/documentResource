package com.huateng.scf.bas.crr.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BCrrBillInfo实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午5:42:36
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午5:42:36	     新增
 *
 * </pre>
 */
public class BCrrBillInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    private String billId;

    /**
     * VARCHAR(32) 必填<br>
     * 表单流水号
     */
    private String extId;

    /**
     * VARCHAR(32)<br>
     * 关联类型
     */
    private String relaTyp;

    /**
     * VARCHAR(18)<br>
     * 关联编号
     */
    private String relaNo;

    /**
     * VARCHAR(32)<br>
     * 票据编号
     */
    private String billNo;

    /**
     * VARCHAR(18)<br>
     * 票据类型
     */
    private String billTyp;

    /**
     * VARCHAR(18)<br>
     * 票据状态
     */
    private String billStat;

    /**
     * VARCHAR(500)<br>
     * 用途
     */
    private String prps;

    /**
     * VARCHAR(32)<br>
     * 出票人代码
     */
    private String wrtId;

    /**
     * VARCHAR(80)<br>
     * 出票人
     */
    private String wrtNm;

    /**
     * VARCHAR(32)<br>
     * 持票人代码
     */
    private String hldId;

    /**
     * VARCHAR(80)<br>
     * 持票人
     */
    private String hldNm;

    /**
     * VARCHAR(32)<br>
     * 受益人代码
     */
    private String bnfcyId;

    /**
     * VARCHAR(80)<br>
     * 受益人
     */
    private String bnfcyNm;

    /**
     * DECIMAL(24,6)<br>
     * 背书次数
     */
    private BigDecimal endOrseTim;

    /**
     * VARCHAR(80)<br>
     * 上次背书人
     */
    private String lsTbfcy;

    /**
     * VARCHAR(32)<br>
     * 承兑人代码
     */
    private String acptId;

    /**
     * VARCHAR(80)<br>
     * 承兑人
     */
    private String acptNm;

    /**
     * VARCHAR(80)<br>
     * 承兑人级别
     */
    private String acptLev;

    /**
     * VARCHAR(18)<br>
     * 承兑人所在行政区域
     */
    private String acptReg;

    /**
     * VARCHAR(80)<br>
     * 期限
     */
    private String trm;

    /**
     * VARCHAR(10)<br>
     * 出票日期
     */
    private String wrtDt;

    /**
     * VARCHAR(10)<br>
     * 到期日
     */
    private String mtrDt;

    /**
     * VARCHAR(18)<br>
     * 币种
     */
    private String billCurcd;

    /**
     * DECIMAL(22)<br>
     * 票据数量
     */
    private BigDecimal billCut;

    /**
     * DECIMAL(24,6)<br>
     * 票面金额
     */
    private BigDecimal billSum;

    /**
     * VARCHAR(10)<br>
     * 完成日期
     */
    private String finDt;

    /**
     * DECIMAL(24,6)<br>
     * 实付金额
     */
    private BigDecimal actSum;

    /**
     * DECIMAL(24,6)<br>
     * 实收利息
     */
    private BigDecimal actInt;

    /**
     * DECIMAL(10,6)<br>
     * 贴现利率
     */
    private BigDecimal rate;

    /**
     * VARCHAR(18)<br>
     * 贴现付息方式
     */
    private String intTyp;

    /**
     * DECIMAL(10,6)<br>
     * 协议付息所占比例
     */
    private BigDecimal scale;

    /**
     * VARCHAR(80)<br>
     * 收款人户名
     */
    private String gatrNm;

    /**
     * VARCHAR(32)<br>
     * 收款人帐号
     */
    private String actNo;

    /**
     * VARCHAR(80)<br>
     * 收款行行名
     */
    private String abtBakNm;

    /**
     * VARCHAR(32)<br>
     * 承兑汇票组内序号
     */
    private String intSialno;

    /**
     * VARCHAR(32)<br>
     * 收款行行号
     */
    private String abtBakId;

    /**
     * VARCHAR(32)<br>
     * 相关出帐号
     */
    private String relaPotNo;

    /**
     * VARCHAR(1)<br>
     * 发送标志
     */
    private String sendFlg;

    /**
     * VARCHAR(10)<br>
     * 查复日期
     */
    private String chkRpyDt;

    /**
     * VARCHAR(32)<br>
     * 票据存放机构
     */
    private String kepBillBrCd;

    /**
     * VARCHAR(32)<br>
     * 贸易背景合同编号
     */
    private String tradConNo;

    /**
     * VARCHAR(60)<br>
     * 贸易背景合同名称
     */
    private String tradConNm;

    /**
     * DECIMAL(24,2)<br>
     * 贸易背景合同金额
     */
    private BigDecimal tradConAmt;

    /**
     * VARCHAR(4)<br>
     * 对应合同收款人是承兑汇票收款人
     */
    private String flg1;

    /**
     * VARCHAR(4)<br>
     * 上次在我行办理银行承兑汇票增值税发票是否提交
     */
    private String flg2;

    /**
     * VARCHAR(100)<br>
     * 备注
     */
    private String rem;

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
     * VARCHAR(500)<br>
     * 其它条件和要求
     */
    private String othRem;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 流水号
     */
    public String getBillId() {
        return billId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 流水号
     */
    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 表单流水号
     */
    public String getExtId() {
        return extId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 表单流水号
     */
    public void setExtId(String extId) {
        this.extId = extId == null ? null : extId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 关联类型
     */
    public String getRelaTyp() {
        return relaTyp;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 关联类型
     */
    public void setRelaTyp(String relaTyp) {
        this.relaTyp = relaTyp == null ? null : relaTyp.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 关联编号
     */
    public String getRelaNo() {
        return relaNo;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 关联编号
     */
    public void setRelaNo(String relaNo) {
        this.relaNo = relaNo == null ? null : relaNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 票据编号
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 票据编号
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 票据类型
     */
    public String getBillTyp() {
        return billTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 票据类型
     */
    public void setBillTyp(String billTyp) {
        this.billTyp = billTyp == null ? null : billTyp.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 票据状态
     */
    public String getBillStat() {
        return billStat;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 票据状态
     */
    public void setBillStat(String billStat) {
        this.billStat = billStat == null ? null : billStat.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 用途
     */
    public String getPrps() {
        return prps;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 用途
     */
    public void setPrps(String prps) {
        this.prps = prps == null ? null : prps.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 出票人代码
     */
    public String getWrtId() {
        return wrtId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 出票人代码
     */
    public void setWrtId(String wrtId) {
        this.wrtId = wrtId == null ? null : wrtId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 出票人
     */
    public String getWrtNm() {
        return wrtNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 出票人
     */
    public void setWrtNm(String wrtNm) {
        this.wrtNm = wrtNm == null ? null : wrtNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 持票人代码
     */
    public String getHldId() {
        return hldId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 持票人代码
     */
    public void setHldId(String hldId) {
        this.hldId = hldId == null ? null : hldId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 持票人
     */
    public String getHldNm() {
        return hldNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 持票人
     */
    public void setHldNm(String hldNm) {
        this.hldNm = hldNm == null ? null : hldNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 受益人代码
     */
    public String getBnfcyId() {
        return bnfcyId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 受益人代码
     */
    public void setBnfcyId(String bnfcyId) {
        this.bnfcyId = bnfcyId == null ? null : bnfcyId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 受益人
     */
    public String getBnfcyNm() {
        return bnfcyNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 受益人
     */
    public void setBnfcyNm(String bnfcyNm) {
        this.bnfcyNm = bnfcyNm == null ? null : bnfcyNm.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 背书次数
     */
    public BigDecimal getEndOrseTim() {
        return endOrseTim;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 背书次数
     */
    public void setEndOrseTim(BigDecimal endOrseTim) {
        this.endOrseTim = endOrseTim;
    }

    /**
     * VARCHAR(80)<br>
     * 获得 上次背书人
     */
    public String getLsTbfcy() {
        return lsTbfcy;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 上次背书人
     */
    public void setLsTbfcy(String lsTbfcy) {
        this.lsTbfcy = lsTbfcy == null ? null : lsTbfcy.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 承兑人代码
     */
    public String getAcptId() {
        return acptId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 承兑人代码
     */
    public void setAcptId(String acptId) {
        this.acptId = acptId == null ? null : acptId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 承兑人
     */
    public String getAcptNm() {
        return acptNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 承兑人
     */
    public void setAcptNm(String acptNm) {
        this.acptNm = acptNm == null ? null : acptNm.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 承兑人级别
     */
    public String getAcptLev() {
        return acptLev;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 承兑人级别
     */
    public void setAcptLev(String acptLev) {
        this.acptLev = acptLev == null ? null : acptLev.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 承兑人所在行政区域
     */
    public String getAcptReg() {
        return acptReg;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 承兑人所在行政区域
     */
    public void setAcptReg(String acptReg) {
        this.acptReg = acptReg == null ? null : acptReg.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 期限
     */
    public String getTrm() {
        return trm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 期限
     */
    public void setTrm(String trm) {
        this.trm = trm == null ? null : trm.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 出票日期
     */
    public String getWrtDt() {
        return wrtDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 出票日期
     */
    public void setWrtDt(String wrtDt) {
        this.wrtDt = wrtDt == null ? null : wrtDt.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 到期日
     */
    public String getMtrDt() {
        return mtrDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 到期日
     */
    public void setMtrDt(String mtrDt) {
        this.mtrDt = mtrDt == null ? null : mtrDt.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 币种
     */
    public String getBillCurcd() {
        return billCurcd;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 币种
     */
    public void setBillCurcd(String billCurcd) {
        this.billCurcd = billCurcd == null ? null : billCurcd.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 票据数量
     */
    public BigDecimal getBillCut() {
        return billCut;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 票据数量
     */
    public void setBillCut(BigDecimal billCut) {
        this.billCut = billCut;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 票面金额
     */
    public BigDecimal getBillSum() {
        return billSum;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 票面金额
     */
    public void setBillSum(BigDecimal billSum) {
        this.billSum = billSum;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 完成日期
     */
    public String getFinDt() {
        return finDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 完成日期
     */
    public void setFinDt(String finDt) {
        this.finDt = finDt == null ? null : finDt.trim();
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 实付金额
     */
    public BigDecimal getActSum() {
        return actSum;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 实付金额
     */
    public void setActSum(BigDecimal actSum) {
        this.actSum = actSum;
    }

    /**
     * DECIMAL(24,6)<br>
     * 获得 实收利息
     */
    public BigDecimal getActInt() {
        return actInt;
    }

    /**
     * DECIMAL(24,6)<br>
     * 设置 实收利息
     */
    public void setActInt(BigDecimal actInt) {
        this.actInt = actInt;
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 贴现利率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 贴现利率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * VARCHAR(18)<br>
     * 获得 贴现付息方式
     */
    public String getIntTyp() {
        return intTyp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 贴现付息方式
     */
    public void setIntTyp(String intTyp) {
        this.intTyp = intTyp == null ? null : intTyp.trim();
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 协议付息所占比例
     */
    public BigDecimal getScale() {
        return scale;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 协议付息所占比例
     */
    public void setScale(BigDecimal scale) {
        this.scale = scale;
    }

    /**
     * VARCHAR(80)<br>
     * 获得 收款人户名
     */
    public String getGatrNm() {
        return gatrNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 收款人户名
     */
    public void setGatrNm(String gatrNm) {
        this.gatrNm = gatrNm == null ? null : gatrNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 收款人帐号
     */
    public String getActNo() {
        return actNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 收款人帐号
     */
    public void setActNo(String actNo) {
        this.actNo = actNo == null ? null : actNo.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 收款行行名
     */
    public String getAbtBakNm() {
        return abtBakNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 收款行行名
     */
    public void setAbtBakNm(String abtBakNm) {
        this.abtBakNm = abtBakNm == null ? null : abtBakNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 承兑汇票组内序号
     */
    public String getIntSialno() {
        return intSialno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 承兑汇票组内序号
     */
    public void setIntSialno(String intSialno) {
        this.intSialno = intSialno == null ? null : intSialno.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 收款行行号
     */
    public String getAbtBakId() {
        return abtBakId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 收款行行号
     */
    public void setAbtBakId(String abtBakId) {
        this.abtBakId = abtBakId == null ? null : abtBakId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 相关出帐号
     */
    public String getRelaPotNo() {
        return relaPotNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 相关出帐号
     */
    public void setRelaPotNo(String relaPotNo) {
        this.relaPotNo = relaPotNo == null ? null : relaPotNo.trim();
    }

    /**
     * VARCHAR(1)<br>
     * 获得 发送标志
     */
    public String getSendFlg() {
        return sendFlg;
    }

    /**
     * VARCHAR(1)<br>
     * 设置 发送标志
     */
    public void setSendFlg(String sendFlg) {
        this.sendFlg = sendFlg == null ? null : sendFlg.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 查复日期
     */
    public String getChkRpyDt() {
        return chkRpyDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 查复日期
     */
    public void setChkRpyDt(String chkRpyDt) {
        this.chkRpyDt = chkRpyDt == null ? null : chkRpyDt.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 票据存放机构
     */
    public String getKepBillBrCd() {
        return kepBillBrCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 票据存放机构
     */
    public void setKepBillBrCd(String kepBillBrCd) {
        this.kepBillBrCd = kepBillBrCd == null ? null : kepBillBrCd.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 贸易背景合同编号
     */
    public String getTradConNo() {
        return tradConNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 贸易背景合同编号
     */
    public void setTradConNo(String tradConNo) {
        this.tradConNo = tradConNo == null ? null : tradConNo.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 贸易背景合同名称
     */
    public String getTradConNm() {
        return tradConNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 贸易背景合同名称
     */
    public void setTradConNm(String tradConNm) {
        this.tradConNm = tradConNm == null ? null : tradConNm.trim();
    }

    /**
     * DECIMAL(24,2)<br>
     * 获得 贸易背景合同金额
     */
    public BigDecimal getTradConAmt() {
        return tradConAmt;
    }

    /**
     * DECIMAL(24,2)<br>
     * 设置 贸易背景合同金额
     */
    public void setTradConAmt(BigDecimal tradConAmt) {
        this.tradConAmt = tradConAmt;
    }

    /**
     * VARCHAR(4)<br>
     * 获得 对应合同收款人是承兑汇票收款人
     */
    public String getFlg1() {
        return flg1;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 对应合同收款人是承兑汇票收款人
     */
    public void setFlg1(String flg1) {
        this.flg1 = flg1 == null ? null : flg1.trim();
    }

    /**
     * VARCHAR(4)<br>
     * 获得 上次在我行办理银行承兑汇票增值税发票是否提交
     */
    public String getFlg2() {
        return flg2;
    }

    /**
     * VARCHAR(4)<br>
     * 设置 上次在我行办理银行承兑汇票增值税发票是否提交
     */
    public void setFlg2(String flg2) {
        this.flg2 = flg2 == null ? null : flg2.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 备注
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 备注
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
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

    /**
     * VARCHAR(500)<br>
     * 获得 其它条件和要求
     */
    public String getOthRem() {
        return othRem;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 其它条件和要求
     */
    public void setOthRem(String othRem) {
        this.othRem = othRem == null ? null : othRem.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billId=").append(billId);
        sb.append(", extId=").append(extId);
        sb.append(", relaTyp=").append(relaTyp);
        sb.append(", relaNo=").append(relaNo);
        sb.append(", billNo=").append(billNo);
        sb.append(", billTyp=").append(billTyp);
        sb.append(", billStat=").append(billStat);
        sb.append(", prps=").append(prps);
        sb.append(", wrtId=").append(wrtId);
        sb.append(", wrtNm=").append(wrtNm);
        sb.append(", hldId=").append(hldId);
        sb.append(", hldNm=").append(hldNm);
        sb.append(", bnfcyId=").append(bnfcyId);
        sb.append(", bnfcyNm=").append(bnfcyNm);
        sb.append(", endOrseTim=").append(endOrseTim);
        sb.append(", lsTbfcy=").append(lsTbfcy);
        sb.append(", acptId=").append(acptId);
        sb.append(", acptNm=").append(acptNm);
        sb.append(", acptLev=").append(acptLev);
        sb.append(", acptReg=").append(acptReg);
        sb.append(", trm=").append(trm);
        sb.append(", wrtDt=").append(wrtDt);
        sb.append(", mtrDt=").append(mtrDt);
        sb.append(", billCurcd=").append(billCurcd);
        sb.append(", billCut=").append(billCut);
        sb.append(", billSum=").append(billSum);
        sb.append(", finDt=").append(finDt);
        sb.append(", actSum=").append(actSum);
        sb.append(", actInt=").append(actInt);
        sb.append(", rate=").append(rate);
        sb.append(", intTyp=").append(intTyp);
        sb.append(", scale=").append(scale);
        sb.append(", gatrNm=").append(gatrNm);
        sb.append(", actNo=").append(actNo);
        sb.append(", abtBakNm=").append(abtBakNm);
        sb.append(", intSialno=").append(intSialno);
        sb.append(", abtBakId=").append(abtBakId);
        sb.append(", relaPotNo=").append(relaPotNo);
        sb.append(", sendFlg=").append(sendFlg);
        sb.append(", chkRpyDt=").append(chkRpyDt);
        sb.append(", kepBillBrCd=").append(kepBillBrCd);
        sb.append(", tradConNo=").append(tradConNo);
        sb.append(", tradConNm=").append(tradConNm);
        sb.append(", tradConAmt=").append(tradConAmt);
        sb.append(", flg1=").append(flg1);
        sb.append(", flg2=").append(flg2);
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
        sb.append(", othRem=").append(othRem);
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
        BCrrBillInfo other = (BCrrBillInfo) that;
        return (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getExtId() == null ? other.getExtId() == null : this.getExtId().equals(other.getExtId()))
            && (this.getRelaTyp() == null ? other.getRelaTyp() == null : this.getRelaTyp().equals(other.getRelaTyp()))
            && (this.getRelaNo() == null ? other.getRelaNo() == null : this.getRelaNo().equals(other.getRelaNo()))
            && (this.getBillNo() == null ? other.getBillNo() == null : this.getBillNo().equals(other.getBillNo()))
            && (this.getBillTyp() == null ? other.getBillTyp() == null : this.getBillTyp().equals(other.getBillTyp()))
            && (this.getBillStat() == null ? other.getBillStat() == null : this.getBillStat().equals(other.getBillStat()))
            && (this.getPrps() == null ? other.getPrps() == null : this.getPrps().equals(other.getPrps()))
            && (this.getWrtId() == null ? other.getWrtId() == null : this.getWrtId().equals(other.getWrtId()))
            && (this.getWrtNm() == null ? other.getWrtNm() == null : this.getWrtNm().equals(other.getWrtNm()))
            && (this.getHldId() == null ? other.getHldId() == null : this.getHldId().equals(other.getHldId()))
            && (this.getHldNm() == null ? other.getHldNm() == null : this.getHldNm().equals(other.getHldNm()))
            && (this.getBnfcyId() == null ? other.getBnfcyId() == null : this.getBnfcyId().equals(other.getBnfcyId()))
            && (this.getBnfcyNm() == null ? other.getBnfcyNm() == null : this.getBnfcyNm().equals(other.getBnfcyNm()))
            && (this.getEndOrseTim() == null ? other.getEndOrseTim() == null : this.getEndOrseTim().equals(other.getEndOrseTim()))
            && (this.getLsTbfcy() == null ? other.getLsTbfcy() == null : this.getLsTbfcy().equals(other.getLsTbfcy()))
            && (this.getAcptId() == null ? other.getAcptId() == null : this.getAcptId().equals(other.getAcptId()))
            && (this.getAcptNm() == null ? other.getAcptNm() == null : this.getAcptNm().equals(other.getAcptNm()))
            && (this.getAcptLev() == null ? other.getAcptLev() == null : this.getAcptLev().equals(other.getAcptLev()))
            && (this.getAcptReg() == null ? other.getAcptReg() == null : this.getAcptReg().equals(other.getAcptReg()))
            && (this.getTrm() == null ? other.getTrm() == null : this.getTrm().equals(other.getTrm()))
            && (this.getWrtDt() == null ? other.getWrtDt() == null : this.getWrtDt().equals(other.getWrtDt()))
            && (this.getMtrDt() == null ? other.getMtrDt() == null : this.getMtrDt().equals(other.getMtrDt()))
            && (this.getBillCurcd() == null ? other.getBillCurcd() == null : this.getBillCurcd().equals(other.getBillCurcd()))
            && (this.getBillCut() == null ? other.getBillCut() == null : this.getBillCut().equals(other.getBillCut()))
            && (this.getBillSum() == null ? other.getBillSum() == null : this.getBillSum().equals(other.getBillSum()))
            && (this.getFinDt() == null ? other.getFinDt() == null : this.getFinDt().equals(other.getFinDt()))
            && (this.getActSum() == null ? other.getActSum() == null : this.getActSum().equals(other.getActSum()))
            && (this.getActInt() == null ? other.getActInt() == null : this.getActInt().equals(other.getActInt()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getIntTyp() == null ? other.getIntTyp() == null : this.getIntTyp().equals(other.getIntTyp()))
            && (this.getScale() == null ? other.getScale() == null : this.getScale().equals(other.getScale()))
            && (this.getGatrNm() == null ? other.getGatrNm() == null : this.getGatrNm().equals(other.getGatrNm()))
            && (this.getActNo() == null ? other.getActNo() == null : this.getActNo().equals(other.getActNo()))
            && (this.getAbtBakNm() == null ? other.getAbtBakNm() == null : this.getAbtBakNm().equals(other.getAbtBakNm()))
            && (this.getIntSialno() == null ? other.getIntSialno() == null : this.getIntSialno().equals(other.getIntSialno()))
            && (this.getAbtBakId() == null ? other.getAbtBakId() == null : this.getAbtBakId().equals(other.getAbtBakId()))
            && (this.getRelaPotNo() == null ? other.getRelaPotNo() == null : this.getRelaPotNo().equals(other.getRelaPotNo()))
            && (this.getSendFlg() == null ? other.getSendFlg() == null : this.getSendFlg().equals(other.getSendFlg()))
            && (this.getChkRpyDt() == null ? other.getChkRpyDt() == null : this.getChkRpyDt().equals(other.getChkRpyDt()))
            && (this.getKepBillBrCd() == null ? other.getKepBillBrCd() == null : this.getKepBillBrCd().equals(other.getKepBillBrCd()))
            && (this.getTradConNo() == null ? other.getTradConNo() == null : this.getTradConNo().equals(other.getTradConNo()))
            && (this.getTradConNm() == null ? other.getTradConNm() == null : this.getTradConNm().equals(other.getTradConNm()))
            && (this.getTradConAmt() == null ? other.getTradConAmt() == null : this.getTradConAmt().equals(other.getTradConAmt()))
            && (this.getFlg1() == null ? other.getFlg1() == null : this.getFlg1().equals(other.getFlg1()))
            && (this.getFlg2() == null ? other.getFlg2() == null : this.getFlg2().equals(other.getFlg2()))
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
            && (this.getOthRem() == null ? other.getOthRem() == null : this.getOthRem().equals(other.getOthRem()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getExtId() == null) ? 0 : getExtId().hashCode());
        result = prime * result + ((getRelaTyp() == null) ? 0 : getRelaTyp().hashCode());
        result = prime * result + ((getRelaNo() == null) ? 0 : getRelaNo().hashCode());
        result = prime * result + ((getBillNo() == null) ? 0 : getBillNo().hashCode());
        result = prime * result + ((getBillTyp() == null) ? 0 : getBillTyp().hashCode());
        result = prime * result + ((getBillStat() == null) ? 0 : getBillStat().hashCode());
        result = prime * result + ((getPrps() == null) ? 0 : getPrps().hashCode());
        result = prime * result + ((getWrtId() == null) ? 0 : getWrtId().hashCode());
        result = prime * result + ((getWrtNm() == null) ? 0 : getWrtNm().hashCode());
        result = prime * result + ((getHldId() == null) ? 0 : getHldId().hashCode());
        result = prime * result + ((getHldNm() == null) ? 0 : getHldNm().hashCode());
        result = prime * result + ((getBnfcyId() == null) ? 0 : getBnfcyId().hashCode());
        result = prime * result + ((getBnfcyNm() == null) ? 0 : getBnfcyNm().hashCode());
        result = prime * result + ((getEndOrseTim() == null) ? 0 : getEndOrseTim().hashCode());
        result = prime * result + ((getLsTbfcy() == null) ? 0 : getLsTbfcy().hashCode());
        result = prime * result + ((getAcptId() == null) ? 0 : getAcptId().hashCode());
        result = prime * result + ((getAcptNm() == null) ? 0 : getAcptNm().hashCode());
        result = prime * result + ((getAcptLev() == null) ? 0 : getAcptLev().hashCode());
        result = prime * result + ((getAcptReg() == null) ? 0 : getAcptReg().hashCode());
        result = prime * result + ((getTrm() == null) ? 0 : getTrm().hashCode());
        result = prime * result + ((getWrtDt() == null) ? 0 : getWrtDt().hashCode());
        result = prime * result + ((getMtrDt() == null) ? 0 : getMtrDt().hashCode());
        result = prime * result + ((getBillCurcd() == null) ? 0 : getBillCurcd().hashCode());
        result = prime * result + ((getBillCut() == null) ? 0 : getBillCut().hashCode());
        result = prime * result + ((getBillSum() == null) ? 0 : getBillSum().hashCode());
        result = prime * result + ((getFinDt() == null) ? 0 : getFinDt().hashCode());
        result = prime * result + ((getActSum() == null) ? 0 : getActSum().hashCode());
        result = prime * result + ((getActInt() == null) ? 0 : getActInt().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getIntTyp() == null) ? 0 : getIntTyp().hashCode());
        result = prime * result + ((getScale() == null) ? 0 : getScale().hashCode());
        result = prime * result + ((getGatrNm() == null) ? 0 : getGatrNm().hashCode());
        result = prime * result + ((getActNo() == null) ? 0 : getActNo().hashCode());
        result = prime * result + ((getAbtBakNm() == null) ? 0 : getAbtBakNm().hashCode());
        result = prime * result + ((getIntSialno() == null) ? 0 : getIntSialno().hashCode());
        result = prime * result + ((getAbtBakId() == null) ? 0 : getAbtBakId().hashCode());
        result = prime * result + ((getRelaPotNo() == null) ? 0 : getRelaPotNo().hashCode());
        result = prime * result + ((getSendFlg() == null) ? 0 : getSendFlg().hashCode());
        result = prime * result + ((getChkRpyDt() == null) ? 0 : getChkRpyDt().hashCode());
        result = prime * result + ((getKepBillBrCd() == null) ? 0 : getKepBillBrCd().hashCode());
        result = prime * result + ((getTradConNo() == null) ? 0 : getTradConNo().hashCode());
        result = prime * result + ((getTradConNm() == null) ? 0 : getTradConNm().hashCode());
        result = prime * result + ((getTradConAmt() == null) ? 0 : getTradConAmt().hashCode());
        result = prime * result + ((getFlg1() == null) ? 0 : getFlg1().hashCode());
        result = prime * result + ((getFlg2() == null) ? 0 : getFlg2().hashCode());
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
        result = prime * result + ((getOthRem() == null) ? 0 : getOthRem().hashCode());
        return result;
    }
}