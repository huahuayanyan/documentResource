package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BSysLnVal实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日下午5:53:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日下午5:53:52	     新增
 *
 * </pre>
 */
public class BSysLnVal implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(32) 必填<br>
     * 利率种类ID
     */
    private String rateid;

    /**
     * VARCHAR(6) 必填<br>
     * 币种代码
     */
    private String curcd;

    /**
     * CHAR(1)<br>
     * 利率单位
     */
    private String unit;

    /**
     * DECIMAL(8,6) 必填<br>
     * 基准利率值
     */
    private BigDecimal rateval;

    /**
     * VARCHAR(10)<br>
     * 生效日期
     */
    private String startDate;

    /**
     * VARCHAR(10)<br>
     * 失效日期
     */
    private String endDate;

    /**
     * CHAR(1)<br>
     * 状态
     */
    private String state;

    /**
     * VARCHAR(3)<br>
     * 期限
     */
    private String term;

    /**
     * DECIMAL(8,6)<br>
     * 年利率
     */
    private BigDecimal ratevalYear;

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
     * VARCHAR(32) 必填<br>
     * 获得 利率种类ID
     */
    public String getRateid() {
        return rateid;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 利率种类ID
     */
    public void setRateid(String rateid) {
        this.rateid = rateid == null ? null : rateid.trim();
    }

    /**
     * VARCHAR(6) 必填<br>
     * 获得 币种代码
     */
    public String getCurcd() {
        return curcd;
    }

    /**
     * VARCHAR(6) 必填<br>
     * 设置 币种代码
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd == null ? null : curcd.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 利率单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * CHAR(1)<br>
     * 设置 利率单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * DECIMAL(8,6) 必填<br>
     * 获得 基准利率值
     */
    public BigDecimal getRateval() {
        return rateval;
    }

    /**
     * DECIMAL(8,6) 必填<br>
     * 设置 基准利率值
     */
    public void setRateval(BigDecimal rateval) {
        this.rateval = rateval;
    }

    /**
     * VARCHAR(10)<br>
     * 获得 生效日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 生效日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 失效日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 失效日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 状态
     */
    public String getState() {
        return state;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * VARCHAR(3)<br>
     * 获得 期限
     */
    public String getTerm() {
        return term;
    }

    /**
     * VARCHAR(3)<br>
     * 设置 期限
     */
    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    /**
     * DECIMAL(8,6)<br>
     * 获得 年利率
     */
    public BigDecimal getRatevalYear() {
        return ratevalYear;
    }

    /**
     * DECIMAL(8,6)<br>
     * 设置 年利率
     */
    public void setRatevalYear(BigDecimal ratevalYear) {
        this.ratevalYear = ratevalYear;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rateid=").append(rateid);
        sb.append(", curcd=").append(curcd);
        sb.append(", unit=").append(unit);
        sb.append(", rateval=").append(rateval);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", state=").append(state);
        sb.append(", term=").append(term);
        sb.append(", ratevalYear=").append(ratevalYear);
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
        BSysLnVal other = (BSysLnVal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRateid() == null ? other.getRateid() == null : this.getRateid().equals(other.getRateid()))
            && (this.getCurcd() == null ? other.getCurcd() == null : this.getCurcd().equals(other.getCurcd()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getRateval() == null ? other.getRateval() == null : this.getRateval().equals(other.getRateval()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getTerm() == null ? other.getTerm() == null : this.getTerm().equals(other.getTerm()))
            && (this.getRatevalYear() == null ? other.getRatevalYear() == null : this.getRatevalYear().equals(other.getRatevalYear()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRateid() == null) ? 0 : getRateid().hashCode());
        result = prime * result + ((getCurcd() == null) ? 0 : getCurcd().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getRateval() == null) ? 0 : getRateval().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getTerm() == null) ? 0 : getTerm().hashCode());
        result = prime * result + ((getRatevalYear() == null) ? 0 : getRatevalYear().hashCode());
        return result;
    }
}