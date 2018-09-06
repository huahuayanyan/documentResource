package com.huateng.scf.bas.crr.dao.model;

public class BCrrVidPrdExt {
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

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vidPrdNm=").append(vidPrdNm);
        sb.append(", loanWay=").append(loanWay);
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
        BCrrVidPrdExt other = (BCrrVidPrdExt) that;
        return (this.getVidPrdNm() == null ? other.getVidPrdNm() == null : this.getVidPrdNm().equals(other.getVidPrdNm()))
        	&& (this.getLoanWay() == null ? other.getLoanWay() == null : this.getLoanWay().equals(other.getLoanWay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVidPrdNm() == null) ? 0 : getVidPrdNm().hashCode());
        result = prime * result + ((getLoanWay() == null) ? 0 : getLoanWay().hashCode());
        return result;
    }
}
