package com.huateng.scf.bas.pbc.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BPbcMtgStorDeli implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 业务申请号
     */
    private String appno;

    /**
     * VARCHAR(20)<br>
     * 其他协议号
     */
    private String otherProtocolNo;

    /**
     * VARCHAR(20)<br>
     * 质押合同号
     */
    private String slaveContno;

    /**
     * VARCHAR(20)<br>
     * 监管合同号
     */
    private String monitorProtocolNo;

    /**
     * CHAR(8)<br>
     * 交易日期
     */
    private String txdate;

    /**
     * TIMESTAMP(11,6)<br>
     * 交易时间
     */
    private Date txtime;

    /**
     * CHAR(2)<br>
     * 押品交易类型：01-入库、02-出库、03-核价调价、04-换货、05-库存清单导入押品出入库信息
     */
    private String storOrDeli;

    /**
     * CHAR(2)<br>
     * 出入库业务类型
     */
    private String storDeliBizType;

    /**
     * DECIMAL(22)<br>
     * 押品业务编号
     */
    private BigDecimal mortgageBizNo;

    /**
     * VARCHAR(32)<br>
     * 登记人
     */
    private String tlrcd;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(16,2)<br>
     * 单价
     */
    private BigDecimal price;

    /**
     * DECIMAL(16,2)<br>
     * 数量/重量
     */
    private BigDecimal quantity;

    /**
     * DECIMAL(16,2)<br>
     * 总价
     */
    private BigDecimal totPrice;

    /**
     * VARCHAR(32)<br>
     * 仓单表主键
     */
    private String billno;

    /**
     * DECIMAL(16,2)<br>
     * 保证金金额
     */
    private BigDecimal bailAmount;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String bussType;

    /**
     * DECIMAL(16,2)<br>
     * 额度金额
     */
    private BigDecimal creditamt;

    /**
     * DECIMAL(16,2)<br>
     * 入库金额
     */
    private BigDecimal stockamt;

    /**
     * DECIMAL(16,2)<br>
     * 敞口金额
     */
    private BigDecimal riskamt;

    /**
     * DECIMAL(16,2)<br>
     * 监管下限
     */
    private BigDecimal lowPriceNew;

    /**
     * VARCHAR(100)<br>
     * 货区号
     */
    private String freightarea;

    /**
     * VARCHAR(100)<br>
     * 货位号
     */
    private String freightlot;

    /**
     * VARCHAR(100)<br>
     * 仓库名
     */
    private String warehouse;

    /**
     * VARCHAR(50)<br>
     * 重量单位
     */
    private String weightUnits;

    /**
     * VARCHAR(50)<br>
     * 押品单位
     */
    private String mortgageUnits;

    /**
     * VARCHAR(20)<br>
     * 操作机构
     */
    private String brcode;

    /**
     * VARCHAR(50)<br>
     * 扩展域1
     */
    private String ext1;

    /**
     * VARCHAR(100)<br>
     * 扩展域2
     */
    private String ext2;

    /**
     * VARCHAR(200)<br>
     * 扩展域3
     */
    private String ext3;

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
     * VARCHAR(20)<br>
     * 获得 业务申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 其他协议号
     */
    public String getOtherProtocolNo() {
        return otherProtocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 其他协议号
     */
    public void setOtherProtocolNo(String otherProtocolNo) {
        this.otherProtocolNo = otherProtocolNo == null ? null : otherProtocolNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 质押合同号
     */
    public String getSlaveContno() {
        return slaveContno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 质押合同号
     */
    public void setSlaveContno(String slaveContno) {
        this.slaveContno = slaveContno == null ? null : slaveContno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 监管合同号
     */
    public String getMonitorProtocolNo() {
        return monitorProtocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 监管合同号
     */
    public void setMonitorProtocolNo(String monitorProtocolNo) {
        this.monitorProtocolNo = monitorProtocolNo == null ? null : monitorProtocolNo.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 交易日期
     */
    public String getTxdate() {
        return txdate;
    }

    /**
     * CHAR(8)<br>
     * 设置 交易日期
     */
    public void setTxdate(String txdate) {
        this.txdate = txdate == null ? null : txdate.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 交易时间
     */
    public Date getTxtime() {
        return txtime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 交易时间
     */
    public void setTxtime(Date txtime) {
        this.txtime = txtime;
    }

    /**
     * CHAR(2)<br>
     * 获得 押品交易类型：01-入库、02-出库、03-核价调价、04-换货、05-库存清单导入押品出入库信息
     */
    public String getStorOrDeli() {
        return storOrDeli;
    }

    /**
     * CHAR(2)<br>
     * 设置 押品交易类型：01-入库、02-出库、03-核价调价、04-换货、05-库存清单导入押品出入库信息
     */
    public void setStorOrDeli(String storOrDeli) {
        this.storOrDeli = storOrDeli == null ? null : storOrDeli.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 出入库业务类型
     */
    public String getStorDeliBizType() {
        return storDeliBizType;
    }

    /**
     * CHAR(2)<br>
     * 设置 出入库业务类型
     */
    public void setStorDeliBizType(String storDeliBizType) {
        this.storDeliBizType = storDeliBizType == null ? null : storDeliBizType.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 押品业务编号
     */
    public BigDecimal getMortgageBizNo() {
        return mortgageBizNo;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 押品业务编号
     */
    public void setMortgageBizNo(BigDecimal mortgageBizNo) {
        this.mortgageBizNo = mortgageBizNo;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
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
     * DECIMAL(16,2)<br>
     * 获得 单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 数量/重量
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 数量/重量
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 总价
     */
    public BigDecimal getTotPrice() {
        return totPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 总价
     */
    public void setTotPrice(BigDecimal totPrice) {
        this.totPrice = totPrice;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 仓单表主键
     */
    public String getBillno() {
        return billno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 仓单表主键
     */
    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
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
     * VARCHAR(10)<br>
     * 获得 业务品种
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 业务品种
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 额度金额
     */
    public BigDecimal getCreditamt() {
        return creditamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 额度金额
     */
    public void setCreditamt(BigDecimal creditamt) {
        this.creditamt = creditamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 入库金额
     */
    public BigDecimal getStockamt() {
        return stockamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 入库金额
     */
    public void setStockamt(BigDecimal stockamt) {
        this.stockamt = stockamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 敞口金额
     */
    public BigDecimal getRiskamt() {
        return riskamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 敞口金额
     */
    public void setRiskamt(BigDecimal riskamt) {
        this.riskamt = riskamt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 监管下限
     */
    public BigDecimal getLowPriceNew() {
        return lowPriceNew;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 监管下限
     */
    public void setLowPriceNew(BigDecimal lowPriceNew) {
        this.lowPriceNew = lowPriceNew;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 货区号
     */
    public String getFreightarea() {
        return freightarea;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 货区号
     */
    public void setFreightarea(String freightarea) {
        this.freightarea = freightarea == null ? null : freightarea.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 货位号
     */
    public String getFreightlot() {
        return freightlot;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 货位号
     */
    public void setFreightlot(String freightlot) {
        this.freightlot = freightlot == null ? null : freightlot.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 仓库名
     */
    public String getWarehouse() {
        return warehouse;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 仓库名
     */
    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse == null ? null : warehouse.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 重量单位
     */
    public String getWeightUnits() {
        return weightUnits;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 重量单位
     */
    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits == null ? null : weightUnits.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 押品单位
     */
    public String getMortgageUnits() {
        return mortgageUnits;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 押品单位
     */
    public void setMortgageUnits(String mortgageUnits) {
        this.mortgageUnits = mortgageUnits == null ? null : mortgageUnits.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 操作机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 操作机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 扩展域1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 扩展域1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 扩展域2
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 扩展域2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 扩展域3
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 扩展域3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appno=").append(appno);
        sb.append(", otherProtocolNo=").append(otherProtocolNo);
        sb.append(", slaveContno=").append(slaveContno);
        sb.append(", monitorProtocolNo=").append(monitorProtocolNo);
        sb.append(", txdate=").append(txdate);
        sb.append(", txtime=").append(txtime);
        sb.append(", storOrDeli=").append(storOrDeli);
        sb.append(", storDeliBizType=").append(storDeliBizType);
        sb.append(", mortgageBizNo=").append(mortgageBizNo);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", curcd=").append(curcd);
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append(", totPrice=").append(totPrice);
        sb.append(", billno=").append(billno);
        sb.append(", bailAmount=").append(bailAmount);
        sb.append(", bussType=").append(bussType);
        sb.append(", creditamt=").append(creditamt);
        sb.append(", stockamt=").append(stockamt);
        sb.append(", riskamt=").append(riskamt);
        sb.append(", lowPriceNew=").append(lowPriceNew);
        sb.append(", freightarea=").append(freightarea);
        sb.append(", freightlot=").append(freightlot);
        sb.append(", warehouse=").append(warehouse);
        sb.append(", weightUnits=").append(weightUnits);
        sb.append(", mortgageUnits=").append(mortgageUnits);
        sb.append(", brcode=").append(brcode);
        sb.append(", ext1=").append(ext1);
        sb.append(", ext2=").append(ext2);
        sb.append(", ext3=").append(ext3);
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
        BPbcMtgStorDeli other = (BPbcMtgStorDeli) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getOtherProtocolNo() == null ? other.getOtherProtocolNo() == null : this.getOtherProtocolNo().equals(other.getOtherProtocolNo()))
            && (this.getSlaveContno() == null ? other.getSlaveContno() == null : this.getSlaveContno().equals(other.getSlaveContno()))
            && (this.getMonitorProtocolNo() == null ? other.getMonitorProtocolNo() == null : this.getMonitorProtocolNo().equals(other.getMonitorProtocolNo()))
            && (this.getTxdate() == null ? other.getTxdate() == null : this.getTxdate().equals(other.getTxdate()))
            && (this.getTxtime() == null ? other.getTxtime() == null : this.getTxtime().equals(other.getTxtime()))
            && (this.getStorOrDeli() == null ? other.getStorOrDeli() == null : this.getStorOrDeli().equals(other.getStorOrDeli()))
            && (this.getStorDeliBizType() == null ? other.getStorDeliBizType() == null : this.getStorDeliBizType().equals(other.getStorDeliBizType()))
            && (this.getMortgageBizNo() == null ? other.getMortgageBizNo() == null : this.getMortgageBizNo().equals(other.getMortgageBizNo()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getTotPrice() == null ? other.getTotPrice() == null : this.getTotPrice().equals(other.getTotPrice()))
            && (this.getBillno() == null ? other.getBillno() == null : this.getBillno().equals(other.getBillno()))
            && (this.getBailAmount() == null ? other.getBailAmount() == null : this.getBailAmount().equals(other.getBailAmount()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getCreditamt() == null ? other.getCreditamt() == null : this.getCreditamt().equals(other.getCreditamt()))
            && (this.getStockamt() == null ? other.getStockamt() == null : this.getStockamt().equals(other.getStockamt()))
            && (this.getRiskamt() == null ? other.getRiskamt() == null : this.getRiskamt().equals(other.getRiskamt()))
            && (this.getLowPriceNew() == null ? other.getLowPriceNew() == null : this.getLowPriceNew().equals(other.getLowPriceNew()))
            && (this.getFreightarea() == null ? other.getFreightarea() == null : this.getFreightarea().equals(other.getFreightarea()))
            && (this.getFreightlot() == null ? other.getFreightlot() == null : this.getFreightlot().equals(other.getFreightlot()))
            && (this.getWarehouse() == null ? other.getWarehouse() == null : this.getWarehouse().equals(other.getWarehouse()))
            && (this.getWeightUnits() == null ? other.getWeightUnits() == null : this.getWeightUnits().equals(other.getWeightUnits()))
            && (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
            && (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
            && (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getOtherProtocolNo() == null) ? 0 : getOtherProtocolNo().hashCode());
        result = prime * result + ((getSlaveContno() == null) ? 0 : getSlaveContno().hashCode());
        result = prime * result + ((getMonitorProtocolNo() == null) ? 0 : getMonitorProtocolNo().hashCode());
        result = prime * result + ((getTxdate() == null) ? 0 : getTxdate().hashCode());
        result = prime * result + ((getTxtime() == null) ? 0 : getTxtime().hashCode());
        result = prime * result + ((getStorOrDeli() == null) ? 0 : getStorOrDeli().hashCode());
        result = prime * result + ((getStorDeliBizType() == null) ? 0 : getStorDeliBizType().hashCode());
        result = prime * result + ((getMortgageBizNo() == null) ? 0 : getMortgageBizNo().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getTotPrice() == null) ? 0 : getTotPrice().hashCode());
        result = prime * result + ((getBillno() == null) ? 0 : getBillno().hashCode());
        result = prime * result + ((getBailAmount() == null) ? 0 : getBailAmount().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getCreditamt() == null) ? 0 : getCreditamt().hashCode());
        result = prime * result + ((getStockamt() == null) ? 0 : getStockamt().hashCode());
        result = prime * result + ((getRiskamt() == null) ? 0 : getRiskamt().hashCode());
        result = prime * result + ((getLowPriceNew() == null) ? 0 : getLowPriceNew().hashCode());
        result = prime * result + ((getFreightarea() == null) ? 0 : getFreightarea().hashCode());
        result = prime * result + ((getFreightlot() == null) ? 0 : getFreightlot().hashCode());
        result = prime * result + ((getWarehouse() == null) ? 0 : getWarehouse().hashCode());
        result = prime * result + ((getWeightUnits() == null) ? 0 : getWeightUnits().hashCode());
        result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
        result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
        result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
        return result;
    }
}