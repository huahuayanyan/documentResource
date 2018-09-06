package com.huateng.scf.bas.crr.dao.model;

import java.io.Serializable;
/**
 * 
 * <p>BCrrInvInfoKey实体类，用于BCrrInvInfo扩展字段</p>
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
public class BCrrBillKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    private String billId;

    /**
     * VARCHAR(32)<br>
     * 票据编号
     */
    private String billNo;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billId=").append(billId);
        sb.append(", billNo=").append(billNo);
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
        BCrrBillKey other = (BCrrBillKey) that;
        return (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillNo() == null ? other.getBillNo() == null : this.getBillNo().equals(other.getBillNo()));
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillNo() == null) ? 0 : getBillNo().hashCode());
        return result;
    }
}