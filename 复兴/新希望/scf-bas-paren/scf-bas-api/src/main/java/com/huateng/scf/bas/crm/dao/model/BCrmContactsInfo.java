package com.huateng.scf.bas.crm.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BCrmContactsInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * UUID主键
     */
    private String id;

    /**
     * VARCHAR(15) 必填<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(80) 必填<br>
     * 联系人名称
     */
    private String name;

    /**
     * VARCHAR(30)<br>
     * 联系电话
     */
    private String contactTel;

    /**
     * CHAR(11) 必填<br>
     * 手机
     */
    private String mobile;

    /**
     * VARCHAR(200)<br>
     * 电子邮件
     */
    private String email;

    /**
     * CHAR(2)<br>
     * 证件类型：01：身份证，02：护照，03：军官证
     */
    private String idtype;

    /**
     * VARCHAR(30)<br>
     * 证件号码
     */
    private String idno;

    /**
     * VARCHAR(500)<br>
     * 备注
     */
    private String remarks;

    /**
     * VARCHAR(32) 必填<br>
     * 创建人
     */
    private String tlrcd;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 创建时间
     */
    private Date crtTime;

    /**
     * VARCHAR(20)<br>
     * 经办机构
     */
    private String brcode;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员
     */
    private String lastUpdTlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新时间
     */
    private Date lastUpdTime;

    /**
     * VARCHAR(20)<br>
     * 最后更新机构
     */
    private String lastUpdBrcode;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 UUID主键
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 UUID主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(15) 必填<br>
     * 获得 客户号
     */
    public String getCustcd() {
        return custcd;
    }

    /**
     * VARCHAR(15) 必填<br>
     * 设置 客户号
     */
    public void setCustcd(String custcd) {
        this.custcd = custcd == null ? null : custcd.trim();
    }

    /**
     * VARCHAR(80) 必填<br>
     * 获得 联系人名称
     */
    public String getName() {
        return name;
    }

    /**
     * VARCHAR(80) 必填<br>
     * 设置 联系人名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 联系电话
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 联系电话
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    /**
     * CHAR(11) 必填<br>
     * 获得 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * CHAR(11) 必填<br>
     * 设置 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 电子邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 证件类型：01：身份证，02：护照，03：军官证
     */
    public String getIdtype() {
        return idtype;
    }

    /**
     * CHAR(2)<br>
     * 设置 证件类型：01：身份证，02：护照，03：军官证
     */
    public void setIdtype(String idtype) {
        this.idtype = idtype == null ? null : idtype.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 证件号码
     */
    public String getIdno() {
        return idno;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 证件号码
     */
    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 创建人
     */
    public String getTlrcd() {
        return tlrcd;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 创建人
     */
    public void setTlrcd(String tlrcd) {
        this.tlrcd = tlrcd == null ? null : tlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 获得 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 经办机构
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 经办机构
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新操作员
     */
    public String getLastUpdTlrcd() {
        return lastUpdTlrcd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员
     */
    public void setLastUpdTlrcd(String lastUpdTlrcd) {
        this.lastUpdTlrcd = lastUpdTlrcd == null ? null : lastUpdTlrcd.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 最后更新时间
     */
    public Date getLastUpdTime() {
        return lastUpdTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 最后更新时间
     */
    public void setLastUpdTime(Date lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 最后更新机构
     */
    public String getLastUpdBrcode() {
        return lastUpdBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 最后更新机构
     */
    public void setLastUpdBrcode(String lastUpdBrcode) {
        this.lastUpdBrcode = lastUpdBrcode == null ? null : lastUpdBrcode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custcd=").append(custcd);
        sb.append(", name=").append(name);
        sb.append(", contactTel=").append(contactTel);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", idtype=").append(idtype);
        sb.append(", idno=").append(idno);
        sb.append(", remarks=").append(remarks);
        sb.append(", tlrcd=").append(tlrcd);
        sb.append(", crtTime=").append(crtTime);
        sb.append(", brcode=").append(brcode);
        sb.append(", lastUpdTlrcd=").append(lastUpdTlrcd);
        sb.append(", lastUpdTime=").append(lastUpdTime);
        sb.append(", lastUpdBrcode=").append(lastUpdBrcode);
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
        BCrmContactsInfo other = (BCrmContactsInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getContactTel() == null ? other.getContactTel() == null : this.getContactTel().equals(other.getContactTel()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getIdtype() == null ? other.getIdtype() == null : this.getIdtype().equals(other.getIdtype()))
            && (this.getIdno() == null ? other.getIdno() == null : this.getIdno().equals(other.getIdno()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getTlrcd() == null ? other.getTlrcd() == null : this.getTlrcd().equals(other.getTlrcd()))
            && (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()))
            && (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getLastUpdTlrcd() == null ? other.getLastUpdTlrcd() == null : this.getLastUpdTlrcd().equals(other.getLastUpdTlrcd()))
            && (this.getLastUpdTime() == null ? other.getLastUpdTime() == null : this.getLastUpdTime().equals(other.getLastUpdTime()))
            && (this.getLastUpdBrcode() == null ? other.getLastUpdBrcode() == null : this.getLastUpdBrcode().equals(other.getLastUpdBrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getContactTel() == null) ? 0 : getContactTel().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIdtype() == null) ? 0 : getIdtype().hashCode());
        result = prime * result + ((getIdno() == null) ? 0 : getIdno().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getTlrcd() == null) ? 0 : getTlrcd().hashCode());
        result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getLastUpdTlrcd() == null) ? 0 : getLastUpdTlrcd().hashCode());
        result = prime * result + ((getLastUpdTime() == null) ? 0 : getLastUpdTime().hashCode());
        result = prime * result + ((getLastUpdBrcode() == null) ? 0 : getLastUpdBrcode().hashCode());
        return result;
    }
}