package com.huateng.scf.bas.cnt.dao.model.ext;

import java.io.Serializable;

public class DataItems implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR() 默认值[] 必填<br>
	 * 代码
	 */
	private String code;

	/**
	 * VARCHAR() 默认值[] 必填<br>
	 * 名称
	 */
	private String codeName;

	public String getCode() {
		return code;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

}
