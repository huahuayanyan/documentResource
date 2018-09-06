package com.huateng.scf.rec.qry.dao;

import java.util.List;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.rec.bcp.dao.model.DebtBillsInfoVO;
import com.huateng.scf.rec.qry.dao.model.DebtCommonQryVO;


public interface IRBcpPoolDebtDetalInfoQryDao {

	Page selectInvoiceCourseInfo(DebtCommonQryVO commonQueryVO, int pageSize, int pageNo);

	List<DebtBillsInfoVO> getDebtInfoByPerson(DebtCommonQryVO commonQueryVO, int pageSize, int pageNo);
	
	Integer getDebtCountByPerson(DebtCommonQryVO commonQueryVO);

	int selectInvoiceCourseCount(DebtCommonQryVO commonQueryVO);



}
