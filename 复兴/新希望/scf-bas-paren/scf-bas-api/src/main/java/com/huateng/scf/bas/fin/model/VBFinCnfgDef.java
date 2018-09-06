package com.huateng.scf.bas.fin.model;

import java.math.BigDecimal;
/**
 * 
 * <p>BFinCnfgDef实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午10:00:35
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午10:00:35	     新增
 *
 * </pre>
 */
public class VBFinCnfgDef {

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
    private String rpSource;//报表周期

	public BigDecimal getColVal1() {
		return colVal1;
	}

	public void setColVal1(BigDecimal colVal1) {
		this.colVal1 = colVal1;
	}

	public BigDecimal getColVal2() {
		return colVal2;
	}

	public void setColVal2(BigDecimal colVal2) {
		this.colVal2 = colVal2;
	}

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
     * 
     * 子模型
     */
    private VBFinCnfgDef child; 
    
    

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




	public VBFinCnfgDef getChild() {
		return child;
	}

	public void setChild(VBFinCnfgDef child) {
		this.child = child;
	}
}