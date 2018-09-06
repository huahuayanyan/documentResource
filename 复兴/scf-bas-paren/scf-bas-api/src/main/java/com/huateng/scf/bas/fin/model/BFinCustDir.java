package com.huateng.scf.bas.fin.model;

import java.io.Serializable;
/**
 * 
 * <p>BFinCustDir实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午10:00:05
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午10:00:05	     新增
 *
 * </pre>
 */
public class BFinCustDir implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 财报目录号
     */
    private String finDirId;

    /**
     * VARCHAR(32) 必填<br>
     * 财报记录号
     */
    private String finId;

    /**
     * VARCHAR(32) 必填<br>
     * 客户编号
     */
    private String custId;

    /**
     * VARCHAR(18)<br>
     * 财报口径
     */
    private String finScp;

    /**
     * VARCHAR(32)<br>
     * 模型编号
     */
    private String mdlId;

    /**
     * VARCHAR(80)<br>
     * 财报名称
     */
    private String finNm;

    /**
     * VARCHAR(10)<br>
     * 财报日期
     */
    private String finDt;

    /**
     * VARCHAR(32)<br>
     * 登记人
     */
    private String tlrNo;

    /**
     * VARCHAR(32)<br>
     * 登记机构
     */
    private String brCd;

    /**
     * CHAR(8)<br>
     * 登记日期
     */
    private String inputDt;

    /**
     * VARCHAR(32)<br>
     * 更新人
     */
    private String lstUpdTlr;

    /**
     * VARCHAR(32)<br>
     * 更新机构
     */
    private String lstUpdBrCd;

    /**
     * CHAR(8)<br>
     * 更新日期
     */
    private String lstUpdDt;

    /**
     * VARCHAR(10) 必填<br>
     * 
     */
    private String finStat;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 财报目录号
     */
    public String getFinDirId() {
        return finDirId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 财报目录号
     */
    public void setFinDirId(String finDirId) {
        this.finDirId = finDirId == null ? null : finDirId.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 财报记录号
     */
    public String getFinId() {
        return finId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 财报记录号
     */
    public void setFinId(String finId) {
        this.finId = finId == null ? null : finId.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 客户编号
     */
    public String getCustId() {
        return custId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 客户编号
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 财报口径
     */
    public String getFinScp() {
        return finScp;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 财报口径
     */
    public void setFinScp(String finScp) {
        this.finScp = finScp == null ? null : finScp.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 模型编号
     */
    public String getMdlId() {
        return mdlId;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 模型编号
     */
    public void setMdlId(String mdlId) {
        this.mdlId = mdlId == null ? null : mdlId.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 财报名称
     */
    public String getFinNm() {
        return finNm;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 财报名称
     */
    public void setFinNm(String finNm) {
        this.finNm = finNm == null ? null : finNm.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 财报日期
     */
    public String getFinDt() {
        return finDt;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 财报日期
     */
    public void setFinDt(String finDt) {
        this.finDt = finDt == null ? null : finDt.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记人
     */
    public String getTlrNo() {
        return tlrNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记人
     */
    public void setTlrNo(String tlrNo) {
        this.tlrNo = tlrNo == null ? null : tlrNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记机构
     */
    public String getBrCd() {
        return brCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记机构
     */
    public void setBrCd(String brCd) {
        this.brCd = brCd == null ? null : brCd.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 登记日期
     */
    public String getInputDt() {
        return inputDt;
    }

    /**
     * CHAR(8)<br>
     * 设置 登记日期
     */
    public void setInputDt(String inputDt) {
        this.inputDt = inputDt == null ? null : inputDt.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新人
     */
    public String getLstUpdTlr() {
        return lstUpdTlr;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新人
     */
    public void setLstUpdTlr(String lstUpdTlr) {
        this.lstUpdTlr = lstUpdTlr == null ? null : lstUpdTlr.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新机构
     */
    public String getLstUpdBrCd() {
        return lstUpdBrCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新机构
     */
    public void setLstUpdBrCd(String lstUpdBrCd) {
        this.lstUpdBrCd = lstUpdBrCd == null ? null : lstUpdBrCd.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 更新日期
     */
    public String getLstUpdDt() {
        return lstUpdDt;
    }

    /**
     * CHAR(8)<br>
     * 设置 更新日期
     */
    public void setLstUpdDt(String lstUpdDt) {
        this.lstUpdDt = lstUpdDt == null ? null : lstUpdDt.trim();
    }

    /**
     * VARCHAR(10) 必填<br>
     */
    public String getFinStat() {
        return finStat;
    }

    /**
     * VARCHAR(10) 必填<br>
     */
    public void setFinStat(String finStat) {
        this.finStat = finStat == null ? null : finStat.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", finDirId=").append(finDirId);
        sb.append(", finId=").append(finId);
        sb.append(", custId=").append(custId);
        sb.append(", finScp=").append(finScp);
        sb.append(", mdlId=").append(mdlId);
        sb.append(", finNm=").append(finNm);
        sb.append(", finDt=").append(finDt);
        sb.append(", tlrNo=").append(tlrNo);
        sb.append(", brCd=").append(brCd);
        sb.append(", inputDt=").append(inputDt);
        sb.append(", lstUpdTlr=").append(lstUpdTlr);
        sb.append(", lstUpdBrCd=").append(lstUpdBrCd);
        sb.append(", lstUpdDt=").append(lstUpdDt);
        sb.append(", finStat=").append(finStat);
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
        BFinCustDir other = (BFinCustDir) that;
        return (this.getFinDirId() == null ? other.getFinDirId() == null : this.getFinDirId().equals(other.getFinDirId()))
            && (this.getFinId() == null ? other.getFinId() == null : this.getFinId().equals(other.getFinId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getFinScp() == null ? other.getFinScp() == null : this.getFinScp().equals(other.getFinScp()))
            && (this.getMdlId() == null ? other.getMdlId() == null : this.getMdlId().equals(other.getMdlId()))
            && (this.getFinNm() == null ? other.getFinNm() == null : this.getFinNm().equals(other.getFinNm()))
            && (this.getFinDt() == null ? other.getFinDt() == null : this.getFinDt().equals(other.getFinDt()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getInputDt() == null ? other.getInputDt() == null : this.getInputDt().equals(other.getInputDt()))
            && (this.getLstUpdTlr() == null ? other.getLstUpdTlr() == null : this.getLstUpdTlr().equals(other.getLstUpdTlr()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()))
            && (this.getFinStat() == null ? other.getFinStat() == null : this.getFinStat().equals(other.getFinStat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFinDirId() == null) ? 0 : getFinDirId().hashCode());
        result = prime * result + ((getFinId() == null) ? 0 : getFinId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getFinScp() == null) ? 0 : getFinScp().hashCode());
        result = prime * result + ((getMdlId() == null) ? 0 : getMdlId().hashCode());
        result = prime * result + ((getFinNm() == null) ? 0 : getFinNm().hashCode());
        result = prime * result + ((getFinDt() == null) ? 0 : getFinDt().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getInputDt() == null) ? 0 : getInputDt().hashCode());
        result = prime * result + ((getLstUpdTlr() == null) ? 0 : getLstUpdTlr().hashCode());
        result = prime * result + ((getLstUpdBrCd() == null) ? 0 : getLstUpdBrCd().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        result = prime * result + ((getFinStat() == null) ? 0 : getFinStat().hashCode());
        return result;
    }
}