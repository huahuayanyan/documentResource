package com.huateng.scf.adv.fcs.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.huateng.scf.bas.pbc.model.BPbcMtgBaseInfo;
import com.huateng.scube.server.annotation.ScubeParam;

public class BPbcWhseInspectVo {

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;
    
    /**
     *
     *
     */
    private String conId;

    /**
     * VARCHAR(15)<br>
     * 客户号
     */
    private String custCd;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement1;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement2;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement3;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement4;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement5;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement6;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement7;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement8;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement9;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement10;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement11;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement12;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement13;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement14;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement15;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement16;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement17;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement18;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement19;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement20;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement21;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement31;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement30;

    /**
     * VARCHAR(80)<br>
     * 核定质押率(%)
     */
    private String inspectElement29;

    /**
     * DECIMAL(16,2)<br>
     * 累计敞口余额
     */
    private BigDecimal inspectElement28;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement27;

    /**
     * DECIMAL(16,2)<br>
     * 价值总计(元)
     */
    private BigDecimal inspectElement26;

    /**
     * DECIMAL(16,2)<br>
     * 总数量
     */
    private BigDecimal inspectElement25;

    /**
     * VARCHAR(80)<br>
     * 当前最低控货价值
     */
    private String inspectElement24;

    /**
     * VARCHAR(80)<br>
     * 货押模式
     */
    private String inspectElement23;

    /**
     * VARCHAR(15)<br>
     * 出质人客户号
     */
    private String inspectElement22;

    /**
     * VARCHAR(200)<br>
     * 巡库结果
     */
    private String results;

    /**
     * CHAR(8)<br>
     * 申请日期
     */
    private String appDate;

    /**
     * VARCHAR(32)<br>
     * 经办人
     */
    private String tlrcd;
    
    /**
     * VARCHAR(32)<br>
     * 经办人姓名
     */
    private String tlrName;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;
    
    /**
     * VARCHAR(20)<br>
     * 经办机构名称
     */
    private String brName;

    /**
     * CHAR(2)<br>
     * 状态：0-未确认回执、1-监管公司确认回执、2-核库巡库岗确认回执、9-其它
     */
    private String status;

    /**
     * VARCHAR(15)<br>
     * 监管客户号
     */
    private String moniCustcd;

    private String moniCustName;

    /**
     * VARCHAR(100)<br>
     * 巡库意见
     */
    private String idea;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String reinspect;

    /**
     * VARCHAR(20)<br>
     * 巡库报告编号
     */
    private String inspectReportNo;

    /**
     * VARCHAR(200)<br>
     * 
     */
    private String inspectElement32;

    /**
     * VARCHAR(200)<br>
     * 本次核库占比（%）
     */
    private String inspectElement33;

    /**
     * VARCHAR(80)<br>
     * 当前查库总价值
     */
    private String inspectElement34;

    /**
     * DECIMAL(16,2)<br>
     * 当前查库数量
     */
    private BigDecimal inspectElement35;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String inspectElement36;

    /**
     * VARCHAR(20)<br>
     * 监管协议号
     */
    private String protocolNo;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String productId;

    /**
     * VARCHAR(100)<br>
     * 监管仓库名称
     */
    private String warehouseName;

    /**
     * DECIMAL(16,2)<br>
     * 当次出账金额
     */
    private BigDecimal loanAmt;

    /**
     * DECIMAL(16,2)<br>
     * 当次出账敞口
     */
    private BigDecimal loanRiskAmt;

    /**
     * CHAR(2)<br>
     * 操作类型：0-巡库、1-核库
     */
    private String operType;
    
