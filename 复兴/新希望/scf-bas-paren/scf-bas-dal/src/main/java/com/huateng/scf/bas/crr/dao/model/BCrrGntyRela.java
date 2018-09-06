package com.huateng.scf.bas.crr.dao.model;

import java.io.Serializable;
/**
 * 
 * <p>BCrrGntyRela实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月24日下午3:45:54
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月24日下午3:45:54	     新增
 *
 * </pre>
 */
public class BCrrGntyRela extends BCrrGntyRelaKey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(18)<br>
     * 数据来源渠道
     */
    private String channel;

    /**
     * VARCHAR(18)<br>
     * 他项权证状态
     */
    private String stat;

    /**
     * VARCHAR(32)<br>
     * 他项权证号
     */
    private String othGntyRid;

    /**
     * VARCHAR(32)<br>
     * 担保债权金额
     */
    private String gntySum;

    /**
     * VARCHAR(200)<br>
     * 他项权证内容
     */
    private String des;

    /**
     * VARCHAR(18)<br>
     * 受偿次序
     */
    private String payOrd;

    /**
     * VARCHAR(18)<br>
     * 数据来源类型
     */
    private String typ;

    /**
     * VARCHAR(18)<br>
     * 获得 数据来源渠道
     */
    public String getChannel() {
        return channel;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 数据来源渠道
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 他项权证状态
     */
    public String getStat() {
        return stat;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 他项权证状态
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 他项权证号
     */
    public String getOthGntyRid() {
        return othGntyRid;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 他项权证号
     */
    public void setOthGntyRid(String othGntyRid) {
        this.othGntyRid = othGntyRid == null ? null : othGntyRid.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 担保债权金额
     */
    public String getGntySum() {
        return gntySum;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 担保债权金额
     */
    public void setGntySum(String gntySum) {
        this.gntySum = gntySum == null ? null : gntySum.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 他项权证内容
     */
    public String getDes() {
        return des;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 他项权证内容
     */
    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 受偿次序
     */
    public String getPayOrd() {
        return payOrd;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 受偿次序
     */
    public void setPayOrd(String payOrd) {
        this.payOrd = payOrd == null ? null : payOrd.trim();
    }

    /**
     * VARCHAR(18)<br>
     * 获得 数据来源类型
     */
    public String getTyp() {
        return typ;
    }

    /**
     * VARCHAR(18)<br>
     * 设置 数据来源类型
     */
    public void setTyp(String typ) {
        this.typ = typ == null ? null : typ.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channel=").append(channel);
        sb.append(", stat=").append(stat);
        sb.append(", othGntyRid=").append(othGntyRid);
        sb.append(", gntySum=").append(gntySum);
        sb.append(", des=").append(des);
        sb.append(", payOrd=").append(payOrd);
        sb.append(", typ=").append(typ);
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
        BCrrGntyRela other = (BCrrGntyRela) that;
        return (this.getRltTyp() == null ? other.getRltTyp() == null : this.getRltTyp().equals(other.getRltTyp()))
            && (this.getRltNo() == null ? other.getRltNo() == null : this.getRltNo().equals(other.getRltNo()))
            && (this.getConNo() == null ? other.getConNo() == null : this.getConNo().equals(other.getConNo()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
            && (this.getOthGntyRid() == null ? other.getOthGntyRid() == null : this.getOthGntyRid().equals(other.getOthGntyRid()))
            && (this.getGntySum() == null ? other.getGntySum() == null : this.getGntySum().equals(other.getGntySum()))
            && (this.getDes() == null ? other.getDes() == null : this.getDes().equals(other.getDes()))
            && (this.getPayOrd() == null ? other.getPayOrd() == null : this.getPayOrd().equals(other.getPayOrd()))
            && (this.getTyp() == null ? other.getTyp() == null : this.getTyp().equals(other.getTyp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRltTyp() == null) ? 0 : getRltTyp().hashCode());
        result = prime * result + ((getRltNo() == null) ? 0 : getRltNo().hashCode());
        result = prime * result + ((getConNo() == null) ? 0 : getConNo().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getOthGntyRid() == null) ? 0 : getOthGntyRid().hashCode());
        result = prime * result + ((getGntySum() == null) ? 0 : getGntySum().hashCode());
        result = prime * result + ((getDes() == null) ? 0 : getDes().hashCode());
        result = prime * result + ((getPayOrd() == null) ? 0 : getPayOrd().hashCode());
        result = prime * result + ((getTyp() == null) ? 0 : getTyp().hashCode());
        return result;
    }
}