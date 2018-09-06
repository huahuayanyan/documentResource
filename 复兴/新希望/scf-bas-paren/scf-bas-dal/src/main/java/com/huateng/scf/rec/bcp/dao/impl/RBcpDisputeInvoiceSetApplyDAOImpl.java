package com.huateng.scf.rec.bcp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.huateng.base.ibatisEx.IbatisDaoAnnotation4Template;
import com.huateng.base.ibatisEx.IbatisTemplate;
import com.huateng.scf.rec.bcp.dao.IRBcpDisputeInvoiceSetApplyDAO;
import com.huateng.scf.rec.bcp.dao.model.RBcpAppliBussInfo;

@Repository("IRBcpDisputeInvoiceSetApplyDAO")
public class RBcpDisputeInvoiceSetApplyDAOImpl extends IbatisDaoAnnotation4Template implements IRBcpDisputeInvoiceSetApplyDAO {
    
	@Resource(name="sqlMapClientTemplate")
    private IbatisTemplate template;
	
	@Override
	public IbatisTemplate getSqlMapClientTemplate() {
		return this.template;
	}

	@Override
	public List<RBcpAppliBussInfo> selectAppliBussInfoBillsNo(String appno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RBcpAppliBussInfo selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRBcpAppliBussInfoByPrimaryKey(RBcpAppliBussInfo rBcpAppliBussInfoDal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBcpAppliBussInfo(RBcpAppliBussInfo rBcpAppliBussInfoDal) {
		// TODO Auto-generated method stub
		
	}

}
