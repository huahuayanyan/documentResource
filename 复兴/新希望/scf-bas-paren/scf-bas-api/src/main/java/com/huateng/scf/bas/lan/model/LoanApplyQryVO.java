/**
 * 
 */
package com.huateng.scf.bas.lan.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * <p>放款查询的VO对象</p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月10日下午1:44:58
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月10日下午1:44:58              新增
 *
 * </pre>
 */
public class LoanApplyQryVO extends CommonQryVO {

	private static final long serialVersionUID = 3570394747531492510L;
	private String appliStatusDtl; // 审批状态
	private String debetId; // 借据号(承兑协议号)
	private String SupplyChainPdId; //产品ID

	public String getSupplyChainPdId() {
		return SupplyChainPdId;
	}

	public LoanApplyQryVO()
	{

	}
	
	public void setSupplyChainPdId(String supplyChainPdId) {
		SupplyChainPdId = supplyChainPdId;
	}

	public String getAppliStatusDtl() {
		return appliStatusDtl;
	}

	public void setAppliStatusDtl(String appliStatusDtl) {
		this.appliStatusDtl = appliStatusDtl;
	}

	public String getDebetId() {
		return debetId;
	}

	public void setDebetId(String debetId) {
		this.debetId = debetId;
	}
}