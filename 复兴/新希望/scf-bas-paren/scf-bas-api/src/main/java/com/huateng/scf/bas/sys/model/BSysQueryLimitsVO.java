package com.huateng.scf.bas.sys.model;

import java.io.Serializable;

import com.huateng.authority.entity.RoleInfoVO;

public class BSysQueryLimitsVO extends RoleInfoVO implements Serializable {
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
//    private String roleNo;

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
//    public String getRoleNo() {
//        return roleNo;
//    }

    /**
     * VARCHAR(30)<br>
     * 设置 角色编号
     */
//    public void setRoleNo(String roleNo) {
//        this.roleNo = roleNo == null ? null : roleNo.trim();
//    }

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
}