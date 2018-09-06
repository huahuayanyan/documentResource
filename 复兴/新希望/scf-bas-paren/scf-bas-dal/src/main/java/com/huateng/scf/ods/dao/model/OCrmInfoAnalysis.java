package com.huateng.scf.ods.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OCrmInfoAnalysis implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * ID
     */
    private String id;

    /**
     * VARCHAR(15) 必填<br>
     * 客户编号
     */
    private String custcd;

    /**
     * VARCHAR(80)<br>
     * 客户名称
     */
    private String cname;

    /**
     * CHAR(8) 必填<br>
     * 创建日期
     */
    private String createDate;

    /**
     * VARCHAR(20)<br>
     * 行业
     */
    private String industryType;

    /**
     * CHAR(8)<br>
     * ERP数据开通时间
     */
    private String openDate;

    /**
     * DECIMAL(16,2)<br>
     * 年度销售额
     */
    private BigDecimal annualSalesAmt;

    /**
     * DECIMAL(16,2)<br>
     * 相对销售占比
     */
    private BigDecimal salesRate;

    /**
     * DECIMAL(16,2)<br>
     * 年度采购额
     */
    private BigDecimal annualPurchaseAmt;

    /**
     * DECIMAL(16,2)<br>
     * 相对采购占比
     */
    private BigDecimal purchaseRate;

    /**
     * DECIMAL(16,2)<br>
     * 年度应收账数
     */
    private BigDecimal annualRec;

    /**
     * DECIMAL(16,2)<br>
     * 逾期比例
     */
    private BigDecimal overdueRate;

    /**
     * DECIMAL(16,2)<br>
     * 平均账龄
     */
    private BigDecimal averageAge;

    /**
     * DECIMAL(16,2)<br>
     * 年度应付账数
     */
    private BigDecimal annualPay;

    /**
     * DECIMAL(16,2)<br>
     * 利润率
     */
    private BigDecimal profitRate;

    /**
     * DECIMAL(16,2)<br>
     * ERP使用比率
     */
    private BigDecimal erpUsedRate;

    /**
     * DECIMAL(16,2)<br>
     * 紧密关系
     */
    private BigDecimal relation;

    /**
     * DECIMAL(16,2)<br>
     * 质量环境稳固
     */
    private BigDecimal qualityEnvir;

    /**
     * DECIMAL(16,2)<br>
     * 销售利润率
     */
    private BigDecimal salesProfitRate;

    /**
     * DECIMAL(16,2)<br>
     * 年增长趋势
     */
    private BigDecimal annuanGrowth;

    /**
     * DECIMAL(16,2)<br>
     * 上季度资金销售活跃率
     */
    private BigDecimal lastquaSaleActiveRate;

    /**
     * DECIMAL(16,2)<br>
     * 上季度资金采购活跃率
     */
    private BigDecimal lastquaPuaActiveRate;

    /**
     * DECIMAL(16,2)<br>
     * 上季度资金入账活跃率
     */
    private BigDecimal lastquaInActiveRate;

    /**
     * DECIMAL(16,2)<br>
     * 上季度资金出账活跃率
     */
    private BigDecimal lastquaOutActiveRate;

    /**
     * DECIMAL(16,2)<br>
     * 存款我行占比
     */
    private BigDecimal depositMyRate;

    /**
     * DECIMAL(10)<br>
     * 信贷比率
     */
    private BigDecimal creditRate;

    /**
     * DECIMAL(16,2)<br>
     * 信贷我行占比
     */
    private BigDecimal creditMyRate;

    /**
     * DECIMAL(16,2)<br>
     * 三个月日均资产
     */
    private BigDecimal threemDaliyAssets;

    /**
     * DECIMAL(16,2)<br>
     * 三个月日均存款
     */
    private BigDecimal threemDaliyDeposit;

    /**
     * DECIMAL(16,2)<br>
     * 时点资产
     */
    private BigDecimal assets;

    /**
     * DECIMAL(16,2)<br>
     * 时点存款
     */
    private BigDecimal deposit;

    /**
     * DECIMAL(16,2)<br>
     * 三个月日均贷款（表内）
     */
    private BigDecimal threemDaliyLoanIn;

    /**
     * DECIMAL(16,2)<br>
     * 三个月日均贷款（表外）
     */
    private BigDecimal threemDaliyLoanOut;

    /**
     * DECIMAL(16,2)<br>
     * 逾期金额
     */
    private BigDecimal overdueAmount;

    /**
     * DECIMAL(16,2)<br>
     * 本息损失
     */
    private BigDecimal principalLossAmt;

    /**
     * DECIMAL(16,2)<br>
     * 保证金覆盖率
     */
    private BigDecimal marginCoverRate;

    /**
     * DECIMAL(16,2)<br>
     * 销售增长率
     */
    private BigDecimal saleGrowthRate;

    /**
     * DECIMAL(16,2)<br>
     * 应收帐款占比
     */
    private BigDecimal recRate;

    /**
     * DECIMAL(16,2)<br>
     * 预付款占比
     */
    private BigDecimal prepayRate;

    /**
     * DECIMAL(16,2)<br>
     * 坏账率
     */
    private BigDecimal badRate;

    /**
     * DECIMAL(16,2)<br>
     * 总贷款额
     */
    private BigDecimal totalLoanAmt;

    /**
     * DECIMAL(16,2)<br>
     * 已还款额
     */
    private BigDecimal repaymentAmt;

    /**
     * DECIMAL(16,2)<br>
     * 逾期笔数
     */
    private BigDecimal overdueNum;

    /**
     * DECIMAL(16,2)<br>
     * 损失金额
     */
    private BigDecimal lossAmt;

    /**
     * DECIMAL(16,2)<br>
     * 总通道费用
     */
    private BigDecimal totalChanFee;

    /**
     * DECIMAL(16,2)<br>
     * 总收益
     */
    private BigDecimal totalIncome;

    /**
     * DECIMAL(16,2)<br>
     * 备用字段1
     */
    private BigDecimal ext1;

    /**
     * DECIMAL(16,2)<br>
     * 备用字段2
     */
    private BigDecimal ext2;

    /**
     * VARCHAR(50)<br>
     * 备用字段3
     */
    private String ext3;

    /**
     * VARCHAR(200)<br>
     * 备用字段4
     */
    private String ext4;

    /**
     * VARCHAR(128)<br>
     * 行业名称
     */
    private String industryTypeName;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 ID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 客户编号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 客户编号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 客户名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 客户名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * CHAR(8) 必填<br>
     * 获得 创建日期
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * CHAR(8) 必填<br>
     * 设置 创建日期
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 行业
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 行业
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType == null ? null : industryType.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 ERP数据开通时间
     */
    public String getOpenDate() {
        return openDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 ERP数据开通时间
     */
    public void setOpenDate(String openDate) {
        this.openDate = openDate == null ? null : openDate.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 年度销售额
     */
    public BigDecimal getAnnualSalesAmt() {
        return annualSalesAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 年度销售额
     */
    public void setAnnualSalesAmt(BigDecimal annualSalesAmt) {
        this.annualSalesAmt = annualSalesAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 相对销售占比
     */
    public BigDecimal getSalesRate() {
        return salesRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 相对销售占比
     */
    public void setSalesRate(BigDecimal salesRate) {
        this.salesRate = salesRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 年度采购额
     */
    public BigDecimal getAnnualPurchaseAmt() {
        return annualPurchaseAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 年度采购额
     */
    public void setAnnualPurchaseAmt(BigDecimal annualPurchaseAmt) {
        this.annualPurchaseAmt = annualPurchaseAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 相对采购占比
     */
    public BigDecimal getPurchaseRate() {
        return purchaseRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 相对采购占比
     */
    public void setPurchaseRate(BigDecimal purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 年度应收账数
     */
    public BigDecimal getAnnualRec() {
        return annualRec;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 年度应收账数
     */
    public void setAnnualRec(BigDecimal annualRec) {
        this.annualRec = annualRec;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 逾期比例
     */
    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 逾期比例
     */
    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 平均账龄
     */
    public BigDecimal getAverageAge() {
        return averageAge;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 平均账龄
     */
    public void setAverageAge(BigDecimal averageAge) {
        this.averageAge = averageAge;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 年度应付账数
     */
    public BigDecimal getAnnualPay() {
        return annualPay;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 年度应付账数
     */
    public void setAnnualPay(BigDecimal annualPay) {
        this.annualPay = annualPay;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 利润率
     */
    public BigDecimal getProfitRate() {
        return profitRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 利润率
     */
    public void setProfitRate(BigDecimal profitRate) {
        this.profitRate = profitRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 ERP使用比率
     */
    public BigDecimal getErpUsedRate() {
        return erpUsedRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 ERP使用比率
     */
    public void setErpUsedRate(BigDecimal erpUsedRate) {
        this.erpUsedRate = erpUsedRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 紧密关系
     */
    public BigDecimal getRelation() {
        return relation;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 紧密关系
     */
    public void setRelation(BigDecimal relation) {
        this.relation = relation;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 质量环境稳固
     */
    public BigDecimal getQualityEnvir() {
        return qualityEnvir;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 质量环境稳固
     */
    public void setQualityEnvir(BigDecimal qualityEnvir) {
        this.qualityEnvir = qualityEnvir;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 销售利润率
     */
    public BigDecimal getSalesProfitRate() {
        return salesProfitRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 销售利润率
     */
    public void setSalesProfitRate(BigDecimal salesProfitRate) {
        this.salesProfitRate = salesProfitRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 年增长趋势
     */
    public BigDecimal getAnnuanGrowth() {
        return annuanGrowth;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 年增长趋势
     */
    public void setAnnuanGrowth(BigDecimal annuanGrowth) {
        this.annuanGrowth = annuanGrowth;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 上季度资金销售活跃率
     */
    public BigDecimal getLastquaSaleActiveRate() {
        return lastquaSaleActiveRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 上季度资金销售活跃率
     */
    public void setLastquaSaleActiveRate(BigDecimal lastquaSaleActiveRate) {
        this.lastquaSaleActiveRate = lastquaSaleActiveRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 上季度资金采购活跃率
     */
    public BigDecimal getLastquaPuaActiveRate() {
        return lastquaPuaActiveRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 上季度资金采购活跃率
     */
    public void setLastquaPuaActiveRate(BigDecimal lastquaPuaActiveRate) {
        this.lastquaPuaActiveRate = lastquaPuaActiveRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 上季度资金入账活跃率
     */
    public BigDecimal getLastquaInActiveRate() {
        return lastquaInActiveRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 上季度资金入账活跃率
     */
    public void setLastquaInActiveRate(BigDecimal lastquaInActiveRate) {
        this.lastquaInActiveRate = lastquaInActiveRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 上季度资金出账活跃率
     */
    public BigDecimal getLastquaOutActiveRate() {
        return lastquaOutActiveRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 上季度资金出账活跃率
     */
    public void setLastquaOutActiveRate(BigDecimal lastquaOutActiveRate) {
        this.lastquaOutActiveRate = lastquaOutActiveRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 存款我行占比
     */
    public BigDecimal getDepositMyRate() {
        return depositMyRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 存款我行占比
     */
    public void setDepositMyRate(BigDecimal depositMyRate) {
        this.depositMyRate = depositMyRate;
    }

    /**
     * DECIMAL(10)<br>
     * 获得 信贷比率
     */
    public BigDecimal getCreditRate() {
        return creditRate;
    }

    /**
     * DECIMAL(10)<br>
     * 设置 信贷比率
     */
    public void setCreditRate(BigDecimal creditRate) {
        this.creditRate = creditRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 信贷我行占比
     */
    public BigDecimal getCreditMyRate() {
        return creditMyRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 信贷我行占比
     */
    public void setCreditMyRate(BigDecimal creditMyRate) {
        this.creditMyRate = creditMyRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 三个月日均资产
     */
    public BigDecimal getThreemDaliyAssets() {
        return threemDaliyAssets;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 三个月日均资产
     */
    public void setThreemDaliyAssets(BigDecimal threemDaliyAssets) {
        this.threemDaliyAssets = threemDaliyAssets;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 三个月日均存款
     */
    public BigDecimal getThreemDaliyDeposit() {
        return threemDaliyDeposit;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 三个月日均存款
     */
    public void setThreemDaliyDeposit(BigDecimal threemDaliyDeposit) {
        this.threemDaliyDeposit = threemDaliyDeposit;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 时点资产
     */
    public BigDecimal getAssets() {
        return assets;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 时点资产
     */
    public void setAssets(BigDecimal assets) {
        this.assets = assets;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 时点存款
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 时点存款
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 三个月日均贷款（表内）
     */
    public BigDecimal getThreemDaliyLoanIn() {
        return threemDaliyLoanIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 三个月日均贷款（表内）
     */
    public void setThreemDaliyLoanIn(BigDecimal threemDaliyLoanIn) {
        this.threemDaliyLoanIn = threemDaliyLoanIn;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 三个月日均贷款（表外）
     */
    public BigDecimal getThreemDaliyLoanOut() {
        return threemDaliyLoanOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 三个月日均贷款（表外）
     */
    public void setThreemDaliyLoanOut(BigDecimal threemDaliyLoanOut) {
        this.threemDaliyLoanOut = threemDaliyLoanOut;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 逾期金额
     */
    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 逾期金额
     */
    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 本息损失
     */
    public BigDecimal getPrincipalLossAmt() {
        return principalLossAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 本息损失
     */
    public void setPrincipalLossAmt(BigDecimal principalLossAmt) {
        this.principalLossAmt = principalLossAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 保证金覆盖率
     */
    public BigDecimal getMarginCoverRate() {
        return marginCoverRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 保证金覆盖率
     */
    public void setMarginCoverRate(BigDecimal marginCoverRate) {
        this.marginCoverRate = marginCoverRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 销售增长率
     */
    public BigDecimal getSaleGrowthRate() {
        return saleGrowthRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 销售增长率
     */
    public void setSaleGrowthRate(BigDecimal saleGrowthRate) {
        this.saleGrowthRate = saleGrowthRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 应收帐款占比
     */
    public BigDecimal getRecRate() {
        return recRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 应收帐款占比
     */
    public void setRecRate(BigDecimal recRate) {
        this.recRate = recRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 预付款占比
     */
    public BigDecimal getPrepayRate() {
        return prepayRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 预付款占比
     */
    public void setPrepayRate(BigDecimal prepayRate) {
        this.prepayRate = prepayRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 坏账率
     */
    public BigDecimal getBadRate() {
        return badRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 坏账率
     */
    public void setBadRate(BigDecimal badRate) {
        this.badRate = badRate;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 总贷款额
     */
    public BigDecimal getTotalLoanAmt() {
        return totalLoanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 总贷款额
     */
    public void setTotalLoanAmt(BigDecimal totalLoanAmt) {
        this.totalLoanAmt = totalLoanAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已还款额
     */
    public BigDecimal getRepaymentAmt() {
        return repaymentAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已还款额
     */
    public void setRepaymentAmt(BigDecimal repaymentAmt) {
        this.repaymentAmt = repaymentAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 逾期笔数
     */
    public BigDecimal getOverdueNum() {
        return overdueNum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 逾期笔数
     */
    public void setOverdueNum(BigDecimal overdueNum) {
        this.overdueNum = overdueNum;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 损失金额
     */
    public BigDecimal getLossAmt() {
        return lossAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 损失金额
     */
    public void setLossAmt(BigDecimal lossAmt) {
        this.lossAmt = lossAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 总通道费用
     */
    public BigDecimal getTotalChanFee() {
        return totalChanFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 总通道费用
     */
    public void setTotalChanFee(BigDecimal totalChanFee) {
        this.totalChanFee = totalChanFee;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 总收益
     */
    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 总收益
     */
    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 备用字段1
     */
    public BigDecimal getExt1() {
        return ext1;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 备用字段1
     */
    public void setExt1(BigDecimal ext1) {
        this.ext1 = ext1;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 备用字段2
     */
    public BigDecimal getExt2() {
        return ext2;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 备用字段2
     */
    public void setExt2(BigDecimal ext2) {
        this.ext2 = ext2;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 备用字段3
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 备用字段3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 备用字段4
     */
    public String getExt4() {
        return ext4;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 备用字段4
     */
    public void setExt4(String ext4) {
        this.ext4 = ext4 == null ? null : ext4.trim();
    }

    /**
     * VARCHAR(128)<br>
     */
    public String getIndustryTypeName() {
        return industryTypeName;
    }

    /**
     * VARCHAR(128)<br>
     */
    public void setIndustryTypeName(String industryTypeName) {
        this.industryTypeName = industryTypeName == null ? null : industryTypeName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custcd=").append(custcd);
        sb.append(", cname=").append(cname);
        sb.append(", createDate=").append(createDate);
        sb.append(", industryType=").append(industryType);
        sb.append(", openDate=").append(openDate);
        sb.append(", annualSalesAmt=").append(annualSalesAmt);
        sb.append(", salesRate=").append(salesRate);
        sb.append(", annualPurchaseAmt=").append(annualPurchaseAmt);
        sb.append(", purchaseRate=").append(purchaseRate);
        sb.append(", annualRec=").append(annualRec);
        sb.append(", overdueRate=").append(overdueRate);
        sb.append(", averageAge=").append(averageAge);
        sb.append(", annualPay=").append(annualPay);
        sb.append(", profitRate=").append(profitRate);
        sb.append(", erpUsedRate=").append(erpUsedRate);
        sb.append(", relation=").append(relation);
        sb.append(", qualityEnvir=").append(qualityEnvir);
        sb.append(", salesProfitRate=").append(salesProfitRate);
        sb.append(", annuanGrowth=").append(annuanGrowth);
        sb.append(", lastquaSaleActiveRate=").append(lastquaSaleActiveRate);
        sb.append(", lastquaPuaActiveRate=").append(lastquaPuaActiveRate);
        sb.append(", lastquaInActiveRate=").append(lastquaInActiveRate);
        sb.append(", lastquaOutActiveRate=").append(lastquaOutActiveRate);
        sb.append(", depositMyRate=").append(depositMyRate);
        sb.append(", creditRate=").append(creditRate);
        sb.append(", creditMyRate=").append(creditMyRate);
        sb.append(", threemDaliyAssets=").append(threemDaliyAssets);
        sb.append(", threemDaliyDeposit=").append(threemDaliyDeposit);
        sb.append(", assets=").append(assets);
        sb.append(", deposit=").append(deposit);
        sb.append(", threemDaliyLoanIn=").append(threemDaliyLoanIn);
        sb.append(", threemDaliyLoanOut=").append(threemDaliyLoanOut);
        sb.append(", overdueAmount=").append(overdueAmount);
        sb.append(", principalLossAmt=").append(principalLossAmt);
        sb.append(", marginCoverRate=").append(marginCoverRate);
        sb.append(", saleGrowthRate=").append(saleGrowthRate);
        sb.append(", recRate=").append(recRate);
        sb.append(", prepayRate=").append(prepayRate);
        sb.append(", badRate=").append(badRate);
        sb.append(", totalLoanAmt=").append(totalLoanAmt);
        sb.append(", repaymentAmt=").append(repaymentAmt);
        sb.append(", overdueNum=").append(overdueNum);
        sb.append(", lossAmt=").append(lossAmt);
        sb.append(", totalChanFee=").append(totalChanFee);
        sb.append(", totalIncome=").append(totalIncome);
        sb.append(", ext1=").append(ext1);
        sb.append(", ext2=").append(ext2);
        sb.append(", ext3=").append(ext3);
        sb.append(", ext4=").append(ext4);
        sb.append(", industryTypeName=").append(industryTypeName);
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
        OCrmInfoAnalysis other = (OCrmInfoAnalysis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getIndustryType() == null ? other.getIndustryType() == null : this.getIndustryType().equals(other.getIndustryType()))
            && (this.getOpenDate() == null ? other.getOpenDate() == null : this.getOpenDate().equals(other.getOpenDate()))
            && (this.getAnnualSalesAmt() == null ? other.getAnnualSalesAmt() == null : this.getAnnualSalesAmt().equals(other.getAnnualSalesAmt()))
            && (this.getSalesRate() == null ? other.getSalesRate() == null : this.getSalesRate().equals(other.getSalesRate()))
            && (this.getAnnualPurchaseAmt() == null ? other.getAnnualPurchaseAmt() == null : this.getAnnualPurchaseAmt().equals(other.getAnnualPurchaseAmt()))
            && (this.getPurchaseRate() == null ? other.getPurchaseRate() == null : this.getPurchaseRate().equals(other.getPurchaseRate()))
            && (this.getAnnualRec() == null ? other.getAnnualRec() == null : this.getAnnualRec().equals(other.getAnnualRec()))
            && (this.getOverdueRate() == null ? other.getOverdueRate() == null : this.getOverdueRate().equals(other.getOverdueRate()))
            && (this.getAverageAge() == null ? other.getAverageAge() == null : this.getAverageAge().equals(other.getAverageAge()))
            && (this.getAnnualPay() == null ? other.getAnnualPay() == null : this.getAnnualPay().equals(other.getAnnualPay()))
            && (this.getProfitRate() == null ? other.getProfitRate() == null : this.getProfitRate().equals(other.getProfitRate()))
            && (this.getErpUsedRate() == null ? other.getErpUsedRate() == null : this.getErpUsedRate().equals(other.getErpUsedRate()))
            && (this.getRelation() == null ? other.getRelation() == null : this.getRelation().equals(other.getRelation()))
            && (this.getQualityEnvir() == null ? other.getQualityEnvir() == null : this.getQualityEnvir().equals(other.getQualityEnvir()))
            && (this.getSalesProfitRate() == null ? other.getSalesProfitRate() == null : this.getSalesProfitRate().equals(other.getSalesProfitRate()))
            && (this.getAnnuanGrowth() == null ? other.getAnnuanGrowth() == null : this.getAnnuanGrowth().equals(other.getAnnuanGrowth()))
            && (this.getLastquaSaleActiveRate() == null ? other.getLastquaSaleActiveRate() == null : this.getLastquaSaleActiveRate().equals(other.getLastquaSaleActiveRate()))
            && (this.getLastquaPuaActiveRate() == null ? other.getLastquaPuaActiveRate() == null : this.getLastquaPuaActiveRate().equals(other.getLastquaPuaActiveRate()))
            && (this.getLastquaInActiveRate() == null ? other.getLastquaInActiveRate() == null : this.getLastquaInActiveRate().equals(other.getLastquaInActiveRate()))
            && (this.getLastquaOutActiveRate() == null ? other.getLastquaOutActiveRate() == null : this.getLastquaOutActiveRate().equals(other.getLastquaOutActiveRate()))
            && (this.getDepositMyRate() == null ? other.getDepositMyRate() == null : this.getDepositMyRate().equals(other.getDepositMyRate()))
            && (this.getCreditRate() == null ? other.getCreditRate() == null : this.getCreditRate().equals(other.getCreditRate()))
            && (this.getCreditMyRate() == null ? other.getCreditMyRate() == null : this.getCreditMyRate().equals(other.getCreditMyRate()))
            && (this.getThreemDaliyAssets() == null ? other.getThreemDaliyAssets() == null : this.getThreemDaliyAssets().equals(other.getThreemDaliyAssets()))
            && (this.getThreemDaliyDeposit() == null ? other.getThreemDaliyDeposit() == null : this.getThreemDaliyDeposit().equals(other.getThreemDaliyDeposit()))
            && (this.getAssets() == null ? other.getAssets() == null : this.getAssets().equals(other.getAssets()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getThreemDaliyLoanIn() == null ? other.getThreemDaliyLoanIn() == null : this.getThreemDaliyLoanIn().equals(other.getThreemDaliyLoanIn()))
            && (this.getThreemDaliyLoanOut() == null ? other.getThreemDaliyLoanOut() == null : this.getThreemDaliyLoanOut().equals(other.getThreemDaliyLoanOut()))
            && (this.getOverdueAmount() == null ? other.getOverdueAmount() == null : this.getOverdueAmount().equals(other.getOverdueAmount()))
            && (this.getPrincipalLossAmt() == null ? other.getPrincipalLossAmt() == null : this.getPrincipalLossAmt().equals(other.getPrincipalLossAmt()))
            && (this.getMarginCoverRate() == null ? other.getMarginCoverRate() == null : this.getMarginCoverRate().equals(other.getMarginCoverRate()))
            && (this.getSaleGrowthRate() == null ? other.getSaleGrowthRate() == null : this.getSaleGrowthRate().equals(other.getSaleGrowthRate()))
            && (this.getRecRate() == null ? other.getRecRate() == null : this.getRecRate().equals(other.getRecRate()))
            && (this.getPrepayRate() == null ? other.getPrepayRate() == null : this.getPrepayRate().equals(other.getPrepayRate()))
            && (this.getBadRate() == null ? other.getBadRate() == null : this.getBadRate().equals(other.getBadRate()))
            && (this.getTotalLoanAmt() == null ? other.getTotalLoanAmt() == null : this.getTotalLoanAmt().equals(other.getTotalLoanAmt()))
            && (this.getRepaymentAmt() == null ? other.getRepaymentAmt() == null : this.getRepaymentAmt().equals(other.getRepaymentAmt()))
            && (this.getOverdueNum() == null ? other.getOverdueNum() == null : this.getOverdueNum().equals(other.getOverdueNum()))
            && (this.getLossAmt() == null ? other.getLossAmt() == null : this.getLossAmt().equals(other.getLossAmt()))
            && (this.getTotalChanFee() == null ? other.getTotalChanFee() == null : this.getTotalChanFee().equals(other.getTotalChanFee()))
            && (this.getTotalIncome() == null ? other.getTotalIncome() == null : this.getTotalIncome().equals(other.getTotalIncome()))
            && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
            && (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
            && (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
            && (this.getExt4() == null ? other.getExt4() == null : this.getExt4().equals(other.getExt4()))
            && (this.getIndustryTypeName() == null ? other.getIndustryTypeName() == null : this.getIndustryTypeName().equals(other.getIndustryTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getIndustryType() == null) ? 0 : getIndustryType().hashCode());
        result = prime * result + ((getOpenDate() == null) ? 0 : getOpenDate().hashCode());
        result = prime * result + ((getAnnualSalesAmt() == null) ? 0 : getAnnualSalesAmt().hashCode());
        result = prime * result + ((getSalesRate() == null) ? 0 : getSalesRate().hashCode());
        result = prime * result + ((getAnnualPurchaseAmt() == null) ? 0 : getAnnualPurchaseAmt().hashCode());
        result = prime * result + ((getPurchaseRate() == null) ? 0 : getPurchaseRate().hashCode());
        result = prime * result + ((getAnnualRec() == null) ? 0 : getAnnualRec().hashCode());
        result = prime * result + ((getOverdueRate() == null) ? 0 : getOverdueRate().hashCode());
        result = prime * result + ((getAverageAge() == null) ? 0 : getAverageAge().hashCode());
        result = prime * result + ((getAnnualPay() == null) ? 0 : getAnnualPay().hashCode());
        result = prime * result + ((getProfitRate() == null) ? 0 : getProfitRate().hashCode());
        result = prime * result + ((getErpUsedRate() == null) ? 0 : getErpUsedRate().hashCode());
        result = prime * result + ((getRelation() == null) ? 0 : getRelation().hashCode());
        result = prime * result + ((getQualityEnvir() == null) ? 0 : getQualityEnvir().hashCode());
        result = prime * result + ((getSalesProfitRate() == null) ? 0 : getSalesProfitRate().hashCode());
        result = prime * result + ((getAnnuanGrowth() == null) ? 0 : getAnnuanGrowth().hashCode());
        result = prime * result + ((getLastquaSaleActiveRate() == null) ? 0 : getLastquaSaleActiveRate().hashCode());
        result = prime * result + ((getLastquaPuaActiveRate() == null) ? 0 : getLastquaPuaActiveRate().hashCode());
        result = prime * result + ((getLastquaInActiveRate() == null) ? 0 : getLastquaInActiveRate().hashCode());
        result = prime * result + ((getLastquaOutActiveRate() == null) ? 0 : getLastquaOutActiveRate().hashCode());
        result = prime * result + ((getDepositMyRate() == null) ? 0 : getDepositMyRate().hashCode());
        result = prime * result + ((getCreditRate() == null) ? 0 : getCreditRate().hashCode());
        result = prime * result + ((getCreditMyRate() == null) ? 0 : getCreditMyRate().hashCode());
        result = prime * result + ((getThreemDaliyAssets() == null) ? 0 : getThreemDaliyAssets().hashCode());
        result = prime * result + ((getThreemDaliyDeposit() == null) ? 0 : getThreemDaliyDeposit().hashCode());
        result = prime * result + ((getAssets() == null) ? 0 : getAssets().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getThreemDaliyLoanIn() == null) ? 0 : getThreemDaliyLoanIn().hashCode());
        result = prime * result + ((getThreemDaliyLoanOut() == null) ? 0 : getThreemDaliyLoanOut().hashCode());
        result = prime * result + ((getOverdueAmount() == null) ? 0 : getOverdueAmount().hashCode());
        result = prime * result + ((getPrincipalLossAmt() == null) ? 0 : getPrincipalLossAmt().hashCode());
        result = prime * result + ((getMarginCoverRate() == null) ? 0 : getMarginCoverRate().hashCode());
        result = prime * result + ((getSaleGrowthRate() == null) ? 0 : getSaleGrowthRate().hashCode());
        result = prime * result + ((getRecRate() == null) ? 0 : getRecRate().hashCode());
        result = prime * result + ((getPrepayRate() == null) ? 0 : getPrepayRate().hashCode());
        result = prime * result + ((getBadRate() == null) ? 0 : getBadRate().hashCode());
        result = prime * result + ((getTotalLoanAmt() == null) ? 0 : getTotalLoanAmt().hashCode());
        result = prime * result + ((getRepaymentAmt() == null) ? 0 : getRepaymentAmt().hashCode());
        result = prime * result + ((getOverdueNum() == null) ? 0 : getOverdueNum().hashCode());
        result = prime * result + ((getLossAmt() == null) ? 0 : getLossAmt().hashCode());
        result = prime * result + ((getTotalChanFee() == null) ? 0 : getTotalChanFee().hashCode());
        result = prime * result + ((getTotalIncome() == null) ? 0 : getTotalIncome().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
        result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
        result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
        result = prime * result + ((getExt4() == null) ? 0 : getExt4().hashCode());
        result = prime * result + ((getIndustryTypeName() == null) ? 0 : getIndustryTypeName().hashCode());
        return result;
    }
}