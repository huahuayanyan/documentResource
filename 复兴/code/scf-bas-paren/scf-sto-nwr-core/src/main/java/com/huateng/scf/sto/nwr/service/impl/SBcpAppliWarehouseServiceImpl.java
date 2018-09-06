package com.huateng.scf.sto.nwr.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.scf.sto.nwr.dao.ISBcpAppliWarehouseDAO;
import com.huateng.scf.sto.nwr.dao.model.SBcpAppliWarehouse;
import com.huateng.scf.sto.nwr.model.SBcpAppliWarehouseVO;
import com.huateng.scf.sto.nwr.service.ISBcpAppliWarehouseService;
import com.huateng.scube.server.annotation.ScubeService;

/**
 * 
 * <p>普通仓单解押申请	接口实现类</p>
 *
 * @author 	mengjiajia
 * @date 	2017年5月3日上午11:20:12
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * mengjiajia		2017年5月3日上午11:20:12	     新增
 *
 * </pre>
 */
@ScubeService
@Service("SBcpAppliWarehouseServiceImpl")
public class SBcpAppliWarehouseServiceImpl implements ISBcpAppliWarehouseService
{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name = "ISBcpAppliWarehouseDAO")
	ISBcpAppliWarehouseDAO sbcpappliwarehousedao;
	
	@Override
	@Transactional
	public void saveOrUpdate(SBcpAppliWarehouseVO sBcpAppliWarehouseVO)
	{
		log.debug("保存仓单解押申请信息==================================");
		SBcpAppliWarehouse appliWarehouse = sbcpappliwarehousedao.selectByPrimaryKey(sBcpAppliWarehouseVO.getAppno());
		if(appliWarehouse==null)
		{
			appliWarehouse = new SBcpAppliWarehouse();
			BeanUtils.copyProperties(sBcpAppliWarehouseVO, appliWarehouse);
			sbcpappliwarehousedao.insertSelective(appliWarehouse);
		}
		else
		{
			BeanUtils.copyProperties(sBcpAppliWarehouseVO, appliWarehouse);
			sbcpappliwarehousedao.updateByPrimaryKeySelective(appliWarehouse);
		}
	}
}
