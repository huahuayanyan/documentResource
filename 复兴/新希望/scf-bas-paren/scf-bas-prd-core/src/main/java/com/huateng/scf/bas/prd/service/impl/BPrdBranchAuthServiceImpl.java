package com.huateng.scf.bas.prd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.prd.dao.IBPrdBranchAuthDAO;
import com.huateng.scf.bas.prd.dao.model.BPrdBranchAuthExample;
import com.huateng.scf.bas.prd.model.BPrdBranchAuth;
import com.huateng.scf.bas.prd.service.IBPrdBranchAuthService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BPrdBranchAuthServiceImpl")
public class BPrdBranchAuthServiceImpl implements IBPrdBranchAuthService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBPrdBranchAuthDAO")
	IBPrdBranchAuthDAO bprdbranchauthdao;
	
	@Override
	public List<BPrdBranchAuth> findBPrdBranchAuthByProductIdAndBrcode(String productId, String brcode) {
		log.debug("检验开始：productId="+productId+",brcode="+brcode);
		List<BPrdBranchAuth> list = new ArrayList<BPrdBranchAuth>();
		BPrdBranchAuthExample example = new BPrdBranchAuthExample();
		BPrdBranchAuthExample.Criteria cri = example.createCriteria();
		cri.andSupplyChainPdIdEqualTo(productId);
		cri.andBrcodeEqualTo(brcode);
		List<com.huateng.scf.bas.prd.dao.model.BPrdBranchAuth> listdal = bprdbranchauthdao.selectByExample(example);
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.prd.dao.model.BPrdBranchAuth auth:listdal)
			{
				BPrdBranchAuth bPrdBranchAuth = new BPrdBranchAuth();
				try
				{
					BeanUtils.copyProperties(auth, bPrdBranchAuth);
				}
				catch(BeansException e)
				{
					throw new ScubeBizException("转换异常");
				}
				list.add(bPrdBranchAuth);
			}
		}
		return list;
	}

}
