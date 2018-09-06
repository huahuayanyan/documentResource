package com.huateng.scf.bas.fin.model;

import java.io.Serializable;
/**
 * 
 * <p>BFinCust实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午10:00:14
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午10:00:14	     新增
 *
 * </pre>
 */
public class BFinCust implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 资产负债表财报状态
     *//*
    private String finIs;
    private String finDirIs;
    *//**
     * 损益表财报状态
     *//*
    private String finBs;
    private String finDirBs;
    *//**
     * 现金流量表财报状态
     *//*
    private String finCs;
    private String finDirCs;
    
    public String getFinDirIs() {
		return finDirIs;
	}

	public void setFinDirIs(String finDirIs) {
		this.finDirIs = finDirIs == null ? null : finDirIs.trim();
	}

	public String getFinDirBs() {
		return finDirBs;
	}

	public void setFinDirBs(String finDirBs) {
		this.finDirBs = finDirBs == null ? null : finDirBs.trim();
	}

	public String getFinDirCs() {
		return finDirCs;
	}

	public void setFinDirCs(String finDirCs) {
		this.finDirCs = finDirCs == null ? null : finDirCs.trim();
	}

    public String getFinIs() {
		return finIs;
	}

	public void setFinIs(String finIs) {
		this.finIs = finIs == null ? null : finIs.trim();
	}

	public String getFinBs() {
		return finBs;
	}

	public void setFinBs(String finBs) {
		this.finBs = finBs == null ? null : finBs.trim();
	}

	public String getFinCs() {
		return finCs;
	}

	public void setFinCs(String finCs) {
		this.finCs = finCs == null ? null : finCs.trim();
	}*/
    /**
     * VARCHAR(40)<br>
     * 客户名
     */
    private String custNm;

    public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm == null ? null : custNm.trim();
	}

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
     * VARCHAR(10)<br>
     * 财报日期
     */
    private String finDt;

    /**
     * VARCHAR(18)<br>
     * 财报口径
     */
    private String finScp;

    /**
     * VARCHAR(18)<br>
     * 财报周期
     */
    private String finPd;

    /**
     * VARCHAR(18)<br>
     * 财报币种
     */
    private String finCy;

    /**
     * VARCHAR(18)<br>
     * 财报单位
     */
    private String finUn;

    /**
     * VARCHAR(18)<br>
     * 财报状态
     */
    private String stat;

    /**
     * VARCHAR(1)<br>
     * 财报检查标志
     */
    private String chkFlg;

    /**
     * VARCHAR(1)<br>
     * 审计标志
     */
    private String audFlg;

    /**
     * VARCHAR(80)<br>
     * 审计单位
     */
    private String audUn;

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
    
    private String rptNo;

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
     * VARCHAR(18)<br>
     * 获得 财报周期
     */
    public String getFinPd() {
        return finPd;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 财报周期
     */
    public void setFinPd(String finPd) {
        this.finPd = finPd == null ? null : finPd.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 财报币种
     */
    public String getFinCy() {
        return finCy;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 财报币种
     */
    public void setFinCy(String finCy) {
        this.finCy = finCy == null ? null : finCy.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 财报单位
     */
    public String getFinUn() {
        return finUn;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 财报单位
     */
    public void setFinUn(String finUn) {
        this.finUn = finUn == null ? null : finUn.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 财报状态
     */
    public String getStat() {
        return stat;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 财报状态
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    /**
     * VARCHAR(1)<br>
     * 获得 财报检查标志
     */
    public String getChkFlg() {
        return chkFlg;
    }

    /**
     * VARCHAR(1)<br>
     * 设置 财报检查标志
     */
    public void setChkFlg(String chkFlg) {
        this.chkFlg = chkFlg == null ? null : chkFlg.trim();
    }

    /**
     * VARCHAR(1)<br>
     * 获得 审计标志
     */
    public String getAudFlg() {
        return audFlg;
    }

    /**
     * VARCHAR(1)<br>
     * 设置 审计标志
     */
    public void setAudFlg(String audFlg) {
        this.audFlg = audFlg == null ? null : audFlg.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 审计单位
     */
    public String getAudUn() {
        return audUn;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 审计单位
     */
    public void setAudUn(String audUn) {
        this.audUn = audUn == null ? null : audUn.trim();
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
	 * @return the rptNo
	 */
	public String getRptNo() {
		return rptNo;
	}

	/**
	 * @param rptNo the rptNo to set
	 */
	public void setRptNo(String rptNo) {
		this.rptNo = rptNo;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", finId=").append(finId);
        sb.append(", custId=").append(custId);
        sb.append(", custNm=").append(custNm);
        sb.append(", finDt=").append(finDt);
        sb.append(", finScp=").append(finScp);
        sb.append(", finPd=").append(finPd);
        sb.append(", finCy=").append(finCy);
        sb.append(", finUn=").append(finUn);
        sb.append(", stat=").append(stat);
        sb.append(", chkFlg=").append(chkFlg);
        sb.append(", audFlg=").append(audFlg);
        sb.append(", audUn=").append(audUn);
        sb.append(", tlrNo=").append(tlrNo);
        sb.append(", brCd=").append(brCd);
        sb.append(", inputDt=").append(inputDt);
        sb.append(", lstUpdTlr=").append(lstUpdTlr);
        sb.append(", lstUpdBrCd=").append(lstUpdBrCd);
        sb.append(", lstUpdDt=").append(lstUpdDt);
        /*sb.append(", finIs=").append(finIs);
        sb.append(", finBs=").append(finBs);
        sb.append(", finCs=").append(finCs);
        sb.append(", finDirIs=").append(finDirIs);
        sb.append(", finDirBs=").append(finDirBs);
        sb.append(", finDirCs=").append(finDirCs);*/
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
        BFinCust other = (BFinCust) that;
        return (this.getFinId() == null ? other.getFinId() == null : this.getFinId().equals(other.getFinId()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getCustNm() == null ? other.getCustNm() == null : this.getCustNm().equals(other.getCustNm()))
            && (this.getFinDt() == null ? other.getFinDt() == null : this.getFinDt().equals(other.getFinDt()))
            && (this.getFinScp() == null ? other.getFinScp() == null : this.getFinScp().equals(other.getFinScp()))
            && (this.getFinPd() == null ? other.getFinPd() == null : this.getFinPd().equals(other.getFinPd()))
            && (this.getFinCy() == null ? other.getFinCy() == null : this.getFinCy().equals(other.getFinCy()))
            && (this.getFinUn() == null ? other.getFinUn() == null : this.getFinUn().equals(other.getFinUn()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
            && (this.getChkFlg() == null ? other.getChkFlg() == null : this.getChkFlg().equals(other.getChkFlg()))
            && (this.getAudFlg() == null ? other.getAudFlg() == null : this.getAudFlg().equals(other.getAudFlg()))
            && (this.getAudUn() == null ? other.getAudUn() == null : this.getAudUn().equals(other.getAudUn()))
            && (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
            && (this.getBrCd() == null ? other.getBrCd() == null : this.getBrCd().equals(other.getBrCd()))
            && (this.getInputDt() == null ? other.getInputDt() == null : this.getInputDt().equals(other.getInputDt()))
            && (this.getLstUpdTlr() == null ? other.getLstUpdTlr() == null : this.getLstUpdTlr().equals(other.getLstUpdTlr()))
            && (this.getLstUpdBrCd() == null ? other.getLstUpdBrCd() == null : this.getLstUpdBrCd().equals(other.getLstUpdBrCd()))
            && (this.getLstUpdDt() == null ? other.getLstUpdDt() == null : this.getLstUpdDt().equals(other.getLstUpdDt()))/*
            && (this.getFinIs() == null ? other.getFinIs() == null : this.getFinIs().equals(other.getFinIs()))
            && (this.getFinBs() == null ? other.getFinBs() == null : this.getFinBs().equals(other.getFinBs()))
            && (this.getFinCs() == null ? other.getFinCs() == null : this.getFinCs().equals(other.getFinCs()))
            && (this.getFinDirIs() == null ? other.getFinDirIs() == null : this.getFinDirIs().equals(other.getFinDirIs()))
            && (this.getFinDirBs() == null ? other.getFinDirBs() == null : this.getFinDirBs().equals(other.getFinDirBs()))
            && (this.getFinDirCs() == null ? other.getFinDirCs() == null : this.getFinDirCs().equals(other.getFinDirCs()))*/;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFinId() == null) ? 0 : getFinId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustNm() == null) ? 0 : getCustNm().hashCode());
        result = prime * result + ((getFinDt() == null) ? 0 : getFinDt().hashCode());
        result = prime * result + ((getFinScp() == null) ? 0 : getFinScp().hashCode());
        result = prime * result + ((getFinPd() == null) ? 0 : getFinPd().hashCode());
        result = prime * result + ((getFinCy() == null) ? 0 : getFinCy().hashCode());
        result = prime * result + ((getFinUn() == null) ? 0 : getFinUn().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getChkFlg() == null) ? 0 : getChkFlg().hashCode());
        result = prime * result + ((getAudFlg() == null) ? 0 : getAudFlg().hashCode());
        result = prime * result + ((getAudUn() == null) ? 0 : getAudUn().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getBrCd() == null) ? 0 : getBrCd().hashCode());
        result = prime * result + ((getInputDt() == null) ? 0 : getInputDt().hashCode());
        result = prime * result + ((getLstUpdTlr() == null) ? 0 : getLstUpdTlr().hashCode());
        result = prime * result + ((getLstUpdBrCd() == null) ? 0 : getLstUpdBrCd().hashCode());
        result = prime * result + ((getLstUpdDt() == null) ? 0 : getLstUpdDt().hashCode());
        /*result = prime * result + ((getFinIs() == null) ? 0 : getFinIs().hashCode());
        result = prime * result + ((getFinBs() == null) ? 0 : getFinBs().hashCode());
        result = prime * result + ((getFinCs() == null) ? 0 : getFinCs().hashCode());
        result = prime * result + ((getFinDirIs() == null) ? 0 : getFinDirIs().hashCode());
        result = prime * result + ((getFinDirBs() == null) ? 0 : getFinDirBs().hashCode());
        result = prime * result + ((getFinDirCs() == null) ? 0 : getFinDirCs().hashCode());*/
        return result;
    }
}