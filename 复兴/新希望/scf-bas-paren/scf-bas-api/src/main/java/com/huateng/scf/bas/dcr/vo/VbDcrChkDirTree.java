package com.huateng.scf.bas.dcr.vo;

import java.io.Serializable;

public class VbDcrChkDirTree extends   VbDcrChkDir implements Serializable {

	private static final long serialVersionUID = 5120616826183765291L;
	private String treeId;
	private String treeLevel;
    private  String treeParentId;
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	public String getTreeLevel() {
		return treeLevel;
	}
	public void setTreeLevel(String treeLevel) {
		this.treeLevel = treeLevel;
	}
	public String getTreeParentId() {
		return treeParentId;
	}
	public void setTreeParentId(String treeParentId) {
		this.treeParentId = treeParentId;
	}
	
	
	
	
	
	

}