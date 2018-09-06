package com.huateng.scf.bas.pbc.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BPbcMtgPriceHis implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20)<br>
     * 押品编号
     */
    private String mortgageNo;

    /**
     * VARCHAR(20)<br>
     * 申请号
     */
    private String 申请号;

    /**
     * CHAR(8)<br>
     * 交易日期
     */
    private String txdate;

    /**
     * CHAR(2)<br>
     * 
     */
    private String priceWay;

    /**
     * VARCHAR(80)<br>
     * 
     */
    private String evalOrg;

    /**
     * CHAR(8)<br>
     * 
     */
    private String evalTime;

    /**
     * CHAR(3)<br>
     * 币种
     */
    private String curcd;

    /**
     * DECIMAL(16,2)<br>
     * 价格
     */
    private BigDecimal price;

    /**
     * VARCHAR(32)<br>
     * 登记人
     */
    private String tlrcd;

    /**
     * CHAR(2)<br>
     * 
     */
    private String priceBasis;

    /**
     * CHAR(2)<br>
     * 价格来源
     */
    private String priceSource;

    /**
     * VARCHAR(256)<br>
     * 描述
     */
    private String description;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal priceOld;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal priceNew;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String ext1;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String ext2;

    /**
     * VARCHAR(200)<br>
     * 
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
     * 获得 押品编号
     */
    public String getMortgageNo() {
        return mortgageNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 押品编号
     */
    public void setMortgageNo(String mortgageNo) {
        this.mortgageNo = mortgageNo == null ? null : mortgageNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 申请号
     */
    public String get申请号() {
        return 申请号;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请号
     */
    public void set申请号(String 申请号) {
        this.申请号 = 申请号 == null ? null : 申请号.trim();
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
     * CHAR(2)<br>
     */
    public String getPriceWay() {
        return priceWay;
    }

    /**
     * CHAR(2)<br>
     */
    public void setPriceWay(String priceWay) {
        this.priceWay = priceWay == null ? null : priceWay.trim();
    }

    /**
     * VARCHAR(80)<br>
     */
    public String getEvalOrg() {
        return evalOrg;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setEvalOrg(String evalOrg) {
        this.evalOrg = evalOrg == null ? null : evalOrg.trim();
    }

    /**
     * CHAR(8)<br>
     */
    public String getEvalTime() {
        return evalTime;
    }

    /**
     * CHAR(8)<br>
     */
    public void setEvalTime(String evalTime) {
        this.evalTime = evalTime == null ? null : evalTime.trim();
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
     * 获得 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
     * CHAR(2)<br>
     */
    public String getPriceBasis() {
        return priceBasis;
    }

    /**
     * CHAR(2)<br>
     */
    public void setPriceBasis(String priceBasis) {
        this.priceBasis = priceBasis == null ? null : priceBasis.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 价格来源
     */
    public String getPriceSource() {
        return priceSource;
    }

    /**
     * CHAR(2)<br>
     * 设置 价格来源
     */
    public void setPriceSource(String priceSource) {
        this.priceSource = priceSource == null ? null : priceSource.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getPriceOld() {
        return priceOld;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setPriceOld(BigDecimal priceOld) {
        this.priceOld = priceOld;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getPriceNew() {
        return priceNew;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setPriceNew(BigDecimal priceNew) {
        this.priceNew = priceNew;
    }

    /**
     * VARCHAR(50)<br>
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * VARCHAR(50)<br>
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * VARCHAR(200)<br>
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * VARCHAR(200)<br>
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
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", 申请号=").append(申请号);
        sb.append(", txdate=").append(txdate);
        sb.append(", priceWay=").append(priceWay);
        sb.append(", evalOrg=").append(evalOrg);
        sb.append(", evalTime=").append(evalTime);
        sb.append(", curcd=").append(curcd);
        sb.append(", price=").append(price);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", priceBasis=").append(priceBasis);
        sb.append(", priceSource=").append(priceSource);
        sb.append(", description=").append(description);
        sb.append(", priceOld=").append(priceOld);
        sb.append(", priceNew=").append(priceNew);
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
        BPbcMtgPriceHis other = (BPbcMtgPriceHis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.get申请号() == null ? other.get申请号() == null : this.get申请号().equals(other.get申请号()))
            && (this.getTxdate() == null ? other.getTxdate() == null : this.getTxdate().equals(other.getTxdate()))
            && (this.getPriceWay() == null ? other.getPriceWay() == null : this.getPriceWay().equals(other.getPriceWay()))
            && (this.getEvalOrg() == null ? other.getEvalOrg() == null : this.getEvalOrg().equals(other.getEvalOrg()))
            && (this.getEvalTime() == null ? other.getEvalTime() == null : this.getEvalTime().equals(other.getEvalTime()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getPriceBasis() == null ? other.getPriceBasis() == null : this.getPriceBasis().equals(other.getPriceBasis()))
            && (this.getPriceSource() == null ? other.getPriceSource() == null : this.getPriceSource().equals(other.getPriceSource()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getPriceOld() == null ? other.getPriceOld() == null : this.getPriceOld().equals(other.getPriceOld()))
            && (this.getPriceNew() == null ? other.getPriceNew() == null : this.getPriceNew().equals(other.getPriceNew()))
            && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
            && (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
            && (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((get申请号() == null) ? 0 : get申请号().hashCode());
        result = prime * result + ((getTxdate() == null) ? 0 : getTxdate().hashCode());
        result = prime * result + ((getPriceWay() == null) ? 0 : getPriceWay().hashCode());
        result = prime * result + ((getEvalOrg() == null) ? 0 : getEvalOrg().hashCode());
        result = prime * result + ((getEvalTime() == null) ? 0 : getEvalTime().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getPriceBasis() == null) ? 0 : getPriceBasis().hashCode());
        result = prime * result + ((getPriceSource() == null) ? 0 : getPriceSource().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getPriceOld() == null) ? 0 : getPriceOld().hashCode());
        result = prime * result + ((getPriceNew() == null) ? 0 : getPriceNew().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
        result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
        result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
        return result;
    }
}