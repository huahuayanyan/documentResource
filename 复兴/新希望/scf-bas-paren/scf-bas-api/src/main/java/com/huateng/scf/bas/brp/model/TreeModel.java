package com.huateng.scf.bas.brp.model;

import java.io.Serializable;

public class TreeModel implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 * "treeId": "10001", "treeName": "二级菜单A", "treeLevel":"2",
	 * "treeParentId":"1000"
	 */
	private String treeId;
	private String treeName;
	private String treeLevel;
	private String treeParentId;

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
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

	@Override
	public String toString() {
		return "TreeModel [treeId=" + treeId + ", treeName=" + treeName + ", treeLevel=" + treeLevel + ", treeParentId="
				+ treeParentId + "]";
	}
}