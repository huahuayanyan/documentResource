package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
/**
 * 
 * <p>BCrrPrdMd实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月28日下午7:54:42
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月28日下午7:54:42	     新增
 *
 * </pre>
 */
public class BCrrPrdMd extends BCrrModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(6) 必填<br>
     * 模版编号
     */
    private String prdId;

    /**
     * VARCHAR(60)<br>
     * 模版名称
     */
    private String prdNm;

    /**
     * VARCHAR(60)<br>
     * 模版类型
     */
    private String prdTyp;

    /**
     * VARCHAR(60)<br>
     * 新增URL
     */
    private String addUrl;

    /**
     * VARCHAR(60)<br>
     * 修改URL
     */
    private String updUrl;

    /**
     * VARCHAR(60)<br>
     * 查找URL
     */
    private String finUrl;

    /**
     * CHAR(1)<br>
     * 列表状态
     */
    private String stat;

    /**
     * VARCHAR(60)<br>
     * 显示名称
     */
    private String titNm;

    /**
     * VARCHAR(20)<br>
     * 对象参数
     */
    private String obj;

    /**
     * VARCHAR(60)<br>
     * 分页查询URL
     */
    private String pageUrl;

    /**
     * CHAR(1)<br>
     * 有效状态
     */
    private String statu;

    /**
     * VARCHAR(5)<br>
     * 业务品种编号
     */
    private String loanWay;
    
    /**
     * CHAR(1)<br>
     * 是否列表显示
     */
    private String isList;

    /**
     * VARCHAR(6) 必填<br>
     * 获得 模版编号
     */
    public String getPrdId() {
        return prdId;
    }

    /**
     * VARCHAR(6) 必填<br>
     * 设置 模版编号
     */
    public void setPrdId(String prdId) {
        this.prdId = prdId == null ? null : prdId.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 模版名称
     */
    public String getPrdNm() {
        return prdNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 模版名称
     */
    public void setPrdNm(String prdNm) {
        this.prdNm = prdNm == null ? null : prdNm.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 模版类型
     */
    public String getPrdTyp() {
        return prdTyp;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 模版类型
     */
    public void setPrdTyp(String prdTyp) {
        this.prdTyp = prdTyp == null ? null : prdTyp.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 新增URL
     */
    public String getAddUrl() {
        return addUrl;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 新增URL
     */
    public void setAddUrl(String addUrl) {
        this.addUrl = addUrl == null ? null : addUrl.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 修改URL
     */
    public String getUpdUrl() {
        return updUrl;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 修改URL
     */
    public void setUpdUrl(String updUrl) {
        this.updUrl = updUrl == null ? null : updUrl.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 查找URL
     */
    public String getFinUrl() {
        return finUrl;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 查找URL
     */
    public void setFinUrl(String finUrl) {
        this.finUrl = finUrl == null ? null : finUrl.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 列表状态
     */
    public String getStat() {
        return stat;
    }

    /**
     * CHAR(1)<br>
     * 设置 列表状态
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 显示名称
     */
    public String getTitNm() {
        return titNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 显示名称
     */
    public void setTitNm(String titNm) {
        this.titNm = titNm == null ? null : titNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 对象参数
     */
    public String getObj() {
        return obj;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 对象参数
     */
    public void setObj(String obj) {
        this.obj = obj == null ? null : obj.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 分页查询URL
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 分页查询URL
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl == null ? null : pageUrl.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 有效状态
     */
    public String getStatu() {
        return statu;
    }

    /**
     * CHAR(1)<br>
     * 设置 有效状态
     */
    public void setStatu(String statu) {
        this.statu = statu == null ? null : statu.trim();
    }

    /**
     * VARCHAR(5)<br>
     * 获得 业务品种编号
     */
    public String getLoanWay() {
        return loanWay;
    }

    /**
     * VARCHAR(5)<br>
     * 设置 业务品种编号
     */
    public void setLoanWay(String loanWay) {
        this.loanWay = loanWay == null ? null : loanWay.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 是否列表显示
     */
    public String getIsList() {
        return isList;
    }

    /**
     * CHAR(1)<br>
     * 设置 是否列表显示
     */
    public void setIsList(String isList) {
        this.isList = isList == null ? null : isList.trim();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prdId=").append(prdId);
        sb.append(", prdNm=").append(prdNm);
        sb.append(", prdTyp=").append(prdTyp);
        sb.append(", addUrl=").append(addUrl);
        sb.append(", updUrl=").append(updUrl);
        sb.append(", finUrl=").append(finUrl);
        sb.append(", stat=").append(stat);
        sb.append(", titNm=").append(titNm);
        sb.append(", obj=").append(obj);
        sb.append(", pageUrl=").append(pageUrl);
        sb.append(", tlrNo=").append(tlrNo);
        sb.append(", tlrNm=").append(tlrNm);
        sb.append(", brCd=").append(brCd);
        sb.append(", brNm=").append(brNm);
        sb.append(", inpDt=").append(inpDt);
        sb.append(", lstUpdTlr=").append(lstUpdTlr);
        sb.append(", lstUpdTlrNm=").append(lstUpdTlrNm);
        sb.append(", lstUpdBrCd=").append(lstUpdBrCd);
        sb.append(", lstUpdBrNm=").append(lstUpdBrNm);
        sb.append(", lstUpdDt=").append(lstUpdDt);
        sb.append(", statu=").append(statu);
        sb.append(", loanWay=").append(loanWay);
        sb.append(", isList=").append(isList);
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
        BCrrPrdMd other = (BCrrPrdMd) that;
        return (this.getPrdId() == null ? other.getPrdId() == null : this.getPrdId().equals(other.getPrdId()))
            && (this.getPrdNm() == null ? other.getPrdNm() == null : this.getPrdNm().equals(other.getPrdNm()))
            && (this.getPrdTyp() == null ? other.getPrdTyp() == null : this.getPrdTyp().equals(other.getPrdTyp()))
            && (this.getAddUrl() == null ? other.getAddUrl() == null : this.getAddUrl().equals(other.getAddUrl()))
            && (this.getUpdUrl() == null ? other.getUpdUrl() == null : this.getUpdUrl().equals(other.getUpdUrl()))
            && (this.getFinUrl() == null ? other.getFinUrl() == null : this.getFinUrl().equals(other.getFinUrl()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
            && (this.getTitNm() == null ? other.getTitNm() == null : this.getTitNm().equals(other.getTitNm()))
            && (this.getObj() == null ? other.getObj() == null : this.getObj().equals(other.getObj()))
            && (this.getPageUrl() == null ? other.getPageUrl() == null : this.getPageUrl().equals(other.getPageUrl()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getTlrNm() == null ? other.getTlrNm() == null : this.getTlrNm().equals(other.getTlrNm()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getBrNm() == null ? other.getBrNm() == null : this.getBrNm().equals(other.getBrNm()))
            && (this.getInpDt() == null ? other.getInpDt() == null : this.getInpDt().equals(other.getInpDt()))
            && (this.getLstUpdTlr() == null ? other.getLstUpdTlr() == null : this.getLstUpdTlr().equals(other.getLstUpdTlr()))
            && (this.getLstUpdTlrNm() == null ? other.getLstUpdTlrNm() == null : this.getLstUpdTlrNm().equals(other.getLstUpdTlrNm()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdBrNm() == null ? other.getLstUpdBrNm() == null : this.getLstUpdBrNm().equals(other.getLstUpdBrNm()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()))
            && (this.getStatu() == null ? other.getStatu() == null : this.getStatu().equals(other.getStatu()))
            && (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()))
            && (this.getIsList() == null ? other.getIsList() == null : this.getIsList().equals(other.getIsList()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPrdId() == null) ? 0 : getPrdId().hashCode());
        result = prime * result + ((getPrdNm() == null) ? 0 : getPrdNm().hashCode());
        result = prime * result + ((getPrdTyp() == null) ? 0 : getPrdTyp().hashCode());
        result = prime * result + ((getAddUrl() == null) ? 0 : getAddUrl().hashCode());
        result = prime * result + ((getUpdUrl() == null) ? 0 : getUpdUrl().hashCode());
        result = prime * result + ((getFinUrl() == null) ? 0 : getFinUrl().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getTitNm() == null) ? 0 : getTitNm().hashCode());
        result = prime * result + ((getObj() == null) ? 0 : getObj().hashCode());
        result = prime * result + ((getPageUrl() == null) ? 0 : getPageUrl().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getTlrNm() == null) ? 0 : getTlrNm().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getBrNm() == null) ? 0 : getBrNm().hashCode());
        result = prime * result + ((getInpDt() == null) ? 0 : getInpDt().hashCode());
        result = prime * result + ((getLstUpdTlr() == null) ? 0 : getLstUpdTlr().hashCode());
        result = prime * result + ((getLstUpdTlrNm() == null) ? 0 : getLstUpdTlrNm().hashCode());
        result = prime * result + ((getLstUpdBrCd() == null) ? 0 : getLstUpdBrCd().hashCode());
        result = prime * result + ((getLstUpdBrNm() == null) ? 0 : getLstUpdBrNm().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        result = prime * result + ((getStatu() == null) ? 0 : getStatu().hashCode());
        result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
        result = prime * result + ((getIsList() == null) ? 0 : getIsList().hashCode());
        return result;
    }
}