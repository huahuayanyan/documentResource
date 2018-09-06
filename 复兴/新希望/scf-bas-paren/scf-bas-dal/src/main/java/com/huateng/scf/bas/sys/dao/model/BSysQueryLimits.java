package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

public class BSysQueryLimits implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(30) 必填<br>
     * 角色ID
     */
    private String roleId;

    /**
     * VARCHAR(30)<br>
     * 角色编号
     */
    private String roleNo;

    /**
     * CHAR(2)<br>
     * 01.按客户经理
02.按客户经理+协管客户经理
03.按机构
04.按角色
     */
    private String roleModel;

    /**
     * CHAR(8)<br>
     * 创建时间
     */
    private String inpDt;

    /**
     * VARCHAR(30) 必填<br>
     * 获得 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * VARCHAR(30) 必填<br>
     * 设置 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 角色编号
     */
    public String getRoleNo() {
        return roleNo;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 角色编号
     */
    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo == null ? null : roleNo.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 01.按客户经理
02.按客户经理+协管客户经理
03.按机构
04.按角色
     */
    public String getRoleModel() {
        return roleModel;
    }

    /**
     * CHAR(2)<br>
     * 设置 01.按客户经理
02.按客户经理+协管客户经理
03.按机构
04.按角色
     */
    public void setRoleModel(String roleModel) {
        this.roleModel = roleModel == null ? null : roleModel.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 创建时间
     */
    public String getInpDt() {
        return inpDt;
    }

    /**
     * CHAR(8)<br>
     * 设置 创建时间
     */
    public void setInpDt(String inpDt) {
        this.inpDt = inpDt == null ? null : inpDt.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleNo=").append(roleNo);
        sb.append(", roleModel=").append(roleModel);
        sb.append(", inpDt=").append(inpDt);
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
        BSysQueryLimits other = (BSysQueryLimits) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getRoleNo() == null ? other.getRoleNo() == null : this.getRoleNo().equals(other.getRoleNo()))
            && (this.getRoleModel() == null ? other.getRoleModel() == null : this.getRoleModel().equals(other.getRoleModel()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getRoleNo() == null) ? 0 : getRoleNo().hashCode());
        result = prime * result + ((getRoleModel() == null) ? 0 : getRoleModel().hashCode());
        result = prime * result + ((getInpDt() == null) ? 0 : getInpDt().hashCode());
        return result;
    }
}