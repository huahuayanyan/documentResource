package com.huateng.scf.bas.crr.dao.model;

import java.math.BigDecimal;

public class BCrrBussExt {
	
	/**
	 * 业务品种父类ID
	 */
	private String parentId;
	
	/**
     * VARCHAR(60)<br>
     * 供应链业务品种名称
     */
    private String vidPrdNm;
    
    /**
     * 供应链出账方式
     */
    private String loanWay;
    
    /**
     * 账务机构名称
     */
    private String actBrNm;
    
    /**
     * 应收账款总额
     */
    private BigDecimal ysTotalAmt;
    
    /**
     * 赎货期限
     */
    private String drawbackTerm;
    
    /**
     * 有效间接额度可用余额
     */
    private BigDecimal creditBalAmt;
    
    /**
     * 买方名称
     */
    private String cname;

    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	/**
     * VARCHAR(60)<br>
     * 获得 供应链业务品种名称
     */
    public String getVidPrdNm() {
        return vidPrdNm;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 供应链业务品种名称
     */
    public void setVidPrdNm(String vidPrdNm) {
        this.vidPrdNm = vidPrdNm == null ? null : vidPrdNm.trim();
    }
    
    public String getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(String loanWay) {
		this.loanWay = loanWay == null ? null : loanWay.trim();
	}

	public String getActBrNm() {
		return actBrNm;
	}

	public void setActBrNm(String actBrNm) {
		this.actBrNm = actBrNm == null ? null : actBrNm.trim();
	}
	
	public String getDrawbackTerm() {
		return drawbackTerm;
	}

	public void setDrawbackTerm(String drawbackTerm) {
		this.drawbackTerm = drawbackTerm;
	}

	public BigDecimal getCreditBalAmt() {
		return creditBalAmt;
	}

	public void setCreditBalAmt(BigDecimal creditBalAmt) {
		this.creditBalAmt = creditBalAmt;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public BigDecimal getYsTotalAmt() {
		return ysTotalAmt;
	}

	public void setYsTotalAmt(BigDecimal ysTotalAmt) {
		this.ysTotalAmt = ysTotalAmt;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vidPrdNm=").append(vidPrdNm);
        sb.append(", loanWay=").append(loanWay);
        sb.append(", actBrNm=").append(actBrNm);
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
        BCrrBussExt other = (BCrrBussExt) that;
        return (this.getVidPrdNm() == null ? other.getVidPrdNm() == null : this.getVidPrdNm().equals(other.getVidPrdNm()))
        	&& (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()))
        	&& (this.getActBrNm() == null ? other.getActBrNm() == null : this.getActBrNm().equals(other.getActBrNm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVidPrdNm() == null) ? 0 : getVidPrdNm().hashCode());
        result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
        result = prime * result + ((getActBrNm() == null) ? 0 : getActBrNm().hashCode());
        return result;
    }
}
