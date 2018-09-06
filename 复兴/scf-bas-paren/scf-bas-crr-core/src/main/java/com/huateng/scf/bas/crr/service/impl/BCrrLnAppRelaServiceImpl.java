package com.huateng.scf.bas.crr.service.impl;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huateng.scf.bas.crr.dao.IBCrrLnAppRelaDAO;
import com.huateng.scf.bas.crr.model.BCrrLnAppRela;
import com.huateng.scf.bas.crr.service.IBCrrLnAppRelaService;
import com.huateng.scube.exception.ScubeBizException;
import com.huateng.scube.server.annotation.ScubeService;
/**
 * 
 * <p>BCrrLnAppRela接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2016年11月14日下午8:25:46
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2016年11月14日下午8:25:46	     新增
 *
 * </pre>
 */
@ScubeService
@Service("BCrrLnAppRelaServiceImpl")
public class BCrrLnAppRelaServiceImpl implements IBCrrLnAppRelaService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "IBCrrLnAppRelaDAO")
	IBCrrLnAppRelaDAO bcrrlnappreladao;
	
	@Override
	@Transactional
	public void add(BCrrLnAppRela bCrrLnAppRela) {
		log.info("业务关联信息维护");
		// VO转PO 展现层对象转换DAO层对象
		com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela bCrrLnAppReladal = 
				new com.huateng.scf.bas.crr.dao.model.BCrrLnAppRela();
		try
		{
			BeanUtils.copyProperties(bCrrLnAppRela, bCrrLnAppReladal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("转换异常");
		}
		try
		{
			bcrrlnappreladao.insertSelective(bCrrLnAppReladal);
		}
		catch(BeansException e)
		{
			throw new ScubeBizException("插入异常");
		}
	}
}
