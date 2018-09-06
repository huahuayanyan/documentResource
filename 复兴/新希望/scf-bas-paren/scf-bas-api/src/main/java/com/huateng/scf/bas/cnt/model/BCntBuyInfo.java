package com.huateng.scf.bas.cnt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BCntBuyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(20) 必填<br>
     * 合同号
     */
    private String tradeContno;

    /**
     * VARCHAR(200) 必填<br>
     * 合同编号
     */
    private String tradeContcode;

    /**
     * VARCHAR(20) 必填<br>
     * 主合同号
     */
    private String mastContno;

    /**
     * VARCHAR(15) 必填<br>
     * 经销商/买方客户号
     */
    private String custcd;

    /**
     * CHAR(8)<br>
     * 签订日期
     */
    private String applyDate;

    /**
     * CHAR(8) 必填<br>
     * 合同生效日
     */
    private String startDate;

    /**
     * CHAR(8) 必填<br>
     * 合同到期日
     */
    private String endDate;

    /**
     * CHAR(3) 必填<br>
     * 合同币种
     */
    private String curcd;

    /**
     * DECIMAL(16,2)<br>
     * 累计出账金额
     */
    private BigDecimal totAmt;

    /**
     * DECIMAL(16,2) 必填<br>
     * 合同金额
     */
    private BigDecimal amt;

    /**
     * DECIMAL(16,2)<br>
     * 审批中出账金额
     */
    private BigDecimal remainAmt;

    /**
     * VARCHAR(100)<br>
     * 授信客户/买方名称
     */
    private String cname;

    /**
     * VARCHAR(30)<br>
     * 收货人电话
     */
    private String tel;

    /**
     * VARCHAR(300)<br>
     * 收货地址
     */
    private String address;

    /**
     * VARCHAR(30)<br>
     * 收货人传真
     */
    private String fax;

    /**
     * CHAR(6)<br>
     * 收货人邮编
     */
    private String postcode;

    /**
     * VARCHAR(12)<br>
     * 收货人开户行号
     */
    private String bank;

    /**
     * VARCHAR(15)<br>
     * 核心厂商/上游厂商客户号
     */
    private String secCustcd;

    /**
     * VARCHAR(80)<br>
     * 核心厂商/上游厂商名称
     */
    private String secCname;

    /**
     * VARCHAR(30)<br>
     * 上游厂商联系电话
     */
    private String secTel;

    /**
     * VARCHAR(300)<br>
     * 上游厂商地址
     */
    private String secAddress;

    /**
     * VARCHAR(12)<br>
     * 上游厂商开户行号
     */
    private String secBank;

    /**
     * VARCHAR(30)<br>
     * 上游厂商传真
     */
    private String secFax;

    /**
     * VARCHAR(200)<br>
     * 上游厂商开户行名
     */
    private String secBankName;

    /**
     * CHAR(6)<br>
     * 上游厂商邮编
     */
    private String secPostcode;

    /**
     * VARCHAR(50)<br>
     * 保证金账号
     */
    private String bailAccount;

    /**
     * DECIMAL(16,2)<br>
     * 保证金金额
     */
    private BigDecimal bailAmount;

    /**
     * DECIMAL(5,2)<br>
     * 保证金比例
     */
    private BigDecimal bailRate;

    /**
     * VARCHAR(150)<br>
     * 交货方式
     */
    private String transportType;

    /**
     * VARCHAR(300)<br>
     * 授信客户地址
     */
    private String effectiveAddress;

    /**
     * DECIMAL(16,2)<br>
     * 其他费用
     */
    private BigDecimal costMoney;

    /**
     * VARCHAR(30)<br>
     * 协议类型
     */
    private String guattype;

    /**
     * VARCHAR(32)<br>
     * 客户经理/经办人
     */
    private String tlrno;

    /**
     * VARCHAR(30)<br>
     * 收货人
     */
    private String firName;

    /**
     * CHAR(1)<br>
     * 合同状态
     */
    private String status;

    /**
     * VARCHAR(50)<br>
     * 授信客户行业
     */
    private String industryOne;

    /**
     * VARCHAR(100)<br>
     * 上游客户行业
     */
    private String industryTwo;

    /**
     * VARCHAR(100)<br>
     * 扩展字段1
     */
    private String ext1;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String memo;

    /**
     * VARCHAR(20)<br>
     * 关联协议(担保提货协议/先票(款)后货协议)号
     */
    private String protocolNo;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String supplyChainPdId;

    /**
     * VARCHAR(50)<br>
     * 网银流水号
     */
    private String ebankAppno;

    /**
     * CHAR(1)<br>
     * 渠道标识：1-供应链、2-企业网银
     */
    private String channelFlag;

    /**
     * DECIMAL(16,2)<br>
     * 累计提货金额
     */
    private BigDecimal accuDeliAmt;

    /**
     * VARCHAR(20)<br>
     * 申请编号
     */
    private String appno;

    /**
     * VARCHAR(32) 必填<br>
     * 创建人
     */
    private String tlrcd;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 创建时间
     */
    private Date crtTime;

    /**
     * VARCHAR(20) 必填<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(32)<br>
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
     * VARCHAR(20) 必填<br>
     * 获得 合同号
     */
    public String getTradeContno() {
        return tradeContno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 合同号
     */
    public void setTradeContno(String tradeContno) {
        this.tradeContno = tradeContno == null ? null : tradeContno.trim();
    }

    /**
     * VARCHAR(200) 必填<br>
     * 获得 合同编号
     */
    public String getTradeContcode() {
        return tradeContcode;
    }

    /**
     * VARCHAR(200) 必填<br>
     * 设置 合同编号
     */
    public void setTradeContcode(String tradeContcode) {
        this.tradeContcode = tradeContcode == null ? null : tradeContcode.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 主合同号
     */
    public String getMastContno() {
        return mastContno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 主合同号
     */
    public void setMastContno(String mastContno) {
        this.mastContno = mastContno == null ? null : mastContno.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 经销商/买方客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 经销商/买方客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 签订日期
     */
    public String getApplyDate() {
        return applyDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 签订日期
     */
    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate == null ? null : applyDate.trim();
    }

    /**
     * CHAR(8) 必填<br>
     * 获得 合同生效日
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * CHAR(8) 必填<br>
     * 设置 合同生效日
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * CHAR(8) 必填<br>
     * 获得 合同到期日
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * CHAR(8) 必填<br>
     * 设置 合同到期日
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * CHAR(3) 必填<br>
     * 获得 合同币种
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * CHAR(3) 必填<br>
     * 设置 合同币种
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计出账金额
     */
    public BigDecimal getTotAmt() {
        return totAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计出账金额
     */
    public void setTotAmt(BigDecimal totAmt) {
        this.totAmt = totAmt;
    }

    /**
     * DECIMAL(16,2) 必填<br>
     * 获得 合同金额
     */
    public BigDecimal getAmt() {
        return amt;
    }

    /**
     * DECIMAL(16,2) 必填<br>
     * 设置 合同金额
     */
    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 审批中出账金额
     */
    public BigDecimal getRemainAmt() {
        return remainAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 审批中出账金额
     */
    public void setRemainAmt(BigDecimal remainAmt) {
        this.remainAmt = remainAmt;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 授信客户/买方名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 授信客户/买方名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 收货人电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 收货人电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 收货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 收货地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 收货人传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 收货人传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * CHAR(6)<br>
     * 获得 收货人邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * CHAR(6)<br>
     * 设置 收货人邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * VARCHAR(12)<br>
     * 获得 收货人开户行号
     */
    public String getBank() {
        return bank;
    }

    /**
     * VARCHAR(12)<br>
     * 设置 收货人开户行号
     */
    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 核心厂商/上游厂商客户号
     */
    public String getSecCustcd() {
        return secCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 核心厂商/上游厂商客户号
     */
    public void setSecCustcd(String secCustcd) {
        this.secCustcd = secCustcd == null ? null : secCustcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 核心厂商/上游厂商名称
     */
    public String getSecCname() {
        return secCname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 核心厂商/上游厂商名称
     */
    public void setSecCname(String secCname) {
        this.secCname = secCname == null ? null : secCname.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 上游厂商联系电话
     */
    public String getSecTel() {
        return secTel;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 上游厂商联系电话
     */
    public void setSecTel(String secTel) {
        this.secTel = secTel == null ? null : secTel.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 上游厂商地址
     */
    public String getSecAddress() {
        return secAddress;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 上游厂商地址
     */
    public void setSecAddress(String secAddress) {
        this.secAddress = secAddress == null ? null : secAddress.trim();
    }

    /**
     * VARCHAR(12)<br>
     * 获得 上游厂商开户行号
     */
    public String getSecBank() {
        return secBank;
    }

    /**
     * VARCHAR(12)<br>
     * 设置 上游厂商开户行号
     */
    public void setSecBank(String secBank) {
        this.secBank = secBank == null ? null : secBank.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 上游厂商传真
     */
    public String getSecFax() {
        return secFax;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 上游厂商传真
     */
    public void setSecFax(String secFax) {
        this.secFax = secFax == null ? null : secFax.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 上游厂商开户行名
     */
    public String getSecBankName() {
        return secBankName;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 上游厂商开户行名
     */
    public void setSecBankName(String secBankName) {
        this.secBankName = secBankName == null ? null : secBankName.trim();
    }

    /**
     * CHAR(6)<br>
     * 获得 上游厂商邮编
     */
    public String getSecPostcode() {
        return secPostcode;
    }

    /**
     * CHAR(6)<br>
     * 设置 上游厂商邮编
     */
    public void setSecPostcode(String secPostcode) {
        this.secPostcode = secPostcode == null ? null : secPostcode.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 保证金账号
     */
    public String getBailAccount() {
        return bailAccount;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 保证金账号
     */
    public void setBailAccount(String bailAccount) {
        this.bailAccount = bailAccount == null ? null : bailAccount.trim();
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
     * DECIMAL(5,2)<br>
     * 获得 保证金比例
     */
    public BigDecimal getBailRate() {
        return bailRate;
    }

    /**
     * DECIMAL(5,2)<br>
     * 设置 保证金比例
     */
    public void setBailRate(BigDecimal bailRate) {
        this.bailRate = bailRate;
    }

    /**
     * VARCHAR(150)<br>
     * 获得 交货方式
     */
    public String getTransportType() {
        return transportType;
    }

    /**
     * VARCHAR(150)<br>
     * 设置 交货方式
     */
    public void setTransportType(String transportType) {
        this.transportType = transportType == null ? null : transportType.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 授信客户地址
     */
    public String getEffectiveAddress() {
        return effectiveAddress;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 授信客户地址
     */
    public void setEffectiveAddress(String effectiveAddress) {
        this.effectiveAddress = effectiveAddress == null ? null : effectiveAddress.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 其他费用
     */
    public BigDecimal getCostMoney() {
        return costMoney;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 其他费用
     */
    public void setCostMoney(BigDecimal costMoney) {
        this.costMoney = costMoney;
    }

    /**
     * VARCHAR(30)<br>
     * 获得 协议类型
     */
    public String getGuattype() {
        return guattype;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 协议类型
     */
    public void setGuattype(String guattype) {
        this.guattype = guattype == null ? null : guattype.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 客户经理/经办人
     */
    public String getTlrno() {
        return tlrno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 客户经理/经办人
     */
    public void setTlrno(String tlrno) {
        this.tlrno = tlrno == null ? null : tlrno.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 收货人
     */
    public String getFirName() {
        return firName;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 收货人
     */
    public void setFirName(String firName) {
        this.firName = firName == null ? null : firName.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 合同状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 合同状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 授信客户行业
     */
    public String getIndustryOne() {
        return industryOne;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 授信客户行业
     */
    public void setIndustryOne(String industryOne) {
        this.industryOne = industryOne == null ? null : industryOne.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 上游客户行业
     */
    public String getIndustryTwo() {
        return industryTwo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 上游客户行业
     */
    public void setIndustryTwo(String industryTwo) {
        this.industryTwo = industryTwo == null ? null : industryTwo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 扩展字段1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 扩展字段1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
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
     * VARCHAR(20)<br>
     * 获得 关联协议(担保提货协议/先票(款)后货协议)号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 关联协议(担保提货协议/先票(款)后货协议)号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getSupplyChainPdId() {
        return supplyChainPdId;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setSupplyChainPdId(String supplyChainPdId) {
        this.supplyChainPdId = supplyChainPdId == null ? null : supplyChainPdId.trim();
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
     * CHAR(1)<br>
     * 获得 渠道标识：1-供应链、2-企业网银
     */
    public String getChannelFlag() {
        return channelFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 渠道标识：1-供应链、2-企业网银
     */
    public void setChannelFlag(String channelFlag) {
        this.channelFlag = channelFlag == null ? null : channelFlag.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 累计提货金额
     */
    public BigDecimal getAccuDeliAmt() {
        return accuDeliAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 累计提货金额
     */
    public void setAccuDeliAmt(BigDecimal accuDeliAmt) {
        this.accuDeliAmt = accuDeliAmt;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 创建人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 获得 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 经办机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 经办机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(32)<br>
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tradeContno=").append(tradeContno);
        sb.append(", tradeContcode=").append(tradeContcode);
        sb.append(", mastContno=").append(mastContno);
        sb.append(", custcd=").append(custcd);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", curcd=").append(curcd);
        sb.append(", totAmt=").append(totAmt);
        sb.append(", amt=").append(amt);
        sb.append(", remainAmt=").append(remainAmt);
        sb.append(", cname=").append(cname);
        sb.append(", tel=").append(tel);
        sb.append(", address=").append(address);
        sb.append(", fax=").append(fax);
        sb.append(", postcode=").append(postcode);
        sb.append(", bank=").append(bank);
        sb.append(", secCustcd=").append(secCustcd);
        sb.append(", secCname=").append(secCname);
        sb.append(", secTel=").append(secTel);
        sb.append(", secAddress=").append(secAddress);
        sb.append(", secBank=").append(secBank);
        sb.append(", secFax=").append(secFax);
        sb.append(", secBankName=").append(secBankName);
        sb.append(", secPostcode=").append(secPostcode);
        sb.append(", bailAccount=").append(bailAccount);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", bailRate=").append(bailRate);
        sb.append(", transportType=").append(transportType);
        sb.append(", effectiveAddress=").append(effectiveAddress);
        sb.append(", costMoney=").append(costMoney);
        sb.append(", guattype=").append(guattype);
        sb.append(", tlrno=").append(tlrno);
        sb.append(", firName=").append(firName);
        sb.append(", status=").append(status);
        sb.append(", industryOne=").append(industryOne);
        sb.append(", industryTwo=").append(industryTwo);
        sb.append(", ext1=").append(ext1);
        sb.append(", memo=").append(memo);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", supplyChainPdId=").append(supplyChainPdId);
        sb.append(", ebankAppno=").append(ebankAppno);
        sb.append(", channelFlag=").append(channelFlag);
        sb.append(", accuDeliAmt=").append(accuDeliAmt);
        sb.append(", appno=").append(appno);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", crtTime=").append(crtTime);
        sb.append(", brcode=").append(brcode);
        sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
        sb.append(", lastUpdTime=").append(lastUpdTime);
        sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
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
        BCntBuyInfo other = (BCntBuyInfo) that;
        return (this.getTradeContno() == null ? other.getTradeContno() == null : this.getTradeContno().equals(other.getTradeContno()))
            && (this.getTradeContcode() == null ? other.getTradeContcode() == null : this.getTradeContcode().equals(other.getTradeContcode()))
            && (this.getMastContno() == null ? other.getMastContno() == null : this.getMastContno().equals(other.getMastContno()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getTotAmt() == null ? other.getTotAmt() == null : this.getTotAmt().equals(other.getTotAmt()))
            && (this.getAmt() == null ? other.getAmt() == null : this.getAmt().equals(other.getAmt()))
            && (this.getRemainAmt() == null ? other.getRemainAmt() == null : this.getRemainAmt().equals(other.getRemainAmt()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getPostcode() == null ? other.getPostcode() == null : this.getPostcode().equals(other.getPostcode()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getSecCustcd() == null ? other.getSecCustcd() == null : this.getSecCustcd().equals(other.getSecCustcd()))
            && (this.getSecCname() == null ? other.getSecCname() == null : this.getSecCname().equals(other.getSecCname()))
            && (this.getSecTel() == null ? other.getSecTel() == null : this.getSecTel().equals(other.getSecTel()))
            && (this.getSecAddress() == null ? other.getSecAddress() == null : this.getSecAddress().equals(other.getSecAddress()))
            && (this.getSecBank() == null ? other.getSecBank() == null : this.getSecBank().equals(other.getSecBank()))
            && (this.getSecFax() == null ? other.getSecFax() == null : this.getSecFax().equals(other.getSecFax()))
            && (this.getSecBankName() == null ? other.getSecBankName() == null : this.getSecBankName().equals(other.getSecBankName()))
            && (this.getSecPostcode() == null ? other.getSecPostcode() == null : this.getSecPostcode().equals(other.getSecPostcode()))
            && (this.getBailAccount() == null ? other.getBailAccount() == null : this.getBailAccount().equals(other.getBailAccount()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getBailRate() == null ? other.getBailRate() == null : this.getBailRate().equals(other.getBailRate()))
            && (this.getTransportType() == null ? other.getTransportType() == null : this.getTransportType().equals(other.getTransportType()))
            && (this.getEffectiveAddress() == null ? other.getEffectiveAddress() == null : this.getEffectiveAddress().equals(other.getEffectiveAddress()))
            && (this.getCostMoney() == null ? other.getCostMoney() == null : this.getCostMoney().equals(other.getCostMoney()))
            && (this.getGuattype() == null ? other.getGuattype() == null : this.getGuattype().equals(other.getGuattype()))
            && (this.getTlrno() == null ? other.getTlrno() == null : this.getTlrno().equals(other.getTlrno()))
            && (this.getFirName() == null ? other.getFirName() == null : this.getFirName().equals(other.getFirName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIndustryOne() == null ? other.getIndustryOne() == null : this.getIndustryOne().equals(other.getIndustryOne()))
            && (this.getIndustryTwo() == null ? other.getIndustryTwo() == null : this.getIndustryTwo().equals(other.getIndustryTwo()))
            && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getSupplyChainPdId() == null ? other.getSupplyChainPdId() == null : this.getSupplyChainPdId().equals(other.getSupplyChainPdId()))
            && (this.getEbankAppno() == null ? other.getEbankAppno() == null : this.getEbankAppno().equals(other.getEbankAppno()))
            && (this.getChannelFlag() == null ? other.getChannelFlag() == null : this.getChannelFlag().equals(other.getChannelFlag()))
            && (this.getAccuDeliAmt() == null ? other.getAccuDeliAmt() == null : this.getAccuDeliAmt().equals(other.getAccuDeliAmt()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTradeContno() == null) ? 0 : getTradeContno().hashCode());
        result = prime * result + ((getTradeContcode() == null) ? 0 : getTradeContcode().hashCode());
        result = prime * result + ((getMastContno() == null) ? 0 : getMastContno().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getTotAmt() == null) ? 0 : getTotAmt().hashCode());
        result = prime * result + ((getAmt() == null) ? 0 : getAmt().hashCode());
        result = prime * result + ((getRemainAmt() == null) ? 0 : getRemainAmt().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getPostcode() == null) ? 0 : getPostcode().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getSecCustcd() == null) ? 0 : getSecCustcd().hashCode());
        result = prime * result + ((getSecCname() == null) ? 0 : getSecCname().hashCode());
        result = prime * result + ((getSecTel() == null) ? 0 : getSecTel().hashCode());
        result = prime * result + ((getSecAddress() == null) ? 0 : getSecAddress().hashCode());
        result = prime * result + ((getSecBank() == null) ? 0 : getSecBank().hashCode());
        result = prime * result + ((getSecFax() == null) ? 0 : getSecFax().hashCode());
        result = prime * result + ((getSecBankName() == null) ? 0 : getSecBankName().hashCode());
        result = prime * result + ((getSecPostcode() == null) ? 0 : getSecPostcode().hashCode());
        result = prime * result + ((getBailAccount() == null) ? 0 : getBailAccount().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getBailRate() == null) ? 0 : getBailRate().hashCode());
        result = prime * result + ((getTransportType() == null) ? 0 : getTransportType().hashCode());
        result = prime * result + ((getEffectiveAddress() == null) ? 0 : getEffectiveAddress().hashCode());
        result = prime * result + ((getCostMoney() == null) ? 0 : getCostMoney().hashCode());
        result = prime * result + ((getGuattype() == null) ? 0 : getGuattype().hashCode());
        result = prime * result + ((getTlrno() == null) ? 0 : getTlrno().hashCode());
        result = prime * result + ((getFirName() == null) ? 0 : getFirName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIndustryOne() == null) ? 0 : getIndustryOne().hashCode());
        result = prime * result + ((getIndustryTwo() == null) ? 0 : getIndustryTwo().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getSupplyChainPdId() == null) ? 0 : getSupplyChainPdId().hashCode());
        result = prime * result + ((getEbankAppno() == null) ? 0 : getEbankAppno().hashCode());
        result = prime * result + ((getChannelFlag() == null) ? 0 : getChannelFlag().hashCode());
        result = prime * result + ((getAccuDeliAmt() == null) ? 0 : getAccuDeliAmt().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}