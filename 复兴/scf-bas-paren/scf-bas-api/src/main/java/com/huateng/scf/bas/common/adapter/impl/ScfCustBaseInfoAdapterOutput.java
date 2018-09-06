/**
 * 
 */
package com.huateng.scf.bas.common.adapter.impl;

import java.util.Map;

import com.huateng.scf.bas.common.adapter.IScfAbsOutput;
import com.huateng.toprules.bizobject.PricingGroup;
import com.huateng.toprules.xom.ProductInfo;
import com.huateng.toprules.xom.ScfCustBaseInfo;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月25日上午10:57:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月25日上午10:57:57             新增
 *
 * </pre>
 */
@SuppressWarnings("rawtypes")
public class ScfCustBaseInfoAdapterOutput implements IScfAbsOutput{
	private ScfCustBaseInfo scfCustBaseInfo;
	private PricingGroup pricingGroup;
	private ProductInfo productInfo;
	private Map<String, Object> extOut;
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
	 * @return the extOut
	 */
	public Map<String, Object> getExtOut() {
		return extOut;
	}
	/**
	 * @param extOut the extOut to set
	 */
	public void setExtOut(Map<String, Object> extOut) {
		this.extOut = extOut;
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
	/**
	 * @return the productInfo
	 */
	public ProductInfo getProductInfo() {
		return productInfo;
	}
	/**
	 * @param productInfo the productInfo to set
	 */
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
	
	
	
	
	
}
