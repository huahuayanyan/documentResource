package com.huateng.scf.bas.dcr.service.impl;

enum InfTypeEnum {

	ROOT("0"), BRANCH("1"), LEAF("2");
	public String getValue() {
		return value;
	}

	private String value;

	private InfTypeEnum(String value) {
		this.value = value;
	};

}
