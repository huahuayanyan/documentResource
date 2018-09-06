/**
 * 
 */
package com.huateng.scf.bas.common.model;

import java.io.Serializable;
import java.util.List;

import com.huateng.authority.entity.BctlVO;

/**
 * <p>通用查询条件VO</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月22日下午4:35:42	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月22日下午4:35:42              新增
 *
 * </pre>
 */
public class CommonQryVO implements Serializable{
	private static final long serialVersionUID = 1941950478048516853L;
	private Integer pageIndex = 1;// 页索引
	private Integer pageSize = 10;// 页大小
	private String flag;// 通用标识
	private String brcode;// 机构号
	private String custcd; // 客户号
	private String cname; // 客户名称
	private String appno; // 申请编号
	private String protocolNo; // 协议编号
	private String protocolCode;// 协议代码
	private String mastContno; // 主合同编号
	private String mastContCode; // 主合同编号
	private String slaveContno; // 从合同编号
	private String slaveContCode; // 从合同编号
	private String bussContno; // 业务合同号
	private String AppliType; // 业务合同号
	private Integer begin; // ibatis分页查询的第一条记录索引
	private Integer end;   // ibatis分页查询的最后一条记录索引
	List<BctlVO> listBctl;
	
	
	
	
	public CommonQryVO() {
	
	}
	
	



	public CommonQryVO(Integer pageIndex, Integer pageSize, String flag, String brcode, String custcd, String cname,
			String appno, String protocolNo, String protocolCode, String mastContno, String mastContCode,
			String slaveContno, String slaveContCode, String bussContno, String appliType, Integer begin, Integer end) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.flag = flag;
		this.brcode = brcode;
		this.custcd = custcd;
		this.cname = cname;
		this.appno = appno;
		this.protocolNo = protocolNo;
		this.protocolCode = protocolCode;
		this.mastContno = mastContno;
		this.mastContCode = mastContCode;
		this.slaveContno = slaveContno;
		this.slaveContCode = slaveContCode;
		this.bussContno = bussContno;
		AppliType = appliType;
		this.begin = begin;
		this.end = end;
	}





	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}



	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}



	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}



	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}



	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}



	/**
	 * @return the brcode
	 */
	public String getBrcode() {
		return brcode;
	}



	/**
	 * @param brcode the brcode to set
	 */
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}



	/**
	 * @return the custcd
	 */
	public String getCustcd() {
		return custcd;
	}



	/**
	 * @param custcd the custcd to set
	 */
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}



	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}



	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}



	/**
	 * @return the appno
	 */
	public String getAppno() {
		return appno;
	}



	/**
	 * @param appno the appno to set
	 */
	public void setAppno(String appno) {
		this.appno = appno;
	}



	/**
	 * @return the protocolNo
	 */
	public String getProtocolNo() {
		return protocolNo;
	}



	/**
	 * @param protocolNo the protocolNo to set
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}



	/**
	 * @return the protocolCode
	 */
	public String getProtocolCode() {
		return protocolCode;
	}



	/**
	 * @param protocolCode the protocolCode to set
	 */
	public void setProtocolCode(String protocolCode) {
		this.protocolCode = protocolCode;
	}



	/**
	 * @return the mastContno
	 */
	public String getMastContno() {
		return mastContno;
	}



	/**
	 * @param mastContno the mastContno to set
	 */
	public void setMastContno(String mastContno) {
		this.mastContno = mastContno;
	}



	/**
	 * @return the mastContCode
	 */
	public String getMastContCode() {
		return mastContCode;
	}



	/**
	 * @param mastContCode the mastContCode to set
	 */
	public void setMastContCode(String mastContCode) {
		this.mastContCode = mastContCode;
	}



	/**
	 * @return the slaveContno
	 */
	public String getSlaveContno() {
		return slaveContno;
	}



	/**
	 * @param slaveContno the slaveContno to set
	 */
	public void setSlaveContno(String slaveContno) {
		this.slaveContno = slaveContno;
	}



	/**
	 * @return the slaveContCode
	 */
	public String getSlaveContCode() {
		return slaveContCode;
	}



	/**
	 * @param slaveContCode the slaveContCode to set
	 */
	public void setSlaveContCode(String slaveContCode) {
		this.slaveContCode = slaveContCode;
	}



	/**
	 * @return the bussContno
	 */
	public String getBussContno() {
		return bussContno;
	}



	/**
	 * @param bussContno the bussContno to set
	 */
	public void setBussContno(String bussContno) {
		this.bussContno = bussContno;
	}



	/**
	 * @return the appliType
	 */
	public String getAppliType() {
		return AppliType;
	}



	/**
	 * @param appliType the appliType to set
	 */
	public void setAppliType(String appliType) {
		AppliType = appliType;
	}



	/**
	 * @return the begin
	 */
	public Integer getBegin() {
		return begin;
	}



	/**
	 * @param begin the begin to set
	 */
	public void setBegin(Integer begin) {
		this.begin = begin;
	}



	/**
	 * @return the end
	 */
	public Integer getEnd() {
		return end;
	}



	/**
	 * @param end the end to set
	 */
	public void setEnd(Integer end) {
		this.end = end;
	}





	/**
	 * @return the listBctl
	 */
	public List<BctlVO> getListBctl() {
		return listBctl;
	}





	/**
	 * @param listBctl the listBctl to set
	 */
	public void setListBctl(List<BctlVO> listBctl) {
		this.listBctl = listBctl;
	}
	
	
	
	
}
