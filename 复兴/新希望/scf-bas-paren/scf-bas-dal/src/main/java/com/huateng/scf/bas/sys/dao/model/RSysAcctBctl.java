package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;
import java.util.Date;

public class RSysAcctBctl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(20) 必填<br>
     * 机构号
     */
    private String brcode;

    /**
     * VARCHAR(20) 必填<br>
     * 外部机构号
     */
    private String brno;

    /**
     * VARCHAR(60)<br>
     * 机构名称
     */
    private String brname;

    /**
     * CHAR(1)<br>
     * 机构级别
     */
    private String brclass;

    /**
     * CHAR(1)<br>
     * 机构属性 0-核算机构（账务机构）；1-管理机构
     */
    private String brattr;

    /**
     * CHAR(1)<br>
     * 分行级别
     */
    private String blnBranchClass;

    /**
     * VARCHAR(20)<br>
     * 分行机构号
     */
    private String blnBranchBrcode;

    /**
     * VARCHAR(20)<br>
     * 归属省分行
     */
    private String blnManageBrcode;

    /**
     * VARCHAR(20)<br>
     * 归属上级行
     */
    private String blnUpBrcode;

    /**
     * VARCHAR(20)<br>
     * 归属分行信贷中心
     */
    private String txnBrcode;

    /**
     * CHAR(1)<br>
     * 授权级别
     */
    private String authlvl;

    /**
     * VARCHAR(20)<br>
     * 联系人
     */
    private String linkman;

    /**
     * VARCHAR(30)<br>
     * 联系电话
     */
    private String teleno;

    /**
     * VARCHAR(300)<br>
     * 地址
     */
    private String address;

    /**
     * CHAR(6)<br>
     * 邮政编码
     */
    private String postno;

    /**
     * CHAR(1)<br>
     * 其他区域标识
     */
    private String otherAreaFlag;

    /**
     * CHAR(6)<br>
     * 区域
     */
    private String regionalism;

    /**
     * VARCHAR(20)<br>
     * 组织机构代码
     */
    private String financeCode;

    /**
     * CHAR(1)<br>
     * 状态 0-无效;1-有效
     */
    private String status;

    /**
     * CHAR(20)<br>
     * 扩展标识 0-实际机构;1-虚拟机构
     */
    private String miscflgs;

    /**
     * VARCHAR(256)<br>
     * 扩展域
     */
    private String misc;

    /**
     * VARCHAR(2)<br>
     * 省份
     */
    private String province;

    /**
     * VARCHAR(20)<br>
     * 归属总行机构号
     */
    private String blnHeadBrcode;

    /**
     * VARCHAR(32)<br>
     * 最后更新操作员号
     */
    private String lastUpdTlr;

    /**
     * VARCHAR(20)<br>
     * 最后更新机构
     */
    private String lastUpdFunc;

    /**
     * CHAR(8)<br>
     * 最后更新日期
     */
    private String lastUpdDate;

    /**
     * TIMESTAMP(11,6)<br>
     * 时间戳
     */
    private Date timestamps;

    /**
     * VARCHAR(20) 必填<br>
     * 获得 机构号
     */
    public String getBrcode() {
        return brcode;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 机构号
     */
    public void setBrcode(String brcode) {
        this.brcode = brcode == null ? null : brcode.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 外部机构号
     */
    public String getBrno() {
        return brno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 外部机构号
     */
    public void setBrno(String brno) {
        this.brno = brno == null ? null : brno.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 机构名称
     */
    public String getBrname() {
        return brname;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 机构名称
     */
    public void setBrname(String brname) {
        this.brname = brname == null ? null : brname.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 机构级别
     */
    public String getBrclass() {
        return brclass;
    }

    /**
     * CHAR(1)<br>
     * 设置 机构级别
     */
    public void setBrclass(String brclass) {
        this.brclass = brclass == null ? null : brclass.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 机构属性 0-核算机构（账务机构）；1-管理机构
     */
    public String getBrattr() {
        return brattr;
    }

    /**
     * CHAR(1)<br>
     * 设置 机构属性 0-核算机构（账务机构）；1-管理机构
     */
    public void setBrattr(String brattr) {
        this.brattr = brattr == null ? null : brattr.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 分行级别
     */
    public String getBlnBranchClass() {
        return blnBranchClass;
    }

    /**
     * CHAR(1)<br>
     * 设置 分行级别
     */
    public void setBlnBranchClass(String blnBranchClass) {
        this.blnBranchClass = blnBranchClass == null ? null : blnBranchClass.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 分行机构号
     */
    public String getBlnBranchBrcode() {
        return blnBranchBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 分行机构号
     */
    public void setBlnBranchBrcode(String blnBranchBrcode) {
        this.blnBranchBrcode = blnBranchBrcode == null ? null : blnBranchBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 归属省分行
     */
    public String getBlnManageBrcode() {
        return blnManageBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 归属省分行
     */
    public void setBlnManageBrcode(String blnManageBrcode) {
        this.blnManageBrcode = blnManageBrcode == null ? null : blnManageBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 归属上级行
     */
    public String getBlnUpBrcode() {
        return blnUpBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 归属上级行
     */
    public void setBlnUpBrcode(String blnUpBrcode) {
        this.blnUpBrcode = blnUpBrcode == null ? null : blnUpBrcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 归属分行信贷中心
     */
    public String getTxnBrcode() {
        return txnBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 归属分行信贷中心
     */
    public void setTxnBrcode(String txnBrcode) {
        this.txnBrcode = txnBrcode == null ? null : txnBrcode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 授权级别
     */
    public String getAuthlvl() {
        return authlvl;
    }

    /**
     * CHAR(1)<br>
     * 设置 授权级别
     */
    public void setAuthlvl(String authlvl) {
        this.authlvl = authlvl == null ? null : authlvl.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    /**
     * VARCHAR(30)<br>
     * 获得 联系电话
     */
    public String getTeleno() {
        return teleno;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 联系电话
     */
    public void setTeleno(String teleno) {
        this.teleno = teleno == null ? null : teleno.trim();
    }

    /**
     * VARCHAR(300)<br>
     * 获得 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * VARCHAR(300)<br>
     * 设置 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * CHAR(6)<br>
     * 获得 邮政编码
     */
    public String getPostno() {
        return postno;
    }

    /**
     * CHAR(6)<br>
     * 设置 邮政编码
     */
    public void setPostno(String postno) {
        this.postno = postno == null ? null : postno.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 其他区域标识
     */
    public String getOtherAreaFlag() {
        return otherAreaFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 其他区域标识
     */
    public void setOtherAreaFlag(String otherAreaFlag) {
        this.otherAreaFlag = otherAreaFlag == null ? null : otherAreaFlag.trim();
    }

    /**
     * CHAR(6)<br>
     * 获得 区域
     */
    public String getRegionalism() {
        return regionalism;
    }

    /**
     * CHAR(6)<br>
     * 设置 区域
     */
    public void setRegionalism(String regionalism) {
        this.regionalism = regionalism == null ? null : regionalism.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 组织机构代码
     */
    public String getFinanceCode() {
        return financeCode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 组织机构代码
     */
    public void setFinanceCode(String financeCode) {
        this.financeCode = financeCode == null ? null : financeCode.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 状态 0-无效;1-有效
     */
    public String getStatus() {
        return status;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态 0-无效;1-有效
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * CHAR(20)<br>
     * 获得 扩展标识 0-实际机构;1-虚拟机构
     */
    public String getMiscflgs() {
        return miscflgs;
    }

    /**
     * CHAR(20)<br>
     * 设置 扩展标识 0-实际机构;1-虚拟机构
     */
    public void setMiscflgs(String miscflgs) {
        this.miscflgs = miscflgs == null ? null : miscflgs.trim();
    }

    /**
     * VARCHAR(256)<br>
     * 获得 扩展域
     */
    public String getMisc() {
        return misc;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 扩展域
     */
    public void setMisc(String misc) {
        this.misc = misc == null ? null : misc.trim();
    }

    /**
     * VARCHAR(2)<br>
     * 获得 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * VARCHAR(2)<br>
     * 设置 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 归属总行机构号
     */
    public String getBlnHeadBrcode() {
        return blnHeadBrcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 归属总行机构号
     */
    public void setBlnHeadBrcode(String blnHeadBrcode) {
        this.blnHeadBrcode = blnHeadBrcode == null ? null : blnHeadBrcode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 最后更新操作员号
     */
    public String getLastUpdTlr() {
        return lastUpdTlr;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 最后更新操作员号
     */
    public void setLastUpdTlr(String lastUpdTlr) {
        this.lastUpdTlr = lastUpdTlr == null ? null : lastUpdTlr.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 最后更新机构
     */
    public String getLastUpdFunc() {
        return lastUpdFunc;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 最后更新机构
     */
    public void setLastUpdFunc(String lastUpdFunc) {
        this.lastUpdFunc = lastUpdFunc == null ? null : lastUpdFunc.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 最后更新日期
     */
    public String getLastUpdDate() {
        return lastUpdDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 最后更新日期
     */
    public void setLastUpdDate(String lastUpdDate) {
        this.lastUpdDate = lastUpdDate == null ? null : lastUpdDate.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 时间戳
     */
    public Date getTimestamps() {
        return timestamps;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 时间戳
     */
    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", brcode=").append(brcode);
        sb.append(", brno=").append(brno);
        sb.append(", brname=").append(brname);
        sb.append(", brclass=").append(brclass);
        sb.append(", brattr=").append(brattr);
        sb.append(", blnBranchClass=").append(blnBranchClass);
        sb.append(", blnBranchBrcode=").append(blnBranchBrcode);
        sb.append(", blnManageBrcode=").append(blnManageBrcode);
        sb.append(", blnUpBrcode=").append(blnUpBrcode);
        sb.append(", txnBrcode=").append(txnBrcode);
        sb.append(", authlvl=").append(authlvl);
        sb.append(", linkman=").append(linkman);
        sb.append(", teleno=").append(teleno);
        sb.append(", address=").append(address);
        sb.append(", postno=").append(postno);
        sb.append(", otherAreaFlag=").append(otherAreaFlag);
        sb.append(", regionalism=").append(regionalism);
        sb.append(", financeCode=").append(financeCode);
        sb.append(", status=").append(status);
        sb.append(", miscflgs=").append(miscflgs);
        sb.append(", misc=").append(misc);
        sb.append(", province=").append(province);
        sb.append(", blnHeadBrcode=").append(blnHeadBrcode);
        sb.append(", lastUpdTlr=").append(lastUpdTlr);
        sb.append(", lastUpdFunc=").append(lastUpdFunc);
        sb.append(", lastUpdDate=").append(lastUpdDate);
        sb.append(", timestamps=").append(timestamps);
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
        RSysAcctBctl other = (RSysAcctBctl) that;
        return (this.getBrcode() == null ? other.getBrcode() == null : this.getBrcode().equals(other.getBrcode()))
            && (this.getBrno() == null ? other.getBrno() == null : this.getBrno().equals(other.getBrno()))
            && (this.getBrname() == null ? other.getBrname() == null : this.getBrname().equals(other.getBrname()))
            && (this.getBrclass() == null ? other.getBrclass() == null : this.getBrclass().equals(other.getBrclass()))
            && (this.getBrattr() == null ? other.getBrattr() == null : this.getBrattr().equals(other.getBrattr()))
            && (this.getBlnBranchClass() == null ? other.getBlnBranchClass() == null : this.getBlnBranchClass().equals(other.getBlnBranchClass()))
            && (this.getBlnBranchBrcode() == null ? other.getBlnBranchBrcode() == null : this.getBlnBranchBrcode().equals(other.getBlnBranchBrcode()))
            && (this.getBlnManageBrcode() == null ? other.getBlnManageBrcode() == null : this.getBlnManageBrcode().equals(other.getBlnManageBrcode()))
            && (this.getBlnUpBrcode() == null ? other.getBlnUpBrcode() == null : this.getBlnUpBrcode().equals(other.getBlnUpBrcode()))
            && (this.getTxnBrcode() == null ? other.getTxnBrcode() == null : this.getTxnBrcode().equals(other.getTxnBrcode()))
            && (this.getAuthlvl() == null ? other.getAuthlvl() == null : this.getAuthlvl().equals(other.getAuthlvl()))
            && (this.getLinkman() == null ? other.getLinkman() == null : this.getLinkman().equals(other.getLinkman()))
            && (this.getTeleno() == null ? other.getTeleno() == null : this.getTeleno().equals(other.getTeleno()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPostno() == null ? other.getPostno() == null : this.getPostno().equals(other.getPostno()))
            && (this.getOtherAreaFlag() == null ? other.getOtherAreaFlag() == null : this.getOtherAreaFlag().equals(other.getOtherAreaFlag()))
            && (this.getRegionalism() == null ? other.getRegionalism() == null : this.getRegionalism().equals(other.getRegionalism()))
            && (this.getFinanceCode() == null ? other.getFinanceCode() == null : this.getFinanceCode().equals(other.getFinanceCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMiscflgs() == null ? other.getMiscflgs() == null : this.getMiscflgs().equals(other.getMiscflgs()))
            && (this.getMisc() == null ? other.getMisc() == null : this.getMisc().equals(other.getMisc()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getBlnHeadBrcode() == null ? other.getBlnHeadBrcode() == null : this.getBlnHeadBrcode().equals(other.getBlnHeadBrcode()))
            && (this.getLastUpdTlr() == null ? other.getLastUpdTlr() == null : this.getLastUpdTlr().equals(other.getLastUpdTlr()))
            && (this.getLastUpdFunc() == null ? other.getLastUpdFunc() == null : this.getLastUpdFunc().equals(other.getLastUpdFunc()))
            && (this.getLastUpdDate() == null ? other.getLastUpdDate() == null : this.getLastUpdDate().equals(other.getLastUpdDate()))
            && (this.getTimestamps() == null ? other.getTimestamps() == null : this.getTimestamps().equals(other.getTimestamps()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBrcode() == null) ? 0 : getBrcode().hashCode());
        result = prime * result + ((getBrno() == null) ? 0 : getBrno().hashCode());
        result = prime * result + ((getBrname() == null) ? 0 : getBrname().hashCode());
        result = prime * result + ((getBrclass() == null) ? 0 : getBrclass().hashCode());
        result = prime * result + ((getBrattr() == null) ? 0 : getBrattr().hashCode());
        result = prime * result + ((getBlnBranchClass() == null) ? 0 : getBlnBranchClass().hashCode());
        result = prime * result + ((getBlnBranchBrcode() == null) ? 0 : getBlnBranchBrcode().hashCode());
        result = prime * result + ((getBlnManageBrcode() == null) ? 0 : getBlnManageBrcode().hashCode());
        result = prime * result + ((getBlnUpBrcode() == null) ? 0 : getBlnUpBrcode().hashCode());
        result = prime * result + ((getTxnBrcode() == null) ? 0 : getTxnBrcode().hashCode());
        result = prime * result + ((getAuthlvl() == null) ? 0 : getAuthlvl().hashCode());
        result = prime * result + ((getLinkman() == null) ? 0 : getLinkman().hashCode());
        result = prime * result + ((getTeleno() == null) ? 0 : getTeleno().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPostno() == null) ? 0 : getPostno().hashCode());
        result = prime * result + ((getOtherAreaFlag() == null) ? 0 : getOtherAreaFlag().hashCode());
        result = prime * result + ((getRegionalism() == null) ? 0 : getRegionalism().hashCode());
        result = prime * result + ((getFinanceCode() == null) ? 0 : getFinanceCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMiscflgs() == null) ? 0 : getMiscflgs().hashCode());
        result = prime * result + ((getMisc() == null) ? 0 : getMisc().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getBlnHeadBrcode() == null) ? 0 : getBlnHeadBrcode().hashCode());
        result = prime * result + ((getLastUpdTlr() == null) ? 0 : getLastUpdTlr().hashCode());
        result = prime * result + ((getLastUpdFunc() == null) ? 0 : getLastUpdFunc().hashCode());
        result = prime * result + ((getLastUpdDate() == null) ? 0 : getLastUpdDate().hashCode());
        result = prime * result + ((getTimestamps() == null) ? 0 : getTimestamps().hashCode());
        return result;
    }
}