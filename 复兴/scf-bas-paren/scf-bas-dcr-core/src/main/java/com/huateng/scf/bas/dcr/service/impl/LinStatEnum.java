package com.huateng.scf.bas.dcr.service.impl;

enum LinStatEnum {

	VALID("1"), FREEZE("0");
	public String getValue() {
		return value;
	}

	private String value;

	private LinStatEnum(String value) {
		this.value = value;
	};

}
