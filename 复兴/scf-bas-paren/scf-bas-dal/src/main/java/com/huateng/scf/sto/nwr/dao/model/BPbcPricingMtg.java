package com.huateng.scf.sto.nwr.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BPbcPricingMtg implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键ID
     */
    private String id;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String pid;

    /**
     * VARCHAR(20)<br>
     * 申请号
     */
    private String appno;

    /**
     * CHAR(4)<br>
     * 申请业务押品清单业务类型
     */
    private String appliMortBizType;

    /**
     * VARCHAR(20)<br>
     * 押品编号
     */
    private String mortgageNo;

    /**
     * VARCHAR(100)<br>
     * 质押物一级
     */
    private String mortgageLevelOne;

    /**
     * VARCHAR(100)<br>
     * 质押物二级
     */
    private String mortgageLevelTwo;

    /**
     * VARCHAR(100)<br>
     * 质押物三级
     */
    private String mortgageLevelThree;

    /**
     * VARCHAR(100)<br>
     * 质押物四级
     */
    private String mortgageLevelFour;

    /**
     * VARCHAR(100)<br>
     * 质押物五级
     */
    private String mortgageLevelFive;

    /**
     * VARCHAR(80)<br>
     * 品牌/厂家
     */
    private String vender;

    /**
     * VARCHAR(300)<br>
     * 产地
     */
    private String productArea;

    /**
     * VARCHAR(300)<br>
     * 仓库地址
     */
    private String warehouseAddress;

    /**
     * VARCHAR(100)<br>
     * 凭证号
     */
    private String billno;

    /**
     * CHAR(3)<br>
     * 押品单位
     */
    private String mortgageUnits;

    /**
     * DECIMAL(16,2)<br>
     * 数（重）量
     */
    private BigDecimal quantity;

    /**
     * DECIMAL(16,2)<br>
     * 原始核定价
     */
    private BigDecimal oldConfirmPrice;

    /**
     * DECIMAL(16,2)<br>
     * 核定单价
     */
    private BigDecimal confirmPrice;

    /**
     * DECIMAL(16,2)<br>
     * [成本价
     */
    private BigDecimal price;

    /**
     * DECIMAL(16,2)<br>
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * DECIMAL(16,2)<br>
     * 合同价
     */
    private BigDecimal contPrice;

    /**
     * VARCHAR(200)<br>
     * 核定依据
     */
    private String approveAccording;

    /**
     * VARCHAR(200)<br>
     * 核准依据
     */
    private String confirmAccording;

    /**
     * DECIMAL(16,2)<br>
     * 总价
     */
    private BigDecimal totPrice;

    /**
     * DECIMAL(16,2)<br>
     * 
     */
    private BigDecimal thirdPartyPrice;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getPid() {
        return pid;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 申请号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 申请号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * CHAR(4)<br>
     * 获得 申请业务押品清单业务类型
     */
    public String getAppliMortBizType() {
        return appliMortBizType;
    }

    /**
     * CHAR(4)<br>
     * 设置 申请业务押品清单业务类型
     */
    public void setAppliMortBizType(String appliMortBizType) {
        this.appliMortBizType = appliMortBizType == null ? null : appliMortBizType.trim();
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
     * VARCHAR(100)<br>
     * 获得 质押物一级
     */
    public String getMortgageLevelOne() {
        return mortgageLevelOne;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物一级
     */
    public void setMortgageLevelOne(String mortgageLevelOne) {
        this.mortgageLevelOne = mortgageLevelOne == null ? null : mortgageLevelOne.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物二级
     */
    public String getMortgageLevelTwo() {
        return mortgageLevelTwo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物二级
     */
    public void setMortgageLevelTwo(String mortgageLevelTwo) {
        this.mortgageLevelTwo = mortgageLevelTwo == null ? null : mortgageLevelTwo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物三级
     */
    public String getMortgageLevelThree() {
        return mortgageLevelThree;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物三级
     */
    public void setMortgageLevelThree(String mortgageLevelThree) {
        this.mortgageLevelThree = mortgageLevelThree == null ? null : mortgageLevelThree.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物四级
     */
    public String getMortgageLevelFour() {
        return mortgageLevelFour;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物四级
     */
    public void setMortgageLevelFour(String mortgageLevelFour) {
        this.mortgageLevelFour = mortgageLevelFour == null ? null : mortgageLevelFour.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 质押物五级
     */
    public String getMortgageLevelFive() {
        return mortgageLevelFive;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 质押物五级
     */
    public void setMortgageLevelFive(String mortgageLevelFive) {
        this.mortgageLevelFive = mortgageLevelFive == null ? null : mortgageLevelFive.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 品牌/厂家
     */
    public String getVender() {
        return vender;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 品牌/厂家
     */
    public void setVender(String vender) {
        this.vender = vender == null ? null : vender.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 产地
     */
    public String getProductArea() {
        return productArea;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 产地
     */
    public void setProductArea(String productArea) {
        this.productArea = productArea == null ? null : productArea.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 仓库地址
     */
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 仓库地址
     */
    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress == null ? null : warehouseAddress.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 凭证号
     */
    public String getBillno() {
        return billno;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 凭证号
     */
    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    /**
     * CHAR(3)<br>
     * 获得 押品单位
     */
    public String getMortgageUnits() {
        return mortgageUnits;
    }

    /**
     * CHAR(3)<br>
     * 设置 押品单位
     */
    public void setMortgageUnits(String mortgageUnits) {
        this.mortgageUnits = mortgageUnits == null ? null : mortgageUnits.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 数（重）量
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 数（重）量
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原始核定价
     */
    public BigDecimal getOldConfirmPrice() {
        return oldConfirmPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原始核定价
     */
    public void setOldConfirmPrice(BigDecimal oldConfirmPrice) {
        this.oldConfirmPrice = oldConfirmPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 核定单价
     */
    public BigDecimal getConfirmPrice() {
        return confirmPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 核定单价
     */
    public void setConfirmPrice(BigDecimal confirmPrice) {
        this.confirmPrice = confirmPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 [成本价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 [成本价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 市场价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 市场价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 合同价
     */
    public BigDecimal getContPrice() {
        return contPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 合同价
     */
    public void setContPrice(BigDecimal contPrice) {
        this.contPrice = contPrice;
    }

    /**
     * VARCHAR(200)<br>
     * 获得 核定依据
     */
    public String getApproveAccording() {
        return approveAccording;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 核定依据
     */
    public void setApproveAccording(String approveAccording) {
        this.approveAccording = approveAccording == null ? null : approveAccording.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 核准依据
     */
    public String getConfirmAccording() {
        return confirmAccording;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 核准依据
     */
    public void setConfirmAccording(String confirmAccording) {
        this.confirmAccording = confirmAccording == null ? null : confirmAccording.trim();
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
     * DECIMAL(16,2)<br>
     */
    public BigDecimal getThirdPartyPrice() {
        return thirdPartyPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     */
    public void setThirdPartyPrice(BigDecimal thirdPartyPrice) {
        this.thirdPartyPrice = thirdPartyPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", appno=").append(appno);
        sb.append(", appliMortBizType=").append(appliMortBizType);
        sb.append(", mortgageNo=").append(mortgageNo);
        sb.append(", mortgageLevelOne=").append(mortgageLevelOne);
        sb.append(", mortgageLevelTwo=").append(mortgageLevelTwo);
        sb.append(", mortgageLevelThree=").append(mortgageLevelThree);
        sb.append(", mortgageLevelFour=").append(mortgageLevelFour);
        sb.append(", mortgageLevelFive=").append(mortgageLevelFive);
        sb.append(", vender=").append(vender);
        sb.append(", productArea=").append(productArea);
        sb.append(", warehouseAddress=").append(warehouseAddress);
        sb.append(", billno=").append(billno);
        sb.append(", mortgageUnits=").append(mortgageUnits);
        sb.append(", quantity=").append(quantity);
        sb.append(", oldConfirmPrice=").append(oldConfirmPrice);
        sb.append(", confirmPrice=").append(confirmPrice);
        sb.append(", price=").append(price);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", contPrice=").append(contPrice);
        sb.append(", approveAccording=").append(approveAccording);
        sb.append(", confirmAccording=").append(confirmAccording);
        sb.append(", totPrice=").append(totPrice);
        sb.append(", thirdPartyPrice=").append(thirdPartyPrice);
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
        BPbcPricingMtg other = (BPbcPricingMtg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getAppliMortBizType() == null ? other.getAppliMortBizType() == null : this.getAppliMortBizType().equals(other.getAppliMortBizType()))
            && (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
            && (this.getMortgageLevelOne() == null ? other.getMortgageLevelOne() == null : this.getMortgageLevelOne().equals(other.getMortgageLevelOne()))
            && (this.getMortgageLevelTwo() == null ? other.getMortgageLevelTwo() == null : this.getMortgageLevelTwo().equals(other.getMortgageLevelTwo()))
            && (this.getMortgageLevelThree() == null ? other.getMortgageLevelThree() == null : this.getMortgageLevelThree().equals(other.getMortgageLevelThree()))
            && (this.getMortgageLevelFour() == null ? other.getMortgageLevelFour() == null : this.getMortgageLevelFour().equals(other.getMortgageLevelFour()))
            && (this.getMortgageLevelFive() == null ? other.getMortgageLevelFive() == null : this.getMortgageLevelFive().equals(other.getMortgageLevelFive()))
            && (this.getVender() == null ? other.getVender() == null : this.getVender().equals(other.getVender()))
            && (this.getProductArea() == null ? other.getProductArea() == null : this.getProductArea().equals(other.getProductArea()))
            && (this.getWarehouseAddress() == null ? other.getWarehouseAddress() == null : this.getWarehouseAddress().equals(other.getWarehouseAddress()))
            && (this.getBillno() == null ? other.getBillno() == null : this.getBillno().equals(other.getBillno()))
            && (this.getMortgageUnits() == null ? other.getMortgageUnits() == null : this.getMortgageUnits().equals(other.getMortgageUnits()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getOldConfirmPrice() == null ? other.getOldConfirmPrice() == null : this.getOldConfirmPrice().equals(other.getOldConfirmPrice()))
            && (this.getConfirmPrice() == null ? other.getConfirmPrice() == null : this.getConfirmPrice().equals(other.getConfirmPrice()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getContPrice() == null ? other.getContPrice() == null : this.getContPrice().equals(other.getContPrice()))
            && (this.getApproveAccording() == null ? other.getApproveAccording() == null : this.getApproveAccording().equals(other.getApproveAccording()))
            && (this.getConfirmAccording() == null ? other.getConfirmAccording() == null : this.getConfirmAccording().equals(other.getConfirmAccording()))
            && (this.getTotPrice() == null ? other.getTotPrice() == null : this.getTotPrice().equals(other.getTotPrice()))
            && (this.getThirdPartyPrice() == null ? other.getThirdPartyPrice() == null : this.getThirdPartyPrice().equals(other.getThirdPartyPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getAppliMortBizType() == null) ? 0 : getAppliMortBizType().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getMortgageLevelOne() == null) ? 0 : getMortgageLevelOne().hashCode());
        result = prime * result + ((getMortgageLevelTwo() == null) ? 0 : getMortgageLevelTwo().hashCode());
        result = prime * result + ((getMortgageLevelThree() == null) ? 0 : getMortgageLevelThree().hashCode());
        result = prime * result + ((getMortgageLevelFour() == null) ? 0 : getMortgageLevelFour().hashCode());
        result = prime * result + ((getMortgageLevelFive() == null) ? 0 : getMortgageLevelFive().hashCode());
        result = prime * result + ((getVender() == null) ? 0 : getVender().hashCode());
        result = prime * result + ((getProductArea() == null) ? 0 : getProductArea().hashCode());
        result = prime * result + ((getWarehouseAddress() == null) ? 0 : getWarehouseAddress().hashCode());
        result = prime * result + ((getBillno() == null) ? 0 : getBillno().hashCode());
        result = prime * result + ((getMortgageUnits() == null) ? 0 : getMortgageUnits().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getOldConfirmPrice() == null) ? 0 : getOldConfirmPrice().hashCode());
        result = prime * result + ((getConfirmPrice() == null) ? 0 : getConfirmPrice().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getContPrice() == null) ? 0 : getContPrice().hashCode());
        result = prime * result + ((getApproveAccording() == null) ? 0 : getApproveAccording().hashCode());
        result = prime * result + ((getConfirmAccording() == null) ? 0 : getConfirmAccording().hashCode());
        result = prime * result + ((getTotPrice() == null) ? 0 : getTotPrice().hashCode());
        result = prime * result + ((getThirdPartyPrice() == null) ? 0 : getThirdPartyPrice().hashCode());
        return result;
    }
}