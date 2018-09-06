package com.huateng.scf.bas.crr.model;

import java.io.Serializable;
/**
 * 
 * <p>BCrrModel实体类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年12月1日下午3:32:04
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年12月1日下午3:32:04	     新增
 *
 * </pre>
 */
public class BCrrModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8965934568658028448L;

	/**
     * VARCHAR(32)<br>
     * 登记人
     */
    protected String tlrNo;

    /**
     * VARCHAR(32)<br>
     * 登记人名称
     */
    protected String tlrNm;

    /**
     * VARCHAR(32)<br>
     * 登记机构
     */
    protected String brCd;

    /**
     * VARCHAR(32)<br>
     * 登记机构名称
     */
    protected String brNm;

    /**
     * VARCHAR(20)<br>
     * 登记日期
     */
    protected String inpDt;

    /**
     * VARCHAR(32)<br>
     * 更新人
     */
    protected String lstUpdTlr;

    /**
     * VARCHAR(32)<br>
     * 更新人名称
     */
    protected String lstUpdTlrNm;

    /**
     * VARCHAR(32)<br>
     * 更新机构
     */
    protected String lstUpdBrCd;

    /**
     * VARCHAR(32)<br>
     * 更新机构名称
     */
    protected String lstUpdBrNm;

    /**
     * VARCHAR(20)<br>
     * 更新日期
     */
    protected String lstUpdDt;
    
    public BCrrModel() {
		
	}

	public BCrrModel(String tlrNo, String tlrNm, String brCd, String brNm, String inpDt,String lstUpdTlr,String lstUpdTlrNm,String lstUpdBrCd,String lstUpdBrNm,String lstUpdDt) {
		this.tlrNo = tlrNo;
		this.tlrNm = tlrNm;
		this.brCd = brCd;
		this.brNm = brNm;
		this.inpDt = inpDt;
		this.lstUpdTlr = lstUpdTlr;
		this.lstUpdTlrNm = lstUpdTlrNm;
		this.lstUpdBrCd = lstUpdBrCd;
		this.lstUpdBrNm = lstUpdBrNm;
		this.lstUpdDt = lstUpdDt;
	}
	
    /**
     * VARCHAR(32)<br>
     * 获得 登记人
     */
    public String getTlrNo() {
        return tlrNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记人
     */
    public void setTlrNo(String tlrNo) {
        this.tlrNo = tlrNo == null ? null : tlrNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记人名称
     */
    public String getTlrNm() {
        return tlrNm;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记人名称
     */
    public void setTlrNm(String tlrNm) {
        this.tlrNm = tlrNm == null ? null : tlrNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记机构
     */
    public String getBrCd() {
        return brCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记机构
     */
    public void setBrCd(String brCd) {
        this.brCd = brCd == null ? null : brCd.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 登记机构名称
     */
    public String getBrNm() {
        return brNm;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 登记机构名称
     */
    public void setBrNm(String brNm) {
        this.brNm = brNm == null ? null : brNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 登记日期
     */
    public String getInpDt() {
        return inpDt;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 登记日期
     */
    public void setInpDt(String inpDt) {
        this.inpDt = inpDt == null ? null : inpDt.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新人
     */
    public String getLstUpdTlr() {
        return lstUpdTlr;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新人
     */
    public void setLstUpdTlr(String lstUpdTlr) {
        this.lstUpdTlr = lstUpdTlr == null ? null : lstUpdTlr.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新人名称
     */
    public String getLstUpdTlrNm() {
        return lstUpdTlrNm;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新人名称
     */
    public void setLstUpdTlrNm(String lstUpdTlrNm) {
        this.lstUpdTlrNm = lstUpdTlrNm == null ? null : lstUpdTlrNm.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新机构
     */
    public String getLstUpdBrCd() {
        return lstUpdBrCd;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新机构
     */
    public void setLstUpdBrCd(String lstUpdBrCd) {
        this.lstUpdBrCd = lstUpdBrCd == null ? null : lstUpdBrCd.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 更新机构名称
     */
    public String getLstUpdBrNm() {
        return lstUpdBrNm;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 更新机构名称
     */
    public void setLstUpdBrNm(String lstUpdBrNm) {
        this.lstUpdBrNm = lstUpdBrNm == null ? null : lstUpdBrNm.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 更新日期
     */
    public String getLstUpdDt() {
        return lstUpdDt;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 更新日期
     */
    public void setLstUpdDt(String lstUpdDt) {
        this.lstUpdDt = lstUpdDt == null ? null : lstUpdDt.trim();
    }
}
