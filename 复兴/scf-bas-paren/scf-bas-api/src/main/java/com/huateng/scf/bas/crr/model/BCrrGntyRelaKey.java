package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
/**
 * 
 * <p>BCrrGntyRelaKey实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:45:39
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:45:39	     新增
 *
 * </pre>
 */
public class BCrrGntyRelaKey extends BCrrModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(18) 必填<br>
     * 关联类型
     */
    private String rltTyp;

    /**
     * VARCHAR(40) 必填<br>
     * 关联编号
     */
    private String rltNo;

    /**
     * VARCHAR(32) 必填<br>
     * 担保合同编号
     */
    private String conNo;

    /**
     * VARCHAR(32) 必填<br>
     * 合同流水号
     */
    private String serialno;

    /**
     * VARCHAR(18) 必填<br>
     * 获得 关联类型
     */
    public String getRltTyp() {
        return rltTyp;
    }

    /**
     * VARCHAR(18) 必填<br>
     * 设置 关联类型
     */
    public void setRltTyp(String rltTyp) {
        this.rltTyp = rltTyp == null ? null : rltTyp.trim();
    }

    /**
     * VARCHAR(40) 必填<br>
     * 获得 关联编号
     */
    public String getRltNo() {
        return rltNo;
    }

    /**
     * VARCHAR(40) 必填<br>
     * 设置 关联编号
     */
    public void setRltNo(String rltNo) {
        this.rltNo = rltNo == null ? null : rltNo.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 担保合同编号
     */
    public String getConNo() {
        return conNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 担保合同编号
     */
    public void setConNo(String conNo) {
        this.conNo = conNo == null ? null : conNo.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 合同流水号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 合同流水号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rltTyp=").append(rltTyp);
        sb.append(", rltNo=").append(rltNo);
        sb.append(", conNo=").append(conNo);
        sb.append(", serialno=").append(serialno);
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
        BCrrGntyRelaKey other = (BCrrGntyRelaKey) that;
        return (this.getRltTyp() == null ? other.getRltTyp() == null : this.getRltTyp().equals(other.getRltTyp()))
            && (this.getRltNo() == null ? other.getRltNo() == null : this.getRltNo().equals(other.getRltNo()))
            && (this.getConNo() == null ? other.getConNo() == null : this.getConNo().equals(other.getConNo()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRltTyp() == null) ? 0 : getRltTyp().hashCode());
        result = prime * result + ((getRltNo() == null) ? 0 : getRltNo().hashCode());
        result = prime * result + ((getConNo() == null) ? 0 : getConNo().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        return result;
    }
}