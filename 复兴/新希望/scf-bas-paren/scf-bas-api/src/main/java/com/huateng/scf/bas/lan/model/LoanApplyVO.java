/**
 * 
 */
package com.huateng.scf.bas.lan.model;

import com.huateng.scf.bas.pbc.model.BPbcAppliBaseInfo;

/**
 * <p>贷款申请的基本信息贷VO对象</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月12日上午10:11:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月12日上午10:11:40              新增
 *
 * </pre>
 */
public class LoanApplyVO extends BPbcAppliBaseInfo {

	private static final long serialVersionUID = 1098070849521962142L;
	private String mastContcode;//信贷合同号

	public String getMastContcode() {
		return mastContcode;
	}

	public void setMastContcode(String mastContcode) {
		this.mastContcode = mastContcode;
	}

}
