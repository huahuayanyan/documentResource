package com.huateng.scf.bas.lan.dao;

import java.util.List;
import java.util.Map;

import com.huateng.base.common.beans.Page;

public interface IMtgLoanApplyDAO {
	
	public static final String BeanId ="MtgLoanApplyDAOImpl";
	

	List<com.huateng.scf.bas.pbc.dao.model.BPbcAppliBaseInfo> findMtgLoanApplyByProductId(Map<String, Object> map, Page page);

}
