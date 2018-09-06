package com.huateng.scf.adv.bcp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ABcpMoreDvyChkStock implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键UUID
     */
    private String id;

    /**
     * VARCHAR(15)<br>
     * 授信客户号
     */
    private String custcd;

    /**
     * VARCHAR(15)<br>
     * 上游客户号
     */
    private String upCustcd;

    /**
     * VARCHAR(20)<br>
     * 担保提货/先票（款）后货协议编号
     */
    private String protocolNo;

    /**
     * VARCHAR(20)<br>
     * 对账机构号
     */
    private String checkBrcode;

    /**
     * VARCHAR(32)<br>
     * 对账负责人
     */
    private String checkTlrno;

    /**
     * VARCHAR(10)<br>
     * 对账状态：01-对账中;02-对账完成
     */
    private String status;

    /**
     * DECIMAL(16,2)<br>
     * 收到款项总计
     */
    private BigDecimal receivedTotAmt;

    /**
     * DECIMAL(16,2)<br>
     * 已发货总计
     */
    private BigDecimal delivriedValue;

    /**
     * DECIMAL(16,2)<br>
     * 未发货总计
     */
    private BigDecimal notDelivriedValue;

    /**
     * VARCHAR(10)<br>
     * 对账结果：01-通过;02-不通过
     */
    private String result;

    /**
     * VARCHAR(500)<br>
     * 对账备注信息
     */
    private String remark;

    /**
     * CHAR(8)<br>
     * 对账日期
     */
    private String checkDate;

    /**
     * VARCHAR(10)<br>
     * 对账方式：01-银行发起;05-上游客户发起
     */
    private String checkType;

    /**
     * VARCHAR(20)<br>
     * 业务申请编号
     */
    private String appno;

    /**
     * VARCHAR(10)<br>
     * 业务品种
     */
    private String productId;

    /**
     * CHAR(8)<br>
     * 对账确认日期
     */
    private String checkConfirmDate;

    /**
     * VARCHAR(32)<br>
     * 卖方对账负责人
     */
    private String sellerChecker;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键UUID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键UUID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 授信客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 授信客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(15)<br>
     * 获得 上游客户号
     */
    public String getUpCustcd() {
        return upCustcd;
    }

    /**
     * VARCHAR(15)<br>
     * 设置 上游客户号
     */
    public void setUpCustcd(String upCustcd) {
        this.upCustcd = upCustcd == null ? null : upCustcd.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 担保提货/先票（款）后货协议编号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 担保提货/先票（款）后货协议编号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 对账机构号
     */
    public String getCheckBrcode() {
        return checkBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 对账机构号
     */
    public void setCheckBrcode(String checkBrcode) {
        this.checkBrcode = checkBrcode == null ? null : checkBrcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 对账负责人
     */
    public String getCheckTlrno() {
        return checkTlrno;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 对账负责人
     */
    public void setCheckTlrno(String checkTlrno) {
        this.checkTlrno = checkTlrno == null ? null : checkTlrno.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 对账状态：01-对账中;02-对账完成
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 对账状态：01-对账中;02-对账完成
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 收到款项总计
     */
    public BigDecimal getReceivedTotAmt() {
        return receivedTotAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 收到款项总计
     */
    public void setReceivedTotAmt(BigDecimal receivedTotAmt) {
        this.receivedTotAmt = receivedTotAmt;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 已发货总计
     */
    public BigDecimal getDelivriedValue() {
        return delivriedValue;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 已发货总计
     */
    public void setDelivriedValue(BigDecimal delivriedValue) {
        this.delivriedValue = delivriedValue;
    }

    /**
     * DECIMAL(16,2)<br>
     * 获得 未发货总计
     */
    public BigDecimal getNotDelivriedValue() {
        return notDelivriedValue;
    }

    /**
     * DECIMAL(16,2)<br>
     * 设置 未发货总计
     */
    public void setNotDelivriedValue(BigDecimal notDelivriedValue) {
        this.notDelivriedValue = notDelivriedValue;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 对账结果：01-通过;02-不通过
     */
    public String getResult() {
        return result;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 对账结果：01-通过;02-不通过
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 对账备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 对账备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 对账日期
     */
    public String getCheckDate() {
        return checkDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 对账日期
     */
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate == null ? null : checkDate.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 对账方式：01-银行发起;05-上游客户发起
     */
    public String getCheckType() {
        return checkType;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 对账方式：01-银行发起;05-上游客户发起
     */
    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 业务申请编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 业务申请编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
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
     * CHAR(8)<br>
     * 获得 对账确认日期
     */
    public String getCheckConfirmDate() {
        return checkConfirmDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 对账确认日期
     */
    public void setCheckConfirmDate(String checkConfirmDate) {
        this.checkConfirmDate = checkConfirmDate == null ? null : checkConfirmDate.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 卖方对账负责人
     */
    public String getSellerChecker() {
        return sellerChecker;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 卖方对账负责人
     */
    public void setSellerChecker(String sellerChecker) {
        this.sellerChecker = sellerChecker == null ? null : sellerChecker.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custcd=").append(custcd);
        sb.append(", upCustcd=").append(upCustcd);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", checkBrcode=").append(checkBrcode);
        sb.append(", checkTlrno=").append(checkTlrno);
        sb.append(", status=").append(status);
        sb.append(", receivedTotAmt=").append(receivedTotAmt);
        sb.append(", delivriedValue=").append(delivriedValue);
        sb.append(", notDelivriedValue=").append(notDelivriedValue);
        sb.append(", result=").append(result);
        sb.append(", remark=").append(remark);
        sb.append(", checkDate=").append(checkDate);
        sb.append(", checkType=").append(checkType);
        sb.append(", appno=").append(appno);
        sb.append(", productId=").append(productId);
        sb.append(", checkConfirmDate=").append(checkConfirmDate);
        sb.append(", sellerChecker=").append(sellerChecker);
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
        ABcpMoreDvyChkStock other = (ABcpMoreDvyChkStock) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getUpCustcd() == null ? other.getUpCustcd() == null : this.getUpCustcd().equals(other.getUpCustcd()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getCheckBrcode() == null ? other.getCheckBrcode() == null : this.getCheckBrcode().equals(other.getCheckBrcode()))
            && (this.getCheckTlrno() == null ? other.getCheckTlrno() == null : this.getCheckTlrno().equals(other.getCheckTlrno()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getReceivedTotAmt() == null ? other.getReceivedTotAmt() == null : this.getReceivedTotAmt().equals(other.getReceivedTotAmt()))
            && (this.getDelivriedValue() == null ? other.getDelivriedValue() == null : this.getDelivriedValue().equals(other.getDelivriedValue()))
            && (this.getNotDelivriedValue() == null ? other.getNotDelivriedValue() == null : this.getNotDelivriedValue().equals(other.getNotDelivriedValue()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCheckDate() == null ? other.getCheckDate() == null : this.getCheckDate().equals(other.getCheckDate()))
            && (this.getCheckType() == null ? other.getCheckType() == null : this.getCheckType().equals(other.getCheckType()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getCheckConfirmDate() == null ? other.getCheckConfirmDate() == null : this.getCheckConfirmDate().equals(other.getCheckConfirmDate()))
            && (this.getSellerChecker() == null ? other.getSellerChecker() == null : this.getSellerChecker().equals(other.getSellerChecker()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getUpCustcd() == null) ? 0 : getUpCustcd().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getCheckBrcode() == null) ? 0 : getCheckBrcode().hashCode());
        result = prime * result + ((getCheckTlrno() == null) ? 0 : getCheckTlrno().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReceivedTotAmt() == null) ? 0 : getReceivedTotAmt().hashCode());
        result = prime * result + ((getDelivriedValue() == null) ? 0 : getDelivriedValue().hashCode());
        result = prime * result + ((getNotDelivriedValue() == null) ? 0 : getNotDelivriedValue().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCheckDate() == null) ? 0 : getCheckDate().hashCode());
        result = prime * result + ((getCheckType() == null) ? 0 : getCheckType().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getCheckConfirmDate() == null) ? 0 : getCheckConfirmDate().hashCode());
        result = prime * result + ((getSellerChecker() == null) ? 0 : getSellerChecker().hashCode());
        return result;
    }
}