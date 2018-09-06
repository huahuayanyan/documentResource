package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
/**
 * 
 * <p>BCrrLnAppRelaKey实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午7:45:30
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午7:45:30	     新增
 *
 * </pre>
 */
public class BCrrLnAppRelaKey extends BCrrBussExt implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 流水号
     */
    protected String serialno;

    /**
     * VARCHAR(32) 必填<br>
     * 关联类型
     */
    protected String rltTyp;

    /**
     * VARCHAR(18) 必填<br>
     * 关联编号
     */
    protected String rltNo;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 流水号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 流水号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 关联类型
     */
    public String getRltTyp() {
        return rltTyp;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 关联类型
     */
    public void setRltTyp(String rltTyp) {
        this.rltTyp = rltTyp == null ? null : rltTyp.trim();
    }

    /**
     * VARCHAR(18) 必填<br>
     * 获得 关联编号
     */
    public String getRltNo() {
        return rltNo;
    }

    /**
     * VARCHAR(18) 必填<br>
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
        BCrrLnAppRelaKey other = (BCrrLnAppRelaKey) that;
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