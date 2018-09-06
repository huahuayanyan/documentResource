package com.huateng.scf.bas.cnt.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.huateng.scf.bas.cnt.dao.IBCntMprotCmPriceHisDAO;
import com.huateng.scf.bas.cnt.model.BCntMprotCmPriceHis;
import com.huateng.scf.bas.cnt.service.IBCntMprotCmPriceHisService;
import com.huateng.scf.bas.common.util.UUIDGeneratorUtil;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;

@ScubeService
@Service("BCntMprotCmPriceHisServiceImpl")
public class BCntMprotCmPriceHisServiceImpl implements IBCntMprotCmPriceHisService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCntMprotCmPriceHisDAO")
	IBCntMprotCmPriceHisDAO bcntmprotcmpricehisdao;
	
	@Override
	public void add(BCntMprotCmPriceHis mportcmprice) {
		String id = UUIDGeneratorUtil.generate();
		log.debug("开始保存id:"+id);
		mportcmprice.setId(id);
		com.huateng.scf.bas.cnt.dao.model.BCntMprotCmPriceHis mportcmpricedal = 
				new com.huateng.scf.bas.cnt.dao.model.BCntMprotCmPriceHis();
		try
		{
			BeanUtils.copyProperties(mportcmprice, mportcmpricedal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcntmprotcmpricehisdao.insertSelective(mportcmpricedal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("新增异常");
		}
	}

}
