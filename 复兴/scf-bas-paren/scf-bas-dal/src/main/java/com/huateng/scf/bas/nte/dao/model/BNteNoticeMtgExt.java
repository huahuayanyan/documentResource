/**
 * 
 */
package com.huateng.scf.bas.nte.dao.model;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年4月24日下午2:21:28
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年4月24日下午2:21:28              新增
 *
 * </pre>
 */
public class BNteNoticeMtgExt  extends BNteNoticeMtg{

	private static final long serialVersionUID = -4910141764675944354L;
	
	  private String deliveryNo;

	/**
	 * @return the deliveryNo
	 */
	public String getDeliveryNo() {
		return deliveryNo;
	}

	/**
	 * @param deliveryNo the deliveryNo to set
	 */
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

}
