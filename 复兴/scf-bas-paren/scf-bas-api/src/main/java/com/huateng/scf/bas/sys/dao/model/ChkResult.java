package com.huateng.scf.bas.sys.dao.model;

public class ChkResult {


    /**
     * VARCHAR(1024)<br>
     * 结果描述
     */
    private String rem;

    /**
     * CHAR(2)<br>
     * 执行结果
     */
    private String stat;


    /**
     * VARCHAR(1024)<br>
     * 获得 结果描述
     */
    public String getRem() {
        return rem;
    }

    /**
     * VARCHAR(1024)<br>
     * 设置 结果描述
     */
    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 执行结果
     */
    public String getStat() {
        return stat;
    }

    /**
     * CHAR(2)<br>
     * 设置 执行结果
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }



}