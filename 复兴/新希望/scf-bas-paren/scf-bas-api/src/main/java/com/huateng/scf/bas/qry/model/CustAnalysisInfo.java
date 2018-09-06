
package com.huateng.scf.bas.qry.model;

/**
 * <p></p>
 *
 * @author 	shangxiujuan
 * @date 2017年6月7日上午10:09:40
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2017年6月7日上午10:09:40              新增
 *
 * </pre>
 */
public class CustAnalysisInfo extends OCrmInfoAnalysis{


	private static final long serialVersionUID = 436648834975559577L;
	private String cname; //客户名称
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

}
