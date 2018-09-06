package com.huateng.scf.rec.bcp.dao.ext;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;



public interface ExtIRBcpDebtBaseInfoDAO {
	public    List  findCancelRBcpDebtBaseInfoByPage(Map debt,Page page);

	/**
	 * 核销申请发票添加查询
	 * @param rBcpDebtBaseInfo
	 * @param page
	 */
	public List getInvoiceChargeOffAddQry(Map rBcpDebtBaseInfo, Page page);
	
	
}