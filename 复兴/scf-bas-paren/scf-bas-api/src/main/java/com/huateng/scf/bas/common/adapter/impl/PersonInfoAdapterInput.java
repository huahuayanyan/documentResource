/**
 * 
 */
package com.huateng.scf.bas.common.adapter.impl;

import java.util.Map;

import com.huateng.scf.bas.common.adapter.IScfAbsInput;
import com.huateng.toprules.xom.PersonInfo;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月22日上午10:14:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月22日上午10:14:26             新增
 *
 * </pre>
 */
public class PersonInfoAdapterInput implements IScfAbsInput{
	private PersonInfo personInfo;
	private Map<String, Object> inputParams;

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
	 * @return the personInfo
	 */
	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	/**
	 * @param personInfo the personInfo to set
	 */
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	
	
}
