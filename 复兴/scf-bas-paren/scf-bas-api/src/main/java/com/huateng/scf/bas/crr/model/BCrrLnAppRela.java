package com.huateng.scf.bas.crr.model;

import java.io.Serializable;

public class BCrrLnAppRela extends BCrrLnAppRelaKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(5) 默认值['01' ] 必填<br>
     * 
     */
    private String isRelate;

    /**
     * VARCHAR(5) 默认值['01' ] 必填<br>
     */
    public String getIsRelate() {
        return isRelate;
    }

    /**
     * VARCHAR(5) 默认值['01' ] 必填<br>
     */
    public void setIsRelate(String isRelate) {
        this.isRelate = isRelate == null ? null : isRelate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", isRelate=").append(isRelate);
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
        BCrrLnAppRela other = (BCrrLnAppRela) that;
        return (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getRltTyp() == null ? other.getRltTyp() == null : this.getRltTyp().equals(other.getRltTyp()))
            && (this.getRltNo() == null ? other.getRltNo() == null : this.getRltNo().equals(other.getRltNo()))
            && (this.getIsRelate() == null ? other.getIsRelate() == null : this.getIsRelate().equals(other.getIsRelate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getRltTyp() == null) ? 0 : getRltTyp().hashCode());
        result = prime * result + ((getRltNo() == null) ? 0 : getRltNo().hashCode());
        result = prime * result + ((getIsRelate() == null) ? 0 : getIsRelate().hashCode());
        return result;
    }
}