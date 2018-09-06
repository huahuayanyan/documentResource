package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

public class BSysFlowUrlRel implements Serializable {

	private static final long serialVersionUID = 1289532871638823503L;

	/**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(50) 必填<br>
     * 流程模板ID
     */
    private String flowId;

    /**
     * VARCHAR(50) 必填<br>
     * 节点ID
     */
    private String nodeId;

    /**
     * VARCHAR(500)<br>
     * 页面URL
     */
    private String pgUrl;

    /**
     * VARCHAR(80)<br>
     * 业务品种
     */
    private String bussType;
    
    /**
     * VARCHAR(80)<br>
     *  任务节点属性
     */
    private String nodeButton;

    /**
     * VARCHAR(32) 必填<br>
     * 获得 主键
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(50) 必填<br>
     * 获得 流程模板ID
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 流程模板ID
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId == null ? null : flowId.trim();
    }

    /**
     * VARCHAR(50) 必填<br>
     * 获得 节点ID
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 节点ID
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    /**
     * VARCHAR(500)<br>
     * 获得 页面URL
     */
    public String getPgUrl() {
        return pgUrl;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 页面URL
     */
    public void setPgUrl(String pgUrl) {
        this.pgUrl = pgUrl == null ? null : pgUrl.trim();
    }

    /**
     * VARCHAR(80)<br>
     * 获得 业务品种
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * VARCHAR(80)<br>
     * 设置 业务品种
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }
    
    
    /**
     * VARCHAR(80)<br>
     */
    public String getNodeButton() {
        return nodeButton;
    }

    /**
     * VARCHAR(80)<br>
     */
    public void setNodeButton(String nodeButton) {
        this.nodeButton = nodeButton == null ? null : nodeButton.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", flowId=").append(flowId);
        sb.append(", nodeId=").append(nodeId);
        sb.append(", pgUrl=").append(pgUrl);
        sb.append(", bussType=").append(bussType);
        sb.append(", nodeButton=").append(nodeButton);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BSysFlowUrlRel other = (BSysFlowUrlRel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFlowId() == null ? other.getFlowId() == null : this.getFlowId().equals(other.getFlowId()))
            && (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getPgUrl() == null ? other.getPgUrl() == null : this.getPgUrl().equals(other.getPgUrl()))
            && (this.getBussType() == null ? other.getBussType() == null : this.getBussType().equals(other.getBussType()))
            && (this.getNodeButton() == null ? other.getNodeButton() == null : this.getNodeButton().equals(other.getNodeButton()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFlowId() == null) ? 0 : getFlowId().hashCode());
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getPgUrl() == null) ? 0 : getPgUrl().hashCode());
        result = prime * result + ((getBussType() == null) ? 0 : getBussType().hashCode());
        result = prime * result + ((getNodeButton() == null) ? 0 : getNodeButton().hashCode());
        return result;
    }
}