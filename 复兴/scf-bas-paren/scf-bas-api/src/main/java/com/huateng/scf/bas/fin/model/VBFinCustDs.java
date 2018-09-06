package com.huateng.scf.bas.fin.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BFinCustDs实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午9:59:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午9:59:53	     新增
 *
 * </pre>
 */
public class VBFinCustDs implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用于区分该项科目类型
     */
    private boolean flagM;

	/**
     * 开始	用于客户记录表查询报表格式
     */
    private String finId;
    private String fin;
    private String delFlg;
    private String mdlId;
    /**
     * 科目编辑方式 add by huangshuidan 2017-06-10
     */
    private String edTyp;
    private String rpSource;
    private String rptNo;
    private String cal;
    
    private String remark;
    
    private String colVal1Str; //列值1,格式化后

    private String colVal2Str;//列值1,格式化后
    
    
    /**
     * 
     * 子模型
     */
    private VBFinCustDs child; 
    
	/**
	 * 结束	用于客户记录表查询报表格式
	 */

    /**
     * VARCHAR(32) 必填<br>
     * 财报数据流水号
     */
    private String serialno;

    /**
     * VARCHAR(32) 必填<br>
     * 财报目录号
     */
    private String finDirId;

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
     * DECIMAL(24,2)<br>
     * 列值1
     */
    private BigDecimal colVal1;

    /**
     * DECIMAL(24,2)<br>
     * 列值2
     */
    private BigDecimal colVal2;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 财报数据流水号
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 财报数据流水号
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

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
     * DECIMAL(24,2)<br>
     * 获得 列值1
     */
    public BigDecimal getColVal1() {
        return colVal1;
    }

    /**
     * DECIMAL(24,2)<br>
     * 设置 列值1
     */
    public void setColVal1(BigDecimal colVal1) {
        this.colVal1 = colVal1;
    }

    /**
     * DECIMAL(24,2)<br>
     * 获得 列值2
     */
    public BigDecimal getColVal2() {
        return colVal2;
    }

    /**
     * DECIMAL(24,2)<br>
     * 设置 列值2
     */
    public void setColVal2(BigDecimal colVal2) {
        this.colVal2 = colVal2;
    }
    public String getMdlId() {
		return mdlId;
	}

	public void setMdlId(String mdlId) {
		this.mdlId = mdlId == null ? null : mdlId.trim();
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
	
	public String getDelFlg() {
        return delFlg;
    }
	
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg == null ? null : delFlg.trim();
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

	/**
	 * @return the cal
	 */
	public String getCal() {
		return cal;
	}

	/**
	 * @param cal the cal to set
	 */
	public void setCal(String cal) {
		this.cal = cal;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialno=").append(serialno);
        sb.append(", finDirId=").append(finDirId);
        sb.append(", subjId=").append(subjId);
        sb.append(", subjNm=").append(subjNm);
        sb.append(", ord=").append(ord);
        sb.append(", cotes=").append(cotes);
        sb.append(", rowFlg=").append(rowFlg);
        sb.append(", colVal1=").append(colVal1);
        sb.append(", colVal2=").append(colVal2);
        sb.append(", finId=").append(finId);
        sb.append(", fin=").append(fin);
        sb.append(", delFlg=").append(delFlg);
        sb.append(", mdlId=").append(mdlId);
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
        VBFinCustDs other = (VBFinCustDs) that;
        return (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getFinDirId() == null ? other.getFinDirId() == null : this.getFinDirId().equals(other.getFinDirId()))
            && (this.getSubjId() == null ? other.getSubjId() == null : this.getSubjId().equals(other.getSubjId()))
            && (this.getSubjNm() == null ? other.getSubjNm() == null : this.getSubjNm().equals(other.getSubjNm()))
            && (this.getOrd() == null ? other.getOrd() == null : this.getOrd().equals(other.getOrd()))
            && (this.getCotes() == null ? other.getCotes() == null : this.getCotes().equals(other.getCotes()))
            && (this.getRowFlg() == null ? other.getRowFlg() == null : this.getRowFlg().equals(other.getRowFlg()))
            && (this.getColVal1() == null ? other.getColVal1() == null : this.getColVal1().equals(other.getColVal1()))
            && (this.getColVal2() == null ? other.getColVal2() == null : this.getColVal2().equals(other.getColVal2()))
            && (this.getFinId() == null ? other.getFinId() == null : this.getFinId().equals(other.getFinId()))
			&& (this.getFin() == null ? other.getFin() == null : this.getFin().equals(other.getFin()))
			&& (this.getDelFlg() == null ? other.getDelFlg() == null : this.getDelFlg().equals(other.getDelFlg()))
			&& (this.getMdlId() == null ? other.getMdlId() == null : this.getMdlId().equals(other.getMdlId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getFinDirId() == null) ? 0 : getFinDirId().hashCode());
        result = prime * result + ((getSubjId() == null) ? 0 : getSubjId().hashCode());
        result = prime * result + ((getSubjNm() == null) ? 0 : getSubjNm().hashCode());
        result = prime * result + ((getOrd() == null) ? 0 : getOrd().hashCode());
        result = prime * result + ((getCotes() == null) ? 0 : getCotes().hashCode());
        result = prime * result + ((getRowFlg() == null) ? 0 : getRowFlg().hashCode());
        result = prime * result + ((getColVal1() == null) ? 0 : getColVal1().hashCode());
        result = prime * result + ((getColVal2() == null) ? 0 : getColVal2().hashCode());
        result = prime * result + ((getFinId() == null) ? 0 : getFinId().hashCode());
        result = prime * result + ((getFin() == null) ? 0 : getFin().hashCode());
        result = prime * result + ((getDelFlg() == null) ? 0 : getDelFlg().hashCode());
        result = prime * result + ((getMdlId() == null) ? 0 : getMdlId().hashCode());
        return result;
    }

	public VBFinCustDs getChild() {
		return child;
	}

	public void setChild(VBFinCustDs child) {
		this.child = child;
	}

	/**
	 * @return the edTyp
	 */
	public String getEdTyp() {
		return edTyp;
	}

	/**
	 * @param edTyp the edTyp to set
	 */
	public void setEdTyp(String edTyp) {
		this.edTyp = edTyp;
	}

	/**
	 * @return the flagM
	 */
	public boolean isFlagM() {
		return flagM;
	}

	/**
	 * @param flagM the flagM to set
	 */
	public void setFlagM(boolean flagM) {
		this.flagM = flagM;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the colVal1Str
	 */
	public String getColVal1Str() {
		return colVal1Str;
	}

	/**
	 * @param colVal1Str the colVal1Str to set
	 */
	public void setColVal1Str(String colVal1Str) {
		this.colVal1Str = colVal1Str;
	}

	/**
	 * @return the colVal2Str
	 */
	public String getColVal2Str() {
		return colVal2Str;
	}

	/**
	 * @param colVal2Str the colVal2Str to set
	 */
	public void setColVal2Str(String colVal2Str) {
		this.colVal2Str = colVal2Str;
	}
	
}