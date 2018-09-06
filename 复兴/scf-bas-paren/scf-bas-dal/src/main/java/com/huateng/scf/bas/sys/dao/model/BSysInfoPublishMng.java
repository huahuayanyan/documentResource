package com.huateng.scf.bas.sys.dao.model;

import java.io.Serializable;

public class BSysInfoPublishMng implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(100)<br>
     * 标题
     */
    private String title;

    /**
     * VARCHAR(4000)<br>
     * 内容
     */
    private String content;

    /**
     * VARCHAR(20)<br>
     * 发布人
     */
    private String authorTlrno;

    /**
     * CHAR(8)<br>
     * 发布日期
     */
    private String publishDate;

    /**
     * CHAR(8)<br>
     * 删除日期
     */
    private String infoDeleteDate;

    /**
     * CHAR(1)<br>
     * 状态
     */
    private String state;

    /**
     * VARCHAR(20)<br>
     * 删除人
     */
    private String infoDelTlrno;

    /**
     * VARCHAR(2048)<br>
     * 协议文本
     */
    private String protocolText;

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
     * VARCHAR(100)<br>
     * 获得 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 发布人
     */
    public String getAuthorTlrno() {
        return authorTlrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 发布人
     */
    public void setAuthorTlrno(String authorTlrno) {
        this.authorTlrno = authorTlrno == null ? null : authorTlrno.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 发布日期
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 发布日期
     */
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate == null ? null : publishDate.trim();
    }

    /**
     * CHAR(8)<br>
     * 获得 删除日期
     */
    public String getInfoDeleteDate() {
        return infoDeleteDate;
    }

    /**
     * CHAR(8)<br>
     * 设置 删除日期
     */
    public void setInfoDeleteDate(String infoDeleteDate) {
        this.infoDeleteDate = infoDeleteDate == null ? null : infoDeleteDate.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 状态
     */
    public String getState() {
        return state;
    }

    /**
     * CHAR(1)<br>
     * 设置 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 删除人
     */
    public String getInfoDelTlrno() {
        return infoDelTlrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 删除人
     */
    public void setInfoDelTlrno(String infoDelTlrno) {
        this.infoDelTlrno = infoDelTlrno == null ? null : infoDelTlrno.trim();
    }

    /**
     * VARCHAR(2048)<br>
     * 获得 协议文本
     */
    public String getProtocolText() {
        return protocolText;
    }

    /**
     * VARCHAR(2048)<br>
     * 设置 协议文本
     */
    public void setProtocolText(String protocolText) {
        this.protocolText = protocolText == null ? null : protocolText.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", authorTlrno=").append(authorTlrno);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", infoDeleteDate=").append(infoDeleteDate);
        sb.append(", state=").append(state);
        sb.append(", infoDelTlrno=").append(infoDelTlrno);
        sb.append(", protocolText=").append(protocolText);
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
        BSysInfoPublishMng other = (BSysInfoPublishMng) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getAuthorTlrno() == null ? other.getAuthorTlrno() == null : this.getAuthorTlrno().equals(other.getAuthorTlrno()))
            && (this.getPublishDate() == null ? other.getPublishDate() == null : this.getPublishDate().equals(other.getPublishDate()))
            && (this.getInfoDeleteDate() == null ? other.getInfoDeleteDate() == null : this.getInfoDeleteDate().equals(other.getInfoDeleteDate()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getInfoDelTlrno() == null ? other.getInfoDelTlrno() == null : this.getInfoDelTlrno().equals(other.getInfoDelTlrno()))
            && (this.getProtocolText() == null ? other.getProtocolText() == null : this.getProtocolText().equals(other.getProtocolText()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getAuthorTlrno() == null) ? 0 : getAuthorTlrno().hashCode());
        result = prime * result + ((getPublishDate() == null) ? 0 : getPublishDate().hashCode());
        result = prime * result + ((getInfoDeleteDate() == null) ? 0 : getInfoDeleteDate().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getInfoDelTlrno() == null) ? 0 : getInfoDelTlrno().hashCode());
        result = prime * result + ((getProtocolText() == null) ? 0 : getProtocolText().hashCode());
        return result;
    }
}