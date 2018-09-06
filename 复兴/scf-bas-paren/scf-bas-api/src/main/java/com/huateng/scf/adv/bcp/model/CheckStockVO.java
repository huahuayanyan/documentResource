package com.huateng.scf.adv.bcp.model;


 

import java.io.Serializable;
import java.math.BigDecimal;

public class CheckStockVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    /**除A_BCP_MORE_DVY_CHK_STOCK，新增字段***/
    
    private String custname;//买方名称
    private String upcustname;//卖方名称
    private String tlrno; //客户经理
    private String tlrname; //客户经理
    private String checkBrCodeName;//经办机构
    private String productName;//业务品种

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCheckBrCodeName() {
		return checkBrCodeName;
	}

	public void setCheckBrCodeName(String checkBrCodeName) {
		this.checkBrCodeName = checkBrCodeName;
	}

	public String getTlrno() {
		return tlrno;
	}

	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}

	public String getTlrname() {
		return tlrname;
	}

	public void setTlrname(String tlrname) {
		this.tlrname = tlrname;
	}


	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getUpcustname() {
		return upcustname;
	}

	public void setUpcustname(String upcustname) {
		this.upcustname = upcustname;
	}


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

}