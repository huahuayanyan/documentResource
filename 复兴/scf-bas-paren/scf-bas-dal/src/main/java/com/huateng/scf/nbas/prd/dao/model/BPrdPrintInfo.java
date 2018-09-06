package com.huateng.scf.nbas.prd.dao.model;

import java.io.Serializable;
import java.util.Date;

public class BPrdPrintInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * 主键
     */
    private String id;

    /**
     * VARCHAR(10) 必填<br>
     * 产品ID
     */
    private String productId;

    /**
     * VARCHAR(10) 必填<br>
     * 调用阶段
     */
    private String invokPhase;

    /**
     * VARCHAR(200)<br>
     * 模板URL
     */
    private String url;

    /**
     * VARCHAR(100)<br>
     * 文件名
     */
    private String fileName;

    /**
     * VARCHAR(50)<br>
     * 文件后缀
     */
    private String fileExt;

    /**
     * TIMESTAMP(11,6)<br>
     * 上传时间
     */
    private Date uploadTime;

    /**
     * VARCHAR(20)<br>
     * 上传人
     */
    private String uploadTlrno;

    /**
     * BLOB(4000)<br>
     * 文件内容
     */
    private byte[] fileData;

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
     * VARCHAR(10) 必填<br>
     * 获得 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * VARCHAR(10) 必填<br>
     * 获得 调用阶段
     */
    public String getInvokPhase() {
        return invokPhase;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 调用阶段
     */
    public void setInvokPhase(String invokPhase) {
        this.invokPhase = invokPhase == null ? null : invokPhase.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 模板URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 模板URL
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 文件后缀
     */
    public String getFileExt() {
        return fileExt;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 文件后缀
     */
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 上传人
     */
    public String getUploadTlrno() {
        return uploadTlrno;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 上传人
     */
    public void setUploadTlrno(String uploadTlrno) {
        this.uploadTlrno = uploadTlrno == null ? null : uploadTlrno.trim();
    }

    /**
     * BLOB(4000)<br>
     * 获得 文件内容
     */
    public byte[] getFileData() {
        return fileData;
    }

    /**
     * BLOB(4000)<br>
     * 设置 文件内容
     */
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", invokPhase=").append(invokPhase);
        sb.append(", url=").append(url);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileExt=").append(fileExt);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", uploadTlrno=").append(uploadTlrno);
        sb.append(", fileData=").append(fileData);
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
        BPrdPrintInfo other = (BPrdPrintInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getInvokPhase() == null ? other.getInvokPhase() == null : this.getInvokPhase().equals(other.getInvokPhase()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileExt() == null ? other.getFileExt() == null : this.getFileExt().equals(other.getFileExt()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getUploadTlrno() == null ? other.getUploadTlrno() == null : this.getUploadTlrno().equals(other.getUploadTlrno()))
            && (this.getFileData() == null ? other.getFileData() == null : this.getFileData().equals(other.getFileData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getInvokPhase() == null) ? 0 : getInvokPhase().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileExt() == null) ? 0 : getFileExt().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getUploadTlrno() == null) ? 0 : getUploadTlrno().hashCode());
        result = prime * result + ((getFileData() == null) ? 0 : getFileData().hashCode());
        return result;
    }
}