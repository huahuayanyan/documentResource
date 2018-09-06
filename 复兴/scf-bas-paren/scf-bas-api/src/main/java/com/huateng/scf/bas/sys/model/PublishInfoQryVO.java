/**
 * 
 */
package com.huateng.scf.bas.sys.model;

import com.huateng.scf.bas.common.model.CommonQryVO;

/**
 * <p>发布信息查询VO</p>
 *
 * @author 	shangxiujuan
 * @date 2017年7月15日上午11:35:21
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年7月15日上午11:35:21              新增
 *
 * </pre>
 */
public class PublishInfoQryVO extends CommonQryVO {

	private static final long serialVersionUID = -411201910857664590L;
	private String id;// 信息ID
	private String title;// 信息标题
	private String content;// 信息内容
	private String authorTlrno;// 信息发布人
	private String publishDate;// 发布日期
	private String infoDeleteDate;// 删除日期
	private String state;// 状态
	private String protocolText;// 关联协议
	private String filePro;
	private String fileClass;
	
	public PublishInfoQryVO(){}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthorTlrno() {
		return authorTlrno;
	}

	public void setAuthorTlrno(String authorTlrno) {
		this.authorTlrno = authorTlrno;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getInfoDeleteDate() {
		return infoDeleteDate;
	}

	public void setInfoDeleteDate(String infoDeleteDate) {
		this.infoDeleteDate = infoDeleteDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProtocolText() {
		return protocolText;
	}

	public void setProtocolText(String protocolText) {
		this.protocolText = protocolText;
	}

	public String getFilePro() {
		return filePro;
	}

	public void setFilePro(String filePro) {
		this.filePro = filePro;
	}

	public String getFileClass() {
		return fileClass;
	}

	public void setFileClass(String fileClass) {
		this.fileClass = fileClass;
	}
}
