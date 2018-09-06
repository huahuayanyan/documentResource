package com.huateng.scf.bas.cnt.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BCntMprotCmInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(20) 必填<br>
     * 协议编号
     */
    private String protocolNo;

    /**
     * VARCHAR(80) 必填<br>
     * 监管公司编号
     */
    private String moniOfCustcd;

    /**
     * CHAR(1)<br>
     * 是否集团公司：1-集团模式、0-单户模式
     */
    private String grouped;

    /**
     * CHAR(1)<br>
     * 是否集团成员：1-是、0-否
     */
    private String groupedMember;

    /**
     * DECIMAL(16,2)<br>
     * 原监管下限
     */
    private BigDecimal lowPrice;

    /**
     * DECIMAL(16,2)<br>
     * 新监管下限
     */
    private BigDecimal lowPriceNew;

    /**
     * CHAR(2) 必填<br>
     * 监管模式：00-自有库监管、01-监管方输出监管
     */
    private String moniWarehouseType;

    /**
     * CHAR(2)<br>
     * 属地监管类型：00-属地监管、01-跨区监管
     */
    private String moniAreaType;

    /**
     * VARCHAR(200)<br>
     * 物流监管条件
     */
    private String logisticsMoniCondition;

    /**
     * VARCHAR(300)<br>
     * 存放地
     */
    private String warehousedress;

    /**
     * CHAR(2)<br>
     * 押品交付方式:1-抵押权人/质权人为收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、2-抵押权人/质权人为抵押人/出质人的委托收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、3-抵押权人/质权人和抵押人/出质人为共同收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、4-监管人代表抵押权人/质权人直接与抵押人/出质人办理货物的交接手续、5-其他。
     */
    private String mortgagePayType;

    /**
     * VARCHAR(200)<br>
     * 抵押人/出质人特别提出条件
     */
    private String specialWarehouseCondition;

    /**
     * VARCHAR(200)<br>
     * 监管费用承担方
     */
    private String costBear;

    /**
     * VARCHAR(200)<br>
     * 计费标准
     */
    private String costStandard;

    /**
     * DECIMAL(16,2)<br>
     * 监管费用(元)
     */
    private BigDecimal moniCost;

    /**
     * VARCHAR(50)<br>
     * 支付方式
     */
    private String payWay;

    /**
     * TIMESTAMP(11,6)<br>
     * 支付时间(支付时间可以是每月的dd日前，或每季的dd日前)
     */
    private Date payTime;

    /**
     * VARCHAR(50)<br>
     * 联系人
     */
    private String moniName;

    /**
     * VARCHAR(30)<br>
     * 联系电话
     */
    private String moniTel;

    /**
     * CHAR(2)<br>
     * 监管协议类型
     */
    private String moniProtocolType;

    /**
     * CHAR(1)<br>
     * 担保合同是否最高额:1,是、2,否
     */
    private String isHighestLimit;

    /**
     * CHAR(2)<br>
     * 是否可调整监管下限:01,是、00,否
     */
    private String moniPriceModel;

    /**
     * CHAR(1)<br>
     * 是否允许以货换货:1,是、2,否
     */
    private String moniModel;

    /**
     * DECIMAL(22)<br>
     * 流转频率（日）
     */
    private BigDecimal deallineRate;

    /**
     * CHAR(1)<br>
     * 场地权属类型:1,监管公司自有、2,出质人/借款人自有、3,监管公司从第三方租赁、4,公共仓
     */
    private String warehouseType;

    /**
     * VARCHAR(200)<br>
     * 场地租赁合同编号
     */
    private String warehouseHireProtocol;

    /**
     * CHAR(8)<br>
     * 场地租赁合同起始日
     */
    private String warehouseHireStartDate;

    /**
     * CHAR(8)<br>
     * 场地租赁合同到期日
     */
    private String warehouseHireEndDate;

    /**
     * VARCHAR(256)<br>
     * 其他描述
     */
    private String otherDes;

    /**
     * CHAR(1)<br>
     * 通知方式:1,快递、2,电邮、3,网银
     */
    private String noticeType;

    /**
     * DECIMAL(10,6)<br>
     * 二级展场存放最高比例(%)
     */
    private BigDecimal seHighestPercent;

    /**
     * CHAR(1)<br>
     * 是否抵押：0-否、1-是
     */
    private String isPledge;

    /**
     * VARCHAR(20) 必填<br>
     * 获得 协议编号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 协议编号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(80) 必填<br>
     * 获得 监管公司编号
     */
    public String getMoniOfCustcd() {
        return moniOfCustcd;
    }

    /**
     * VARCHAR(80) 必填<br>
     * 设置 监管公司编号
     */
    public void setMoniOfCustcd(String moniOfCustcd) {
        this.moniOfCustcd = moniOfCustcd == null ? null : moniOfCustcd.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否集团公司：1-集团模式、0-单户模式
     */
    public String getGrouped() {
        return grouped;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否集团公司：1-集团模式、0-单户模式
     */
    public void setGrouped(String grouped) {
        this.grouped = grouped == null ? null : grouped.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否集团成员：1-是、0-否
     */
    public String getGroupedMember() {
        return groupedMember;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否集团成员：1-是、0-否
     */
    public void setGroupedMember(String groupedMember) {
        this.groupedMember = groupedMember == null ? null : groupedMember.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 原监管下限
     */
    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 原监管下限
     */
    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 新监管下限
     */
    public BigDecimal getLowPriceNew() {
        return lowPriceNew;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 新监管下限
     */
    public void setLowPriceNew(BigDecimal lowPriceNew) {
        this.lowPriceNew = lowPriceNew;
    }

    /**
     * CHAR(2) 必填<br>
     * 获得 监管模式：00-自有库监管、01-监管方输出监管
     */
    public String getMoniWarehouseType() {
        return moniWarehouseType;
    }

    /**
     * CHAR(2) 必填<br>
     * 设置 监管模式：00-自有库监管、01-监管方输出监管
     */
    public void setMoniWarehouseType(String moniWarehouseType) {
        this.moniWarehouseType = moniWarehouseType == null ? null : moniWarehouseType.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 属地监管类型：00-属地监管、01-跨区监管
     */
    public String getMoniAreaType() {
        return moniAreaType;
    }

    /**
     * CHAR(2)<br>
     * 设置 属地监管类型：00-属地监管、01-跨区监管
     */
    public void setMoniAreaType(String moniAreaType) {
        this.moniAreaType = moniAreaType == null ? null : moniAreaType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 物流监管条件
     */
    public String getLogisticsMoniCondition() {
        return logisticsMoniCondition;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 物流监管条件
     */
    public void setLogisticsMoniCondition(String logisticsMoniCondition) {
        this.logisticsMoniCondition = logisticsMoniCondition == null ? null : logisticsMoniCondition.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 存放地
     */
    public String getWarehousedress() {
        return warehousedress;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 存放地
     */
    public void setWarehousedress(String warehousedress) {
        this.warehousedress = warehousedress == null ? null : warehousedress.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 押品交付方式:1-抵押权人/质权人为收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、2-抵押权人/质权人为抵押人/出质人的委托收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、3-抵押权人/质权人和抵押人/出质人为共同收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、4-监管人代表抵押权人/质权人直接与抵押人/出质人办理货物的交接手续、5-其他。
     */
    public String getMortgagePayType() {
        return mortgagePayType;
    }

    /**
     * CHAR(2)<br>
     * 设置 押品交付方式:1-抵押权人/质权人为收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、2-抵押权人/质权人为抵押人/出质人的委托收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、3-抵押权人/质权人和抵押人/出质人为共同收货人，货物到达后，监管人须立即通知抵押权人/质权人和抵押人/出质人，并由监管人代替抵押权人/质权人办理接货及验收等手续、4-监管人代表抵押权人/质权人直接与抵押人/出质人办理货物的交接手续、5-其他。
     */
    public void setMortgagePayType(String mortgagePayType) {
        this.mortgagePayType = mortgagePayType == null ? null : mortgagePayType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 抵押人/出质人特别提出条件
     */
    public String getSpecialWarehouseCondition() {
        return specialWarehouseCondition;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 抵押人/出质人特别提出条件
     */
    public void setSpecialWarehouseCondition(String specialWarehouseCondition) {
        this.specialWarehouseCondition = specialWarehouseCondition == null ? null : specialWarehouseCondition.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 监管费用承担方
     */
    public String getCostBear() {
        return costBear;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 监管费用承担方
     */
    public void setCostBear(String costBear) {
        this.costBear = costBear == null ? null : costBear.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 计费标准
     */
    public String getCostStandard() {
        return costStandard;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 计费标准
     */
    public void setCostStandard(String costStandard) {
        this.costStandard = costStandard == null ? null : costStandard.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 监管费用(元)
     */
    public BigDecimal getMoniCost() {
        return moniCost;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 监管费用(元)
     */
    public void setMoniCost(BigDecimal moniCost) {
        this.moniCost = moniCost;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 支付方式
     */
    public String getPayWay() {
        return payWay;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 支付方式
     */
    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 支付时间(支付时间可以是每月的dd日前，或每季的dd日前)
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 支付时间(支付时间可以是每月的dd日前，或每季的dd日前)
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 联系人
     */
    public String getMoniName() {
        return moniName;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 联系人
     */
    public void setMoniName(String moniName) {
        this.moniName = moniName == null ? null : moniName.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 联系电话
     */
    public String getMoniTel() {
        return moniTel;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 联系电话
     */
    public void setMoniTel(String moniTel) {
        this.moniTel = moniTel == null ? null : moniTel.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 监管协议类型
     */
    public String getMoniProtocolType() {
        return moniProtocolType;
    }

    /**
     * CHAR(2)<br>
     * 设置 监管协议类型
     */
    public void setMoniProtocolType(String moniProtocolType) {
        this.moniProtocolType = moniProtocolType == null ? null : moniProtocolType.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 担保合同是否最高额:1,是、2,否
     */
    public String getIsHighestLimit() {
        return isHighestLimit;
    }

    /**
     * CHAR(1)<br>
     * 设置 担保合同是否最高额:1,是、2,否
     */
    public void setIsHighestLimit(String isHighestLimit) {
        this.isHighestLimit = isHighestLimit == null ? null : isHighestLimit.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 是否可调整监管下限:01,是、00,否
     */
    public String getMoniPriceModel() {
        return moniPriceModel;
    }

    /**
     * CHAR(2)<br>
     * 设置 是否可调整监管下限:01,是、00,否
     */
    public void setMoniPriceModel(String moniPriceModel) {
        this.moniPriceModel = moniPriceModel == null ? null : moniPriceModel.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否允许以货换货:1,是、2,否
     */
    public String getMoniModel() {
        return moniModel;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否允许以货换货:1,是、2,否
     */
    public void setMoniModel(String moniModel) {
        this.moniModel = moniModel == null ? null : moniModel.trim();
    }

    /**
     * DECIMAL(22)<br>
     * 获得 流转频率（日）
     */
    public BigDecimal getDeallineRate() {
        return deallineRate;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 流转频率（日）
     */
    public void setDeallineRate(BigDecimal deallineRate) {
        this.deallineRate = deallineRate;
    }

    /**
     * CHAR(1)<br>
     * 获得 场地权属类型:1,监管公司自有、2,出质人/借款人自有、3,监管公司从第三方租赁、4,公共仓
     */
    public String getWarehouseType() {
        return warehouseType;
    }

    /**
     * CHAR(1)<br>
     * 设置 场地权属类型:1,监管公司自有、2,出质人/借款人自有、3,监管公司从第三方租赁、4,公共仓
     */
    public void setWarehouseType(String warehouseType) {
        this.warehouseType = warehouseType == null ? null : warehouseType.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 场地租赁合同编号
     */
    public String getWarehouseHireProtocol() {
        return warehouseHireProtocol;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 场地租赁合同编号
     */
    public void setWarehouseHireProtocol(String warehouseHireProtocol) {
        this.warehouseHireProtocol = warehouseHireProtocol == null ? null : warehouseHireProtocol.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 场地租赁合同起始日
     */
    public String getWarehouseHireStartDate() {
        return warehouseHireStartDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 场地租赁合同起始日
     */
    public void setWarehouseHireStartDate(String warehouseHireStartDate) {
        this.warehouseHireStartDate = warehouseHireStartDate == null ? null : warehouseHireStartDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 场地租赁合同到期日
     */
    public String getWarehouseHireEndDate() {
        return warehouseHireEndDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 场地租赁合同到期日
     */
    public void setWarehouseHireEndDate(String warehouseHireEndDate) {
        this.warehouseHireEndDate = warehouseHireEndDate == null ? null : warehouseHireEndDate.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 其他描述
     */
    public String getOtherDes() {
        return otherDes;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 其他描述
     */
    public void setOtherDes(String otherDes) {
        this.otherDes = otherDes == null ? null : otherDes.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 通知方式:1,快递、2,电邮、3,网银
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * CHAR(1)<br>
     * 设置 通知方式:1,快递、2,电邮、3,网银
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    /**
     * DECIMAL(10,6)<br>
     * 获得 二级展场存放最高比例(%)
     */
    public BigDecimal getSeHighestPercent() {
        return seHighestPercent;
    }

    /**
     * DECIMAL(10,6)<br>
     * 设置 二级展场存放最高比例(%)
     */
    public void setSeHighestPercent(BigDecimal seHighestPercent) {
        this.seHighestPercent = seHighestPercent;
    }

    /**
     * CHAR(1)<br>
     * 获得 是否抵押：0-否、1-是
     */
    public String getIsPledge() {
        return isPledge;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否抵押：0-否、1-是
     */
    public void setIsPledge(String isPledge) {
        this.isPledge = isPledge == null ? null : isPledge.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", moniOfCustcd=").append(moniOfCustcd);
        sb.append(", grouped=").append(grouped);
        sb.append(", groupedMember=").append(groupedMember);
        sb.append(", lowPrice=").append(lowPrice);
        sb.append(", lowPriceNew=").append(lowPriceNew);
        sb.append(", moniWarehouseType=").append(moniWarehouseType);
        sb.append(", moniAreaType=").append(moniAreaType);
        sb.append(", logisticsMoniCondition=").append(logisticsMoniCondition);
        sb.append(", warehousedress=").append(warehousedress);
        sb.append(", mortgagePayType=").append(mortgagePayType);
        sb.append(", specialWarehouseCondition=").append(specialWarehouseCondition);
        sb.append(", costBear=").append(costBear);
        sb.append(", costStandard=").append(costStandard);
        sb.append(", moniCost=").append(moniCost);
        sb.append(", payWay=").append(payWay);
        sb.append(", payTime=").append(payTime);
        sb.append(", moniName=").append(moniName);
        sb.append(", moniTel=").append(moniTel);
        sb.append(", moniProtocolType=").append(moniProtocolType);
        sb.append(", isHighestLimit=").append(isHighestLimit);
        sb.append(", moniPriceModel=").append(moniPriceModel);
        sb.append(", moniModel=").append(moniModel);
        sb.append(", deallineRate=").append(deallineRate);
        sb.append(", warehouseType=").append(warehouseType);
        sb.append(", warehouseHireProtocol=").append(warehouseHireProtocol);
        sb.append(", warehouseHireStartDate=").append(warehouseHireStartDate);
        sb.append(", warehouseHireEndDate=").append(warehouseHireEndDate);
        sb.append(", otherDes=").append(otherDes);
        sb.append(", noticeType=").append(noticeType);
        sb.append(", seHighestPercent=").append(seHighestPercent);
        sb.append(", isPledge=").append(isPledge);
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
        BCntMprotCmInfo other = (BCntMprotCmInfo) that;
        return (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getMoniOfCustcd() == null ? other.getMoniOfCustcd() == null : this.getMoniOfCustcd().equals(other.getMoniOfCustcd()))
            && (this.getGrouped() == null ? other.getGrouped() == null : this.getGrouped().equals(other.getGrouped()))
            && (this.getGroupedMember() == null ? other.getGroupedMember() == null : this.getGroupedMember().equals(other.getGroupedMember()))
            && (this.getLowPrice() == null ? other.getLowPrice() == null : this.getLowPrice().equals(other.getLowPrice()))
            && (this.getLowPriceNew() == null ? other.getLowPriceNew() == null : this.getLowPriceNew().equals(other.getLowPriceNew()))
            && (this.getMoniWarehouseType() == null ? other.getMoniWarehouseType() == null : this.getMoniWarehouseType().equals(other.getMoniWarehouseType()))
            && (this.getMoniAreaType() == null ? other.getMoniAreaType() == null : this.getMoniAreaType().equals(other.getMoniAreaType()))
            && (this.getLogisticsMoniCondition() == null ? other.getLogisticsMoniCondition() == null : this.getLogisticsMoniCondition().equals(other.getLogisticsMoniCondition()))
            && (this.getWarehousedress() == null ? other.getWarehousedress() == null : this.getWarehousedress().equals(other.getWarehousedress()))
            && (this.getMortgagePayType() == null ? other.getMortgagePayType() == null : this.getMortgagePayType().equals(other.getMortgagePayType()))
            && (this.getSpecialWarehouseCondition() == null ? other.getSpecialWarehouseCondition() == null : this.getSpecialWarehouseCondition().equals(other.getSpecialWarehouseCondition()))
            && (this.getCostBear() == null ? other.getCostBear() == null : this.getCostBear().equals(other.getCostBear()))
            && (this.getCostStandard() == null ? other.getCostStandard() == null : this.getCostStandard().equals(other.getCostStandard()))
            && (this.getMoniCost() == null ? other.getMoniCost() == null : this.getMoniCost().equals(other.getMoniCost()))
            && (this.getPayWay() == null ? other.getPayWay() == null : this.getPayWay().equals(other.getPayWay()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getMoniName() == null ? other.getMoniName() == null : this.getMoniName().equals(other.getMoniName()))
            && (this.getMoniTel() == null ? other.getMoniTel() == null : this.getMoniTel().equals(other.getMoniTel()))
            && (this.getMoniProtocolType() == null ? other.getMoniProtocolType() == null : this.getMoniProtocolType().equals(other.getMoniProtocolType()))
            && (this.getIsHighestLimit() == null ? other.getIsHighestLimit() == null : this.getIsHighestLimit().equals(other.getIsHighestLimit()))
            && (this.getMoniPriceModel() == null ? other.getMoniPriceModel() == null : this.getMoniPriceModel().equals(other.getMoniPriceModel()))
            && (this.getMoniModel() == null ? other.getMoniModel() == null : this.getMoniModel().equals(other.getMoniModel()))
            && (this.getDeallineRate() == null ? other.getDeallineRate() == null : this.getDeallineRate().equals(other.getDeallineRate()))
            && (this.getWarehouseType() == null ? other.getWarehouseType() == null : this.getWarehouseType().equals(other.getWarehouseType()))
            && (this.getWarehouseHireProtocol() == null ? other.getWarehouseHireProtocol() == null : this.getWarehouseHireProtocol().equals(other.getWarehouseHireProtocol()))
            && (this.getWarehouseHireStartDate() == null ? other.getWarehouseHireStartDate() == null : this.getWarehouseHireStartDate().equals(other.getWarehouseHireStartDate()))
            && (this.getWarehouseHireEndDate() == null ? other.getWarehouseHireEndDate() == null : this.getWarehouseHireEndDate().equals(other.getWarehouseHireEndDate()))
            && (this.getOtherDes() == null ? other.getOtherDes() == null : this.getOtherDes().equals(other.getOtherDes()))
            && (this.getNoticeType() == null ? other.getNoticeType() == null : this.getNoticeType().equals(other.getNoticeType()))
            && (this.getSeHighestPercent() == null ? other.getSeHighestPercent() == null : this.getSeHighestPercent().equals(other.getSeHighestPercent()))
            && (this.getIsPledge() == null ? other.getIsPledge() == null : this.getIsPledge().equals(other.getIsPledge()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getMoniOfCustcd() == null) ? 0 : getMoniOfCustcd().hashCode());
        result = prime * result + ((getGrouped() == null) ? 0 : getGrouped().hashCode());
        result = prime * result + ((getGroupedMember() == null) ? 0 : getGroupedMember().hashCode());
        result = prime * result + ((getLowPrice() == null) ? 0 : getLowPrice().hashCode());
        result = prime * result + ((getLowPriceNew() == null) ? 0 : getLowPriceNew().hashCode());
        result = prime * result + ((getMoniWarehouseType() == null) ? 0 : getMoniWarehouseType().hashCode());
        result = prime * result + ((getMoniAreaType() == null) ? 0 : getMoniAreaType().hashCode());
        result = prime * result + ((getLogisticsMoniCondition() == null) ? 0 : getLogisticsMoniCondition().hashCode());
        result = prime * result + ((getWarehousedress() == null) ? 0 : getWarehousedress().hashCode());
        result = prime * result + ((getMortgagePayType() == null) ? 0 : getMortgagePayType().hashCode());
        result = prime * result + ((getSpecialWarehouseCondition() == null) ? 0 : getSpecialWarehouseCondition().hashCode());
        result = prime * result + ((getCostBear() == null) ? 0 : getCostBear().hashCode());
        result = prime * result + ((getCostStandard() == null) ? 0 : getCostStandard().hashCode());
        result = prime * result + ((getMoniCost() == null) ? 0 : getMoniCost().hashCode());
        result = prime * result + ((getPayWay() == null) ? 0 : getPayWay().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getMoniName() == null) ? 0 : getMoniName().hashCode());
        result = prime * result + ((getMoniTel() == null) ? 0 : getMoniTel().hashCode());
        result = prime * result + ((getMoniProtocolType() == null) ? 0 : getMoniProtocolType().hashCode());
        result = prime * result + ((getIsHighestLimit() == null) ? 0 : getIsHighestLimit().hashCode());
        result = prime * result + ((getMoniPriceModel() == null) ? 0 : getMoniPriceModel().hashCode());
        result = prime * result + ((getMoniModel() == null) ? 0 : getMoniModel().hashCode());
        result = prime * result + ((getDeallineRate() == null) ? 0 : getDeallineRate().hashCode());
        result = prime * result + ((getWarehouseType() == null) ? 0 : getWarehouseType().hashCode());
        result = prime * result + ((getWarehouseHireProtocol() == null) ? 0 : getWarehouseHireProtocol().hashCode());
        result = prime * result + ((getWarehouseHireStartDate() == null) ? 0 : getWarehouseHireStartDate().hashCode());
        result = prime * result + ((getWarehouseHireEndDate() == null) ? 0 : getWarehouseHireEndDate().hashCode());
        result = prime * result + ((getOtherDes() == null) ? 0 : getOtherDes().hashCode());
        result = prime * result + ((getNoticeType() == null) ? 0 : getNoticeType().hashCode());
        result = prime * result + ((getSeHighestPercent() == null) ? 0 : getSeHighestPercent().hashCode());
        result = prime * result + ((getIsPledge() == null) ? 0 : getIsPledge().hashCode());
        return result;
    }
}