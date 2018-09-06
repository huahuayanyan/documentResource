package com.huateng.scf.bas.brp.service.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.brp.dao.IBBrpPrdFactoringDAO;
import com.huateng.scf.bas.brp.model.BBrpPrdFactoring;
import com.huateng.scf.bas.brp.service.IBBrpPrdFactoringService;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BBrpPrdFactoringServiceImpl")
public class BBrpPrdFactoringServiceImpl implements IBBrpPrdFactoringService {
	
	@Autowired
	IBBrpPrdFactoringDAO bBrpPrdFactoringDAO;

	@Override
	public String add(BBrpPrdFactoring bBrpPrdFactoring) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String productId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BBrpPrdFactoring bBrpPrdFactoring) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BBrpPrdFactoring findBBrpPrdFactoringByKey(String productId) {
		com.huateng.scf.bas.brp.dao.model.BBrpPrdFactoring bBrpPrdFactoringDal = bBrpPrdFactoringDAO.selectByPrimaryKey(productId);
		BBrpPrdFactoring bBrpPrdFactoring = new BBrpPrdFactoring();
		BeanUtils.copyProperties(bBrpPrdFactoringDal, bBrpPrdFactoring);
		return bBrpPrdFactoring;
	}

	@Override
	public Page findBBrpIndustryTypesTree(int pageNo, int pageSize, BBrpPrdFactoring bBrpPrdFactoring) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page findBBrpIndustryTypesByPage(int pageNo, int pageSize, BBrpPrdFactoring bBrpPrdFactoring) {
		// TODO Auto-generated method stub
		return null;
	}

}
