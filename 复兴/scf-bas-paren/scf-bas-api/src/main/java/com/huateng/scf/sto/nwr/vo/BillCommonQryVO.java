package com.huateng.scf.sto.nwr.vo;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * 
 * <p>应收类通用查询条件VO</p>
 *
 * @author 	mengjiajia
 * @date 	2017年4月21日上午11:16:31
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年4月21日上午11:16:31	     新增
 *
 * </pre>
 */
public class BillCommonQryVO extends CommonQryVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String supplyChainPdId;   //产品ID

	public String getSupplyChainPdId() {
		return supplyChainPdId;
	}

	public void setSupplyChainPdId(String supplyChainPdId) {
		this.supplyChainPdId = supplyChainPdId;
	}




}