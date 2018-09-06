/**
 * 
 */
package com.huateng.scf.bas.qry.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangshuidan
 * @date 2017年6月23日下午2:24:53
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年6月23日下午2:24:53             新增
 *
 * </pre>
 */
public class SeriesData implements Serializable{
	private static final long serialVersionUID = 822121626365791018L;
	private String name; //SeriesData 的name 属性
	private BigDecimal value; //SeriesData 的value
	
	
	public SeriesData() {
		
	}


	public SeriesData(String name, BigDecimal value) {
		this.name = name;
		this.value = value;
	}


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
