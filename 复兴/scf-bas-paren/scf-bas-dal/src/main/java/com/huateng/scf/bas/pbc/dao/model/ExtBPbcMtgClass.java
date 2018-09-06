package com.huateng.scf.bas.pbc.dao.model;

import java.io.Serializable;

public class ExtBPbcMtgClass extends BPbcMtgClass implements Serializable {
    private static final long serialVersionUID = 1L;

    private String brname;

	public String getBrname() {
		return brname;
	}

	public void setBrname(String brname) {
		this.brname = brname;
	}
}