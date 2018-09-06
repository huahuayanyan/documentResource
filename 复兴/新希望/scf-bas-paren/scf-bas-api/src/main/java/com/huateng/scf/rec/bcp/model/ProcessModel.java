/**
 * 
 */
package com.huateng.scf.rec.bcp.model;

/**
 * <p>
 * </p>
 *
 * @author lihao
 * @date 2016年12月28日上午9:52:23
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date	 	 Content
 * lihao		2016年12月28日上午9:52:23	      新增
 *
 *            </pre>
 */
public class ProcessModel {

	private String modelId;

	private String ProcessName;

	private String NodeId;

	private String startedUserId;

	private String bizId;

	private String[] bizData;

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getProcessName() {
		return ProcessName;
	}

	public void setProcessName(String processName) {
		ProcessName = processName;
	}

	public String getNodeId() {
		return NodeId;
	}

	public void setNodeId(String nodeId) {
		NodeId = nodeId;
	}

	public String getStartedUserId() {
		return startedUserId;
	}

	public void setStartedUserId(String startedUserId) {
		this.startedUserId = startedUserId;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String[] getBizData() {
		return bizData;
	}

	public void setBizData(String[] bizData) {
		this.bizData = bizData;
	}

	@Override
	public String toString() {
		return "ProcessModel [modelId=" + modelId + ", ProcessName=" + ProcessName + ", NodeId=" + NodeId
				+ ", startedUserId=" + startedUserId + ", bizId=" + bizId + ", bizData=" + bizData + "]";
	}

}
