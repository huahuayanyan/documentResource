/**
 * 
 */
package com.huateng.scf.bas.qry.model;

import java.math.BigDecimal;

/**
 * <p>
 * </p>
 *
 * @author shangxiujuan
 * @date 2017年6月29日下午2:08:50
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月29日下午2:08:50              新增
 *
 *            </pre>
 */
public class PointData {

	private String name;
	private BigDecimal value;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
