package com.huateng.scf.bas.crr.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.bas.common.util.StringUtil;
import com.huateng.scf.bas.crr.dao.IBCrrLnConRelaDAO;
import com.huateng.scf.bas.crr.dao.model.BCrrLnConRelaExample;
import com.huateng.scf.bas.crr.model.BCrrLnConRela;
import com.huateng.scf.bas.crr.service.IBCrrLnConRelaService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrLnConRela接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:49:50
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:49:50	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrLnConRelaServiceImpl")
public class BCrrLnConRelaServiceImpl implements IBCrrLnConRelaService {

	@Resource(name = "IBCrrLnConRelaDAO")
	IBCrrLnConRelaDAO bcrrlnconreladao;
	
	@Override
	@Transactional
	public void add(BCrrLnConRela bCrrLnConRela) {
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLnConRela bCrrLnConReladal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrLnConRela();
		try
		{
			BeanUtils.copyProperties(bCrrLnConRela, bCrrLnConReladal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrrlnconreladao.insertSelective(bCrrLnConReladal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
	}
	
	@Override
	public List<BCrrLnConRela> findBCrrLnConRelaByExample(BCrrLnConRela bCrrLnConRela)
	{
		BCrrLnConRelaExample example = new BCrrLnConRelaExample();
		BCrrLnConRelaExample.Criteria cri = example.createCriteria();
		if(bCrrLnConRela!=null)
		{
			if(!StringUtil.isEmpty(bCrrLnConRela.getIsRelate()))
			{
				cri.andIsRelateEqualTo(bCrrLnConRela.getIsRelate());
			}
			if(!StringUtil.isEmpty(bCrrLnConRela.getRltNo()))
			{
				cri.andRltNoEqualTo(bCrrLnConRela.getRltNo());
			}
		}
		List<com.huateng.scf.bas.crr.dao.model.BCrrLnConRela> listdal = bcrrlnconreladao.selectByExample(example);
		List<BCrrLnConRela> list = new ArrayList<BCrrLnConRela>();
		if(listdal.size()>0)
		{
			for(com.huateng.scf.bas.crr.dao.model.BCrrLnConRela conRela:listdal)
			{
				BCrrLnConRela lnConRela = new BCrrLnConRela();
				BeanUtils.copyProperties(conRela, lnConRela);
				list.add(lnConRela);
			}
		}
		return list;
	}
}
