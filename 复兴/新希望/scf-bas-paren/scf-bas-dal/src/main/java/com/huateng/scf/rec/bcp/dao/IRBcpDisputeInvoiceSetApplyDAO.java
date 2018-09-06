package com.huateng.scf.rec.bcp.dao;

import java.util.List;

import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;

public interface IRBcpDisputeInvoiceSetApplyDAO {

	List<RBcpAppliBussInfo> selectAppliBussInfoBillsNo(java.lang.String appno);

	RBcpAppliBussInfo selectByPrimaryKey(java.lang.String id);

	void updateRBcpAppliBussInfoByPrimaryKey(RBcpAppliBussInfo rBcpAppliBussInfoDal);

	void addBcpAppliBussInfo(RBcpAppliBussInfo rBcpAppliBussInfoDal);

}