    /**
     * CHAR(2)<br>
     * 监管模式
     */
    private String moniWarehouseType;
    /**
     * CHAR(2)<br>
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * CHAR(2)<br>
     * 押品清单
     */
    private List<Map<String, Object>> mtgBaseList;

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
     * VARCHAR(15)<br>
     * 获得 客户号
     */
    public String getCustCd() {
        return custCd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 客户号
     */
    public void setCustCd(String custCd) {
        this.custCd = custCd == null ? null : custCd.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement1() {
        return inspectElement1;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement1(String inspectElement1) {
        this.inspectElement1 = inspectElement1 == null ? null : inspectElement1.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement2() {
        return inspectElement2;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement2(String inspectElement2) {
        this.inspectElement2 = inspectElement2 == null ? null : inspectElement2.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement3() {
        return inspectElement3;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement3(String inspectElement3) {
        this.inspectElement3 = inspectElement3 == null ? null : inspectElement3.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement4() {
        return inspectElement4;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement4(String inspectElement4) {
        this.inspectElement4 = inspectElement4 == null ? null : inspectElement4.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement5() {
        return inspectElement5;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement5(String inspectElement5) {
        this.inspectElement5 = inspectElement5 == null ? null : inspectElement5.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement6() {
        return inspectElement6;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement6(String inspectElement6) {
        this.inspectElement6 = inspectElement6 == null ? null : inspectElement6.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement7() {
        return inspectElement7;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement7(String inspectElement7) {
        this.inspectElement7 = inspectElement7 == null ? null : inspectElement7.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement8() {
        return inspectElement8;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement8(String inspectElement8) {
        this.inspectElement8 = inspectElement8 == null ? null : inspectElement8.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement9() {
        return inspectElement9;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement9(String inspectElement9) {
        this.inspectElement9 = inspectElement9 == null ? null : inspectElement9.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement10() {
        return inspectElement10;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement10(String inspectElement10) {
        this.inspectElement10 = inspectElement10 == null ? null : inspectElement10.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement11() {
        return inspectElement11;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement11(String inspectElement11) {
        this.inspectElement11 = inspectElement11 == null ? null : inspectElement11.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement12() {
        return inspectElement12;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement12(String inspectElement12) {
        this.inspectElement12 = inspectElement12 == null ? null : inspectElement12.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement13() {
        return inspectElement13;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement13(String inspectElement13) {
        this.inspectElement13 = inspectElement13 == null ? null : inspectElement13.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement14() {
        return inspectElement14;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement14(String inspectElement14) {
        this.inspectElement14 = inspectElement14 == null ? null : inspectElement14.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement15() {
        return inspectElement15;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement15(String inspectElement15) {
        this.inspectElement15 = inspectElement15 == null ? null : inspectElement15.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement16() {
        return inspectElement16;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement16(String inspectElement16) {
        this.inspectElement16 = inspectElement16 == null ? null : inspectElement16.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement17() {
        return inspectElement17;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement17(String inspectElement17) {
        this.inspectElement17 = inspectElement17 == null ? null : inspectElement17.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement18() {
        return inspectElement18;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement18(String inspectElement18) {
        this.inspectElement18 = inspectElement18 == null ? null : inspectElement18.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement19() {
        return inspectElement19;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement19(String inspectElement19) {
        this.inspectElement19 = inspectElement19 == null ? null : inspectElement19.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement20() {
        return inspectElement20;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement20(String inspectElement20) {
        this.inspectElement20 = inspectElement20 == null ? null : inspectElement20.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement21() {
        return inspectElement21;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement21(String inspectElement21) {
        this.inspectElement21 = inspectElement21 == null ? null : inspectElement21.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement31() {
        return inspectElement31;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement31(String inspectElement31) {
        this.inspectElement31 = inspectElement31 == null ? null : inspectElement31.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement30() {
        return inspectElement30;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement30(String inspectElement30) {
        this.inspectElement30 = inspectElement30 == null ? null : inspectElement30.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 核定质押率(%)
     */
    public String getInspectElement29() {
        return inspectElement29;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 核定质押率(%)
     */
    public void setInspectElement29(String inspectElement29) {
        this.inspectElement29 = inspectElement29 == null ? null : inspectElement29.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计敞口余额
     */
    public BigDecimal getInspectElement28() {
        return inspectElement28;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计敞口余额
     */
    public void setInspectElement28(BigDecimal inspectElement28) {
        this.inspectElement28 = inspectElement28;
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement27() {
        return inspectElement27;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement27(String inspectElement27) {
        this.inspectElement27 = inspectElement27 == null ? null : inspectElement27.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 价值总计(元)
     */
    public BigDecimal getInspectElement26() {
        return inspectElement26;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 价值总计(元)
     */
    public void setInspectElement26(BigDecimal inspectElement26) {
        this.inspectElement26 = inspectElement26;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 总数量
     */
    public BigDecimal getInspectElement25() {
        return inspectElement25;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 总数量
     */
    public void setInspectElement25(BigDecimal inspectElement25) {
        this.inspectElement25 = inspectElement25;
    }

    /**
     * VARCHAR(80)<br>
     * 获得 当前最低控货价值
     */
    public String getInspectElement24() {
        return inspectElement24;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 当前最低控货价值
     */
    public void setInspectElement24(String inspectElement24) {
        this.inspectElement24 = inspectElement24 == null ? null : inspectElement24.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 货押模式
     */
    public String getInspectElement23() {
        return inspectElement23;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 货押模式
     */
    public void setInspectElement23(String inspectElement23) {
        this.inspectElement23 = inspectElement23 == null ? null : inspectElement23.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 出质人客户号
     */
    public String getInspectElement22() {
        return inspectElement22;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 出质人客户号
     */
    public void setInspectElement22(String inspectElement22) {
        this.inspectElement22 = inspectElement22 == null ? null : inspectElement22.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 巡库结果
     */
    public String getResults() {
        return results;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 巡库结果
     */
    public void setResults(String results) {
        this.results = results == null ? null : results.trim();
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
     * 获得 经办人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 经办人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
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
     * CHAR(2)<br>
     * 获得 状态：0-未确认回执、1-监管公司确认回执、2-核库巡库岗确认回执、9-其它
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(2)<br>
     * 设置 状态：0-未确认回执、1-监管公司确认回执、2-核库巡库岗确认回执、9-其它
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 监管客户号
     */
    public String getMoniCustcd() {
        return moniCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 监管客户号
     */
    public void setMoniCustcd(String moniCustcd) {
        this.moniCustcd = moniCustcd == null ? null : moniCustcd.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 巡库意见
     */
    public String getIdea() {
        return idea;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 巡库意见
     */
    public void setIdea(String idea) {
        this.idea = idea == null ? null : idea.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getReinspect() {
        return reinspect;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setReinspect(String reinspect) {
        this.reinspect = reinspect == null ? null : reinspect.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 巡库报告编号
     */
    public String getInspectReportNo() {
        return inspectReportNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 巡库报告编号
     */
    public void setInspectReportNo(String inspectReportNo) {
        this.inspectReportNo = inspectReportNo == null ? null : inspectReportNo.trim();
    }

    /**
     * VARCHAR(200)<br>
     */
    public String getInspectElement32() {
        return inspectElement32;
    }

    /**
     * VARCHAR(200)<br>
     */
    public void setInspectElement32(String inspectElement32) {
        this.inspectElement32 = inspectElement32 == null ? null : inspectElement32.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 本次核库占比（%）
     */
    public String getInspectElement33() {
        return inspectElement33;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 本次核库占比（%）
     */
    public void setInspectElement33(String inspectElement33) {
        this.inspectElement33 = inspectElement33 == null ? null : inspectElement33.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 当前查库总价值
     */
    public String getInspectElement34() {
        return inspectElement34;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 当前查库总价值
     */
    public void setInspectElement34(String inspectElement34) {
        this.inspectElement34 = inspectElement34 == null ? null : inspectElement34.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 当前查库数量
     */
    public BigDecimal getInspectElement35() {
        return inspectElement35;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 当前查库数量
     */
    public void setInspectElement35(BigDecimal inspectElement35) {
        this.inspectElement35 = inspectElement35;
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getInspectElement36() {
        return inspectElement36;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setInspectElement36(String inspectElement36) {
        this.inspectElement36 = inspectElement36 == null ? null : inspectElement36.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 监管仓库名称
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 监管仓库名称
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 当次出账金额
     */
    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 当次出账金额
     */
    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 当次出账敞口
     */
    public BigDecimal getLoanRiskAmt() {
        return loanRiskAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 当次出账敞口
     */
    public void setLoanRiskAmt(BigDecimal loanRiskAmt) {
        this.loanRiskAmt = loanRiskAmt;
    }

    /**
     * CHAR(2)<br>
     * 获得 操作类型：0-巡库、1-核库
     */
    public String getOperType() {
        return operType;
    }

    /**
     * CHAR(2)<br>
     * 设置 操作类型：0-巡库、1-核库
     */
    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custCd=").append(custCd);
        sb.append(", inspectElement1=").append(inspectElement1);
        sb.append(", inspectElement2=").append(inspectElement2);
        sb.append(", inspectElement3=").append(inspectElement3);
        sb.append(", inspectElement4=").append(inspectElement4);
        sb.append(", inspectElement5=").append(inspectElement5);
        sb.append(", inspectElement6=").append(inspectElement6);
        sb.append(", inspectElement7=").append(inspectElement7);
        sb.append(", inspectElement8=").append(inspectElement8);
        sb.append(", inspectElement9=").append(inspectElement9);
        sb.append(", inspectElement10=").append(inspectElement10);
        sb.append(", inspectElement11=").append(inspectElement11);
        sb.append(", inspectElement12=").append(inspectElement12);
        sb.append(", inspectElement13=").append(inspectElement13);
        sb.append(", inspectElement14=").append(inspectElement14);
        sb.append(", inspectElement15=").append(inspectElement15);
        sb.append(", inspectElement16=").append(inspectElement16);
        sb.append(", inspectElement17=").append(inspectElement17);
        sb.append(", inspectElement18=").append(inspectElement18);
        sb.append(", inspectElement19=").append(inspectElement19);
        sb.append(", inspectElement20=").append(inspectElement20);
        sb.append(", inspectElement21=").append(inspectElement21);
        sb.append(", inspectElement31=").append(inspectElement31);
        sb.append(", inspectElement30=").append(inspectElement30);
        sb.append(", inspectElement29=").append(inspectElement29);
        sb.append(", inspectElement28=").append(inspectElement28);
        sb.append(", inspectElement27=").append(inspectElement27);
        sb.append(", inspectElement26=").append(inspectElement26);
        sb.append(", inspectElement25=").append(inspectElement25);
        sb.append(", inspectElement24=").append(inspectElement24);
        sb.append(", inspectElement23=").append(inspectElement23);
        sb.append(", inspectElement22=").append(inspectElement22);
        sb.append(", results=").append(results);
        sb.append(", appDate=").append(appDate);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", brcode=").append(brcode);
        sb.append(", status=").append(status);
        sb.append(", moniCustcd=").append(moniCustcd);
        sb.append(", idea=").append(idea);
        sb.append(", reinspect=").append(reinspect);
        sb.append(", inspectReportNo=").append(inspectReportNo);
        sb.append(", inspectElement32=").append(inspectElement32);
        sb.append(", inspectElement33=").append(inspectElement33);
        sb.append(", inspectElement34=").append(inspectElement34);
        sb.append(", inspectElement35=").append(inspectElement35);
        sb.append(", inspectElement36=").append(inspectElement36);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", productId=").append(productId);
        sb.append(", warehouseName=").append(warehouseName);
        sb.append(", loanAmt=").append(loanAmt);
        sb.append(", loanRiskAmt=").append(loanRiskAmt);
        sb.append(", operType=").append(operType);
        sb.append("]");
        return sb.toString();
    }

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getTlrName() {
		return tlrName;
	}

	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getMoniCustName() {
		return moniCustName;
	}

	public void setMoniCustName(String moniCustName) {
		this.moniCustName = moniCustName;
	}

	public String getMoniWarehouseType() {
		return moniWarehouseType;
	}

	public void setMoniWarehouseType(String moniWarehouseType) {
		this.moniWarehouseType = moniWarehouseType;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Map<String, Object>> getMtgBaseList() {
		return mtgBaseList;
	}

	public void setMtgBaseList(List<Map<String, Object>> mtgBaseList) {
		this.mtgBaseList = mtgBaseList;
	}
}