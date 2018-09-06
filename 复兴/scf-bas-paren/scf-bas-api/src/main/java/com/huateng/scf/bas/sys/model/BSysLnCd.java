package com.huateng.scf.bas.sys.model;

import java.io.Serializable;
/**
 * 
 * <p>BSysLnCd实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月12日上午10:23:22
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月12日上午10:23:22	     新增
 *
 * </pre>
 */
public class BSysLnCd extends BSysLnVal implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(30) 必填<br>
     * 利率代码
     */
    private String ratecode;

    /**
     * VARCHAR(30)<br>
     * 利率名称
     */
    private String ratename;

    /**
     * CHAR(1)<br>
     * 状态
     */
    private String state;

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
     * VARCHAR(30) 必填<br>
     * 获得 利率代码
     */
    public String getRatecode() {
        return ratecode;
    }

    /**
     * VARCHAR(30) 必填<br>
     * 设置 利率代码
     */
    public void setRatecode(String ratecode) {
        this.ratecode = ratecode == null ? null : ratecode.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 利率名称
     */
    public String getRatename() {
        return ratename;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 利率名称
     */
    public void setRatename(String ratename) {
        this.ratename = ratename == null ? null : ratename.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ratecode=").append(ratecode);
        sb.append(", ratename=").append(ratename);
        sb.append(", state=").append(state);
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
        BSysLnCd other = (BSysLnCd) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRatecode() == null ? other.getRatecode() == null : this.getRatecode().equals(other.getRatecode()))
            && (this.getRatename() == null ? other.getRatename() == null : this.getRatename().equals(other.getRatename()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRatecode() == null) ? 0 : getRatecode().hashCode());
        result = prime * result + ((getRatename() == null) ? 0 : getRatename().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }
}