package com.huateng.scf.bas.cnt.model;

public class BCntSlaveMtgRelExt {
	private String mortgageLevelOneNm;
	
	private String mortgageLevelTwoNm;

	public String getMortgageLevelOneNm() {
		return mortgageLevelOneNm;
	}

	public void setMortgageLevelOneNm(String mortgageLevelOneNm) {
		this.mortgageLevelOneNm = mortgageLevelOneNm == null ? null : mortgageLevelOneNm.trim();
	}

	public String getMortgageLevelTwoNm() {
		return mortgageLevelTwoNm;
	}

	public void setMortgageLevelTwoNm(String mortgageLevelTwoNm) {
		this.mortgageLevelTwoNm = mortgageLevelTwoNm == null ? null : mortgageLevelTwoNm.trim();
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mortgageLevelOneNm=").append(mortgageLevelOneNm);
        sb.append(", mortgageLevelTwoNm=").append(mortgageLevelTwoNm);
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
        BCntSlaveMtgRelExt other = (BCntSlaveMtgRelExt) that;
        return (this.getMortgageLevelOneNm() == null ? other.getMortgageLevelOneNm() == null : this.getMortgageLevelOneNm().equals(other.getMortgageLevelOneNm()))
            && (this.getMortgageLevelTwoNm() == null ? other.getMortgageLevelTwoNm() == null : this.getMortgageLevelTwoNm().equals(other.getMortgageLevelTwoNm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMortgageLevelOneNm() == null) ? 0 : getMortgageLevelOneNm().hashCode());
        result = prime * result + ((getMortgageLevelTwoNm() == null) ? 0 : getMortgageLevelTwoNm().hashCode());
        return result;
    }
}
