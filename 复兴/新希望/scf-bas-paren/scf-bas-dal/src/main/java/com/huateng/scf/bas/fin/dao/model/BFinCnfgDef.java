package com.huateng.scf.bas.fin.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BFinCnfgDef实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午9:56:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午9:56:35	     新增
 *
 * </pre>
 */
public class BFinCnfgDef implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 开始	用于客户记录表查询报表格式
     */
    private String finId;
    private String fin;
    private String rpSource;
   
	/**
	 * 结束	用于客户记录表查询报表格式
	 */
	
    /**
     * VARCHAR(32) 必填<br>
     * 模型流水号
     */
    private String serialno;

    /**
     * VARCHAR(6)<br>
     * 模型编号
     */
    private String mdlId;

    /**
     * VARCHAR(9)<br>
     * 财报科目编号
     */
    private String subjId;

    /**
     * VARCHAR(150)<br>
     * 财报科目名称
     */
    private String subjNm;

    /**
     * DECIMAL(22)<br>
     * 顺序编号
     */
    private BigDecimal ord;

    /**
     * DECIMAL(22)<br>
     * 栏位
     */
    private BigDecimal cotes;

    /**
     * CHAR(1)<br>
     * 行次标识
     */
    private String rowFlg;

    /**
     * CHAR(1)<br>
     * 财报科目编辑方式
     */
    private String edTyp;

    /**
     * VARCHAR(2000)<br>
     * 检查公式
     */
    private String chk;

    /**
     * VARCHAR(2000)<br>
     * 计算公式
     */
    private String cal;

    /**
     * CHAR(1)<br>
     * 删除标志
     */
    private String delFlg;

    /**
     * VARCHAR(200)<br>
     * 备注
     */
    private String rem;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 模型流水号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 模型流水号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    /**
     * VARCHAR(6)<br>
     * 获得 模型编号
     */
    public String getMdlId() {
        return mdlId;
    }

    /**
     * VARCHAR(6)<br>
     * 设置 模型编号
     */
    public void setMdlId(String mdlId) {
        this.mdlId = mdlId == null ? null : mdlId.trim();
    }

    /**
     * VARCHAR(9)<br>
     * 获得 财报科目编号
     */
    public String getSubjId() {
        return subjId;
    }

    /**
     * VARCHAR(9)<br>
     * 设置 财报科目编号
     */
    public void setSubjId(String subjId) {
        this.subjId = subjId == null ? null : subjId.trim();
    }

    /**
     * VARCHAR(150)<br>
     * 获得 财报科目名称
     */
    public String getSubjNm() {
        return subjNm;
    }

    /**
     * VARCHAR(150)<br>
     * 设置 财报科目名称
     */
    public void setSubjNm(String subjNm) {
        this.subjNm = subjNm == null ? null : subjNm;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 顺序编号
     */
    public BigDecimal getOrd() {
        return ord;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 顺序编号
     */
    public void setOrd(BigDecimal ord) {
        this.ord = ord;
    }

    /**
     * DECIMAL(22)<br>
     * 获得 栏位
     */
    public BigDecimal getCotes() {
        return cotes;
    }

    /**
     * DECIMAL(22)<br>
     * 设置 栏位
     */
    public void setCotes(BigDecimal cotes) {
        this.cotes = cotes;
    }

    /**
     * CHAR(1)<br>
     * 获得 行次标识
     */
    public String getRowFlg() {
        return rowFlg;
    }

    /**
     * CHAR(1)<br>
     * 设置 行次标识
     */
    public void setRowFlg(String rowFlg) {
        this.rowFlg = rowFlg == null ? null : rowFlg.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 财报科目编辑方式
     */
    public String getEdTyp() {
        return edTyp;
    }

    /**
     * CHAR(1)<br>
     * 设置 财报科目编辑方式
     */
    public void setEdTyp(String edTyp) {
        this.edTyp = edTyp == null ? null : edTyp.trim();
    }

    /**
     * VARCHAR(2000)<br>
     * 获得 检查公式
     */
    public String getChk() {
        return chk;
    }

    /**
     * VARCHAR(2000)<br>
     * 设置 检查公式
     */
    public void setChk(String chk) {
        this.chk = chk == null ? null : chk.trim();
    }

    /**
     * VARCHAR(2000)<br>
     * 获得 计算公式
     */
    public String getCal() {
        return cal;
    }

    /**
     * VARCHAR(2000)<br>
     * 设置 计算公式
     */
    public void setCal(String cal) {
        this.cal = cal == null ? null : cal.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 删除标志
     */
    public String getDelFlg() {
        return delFlg;
    }

    /**
     * CHAR(1)<br>
     * 设置 删除标志
     */
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg == null ? null : delFlg.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 备注
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 备注
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }
    public String getFinId() {
		return finId;
	}

	public void setFinId(String finId) {
		this.finId = finId == null ? null : finId.trim();
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin == null ? null : fin.trim();
	}
	

    /**
	 * @return the rpSource
	 */
	public String getRpSource() {
		return rpSource;
	}

	/**
	 * @param rpSource the rpSource to set
	 */
	public void setRpSource(String rpSource) {
		this.rpSource = rpSource;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialno=").append(serialno);
        sb.append(", mdlId=").append(mdlId);
        sb.append(", subjId=").append(subjId);
        sb.append(", subjNm=").append(subjNm);
        sb.append(", ord=").append(ord);
        sb.append(", cotes=").append(cotes);
        sb.append(", rowFlg=").append(rowFlg);
        sb.append(", edTyp=").append(edTyp);
        sb.append(", chk=").append(chk);
        sb.append(", cal=").append(cal);
        sb.append(", delFlg=").append(delFlg);
        sb.append(", rem=").append(rem);
        sb.append(", finId=").append(finId);
        sb.append(", fin=").append(fin);
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
        BFinCnfgDef other = (BFinCnfgDef) that;
        return (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getMdlId() == null ? other.getMdlId() == null : this.getMdlId().equals(other.getMdlId()))
            && (this.getSubjId() == null ? other.getSubjId() == null : this.getSubjId().equals(other.getSubjId()))
            && (this.getSubjNm() == null ? other.getSubjNm() == null : this.getSubjNm().equals(other.getSubjNm()))
            && (this.getOrd() == null ? other.getOrd() == null : this.getOrd().equals(other.getOrd()))
            && (this.getCotes() == null ? other.getCotes() == null : this.getCotes().equals(other.getCotes()))
            && (this.getRowFlg() == null ? other.getRowFlg() == null : this.getRowFlg().equals(other.getRowFlg()))
            && (this.getEdTyp() == null ? other.getEdTyp() == null : this.getEdTyp().equals(other.getEdTyp()))
            && (this.getChk() == null ? other.getChk() == null : this.getChk().equals(other.getChk()))
            && (this.getCal() == null ? other.getCal() == null : this.getCal().equals(other.getCal()))
            && (this.getDelFlg() == null ? other.getDelFlg() == null : this.getDelFlg().equals(other.getDelFlg()))
            && (this.getRem() == null ? other.getRem() == null : this.getRem().equals(other.getRem()))
            && (this.getFinId() == null ? other.getFinId() == null : this.getFinId().equals(other.getFinId()))
            && (this.getFin() == null ? other.getFin() == null : this.getFin().equals(other.getFin()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getMdlId() == null) ? 0 : getMdlId().hashCode());
        result = prime * result + ((getSubjId() == null) ? 0 : getSubjId().hashCode());
        result = prime * result + ((getSubjNm() == null) ? 0 : getSubjNm().hashCode());
        result = prime * result + ((getOrd() == null) ? 0 : getOrd().hashCode());
        result = prime * result + ((getCotes() == null) ? 0 : getCotes().hashCode());
        result = prime * result + ((getRowFlg() == null) ? 0 : getRowFlg().hashCode());
        result = prime * result + ((getEdTyp() == null) ? 0 : getEdTyp().hashCode());
        result = prime * result + ((getChk() == null) ? 0 : getChk().hashCode());
        result = prime * result + ((getCal() == null) ? 0 : getCal().hashCode());
        result = prime * result + ((getDelFlg() == null) ? 0 : getDelFlg().hashCode());
        result = prime * result + ((getRem() == null) ? 0 : getRem().hashCode());
        result = prime * result + ((getFinId() == null) ? 0 : getFinId().hashCode());
        result = prime * result + ((getFin() == null) ? 0 : getFin().hashCode());
        return result;
    }
}