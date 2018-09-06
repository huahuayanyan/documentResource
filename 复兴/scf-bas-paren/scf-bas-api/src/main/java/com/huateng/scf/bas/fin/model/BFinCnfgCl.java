package com.huateng.scf.bas.fin.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * <p>BFinCnfgCl实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午9:59:05
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午9:59:05	     新增
 *
 * </pre>
 */
public class BFinCnfgCl implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String finDirId;

    public String getFinDirId() {
		return finDirId;
	}

	public void setFinDirId(String finDirId) {
		this.finDirId = finDirId == null ? null : finDirId.trim();
	}

	/**
     * VARCHAR(6) 必填<br>
     * 模型编号
     */
    private String mdlId;

    /**
     * VARCHAR(200) 必填<br>
     * 模型名称
     */
    private String mdlNm;

    /**
     * VARCHAR(18) 必填<br>
     * 模型分类
     */
    private String mdlCl;
    
    /**
     * VARCHAR(18) 必填<br>
     * 模型种类
     */
    private String mdlTyp;

    /**
     * DECIMAL(22) 必填<br>
     * 数据列数
     */
    private BigDecimal col;

    /**
     * DECIMAL(22) 必填<br>
     * 栏位
     */
    private BigDecimal cotes;

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
     * VARCHAR(6) 必填<br>
     * 获得 模型编号
     */
    public String getMdlId() {
        return mdlId;
    }

    /**
     * VARCHAR(6) 必填<br>
     * 设置 模型编号
     */
    public void setMdlId(String mdlId) {
        this.mdlId = mdlId == null ? null : mdlId.trim();
    }

    /**
     * VARCHAR(200) 必填<br>
     * 获得 模型名称
     */
    public String getMdlNm() {
        return mdlNm;
    }

    /**
     * VARCHAR(200) 必填<br>
     * 设置 模型名称
     */
    public void setMdlNm(String mdlNm) {
        this.mdlNm = mdlNm == null ? null : mdlNm.trim();
    }

    /**
     * VARCHAR(18) 必填<br>
     * 获得 模型分类
     */
    public String getMdlCl() {
        return mdlCl;
    }

    /**
     * VARCHAR(18) 必填<br>
     * 设置 模型分类
     */
    public void setMdlCl(String mdlCl) {
        this.mdlCl = mdlCl == null ? null : mdlCl.trim();
    }

    /**
     * VARCHAR(18) 必填<br>
     * 获得 模型种类
     */
    public String getMdlTyp() {
		return mdlTyp;
	}

    /**
     * VARCHAR(18) 必填<br>
     * 设置 模型种类
     */
	public void setMdlTyp(String mdlTyp) {
		this.mdlTyp = mdlTyp;
	}

	/**
     * DECIMAL(22) 必填<br>
     * 获得 数据列数
     */
    public BigDecimal getCol() {
        return col;
    }

    /**
     * DECIMAL(22) 必填<br>
     * 设置 数据列数
     */
    public void setCol(BigDecimal col) {
        this.col = col;
    }

    /**
     * DECIMAL(22) 必填<br>
     * 获得 栏位
     */
    public BigDecimal getCotes() {
        return cotes;
    }

    /**
     * DECIMAL(22) 必填<br>
     * 设置 栏位
     */
    public void setCotes(BigDecimal cotes) {
        this.cotes = cotes;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mdlId=").append(mdlId);
        sb.append(", mdlNm=").append(mdlNm);
        sb.append(", mdlCl=").append(mdlCl);
        sb.append(", col=").append(col);
        sb.append(", cotes=").append(cotes);
        sb.append(", delFlg=").append(delFlg);
        sb.append(", rem=").append(rem);
        sb.append(", mdlTyp=").append(mdlTyp);
        sb.append(", finDirId=").append(finDirId);
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
        BFinCnfgCl other = (BFinCnfgCl) that;
        return (this.getMdlId() == null ? other.getMdlId() == null : this.getMdlId().equals(other.getMdlId()))
            && (this.getMdlNm() == null ? other.getMdlNm() == null : this.getMdlNm().equals(other.getMdlNm()))
            && (this.getMdlCl() == null ? other.getMdlCl() == null : this.getMdlCl().equals(other.getMdlCl()))
            && (this.getCol() == null ? other.getCol() == null : this.getCol().equals(other.getCol()))
            && (this.getCotes() == null ? other.getCotes() == null : this.getCotes().equals(other.getCotes()))
            && (this.getDelFlg() == null ? other.getDelFlg() == null : this.getDelFlg().equals(other.getDelFlg()))
            && (this.getRem() == null ? other.getRem() == null : this.getRem().equals(other.getRem()))
            && (this.getMdlTyp() == null ? other.getMdlTyp() == null : this.getMdlTyp().equals(other.getMdlTyp()))
            && (this.getFinDirId() == null ? other.getFinDirId() == null : this.getFinDirId().equals(other.getFinDirId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMdlId() == null) ? 0 : getMdlId().hashCode());
        result = prime * result + ((getMdlNm() == null) ? 0 : getMdlNm().hashCode());
        result = prime * result + ((getMdlCl() == null) ? 0 : getMdlCl().hashCode());
        result = prime * result + ((getCol() == null) ? 0 : getCol().hashCode());
        result = prime * result + ((getCotes() == null) ? 0 : getCotes().hashCode());
        result = prime * result + ((getDelFlg() == null) ? 0 : getDelFlg().hashCode());
        result = prime * result + ((getRem() == null) ? 0 : getRem().hashCode());
        result = prime * result + ((getMdlTyp() == null) ? 0 : getMdlTyp().hashCode());
        result = prime * result + ((getFinDirId() == null) ? 0 : getFinDirId().hashCode());
        return result;
    }
}