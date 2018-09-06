package com.huateng.scf.bas.fin.model;

import java.io.Serializable;
/**
 * 
 * <p>BFinCnfgSubj实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月12日上午10:00:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月12日上午10:00:26	     新增
 *
 * </pre>
 */
public class BFinCnfgSubj implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 财报科目名称与编号组合
     */
    private String subj;
    public String getSubj() {
		return subj;
	}

	public void setSubj(String subj) {
		this.subj = subj;
	}
    /**
     * VARCHAR(9) 必填<br>
     * 财报科目编号
     */
    private String subjId;

    /**
     * VARCHAR(150) 必填<br>
     * 财报科目名称
     */
    private String subjNm;

    /**
     * VARCHAR(250)<br>
     * 备注
     */
    private String rem;

    /**
     * CHAR(1)<br>
     * 删除标志
     */
    private String delFlg;

    /**
     * VARCHAR(9) 必填<br>
     * 获得 财报科目编号
     */
    public String getSubjId() {
        return subjId;
    }

    /**
     * VARCHAR(9) 必填<br>
     * 设置 财报科目编号
     */
    public void setSubjId(String subjId) {
        this.subjId = subjId == null ? null : subjId.trim();
    }

    /**
     * VARCHAR(150) 必填<br>
     * 获得 财报科目名称
     */
    public String getSubjNm() {
        return subjNm;
    }

    /**
     * VARCHAR(150) 必填<br>
     * 设置 财报科目名称
     */
    public void setSubjNm(String subjNm) {
        this.subjNm = subjNm == null ? null : subjNm.trim();
    }

    /**
     * VARCHAR(250)<br>
     * 获得 备注
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(250)<br>
     * 设置 备注
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subjId=").append(subjId);
        sb.append(", subjNm=").append(subjNm);
        sb.append(", rem=").append(rem);
        sb.append(", delFlg=").append(delFlg);
        sb.append(", subj=").append(subj);
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
        BFinCnfgSubj other = (BFinCnfgSubj) that;
        return (this.getSubjId() == null ? other.getSubjId() == null : this.getSubjId().equals(other.getSubjId()))
            && (this.getSubjNm() == null ? other.getSubjNm() == null : this.getSubjNm().equals(other.getSubjNm()))
            && (this.getRem() == null ? other.getRem() == null : this.getRem().equals(other.getRem()))
            && (this.getDelFlg() == null ? other.getDelFlg() == null : this.getDelFlg().equals(other.getDelFlg()))
            && (this.getSubj() == null ? other.getSubj() == null : this.getSubj().equals(other.getSubj()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSubjId() == null) ? 0 : getSubjId().hashCode());
        result = prime * result + ((getSubjNm() == null) ? 0 : getSubjNm().hashCode());
        result = prime * result + ((getRem() == null) ? 0 : getRem().hashCode());
        result = prime * result + ((getDelFlg() == null) ? 0 : getDelFlg().hashCode());
        result = prime * result + ((getSubj() == null) ? 0 : getSubj().hashCode());
        return result;
    }
}