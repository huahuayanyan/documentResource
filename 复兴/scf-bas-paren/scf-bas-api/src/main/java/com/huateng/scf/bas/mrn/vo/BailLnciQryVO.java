package com.huateng.scf.bas.mrn.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 *
 * 保证金借据查询VO
 * @author <a href="mailto:shuidan_huang@topscf.com">shuidan_huang</a>
 *
 * @date 2014-1-2 上午03:34:55
 *
 * @version Revision: 1.0
 *
 */
public class BailLnciQryVO extends CommonQryVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lnciStatus_Q;//借据状态
	private String debetNo_Q;//单据号
	private String debetId_Q;//子合同外部合同号

	/**
	 * @return the lnciStatus_Q
	 */
	public String getLnciStatus_Q() {
		return lnciStatus_Q;
	}
	/**
	 * @param lnciStatus_Q the lnciStatus_Q to set
	 */
	public void setLnciStatus_Q(String lnciStatus_Q) {
		this.lnciStatus_Q = lnciStatus_Q;
	}
	/**
	 * @return the debetNo_Q
	 */
	public String getDebetNo_Q() {
		return debetNo_Q;
	}
	/**
	 * @param debetNo_Q the debetNo_Q to set
	 */
	public void setDebetNo_Q(String debetNo_Q) {
		this.debetNo_Q = debetNo_Q;
	}
	/**
	 * @return the debetId_Q
	 */
	public String getDebetId_Q() {
		return debetId_Q;
	}
	/**
	 * @param debetId_Q the debetId_Q to set
	 */
	public void setDebetId_Q(String debetId_Q) {
		this.debetId_Q = debetId_Q;
	}



}
