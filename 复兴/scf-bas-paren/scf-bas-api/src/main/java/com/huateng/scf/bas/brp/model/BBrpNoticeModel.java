package com.huateng.scf.bas.brp.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class BBrpNoticeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * VARCHAR(32) 必填<br>
	 * 主键UUID
	 */
	private String id;

	/**
	 * CHAR(4)<br>
	 * 通知书类型
	 */
	private String noticeType;

	/**
	 * VARCHAR(200)<br>
	 * 路径
	 */
	private String url;

	/**
	 * VARCHAR(100)<br>
	 * 模版名称
	 */
	private String fileName;
	/**
	 * VARCHAR(50)<br>
	 * 模版类型
	 */
	private String fileExt;
	/**
	 * date<br>
	 * 上传时间
	 */
	private Date uploadTime;

	/**
	 * string<br>
	 * 上传时间
	 */
	private String uploadDate;
	
	/**
	 * VARCHAR(20)<br>
	 * 操作员
	 */
	private String uploadTlrno;
	/**
	 * Blob<br>
	 * 上传数据
	 */
	private byte[] fileData;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUploadTlrno() {
		return uploadTlrno;
	}
	public void setUploadTlrno(String uploadTlrno) {
		this.uploadTlrno = uploadTlrno;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}


	
}
