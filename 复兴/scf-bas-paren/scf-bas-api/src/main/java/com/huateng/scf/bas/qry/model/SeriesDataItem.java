/**
 * 
 */
package com.huateng.scf.bas.qry.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月10日上午11:37:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月10日上午11:37:21              新增
 *
 * </pre>
 */
public class SeriesDataItem {
	
	 private String name; //SeriesData 的name 属性
	// private String value; //SeriesData 的value
	 private List<Object> value; //SeriesData 的value集合

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
	public List<Object> getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(List<Object> value) {
		this.value = value;
	}
 


	

}
