/**
 * 
 */
package com.huateng.scf.bas.common.adapter.impl;

import java.util.Map;

import com.huateng.scf.bas.common.adapter.IScfAbsOutput;
import com.huateng.toprules.xom.PersonInfo;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangshuidan
 * @date 2017年5月22日上午10:27:02
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2017年5月22日上午10:27:02             新增
 *
 * </pre>
 */
public class PersonInfoAdapterOutput implements IScfAbsOutput{
	private PersonInfo personInfo;
	private Map<String, Object> extOut;

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
