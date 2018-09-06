/**
 * 
 */
package com.huateng.scf.bas.common.page;

/**
 * <p>供应链分页信息</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月17日下午1:50:57	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月17日下午1:50:57              新增
 *
 * </pre>
 */
public class ScfPage {
	private int pageSize;//current page records count
	private int pageNo;//current page number
	
	public ScfPage() {
		
	}
	public ScfPage(int pageSize, int pageNo) {
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
}
