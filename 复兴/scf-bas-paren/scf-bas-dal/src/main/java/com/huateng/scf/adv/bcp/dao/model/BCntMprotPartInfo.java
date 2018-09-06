package com.huateng.scf.adv.bcp.dao.model;

import java.io.Serializable;

public class BCntMprotPartInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(20) 必填<br>
     * 协议号
     */
    private String protocolNo;

    /**
     * CHAR(2)<br>
     * 参与方角色：01-银行、02-监管公司、03-授信客户、04-核心企业、05-担保方/回购厂商
     */
    private String role;

    /**
     * VARCHAR(15) 必填<br>
     * 客户号
     */
    private String custcd;

    /**
     * VARCHAR(80) 必填<br>
     * 客户名称
     */
    private String cname;

    /**
     * VARCHAR(300)<br>
     * 客户地址
     */
    private String address;

    /**
     * VARCHAR(50)<br>
     * 法定代表人
     */
    private String legal;

    /**
     * VARCHAR(12)<br>
     * 开户行行号
     */
    private String actBankno;

    /**
     * VARCHAR(50)<br>
     * 开户账号
     */
    private String actno;

    /**
     * VARCHAR(50)<br>
     * 保证金账号
     */
    private String bailActno;

    /**
     * VARCHAR(80)<br>
     * 联系人
     */
    private String attn;

    /**
     * VARCHAR(30)<br>
     * 联系人电话
     */
    private String attnTel;

    /**
     * VARCHAR(30)<br>
     * 传真
     */
    private String fax;

    /**
     * CHAR(6)<br>
     * 邮编
     */
    private String postCode;

    /**
     * VARCHAR(30)<br>
     * 证件号码
     */
    private String idno;

    /**
     * VARCHAR(20)<br>
     * 营业执照号码
     */
    private String licenseNo;

    /**
     * VARCHAR(50)<br>
     * 网址
     */
    private String website;

    /**
     * VARCHAR(50)<br>
     * 邮箱
     */
    private String mailbox;

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
     * VARCHAR(20) 必填<br>
     * 获得 协议号
     */
    public String getProtocolNo() {
        return protocolNo;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 协议号
     */
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo == null ? null : protocolNo.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 参与方角色：01-银行、02-监管公司、03-授信客户、04-核心企业、05-担保方/回购厂商
     */
    public String getRole() {
        return role;
    }

    /**
     * CHAR(2)<br>
     * 设置 参与方角色：01-银行、02-监管公司、03-授信客户、04-核心企业、05-担保方/回购厂商
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
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
     * 获得 客户名称
     */
    public String getCname() {
        return cname;
    }

    /**
     * VARCHAR(80) 必填<br>
     * 设置 客户名称
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 客户地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 客户地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 法定代表人
     */
    public String getLegal() {
        return legal;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 法定代表人
     */
    public void setLegal(String legal) {
        this.legal = legal == null ? null : legal.trim();
    }

    /**
     * VARCHAR(12)<br>
     * 获得 开户行行号
     */
    public String getActBankno() {
        return actBankno;
    }

    /**
     * VARCHAR(12)<br>
     * 设置 开户行行号
     */
    public void setActBankno(String actBankno) {
        this.actBankno = actBankno == null ? null : actBankno.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 开户账号
     */
    public String getActno() {
        return actno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 开户账号
     */
    public void setActno(String actno) {
        this.actno = actno == null ? null : actno.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 保证金账号
     */
    public String getBailActno() {
        return bailActno;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 保证金账号
     */
    public void setBailActno(String bailActno) {
        this.bailActno = bailActno == null ? null : bailActno.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 联系人
     */
    public String getAttn() {
        return attn;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 联系人
     */
    public void setAttn(String attn) {
        this.attn = attn == null ? null : attn.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 联系人电话
     */
    public String getAttnTel() {
        return attnTel;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 联系人电话
     */
    public void setAttnTel(String attnTel) {
        this.attnTel = attnTel == null ? null : attnTel.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * CHAR(6)<br>
     * 获得 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * CHAR(6)<br>
     * 设置 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
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
     * VARCHAR(20)<br>
     * 获得 营业执照号码
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 营业执照号码
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 网址
     */
    public String getWebsite() {
        return website;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 网址
     */
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 邮箱
     */
    public String getMailbox() {
        return mailbox;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 邮箱
     */
    public void setMailbox(String mailbox) {
        this.mailbox = mailbox == null ? null : mailbox.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", protocolNo=").append(protocolNo);
        sb.append(", role=").append(role);
        sb.append(", custcd=").append(custcd);
        sb.append(", cname=").append(cname);
        sb.append(", address=").append(address);
        sb.append(", legal=").append(legal);
        sb.append(", actBankno=").append(actBankno);
        sb.append(", actno=").append(actno);
        sb.append(", bailActno=").append(bailActno);
        sb.append(", attn=").append(attn);
        sb.append(", attnTel=").append(attnTel);
        sb.append(", fax=").append(fax);
        sb.append(", postCode=").append(postCode);
        sb.append(", idno=").append(idno);
        sb.append(", licenseNo=").append(licenseNo);
        sb.append(", website=").append(website);
        sb.append(", mailbox=").append(mailbox);
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
        BCntMprotPartInfo other = (BCntMprotPartInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProtocolNo() == null ? other.getProtocolNo() == null : this.getProtocolNo().equals(other.getProtocolNo()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getCustcd() == null ? other.getCustcd() == null : this.getCustcd().equals(other.getCustcd()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getLegal() == null ? other.getLegal() == null : this.getLegal().equals(other.getLegal()))
            && (this.getActBankno() == null ? other.getActBankno() == null : this.getActBankno().equals(other.getActBankno()))
            && (this.getActno() == null ? other.getActno() == null : this.getActno().equals(other.getActno()))
            && (this.getBailActno() == null ? other.getBailActno() == null : this.getBailActno().equals(other.getBailActno()))
            && (this.getAttn() == null ? other.getAttn() == null : this.getAttn().equals(other.getAttn()))
            && (this.getAttnTel() == null ? other.getAttnTel() == null : this.getAttnTel().equals(other.getAttnTel()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getPostCode() == null ? other.getPostCode() == null : this.getPostCode().equals(other.getPostCode()))
            && (this.getIdno() == null ? other.getIdno() == null : this.getIdno().equals(other.getIdno()))
            && (this.getLicenseNo() == null ? other.getLicenseNo() == null : this.getLicenseNo().equals(other.getLicenseNo()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getMailbox() == null ? other.getMailbox() == null : this.getMailbox().equals(other.getMailbox()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProtocolNo() == null) ? 0 : getProtocolNo().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getCustcd() == null) ? 0 : getCustcd().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getLegal() == null) ? 0 : getLegal().hashCode());
        result = prime * result + ((getActBankno() == null) ? 0 : getActBankno().hashCode());
        result = prime * result + ((getActno() == null) ? 0 : getActno().hashCode());
        result = prime * result + ((getBailActno() == null) ? 0 : getBailActno().hashCode());
        result = prime * result + ((getAttn() == null) ? 0 : getAttn().hashCode());
        result = prime * result + ((getAttnTel() == null) ? 0 : getAttnTel().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getPostCode() == null) ? 0 : getPostCode().hashCode());
        result = prime * result + ((getIdno() == null) ? 0 : getIdno().hashCode());
        result = prime * result + ((getLicenseNo() == null) ? 0 : getLicenseNo().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getMailbox() == null) ? 0 : getMailbox().hashCode());
        return result;
    }
}