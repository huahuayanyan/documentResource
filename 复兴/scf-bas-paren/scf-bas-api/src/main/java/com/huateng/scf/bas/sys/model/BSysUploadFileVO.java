package com.huateng.scf.bas.sys.model;

import java.io.Serializable;
import java.util.Date;

public class BSysUploadFileVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(32) 必填<br>
     * ID
     */
    private String id;

    /**
     * VARCHAR(256) 必填<br>
     * 文件名称
     */
    private String fileName;

    /**
     * VARCHAR(100)<br>
     * 文件后缀
     */
    private String fileExt;

    /**
     * CHAR(2)<br>
     * 文件类型:01-主协议附件
     */
    private String fileType;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String fileSize;

    /**
     * VARCHAR(20) 必填<br>
     * 上传人
     */
    private String uploadTlrno;
    
    private String uploadTlrnoName;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 上传时间
     */
    private Date uploadTime;

    /**
     * VARCHAR(256)<br>
     * 扩展域1
     */
    private String ext1;

    /**
     * VARCHAR(512)<br>
     * 扩展域2
     */
    private String ext2;

    /**
     * VARCHAR(1024)<br>
     * 扩展域3
     */
    private String ext3;

    /**
     * VARCHAR(8)<br>
     * 文件种类：01-信息发布附件;02-系统文档;03-通知书模板文件
     */
    private String fileClass;

    /**
     * CHAR(1)<br>
     * 文件标识
     */
    private String fileFlag;

    /**
     * VARCHAR(20) 必填<br>
     * 关联业务编号
     */
    private String appno;
    
    /**
     * VARCHAR(100)<br>
     * 文件关联
     */
    private String filePro;

    /**
     * BLOB(4000) 必填<br>
     * 文件路径
     */
    private byte[] fileContent;

    private String uploadTimes;
    /**
     * VARCHAR(32) 必填<br>
     * 获得 ID
     */
    public String getId() {
        return id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * VARCHAR(256) 必填<br>
     * 获得 文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * VARCHAR(256) 必填<br>
     * 设置 文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 文件关联
     */
    public String getFileExt() {
        return fileExt;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 文件关联
     */
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    /**
     * CHAR(2)<br>
     * 获得 文件类型:01-主协议附件
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * CHAR(2)<br>
     * 设置 文件类型:01-主协议附件
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * VARCHAR(20)<br>
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * VARCHAR(20)<br>
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 上传人
     */
    public String getUploadTlrno() {
        return uploadTlrno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 上传人
     */
    public void setUploadTlrno(String uploadTlrno) {
        this.uploadTlrno = uploadTlrno == null ? null : uploadTlrno.trim();
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 获得 上传时间
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 上传时间
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * VARCHAR(256)<br>
     * 获得 扩展域1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * VARCHAR(256)<br>
     * 设置 扩展域1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * VARCHAR(512)<br>
     * 获得 扩展域2
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * VARCHAR(512)<br>
     * 设置 扩展域2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * VARCHAR(1024)<br>
     * 获得 扩展域3
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * VARCHAR(1024)<br>
     * 设置 扩展域3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    /**
     * VARCHAR(8)<br>
     * 获得 文件种类：01-信息发布附件;02-系统文档;03-通知书模板文件
     */
    public String getFileClass() {
        return fileClass;
    }

    /**
     * VARCHAR(8)<br>
     * 设置 文件种类：01-信息发布附件;02-系统文档;03-通知书模板文件
     */
    public void setFileClass(String fileClass) {
        this.fileClass = fileClass == null ? null : fileClass.trim();
    }

    /**
     * CHAR(1)<br>
     * 获得 文件标识
     */
    public String getFileFlag() {
        return fileFlag;
    }

    /**
     * CHAR(1)<br>
     * 设置 文件标识
     */
    public void setFileFlag(String fileFlag) {
        this.fileFlag = fileFlag == null ? null : fileFlag.trim();
    }

    /**
     * VARCHAR(20) 必填<br>
     * 获得 关联业务编号
     */
    public String getAppno() {
        return appno;
    }

    /**
     * VARCHAR(20) 必填<br>
     * 设置 关联业务编号
     */
    public void setAppno(String appno) {
        this.appno = appno == null ? null : appno.trim();
    }

    /**
     * BLOB(4000) 必填<br>
     * 获得 文件路径
     */
    public byte[] getFileContent() {
        return fileContent;
    }

    /**
     * BLOB(4000) 必填<br>
     * 设置 文件路径
     */
    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileExt=").append(fileExt);
        sb.append(", fileType=").append(fileType);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", uploadTlrno=").append(uploadTlrno);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", ext1=").append(ext1);
        sb.append(", ext2=").append(ext2);
        sb.append(", ext3=").append(ext3);
        sb.append(", fileClass=").append(fileClass);
        sb.append(", fileFlag=").append(fileFlag);
        sb.append(", appno=").append(appno);
        sb.append(", fileContent=").append(fileContent);
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
        BSysUploadFileVO other = (BSysUploadFileVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileExt() == null ? other.getFileExt() == null : this.getFileExt().equals(other.getFileExt()))
            && (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType()))
            && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()))
            && (this.getUploadTlrno() == null ? other.getUploadTlrno() == null : this.getUploadTlrno().equals(other.getUploadTlrno()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getExt1() == null ? other.getExt1() == null : this.getExt1().equals(other.getExt1()))
            && (this.getExt2() == null ? other.getExt2() == null : this.getExt2().equals(other.getExt2()))
            && (this.getExt3() == null ? other.getExt3() == null : this.getExt3().equals(other.getExt3()))
            && (this.getFileClass() == null ? other.getFileClass() == null : this.getFileClass().equals(other.getFileClass()))
            && (this.getFileFlag() == null ? other.getFileFlag() == null : this.getFileFlag().equals(other.getFileFlag()))
            && (this.getAppno() == null ? other.getAppno() == null : this.getAppno().equals(other.getAppno()))
            && (this.getFileContent() == null ? other.getFileContent() == null : this.getFileContent().equals(other.getFileContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileExt() == null) ? 0 : getFileExt().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getUploadTlrno() == null) ? 0 : getUploadTlrno().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getExt1() == null) ? 0 : getExt1().hashCode());
        result = prime * result + ((getExt2() == null) ? 0 : getExt2().hashCode());
        result = prime * result + ((getExt3() == null) ? 0 : getExt3().hashCode());
        result = prime * result + ((getFileClass() == null) ? 0 : getFileClass().hashCode());
        result = prime * result + ((getFileFlag() == null) ? 0 : getFileFlag().hashCode());
        result = prime * result + ((getAppno() == null) ? 0 : getAppno().hashCode());
        result = prime * result + ((getFileContent() == null) ? 0 : getFileContent().hashCode());
        return result;
    }

	/**
	 * @return the filePro
	 */
	public String getFilePro() {
		return filePro;
	}

	/**
	 * @param filePro the filePro to set
	 */
	public void setFilePro(String filePro) {
		this.filePro = filePro;
	}

	/**
	 * @return the uploadTlrnoName
	 */
	public String getUploadTlrnoName() {
		return uploadTlrnoName;
	}

	/**
	 * @param uploadTlrnoName the uploadTlrnoName to set
	 */
	public void setUploadTlrnoName(String uploadTlrnoName) {
		this.uploadTlrnoName = uploadTlrnoName;
	}

	/**
	 * @return the uploadTimes
	 */
	public String getUploadTimes() {
		return uploadTimes;
	}

	/**
	 * @param uploadTimes the uploadTimes to set
	 */
	public void setUploadTimes(String uploadTimes) {
		this.uploadTimes = uploadTimes;
	}
}