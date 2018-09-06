/**
 * 
 */
package com.huateng.scf.bas.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>平台公共Model</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月10日下午8:16:33
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月10日下午8:16:33	                                 新增
 *
 * </pre>
 */
public class PlmBaseModel implements Serializable{

	private static final long serialVersionUID = -6016530404404512713L;

	/**
     * VARCHAR(20) 必填<br>
     * 创建人
     */
    private String tlrcd;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 创建时间
     */
    private Date crtTime;
    
    /**
     * VARCHAR(20)<br>
     * 最后更新操作员
     */
    private String lastUpdTlrcd;

    /**
     * TIMESTAMP(11,6)<br>
     * 最后更新时间
     */
    private Date lastUpdTime;

    /**
     * VARCHAR(20)<br>
     * 最后更新机构
     */
    private String lastUpdBrcode;
    
    

	public PlmBaseModel() {
		
	}

	public PlmBaseModel(String tlrcd, Date crtTime, String lastUpdTlrcd, Date lastUpdTime, String lastUpdBrcode) {
		this.tlrcd = tlrcd;
		this.crtTime = crtTime;
		this.lastUpdTlrcd = lastUpdTlrcd;
		this.lastUpdTime = lastUpdTime;
		this.lastUpdBrcode = lastUpdBrcode;
	}

	/**
	 * @return the tlrcd
	 */
	public String getTlrcd() {
		return tlrcd;
	}

	/**
	 * @param tlrcd the tlrcd to set
	 */
	public void setTlrcd(String tlrcd) {
		this.tlrcd = tlrcd;
	}

	/**
	 * @return the crtTime
	 */
	public Date getCrtTime() {
		return crtTime;
	}

	/**
	 * @param crtTime the crtTime to set
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	/**
	 * @return the lastUpdTlrcd
	 */
	public String getLastUpdTlrcd() {
		return lastUpdTlrcd;
	}

	/**
	 * @param lastUpdTlrcd the lastUpdTlrcd to set
	 */
	public void setLastUpdTlrcd(String lastUpdTlrcd) {
		this.lastUpdTlrcd = lastUpdTlrcd;
	}

	/**
	 * @return the lastUpdTime
	 */
	public Date getLastUpdTime() {
		return lastUpdTime;
	}

	/**
	 * @param lastUpdTime the lastUpdTime to set
	 */
	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	/**
	 * @return the lastUpdBrcode
	 */
	public String getLastUpdBrcode() {
		return lastUpdBrcode;
	}

	/**
	 * @param lastUpdBrcode the lastUpdBrcode to set
	 */
	public void setLastUpdBrcode(String lastUpdBrcode) {
		this.lastUpdBrcode = lastUpdBrcode;
	}
    
    
}
