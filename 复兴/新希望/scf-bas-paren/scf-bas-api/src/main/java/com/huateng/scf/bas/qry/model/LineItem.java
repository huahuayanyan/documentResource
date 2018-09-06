/**
 * 
 */
package com.huateng.scf.bas.qry.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>折线图实体类</p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月8日下午3:38:52
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月8日下午3:38:52              新增
 *
 * </pre>
 */
public class LineItem {
	
	
	 
	 private String name; //lengendName
	 List<String> xcontent; //X轴坐标
	 List<Object> data;
	 
	 private BigDecimal value; //饼图的data value

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
	 * @return the data
	 */
	public List<Object> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<Object> data) {
		this.data = data;
	}

	/**
	 * @return the xcontent
	 */
	public List<String> getXcontent() {
		return xcontent;
	}

	/**
	 * @param xcontent the xcontent to set
	 */
	public void setXcontent(List<String> xcontent) {
		this.xcontent = xcontent;
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
