/**
 * 
 */
package com.huateng.scf.bas.common.adapter.impl;

import java.util.Map;

import com.huateng.scf.bas.common.adapter.IScfAbsInput;
import com.huateng.toprules.bizobject.PricingGroup;
import com.huateng.toprules.xom.ScfCustBaseInfo;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月25日上午10:53:55
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月25日上午10:53:55             新增
 *
 * </pre>
 */
@SuppressWarnings("rawtypes")
public class ScfCustBaseInfoAdapterInput implements IScfAbsInput{
	private ScfCustBaseInfo scfCustBaseInfo;
	private PricingGroup pricingGroup;
	private Map<String, Object> inputParams;
	/**
	 * @return the scfCustBaseInfo
	 */
	public ScfCustBaseInfo getScfCustBaseInfo() {
		return scfCustBaseInfo;
	}
	/**
	 * @param scfCustBaseInfo the scfCustBaseInfo to set
	 */
	public void setScfCustBaseInfo(ScfCustBaseInfo scfCustBaseInfo) {
		this.scfCustBaseInfo = scfCustBaseInfo;
	}
	/**
	 * @return the inputParams
	 */
	public Map<String, Object> getInputParams() {
		return inputParams;
	}
	/**
	 * @param inputParams the inputParams to set
	 */
	public void setInputParams(Map<String, Object> inputParams) {
		this.inputParams = inputParams;
	}
	/**
	 * @return the pricingGroup
	 */
	public PricingGroup getPricingGroup() {
		return pricingGroup;
	}
	/**
	 * @param pricingGroup the pricingGroup to set
	 */
	public void setPricingGroup(PricingGroup pricingGroup) {
		this.pricingGroup = pricingGroup;
	}
	
	
	
}
