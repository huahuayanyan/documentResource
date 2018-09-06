package com.huateng.scf.bas.crr.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huateng.base.common.beans.Page;
import com.huateng.scf.bas.crr.dao.IBCrrGntyRelaDAO;
import com.huateng.scf.bas.crr.model.BCrrGntyRela;
import com.huateng.scf.bas.crr.service.IBCrrGntyRelaService;
import com.huateng.scf.bas.crr.util.BCrrModelCommonUtil;
import com.huateng.scf.bas.sys.service.IBSysSerialNoService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrGntyRela接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:33:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:33:01	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrGntyRelaServiceImpl")
public class BCrrGntyRelaServiceImpl implements IBCrrGntyRelaService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrGntyRelaDAO")
	IBCrrGntyRelaDAO bcrrgntyreladao;
	
	@Resource(name = "BSysSerialNoServiceImpl")	
	IBSysSerialNoService  ibSysSerialNoService;
	
	@Override
	@Transactional
	public BCrrGntyRela add(BCrrGntyRela bCrrGntyRela) {
		log.info("担保关联信息新增");
		com.huateng.scf.bas.crr.dao.model.BCrrGntyRela bCrrGntyReladal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrGntyRela();
		try
		{
			BeanUtils.copyProperties(bCrrGntyRela, bCrrGntyReladal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrrgntyreladao.insertSelective(bCrrGntyReladal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
		return bCrrGntyRela;
	}
	
	@Override
	public BCrrGntyRela cachadd(BCrrGntyRela bCrrGntyRela) {
		log.info("担保关联信息新增");
		BCrrModelCommonUtil.setAddField(bCrrGntyRela);
		String gntyId =ibSysSerialNoService.genSerialNo("GNTY_INFO_NO");
		bCrrGntyRela.setRltNo(gntyId);
		return bCrrGntyRela;
	}
	
	@Override
	public Page findBCrrGntyRelaByPage(int pageNo, int pageSize, BCrrGntyRela bCrrGntyRela) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BCrrGntyRela findBCrrGntyRelaByGntyId(String rltNo) {
		log.info("获取担保关联信息");
		com.huateng.scf.bas.crr.dao.model.BCrrGntyRela bCrrGntyReladal = 
				bcrrgntyreladao.selectByRltNo(rltNo);
		// VO转PO 展现层对象转换DAO层对象
		BCrrGntyRela bCrrGntyRela = new BCrrGntyRela();
		try
		{
			BeanUtils.copyProperties(bCrrGntyReladal, bCrrGntyRela);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		return bCrrGntyRela;
	}
}
