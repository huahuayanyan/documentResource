package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
/**
 * 
 * <p>BCrrLnConRelaKey实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午7:45:25
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午7:45:25	     新增
 *
 * </pre>
 */
public class BCrrLnConRelaKey extends BCrrModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 合同流水号
     */
    protected String serialno;

    /**
     * VARCHAR(18) 必填<br>
     * 关联类型
     */
    protected String rltTyp;

    /**
     * VARCHAR(32) 必填<br>
     * 关联编号
     */
    protected String rltNo;

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
     * VARCHAR(32) 必填<br>
     * 获得 关联编号
     */
    public String getRltNo() {
        return rltNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 关联编号
     */
    public void setRltNo(String rltNo) {
        this.rltNo = rltNo == null ? null : rltNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialno=").append(serialno);
        sb.append(", rltTyp=").append(rltTyp);
        sb.append(", rltNo=").append(rltNo);
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
        BCrrLnConRelaKey other = (BCrrLnConRelaKey) that;
        return (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getRltTyp() == null ? other.getRltTyp() == null : this.getRltTyp().equals(other.getRltTyp()))
            && (this.getRltNo() == null ? other.getRltNo() == null : this.getRltNo().equals(other.getRltNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getRltTyp() == null) ? 0 : getRltTyp().hashCode());
        result = prime * result + ((getRltNo() == null) ? 0 : getRltNo().hashCode());
        return result;
    }
}